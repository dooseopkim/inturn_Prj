package com.inturn.biz.board.dao;

import java.util.HashMap;
import java.util.List;

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
	public int update_CB_FileGroup(FileGroupVO vo) {
		return mybatis.update("FileMapper.update_CB_FileGroup", vo);
	}

	@Override
	public int update_FB_FileGroup(FileGroupVO vo) {
		return mybatis.update("FileMapper.update_FB_FileGroup", vo);
	}
	@Override
	public int delete_CB_FileGroup(int cb_num) {
		return mybatis.delete("FileMapper.delete_CB_FileGroup", cb_num);
	}

	@Override
	public int delete_FB_FileGroup(int fb_num) {
		return mybatis.delete("FileMapper.delete_FB_FileGroup", fb_num);
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
	@Override
	public int findFileGroupNumMax(int fb_num) {
		return mybatis.selectOne("FileMapper.findFileGroupNumMax", fb_num);
	}
	@Override
	public int findFileGroupNumMin(int fb_num) {
		return mybatis.selectOne("FileMapper.findFileGroupNumMin", fb_num);
	}
	@Override
	public int modify_FB_files(HashMap<String, Integer> map) {
		return mybatis.update("FileMapper.modify_FB_files", map);
	}
	@Override
	public int delete_FB_Files(int fb_num) {
		return mybatis.delete("FileMapper.delete_FB_Files", fb_num);
	}
	@Override
	public List<FilesVO> findFiles(int fileGroupNum) {
		return mybatis.selectList("FileMapper.findFiles", fileGroupNum);
	}
}
