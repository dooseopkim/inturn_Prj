package com.inturn.biz.web.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.inturn.biz.board.service.CsBoardService;
import com.inturn.biz.board.service.FileService;
import com.inturn.biz.board.vo.CsBoardVO;
import com.inturn.biz.board.vo.FreeBoardVO;

@Controller
public class CsBoardController {
	
	@Resource(name = "CsBoardService")
	CsBoardService cb_service;
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
	 * @return freeBoard.jsp
	 */
	@RequestMapping(value = "/csBoard.do", method = RequestMethod.GET)
	public String csBoardDo(int page_num, HttpServletRequest request) {
		HashMap<String, Object> boardInfo = cb_service.boardList(page_num);
		List<CsBoardVO> list = (List<CsBoardVO>) boardInfo.get("list");
		int page = (int) boardInfo.get("count_page");
		int limit = (int) boardInfo.get("limit");
		int thisPage = (int) boardInfo.get("thisPage");
		request.setAttribute("list", list);
		request.setAttribute("page", page);
		request.setAttribute("limit", limit);
		request.setAttribute("thisPage", thisPage);
		return "index.jsp?content=board/csBoard";
	}


	/**
	 * @return 게시판 입력 페이지 이동 설정 insertFreeBoard.jsp
	 */
	@RequestMapping(value = "/insertCsBoard.do", method = RequestMethod.GET)
	public String insertBoard() {
		return "index.jsp?content=board/insertCsBoard";
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
	 * @return freeBoard.do 게시글 목록으로 이동
	 */
//	@RequestMapping(value = "/insertCsBoard.do", method = RequestMethod.POST)
//	public String insertBoard(String title, String id, String editor) {
//		java.util.Date udate = new java.util.Date();
//		Date regDate = new Date(udate.getTime());
//		cb_service.insertCsBoard(new CsBoardVO(title, editor, regDate, 0, id));
//		return "redirect:freeBoard.do?page_num=1";
//	}
}
