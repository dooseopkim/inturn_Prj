package com.inturn.biz.users.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inturn.biz.users.dao.EducationalLevelDAO;

@Service("EducationalLevelService")
public class EducationalLevelServiceImpl implements EducationalLevelService{
	@Resource(name="EducationalLevelDAO")
	EducationalLevelDAO dao;
}
