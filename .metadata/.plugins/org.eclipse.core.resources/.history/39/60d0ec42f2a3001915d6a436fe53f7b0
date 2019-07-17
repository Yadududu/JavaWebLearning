package com.lmj.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lmj.bean.Pet;


@RunWith(SpringJUnit4ClassRunner.class)//使用junit进行测试，帮我们创建容器
@ContextConfiguration("classpath:applicationContext.xml") //读取配置文件
public class test_JUnit {
	
	@Resource(name="dog")
	private Pet p;
	
	@Test
	public void Test1() {
		System.out.println(p);
	}
}
