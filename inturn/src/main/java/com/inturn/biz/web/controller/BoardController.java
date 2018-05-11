package com.inturn.biz.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
	
	@RequestMapping(value="/main.do")
	public String mainDo() {
		return "index.jsp?content=main";
	}
}
