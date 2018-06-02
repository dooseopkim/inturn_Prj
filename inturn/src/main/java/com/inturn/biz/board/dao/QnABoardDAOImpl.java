package com.inturn.biz.board.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inturn.biz.board.vo.QnABoardVO;

@Repository("CsBoardDAO")
public class QnABoardDAOImpl implements QnQBoardDAO{
	@Autowired
	SqlSessionTemplate mybatis;

	@Override
	public List<QnABoardVO> boardList(HashMap<String, Integer> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<QnABoardVO> scBoardList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QnABoardVO viewBoard(int fb_num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countBoards() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int scCountBoards(String condition, String search) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int findBoard(QnABoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertQnABoard(QnABoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyQnABoard(QnABoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteQnABoard(int fb_num) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int countUp(int fb_num) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int prevfb_num(int fb_num) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int nextfb_num(int fb_num) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int scPrevfb_num(String condition, String search, int fb_num) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int scNextfb_num(String condition, String search, int fb_num) {
		// TODO Auto-generated method stub
		return 0;
	}
}
