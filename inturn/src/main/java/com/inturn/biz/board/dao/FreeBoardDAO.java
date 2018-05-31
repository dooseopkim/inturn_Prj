package com.inturn.biz.board.dao;

import java.util.HashMap;
import java.util.List;

import com.inturn.biz.board.vo.FreeBoardVO;

public interface FreeBoardDAO {
	public List<FreeBoardVO> boardList(HashMap<String, Integer> map);
	public List<FreeBoardVO> scBoardList(HashMap<String, Object> map);
	public FreeBoardVO viewBoard(int fb_num);
	public int countBoards();
	public int scCountBoards(String condition, String search);
	public int findBoard(FreeBoardVO vo);
	public int insertFreeBoard(FreeBoardVO vo);
	public int modifyFreeBoard(FreeBoardVO vo);
	public int deleteFreeBoard(int fb_num);
	public int countUp(int fb_num);
	public int prevfb_num(int fb_num);
	public int nextfb_num(int fb_num);
	public int scPrevfb_num(String condition, String search, int fb_num);
	public int scNextfb_num(String condition, String search, int fb_num);
}
