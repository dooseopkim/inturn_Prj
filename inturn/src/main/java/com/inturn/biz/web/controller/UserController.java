package com.inturn.biz.web.controller;


import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inturn.biz.users.service.MailService;
import com.inturn.biz.users.service.UserService;

@Controller
public class UserController {

	@Resource(name="UserService")
	UserService UserService;
	
	@Resource(name="mailService")
	MailService mailService;
	
	/**
	 * userMenu에서 회원가입 클릭시 
	 * @return
	 */
	@RequestMapping(value="/signupForm.do")
	public String signupDo() {
		return "index.jsp?content=chkCert";
	}

	
	@RequestMapping(value="/sendEmail.do", method=RequestMethod.POST)
	@ResponseBody
	public String sendEmailDo(HttpSession session, String to) {
		// 인증코드 5자리 생성한 후 session에 박아놓기
		int ran = new Random().nextInt(100000)+10000; //10000~99999
		String code = String.valueOf(ran);
		session.setAttribute("code", code);
		System.out.println("여기까진 성공");
		String subject = "[人Turn] 회원가입 인증 코드 발급 안내";
		StringBuffer sb = new StringBuffer();
		sb.append("<h2>[人Turn] 회원가입 인증 코드 발급 안내</h2><br><br><hr><br>귀하의 인증 코드는 "+code+" 입니다. <br>인증번호를 입력해서 회원가입을 진행해 주세요.");
		boolean flag = mailService.sendEmail(subject, sb.toString(), "youngseo9478@gmail.com", to);
		if(flag){
			return code;
		}
		return null;
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
