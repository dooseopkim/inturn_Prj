package com.inturn.biz.board.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inturn.biz.board.dao.CsBoardDAO;

@Service("CsBoardService")
public class CsBoardServiceImpl implements CsBoardService{
	@Resource(name="CsBoardDAO")
	CsBoardDAO dao;
}
