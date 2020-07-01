package com.lmj.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lmj.bean.User;
import com.lmj.dao.UserDaoImpl;
import com.lmj.mapper.UserMapper;

public class MapperTest {
	@Test
	public void Test1() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		//UserMapper mapper = (UserMapper) ac.getBean("userMapper");
		UserMapper mapper = ac.getBean(UserMapper.class);
		
		User user = mapper.selectUserById(1);
		System.out.println(user);
	}
	
	@Test
	public void Test2() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserMapper mapper = ac.getBean(UserMapper.class);
		
		User user = mapper.selectUserById(12);
		System.out.println(user);
	}
}
