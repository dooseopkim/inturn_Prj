package com.inturn.biz.users.vo;

import java.sql.Date;

public class EducationalLevelVO {
	private int eduLevel_num;
	private String degree_level;
	private String school_name;
	private Date admission_date;
	private Date graduation_date;
	private String current_status;
	private String major;
	private double avg_score;
	private double total_score;
	private String id;
	
	public EducationalLevelVO() {
	}

	public EducationalLevelVO(int eduLevel_num, String degree_level, String school_name, Date admission_date,
			Date graduation_date, String current_status, String major, double avg_score, double total_score,
			String id) {
		super();
		this.eduLevel_num = eduLevel_num;
		this.degree_level = degree_level;
		this.school_name = school_name;
		this.admission_date = admission_date;
		this.graduation_date = graduation_date;
		this.current_status = current_status;
		this.major = major;
		this.avg_score = avg_score;
		this.total_score = total_score;
		this.id = id;
	}

	public int getEduLevel_num() {
		return eduLevel_num;
	}

	public void setEduLevel_num(int eduLevel_num) {
		this.eduLevel_num = eduLevel_num;
	}

	public String getDegree_level() {
		return degree_level;
	}

	public void setDegree_level(String degree_level) {
		this.degree_level = degree_level;
	}

	public String getSchool_name() {
		return school_name;
	}

	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}

	public Date getAdmission_date() {
		return admission_date;
	}

	public void setAdmission_date(Date admission_date) {
		this.admission_date = admission_date;
	}

	public Date getGraduation_date() {
		return graduation_date;
	}

	public void setGraduation_date(Date graduation_date) {
		this.graduation_date = graduation_date;
	}

	public String getCurrent_status() {
		return current_status;
	}

	public void setCurrent_status(String current_status) {
		this.current_status = current_status;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public double getAvg_score() {
		return avg_score;
	}

	public void setAvg_score(double avg_score) {
		this.avg_score = avg_score;
	}

	public double getTotal_score() {
		return total_score;
	}

	public void setTotal_score(double total_score) {
		this.total_score = total_score;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "EducationalLevelVO [eduLevel_num=" + eduLevel_num + ", degree_level=" + degree_level + ", school_name="
				+ school_name + ", admission_date=" + admission_date + ", graduation_date=" + graduation_date
				+ ", current_status=" + current_status + ", major=" + major + ", avg_score=" + avg_score
				+ ", total_score=" + total_score + ", id=" + id + "]";
	}
	
	
	
	
	
}

