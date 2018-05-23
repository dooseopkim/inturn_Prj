package com.inturn.biz.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuController {
	
	@RequestMapping(value="/main.do")
	public String mainDo() {
		return "index.jsp?content=main";
	}
	
	@RequestMapping(value="/intro1.do")
	public String intro1Do() {
		return "index.jsp?content=intro1";
	}
	
	@RequestMapping(value="/intro2.do")
	public String intro2Do() {
		return "index.jsp?content=intro2";
	}
	
	@RequestMapping(value="/mentor.do")
	public String mentorDO() {
		return "index.jsp?content=mentor";
	}
	
	@RequestMapping(value="/mentee.do")
	public String menteeDo() {
		return "index.jsp?content=mentee";
	}

	@RequestMapping(value="/freeBoard.do")
	public String freeBoardDo() {
		return "index.jsp?content=freeBoard";
	}

	@RequestMapping(value="/csBoard.do")
	public String csBoardDo() {
		return "index.jsp?content=csBoard";
	}
	
	@RequestMapping(value="/interceptor.do")
	public String interceptorDo() {
		return "common/interceptor";
	}
}
