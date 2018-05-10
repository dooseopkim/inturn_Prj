package com.inturn.biz.users.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("CertificateDAO")
public class CertificateDAOImpl implements CertificateDAO{
	@Autowired
	SqlSessionTemplate mybatis;
}