package com.inturn.biz.board.vo;

import java.sql.Date;

public class MenteeBoardVO {
	private int tb_num;
	private String title;
	private String content;
	private Date regDate;
	private String id;
	
	public MenteeBoardVO() {
	}
	
	public MenteeBoardVO(int tb_num, String title, String content, Date regDate, String id) {
		this.tb_num = tb_num;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.id = id;
	}
	
	public MenteeBoardVO(int tb_num, String title, String id) {
		super();
		this.tb_num = tb_num;
		this.title = title;
		this.id = id;
	}
	
	public MenteeBoardVO(String title, String content, Date regDate, String id) {
		super();
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.id = id;
	}

	public MenteeBoardVO(int tb_num, String title, String content, String id) {
		super();
		this.tb_num = tb_num;
		this.title = title;
		this.content = content;
		this.id = id;
	}

	public int getTb_num() {
		return tb_num;
	}

	public void setTb_num(int tb_num) {
		this.tb_num = tb_num;
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
		return "MenteeBoardVO [tb_num=" + tb_num + ", title=" + title + ", content=" + content + ", regDate=" + regDate
				+ ", id=" + id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((regDate == null) ? 0 : regDate.hashCode());
		result = prime * result + tb_num;
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
		MenteeBoardVO other = (MenteeBoardVO) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (regDate == null) {
			if (other.regDate != null)
				return false;
		} else if (!regDate.equals(other.regDate))
			return false;
		if (tb_num != other.tb_num)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	
}
