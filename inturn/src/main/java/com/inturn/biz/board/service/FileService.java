package com.inturn.biz.board.service;

import com.inturn.biz.board.vo.FileGroupVO;
import com.inturn.biz.board.vo.FilesVO;

public interface FileService {
	public int findFileGroup(String flag);
	public int insertFiles(String flag, FilesVO vo);
	public int insert_CB_files(FileGroupVO vo);
	public int insert_FB_files(FileGroupVO vo);
	public int delete_CB_Files(int cb_num);
	public int delete_FB_Files(int fb_num);
	public int findFile(FilesVO vo);
	public int deleteFile(int fileGroupNum);
}
