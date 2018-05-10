package com.inturn.biz.users.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("CounselStatusDAO")
public class CounselStatusDAOImpl  implements CounselStatusDAO{
	@Autowired
	SqlSessionTemplate mybatis;
}
