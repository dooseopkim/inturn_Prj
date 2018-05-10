package com.inturn.biz.users.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("EducationalLevelDAO")
public class EducationalLevelDAOImpl implements EducationalLevelDAO{
	@Autowired
	SqlSessionTemplate mybatis;
}
