package com.inturn.biz.board.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inturn.biz.board.dao.MentorBoardDAO;
import com.inturn.biz.board.vo.MentorBoardVO;

@Service("MentorBoardService")
public class MentorBoardServiceImpl implements MentorBoardService{
	@Resource(name="MentorBoardDAO")
	MentorBoardDAO mb_dao;
	
	@Override
	public List<MentorBoardVO> mentorBoardList(HashMap<String, Object> map) {
		return mb_dao.mentorBoardList(map);
	}

	@Override
	public List<MentorBoardVO> searchMentorBoardList(HashMap<String, Object> map) {
		return mb_dao.searchMentorBoardList(map);
	}

	@Override
	public int getCntMentorBoard() {
		System.out.println("serviceImpl getCntMentorBoard() 진입");
		return mb_dao.getCntMentorBoard();
	}

	@Override
	public int getSearchCntMentorBoard(HashMap<String, Object> map) {
		return mb_dao.getSearchCntMentorBoard(map);
	}

	@Override
	public int prevMb_num(int mb_num) {
		return mb_dao.prevMb_num(mb_num);
	}

	@Override
	public int nextMb_num(int mb_num) {
		return mb_dao.nextMb_num(mb_num);
	}

	@Override
	public int scPrevMb_num(HashMap<String, Object> map) {
		return mb_dao.scPrevMb_num(map);
	}

	@Override
	public int scNextMb_num(HashMap<String, Object> map) {
		return mb_dao.scNextMb_num(map);
	}
	
	@Override
	public MentorBoardVO viewMentorBoard(int mb_num) {
		return mb_dao.viewMentorBoard(mb_num);
	}

	@Override
	public int insertMentorBoard(MentorBoardVO vo) {
		return mb_dao.insertMentorBoard(vo);
	}

	@Override
	public int modifyMentorBoard(MentorBoardVO vo) {
		return mb_dao.modifyMentorBoard(vo);
	}

	@Override
	public int deleteMentorBoard(int mb_num) {
		return mb_dao.deleteMentorBoard(mb_num);
	}
	
}
