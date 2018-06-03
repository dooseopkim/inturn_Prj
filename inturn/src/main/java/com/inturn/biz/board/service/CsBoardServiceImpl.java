package com.inturn.biz.board.service;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inturn.biz.board.dao.CsBoardDAO;
import com.inturn.biz.board.vo.CsBoardVO;
import com.inturn.biz.board.vo.FreeBoardVO;

@Service("CsBoardService")
public class CsBoardServiceImpl implements CsBoardService{
	@Resource(name="CsBoardDAO")
	CsBoardDAO dao;

	@Override
	public HashMap<String, Object> boardList(int page_num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, Object> scBoardList(String condition, String search, int page_num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, Object> viewBoard(int cs_num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, Object> scViewBoard(String condition, String search, int cs_num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countBoards() {
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
		// TODO Auto-generated method stub
		return 0;
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
	
}
