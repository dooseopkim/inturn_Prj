package com.inturn.biz.web.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.inturn.biz.board.service.FileService;
import com.inturn.biz.board.service.MenteeBoardService;
import com.inturn.biz.board.vo.MenteeBoardVO;

/**
 * 
 * @author youngseo
 * @since 2018.07.15
 *
 */
@Controller
public class MenteeBoardController {
	@Resource(name = "MenteeBoardService")
	MenteeBoardService tb_service;
	@Resource(name = "FileService")
	FileService file_service;

	/**
	 * 게시판 리스트를 보여주는 함수
	 * 
	 * @param page_num
	 *            현재 페이징 처리된 페이지 번호
	 * @param request
	 *            해당 페이지에서의 띄워줄 게시글목록(list), 전체 페이징처리 개수가 몇개인지(page), 해당 페이지에서 마지막
	 *            게시글 번호(정확히는 게시글 수)(limit), 현재 페이지 목록 번호(thisPage)
	 * @return menteeBoard.jsp
	 */
	@RequestMapping(value = "/menteeBoard.do", method = RequestMethod.GET)
	public String menteeBoardDo(int page_num, HttpServletRequest request) {
		System.out.println("멘티게시판 고고고고!!");
		HashMap<String, Object> boardInfo = tb_service.boardList(page_num);
		List<MenteeBoardVO> list = (List<MenteeBoardVO>) boardInfo.get("list");
		System.out.println(list.toString());
		int page = (int) boardInfo.get("count_page");
		int limit = (int) boardInfo.get("limit");
		int thisPage = (int) boardInfo.get("thisPage");
		request.setAttribute("list", list);
		request.setAttribute("page", page);
		request.setAttribute("limit", limit);
		request.setAttribute("thisPage", thisPage);
		return "index.jsp?content=board/menteeBoard";
	}
	
	/**
	 * 게시물 내용보기
	 * 
	 * @param tb_num
	 *            게시판 번호
	 * @param thisPage
	 *            페이징 처리된 현재 페이지 번호
	 * @param request
	 *            게시글의 정보(board), 이전 게시글의 번호(prevtb_num), 다음 게시글의 번호(nexttb_num), 현재
	 *            페이지 번호(thisPage)를 담아서 보내준다.
	 * @return viewMenteeBoard.jsp
	 */
	@RequestMapping(value = "/viewMenteeBoard.do")
	public String viewMenteeBoard(int tb_num, int thisPage, HttpServletRequest request) {
		HashMap<String, Object> boardInfo = tb_service.viewBoard(tb_num);
		MenteeBoardVO board = (MenteeBoardVO) boardInfo.get("board");
		int prevtb_num = (int) boardInfo.get("prevtb_num");
		int nexttb_num = (int) boardInfo.get("nexttb_num");
		request.setAttribute("board", board);
		request.setAttribute("prevtb_num", prevtb_num);
		request.setAttribute("nexttb_num", nexttb_num);
		request.setAttribute("thisPage", thisPage);
		return "index.jsp?content=board/viewMenteeBoard";
	}


	/**
	 * 조건 검색한 게시물 리스트
	 * 
	 * @param condition
	 *            아이디 / 글제목
	 * @param search
	 *            검색할 내용
	 * @return scMenteeBoard.jsp
	 */
	@RequestMapping(value = "/searchMenteeBoard.do")
	public String searchMenteeBoard(String condition, String search, int page_num, HttpServletRequest request) {
		// 매퍼, DAO, Service모두 짜서 만들어야함
		HashMap<String, Object> boardInfo = tb_service.scBoardList(condition, search, page_num);
		List<MenteeBoardVO> list = (List<MenteeBoardVO>) boardInfo.get("list");
		int page = (int) boardInfo.get("count_page");
		int limit = (int) boardInfo.get("limit");
		int thisPage = (int) boardInfo.get("thisPage");
		request.setAttribute("list", list);
		request.setAttribute("page", page);
		request.setAttribute("limit", limit);
		request.setAttribute("thisPage", thisPage);
		request.setAttribute("condition", condition);
		request.setAttribute("search", search);
		return "index.jsp?content=board/scMenteeBoard";
	}
	
