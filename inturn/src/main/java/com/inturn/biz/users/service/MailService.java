package com.inturn.biz.users.service;

public interface MailService {
	/**
	 * 인증 메일 전송 메소드
	 * @param subject 제목
	 * @param text 내용
	 * @param from 보내는 메일 주소
	 * @param to 받는 메일 주소
	 * @param filePath 첨부파일 
	 * @return
	 */
	public boolean sendEmail(String subject, String text, String from, String to);
}
