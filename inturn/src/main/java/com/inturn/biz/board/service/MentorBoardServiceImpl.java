package com.inturn.biz.board.service;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inturn.biz.board.dao.MentorBoardDAO;
import com.inturn.biz.board.vo.FreeBoardVO;

@Service("MentorBoardService")
public class MentorBoardServiceImpl implements MentorBoardService{
	@Resource(name="MentorBoardDAO")
	MentorBoardDAO dao;

	@Override
	public HashMap<String, Object> MentorBbsList(int page_num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, Object> scBoardList(String condition, String search, int page_num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, Object> viewBoard(int mb_num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, Object> scViewBoard(String condition, String search, int fb_num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countBoards() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int findBoard(FreeBoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertFreeBoard(FreeBoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyFreeBoard(FreeBoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteFreeBoard(int fb_num) {
		// TODO Auto-generated method stub
		return 0;
	}
}
