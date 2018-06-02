package com.inturn.biz.board.dao;

import java.util.HashMap;
import java.util.List;

import com.inturn.biz.board.vo.QnABoardVO;

public interface QnQBoardDAO {
	public List<QnABoardVO> boardList(HashMap<String, Integer> map);
	public List<QnABoardVO> scBoardList(HashMap<String, Object> map);
	public QnABoardVO viewBoard(int fb_num);
	public int countBoards();
	public int scCountBoards(String condition, String search);
	public int findBoard(QnABoardVO vo);
	public int insertQnABoard(QnABoardVO vo);
	public int modifyQnABoard(QnABoardVO vo);
	public int deleteQnABoard(int fb_num);
	public int countUp(int fb_num);
	public int prevfb_num(int fb_num);
	public int nextfb_num(int fb_num);
	public int scPrevfb_num(String condition, String search, int fb_num);
	public int scNextfb_num(String condition, String search, int fb_num);
}
