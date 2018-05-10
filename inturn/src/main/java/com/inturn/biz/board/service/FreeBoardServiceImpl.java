package com.inturn.biz.board.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inturn.biz.board.dao.FreeBoardDAO;

@Service("FreeBoardService")
public class FreeBoardServiceImpl implements FreeBoardService{
	@Resource(name="FreeBoardDAO")
	FreeBoardDAO dao;
}
