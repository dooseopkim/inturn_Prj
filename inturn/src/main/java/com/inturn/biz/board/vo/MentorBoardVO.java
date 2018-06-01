package com.inturn.biz.board.vo;

import java.sql.Date;

public class MentorBoardVO {
	private int mb_num;
	private String title;
	private String content;
	private Date regDate;
	private String id;
	
	public MentorBoardVO() {
	}

	public MentorBoardVO(int mb_num, String title, String content, Date regDate, String id) {
		super();
		this.mb_num = mb_num;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.id = id;
	}

	public int getMb_num() {
		return mb_num;
	}

	public void setMb_num(int mb_num) {
		this.mb_num = mb_num;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "MentorBoardVO [mb_num=" + mb_num + ", title=" + title + ", content=" + content + ", regDate=" + regDate
				+ ", id=" + id + "]";
	}

}
