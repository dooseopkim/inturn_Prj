package com.inturn.biz.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inturn.biz.board.service.MentorBoardService;

@Controller
public class MentorBoardController {
	
	@Resource(name="MentorBoardService")
	MentorBoardService mb_service;
	
	@RequestMapping("mentorBoardWriteForm.do")
	public String mentorBoardWriteFormDo() {
		return "index.jsp?content=board/insertMentorBoard";
	}
	
}
