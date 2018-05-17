package com.inturn.biz.web.controller;

import java.io.IOException;
import java.util.HashMap;

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
	
	/**
	 *  이 부분은 그냥 네이버로그인 API를 통해 로그인 됐을 때
	 *  @return loginFrom으로 다시 가서 naver Api의 callback메소드를 수행 -> ajax부분을 수행
	 */
	@RequestMapping(value="naverLogin.do", method=RequestMethod.GET)
	public String naverLogin(){
		System.out.println("naverLogin.do GET");
		return "redirect:loginForm.do";
	}

	/**
	 * 
	 * @param email 네이버 로그인을 통해 받은 email 주소
	 * @param name 네이버 회원가입 시 등록해 놓은 아이디
	 * @param birthday 네이버 회원가입 시 등록해 놓은 생일 월 / 일만 받아와서 곤란함
	 * 현재 이 부분에서 기존 가입이 있을 경우 그 정보와 비교해서 session에 loginVO를 박아줘야함
	 * 만약 가입이 없다면, 가입하라고 해야함!
	 * @return
	 */
	@RequestMapping(value="naverLogin.do", method=RequestMethod.POST)
	public ModelAndView naverLogin(String email, String name, String birthday){
		System.out.println("naverLogin.do POST");
		HashMap<String, Object> map = new HashMap<>();
		map.put("email", email);
		map.put("name", name);
		map.put("birthday", birthday);
		System.out.println("email : "+email);
		System.out.println("name : "+name);
		System.out.println("birthday : "+birthday);
		return new ModelAndView("jsonView",map);
	}
	
	
}
