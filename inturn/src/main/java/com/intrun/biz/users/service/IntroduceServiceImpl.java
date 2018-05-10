package com.intrun.biz.users.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inturn.biz.users.dao.CareerDAO;

@Service("IntroduceService")
public class IntroduceServiceImpl implements IntroduceService{
	@Resource(name="IntroduceDAO")
	CareerDAO dao;
}
