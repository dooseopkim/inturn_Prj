package com.inturn.biz.board.vo;

import java.sql.Date;

public class FilesVO {
	private int fileGroupNum;
	private int file_num;
	private String original_name;
	private String fileName;
	private int fileSize;
	private String fileHash;
	private String fileExtension;
	private Date regDate;
	
	public FilesVO() {
		super();
	}

	public FilesVO(int fileGroupNum, int file_num, String original_name, String fileName, int fileSize, String fileHash,
			String fileExtension, Date regDate) {
		super();
		this.fileGroupNum = fileGroupNum;
		this.file_num = file_num;
		this.original_name = original_name;
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.fileHash = fileHash;
		this.fileExtension = fileExtension;
		this.regDate = regDate;
	}

	public int getFileGroupNum() {
		return fileGroupNum;
	}

	public void setFileGroupNum(int fileGroupNum) {
		this.fileGroupNum = fileGroupNum;
	}

	public int getFile_num() {
		return file_num;
	}

	public void setFile_num(int file_num) {
		this.file_num = file_num;
	}

	public String getOriginal_name() {
		return original_name;
	}

	public void setOriginal_name(String original_name) {
		this.original_name = original_name;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileHash() {
		return fileHash;
	}

	public void setFileHash(String fileHash) {
		this.fileHash = fileHash;
	}

	public String getFileExtension() {
		return fileExtension;
	}

	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "FilesVO [fileGroupNum=" + fileGroupNum + ", file_num=" + file_num + ", original_name=" + original_name
				+ ", fileName=" + fileName + ", fileSize=" + fileSize + ", fileHash=" + fileHash + ", fileExtension="
				+ fileExtension + ", regDate=" + regDate + "]";
	}
}
