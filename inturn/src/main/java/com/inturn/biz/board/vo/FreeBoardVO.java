package com.inturn.biz.board.vo;

import java.sql.Date;

public class FreeBoardVO {
	private int fb_num;
	private String title;
	private String content;
	private Date regDate;
	private int hit;
	private String id;
	
	public FreeBoardVO() {
		super();
	}

	public FreeBoardVO(int fb_num, String title, String content, Date regDate, int hit, String id) {
		super();
		this.fb_num = fb_num;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.hit = hit;
		this.id = id;
	}

	public FreeBoardVO(String title, String content, Date regDate, int hit, String id) {
		super();
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.hit = hit;
		this.id = id;
	}

	public int getFb_num() {
		return fb_num;
	}

	public void setFb_num(int fb_num) {
		this.fb_num = fb_num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "FreeBoardVO [fb_num=" + fb_num + ", title=" + title + ", content=" + content + ", regDate=" + regDate
				+ ", hit=" + hit + ", id=" + id + "]";
	}
}
