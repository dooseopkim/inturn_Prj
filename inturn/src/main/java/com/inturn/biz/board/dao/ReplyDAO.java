package com.inturn.biz.board.dao;

import java.util.HashMap;
import java.util.List;

import com.inturn.biz.board.vo.ReplyVO;

public interface ReplyDAO {
	public int insertFBReply(ReplyVO vo);
	public int insertFBReReply(ReplyVO vo);
	public List<ReplyVO> getFBReplies(HashMap<String, Object> map);
	public ReplyVO getReply(int rp_num);
	public int getPosition(int parentNum);
	public int modifyReply(ReplyVO vo);
	public int upPosition(int position);
	public int downPosition(int position);
	public int deleteReply(int rp_num);
	public int deleteChildReply(int rp_num);
	public int deleteReplies(int fb_num);
	public int countReplies(int fb_num);
	public List<ReplyVO> freeBoardAlarm(String id);
}
