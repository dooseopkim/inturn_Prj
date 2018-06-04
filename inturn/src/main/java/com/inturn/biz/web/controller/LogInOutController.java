package com.inturn.biz.web.controller;

import java.util.HashMap;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.inturn.biz.users.service.MailService;
import com.inturn.biz.users.service.UserService;
import com.inturn.biz.users.vo.MailVO;
import com.inturn.biz.users.vo.UserVO;

@Controller
public class LogInOutController {
	
	@Resource(name="UserService")
	UserService service;
	
	@Resource(name="mailService")
	MailService mailService;
	
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
		System.out.println("vo : " + vo);
		ModelAndView mav = new ModelAndView();
		UserVO user = service.login(vo);
		
		if(session.getAttribute("chkModPw") != null) {
			System.out.println("임시 비밀번호 발급한 계정");
			if(tempLogin(vo, session, mav)){
				session.setAttribute("login", vo);
//				session.setAttribute("chkModPw", null);
			} 
		} else if(user != null ) {
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
	
	/**
	 * 로그인 페이지에서 아이디 찾기 버튼 클릭 시
	 * @return
	 */
	@RequestMapping("findIDForm.do")
	public String findIDFormDo() {
		return "index.jsp?content=user/findID";
	}
	
	
	@RequestMapping(value="findID.do", method=RequestMethod.POST)
	public ModelAndView findIDDo(UserVO vo) {
		System.out.println(vo);
		ModelAndView mav = new ModelAndView();
		String userId = service.findID(vo);
		if(userId != null) {
			mav.addObject("result", "success");
			mav.addObject("id", userId);
		} else {
			mav.addObject("result", "일치하는 정보가 없습니다.");
		}
		mav.setViewName("jsonView");
		return mav;
	}
	
	/**
	 * 로그인 페이지에서 비밀번호찾기 클릭 시 
	 * @return
	 */
	@RequestMapping("findPW.do")
	public String findPwDo() {
		return "index.jsp?content=user/findPW";
	}
	
	/**
	 * 비밀번호찾기 버튼 클릭 시 임시 비밀번호를 사용자의 이메일로 발송한다.
	 * @param vo
	 * @param session
	 * @return
	 */
	@RequestMapping(value="sendNewPW.do", method=RequestMethod.POST)
	public ModelAndView sendNewPWDo(UserVO vo, HttpSession session) {
		System.out.println("sendNewPWDo() 진입");
		System.out.println(vo);
		ModelAndView mav = new ModelAndView();
		System.out.println(service.findPw(vo));
		if(service.findPw(vo)) {
			System.out.println("service.findPw() 진행");
//			비밀번호 이메일로 보내기
			int ran = new Random().nextInt(100000)+10000; //10000~99999
			String tempPw = String.valueOf(ran);
			System.out.println("tempPw : " +tempPw);
			String userEmail = vo.getEmail();
			
			// 이메일 전송정보 로딩
			MailVO mail_setting = mailService.init();
			System.out.println("여기까진 성공");
			String subject = "[人Turn] 임시 비밀번호 발급 안내";
			StringBuffer sb = new StringBuffer();
			sb.append("<h2>[人Turn] 임시 비밀번호 발급 안내</h2><br><br><hr><br>귀하의 임시 비밀번호는 <strong style='color: green; font-weight: bold; font-size: large;'>" + tempPw + "</strong> 입니다. <br>임시 비밀번호를 입력해서 로그인을 진행해 주세요.");
			
			//이게 진짜 메일 전송
			boolean flag = mailService.sendEmail(subject, sb.toString(), userEmail, mail_setting);

			if(flag) {
				session.setAttribute("chkModPw", "true");
				session.setAttribute("tempPw", tempPw);
				mav.addObject("result", "success");
				mav.addObject("userEmail", userEmail);
			} else {
				mav.addObject("result", "임시 비밀번호 발급에 실패했습니다. 잠시 후 다시 시도해 주세요.");
			}
			
		} else {
			mav.addObject("result", "일치하는 정보가 없습니다.");
		}
		mav.setViewName("jsonView");
		return mav;
	}

	/**
	 * 비밀번호 바꾸기 페이지로 이동
	 * @return
	 */
	@RequestMapping("modifyUserPwForm.do")
	public String modifyUserPwFormDo() {
		return "index.jsp?content=user/modifyUserPw";
	}
	
	@RequestMapping(value="modifyUserPw.do", method=RequestMethod.POST)
	public ModelAndView modifyUserPwDo(String id, String pw, String newPw, HttpSession session) {
		System.out.println("modifyUserPwDo() 진입");
		System.out.println("id : " + id);
		System.out.println("pw : " + pw);
		System.out.println("newPw : " + newPw);
		ModelAndView mav = new ModelAndView();
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPw(pw);
		mav.setViewName("jsonView");
		
		if(session.getAttribute("chkModPw") != null) {
			System.out.println("임시 비밀번호 사용 중");
			if(tempLogin(vo, session, mav)) {
				modifyUserPw(vo, newPw, mav);
				session.setAttribute("chkModPw", null);
			} 
		} else if(service.login(vo) != null) {
			System.out.println("현재 비밀번호 일치!");
			if(pw.equals(newPw)) {
				mav.addObject("result", "새 비밀번호가 현재 비밀번호와 일치합니다. 변경 후 다시 시도해 주세요.");
			} else {
				modifyUserPw(vo, newPw, mav);
			}
		} else {
			mav.addObject("result", "정보가 일치하지 않습니다. 정보 확인 후 다시 시도해 주세요.");
		}
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
		session.invalidate();
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
	
	
	public Boolean tempLogin(UserVO vo, HttpSession session, ModelAndView mav) {
		System.out.println("tempLogin() 진입");
		String tempPw = (String)session.getAttribute("tempPw");
		if(vo.getPw().equals(tempPw)) {
			System.out.println("tempPw 일치");
			mav.addObject("result", "success");
			mav.addObject("chkTempPw", "true");
//			session.setAttribute("chkModPw", null);
			return true;
		} else {
			System.out.println("tempPw 불일치");
			mav.addObject("result", "정보가 일치하지 않습니다. 정보 확인 후 다시 시도해 주세요.");
			return false;
		}
	}
	
	public void modifyUserPw(UserVO vo, String newPw, ModelAndView mav) {
		vo.setPw(newPw);
		if(service.modifyUserPw(vo) == 1) {
				System.out.println("비밀번호 변경 성공");
				mav.addObject("result", "success");
//				session.setAttribute("chkModPw", "null");
		} else {
			System.out.println("비밀번호 변경 실패");
			mav.addObject("result", "비밀번호 변경에 실패했습니다. 잠시 후 다시 시도해 주세요.");
		}
	}
}
