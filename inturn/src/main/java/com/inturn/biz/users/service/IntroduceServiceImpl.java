package com.inturn.biz.users.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inturn.biz.users.dao.IntroduceDAO;

@Service("IntroduceService")
public class IntroduceServiceImpl implements IntroduceService{
	@Resource(name="IntroduceDAO")
	IntroduceDAO dao;
}
