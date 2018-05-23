package com.inturn.biz.users.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inturn.biz.users.dao.UserDAO;
import com.inturn.biz.users.vo.UserVO;

@Service("UserService")
public class UserServiceImpl implements UserService{

	@Resource(name="UserDAO")
	UserDAO dao;
	
	@Override
	public List<UserVO> getUsers() {
		return dao.getUsers();
	}

	@Override
	public int insertUser(UserVO vo) {
		return dao.insertUser(vo);
	}

	@Override
	public int modifyUser(UserVO vo) {
		return dao.modifyUser(vo);
	}

	@Override
	public int deleteUser(UserVO vo) {
		return dao.deleteUser(vo);
	}

	@Override
	public UserVO login(UserVO vo) {
		return dao.login(vo);
	}

	@Override
	public String findID(UserVO vo) {
		return dao.findID(vo);
	}

	@Override
	public Boolean findPw(UserVO vo) {
		return dao.findPw(vo);
	}

	@Override
	public int getId(UserVO vo) {
		System.out.println("여긴 서비스임플입니다.");
		return dao.getId(vo);
	}
}
