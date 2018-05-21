package com.inturn.biz.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.inturn.biz.board.vo.EditorVO;
import com.inturn.biz.web.common.SHA256;

/**
 * 
 * @author 박현호
 * @version 1.0
 * @since 2018.05.14
 * @see 게시판 관련 메소드 Controller
 */
@Controller
public class BoardController {

	/**
	 * @return 자유게시판 페이지 이동 설정
	 */
	@RequestMapping(value = "/freeBoard.do", method = RequestMethod.GET)
	public String freeBoardDo() {
		return "index.jsp?content=board/freeBoard";
	}

	/**
	 * @return 게시판 입력 페이지 이동 설정
	 */
	@RequestMapping(value = "/insertBoard.do", method = RequestMethod.GET)
	public String insertBoard() {
		return "index.jsp?content=board/insertBoard";
	}

	@RequestMapping(value = "/insertBoard.do", method = RequestMethod.POST)
	public String insertBoard(String editor) {
		System.out.println("저장할 내용" + editor);
		return "redirect:freeBoard.do";
	}

	@RequestMapping("/file_uploader.do")
	public String file_uploader(HttpServletRequest request, HttpServletResponse response, EditorVO editor) {
		String return1 = request.getParameter("callback");
		String return2 = "?callback_func=" + request.getParameter("callback_func");
		String return3 = "";
		String name = "";
		try {
			if (editor.getFiledata() != null && editor.getFiledata().getOriginalFilename() != null
					&& !editor.getFiledata().getOriginalFilename().equals("")) {
				// 기존 상단 코드를 막고 하단코드를 이용
				name = editor.getFiledata().getOriginalFilename()
						.substring(editor.getFiledata().getOriginalFilename().lastIndexOf(File.separator) + 1);
				String filename_ext = name.substring(name.lastIndexOf(".") + 1);
				filename_ext = filename_ext.toLowerCase();
				String[] allow_file = { "jpg", "png", "bmp", "gif" };
				int cnt = 0;
				for (int i = 0; i < allow_file.length; i++) {
					if (filename_ext.equals(allow_file[i])) {
						cnt++;
					}
				}
				if (cnt == 0) {
					return3 = "&errstr=" + name;
				} else {
					// 파일 기본경로
					String dftFilePath = request.getSession().getServletContext().getRealPath("/");
					// 파일 기본경로 _ 상세경로
					String filePath = dftFilePath + "resources" + File.separator + "editor" + File.separator + "upload"
							+ File.separator;
					File file = new File(filePath);
					if (!file.exists()) {
						file.mkdirs();
					}
					String realFileNm = "";
					SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
					String today = formatter.format(new java.util.Date());
					realFileNm = today + UUID.randomUUID().toString() + name.substring(name.lastIndexOf("."));
					String rlFileNm = filePath + realFileNm;
					///////////////// 서버에 파일쓰기 /////////////////
					editor.getFiledata().transferTo(new File(rlFileNm));
					///////////////// 서버에 파일쓰기 /////////////////
					return3 += "&bNewLine=true";
					return3 += "&sFileName=" + name;
					return3 += "&sFileURL=/resources/editor/upload/" + realFileNm;
				}
			} else {
				return3 += "&errstr=error";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:" + return1 + return2 + return3;
	}

	@RequestMapping("/multiFileUploader.do")
	public void file_uploader_html5(HttpServletRequest request, HttpServletResponse response) {
		try {
			// 파일정보
			String sFileInfo = "";
			// 파일명을 받는다 - 일반 원본파일명
			String filename = request.getHeader("file-name");
			String temp[] = filename.split("%23%23%23");
			filename = temp[0];
			String hashValue = temp[1];
			System.out.println("javascript hash : "+hashValue);
			/*
			 * String hashValue = filename.substring(filename.indexOf("###"));
			 * System.out.println(hashValue);
			 */
			// 파일 확장자
			String filename_ext = filename.substring(filename.lastIndexOf(".") + 1);
			// 확장자를소문자로 변경
			filename_ext = filename_ext.toLowerCase();

			// 이미지이므로 신규 파일로 디렉토리 설정 및 업로드
			// 파일 기본경로
			String dftFilePath = request.getSession().getServletContext().getRealPath("/");
			// 파일 기본경로 _ 상세경로
			String filePath = dftFilePath + "resources" + File.separator + "editor" + File.separator + "multiupload"
					+ File.separator;
			File file = new File(filePath);
			if (!file.exists()) {
				file.mkdirs();
			}
			String realFileNm = "";
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
			String today = formatter.format(new java.util.Date());
			realFileNm = today + UUID.randomUUID().toString() + filename.substring(filename.lastIndexOf("."));
			String rlFileNm = filePath + realFileNm;
			///////////////// 서버에 파일쓰기 /////////////////
			InputStream is = request.getInputStream();
			OutputStream os = new FileOutputStream(rlFileNm);
			OutputStream os1 = new FileOutputStream(filePath+filename);
			int numRead;
			byte b[] = new byte[Integer.parseInt(request.getHeader("file-size"))];
			while ((numRead = is.read(b, 0, b.length)) != -1) {
				os.write(b, 0, numRead);
				os1.write(b, 0, numRead);
			}
			if (is != null) {
				is.close();
			}
			os.flush();
			os.close();
			os1.flush();
			os1.close();
			///////////////// 서버에 파일쓰기 /////////////////
			
			//자바스크립트와 여기의 해시함수가 달라서 값이 다름 그것을 맞춰줘야 무결성 검증 가능...
			SHA256 hash = new SHA256();
			System.out.println("java hash : "+hash.sha256(filePath+filename));
			System.out.println("file 경로 : "+filePath+filename);
			
			// 정보 출력
			sFileInfo += "&bNewLine=true";
			// img 태그의 title 속성을 원본파일명으로 적용시켜주기 위함
			sFileInfo += "&sFileName=" + filename;
			;
			sFileInfo += "&sFileURL=" + "/resources/editor/multiupload/" + realFileNm;
			PrintWriter print = response.getWriter();
			print.print(sFileInfo);
			print.flush();
			print.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
