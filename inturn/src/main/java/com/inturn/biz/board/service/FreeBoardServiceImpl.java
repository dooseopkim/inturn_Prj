package com.inturn.biz.board.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.inturn.biz.board.dao.FileDAO;
import com.inturn.biz.board.dao.FreeBoardDAO;
import com.inturn.biz.board.vo.FileGroupVO;
import com.inturn.biz.board.vo.FreeBoardVO;

@Service("FreeBoardService")
public class FreeBoardServiceImpl implements FreeBoardService{
	@Resource(name="FreeBoardDAO")
	FreeBoardDAO fb_dao;
	@Resource(name="FileDAO")
	FileDAO file_dao;
	
	@Override
	public List<FreeBoardVO> showFreeBoard() {
		return fb_dao.showFreeBoard();
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int insertFreeBoard(FreeBoardVO vo) {
		int row = 0;
		int fileGroupNum = file_dao.findFileGroup(vo.getId());
		row += fb_dao.insertFreeBoard(vo);
		row += file_dao.insert_FB_files(new FileGroupVO(fileGroupNum,fb_dao.findBoard(vo)));
		row += file_dao.insertBoard(vo.getId());
		return row;
	}

	@Override
	public int modifyFreeBoard(FreeBoardVO vo) {
		return fb_dao.modifyFreeBoard(vo);
	}

	@Override
	public int deleteFreeBoard(int fb_num) {
		return fb_dao.deleteFreeBoard(fb_num);
	}

	@Override
	public int findBoard(FreeBoardVO vo) {
		return fb_dao.findBoard(vo);
	}
}
