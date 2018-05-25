package com.inturn.biz.board.service;

import java.util.HashMap;

import com.inturn.biz.board.vo.FreeBoardVO;

public interface FreeBoardService {
	public HashMap<String,Object> boardList(int page_num);
	public int countBoards();
	public int findBoard(FreeBoardVO vo);
	public int insertFreeBoard(FreeBoardVO vo);
	public int modifyFreeBoard(FreeBoardVO vo);
	public int deleteFreeBoard(int fb_num);
}
