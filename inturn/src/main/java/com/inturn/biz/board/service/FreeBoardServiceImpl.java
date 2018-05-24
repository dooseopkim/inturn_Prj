package com.inturn.biz.board.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inturn.biz.board.dao.FreeBoardDAO;
import com.inturn.biz.board.vo.FreeBoardVO;

@Service("FreeBoardService")
public class FreeBoardServiceImpl implements FreeBoardService{
	@Resource(name="FreeBoardDAO")
	FreeBoardDAO dao;

	@Override
	public List<FreeBoardVO> showFreeBoard() {
		return dao.showFreeBoard();
	}

	@Override
	public int insertFreeBoard(FreeBoardVO vo) {
		return dao.insertFreeBoard(vo);
	}

	@Override
	public int modifyFreeBoard(FreeBoardVO vo) {
		return dao.modifyFreeBoard(vo);
	}

	@Override
	public int deleteFreeBoard(int fb_num) {
		return dao.deleteFreeBoard(fb_num);
	}
}
