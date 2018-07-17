package com.inturn.biz.board.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inturn.biz.board.vo.MenteeBoardVO;

@Repository("MenteeBoardDAO")
public class MenteeBoardDAOImple implements MenteeBoardDAO{

	@Autowired
	SqlSessionTemplate mybatis;
	
	@Override
	public List<MenteeBoardVO> boardList(HashMap<String, Integer> map) {
		return null;
	}

	@Override
	public List<MenteeBoardVO> scBoardList(HashMap<String, Object> map) {
		return null;
	}

	@Override
	public MenteeBoardVO viewBoard(int tb_num) {
		return null;
	}

	@Override
	public int countBoards() {
		return 0;
	}

	@Override
	public int scCountBoards(String condition, String search) {
		return 0;
	}

	@Override
	public int findBoard(MenteeBoardVO vo) {
		return 0;
	}

	@Override
	public int insertMenteeBoard(MenteeBoardVO vo) {
		return 0;
	}

	@Override
	public int modifyMenteeBoard(MenteeBoardVO vo) {
		return 0;
	}

	@Override
	public int deleteMenteeBoard(int tb_num) {
		return 0;
	}

	@Override
	public int countUp(int tb_num) {
		return 0;
	}

	@Override
	public int prevtb_num(int tb_num) {
		return 0;
	}

	@Override
	public int nexttb_num(int tb_num) {
		return 0;
	}

	@Override
	public int scPrevtb_num(String condition, String search, int tb_num) {
		return 0;
	}

	@Override
	public int scNexttb_num(String condition, String search, int tb_num) {
		return 0;
	}

}
