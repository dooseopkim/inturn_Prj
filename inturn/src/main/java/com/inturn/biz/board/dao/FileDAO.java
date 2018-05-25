package com.inturn.biz.board.dao;

import com.inturn.biz.board.vo.FileGroupVO;
import com.inturn.biz.board.vo.FilesVO;

public interface FileDAO {
	public int findFileGroup(String flag);
	public int insertFileGroup(String flag);
	public int insert_CB_files(FileGroupVO vo);
	public int insert_FB_files(FileGroupVO vo);
	public int insertBoard(String flag);
	public int delete_CB_Files(int cb_num);
	public int delete_FB_Files(int fb_num);
	public int findFile(FilesVO vo);
	public int insertFile(FilesVO vo);
	public int deleteFile(int fileGroupNum);
}
