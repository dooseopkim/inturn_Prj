package com.inturn.biz.board.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inturn.biz.board.dao.ReviewBoardDAO;

@Service("ReviewBoardService")
public class ReviewBoardServiceImpl implements ReviewBoardService{
	@Resource(name="ReviewBoardDAO")
	ReviewBoardDAO dao;
}
