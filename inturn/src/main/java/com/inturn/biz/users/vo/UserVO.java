package com.inturn.biz.users.vo;

import java.sql.Date;

public class UserVO {
	private String id;
	private String pw;
	private String name;
	private String phone;
	private String email;
	private Date birthday;
	private String type;
	private int idx;
	private int icon_num;
	
	public UserVO() {
	}
	
	/**
	 * 아이콘을 추가하지 않은 회원가입
	 * @param id
	 * @param pw
	 * @param name
	 * @param phone
	 * @param email
	 * @param birthday
	 * @param type
	 * @param idx
	 */
	public UserVO(String id, String pw, String name, String phone, String email, Date birthday, String type, int idx) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.birthday = birthday;
		this.type = type;
		this.idx = idx;
	}

	/**
	 * 아이콘을 추가한 회원가입
	 * @param id
	 * @param pw
	 * @param name
	 * @param phone
	 * @param email
	 * @param birthday
	 * @param type
	 * @param idx
	 * @param icon_num
	 */
	public UserVO(String id, String pw, String name, String phone, String email, Date birthday, String type, int idx,
			int icon_num) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.birthday = birthday;
		this.type = type;
		this.idx = idx;
		this.icon_num = icon_num;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getIcon_num() {
		return icon_num;
	}

	public void setIcon_num(int icon_num) {
		this.icon_num = icon_num;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone + ", email=" + email
				+ ", birthday=" + birthday + ", type=" + type + ", idx=" + idx + ", icon_num=" + icon_num + "]";
	}

}
