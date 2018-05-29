package com.inturn.biz.board.dao;

import java.util.HashMap;
import java.util.List;

import com.inturn.biz.board.vo.FileGroupVO;
import com.inturn.biz.board.vo.FilesVO;

public interface FileDAO {
	public int findFileGroup(String flag);
	public int findFileGroupNumMax(int fb_num);
	public int findFileGroupNumMin(int fb_num);
	public int insertFileGroup(String flag);
	public int update_CB_FileGroup(FileGroupVO vo);
	public int update_FB_FileGroup(FileGroupVO vo);
	public int insertBoard(String flag);
	public int delete_CB_FileGroup(int cb_num);
	public int delete_FB_FileGroup(int fb_num);
	public int deleteFileGroup(int fileGroupNum);
	public int findFile(FilesVO vo);
	public int insertFile(FilesVO vo);
	public int deleteFile(int fileGroupNum);
	public int modify_FB_files(HashMap<String, Integer> map);
	public int delete_FB_Files(int fb_num);
	public List<FilesVO> findFiles(int fileGroupNum);
}
