package com.inturn.biz.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
			// 파일 확장자
			String filename_ext = filename.substring(filename.lastIndexOf(".") + 1);
			// 확장자를소문자로 변경
			filename_ext = filename_ext.toLowerCase();

			// 파일 기본경로
			String dftFilePath = request.getSession().getServletContext().getRealPath("/");
			// 파일 기본경로 _ 상세경로
			String filePath = dftFilePath + "resources" + File.separator + "editor" + File.separator + "multiupload"
					+ File.separator;
			String realFilePath = filePath + filename;
			File file = new File(filePath);
			if (!file.exists()) {
				file.mkdirs();
			}
			///////////////// 서버에 파일쓰기 /////////////////
			InputStream is = request.getInputStream();
			OutputStream os = new FileOutputStream(realFilePath);
			int numRead;
			byte b[] = new byte[Integer.parseInt(request.getHeader("file-size"))];
			while ((numRead = is.read(b, 0, b.length)) != -1) {
				os.write(b, 0, numRead);
			}
			if (is != null) {
				is.close();
			}
			os.flush();
			os.close();
			
			//무결성 검증
			SHA256 hash = new SHA256();
			String checkHashValue = hash.sha256(realFilePath);
			System.out.println("java hash : "+checkHashValue);
			if(checkHashValue.equals(hashValue)) {
				
			} else {
				File deleteFile = new File(realFilePath);
				deleteFile.delete();
			}
			System.out.println("file 경로 : "+realFilePath);
			
			// 정보 출력
			sFileInfo += "&bNewLine=true";
			// img 태그의 title 속성을 원본파일명으로 적용시켜주기 위함
			sFileInfo += "&sFileName=" + filename;
			sFileInfo += "&sFileURL=" + "/resources/editor/multiupload/" + filename;
			PrintWriter print = response.getWriter();
			print.print(sFileInfo);
			print.flush();
			print.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
