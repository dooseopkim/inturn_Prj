package com.inturn.biz.users.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inturn.biz.users.dao.CareerDAO;
import com.inturn.biz.users.dao.JobDAO;

@Service("JobService")
public class JobServiceImpl implements JobService{
	@Resource(name="JobDAO")
	JobDAO dao;
}
