package com.inturn.biz.users.vo;

import java.sql.Date;

public class CareerVO {
	private int num;
	private String company_num;
	private String dept_name;
	private Date indate;
	private Date outdate;
	private String id;
	public CareerVO(int num, String company_num, String dept_name, Date indate, Date outdate, String id) {
		super();
		this.num = num;
		this.company_num = company_num;
		this.dept_name = dept_name;
		this.indate = indate;
		this.outdate = outdate;
		this.id = id;
	}
	public CareerVO() {
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getCompany_num() {
		return company_num;
	}
	public void setCompany_num(String company_num) {
		this.company_num = company_num;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public Date getIndate() {
		return indate;
	}
	public void setIndate(Date indate) {
		this.indate = indate;
	}
	public Date getOutdate() {
		return outdate;
	}
	public void setOutdate(Date outdate) {
		this.outdate = outdate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "CareerVO [num=" + num + ", company_num=" + company_num + ", dept_name=" + dept_name + ", indate="
				+ indate + ", outdate=" + outdate + ", id=" + id + "]";
	}
	
}
