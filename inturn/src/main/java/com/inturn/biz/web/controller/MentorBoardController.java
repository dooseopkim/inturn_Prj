package com.inturn.biz.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.inturn.biz.board.service.MentorBoardService;
import com.inturn.biz.board.vo.MentorBoardVO;
import com.inturn.biz.users.vo.UserVO;

/**
 * 
 * @author 이슬기
 * @version 1.0
 * @since 2018.06.01
 * @see MentorBoard 관련 메소드 Controller
 */
@Controller
public class MentorBoardController {
	
	@Resource(name="MentorBoardService")
	MentorBoardService mb_service;
	
	@RequestMapping(value="mentorBoard.do", method={ RequestMethod.GET, RequestMethod.POST })
	public String mentorBoardDo(@RequestParam(value="nowPage", defaultValue="1")int nowPage,
								@RequestParam(value="condition", defaultValue="")String condition, 
								@RequestParam(value="keyword", defaultValue="")String keyword,
								HttpServletRequest req) {
		
		System.out.println("mentorBoardDo() 진입");
		System.out.println("nowPage : "+nowPage);
		System.out.println("condition : "+condition);
		System.out.println("keyword : "+keyword);
		
		int row = 9;
		System.out.println("row : "+row);
		int start_point = (nowPage-1) * row;
		System.out.println("startpoint : "+start_point);
		
		List<MentorBoardVO> mentorBoardList = new ArrayList<MentorBoardVO>();
		int totalCnt = 0;
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("start_point", start_point);
		map.put("row", row);
		
		if(condition.equals("")) {
			System.out.println("전체 리스트!!");
			totalCnt = mb_service.getCntMentorBoard();
			mentorBoardList = mb_service.mentorBoardList(map);
			req.setAttribute("condition", null);			
			
		} else {
			System.out.println("검색 결과 리스트!!");

			System.out.println("condition : "+ condition);
			System.out.println("keyword : "+ keyword);
			map.put("condition", condition);
			map.put("keyword", keyword);
			
			totalCnt = mb_service.getSearchCntMentorBoard(map);
			mentorBoardList = mb_service.searchMentorBoardList(map);
			req.setAttribute("condition", condition);
			req.setAttribute("keyword", keyword);
		}

		System.out.println("totalCnt : " + totalCnt);
		for(MentorBoardVO vo : mentorBoardList) {
			System.out.println(vo);
		}
				
		int totalPage = totalCnt / row;
		if((totalCnt % row) > 0) {
			totalPage ++;
		}
		
		int blockPage = 10;
		int startPage = ((nowPage-1)/blockPage)*blockPage+1;
		int endPage = startPage+blockPage-1;
		if(endPage > totalPage) {
			endPage = totalPage;
		}
		
		System.out.println("startPage : " + startPage);
		System.out.println("endPage : " + endPage);
		System.out.println("totalPage : "+totalPage);

		req.setAttribute("mentorBoardList", mentorBoardList);
		req.setAttribute("nowPage", nowPage);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("startPage", startPage);
		req.setAttribute("endPage", endPage);
				
		System.out.println("mentorBoardDo() 끝");
		
		return "index.jsp?content=board/mentorBoard";
	}
	
	@RequestMapping(value="viewMentorBoard.do")
	public String viewMentorBoardDo(int mb_num, HttpServletRequest req,
									@RequestParam(value="nowPage", defaultValue="1")int nowPage,
									@RequestParam(value="condition", defaultValue="")String condition, 
									@RequestParam(value="keyword", defaultValue="")String keyword) {
		
		System.out.println("viewMentorBoardDo() 진입");
		System.out.println("mb_num : " + mb_num);
		setReqViewMentorBoard(req, mb_num, nowPage, condition, keyword);
		System.out.println("viewMentorBoardDo() 끝");
		return "index.jsp?content=board/viewMentorBoard";
	
	}
	
	@RequestMapping("mentorBoardForm.do")
	public String mentorBoardFormDo() {
		return "index.jsp?content=board/insertMentorBoard";
	}
	
	@RequestMapping(value="insertMentorBoard.do", method = RequestMethod.POST)
	public String insertMentorBoardDo(String title, String editor, HttpSession session,
									@RequestParam(value="edu", defaultValue="")String edu,
									@RequestParam(value="career", defaultValue="")String career,
									@RequestParam(value="certificate", defaultValue="")String certificate) {
		
		System.out.println("insertMentorBoardDo()진입");
		UserVO user = (UserVO)session.getAttribute("login");
		String id = user.getId();
		MentorBoardVO vo = new MentorBoardVO(0, title, editor, edu, career, certificate, null, id);
		System.out.println(vo);
		int result = mb_service.insertMentorBoard(vo);
		if(result == 1) {
			System.out.println("insert 성공");
		} else {
			System.out.println("insert 실패");
		}
		System.out.println("insertMentorBoardDo() 끝");
		return "redirect:mentorBoard.do";
	}
	
