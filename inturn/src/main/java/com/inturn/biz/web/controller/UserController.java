package com.inturn.biz.web.controller;


import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.inturn.biz.users.service.MailService;
import com.inturn.biz.users.service.UserService;
import com.inturn.biz.users.vo.UserVO;

@Controller
public class UserController {

	@Resource(name="UserService")
	UserService UserService;
	
	@Resource(name="mailService")
	MailService mailService;
	
	/**
	 * userMenu에서 회원가입 클릭시 약관동의 및 이메일 인증 페이지로 이동
	 * @return
	 */
	@RequestMapping(value="/signup.do")
	public String signupDo() {
		return "index.jsp?content=chkCert";
	}

	/**
	 * 인증 코드를 담은 to 계정으로 이메일을 전송
	 * @param session 현재 생성한 인증코드를 세션 정보에 담아둠
	 * @param to 받는 사람의 이메일 주소
	 * @return
	 */
	@RequestMapping(value="/sendEmail.do", method=RequestMethod.POST)
	@ResponseBody
	public String sendEmailDo(HttpSession session, String to) {
		// 인증코드 생성한 후 session에 박아놓기
		int ran = new Random().nextInt(100000)+10000; //10000~99999
		String code = String.valueOf(ran);
		session.setAttribute("code", code);
		session.setAttribute("email", to);
		System.out.println("여기까진 성공");
		String subject = "[人Turn] 회원가입 인증 코드 발급 안내";
		StringBuffer sb = new StringBuffer();
		sb.append("<h2>[人Turn] 회원가입 인증 코드 발급 안내</h2><br><br><hr><br>귀하의 인증 코드는 <strong style='color: green; font-weight: bold; font-size: large;'>"+code+"</strong> 입니다. <br>인증번호를 입력해서 회원가입을 진행해 주세요.");
		boolean flag = mailService.sendEmail(subject, sb.toString(), "inturn303@gmail.com", to);
		if(flag){
			return code;
		}
		return null;
	}
	
	/**
	 * 이메일 인증 성공 후 회원가입 페이지로 이동 
	 * @return
	 */
	@RequestMapping(value="/signupForm.do", method={RequestMethod.GET,RequestMethod.POST})
	public String signupFormDo(HttpSession session) {
		String email = (String) session.getAttribute("email");
		session.setAttribute("email", email);
		return "/index.jsp?content=signup";
	}
	
	/**
	 * 아이디 중복체크
	 * @param session
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/chkId.do", method=RequestMethod.POST)
	public ModelAndView chkIdDo(HttpSession session, String id){
		UserVO uvo = new UserVO(id);
		System.out.println(id);
		Map<String, String> map = new HashMap<String, String>();
		int result = UserService.getId(uvo);
		System.out.println(result);
		if(result==0){
			map.put("result", "success");
		}else{
			map.put("result", "fail");
		}
		session.setAttribute("chkId", id);
		return new ModelAndView("jsonView",map);
	}
	
	/**
	 * 유저 생성(회원가입)
	 * @param type
	 * @param name
	 * @param id
	 * @param pw
	 * @param phone
	 * @param birthday
	 * @param email
	 * @return
	 */
	@RequestMapping(value="/insertUser.do", method=RequestMethod.POST)
	public ModelAndView insertUserDo(String type, String name, String id, String pw, String phone, String birthday, String email){
		Map<String, String> map = new HashMap<String, String>();
		System.out.println(birthday);
		UserVO uvo = new UserVO(id, pw, name, phone, email, Date.valueOf(birthday), type);
		int num = UserService.insertUser(uvo);
		if(num==1){
			map.put("result", "success");
		}else{
			map.put("result", "fail");
		}
		return new ModelAndView("jsonView", map);
	}
	
	@RequestMapping(value="/successSignup.do", method={RequestMethod.POST, RequestMethod.GET})
	public String successSignupDo(){
		return "/index.jsp?content=successSignUp";
	}

}
