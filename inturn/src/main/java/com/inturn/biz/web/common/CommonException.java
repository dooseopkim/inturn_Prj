package com.inturn.biz.web.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

public class CommonException {
	/*@ControllerAdvice("com.wdist.web.controller")
	public class CommonException {
		
		@ExceptionHandler(Exception.class)
		public ModelAndView ex(Exception exception) {
			ModelAndView mav = new ModelAndView();
			mav.addObject("exception",exception);
			mav.setViewName("error/error");
			return mav;
		}
	}*/
}