	/**
	 * 조건 검색한 게시물의 내용보기
	 * 
	 * @param condition
	 *            아이디 / 게시물 제목
	 * @param search
	 *            검색할 내용
	 * @param tb_num
	 *            현재 게시글 번호
	 * @param thisPage
	 *            수정 취소나 수정 시 다시 돌아갈 페이지 번호
	 * @param request
	 * @return viewSCMenteeBoard.jsp
	 */
	@RequestMapping(value = "/viewSCMenteeBoard.do")
	public String viewSCMenteeBoard(String condition, String search, int tb_num, int thisPage,
			HttpServletRequest request) {
		HashMap<String, Object> boardInfo = tb_service.scViewBoard(condition, search, tb_num);
		MenteeBoardVO board = (MenteeBoardVO) boardInfo.get("board");
		int prevtb_num = (int) boardInfo.get("prevtb_num");
		int nexttb_num = (int) boardInfo.get("nexttb_num");
		request.setAttribute("board", board);
		request.setAttribute("prevtb_num", prevtb_num);
		request.setAttribute("nexttb_num", nexttb_num);
		request.setAttribute("thisPage", thisPage);
		request.setAttribute("condition", condition);
		request.setAttribute("search", search);
		return "index.jsp?content=board/viewSCMenteeBoard";
	}

	
	/**
	 * 조건 검색한 게시글을 수정하기 위해 수정페이지로 이동 
	 * 이동 이전페이지, 다음페이지, 삭제, 수정등
	 * 다시 검색된 목록에 해당하는 페이지를 띄워주어야 하므로 다 따로 만들어짐
	 * 
	 * @param condition
	 *            검색하고자 하는 아이디나, 게시판 제목
	 * @param search
	 *            검색하고자 하는 것의 내용
	 * @param tb_num
	 *            현재 게시글 번호
	 * @param thisPage
	 *            수정 취소나 수정 시 다시 돌아갈 페이지 번호
	 * @param request
	 *            현제 수정하고자 하는 게시글 정보와, 수정 취소나 수정 시 다시 돌아갈 페이지 번호를 넣기 위해 사용
	 * @return modifySCMenteeBoard.jsp
	 */
	@RequestMapping(value = "/modifySCMenteeBoard.do", method = RequestMethod.GET)
	public String modifyMenteeBoard(String condition, String search, int tb_num, int thisPage,
			HttpServletRequest request) {
		HashMap<String, Object> boardInfo = tb_service.viewBoard(tb_num);
		request.setAttribute("board", (MenteeBoardVO) boardInfo.get("board"));
		request.setAttribute("thisPage", thisPage);
		request.setAttribute("condition", condition);
		request.setAttribute("search", search);
		return "index.jsp?content=board/modifySCMenteeBoard";
	}

	/**
	 * 조건 검색된 게시글을 수정
	 * 이동 이전페이지, 다음페이지, 삭제, 수정등
	 * 다시 검색된 목록에 해당하는 페이지를 띄워주어야 하므로 다 따로 만들어짐
	 * @param condition
	 *            검색하고자 하는 아이디나, 게시판 제목
	 * @param search
	 *            검색하고자 하는 것의 내용
	 * @param tb_num
	 *            현재 게시글 번호
	 * @param thisPage
	 *            수정 취소나 수정 시 다시 돌아갈 페이지 번호
	 * @param id
	 *            작성자
	 * @param editor
	 *            수정된 게시글의 내용
	 * @return viewSCMenteeBoard.do
	 */
	@RequestMapping(value = "/modifySCMenteeBoard.do", method = RequestMethod.POST)
	public String modfiySCFreeBoard(String condition, String search, int tb_num, String title, String id, int thisPage,
			String editor) {
		tb_service.modifyMenteeBoard(new MenteeBoardVO(tb_num, title, editor, id));
		return "redirect:viewSCMenteeBoard.do?condition=" + condition + "&search=" + search + "&tb_num=" + tb_num
				+ "&thisPage=" + thisPage;
	}

