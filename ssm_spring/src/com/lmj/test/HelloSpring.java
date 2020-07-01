package com.lmj.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lmj.bean.User;

public class HelloSpring {
	
	//在之前项目开中 new 对象是我们自己做的
	@Test
	public void Test1() {
		User u = new User();
		u.setU_id(1);
		System.out.println(u);
	}
	
	//IOC的反转：创建对象这份工作由我们自己执行反转给spring帮我们执行；
	//IOC的控制：就是由spring帮我们负责创建销毁对象，掌控对象的生命周期等，我们在需要使用对象的时候跟Spring申请即可；
	//IOC是一种编程思想，也是一种新的设计模式，它需要DI（依赖注入）技术的支持；
	
	//spring是一个容器，它将帮我们管理对象
	@Test
	public void Test2() {
		//根据spring配置文件获取容器对象
		//ApplicationContext 配置的所有bean都会在容器创建的时候被创建出来
		//如果配置的bean较多，那么在创建容器的时候，会产生内存过大的问题；这种情况在机器硬件性能较为落后的时候体现的比较明显；
		//延迟加载 lazy-init="true"就是创建容器时不加载配置的bean对象，在获取的时候才创建；
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		//User u = (User) ac.getBean("user");
		//通过getBean获取配置好的user对象（程序员向spring容器要对象）
		User u = ac.getBean(User.class);
		System.out.println(u);
	}
	
	@Test
	public void Test3() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//scope="singleton" 默认值 单例的 只创建一个对象 一般项目中采用singleton
		User u1 = ac.getBean(User.class);
		User u2 = ac.getBean(User.class);
		User u3 = ac.getBean(User.class);
		
		System.out.println(u1 == u2);
		
	}
	
	@Test
	public void Test4() {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// scope="prototype" 多例的 在获取的时候会创建新的对象 但是特殊环境下需要改为prototype
		User u1 = ac.getBean(User.class);
		User u2 = ac.getBean(User.class);
		User u3 = ac.getBean(User.class);
	
		System.out.println(u1 == u2);
		
		//关闭容器对象，就会触发bean的destroymethod
		ac.close();
	}
}
