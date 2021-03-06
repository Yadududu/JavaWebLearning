package com.lmj.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.lmj.service.UserService;
import com.lmj.service.UserServiceImpl;

/**
 * UserService代理类
 */
public class UserServiceProxy {
	//UserServiceProxy	代理类
	//UserServiceImpl	被代理类
	public UserService getUserServiceProxy(UserService us) {
		
		return (UserService) Proxy.newProxyInstance(UserServiceProxy.class.getClassLoader(), 
													UserServiceImpl.class.getInterfaces(), 
													new InvocationHandler() {
			@Override
			public Object invoke(Object proxy,Method method,Object[] args) throws Throwable {
				//增强代码
				System.out.println("开启事务");
				//调用原始方法
				Object invoke = method.invoke(us, args);
				System.out.println("提交/回滚");
				return invoke;
			}
		});
	}

}
