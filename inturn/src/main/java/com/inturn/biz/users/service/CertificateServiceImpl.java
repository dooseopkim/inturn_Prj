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

/**
 * @author 박현호
 * @version 1.0
 * @since 2018.06.01
 * @see 자격증 관련 서비스 함수
 */
@Service("CertificateService")
public class CertificateServiceImpl implements CertificateService{
	@Resource(name="CertificateDAO")
	CertificateDAO dao;

	/**
	 * 자격증 insert 함수
	 * if문에서 무결성 검증을 한다.
	 * 만약 있는 데이터라면 -1로 row를 반환하여
	 * 무결성 검증을 한다.
	 * 이상이 없는 경우 모든 data를 insert한다.
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int insertCertificates(ArrayList<String> certificate_num, ArrayList<String> certificate_name,
			ArrayList<String> published_by_license, ArrayList<String> acquisition_date, String id) {
		int row = 0;
		for(int i=0; i<certificate_num.size(); i++) {
			if(dao.getCertificate(certificate_num.get(i)) != null) {
				row = -1;
				break;
			}
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

	/**
	 * 자격증 정보 수정하는 함수
	 * 사실상 certificate_num이 기본키이므로
	 * 삭제 후 다시 insert해야한다.
	 * 따라서 수정된 자격증정보가 if문에서 무결성검증을 거친 후
	 * 이상이 없으면 기존의 정보를 삭제, 새로운 정보를 insert한다.
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int modifyCertificate(CertificateVO or_vo, CertificateVO ne_vo) {
		int row = 0;
		if(dao.getCertificate(ne_vo.getCertificate_num()) == null) {
			row += dao.deleteCertificate(or_vo.getCertificate_num());
			row += dao.insertCertificates(ne_vo);
		}
		else
			row = -1;
		return row;
	}
}