	@RequestMapping("modifyMentorBoardForm.do")
	public String modifyMentorBoardFormDo(int mb_num, int nowPage, HttpServletRequest req,
										@RequestParam(value="condition", defaultValue="")String condition, 
										@RequestParam(value="keyword", defaultValue="")String keyword) {
	
		System.out.println("modifyMentorBoardFormDo() 진입");
		System.out.println("mb_num : "+mb_num);
		System.out.println("nowPage : "+nowPage);
		System.out.println("condition : "+condition);
		System.out.println("keyword : "+keyword);
		
		MentorBoardVO vo = mb_service.viewMentorBoard(mb_num);
		
		req.setAttribute("mentorBoard", vo);
		req.setAttribute("nowPage", nowPage);
		req.setAttribute("condition", condition);
		req.setAttribute("keyword", keyword);
		
		System.out.println("modifyMentorBoardFormDo() 끝");
		return "index.jsp?content=board/modifyMentorBoard";
	}
	
	@RequestMapping(value="modifyMentorBoard.do", method=RequestMethod.POST)
	public String modifyMentorBoardDo(int mb_num, int nowPage, HttpServletRequest req,
										String title, String editor,
										@RequestParam(value="edu", defaultValue="")String edu,
										@RequestParam(value="career", defaultValue="")String career,
										@RequestParam(value="certificate", defaultValue="")String certificate,
										@RequestParam(value="condition", defaultValue="")String condition, 
										@RequestParam(value="keyword", defaultValue="")String keyword) {
		System.out.println("modifyMentorBoardDo() 진입");
		System.out.println("mb_num : "+mb_num);
		System.out.println("title : "+title);
		System.out.println("editor : "+editor);
		System.out.println("edu : "+edu);
		System.out.println("career : "+career);
		System.out.println("certificate : "+certificate);
		System.out.println("nowPage : "+nowPage);
		System.out.println("condition : "+condition);
		System.out.println("keyword : "+keyword);
		
		MentorBoardVO vo = mb_service.viewMentorBoard(mb_num);
		System.out.println("수정 전 : " +vo);
		vo.setTitle(title);
		vo.setContent(editor);
		vo.setEdu(edu);
		vo.setCareer(career);
		vo.setCertificate(certificate);
		mb_service.modifyMentorBoard(vo);
		setReqViewMentorBoard(req, mb_num, nowPage, condition, keyword);
	
		System.out.println("modifyMentorBoardDo() 끝");
		return "index.jsp?content=board/viewMentorBoard";
	}
	
	@RequestMapping(value="deleteMentorBoard.do", method=RequestMethod.POST)
	public ModelAndView deleteMentorBoardDo(int mb_num) {
		System.out.println("deleteMentorBoardDo() 진입");
		ModelAndView mav = new ModelAndView();
		int result = mb_service.deleteMentorBoard(mb_num);
		if(result == 1) {
			System.out.println("삭제 성공");
			mav.addObject("result", "success");
		} else {
			System.out.println("삭제 실패");
			mav.addObject("result", "삭제되지 않았습니다. 잠시 후 다시 시도해 주세요.");
		}
		mav.setViewName("jsonView");
		System.out.println("deleteMentorBoardDo() 끝");
		return mav;
	}
	
	public HttpServletRequest setReqViewMentorBoard(HttpServletRequest req,
													int mb_num, int nowPage, 
													String condition, String keyword ) {
		System.out.println("index.jsp?content=board/viewMentorBoard() 진입");
		MentorBoardVO vo = mb_service.viewMentorBoard(mb_num);
		System.out.println(vo);
		int prevMb_num = 0;
		int nextMb_num = 0;
		
		if(!condition.equals("")) {
			System.out.println("검색");
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("condition", condition);
			map.put("keyword", keyword);
			map.put("mb_num", mb_num);
			prevMb_num = mb_service.scPrevMb_num(map);
			nextMb_num = mb_service.scNextMb_num(map);
			req.setAttribute("condition", condition);
			req.setAttribute("keyword", keyword);
			
		} else {
			System.out.println("전체");
			prevMb_num = mb_service.prevMb_num(mb_num);
			nextMb_num = mb_service.nextMb_num(mb_num);
		}
		req.setAttribute("mentorBoard", vo);
		req.setAttribute("nowPage", nowPage);
		req.setAttribute("prevMb_num", prevMb_num);
		req.setAttribute("nextMb_num", nextMb_num);
		System.out.println("prevMb_num : "+prevMb_num);
		System.out.println("nextMb_num : "+nextMb_num);
		
		System.out.println("index.jsp?content=board/viewMentorBoard() 끝");
		return req;
	}
}
