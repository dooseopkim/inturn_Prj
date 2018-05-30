package com.inturn.biz.web.controller;


import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.inturn.biz.users.service.EducationalLevelService;
import com.inturn.biz.users.service.MailService;
import com.inturn.biz.users.service.UserService;
import com.inturn.biz.users.vo.EducationalLevelVO;
import com.inturn.biz.users.vo.UserVO;

@Controller
public class UserController {

	@Resource(name="UserService")
	UserService UserService;
	
	@Resource(name="mailService")
	MailService mailService;
	
	@Resource(name="EducationalLevelService")
	EducationalLevelService eduLvlService;
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
	
	/**
	 * 회원가입 성공 시 띄워줄 화면
	 * @return
	 */
	@RequestMapping(value="/successSignup.do", method={RequestMethod.POST, RequestMethod.GET})
	public String successSignupDo(){
		return "/index.jsp?content=successSignUp";
	}
	
	
	@RequestMapping(value="/profileForm.do")
	public String profileFormDo(){
		return "/index.jsp?content=profile";
	}
			
	/**
	 * 프로필 페이지의 우측 배너(이력서 항목)에서 학력 클릭 시 학력사항 카드에 기존 데이터 불러오기
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping(value="getUserEduLvl.do")
	public ModelAndView getUserEduLvlDo(String name, HttpSession session) {
		System.out.println("getUserEduLvlDo() 진입");
		ModelAndView mav = new ModelAndView();
		UserVO user = (UserVO)session.getAttribute("login");
		System.out.println(user);
		if(user != null) {
			String id = user.getId();
			System.out.println("id : "+id);
			List<EducationalLevelVO> eduLvlList = eduLvlService.getUserEduLvl(id);
			System.out.println(eduLvlList);
			if(eduLvlList.size()!=0) {
				System.out.println("eduLvlList 불러오기 성공");
				mav.addObject("eduLvlList", eduLvlList);
				mav.addObject("result", "success");
			} else {
				System.out.println("eduLvlList.size()==0");
				mav.addObject("eduLvlList", null);
				mav.addObject("result", "null");
			}
		} else {
			System.out.println("로그인 정보 없음");
			mav.addObject("result", "로그인 후 이용해 주세요.");
		}
		mav.setViewName("jsonView");
		return mav;
	}
	
	/**
	 * 프로필 페이지에서 학력사항 추가 시
	 * @param vo
	 * @param session
	 * @return
	 */
	@RequestMapping(value="addProfileEdu.do", method=RequestMethod.POST)
	public ModelAndView addProfileEduDo(EducationalLevelVO vo, HttpSession session) {
		System.out.println("addProfileEduDo() 진입");
		ModelAndView mav = new ModelAndView();
		System.out.println(vo);
		UserVO user = (UserVO)session.getAttribute("login");
		String id = user.getId();
		System.out.println("id : " + id);
		vo.setId(id);
		System.out.println(vo);
		int result = eduLvlService.insertEduLvl(vo);
		if(result==1) {
			System.out.println("insert 성공");
			List<EducationalLevelVO> eduLvlList = eduLvlService.getUserEduLvl(id);
			System.out.println(eduLvlList);
			mav.addObject("eduLvlList", eduLvlList);
			mav.addObject("result", "success");
		} else {
			System.out.println("insert 실패");
			mav.addObject("result", "학력사항 저장에 실패했습니다. 잠시 후 다시 시도해 주세요.");
		}
		mav.setViewName("jsonView");
		System.out.println("addProfileEduDo() 끝");
		return mav;
	}
	
	@RequestMapping(value="deleteProfileEdu.do", method=RequestMethod.POST)
	public ModelAndView deleteProfileEduDo(int eduLevel_num, HttpSession session) {
		System.out.println("deleteProfileEduDo() 진입");
		ModelAndView mav = new ModelAndView();
		UserVO user = (UserVO)session.getAttribute("login");
		if(user!=null) {
			int result = eduLvlService.deleteEduLvl(eduLevel_num);
			if(result == 1) {
				System.out.println("삭제 성공");
				mav.addObject("result", "success");
				List<EducationalLevelVO> eduLvlList = eduLvlService.getUserEduLvl(user.getId());
				System.out.println(eduLvlList);
				if(eduLvlList.size()!=0) {
					System.out.println("eduLvlList.size()!=0");
					mav.addObject("eduLvlList", eduLvlList);
				} else {
					System.out.println("eduLvlList.size()==0");
					mav.addObject("result", "null");
					mav.addObject("eduLvlList", null);
				}
			} else {
				System.out.println("삭제 실패");
				mav.addObject("result", "삭제 실패. 잠시 후 다시 시도해 주세요.");
				
			}
		} else {
			System.out.println("로그인 정보 없음");
			mav.addObject("result", "로그인 후 이용해 주세요.");
		}
		mav.setViewName("jsonView");
		System.out.println("deleteProfileEduDo() 끝");
		return mav;
	}
}
