package com.lmj.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lmj.bean.MyCollection;
import com.lmj.bean.User;

public class Test_Injection {
	@Test
	public void Test1() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext_Injection.xml");
	
		User u1 = (User) ac.getBean("user1");
	
		System.out.println(u1);
	}
	
	@Test
	public void Test2() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext_Injection.xml");
	
		MyCollection mc = (MyCollection) ac.getBean("collection");
	
		System.out.println(mc);
	}
}
