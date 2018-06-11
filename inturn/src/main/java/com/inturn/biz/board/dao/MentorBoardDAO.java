package com.inturn.biz.board.dao;

import java.util.HashMap;
import java.util.List;

import com.inturn.biz.board.vo.MentorBoardVO;

public interface MentorBoardDAO {
	public List<MentorBoardVO> mentorBoardList(HashMap<String, Object> map);
	public List<MentorBoardVO> searchMentorBoardList(HashMap<String, Object> map);
	public int getCntMentorBoard();
	public int getSearchCntMentorBoard(HashMap<String, Object> map);
	public int prevMb_num(int mb_num);
	public int nextMb_num(int mb_num);
	public int scPrevMb_num(HashMap<String, Object> map);
	public int scNextMb_num(HashMap<String, Object> map);
	public  MentorBoardVO viewMentorBoard(int mb_num);
	public int insertMentorBoard(MentorBoardVO vo);
	public int modifyMentorBoard(MentorBoardVO vo);
	public int deleteMentorBoard(int mb_num);

}