	/**
	 * 조건 검색된 게시글을 삭제하는 함수
	 * 이동 이전페이지, 다음페이지, 삭제, 수정등
	 * 다시 검색된 목록에 해당하는 페이지를 띄워주어야 하므로 다 따로 만들어짐
	 * @param condition
	 *            검색하고자 하는 아이디나, 게시판 제목
	 * @param search
	 *            검색하고자 하는 것의 내용
	 * @param tb_num
	 *            현재 게시글 번호
	 * @param thisPage
	 *            수정 취소나 수정 시 다시 돌아갈 페이지 번호
	 * @return searchMenteeBoard.do
	 */
	@RequestMapping(value = "/deleteSCMenteeBoard.do")
	public String deleteSCFreeBoard(String condition, String search, int tb_num, int thisPage) {
		tb_service.deleteMenteeBoard(tb_num);
		return "redirect:searchMenteeBoard.do?condition=" + condition + "&search=" + search + "&page_num=" + thisPage;
	}

	/**
	 * 게시글을 수정하기 위해 수정페이지로 이동
	 * 
	 * @param tb_num
	 *            현재 게시글 번호
	 * @param thisPage
	 *            수정 취소나 수정 시 다시 돌아갈 페이지 번호
	 * @param request
	 *            현제 수정하고자 하는 게시글 정보와, 수정 취소나 수정 시 다시 돌아갈 페이지 번호를 넣기 위해 사용
	 * @return modifyMenteeBoard.jsp
	 */
	@RequestMapping(value = "/modifyMenteeBoard.do", method = RequestMethod.GET)
	public String modifyMenteeBoard(int tb_num, int thisPage, HttpServletRequest request) {
		HashMap<String, Object> boardInfo = tb_service.viewBoard(tb_num);
		request.setAttribute("board", (MenteeBoardVO) boardInfo.get("board"));
		request.setAttribute("thisPage", thisPage);
		return "index.jsp?content=board/modifyMenteeBoard";
	}

	/**
	 * 게시글 수정 DB에 저장하기 Service단에서 transaction을 걸어 기존 파일을 지우고 저장했을 경우등 파일을 수정했을때의 모든
	 * 경우 수정
	 * 
	 * @param tb_num
	 *            게시판 번호
	 * @param title
	 *            게시판 제목
	 * @param id
	 *            글쓴이
	 * @param thisPage
	 *            게시판을 보고있던 사람이 게시글을 들어오기 전 리스트 번호
	 * @param editor
	 *            게시글 내용
	 * @return viewMenteeBoard.jsp
	 */
	@RequestMapping(value = "/modifyMenteeBoard.do", method = RequestMethod.POST)
	public String modfiyMenteeBoard(int tb_num, String title, String id, int thisPage, String editor) {
		tb_service.modifyMenteeBoard(new MenteeBoardVO(tb_num, title, editor, id));
		return "redirect:viewMenteeBoard.do?tb_num=" + tb_num + "&thisPage=" + thisPage;
	}

	/**
	 * 게시글을 삭제하는 함수, service단에서 transaction 설정으로 파일삭제, 댓글삭제도 같이 한다.
	 * 
	 * @param tb_num
	 *            게시판 번호
	 * @param thisPage
	 *            페이징 처리된 현재 페이지 번호
	 * @return 게시글 삭제 후 게시글 리스트로 돌아감 menteeBoard.do
	 */
	@RequestMapping(value = "/deleteMenteeBoard.do")
	public String deleteMenteeBoard(int tb_num, int thisPage) {
		tb_service.deleteMenteeBoard(tb_num);
		return "redirect:menteeBoard.do?page_num=" + thisPage;
	}


	
	/**
	 * @return 게시판 입력 페이지 이동 설정 insertMenteeBoard.jsp
	 */
	@RequestMapping(value = "/insertMenteeBoard.do", method = RequestMethod.GET)
	public String insertBoard() {
		return "index.jsp?content=board/insertMenteeBoard";
	}

