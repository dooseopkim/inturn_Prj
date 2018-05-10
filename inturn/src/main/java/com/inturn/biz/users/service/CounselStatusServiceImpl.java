package com.inturn.biz.users.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inturn.biz.users.dao.CounselStatusDAO;

@Service("CounselStatusService")
public class CounselStatusServiceImpl implements CounselStatusService{
	@Resource(name="CounselStatusDAO")
	CounselStatusDAO dao;
}
