package com.sikiedu.dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import com.sikiedu.domain.User;
import com.sikiedu.utils.HibernateUtils;

public class UserDao {

	//Ô­Éúsql²éÑ¯
	public User findUser(User user) {
		
		Session session = HibernateUtils.getCurrentSession();
		String sql = "select * from user where username = ? and password = ?";
		NativeQuery query = session.createSQLQuery(sql);
		query.setParameter(1,user.getUsername());
		query.setParameter(2, user.getPassword());
		query.addEntity(User.class);
		
		User temp = (User) query.uniqueResult();
		
		
		return temp;
	}

}
