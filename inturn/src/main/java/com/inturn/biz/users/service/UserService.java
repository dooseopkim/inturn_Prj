package com.inturn.biz.users.service;

import java.util.List;

import com.inturn.biz.users.vo.UserVO;

public interface UserService {
	public List<UserVO> getUsers();
	public int insertUser(UserVO vo);
	public int modifyUser(UserVO vo);
	public int deleteUser(UserVO vo);
	public UserVO login(String id, String pw);
	public String findID(UserVO vo);
	public Boolean findPw(UserVO vo);
}
