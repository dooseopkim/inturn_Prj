package com.inturn.biz.board.dao;

import java.util.HashMap;
import java.util.List;

import com.inturn.biz.board.vo.MenteeBoardVO;

public interface MenteeBoardDAO {
	public List<MenteeBoardVO> boardList(HashMap<String, Integer> map);
	public List<MenteeBoardVO> scBoardList(HashMap<String, Object> map);
	public MenteeBoardVO viewBoard(int tb_num);
	public int countBoards();
	public int scCountBoards(String condition, String search);
	public int findBoard(MenteeBoardVO vo);
	public int insertMenteeBoard(MenteeBoardVO vo);
	public int modifyMenteeBoard(MenteeBoardVO vo);
	public int deleteMenteeBoard(int tb_num);
	public int countUp(int tb_num);
	public int prevtb_num(int tb_num);
	public int nexttb_num(int tb_num);
	public int scPrevtb_num(String condition, String search, int tb_num);
	public int scNexttb_num(String condition, String search, int tb_num);
}
