package com.lmj.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lmj.service.UserService;
import com.lmj.service.UserServiceImpl;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AopTest {
	@Test
	public void Test1() {
		UserServiceProxy usProxy = new UserServiceProxy();
		UserService us = new UserServiceImpl();
		UserService us_PowerUp = usProxy.getUserServiceProxy(us);
		
		us_PowerUp.find();
	}
	
	@Resource(name="userService")
	UserService us;
	@Test
	public void Test2() {
		us.delete();
	}
}
