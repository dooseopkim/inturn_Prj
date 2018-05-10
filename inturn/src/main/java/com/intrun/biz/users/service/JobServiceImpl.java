package com.intrun.biz.users.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inturn.biz.users.dao.CareerDAO;

@Service("JobService")
public class JobServiceImpl implements JobService{
	@Resource(name="JobDAO")
	CareerDAO dao;
}
