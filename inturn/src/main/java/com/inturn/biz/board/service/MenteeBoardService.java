package com.inturn.biz.board.service;

import java.util.HashMap;

import com.inturn.biz.board.vo.MenteeBoardVO;

public interface MenteeBoardService {
	/**
	 * 게시물 리스트
	 * @param page_num
	 * @return
	 */
	public HashMap<String, Object> boardList(int page_num);
	/**
	 * 조건 검색 후 게시물 리스트
	 * @param condition
	 * @param search
	 * @param page_num
	 * @return
	 */
	public HashMap<String, Object> scBoardList(String condition, String search, int page_num);
	/**
	 * 게시물 데이터 반환하는 함수
	 * @param tb_num
	 * @return
	 */
	public HashMap<String, Object> viewBoard(int tb_num);
	/**
	 * 조건 검색 후 나온 게시물 데이터 반환하는 함수
	 * @param condition
	 * @param search
	 * @param tb_num
	 * @return
	 */
	public HashMap<String, Object> scViewBoard(String condition, String search, int tb_num);
	/**
	 * 게시물 개수 반환
	 * @return
	 */
	public int countBoards();
	public int findBoard(MenteeBoardVO vo);
	public int insertMenteeBoard(MenteeBoardVO vo);
	public int modifyMenteeBoard(MenteeBoardVO vo);
	public int deleteMenteeBoard(int tb_num);
}
