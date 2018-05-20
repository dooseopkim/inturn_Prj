package com.inturn.biz.users.service;

import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service("mailService")
public class MailServiceImpl implements MailService {
	@Inject
	private JavaMailSender javaMailSender;

	/*public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}*/

	@Override
	public boolean sendEmail(String subject, String text, String from, String to) {
		MimeMessage message = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
			helper.setSubject(subject);
			helper.setText(text, true);
			helper.setFrom(from);
			helper.setTo(to);

			// 파일첨부가 있을 때만 처리
			/*
			 * if (filePath != null) { File file = new File(filePath); if
			 * (file.exists()) { helper.addAttachment(file.getName(), new
			 * File(filePath)); } }
			 */

			javaMailSender.send(message);

			return true;

		} catch (MessagingException e) {
			e.printStackTrace();
		}

		return false;
	}

}
