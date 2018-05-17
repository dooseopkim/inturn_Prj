package com.inturn.biz.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.inturn.biz.users.service.UserService;
import com.inturn.biz.users.vo.UserVO;

@Controller
public class LogInOutController {
	
	@Resource(name="UserService")
	UserService service;
	
	/**
	 * userMenu에서 로그인 클릭 시
	 * @return
	 */
	@RequestMapping("loginForm.do")
	public String loginFormDo() {
		return "index.jsp?content=user/login";
	}
	
	/**
	 * 로그인 페이지에서 로그인 버튼 클릭 시
	 * @param id
	 * @param pw
	 * @param session
	 * @return
	 */
	@RequestMapping(value="login.do", method=RequestMethod.POST)
	public ModelAndView loginDo(UserVO vo, HttpSession session) {
		System.out.println("loginDo() 진입");
		System.out.println(vo.getPw());
		ModelAndView mav = new ModelAndView();
		UserVO user = service.login(vo);
		if(user != null) {
			System.out.println("user : "+user);
			mav.addObject("result", "success");
			session.setAttribute("login", user);

		} else {
			System.out.println("user == null");
			mav.addObject("result", "fail");
		}
		mav.setViewName("jsonView");
		System.out.println("loginDo() 끝");
		return mav;
	}

	
//	kakaologin.do

	
	
//	naverlogin.do
	
	/**
	 * 로그인 페이지에서 아이디 찾기 버튼 클릭 시
	 * @return
	 */
	@RequestMapping("findIDForm.do")
	public String findIDFormDo() {
		return "index.jsp?content=user/findID";
	}
	
	
	@RequestMapping(value="findID.do", method=RequestMethod.POST)
	public ModelAndView findIDDo() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", "success");
		mav.addObject("id", "test");
		mav.setViewName("jsonView");
		return mav;
	}
	
	/**
	 * 로그인 페이지에서 비밀번호찾기 클릭 시 
	 * @return
	 */
	@RequestMapping("findPW.do")
	public String sendNewPWFormDo() {
		return "index.jsp?content=user/findPW";
	}
	
	@RequestMapping(value="sendNewPW.do", method=RequestMethod.POST)
	public ModelAndView sendNewPWDo() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", "success");
		mav.addObject("email", "test@gmail.com");
		mav.setViewName("jsonView");
		return mav;
	}
	
	/**
	 * 로그아웃 클릭 시
	 * @param session
	 * @return
	 */
	@RequestMapping("logout.do")
	public String logoutDo(HttpSession session) {
		session.setAttribute("login", null);
		session.removeAttribute("login");
		return "index.jsp?content=main";
	}
	
}
