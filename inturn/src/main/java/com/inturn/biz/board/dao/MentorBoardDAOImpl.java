package com.inturn.biz.board.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inturn.biz.board.vo.MentorBoardVO;

@Repository("MentorBoardDAO")
public class MentorBoardDAOImpl implements MentorBoardDAO{
	@Autowired
	SqlSessionTemplate mybatis;

	@Override
	public List<MentorBoardVO> mentorBoardList(HashMap<String, Object> map) {
		return mybatis.selectList("MentorBoardMapper.mentorBoardList", map);		
	}

	@Override
	public List<MentorBoardVO> searchMentorBoardList(HashMap<String, Object> map) {
		return mybatis.selectList("MentorBoardMapper.searchMentorBoardList", map);
	}

	@Override
	public int getCntMentorBoard() {
		return mybatis.selectOne("MentorBoardMapper.getCntMentorBoard");
	}

	@Override
	public int getSearchCntMentorBoard(HashMap<String, Object> map) {
		return mybatis.selectOne("MentorBoardMapper.getSearchCntMentorBoard", map);
	}

	@Override
	public int prevMb_num(int mb_num) {
		return mybatis.selectOne("MentorBoardMapper.prevMb_num", mb_num);
	}

	@Override
	public int nextMb_num(int mb_num) {
		return mybatis.selectOne("MentorBoardMapper.nextMb_num", mb_num);
	}
	
	@Override
	public int scPrevMb_num(HashMap<String, Object> map) {
		return mybatis.selectOne("MentorBoardMapper.scPrevMb_num", map);
	}

	@Override
	public int scNextMb_num(HashMap<String, Object> map) {
		return mybatis.selectOne("MentorBoardMapper.scNextMb_num", map);
	}
	
	@Override
	public MentorBoardVO viewMentorBoard(int mb_num) {
		return mybatis.selectOne("MentorBoardMapper.viewMentorBoard", mb_num);
		
	}

	@Override
	public int insertMentorBoard(MentorBoardVO vo) {
		return mybatis.insert("MentorBoardMapper.insertMentorBoard", vo);
	}

	@Override
	public int modifyMentorBoard(MentorBoardVO vo) {
		return mybatis.update("MentorBoardMapper.modifyMentorBoard", vo);
	}

	@Override
	public int deleteMentorBoard(int mb_num) {
		return mybatis.delete("MentorBoardMapper.deleteMentorBoard", mb_num);
	}

}
