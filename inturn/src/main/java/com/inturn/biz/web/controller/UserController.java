package com.inturn.biz.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.RequestMethod;
>>>>>>> branch 'master' of https://github.com/dooseopkim/inturn_Prj.git
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	
	/**
	 * userMenu에서 회원가입 클릭시 
	 * @return
	 */
	@RequestMapping(value="/signupForm.do")
	public String signupDo() {
		return "index.jsp?content=chkCert";
	}

	@RequestMapping(value="/checkCert.do")
	public String checkCertDo() {
		return "index.jsp?content=checkCert";
	}
	
	/**
	 * 청년 회원가입 페이지
	 * @return
	 */
	@RequestMapping(value="/signupForm_tee.do")
	public String signupForm_teeDo() {
		return "index.jsp?content=signup";
	}
	
	/**
	 * 신중년 회원가입 페이지
	 * @return
	 */
	@RequestMapping(value="/signupForm_tor.do")
	public String signupForm_torDo() {
		return "index.jsp?content=signup_mento";
	}
	
	@RequestMapping(value="/mentee_signup.do")
	public String mentee_signupDo(){
		return "index.jsp?content=";
	}
	

}
