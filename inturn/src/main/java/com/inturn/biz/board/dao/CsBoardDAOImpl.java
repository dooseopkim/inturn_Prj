package com.inturn.biz.board.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inturn.biz.board.vo.CsBoardVO;

@Repository("CsBoardDAO")
public class CsBoardDAOImpl implements CsBoardDAO{
	@Autowired
	SqlSessionTemplate mybatis;

	@Override
	public List<CsBoardVO> boardList(HashMap<String, Integer> map) {
		return mybatis.selectList("CsBoardMapper.boardList",map);
	}

	@Override
	public List<CsBoardVO> scBoardList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CsBoardVO viewBoard(int cs_num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countBoards() {
		return mybatis.selectOne("CsBoardMapper.countBoards");
	}

	@Override
	public int scCountBoards(String condition, String search) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int findBoard(CsBoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertCsBoard(CsBoardVO vo) {
		System.out.println("insertCsBoard 디에이오임플 거쳐가여");
		return mybatis.insert("CsBoardMapper.insertCsBoard",vo);
	}

	@Override
	public int modifyCsBoard(CsBoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCsBoard(int cs_num) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int countUp(int cs_num) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int prevcs_num(int cs_num) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int nextcs_num(int cs_num) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int scPrevcs_num(String condition, String search, int cs_num) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int scNextcs_num(String condition, String search, int cs_num) {
		// TODO Auto-generated method stub
		return 0;
	}



}
