package com.inturn.biz.users.dao;

import java.util.List;

import com.inturn.biz.users.vo.UserVO;

public interface UserDAO {
	public List<UserVO> getUsers();
}
