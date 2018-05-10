package com.intrun.biz.users.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inturn.biz.users.dao.CareerDAO;

@Service("EducationalLevelService")
public class EducationalLevelServiceImpl implements EducationalLevelService{
	@Resource(name="EducationalLevelDAO")
	CareerDAO dao;
}
