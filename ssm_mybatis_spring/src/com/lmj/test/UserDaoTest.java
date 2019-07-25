package com.lmj.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lmj.bean.User;
import com.lmj.dao.UserDao;
import com.lmj.dao.UserDaoImpl;

public class UserDaoTest {

	@Test
	public void DaoTest() {
//		UserDao userDao = new UserDaoImpl(ssf);
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDaoImpl userDao = ac.getBean(UserDaoImpl.class);
		
		User user = userDao.getUserById(1);
		System.out.println(user);
	}
}
