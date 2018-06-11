package com.inturn.biz.web.controller;


import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.inturn.biz.users.service.CareerService;
import com.inturn.biz.users.service.CertificateService;
import com.inturn.biz.users.service.EducationalLevelService;
import com.inturn.biz.users.service.JobService;
import com.inturn.biz.users.service.MailService;
import com.inturn.biz.users.service.UserService;
import com.inturn.biz.users.vo.CareerVO;
import com.inturn.biz.users.vo.CertificateVO;
import com.inturn.biz.users.vo.EducationalLevelVO;
import com.inturn.biz.users.vo.JobVO;
import com.inturn.biz.users.vo.MailVO;
import com.inturn.biz.users.vo.UserVO;

@Controller
public class UserController {

	@Resource(name="UserService")
	UserService UserService;
	
	@Resource(name="mailService")
	MailService mailService;
	
	@Resource(name="EducationalLevelService")
	EducationalLevelService eduLvlService;
	
	@Resource(name="CareerService")
	CareerService careerService;
	
	@Resource(name="JobService")
	JobService jobService;

	@Resource(name="CertificateService")
	CertificateService CertificateService;
	
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
		
		// 이메일 전송정보 로딩
		MailVO mail_setting = mailService.init();
	
		String subject = "[人Turn] 회원가입 인증 코드 발급 안내";
		StringBuffer sb = new StringBuffer();
		sb.append("<h2>[人Turn] 회원가입 인증 코드 발급 안내</h2><br><br><hr><br>귀하의 인증 코드는 <strong style='color: green; font-weight: bold; font-size: large;'>"+code+"</strong>입니다. <br>인증번호를 입력해서 회원가입을 진행해 주세요.");
		//이게 진짜 메일 전송
		boolean flag = mailService.sendEmail(subject, sb.toString(), to, mail_setting);
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
	 * 프로필 페이지에서 학력사항 카드에 기존 데이터 불러오기
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping(value="getUserEduLvl.do")
	public ModelAndView getUserEduLvlDo(HttpSession session,
										@RequestParam(value="id", defaultValue="")String id) {
		System.out.println("getUserEduLvlDo() 진입");
		ModelAndView mav = new ModelAndView();
		if(id.equals("")) {
			UserVO user = (UserVO)session.getAttribute("login");
			id=user.getId();
		}
		System.out.println(id);
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
	public ModelAndView addProfileEduDo(String degree_level, String school_name, 
										Date admission_date, Date graduation_date, 
										String current_status, @RequestParam(value="major", defaultValue="")String major,
										@RequestParam(value="avg_score", defaultValue="0")double avg_score, double total_score,
										HttpSession session) {
		System.out.println("addProfileEduDo() 진입");
		ModelAndView mav = new ModelAndView();
		UserVO user = (UserVO)session.getAttribute("login");
		String id = user.getId();
		System.out.println("id : " + id);
		EducationalLevelVO vo = new EducationalLevelVO();
		vo.setDegree_level(degree_level);
		vo.setSchool_name(school_name);
		vo.setAdmission_date(admission_date);
		vo.setGraduation_date(graduation_date);
		vo.setCurrent_status(current_status);
		vo.setMajor(major);
		vo.setAvg_score(avg_score);
		vo.setTotal_score(total_score);
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
	
	/**
	 * 프로필 페이지에서 학력사항 수정 폼으로 이동 시
	 * @param eduLevel_num
	 * @param session
	 * @return
	 */
	@RequestMapping(value="modifyEduForm.do", method=RequestMethod.POST)
	public ModelAndView modifyEduFormDo(int eduLevel_num, HttpSession session) {
		System.out.println("modifyEduFormDo() 진입");
		ModelAndView mav = new ModelAndView();
		UserVO user = (UserVO)session.getAttribute("login");
		if(user!=null) {
			System.out.println("로그인 정보 확인 id : "+ user.getId());
			EducationalLevelVO vo = eduLvlService.getEduLvl(eduLevel_num);
			System.out.println(vo);
			if(vo!=null) {
				System.out.println("vo!=null");
				mav.addObject("eduLvl", vo);
				mav.addObject("result", "success");
			} else {
				System.out.println("vo!=null");
				mav.addObject("result", "해당 학력 데이터를 찾을 수 없습니다.");
			}
		} else {
			System.out.println("로그인 정보 없음");
			mav.addObject("result", "로그인 후 이용해 주세요.");
		}
		mav.setViewName("jsonView");
		System.out.println("modifyEduFormDo() 끝");
		return mav;
	}
	
	/**
	 * 프로필 페이지에서 학력사항 수정 시
	 * @param eduLevel_num
	 * @param degree_level
	 * @param school_name
	 * @param admission_date
	 * @param graduation_date
	 * @param current_status
	 * @param major
	 * @param avg_score
	 * @param total_score
	 * @param session
	 * @return
	 */
	@RequestMapping(value="modifyEdu.do", method=RequestMethod.POST)
	public ModelAndView modifyEduDo(int eduLevel_num, String degree_level, String school_name, 
									Date admission_date, Date graduation_date, 
									String current_status, @RequestParam(value="major", defaultValue="")String major,
									@RequestParam(value="avg_score", defaultValue="0")double avg_score, double total_score,
									HttpSession session) {
		System.out.println("modifyEduDo() 진입");
		ModelAndView mav = new ModelAndView();
		UserVO user = (UserVO)session.getAttribute("login");
		if(user != null) {
			String id = user.getId();
			System.out.println("로그인 정보 확인 id : " + id);
			EducationalLevelVO vo = new EducationalLevelVO();
			vo.setEduLevel_num(eduLevel_num);
			vo.setDegree_level(degree_level);
			vo.setSchool_name(school_name);
			vo.setAdmission_date(admission_date);
			vo.setGraduation_date(graduation_date);
			vo.setCurrent_status(current_status);
			vo.setMajor(major);
			vo.setAvg_score(avg_score);
			vo.setTotal_score(total_score);
			vo.setId(id);;
			System.out.println(vo);
			int result = eduLvlService.modifyEduLvl(vo);
			if(result == 1) {
				System.out.println("수정 성공");
				mav.addObject("result", "success");
				List<EducationalLevelVO> eduLvlList = eduLvlService.getUserEduLvl(id);
				mav.addObject("eduLvlList", eduLvlList);
			} else {
				System.out.println("수정 실패");
				mav.addObject("result", "success");
			}
		} else {
			System.out.println("로그인 정보 없음");
			mav.addObject("result", "로그인 후 이용해 주세요.");
		}
		
		mav.setViewName("jsonView");
		System.out.println("modifyEduDo() 끝");
		return mav;
	}
	
	/**
	 * 프로필 페이지에서 학력사항 삭제 시
	 * @param eduLevel_num
	 * @param session
	 * @return
	 */
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
	
	/**
	 * 프로필 페이지에서 경력사항 추가 시
	 * @param cvo career(회사명,부서명,입사일,퇴사일)
	 * @param jvo job(직급/직책,직무,세부직무)
	 * @param session 유저정보
	 * @return
	 */
	@RequestMapping(value="/addProfileCareer.do", method=RequestMethod.POST)
	public ModelAndView addProfileCareerDo(CareerVO cvo, JobVO jvo, HttpSession session){
		ModelAndView mav = new ModelAndView();
		UserVO uvo = (UserVO) session.getAttribute("login");
		String id= uvo.getId();
		cvo.setId(id);
		int resultCvo = careerService.insertCareer(cvo);
		jvo.setId(uvo.getId());
		int resultJvo = jobService.insertJob(jvo);
		if(resultCvo==1&&resultJvo==1) {
			System.out.println("insert 성공");
			List<CareerVO> careerList = careerService.getUserCareer(id);
			System.out.println(careerList);
			List<JobVO> jobList = jobService.getUserJob(id);
			System.out.println(jobList);
			mav.addObject("careerList", careerList);
			mav.addObject("jobList", jobList);
			mav.addObject("result", "success");
		} else {
			System.out.println("insert 실패");
			mav.addObject("result", "경력사항 저장에 실패했습니다. 잠시 후 다시 시도해 주세요.");
		}
		mav.setViewName("jsonView");
		System.out.println("addProfileCareerDo() 끝");
		return mav;
	}
	
	/**
	 * 기존에 등록된 경력사항을 불러옴
	 * @param session
	 * @param id 사용자 아이디
	 * @return
	 */
	@RequestMapping(value="/getUserCareer.do")
	public ModelAndView getUserCareerDo(HttpSession session,
			@RequestParam(value="id", defaultValue="")String id){
		System.out.println("getUserCareerDo() 진입");
		ModelAndView mav = new ModelAndView();
		if(id.equals("")) {
			UserVO user = (UserVO)session.getAttribute("login");
			id=user.getId();
		}
		System.out.println(id);
		List<CareerVO> careerList = careerService.getUserCareer(id);
		List<JobVO> jobList = jobService.getUserJob(id);
		if(careerList.size()!=0 && jobList.size()!=0) {
			System.out.println("경력사항 불러오기 성공");
			mav.addObject("careerList", careerList);
			mav.addObject("jobList", jobList);
			mav.addObject("result", "success");
		} else {
			System.out.println("기존에 등록된 경력사항이 없습니다.");
			mav.addObject("careerList", null);
			mav.addObject("jobList", null);
			mav.addObject("result", "null");
		}
		mav.setViewName("jsonView");
		return mav;
	}
	
	/**
	 * 경력사항 삭제
	 * @param num career의 num
	 * @param job_num  job의 num
	 * @param session
	 * @return
	 */
	@RequestMapping(value="deleteProfileCareer.do", method=RequestMethod.POST)
	public ModelAndView deleteProfileCareerDo(int num, int job_num, HttpSession session){
		ModelAndView mav = new ModelAndView();
		System.out.println("경력사항 삭제 do 진입");
		UserVO user = (UserVO)session.getAttribute("login");
		if(user!=null) {
			int result1 = jobService.deleteJob(job_num);
			int result2 = careerService.deleteCareer(num);
			if(result1 == 1 && result2 ==1) {
				System.out.println("삭제 성공");
				mav.addObject("result", "success");
				List<CareerVO> careerList = careerService.getUserCareer(user.getId());
				List<JobVO> jobList = jobService.getUserJob(user.getId());
				if(careerList.size()!=0 && jobList.size()!=0) {
					System.out.println("careerList.size()!=0   jobList.size()!=0");
					mav.addObject("careerList", careerList);
					mav.addObject("jobList", jobList);
				} else {
					System.out.println("careerList.size()==0    jobList.size()==0");
					mav.addObject("result", "null");
					mav.addObject("careerList", null);
					mav.addObject("jobList", null);
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
		System.out.println("deleteProfileCareerDo() 끝");
		return mav;
	}
	
	/**
	 * 경력사항 수정 후 저장 버튼 클릭 시
	 * @param cvo
	 * @param jvo
	 * @param session
	 * @return
	 */
	@RequestMapping(value="modifyCareer.do", method=RequestMethod.POST)
	public ModelAndView modifyCareerDo(CareerVO cvo, JobVO jvo, HttpSession session){
		System.out.println("modifyCareeDo() 접근");
		ModelAndView mav = new ModelAndView();
		UserVO uvo = (UserVO)session.getAttribute("login");
		String id= uvo.getId();
		int resultCvo = careerService.modifyCareer(cvo);
		int resultJvo = jobService.insertJob(jvo);
		if(resultCvo==1&&resultJvo==1) {
			System.out.println("modify 성공");
			List<CareerVO> careerList = careerService.getUserCareer(id);
			System.out.println(careerList);
			List<JobVO> jobList = jobService.getUserJob(id);
			System.out.println(jobList);
			mav.addObject("careerList", careerList);
			mav.addObject("jobList", jobList);
			mav.addObject("result", "success");
		} else {
			System.out.println("insert 실패");
			mav.addObject("result", "경력사항 저장에 실패했습니다. 잠시 후 다시 시도해 주세요.");
		}
		mav.setViewName("jsonView");
		System.out.println("modifyCareerDo() 끝");
		return mav;
	}
	
	/**
	 * 받을때, String[] 이나 int[]로도 가능 하지만, date[]는 안됨 (JSON 데이터 타입과 동일)
	 * 자격증 정보를 DB에 넣는 함수 각 리스트로 받은 변수들을 먼저 무결성 검증을 한 후에
	 * 없는 데이터일 경우 CertificateVO로 만들어서 모두 insert 해준다.
	 * @param certificate_num 자격증 번호
	 * @param certificate_name 자격증 이름
	 * @param published_by_license 자격증 발급처
	 * @param acquisition_date 자격증 취득일
	 * @param id 유저ID
	 * @return
	 */
	@RequestMapping(value="/insertCertificate.do", method=RequestMethod.POST)
	public ModelAndView insertCertificate(@RequestParam("certificate_num") ArrayList<String> certificate_num, 
			@RequestParam("certificate_name") ArrayList<String> certificate_name, 
			@RequestParam("published_by_license") ArrayList<String> published_by_license,
			@RequestParam("acquisition_date") ArrayList<String> acquisition_date,
			@RequestParam("id") String id) {
		HashMap<String, Object> map = new HashMap<>();
		int row = CertificateService.insertCertificates(certificate_num, certificate_name, published_by_license, acquisition_date, id);
		if(row != -1) {
			List<CertificateVO> list = CertificateService.getCertificates(id);
			map.put("result", "success");
			map.put("list", list);
		}
		else
			map.put("result","fail");
		return new ModelAndView("jsonView",map);
	}
	
	/**
	 * 자격증 정보를 수정하는 함수
	 * 그러나 certificate_num이 사실 기본키이므로 해당 자격증 삭제 후 새로 insert한다.
	 * ne_vo가 먼저 무결성검증을 거친 후 이상이 없으면 수행
	 * @param or_vo 바꾸기 전 값을 가지고 있는 vo
	 * @param ne_vo 새로 수정된 값을 가지고 있는 vo
	 * @return
	 */
	@RequestMapping(value="/modifyCertificate.do", method=RequestMethod.POST)
	public ModelAndView modifyCertificate(CertificateVO or_vo, CertificateVO ne_vo) {
		HashMap<String, Object> map = new HashMap<>();
		int row = CertificateService.modifyCertificate(or_vo, ne_vo);
		if(row != -1) {
			map.put("result", "success");
			map.put("list", ne_vo);
		}
		else
			map.put("result","fail");
		return new ModelAndView("jsonView", map);
	}
	
	/**
	 * 해당 자격증 번호의 자격증을 삭제
	 * @param certificate_num 자격증 번호
	 * @return
	 */
	@RequestMapping(value="/deleteRegisteredCertificate.do", method=RequestMethod.POST)
	public ModelAndView deleteRegisteredCertificate(String certificate_num) {
		HashMap<String, Object> map = new HashMap<>();
		CertificateService.deleteCertificate(certificate_num);
		map.put("result", "success");
		return new ModelAndView("jsonView", map);
	}

	/**
	 * 해당 유저의 모든 자격증 삭제
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/deleteAllCertificate.do")
	public ModelAndView deleteAllCertificate(HttpSession session) {
		HashMap<String, Object> map = new HashMap<>();
		UserVO vo = (UserVO) session.getAttribute("login");
		CertificateService.deleteCertificates(vo.getId());
		map.put("result", "success");
		return new ModelAndView("jsonView", map);
	}
	
	/**
	 * 자격증 정보를 가져오는 함수
	 * 페이지 로딩시 수행되는 부분으로
	 * 해당 유저가 가지고있는 모든 자격증 정보를 보내주는 함수
	 * 만약 자격증이없으면 javascript에서도 나머지 함수를 수행할 필요가 없으므로,
	 * 밑에와 같이 구분함
	 */
//	@RequestMapping(value="/getCertificates.do")
//	public ModelAndView getCertificates(HttpSession session) {
//		HashMap<String, Object> map = new HashMap<>();
//		UserVO vo = (UserVO) session.getAttribute("login");
//		List<CertificateVO> list = CertificateService.getCertificates(vo.getId());
//		if(!list.isEmpty()) {
//			map.put("result", "success");
//			map.put("list", list);
//		}
//		else
//			map.put("result", "none");
//		return new ModelAndView("jsonView", map);
//	}
	
	@RequestMapping(value="/getCertificates.do")
	public ModelAndView getCertificates(HttpSession session,
										@RequestParam(value="id", defaultValue="")String id) {
		HashMap<String, Object> map = new HashMap<>();
		if(id.equals("")) {
			UserVO user = (UserVO)session.getAttribute("login");
			id=user.getId();
		}
		System.out.println(id);
		List<CertificateVO> list = CertificateService.getCertificates(id);
		if(!list.isEmpty()) {
			map.put("result", "success");
			map.put("list", list);
		}
		else
			map.put("result", "none");
		return new ModelAndView("jsonView", map);
	}
	
}

