package com.inturn.biz.web.common;

import java.io.FileInputStream;
import java.security.MessageDigest;

public class SHA256 {
	public String sha256(String filepath) throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		FileInputStream fis = new FileInputStream(filepath);

		byte[] dataBytes = new byte[1024];

		int nread = 0;
		while ((nread = fis.read(dataBytes)) != -1) {
			md.update(dataBytes, 0, nread);
		}
		
		byte[] mdbytes = md.digest();
		
		/*String shaHex = DatatypeConverter.printHexBinary(mdbytes);*/
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < mdbytes.length; i++) {
			sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
		}
		fis.close();
		return sb.toString();
	}
}
