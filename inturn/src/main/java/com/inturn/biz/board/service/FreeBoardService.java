package com.inturn.biz.board.service;

import java.util.List;

import com.inturn.biz.board.vo.FreeBoardVO;

public interface FreeBoardService {
	public List<FreeBoardVO> showFreeBoard();
	public int findBoard(FreeBoardVO vo);
	public int insertFreeBoard(FreeBoardVO vo);
	public int modifyFreeBoard(FreeBoardVO vo);
	public int deleteFreeBoard(int fb_num);
}
