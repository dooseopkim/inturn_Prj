package com.inturn.biz.users.service;

import java.util.ArrayList;
import java.util.List;

import com.inturn.biz.users.vo.CertificateVO;

public interface CertificateService {
	public int insertCertificates(ArrayList<String> certificate_num, ArrayList<String> certificate_name,
			ArrayList<String> published_by_license, ArrayList<String> acquisition_date, String id);

	public CertificateVO getCertificate(String certificate_num);

	public List<CertificateVO> getCertificates(String id);

	public int deleteCertificate(String certificate_num);

	public int deleteCertificates(String id);

	public int modifyCertificate(CertificateVO or_vo, CertificateVO ne_vo);
}
