package com.inturn.biz.board.vo;

import java.sql.Date;

public class FilesVO {
	private int fileGroupNum;
	private int file_num;
	private String filePath;
	private String fileName;
	private int fileSize;
	private String fileHash;
	private Date regDate;
	
	public FilesVO() {
		super();
	}

	public FilesVO(String filePath, String fileName, int fileSize, String fileHash) {
		super();
		this.filePath = filePath;
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.fileHash = fileHash;
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

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
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

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "FilesVO [fileGroupNum=" + fileGroupNum + ", file_num=" + file_num + ", filePath=" + filePath
				+ ", fileName=" + fileName + ", fileSize=" + fileSize + ", fileHash=" + fileHash + ", regDate=" + regDate + "]";
	}
}
