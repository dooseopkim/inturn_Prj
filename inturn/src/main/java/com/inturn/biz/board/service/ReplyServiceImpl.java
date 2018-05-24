package com.inturn.biz.board.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inturn.biz.board.dao.ReplyDAO;

@Service("ReplyService")
public class ReplyServiceImpl implements ReplyService{
	@Resource(name="ReplyDAO")
	ReplyDAO dao;
}
