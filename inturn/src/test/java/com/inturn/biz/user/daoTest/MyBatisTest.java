package com.inturn.biz.user.daoTest;

import java.util.List;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.inturn.biz.users.dao.UserDAO;
import com.inturn.biz.users.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:ApplicationContext.xml"})
public class MyBatisTest {

	@Resource(name="UserDAO")
	UserDAO dao;
	
	
	@After
	public void tearDown() throws Exception {
		dao = null;
	}

//	@Test
	public void test() {
		List<UserVO> list = dao.getUsers();
		System.out.println(list);
	}
	
	@Test
	public void login() {
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPw("1234");
		UserVO user = dao.login(vo);
		System.out.println(user);
	}
}
