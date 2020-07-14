package com.sikiedu.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.sikiedu.domain.User;
import com.sikiedu.utils.HibernateUtils;

public class HQLDao {

	//HQL不能出现表中的任何内容
	
	//基本查询
	public void search()
	{
		Session session = HibernateUtils.getSession();
		Transaction beginTransaction = session.beginTransaction();
		
		/////////////////////
		//操作   select * from user
		String hql = "from com.sikiedu.domain.User";
		
		Query query = session.createQuery(hql);
		
		List<User> list = query.list();//查询多条数据
		//User user = (User) query.uniqueResult();//查询唯一数据
		
		System.out.println(list);
		
		/////////////////////
		beginTransaction.commit();
		session.close();
	}
	
	
	//条件查询
	public void search1()
	{
		Session session = HibernateUtils.getSession();
		Transaction beginTransaction = session.beginTransaction();
		
		/////////////////////
		//操作   select * from user where id = ?;
		
		String hql = "from com.sikiedu.domain.User where id = 1";
		Query query = session.createQuery(hql);
		User user = (User) query.uniqueResult();
		
		System.out.println(user.getUsername());
		
		/////////////////////
		beginTransaction.commit();
		session.close();
	}
	
	
	
	//?占位符查询
	public void search2(String id)
	{
		Session session = HibernateUtils.getSession();
		Transaction beginTransaction = session.beginTransaction();
		
		/////////////////////
		//操作   select * from user where id = ?;
		
		String hql = "from com.sikiedu.domain.User where id = ?0";
		Query query = session.createQuery(hql);
		//设置参数
		query.setParameter(0, id);
		//query.setString(0, id);
		User user = (User) query.uniqueResult();

		
		System.out.println(user.getPassword());
		
		/////////////////////
		beginTransaction.commit();
		session.close();
	}
	
	
	
	
	//命名占位符查询
	public void search3(String id)
	{
		Session session = HibernateUtils.getSession();
		Transaction beginTransaction = session.beginTransaction();
		
		/////////////////////
		//操作   select * from user where id = ?;
		
		String hql = "from com.sikiedu.domain.User where id = :id ";
		Query query = session.createQuery(hql);
		//设置参数

		query.setParameter("id", id);

		User user = (User) query.uniqueResult();

		
		System.out.println(user.getEmail());
		
		/////////////////////
		beginTransaction.commit();
		session.close();
	}
	
	
	
	//分页 limit ? , ?
	public void search4()
	{
		Session session = HibernateUtils.getSession();
		Transaction beginTransaction = session.beginTransaction();
		
		/////////////////////
		//操作   select * from user limit 0,1;
		
		String hql = "from com.sikiedu.domain.User";
		
		Query query = session.createQuery(hql);
		query.setFirstResult(1);
		query.setMaxResults(1);
	
		List<User> list = query.list();
		
		System.out.println(list.get(0).getUsername());
		
		/////////////////////
		beginTransaction.commit();
		session.close();
	}
	
	
	
	
}
