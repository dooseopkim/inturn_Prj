package com.inturn.biz.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.inturn.biz.board.service.FileService;
import com.inturn.biz.board.service.FreeBoardService;
import com.inturn.biz.board.vo.FilesVO;
import com.inturn.biz.board.vo.FreeBoardVO;
import com.inturn.biz.users.vo.UserVO;
import com.inturn.biz.web.common.SHA256;

/**
 * 
 * @author 박현호
 * @version 1.0
 * @since 2018.05.14
 * @see 게시판 관련 메소드 Controller
 */
@Controller
public class FreeBoardController {
	@Resource(name = "FreeBoardService")
	FreeBoardService fb_service;
	@Resource(name = "FileService")
	FileService file_service;

	/**
	 * @return 자유게시판 페이지 이동 설정
	 */
	@RequestMapping(value = "/freeBoard.do", method = RequestMethod.GET)
	public String freeBoardDo(int page_num, HttpServletRequest request) {
		HashMap<String, Object> boardInfo = fb_service.boardList(page_num);
		List<FreeBoardVO> list = (List<FreeBoardVO>) boardInfo.get("list");
		int page = (int) boardInfo.get("count_page");
		request.setAttribute("list", list);
		request.setAttribute("page", page);
		request.setAttribute("thisPage", page_num);
		return "index.jsp?content=board/freeBoard";
	}

	/**
	 * @return 게시판 입력 페이지 이동 설정
	 */
	@RequestMapping(value = "/insertFreeBoard.do", method = RequestMethod.GET)
	public String insertBoard() {
		return "index.jsp?content=board/insertFreeBoard";
	}

	@RequestMapping(value = "/insertFreeBoard.do", method = RequestMethod.POST)
	public String insertBoard(String title, String id, String editor) {
		java.util.Date udate = new java.util.Date();
		Date regDate = new Date(udate.getTime());
		fb_service.insertFreeBoard(new FreeBoardVO(title, editor, regDate, 0, id));
		return "redirect:freeBoard.do?page_num=1";
	}

	// 서버에 파일저장
	public int saveFile(InputStream is, OutputStream os, HttpServletRequest request, String filePath, String fileName) {
		int fileSize = 0;
		try {
			File file = new File(filePath);
			if (!file.exists()) {
				file.mkdirs();
			}
			is = request.getInputStream();
			os = new FileOutputStream(filePath + fileName);
			int numRead;
			byte b[] = new byte[Integer.parseInt(request.getHeader("file-size"))];
			while ((numRead = is.read(b, 0, b.length)) != -1) {
				fileSize += numRead;
				os.write(b, 0, numRead);
			}
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null)
					is.close();
				if (os != null)
					os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return fileSize;
	}

	// Error났을 시, 이미지 url
	public void fileError(String realFilePath, String sFileInfo, String filename) {
		File deleteFile = new File(realFilePath);
		deleteFile.delete();
		// 정보 출력
		sFileInfo += "&bNewLine=true";
		// img 태그의 title 속성을 원본파일명으로 적용시켜주기 위함
		sFileInfo += "&sFileName=" + filename;
		sFileInfo += "&sFileURL=" + "/resources/editor/multiupload/" + "error.jpg";
	}

	@RequestMapping("/multiFileUploader.do")
	public void file_uploader(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		InputStream is = null;
		OutputStream os = null;
		try {
			// 파일정보
			String sFileInfo = "";
			// 파일명을 받는다 - 일반 원본파일명
			String fileName = request.getHeader("file-name");
			System.out.println(fileName);
			String temp[] = fileName.split("%23%23%23");
			fileName = temp[0];
			String hashValue = temp[1];
			System.out.println("javascript hash : " + hashValue);

			// 파일 기본경로
			String dftFilePath = request.getSession().getServletContext().getRealPath("/");
			// 파일 기본경로 _ 상세경로
			String filePath = dftFilePath + "resources" + File.separator + "editor" + File.separator + "multiupload"
					+ File.separator;
			String realFilePath = filePath + fileName;
			// 서버에 파일 저장
			int fileSize = saveFile(is, os, request, filePath, fileName);
			// 무결성 검증
			SHA256 hash = new SHA256();
			String checkHashValue = hash.sha256(realFilePath);
			System.out.println("java hash : " + checkHashValue);
			// 무결성 검증이 정상적이라면
			if (checkHashValue.equals(hashValue)) {
				UserVO login = (UserVO) session.getAttribute("login");
				String flag = login.getId();
				FilesVO insertFile = new FilesVO(filePath, fileName, fileSize, hashValue);
				// 데이터베이스에 파일저장
				int row = file_service.insertFiles(flag, insertFile);
				if (row == 0)
					fileError(realFilePath, sFileInfo, fileName);
				else {
					// DB에 저장에 문제없이 잘 처리 됐을경우
					insertFile.setFileGroupNum(file_service.findFileGroup(flag));
					int saveFileNum = file_service.findFile(insertFile);
					// 파일이름 중복이나 똑같은 파일저장 시 모두 저장해 주기위해 해당 파일num을 가져옴
					if (saveFileNum == 0)
						fileError(realFilePath, sFileInfo, fileName);
					else {
						// 문제없이 잘 가져왔을 경우
						// 파일 확장자를 구함
						String filename_ext = fileName.substring(fileName.lastIndexOf(".") + 1);
						// 확장자를소문자로 변경
						filename_ext = filename_ext.toLowerCase();
						// DB에 있는 파일넘버로 이름을 바꿔주는 작업
						String saveFileName = Integer.toString(saveFileNum) + "." + filename_ext;
						File tempFile = new File(realFilePath);
						File saveFile = new File(filePath + saveFileName);
						if(tempFile.exists()) {
							tempFile.renameTo(saveFile);
							tempFile.delete();
							// 작성중인 게시판으로 정보출력해주는 과정
							sFileInfo += "&bNewLine=true";
							// img 태그의 title 속성을 원본파일명으로 적용시켜주기 위함
							sFileInfo += "&sFileName=" + fileName;
							sFileInfo += "&sFileURL=" + "/resources/editor/multiupload/" + saveFileName;
						} else
							fileError(realFilePath, sFileInfo, fileName);
					}
				}
			} else
				fileError(realFilePath, sFileInfo, fileName);
			System.out.println("file 경로 : " + realFilePath);
			PrintWriter print = response.getWriter();
			print.print(sFileInfo);
			print.flush();
			print.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/deleteFiles.do")
	public String deleteFiles(HttpSession session, HttpServletRequest request) {
		UserVO login = (UserVO) session.getAttribute("login");
		file_service.cancel_insertBoard(login.getId());
		String referer = (String)request.getHeader("Referer"); 
		System.out.println(referer);
		return "redirect:"+referer;
	}
}
