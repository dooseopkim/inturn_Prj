package com.inturn.biz.board.vo;

import java.util.Date;

public class CsBoardVO {
	private int cs_num;    		//INT           NOT NULL COMMENT 'cs_num', -- cs_num
	private int grpno;      	//INT           NULL     COMMENT 'grpno', -- grpno
	private int grpord;     	//INT           NULL     COMMENT 'grpord', -- grpord
	private int dept;       	//INT           NULL     COMMENT 'dept', -- dept
	private String title;      	//VARCHAR(200)  NULL     COMMENT 'title', -- title
	private String content;    	//VARCHAR(1000) NULL     COMMENT 'content', -- content
	private Date regDate;    	//DATE          NULL     COMMENT 'regDate', -- regDate
	private String makePublic; 	//VARCHAR(10)   NULL     COMMENT 'makePublic', -- makePublic
	private String pw;         	//VARCHAR(50)   NULL     COMMENT 'pw', -- pw
	private int hit;		 		//INT		   NULL     COMMENT 'hit', -- hit
	private String id;         	//VARCHAR(30)   NULL     COMMENT 'id' -- id

	
	

	
	public CsBoardVO(int cs_num, int grpno, int grpord, int dept, String title, String content, Date regDate,
			String makePublic, String pw, int hit, String id) {
		this.cs_num = cs_num;
		this.grpno = grpno;
		this.grpord = grpord;
		this.dept = dept;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.makePublic = makePublic;
		this.pw = pw;
		this.hit = hit;
		this.id = id;
	}

	public int getCs_num() {
		return cs_num;
	}

	public void setCs_num(int cs_num) {
		this.cs_num = cs_num;
	}

	public int getGrpno() {
		return grpno;
	}

	public void setGrpno(int grpno) {
		this.grpno = grpno;
	}

	public int getGrpord() {
		return grpord;
	}

	public void setGrpord(int grpord) {
		this.grpord = grpord;
	}

	public int getDept() {
		return dept;
	}

	public void setDept(int dept) {
		this.dept = dept;
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

	public String getMakePublic() {
		return makePublic;
	}

	public void setMakePublic(String makePublic) {
		this.makePublic = makePublic;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
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
		return "CsBoardVO [cs_num=" + cs_num + ", grpno=" + grpno + ", grpord=" + grpord + ", dept=" + dept + ", title="
				+ title + ", content=" + content + ", regDate=" + regDate + ", makePublic=" + makePublic + ", pw=" + pw
				+ ", hit=" + hit + ", id=" + id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + cs_num;
		result = prime * result + dept;
		result = prime * result + grpno;
		result = prime * result + grpord;
		result = prime * result + hit;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((makePublic == null) ? 0 : makePublic.hashCode());
		result = prime * result + ((pw == null) ? 0 : pw.hashCode());
		result = prime * result + ((regDate == null) ? 0 : regDate.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CsBoardVO other = (CsBoardVO) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (cs_num != other.cs_num)
			return false;
		if (dept != other.dept)
			return false;
		if (grpno != other.grpno)
			return false;
		if (grpord != other.grpord)
			return false;
		if (hit != other.hit)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (makePublic == null) {
			if (other.makePublic != null)
				return false;
		} else if (!makePublic.equals(other.makePublic))
			return false;
		if (pw == null) {
			if (other.pw != null)
				return false;
		} else if (!pw.equals(other.pw))
			return false;
		if (regDate == null) {
			if (other.regDate != null)
				return false;
		} else if (!regDate.equals(other.regDate))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

		
}
