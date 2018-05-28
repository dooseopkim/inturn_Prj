package com.inturn.biz.board.service;

import com.inturn.biz.board.vo.FileGroupVO;
import com.inturn.biz.board.vo.FilesVO;

public interface FileService {
	public int findFileGroup(String flag);
	public int insertFiles(String flag, FilesVO vo);
	public int update_CB_FileGroup(FileGroupVO vo);
	public int update_FB_FileGroup(FileGroupVO vo);
	public int insertBoard(String flag);
	public int delete_CB_FileGroup(int cb_num);
	public int delete_FB_FileGroup(int fb_num);
	public int deleteFileGroup(int fileGroupNum);
	public int findFile(FilesVO vo);
	public int deleteFile(int fileGroupNum);
	public int cancel_insertBoard(String flag);
}