	/**
	 * 게시글을 입력하는 함수로, File처리까지 한다. service 단에서 transaction 처리되어 입력된다.
	 * 
	 * @param title
	 *            게시글 제목
	 * @param id
	 *            게시글 작성자
	 * @param editor
	 *            게시글 내용
	 * @return menteeBoard.do 게시글 목록으로 이동
	 */
	@RequestMapping(value = "/insertMenteeBoard.do", method = RequestMethod.POST)
	public String insertBoard(String title, String id, String editor) {
		java.util.Date udate = new java.util.Date();
		System.out.println(title);
		Date regDate = new Date(udate.getTime());
		tb_service.insertMenteeBoard(new MenteeBoardVO(title, editor, regDate, 0, id));
		System.out.println("insert Mentee Board Test OK");
		return "redirect:menteeBoard.do?page_num=1";
	}

	/**
	 * 에디터를 이용한 파일 업로드시, 파일을 저장해주는 함수
	 * 
	 * @param is
	 *            파일을 읽어옴
	 * @param os
	 *            파일을 지정된 서버경로에 저장할 변수
	 * @param request
	 *            Ajax에서 헤더에 넣어 보낸 file정보를 가져오기 위해 사용
	 * @param filePath
	 *            파일의 경로
	 * @param fileName
	 *            파일의 이름
	 * @return 정상 수행됐을 경우, 파일 사이즈를 리턴
	 */
	/*public int saveFile(InputStream is, OutputStream os, HttpServletRequest request, String filePath, String fileName) {
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
	}*/

	/**
	 * 파일 입력을 하다가 다른페이지로 이동하거나, 중간에 에러가 났을 때 업로드된 파일을 삭제하기 위한 함수
	 * 
	 * @param realFilePath
	 *            저장된 파일의 이름까지 합쳐진 경로
	 * @param sFileInfo
	 *            파일의 정보
	 * @param filename
	 *            파일의 이름
	 */
/*	public void fileError(String realFilePath, String sFileInfo, String filename) {
		File deleteFile = new File(realFilePath);
		deleteFile.delete();
		// 정보 출력
		sFileInfo += "&bNewLine=true";
		// img 태그의 title 속성을 원본파일명으로 적용시켜주기 위함
		sFileInfo += "&sFileName=" + filename;
		sFileInfo += "&sFileURL=" + "/resources/editor/multiupload/" + "error.jpg";
	}*/

	/**
	 * 에디터를 이용해 파일을 업로드 시 DB와 서버에 파일을 저장하는 함수
	 * 
	 * @param request
	 *            Ajax에서 Header에 넣어 보낸 파일의 정보를 가져옴
	 * @param response
	 *            써진 파일의 경로를 다시 보내주기 위해 사용
	 * @param session
	 *            로그인 정보를 통해 id를 가져오기위해 사용
	 */
/*	@RequestMapping("/multiFileUploader.do")
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
						if (tempFile.exists()) {
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
	}*/

	/**
	 * 게시글을 작성하다가 다른페이지로 이동하여 당시 올린 파일들을 삭제하기 위해 사용하는 함수
	 * 
	 * @param session
	 *            login에서 id를 가져오기 위해 사용
	 * @param request
	 *            이동 직전 URL을 가져오기 위해 사용 (해당 URL을 체크해서 insertFreeBoard.do일 경우 수행하게
	 *            해놓았고, 파일 삭제작업이 끝난 후 다시 가고자 하는 페이지로 이동시켜주기 위해 사용)
	 * @return 가고자하는 페이지로 이동
	 */
	/*@RequestMapping(value = "/deleteFiles.do")
	public String deleteFiles(HttpSession session, HttpServletRequest request) {
		UserVO login = (UserVO) session.getAttribute("login");
		file_service.cancel_insertBoard(login.getId());
		String referer = (String) request.getHeader("Referer");
		System.out.println(referer);
		return "redirect:" + referer;
	}*/
}
