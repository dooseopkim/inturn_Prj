package com.inturn.biz.users.vo;

import java.sql.Date;

public class UserVO {
	private String id;
	private String pw;
	private String name;
	private String phone;
	private Date birthday;
	private String type;
	
	public UserVO() {
	}

	public UserVO(String id, String pw, String name, String phone, Date birthday, String type) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.birthday = birthday;
		this.type = type;
	}

	public UserVO(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone + ", birthday=" + birthday
				+ ", type=" + type + "]";
	}
}
