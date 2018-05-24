package com.inturn.biz.web.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthenticInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		String requestUrl = request.getRequestURL().toString();
		if(requestUrl.equals("http://localhost:9000/") || requestUrl.contains("/login.do") || requestUrl.contains("/logout.do") 
				|| requestUrl.contains("/loginForm.do") || requestUrl.contains("/loginForm.do") || requestUrl.contains("/findIDForm.do") 
				|| requestUrl.contains("/findID.do") || requestUrl.contains("/findPW.do") || requestUrl.contains("/sendNewPW.do")
				|| requestUrl.contains("/naverLogin.do") || requestUrl.contains("/main.do") || requestUrl.contains("/successSignup.do")
				|| requestUrl.contains("/chkId.do") || requestUrl.contains("/insertUser.do") || requestUrl.contains("/interceptor.do") 
				|| requestUrl.contains("/signup.do") || requestUrl.contains("/sendEmail.do") || requestUrl.contains("/signupForm.do") 
				|| requestUrl.contains("/intro1.do") || requestUrl.contains("/intro2.do") || session.getAttribute("login") != null ){
			System.out.println(request.getRequestURI() + "인터셉터 통과");
			return true;
		}
		else {
			response.sendRedirect("/interceptor.do");
			System.out.println(request.getRequestURI() + "인터셉터에서 제한");
			return false;
		}
	}
}
