package com.intrun.biz.users.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inturn.biz.users.dao.CareerDAO;

@Service("CounselStatusService")
public class CounselStatusServiceImpl implements CounselStatusService{
	@Resource(name="CounselStatusDAO")
	CareerDAO dao;
}
