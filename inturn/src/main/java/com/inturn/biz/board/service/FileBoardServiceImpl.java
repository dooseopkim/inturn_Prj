package com.inturn.biz.board.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inturn.biz.board.dao.FileBoardDAO;

@Service("FileBoardService")
public class FileBoardServiceImpl implements FileBoardService{
	@Resource(name="FileBoardDAO")
	FileBoardDAO dao;
}
