package com.inturn.biz.web.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.inturn.biz.board.service.ReplyService;
import com.inturn.biz.board.vo.ReplyVO;

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
	
	@RequestMapping(value="/getReplies.do")
	public ModelAndView getReplies(int page_num) {
		HashMap<String, Object> map = new HashMap<>();
		HashMap<String, Object> result = ReplyService.getFBReplies(page_num);
		List<ReplyVO> list = (List<ReplyVO>) result.get("list");
		if(list != null) {
			map.put("result", "success");
			map.put("list", list);
		}
		else
			map.put("result", "none");
		return new ModelAndView("jsonView",map);
	}
	
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
