package com.inturn.biz.users.dao;

import com.inturn.biz.users.vo.MailVO;

public interface MailDAO {
	MailVO init();
	public boolean sendEmail(String subject, String contents, String to, MailVO vo);
}
