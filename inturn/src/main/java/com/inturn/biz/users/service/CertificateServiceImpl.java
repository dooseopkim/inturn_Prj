package com.inturn.biz.users.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inturn.biz.users.dao.CareerDAO;

@Service("CertificateService")
public class CertificateServiceImpl implements CertificateService{
	@Resource(name="CertificateDAO")
	CareerDAO dao;
}
