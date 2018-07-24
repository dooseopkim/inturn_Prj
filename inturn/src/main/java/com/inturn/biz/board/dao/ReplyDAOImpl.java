package com.inturn.biz.board.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inturn.biz.board.vo.ReplyVO;

@Repository("ReplyDAO")
public class ReplyDAOImpl implements ReplyDAO{
	@Autowired
	SqlSessionTemplate mybatis;

	@Override
	public int insertFBReply(ReplyVO vo) {
		return mybatis.insert("ReplyMapper.insertFBReply", vo);
	}

	@Override
	public int insertFBReReply(ReplyVO vo) {
		return mybatis.insert("ReplyMapper.insertFBReReply", vo);
	}

	@Override
	public List<ReplyVO> getFBReplies(HashMap<String, Object> map) {
		return mybatis.selectList("ReplyMapper.getFBReplies", map);
	}

	@Override
	public int modifyReply(ReplyVO vo) {
		return mybatis.update("ReplyMapper.modifyReply", vo);
	}

	@Override
	public int upPosition(int position) {
		return mybatis.update("ReplyMapper.upPosition", position);
	}

	@Override
	public int downPosition(int position) {
		return mybatis.update("ReplyMapper.downPosition", position);
	}

	@Override
	public int deleteReply(int rp_num) {
		return mybatis.delete("ReplyMapper.deleteReply", rp_num);
	}

	@Override
	public int countReplies(int fb_num) {
		return mybatis.selectOne("ReplyMapper.countReplies", fb_num);
	}

	@Override
	public ReplyVO getReply(int rp_num) {
		return mybatis.selectOne("ReplyMapper.getReply", rp_num);
	}

	@Override
	public int getPosition(int parentNum) {
		System.out.println(parentNum);
		return mybatis.selectOne("ReplyMapper.getPosition", parentNum);
	}

	@Override
	public int deleteReplies(int fb_num) {
		return mybatis.delete("ReplyMapper.deleteReplies", fb_num);
	}

	@Override
	public int deleteChildReply(int rp_num) {
		return mybatis.delete("ReplyMapper.deleteChildReply", rp_num);
	}
	
	@Override
	public List<ReplyVO> freeBoardAlarm(String id) {
		return mybatis.selectList("ReplyMapper.freeBoardAlarm", id);
	}

	@Override
	public List<ReplyVO> mentorBoardAlarm(String id) {
		return mybatis.selectList("ReplyMapper.mentorBoardAlarm", id);
	}

	@Override
	public int insertMBReply(ReplyVO vo) {
		return mybatis.insert("ReplyMapper.insertMBReply", vo);
	}

	@Override
	public int insertMBReReply(ReplyVO vo) {
		return mybatis.insert("ReplyMapper.insertMBReReply", vo);
	}

	@Override
	public List<ReplyVO> getMBReplies(HashMap<String, Object> map) {
		return mybatis.selectList("ReplyMapper.getMBReplies", map);
	}

	@Override
	public int deleteMBReplies(int mb_num) {
		return mybatis.delete("ReplyMapper.deleteMBReplies", mb_num);
	}

	@Override
	public int countMBReplies(int mb_num) {
		return mybatis.selectOne("ReplyMapper.countMBReplies", mb_num);
	}

	//////멘티 게시판 댓글 관련//////
	@Override
	public int insertTBReply(ReplyVO vo) {
		return mybatis.insert("ReplyMapper.insertTBReply", vo);
	}

	@Override
	public int insertTBReReply(ReplyVO vo) {
		return mybatis.insert("ReplyMapper.insertTBReReply", vo);
	}

	@Override
	public List<ReplyVO> getTBReplies(HashMap<String, Object> map) {
		return mybatis.selectList("ReplyMapper.getTBReplies", map);
	}

	@Override
	public List<ReplyVO> menteeBoardAlarm(String id) {
		return mybatis.selectList("ReplyMapper.menteeBoardAlarm", id);
	}

	@Override
	public int deleteTBReplies(int tb_num) {
		return mybatis.delete("ReplyMapper.deleteTBReplies", tb_num);
	}

	@Override
	public int countTBReplies(int tb_num) {
		return mybatis.selectOne("ReplyMapper.countTBReplies", tb_num);
	}
	
}
