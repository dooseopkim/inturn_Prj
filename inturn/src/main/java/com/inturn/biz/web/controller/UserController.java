package com.inturn.biz.web.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	
	/**
	 * userMenu에서 회원가입 클릭시 
	 * @return
	 */
	@RequestMapping(value="/signUp.do")
	public String signupDo() {
		return "index.jsp?content=signup";
	}
	
	/**
	 * 청년 회원가입 페이지
	 * @return
	 */
	@RequestMapping(value="/signupForm_tee.do")
	public String signupForm_teeDo() {
		return "index.jsp?content=signup1";
	}
	
	/**
	 * 신중년 회원가입 페이지
	 * @return
	 */
	@RequestMapping(value="/signupForm_tor.do")
	public String signupForm_torDo() {
		return "index.jsp?content=signup1";
	}
	
	/**
	 * userMenu에서 로그인 클릭 시
	 * @return
	 */
	@RequestMapping("loginForm.do")
	public String loginFormDo() {
		return "index.jsp?content=user/login";
	}
	
	@RequestMapping(value="login.do", method=RequestMethod.POST)
	public ModelAndView loginDo() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", "success");
		mav.setViewName("jsonView");
		return mav;
	}
	
	@RequestMapping("searchIdForm.do")
	public String SearchIdFormDo() {
		return "index.jsp?content=user/searchId";
	}
	
}
