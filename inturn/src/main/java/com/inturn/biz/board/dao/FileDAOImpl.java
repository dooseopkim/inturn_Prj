package com.inturn.biz.board.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inturn.biz.board.vo.FileGroupVO;
import com.inturn.biz.board.vo.FilesVO;

@Repository("FileDAO")
public class FileDAOImpl implements FileDAO{
	@Autowired
	SqlSessionTemplate mybatis;

	@Override
	public int findFileGroup(String flag) {
		return mybatis.selectOne("FileMapper.findFileGroup", flag);
	}
	@Override
	public int insertFileGroup(String flag) {
		return mybatis.insert("FileMapper.insertFileGroup", flag);
	}

	@Override
	public int insert_CB_files(FileGroupVO vo) {
		return mybatis.update("FileMapper.insert_CB_files", vo);
	}

	@Override
	public int insert_FB_files(FileGroupVO vo) {
		return mybatis.update("FileMapper.insert_FB_files", vo);
	}
	@Override
	public int delete_CB_Files(int cb_num) {
		return mybatis.delete("FileMapper.delete_CB_Files", cb_num);
	}

	@Override
	public int delete_FB_Files(int fb_num) {
		return mybatis.delete("FileMapper.delete_FB_Files", fb_num);
	}

	@Override
	public int findFile(FilesVO vo) {
		return mybatis.selectOne("FileMapper.findFile",vo);
	}
	
	@Override
	public int insertFile(FilesVO vo) {
		return mybatis.insert("FileMapper.insertFile", vo);
	}

	@Override
	public int deleteFile(int fileGroupNum) {
		return mybatis.delete("FileMapper.deleteFile", fileGroupNum);
	}
	@Override
	public int insertBoard(String flag) {
		return mybatis.update("FileMapper.insertBoard",flag);
	}
	@Override
	public int deleteFileGroup(int fileGroupNum) {
		return mybatis.delete("FileMapper.deleteFileGroup", fileGroupNum);
	}
}
