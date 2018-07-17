package com.inturn.biz.board.service;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inturn.biz.board.dao.FileDAO;
import com.inturn.biz.board.dao.MenteeBoardDAO;
import com.inturn.biz.board.dao.ReplyDAO;
import com.inturn.biz.board.vo.MenteeBoardVO;

@Service("MenteeBoardService")
public class MenteeBoardServiceImpl implements MenteeBoardService{

	@Resource(name = "MenteeBoardDAO")
	MenteeBoardDAO tb_dao;
	@Resource(name = "FileDAO")
	FileDAO file_dao;
	@Resource(name = "ReplyDAO")
	ReplyDAO reply_dao;
	
	@Override
	public HashMap<String, Object> boardList(int page_num) {
		return null;
	}

	@Override
	public HashMap<String, Object> scBoardList(String condition, String search, int page_num) {
		return null;
	}

	@Override
	public HashMap<String, Object> viewBoard(int tb_num) {
		return null;
	}

	@Override
	public HashMap<String, Object> scViewBoard(String condition, String search, int tb_num) {
		return null;
	}

	@Override
	public int countBoards() {
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

}
