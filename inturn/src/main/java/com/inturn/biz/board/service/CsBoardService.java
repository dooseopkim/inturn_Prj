package com.inturn.biz.board.service;

import java.util.HashMap;

import com.inturn.biz.board.vo.CsBoardVO;

public interface CsBoardService {
	public HashMap<String, Object> boardList(int page_num);
	public HashMap<String, Object> scBoardList(String condition, String search, int page_num);
	public HashMap<String, Object> viewBoard(int cs_num);
	public HashMap<String, Object> scViewBoard(String condition, String search, int cs_num);
	public int countBoards();
	public int findBoard(CsBoardVO vo);
	public int insertCsBoard(CsBoardVO vo);
	public int modifyCsBoard(CsBoardVO vo);
	public int deleteCsBoard(int cs_num);
}
