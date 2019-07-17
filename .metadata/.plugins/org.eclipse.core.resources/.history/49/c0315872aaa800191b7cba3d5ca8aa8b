package com.lmj.test;

import org.junit.Test;

import com.lmj.bean.User;
import com.lmj.dao.UserDao;
import com.lmj.dao.UserDaoImpl;

public class JdbcTest {
	@Test
	public void Test1() {
		UserDao dao = new UserDaoImpl();
		User u = dao.selectUserById(1);
		System.out.println(u);
	}
}
