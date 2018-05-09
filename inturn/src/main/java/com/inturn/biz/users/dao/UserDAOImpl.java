package com.inturn.biz.users.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inturn.biz.users.vo.UserVO;

@Repository("UserDAO")
public class UserDAOImpl implements UserDAO{
	@Autowired
	SqlSessionTemplate mybatis;
	
	@Override
	public List<UserVO> getUsers() {
		return mybatis.selectList("UserMapper.selectUser");
	}

	@Override
	public int insertUser(UserVO vo) {
		return 0;
	}

	@Override
	public int modifyUser(UserVO vo) {
		return 0;
	}

	@Override
	public int deleteUser(UserVO vo) {
		return 0;
	}

	@Override
	public UserVO login(String id, String pw) {
		return null;
	}

	@Override
	public String findID(UserVO vo) {
		return null;
	}

	@Override
	public Boolean findPw(UserVO vo) {
		return null;
	}
}