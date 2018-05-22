package com.inturn.biz.users.dao;

import java.util.List;

import com.inturn.biz.users.vo.UserVO;

public interface UserDAO {
	public List<UserVO> getUsers();
	public int insertUser(UserVO vo);
	public int modifyUser(UserVO vo);
	public int deleteUser(UserVO vo);
	public UserVO login(UserVO vo);
	public String findID(UserVO vo);
	public int getId(UserVO vo);
	public Boolean findPw(UserVO vo);
}
