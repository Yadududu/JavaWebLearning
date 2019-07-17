package com.lmj.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.lmj.service.UserService;
import com.lmj.service.UserServiceImpl;

/**
 * UserService������
 */
public class UserServiceProxy {
	//UserServiceProxy	������
	//UserService		��������
	public UserService getUserServiceProxy(UserService us) {
		
		return (UserService) Proxy.newProxyInstance(UserServiceProxy.class.getClassLoader(), 
													UserServiceImpl.class.getInterfaces(), 
													new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, 
					Method method, 
					Object[] args) throws Throwable {
				//��ǿ����
				System.out.println("��������");
				//����ԭʼ����
				Object invoke = method.invoke(us, args);
				System.out.println("�ύ/�ع�");
				return invoke;
			}
		});
	}

}