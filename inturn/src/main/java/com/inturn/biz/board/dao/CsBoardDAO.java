package com.inturn.biz.board.dao;

import java.util.HashMap;
import java.util.List;

import com.inturn.biz.board.vo.CsBoardVO;

public interface CsBoardDAO {
	public List<CsBoardVO> boardList(HashMap<String, Integer> map);
	public List<CsBoardVO> scBoardList(HashMap<String, Object> map);
	public CsBoardVO viewBoard(int cs_num);
	public int countBoards();
	public int scCountBoards(String condition, String search);
	public int findBoard(CsBoardVO vo);
	public int insertCsBoard(CsBoardVO vo);
	public int modifyCsBoard(CsBoardVO vo);
	public int deleteCsBoard(int cs_num);
	public int countUp(int cs_num);
	public int prevcs_num(int cs_num);
	public int nextcs_num(int cs_num);
	public int scPrevcs_num(String condition, String search, int cs_num);
	public int scNextcs_num(String condition, String search, int cs_num);
}
