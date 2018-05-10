package com.inturn.biz.board.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("MentorBoardDAO")
public class MentorBoardDAOImpl implements MentorBoardDAO{
	@Autowired
	SqlSessionTemplate mybatis;
}
