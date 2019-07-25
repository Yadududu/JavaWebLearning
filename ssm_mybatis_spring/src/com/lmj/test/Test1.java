package com.lmj.test;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		SqlSessionFactoryBean bean = ac.getBean(SqlSessionFactoryBean.class);
		
		System.out.println(bean);
	}

}
