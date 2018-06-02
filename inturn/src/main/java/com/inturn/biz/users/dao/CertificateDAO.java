package com.inturn.biz.users.dao;

import java.util.List;

import com.inturn.biz.users.vo.CertificateVO;

public interface CertificateDAO {
	public int insertCertificates(CertificateVO vo);
	public CertificateVO getCertificate(String certificate_num);
	public List<CertificateVO> getCertificates(String id);
	public int deleteCertificate(String certificate_num);
	public int deleteCertificates(String id);
}
