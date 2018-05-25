package com.inturn.biz.board.dao;

import java.util.HashMap;
import java.util.List;

import com.inturn.biz.board.vo.FreeBoardVO;

public interface FreeBoardDAO {
	public List<FreeBoardVO> boardList(HashMap<String, Integer> map);
	public int countBoards();
	public int findBoard(FreeBoardVO vo);
	public int insertFreeBoard(FreeBoardVO vo);
	public int modifyFreeBoard(FreeBoardVO vo);
	public int deleteFreeBoard(int fb_num);
	
}
