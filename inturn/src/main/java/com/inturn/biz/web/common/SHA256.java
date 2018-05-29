package com.inturn.biz.web.common;

import java.io.FileInputStream;
import java.security.MessageDigest;

/**
 * 
 * @author 박현호
 * @version 1.0
 * @since 2018.05.29
 * @see 파일 무결성 검증을 위한 hash함수
 */
public class SHA256 {
	/**
	 * FileInputStream으로 해당 경로의 파일을 읽어온다.
	 * 이 후 byte로 파일 데이터를 읽어 해쉬함수를 적용시킨다.
	 * 그 다음 byte타입으로 되어있는 해시값을 스트링으로 변환시켜 리턴한다.
	 * @param filepath
	 * @return file을 해시한 값
	 * @throws Exception
	 */
	public String sha256(String filepath) throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		FileInputStream fis = new FileInputStream(filepath);

		byte[] dataBytes = new byte[1024];

		int nread = 0;
		while ((nread = fis.read(dataBytes)) != -1) {
			md.update(dataBytes, 0, nread);
		}
		
		byte[] mdbytes = md.digest();
		
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < mdbytes.length; i++) {
			sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
		}
		fis.close();
		return sb.toString();
	}
}
