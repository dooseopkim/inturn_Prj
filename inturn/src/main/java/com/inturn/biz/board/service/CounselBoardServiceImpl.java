package com.inturn.biz.board.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inturn.biz.board.dao.CounselBoardDAO;

@Service("CounselBoardService")
public class CounselBoardServiceImpl implements CounselBoardService{
	@Resource(name="CounselBoardDAO")
	CounselBoardDAO dao;
}
