package com.inturn.biz.users.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inturn.biz.users.dao.MailDAO;
import com.inturn.biz.users.vo.MailVO;

@Service("mailService")
public class MailServiceImpl implements MailService{
	
	@Resource(name="MailDAO")
	MailDAO dao;
	
	@Override
	public MailVO init(int port) {
		return dao.init(port);
	}

	@Override
	public boolean sendEmail(String subject, String contents, String to, MailVO vo) {
		return dao.sendEmail(subject, contents, to, vo);
	}


}
