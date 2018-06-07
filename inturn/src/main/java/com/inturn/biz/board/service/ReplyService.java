package com.inturn.biz.board.service;

import java.util.HashMap;
import java.util.List;

import com.inturn.biz.board.vo.ReplyVO;

public interface ReplyService {
	public int insertFBReply(ReplyVO vo);
	public int insertFBReReply(ReplyVO vo);
	public HashMap<String, Object> getFBReplies(int page_num, int fb_num);
	public int modifyReply(ReplyVO vo);
	public int upPosition(int position);
	public int downPosition(int position);
	public int deleteReply(int rp_num);
	public List<ReplyVO> freeBoardAlarm(String id);
	public List<ReplyVO> mentorBoardAlarm(String id);
	public int insertMBReply(ReplyVO vo);
	public int insertMBReReply(ReplyVO vo);
	public HashMap<String, Object> getMBReplies(int page_num, int mb_num);
	
}
