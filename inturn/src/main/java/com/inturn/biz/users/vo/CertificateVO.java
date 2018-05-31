package com.inturn.biz.users.vo;

import java.sql.Date;

public class CertificateVO {
	private String certificate_num;
	private String certificate_name;
	private String published_by_license;
	private Date acquisition_date;
	private String id;
	
	public CertificateVO() {
	}

	public CertificateVO(String certificate_num, String certificate_name, String published_by_license,
			Date acquisition_date, String id) {
		super();
		this.certificate_num = certificate_num;
		this.certificate_name = certificate_name;
		this.published_by_license = published_by_license;
		this.acquisition_date = acquisition_date;
		this.id = id;
	}

	public String getCertificate_num() {
		return certificate_num;
	}

	public void setCertificate_num(String certificate_num) {
		this.certificate_num = certificate_num;
	}

	public String getCertificate_name() {
		return certificate_name;
	}

	public void setCertificate_name(String certificate_name) {
		this.certificate_name = certificate_name;
	}

	public String getPublished_by_license() {
		return published_by_license;
	}

	public void setPublished_by_license(String published_by_license) {
		this.published_by_license = published_by_license;
	}

	public Date getAcquisition_date() {
		return acquisition_date;
	}

	public void setAcquisition_date(Date acquisition_date) {
		this.acquisition_date = acquisition_date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "CertificateVO [certificate_num=" + certificate_num + ", certificate_name=" + certificate_name
				+ ", published_by_license=" + published_by_license + ", acquisition_date=" + acquisition_date + ", id="
				+ id + "]";
	}
}
