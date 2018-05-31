package com.inturn.biz.board.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inturn.biz.board.vo.FreeBoardVO;

@Repository("FreeBoardDAO")
public class FreeBoardDAOImpl implements FreeBoardDAO{
	@Autowired
	SqlSessionTemplate mybatis;

	@Override
	public int insertFreeBoard(FreeBoardVO vo) {
		return mybatis.insert("FreeBoardMapper.insertFreeBoard", vo);
	}

	@Override
	public int modifyFreeBoard(FreeBoardVO vo) {
		return mybatis.update("FreeBoardMapper.modifyFreeBoard", vo);
	}

	@Override
	public int deleteFreeBoard(int fb_num) {
		return mybatis.delete("FreeBoardMapper.deleteFreeBoard", fb_num);
	}

	@Override
	public int findBoard(FreeBoardVO vo) {
		return mybatis.selectOne("FreeBoardMapper.findBoard", vo);
	}

	@Override
	public List<FreeBoardVO> boardList(HashMap<String, Integer> map) {
		return mybatis.selectList("FreeBoardMapper.boardList", map);
	}

	@Override
	public int countBoards() {
		return mybatis.selectOne("FreeBoardMapper.countBoards");
	}

	@Override
	public FreeBoardVO viewBoard(int fb_num) {
		return mybatis.selectOne("FreeBoardMapper.viewBoard", fb_num);
	}

	@Override
	public int countUp(int fb_num) {
		return mybatis.update("FreeBoardMapper.countUp", fb_num);
	}

	@Override
	public int prevfb_num(int fb_num) {
		return mybatis.selectOne("FreeBoardMapper.prevfb_num", fb_num);
	}

	@Override
	public int nextfb_num(int fb_num) {
		return mybatis.selectOne("FreeBoardMapper.nextfb_num", fb_num);
	}

	@Override
	public List<FreeBoardVO> scBoardList(HashMap<String, Object> map) {
		return mybatis.selectList("FreeBoardMapper.scBoardList", map);
	}

	@Override
	public int scCountBoards(String condition, String search) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("condition", condition);
		map.put("search",search);
		return mybatis.selectOne("FreeBoardMapper.scCountBoards", map);
	}

	@Override
	public int scPrevfb_num(String condition, String search, int fb_num) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("condition", condition);
		map.put("search",search);
		map.put("fb_num",fb_num);
		return mybatis.selectOne("FreeBoardMapper.scPrevfb_num", map);
	}

	@Override
	public int scNextfb_num(String condition, String search, int fb_num) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("condition", condition);
		map.put("search",search);
		map.put("fb_num",fb_num);
		return mybatis.selectOne("FreeBoardMapper.scNextfb_num", map);
	}
}
