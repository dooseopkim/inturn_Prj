package com.inturn.biz.users.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.inturn.biz.users.dao.CertificateDAO;
import com.inturn.biz.users.vo.CertificateVO;


@Service("CertificateService")
public class CertificateServiceImpl implements CertificateService{
	@Resource(name="CertificateDAO")
	CertificateDAO dao;

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int insertCertificates(ArrayList<String> certificate_num, ArrayList<String> certificate_name,
			ArrayList<String> published_by_license, ArrayList<String> acquisition_date, String id) {
		int row = 0;
		for(int i=0; i<certificate_num.size(); i++) {
			Date date = Date.valueOf(acquisition_date.get(i));
			row += dao.insertCertificates(new CertificateVO(certificate_num.get(i),certificate_name.get(i),published_by_license.get(i),date,id));
		}
		return row;
	}

	@Override
	public CertificateVO getCertificate(String certificate_num) {
		return dao.getCertificate(certificate_num);
	}

	@Override
	public List<CertificateVO> getCertificates(String id) {
		return dao.getCertificates(id);
	}

	@Override
	public int deleteCertificate(String certificate_num) {
		return dao.deleteCertificate(certificate_num);
	}

	@Override
	public int deleteCertificates(String id) {
		return dao.deleteCertificates(id);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int modifyCertificate(CertificateVO or_vo, CertificateVO ne_vo) {
		int row = 0;
		row += dao.deleteCertificate(or_vo.getCertificate_num());
		row += dao.insertCertificates(ne_vo);
		return row;
	}
}
