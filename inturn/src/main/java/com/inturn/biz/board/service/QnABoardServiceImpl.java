package com.inturn.biz.board.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inturn.biz.board.dao.QnQBoardDAO;

@Service("CsBoardService")
public class QnABoardServiceImpl implements QnABoardService{
	@Resource(name="CsBoardDAO")
	QnQBoardDAO dao;
}
