package com.sikiedu.service;

import org.hibernate.Transaction;

import com.sikiedu.dao.UserDao;
import com.sikiedu.domain.User;
import com.sikiedu.utils.HibernateUtils;

public class UserService {

	public User findUser(User user) {
		
		UserDao userDao = new UserDao();
		Transaction transaction = HibernateUtils.getCurrentSession().beginTransaction();
		User temp = null;
		try
		{
			temp = userDao.findUser(user);			
		}
		catch(Exception e)
		{
			transaction.rollback();
		}
		transaction.commit();
		
		return temp;
	}

	
	
	
	
}
