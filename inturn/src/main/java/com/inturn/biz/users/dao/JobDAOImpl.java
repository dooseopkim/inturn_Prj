package com.inturn.biz.users.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("JobDAO")
public class JobDAOImpl implements JobDAO{
	@Autowired
	SqlSessionTemplate mybatis;
}	