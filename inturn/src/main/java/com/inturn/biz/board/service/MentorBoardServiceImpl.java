package com.inturn.biz.board.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inturn.biz.board.dao.MentorBoardDAO;

@Service("MentorBoardService")
public class MentorBoardServiceImpl implements MentorBoardService{
	@Resource(name="MentorBoardDAO")
	MentorBoardDAO dao;
}
