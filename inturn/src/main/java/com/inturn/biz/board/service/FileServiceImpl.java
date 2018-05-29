package com.inturn.biz.board.service;

import java.sql.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.inturn.biz.board.dao.FileDAO;
import com.inturn.biz.board.vo.FileGroupVO;
import com.inturn.biz.board.vo.FilesVO;

@Service("FileService")
public class FileServiceImpl implements FileService{
	@Resource(name="FileDAO")
	FileDAO dao;

	@Override
	public int findFileGroup(String flag) {
		return dao.findFileGroup(flag);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int insertFiles(String flag, FilesVO vo) {
		int row = 0;
		int fileGroupNum = dao.findFileGroup(flag);
		if(fileGroupNum == 0)
			row += dao.insertFileGroup(flag);
		java.util.Date udate = new java.util.Date();
		Date regDate = new Date(udate.getTime());
		vo.setFileGroupNum(dao.findFileGroup(flag));
		vo.setRegDate(regDate);
		row += dao.insertFile(vo);
		return row;
	}

	@Override
	public int update_CB_FileGroup(FileGroupVO vo) {
		return dao.update_CB_FileGroup(vo);
	}

	@Override
	public int update_FB_FileGroup(FileGroupVO vo) {
		return dao.update_FB_FileGroup(vo);
	}
	
	@Override
	public int delete_CB_FileGroup(int cb_num) {
		return dao.delete_CB_FileGroup(cb_num);
	}

	@Override
	public int delete_FB_FileGroup(int fb_num) {
		return dao.delete_FB_FileGroup(fb_num);
	}

	@Override
	public int findFile(FilesVO vo) {
		return dao.findFile(vo);
	}
	
	@Override
	public int deleteFile(int fileGroupNum) {
		return dao.deleteFile(fileGroupNum);
	}

	@Override
	public int insertBoard(String flag) {
		return dao.insertBoard(flag);
	}

	@Override
	public int deleteFileGroup(int fileGroupNum) {
		return dao.deleteFileGroup(fileGroupNum);
	}
	
	@Override
	public int cancel_insertBoard(String flag) {
		int row = 0;
		int fileGroupNum = dao.findFileGroup(flag);
		row += dao.deleteFile(fileGroupNum);
		row += dao.deleteFileGroup(fileGroupNum);
		return row;
	}
}
