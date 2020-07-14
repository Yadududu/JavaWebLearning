package com.sikiedu.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.sikiedu.domain.User;
import com.sikiedu.utils.HibernateUtils;

public class CriteriaDao {

	// 基本查询
	public void search() {

		Session session = HibernateUtils.getSession();
		Transaction beginTransaction = session.beginTransaction();

		/////////////////////
		// 操作 select * from user

		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		// createQuery-->查询条件(首先要知道查询什么类型数据)
		CriteriaQuery<User> createQuery = criteriaBuilder.createQuery(User.class);
		Root<User> from = createQuery.from(User.class);
		createQuery.select(from);
		
		
		// 执行查询
		List<User> resultList = session.createQuery(createQuery).getResultList();

		System.out.println(resultList);

		/////////////////////
		beginTransaction.commit();
		session.close();

	}

	// 条件查询
	public void search2() {

		Session session = HibernateUtils.getSession();
		Transaction beginTransaction = session.beginTransaction();

		/////////////////////
		// 操作 select * from user

		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

		// createQuery-->查询条件(首先要知道查询什么类型数据)
		CriteriaQuery<User> criteria = criteriaBuilder.createQuery(User.class);
		Root<User> root = criteria.from(User.class);
		criteria.select(root).where(root.get("id").in("1"));
		// 执行查询
		List<User> resultList = session.createQuery(criteria).getResultList();

		System.out.println(resultList);

		/////////////////////
		beginTransaction.commit();
		session.close();

	}

	// 查询总数查询
	public void search3() {

		Session session = HibernateUtils.getSession();
		Transaction beginTransaction = session.beginTransaction();

		/////////////////////
		// 操作 select count(*) from user

		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

		// createQuery-->查询条件(首先要知道查询什么类型数据)(数Integer Long)
		CriteriaQuery<Long> criteria = criteriaBuilder.createQuery(Long.class);
		Root<User> root = criteria.from(User.class);
		criteria.select(criteriaBuilder.count(root));
		
		// 执行查询
		Long count = session.createQuery(criteria).uniqueResult();
		
		System.out.println(count);

		/////////////////////
		beginTransaction.commit();
		session.close();

	}
	
	//查询名字带有i的人的总数 -- 2
	// 查询总数查询
	public void search4() {

		Session session = HibernateUtils.getSession();
		Transaction beginTransaction = session.beginTransaction();

		/////////////////////
		// 操作 select count(*) from user where username like '%i%'  
		
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		
		CriteriaQuery<Long> criteria = criteriaBuilder.createQuery(Long.class);
		Root<User> root = criteria.from(User.class);
		
		criteria.select(criteriaBuilder.count(root)).where(criteriaBuilder.like(root.get("username"), "%i%"));

	
		Long count = session.createQuery(criteria).uniqueResult();

		System.out.println(count);
		
		/////////////////////
		beginTransaction.commit();
		session.close();

	}
	

}
