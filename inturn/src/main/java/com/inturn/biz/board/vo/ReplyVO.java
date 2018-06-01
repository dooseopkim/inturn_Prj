package com.inturn.biz.board.vo;

import java.sql.Date;

public class ReplyVO {
	private int rp_num;
	private int fb_num;
	private int cb_num;
	private String content;
	private Date regDate;
	private int parentNum;
	private int position;
	private String id;

	public ReplyVO() {
	}

	public ReplyVO(int rp_num, int fb_num, int cb_num, String content, Date regDate, int parentNum, int position,
			String id) {
		this.rp_num = rp_num;
		this.fb_num = fb_num;
		this.cb_num = cb_num;
		this.content = content;
		this.regDate = regDate;
		this.parentNum = parentNum;
		this.position = position;
		this.id = id;
	}

	public int getRp_num() {
		return rp_num;
	}

	public void setRp_num(int rp_num) {
		this.rp_num = rp_num;
	}

	public int getFb_num() {
		return fb_num;
	}

	public void setFb_num(int fb_num) {
		this.fb_num = fb_num;
	}

	public int getCb_num() {
		return cb_num;
	}

	public void setCb_num(int cb_num) {
		this.cb_num = cb_num;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getParentNum() {
		return parentNum;
	}

	public void setParentNum(int parentNum) {
		this.parentNum = parentNum;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ReplyVO [rp_num=" + rp_num + ", fb_num=" + fb_num + ", cb_num=" + cb_num + ", content=" + content
				+ ", regDate=" + regDate + ", parentNum=" + parentNum + ", position=" + position + ", id=" + id + "]";
	}
}
