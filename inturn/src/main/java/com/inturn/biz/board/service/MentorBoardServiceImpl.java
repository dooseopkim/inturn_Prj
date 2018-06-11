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
	MentorBoardDAO dao;
	
	@Override
	public List<MentorBoardVO> mentorBoardList(HashMap<String, Object> map) {
		return dao.mentorBoardList(map);
	}

	@Override
	public List<MentorBoardVO> searchMentorBoardList(HashMap<String, Object> map) {
		return dao.searchMentorBoardList(map);
	}

	@Override
	public int getCntMentorBoard() {
		return dao.getCntMentorBoard();
	}

	@Override
	public int getSearchCntMentorBoard(HashMap<String, Object> map) {
		return dao.getSearchCntMentorBoard(map);
	}

	@Override
	public int prevMb_num(int mb_num) {
		return dao.prevMb_num(mb_num);
	}

	@Override
	public int nextMb_num(int mb_num) {
		return dao.nextMb_num(mb_num);
	}

	@Override
	public int scPrevMb_num(HashMap<String, Object> map) {
		return dao.scPrevMb_num(map);
	}

	@Override
	public int scNextMb_num(HashMap<String, Object> map) {
		return dao.scNextMb_num(map);
	}
	
	@Override
	public MentorBoardVO viewMentorBoard(int mb_num) {
		return dao.viewMentorBoard(mb_num);
	}

	@Override
	public int insertMentorBoard(MentorBoardVO vo) {
		return dao.insertMentorBoard(vo);
	}

	@Override
	public int modifyMentorBoard(MentorBoardVO vo) {
		return dao.modifyMentorBoard(vo);
	}

	@Override
	public int deleteMentorBoard(int mb_num) {
		return dao.deleteMentorBoard(mb_num);
	}
	
}
