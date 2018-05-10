package com.inturn.biz.users.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("CareerDAO")
public class CareerDAOImpl implements CareerDAO{
	@Autowired
	SqlSessionTemplate mybatis;
}
