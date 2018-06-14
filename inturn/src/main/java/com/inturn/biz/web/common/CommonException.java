package com.inturn.biz.web.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice("com.inturn.biz.web.controller")
public class CommonException {

	@ExceptionHandler(Exception.class)
	public ModelAndView ex(Exception exception) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", exception);
		mav.setViewName("common/error");
		return mav;
	}
}
