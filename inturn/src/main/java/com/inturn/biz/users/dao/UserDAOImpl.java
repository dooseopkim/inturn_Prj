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
		System.out.println("dao : "+vo);
		int row = mybatis.insert("UserMapper.addUser", vo);
		System.out.println(vo);
		return row;
	}

	@Override
	public int modifyUser(UserVO vo) {
		return 0;
	}
	
	@Override
	public int modifyUserPw(UserVO vo) {
		return mybatis.update("UserMapper.modifyUserPw", vo);
	}

	@Override
	public int deleteUser(UserVO vo) {
		return 0;
	}

	@Override
	public UserVO login(UserVO vo) {
		return mybatis.selectOne("UserMapper.login", vo);
	}

	@Override
	public String findID(UserVO vo) {
		return mybatis.selectOne("UserMapper.findID", vo);
	}

	@Override
	public Boolean findPw(UserVO vo) {
		return mybatis.selectOne("UserMapper.findPw", vo);
	}

	@Override
	public int getId(UserVO vo) {
		return mybatis.selectOne("UserMapper.getId", vo);
	}
}
