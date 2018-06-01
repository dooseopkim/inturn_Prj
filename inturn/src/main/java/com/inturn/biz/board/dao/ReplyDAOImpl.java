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
	public int countReplies() {
		return mybatis.selectOne("ReplyMapper.countReplies");
	}

	@Override
	public ReplyVO getReply(int rp_num) {
		return mybatis.selectOne("ReplyMapper.getReply", rp_num);
	}
}
