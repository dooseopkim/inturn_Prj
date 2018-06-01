package com.inturn.biz.board.service;

import java.util.HashMap;

import com.inturn.biz.board.vo.FreeBoardVO;

public interface MentorBoardService {
	public HashMap<String, Object> MentorBbsList(int page_num);
	public HashMap<String, Object> scBoardList(String condition, String search, int page_num);
	public HashMap<String, Object> viewBoard(int mb_num);
	public HashMap<String, Object> scViewBoard(String condition, String search, int fb_num);
	public int countBoards();
	public int findBoard(FreeBoardVO vo);
	public int insertFreeBoard(FreeBoardVO vo);
	public int modifyFreeBoard(FreeBoardVO vo);
	public int deleteFreeBoard(int fb_num);
}
