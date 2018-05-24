package com.inturn.biz.board.vo;

public class FileGroupVO {
	private int fileGroupNum;
	private String flag;
	private int fb_num;
	private int cb_num;
	
	public FileGroupVO() {
		super();
	}

	public FileGroupVO(int fileGroupNum, String flag, int fb_num, int cb_num) {
		super();
		this.fileGroupNum = fileGroupNum;
		this.flag = flag;
		this.fb_num = fb_num;
		this.cb_num = cb_num;
	}

	public int getFileGroupNum() {
		return fileGroupNum;
	}

	public void setFileGroupNum(int fileGroupNum) {
		this.fileGroupNum = fileGroupNum;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
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

	@Override
	public String toString() {
		return "FileGroupVO [fileGroupNum=" + fileGroupNum + ", flag=" + flag + ", fb_num=" + fb_num + ", cb_num="
				+ cb_num + "]";
	}
}
