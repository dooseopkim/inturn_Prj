package com.inturn.biz.web.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.inturn.biz.board.service.ReplyService;
import com.inturn.biz.board.vo.ReplyVO;
import com.inturn.biz.users.vo.UserVO;

/**
 * 
 * @author 박현호
 * @version 1.0
 * @since 2018.06.01
 * @see 댓글 CRUD 수행
 */
@Controller
public class ReplyController {
	@Resource(name="ReplyService")
	ReplyService ReplyService;
	
	/**
	 * 자유게시판과 관련된 댓글 최근 10개를 가져와서 알려주는 함수
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/freeBoardAlarm.do")
	public ModelAndView freeBoardAlarm(HttpSession session) {
		UserVO login = (UserVO) session.getAttribute("login");
		List<ReplyVO> list = ReplyService.freeBoardAlarm(login.getId());
		HashMap<String, Object> map = new HashMap<>();
		if(list != null) {
			map.put("result", "success");
			map.put("list", list);
		}
		else
			map.put("result", "none");
		return new ModelAndView("jsonView",map);
	}
	
	/**
	 * 댓글 작성 수행 함수
	 * @param vo
	 * @return
	 */
	@RequestMapping(value="/insertReply.do", method=RequestMethod.POST)
	public ModelAndView insertReply(ReplyVO vo) {
		int row = ReplyService.insertFBReply(vo);
		HashMap<String, Object> map = new HashMap<>();
		if(row >= 1)
			map.put("result", "success");
		else
			map.put("reulst", "fail");
		return new ModelAndView("jsonView",map);
	}
	
	/**
	 * 로딩시, 혹은 호출시 해당 페이지, 게시글에 있는
	 * 댓글을 페이징처리하여 보내주는 함수
	 * @param page_num
	 * @return
	 */
	@RequestMapping(value="/getReplies.do")
	public ModelAndView getReplies(int page_num, int fb_num) {
		HashMap<String, Object> map = new HashMap<>();
		HashMap<String, Object> result = ReplyService.getFBReplies(page_num, fb_num);
		List<ReplyVO> list = (List<ReplyVO>) result.get("list");
		int count_page = (int) result.get("count_page");
		if(list != null) {
			map.put("result", "success");
			map.put("list", list);
			map.put("page", count_page);
			map.put("thisPage", page_num);
		}
		else
			map.put("result", "none");
		return new ModelAndView("jsonView",map);
	}
	
	/**
	 * 댓글을 삭제해주는 함수
	 * @param rp_num
	 * @return
	 */
	@RequestMapping(value="/deleteReply.do", method=RequestMethod.POST)
	public ModelAndView deleteReply(int rp_num) {
		int row = ReplyService.deleteReply(rp_num);
		HashMap<String, Object> map = new HashMap<>();
		if(row >= 1)
			map.put("result", "success");
		else
			map.put("reulst", "fail");
		return new ModelAndView("jsonView",map);
	}
	
	/**
	 * 댓글을 수정해주는 함수
	 * @param vo
	 * @return
	 */
	@RequestMapping(value="/modifyReply.do", method=RequestMethod.POST)
	public ModelAndView modifyReply(ReplyVO vo) {
		int row = ReplyService.modifyReply(vo);
		HashMap<String, Object> map = new HashMap<>();
		if(row >= 1)
			map.put("result", "success");
		else
			map.put("reulst", "fail");
		return new ModelAndView("jsonView",map);
	}
	
	/**
	 * 대 댓글 입력함수
	 * @param vo
	 * @return
	 */
	@RequestMapping(value="/insertReReply.do", method=RequestMethod.POST)
	public ModelAndView insertReReply(ReplyVO vo) {
		int row = ReplyService.insertFBReReply(vo);
		HashMap<String, Object> map = new HashMap<>();
		if(row >= 1)
			map.put("result", "success");
		else
			map.put("reulst", "fail");
		return new ModelAndView("jsonView",map);
	}
}
