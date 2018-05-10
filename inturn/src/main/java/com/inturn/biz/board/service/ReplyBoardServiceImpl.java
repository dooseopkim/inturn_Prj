package com.inturn.biz.board.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inturn.biz.board.dao.ReplyBoardDAO;

@Service("ReplyBoardService")
public class ReplyBoardServiceImpl implements ReplyBoardService{
	@Resource(name="ReplyBoardDAO")
	ReplyBoardDAO dao;
}
