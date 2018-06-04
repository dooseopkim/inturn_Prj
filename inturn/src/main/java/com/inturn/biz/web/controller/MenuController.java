package com.inturn.biz.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author 박현호
 * @since 2018.05.14
 * @see 주석을 깜빡하고 늦게답니다...
 * 메뉴바에서 페이지 이동을 위한 Controller
 */
@Controller
public class MenuController {
	
	/**
	 * 회원정보 페이지로 이동하는 함수
	 * @return myPage.jsp
	 */
	@RequestMapping(value="/mypage.do")
	public String myPage() {
		
		return "index.jsp?content=user/myPage";
	}
	
	/**
	 * 메인 페이지로 이동하는 함수
	 * @return main.jsp
	 */
	@RequestMapping(value="/main.do")
	public String mainDo() {
		return "index.jsp?content=main";
	}
	
	/**
	 * 소개1 페이지로 이동하는 함수
	 * @return intro1.jsp
	 */
	@RequestMapping(value="/intro1.do")
	public String intro1Do() {
		return "index.jsp?content=intro1";
	}
	
	/**
	 * 소개2 페이지로 이동하는 함수
	 * @return intro2.jsp
	 */
	@RequestMapping(value="/intro2.do")
	public String intro2Do() {
		return "index.jsp?content=intro2";
	}
	
	/**
	 * 맨토페이지로 이동하는 함수
	 * @return mentor.jsp
	 */
	@RequestMapping(value="/mentor.do")
	public String mentorDO() {
		return "index.jsp?content=board/mentorBoard";
	}
	
	/**
	 * 맨티페이지로 이동하는 함수
	 * @return mentee.jsp
	 */
	@RequestMapping(value="/mentee.do")
	public String menteeDo() {
		return "index.jsp?content=mentee";
	}
	
	/**
	 * 자유게시판으로 이동하는 함수
	 * @return freeBoard.jsp
	 */
	@RequestMapping(value="/freeBoard.do")
	public String freeBoardDo() {
		return "index.jsp?content=freeBoard";
	}

	/**
	 * 고객서비스 게시판으로 이동하는 함수
	 * @return csBoard.jsp
	 */
	@RequestMapping(value="/csBoard.do")
	public String csBoardDo() {
		return "index.jsp?content=csBoard";
	}
	
	/**
	 * 인터셉터에서 걸러져서 요청값이 false되는 경우
	 * @return interceptor.jsp
	 */
	@RequestMapping(value="/interceptor.do")
	public String interceptorDo() {
		return "common/interceptor";
	}
}
