package com.inturn.biz.web.controller;

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
}
