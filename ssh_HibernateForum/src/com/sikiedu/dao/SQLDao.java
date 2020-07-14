package com.sikiedu.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import com.sikiedu.domain.User;
import com.sikiedu.utils.HibernateUtils;

public class SQLDao {

	//SQL基本查询
	public void fun()
	{
		
		Session session = HibernateUtils.getSession();
		Transaction beginTransaction = session.beginTransaction();
		
		///////
		
		String sql = "select * from user";
		
		//创建sql查询对象
		NativeQuery query = session.createSQLQuery(sql);
		//封装数据
		query.addEntity(User.class);
		//接收list
		List<User> list = query.list();
		//接受单一返回值
		//query.uniqueResult();
		
		System.out.println(list.get(0).getUsername()+"--"+list.get(1).getUsername()
				+"--"+ list.get(2).getUsername()
				);
		
		///////
		beginTransaction.commit();
		session.close();
		
		
	}
	
	
	//SQL条件查询
	public void fun2()
	{
			
		Session session = HibernateUtils.getSession();
		Transaction beginTransaction = session.beginTransaction();
		///////
		
		String sql = "select * from user where id = ?";
		NativeQuery query = session.createSQLQuery(sql);
		
		//给?赋值
		query.setParameter(1, "3");
		
		//自动封装为user
		query.addEntity(User.class);
		//唯一返回值
		User user = (User) query.uniqueResult();
		
		
		System.out.println(user);
		
		
		///////
		beginTransaction.commit();
		session.close();
			
			
	}
	
	
	//SQL分页查询
	public void fun3()
	{
			
		Session session = HibernateUtils.getSession();
		Transaction beginTransaction = session.beginTransaction();
		///////
		
		String sql = "select * from user limit ? , ?";
		NativeQuery query = session.createSQLQuery(sql);
		
		//给?赋值
		query.setParameter(1, 0);
		query.setParameter(2, 2);
		query.addEntity(User.class);
		//唯一返回值
		List<User> list = query.list();
		
		System.out.println(list + " --- " + list.get(0).getUsername() + "--" + list.get(1).getUsername());
		
		
		///////
		beginTransaction.commit();
		session.close();
			
			
	}	

	
}
