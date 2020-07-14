package com.sikiedu.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sikiedu.dao.CriteriaDao;
import com.sikiedu.dao.HQLDao;
import com.sikiedu.dao.SQLDao;
import com.sikiedu.dao.UserDao;
import com.sikiedu.domain.User;
import com.sikiedu.utils.HibernateUtils;

public class UserService {

	public void test()
	{
		//HQLDao dao = new HQLDao();
		//dao.search2("1");
		//dao.search3("1");
		//dao.search4();
		//CriteriaDao dao = new CriteriaDao();
		//dao.search();
		SQLDao dao = new SQLDao();
		dao.fun3();
	}
	
	
	
	public void addUser(User user) {
		
		UserDao dao = new UserDao();
		//开始事务
		Session currentSesssion = HibernateUtils.getCurrentSesssion();
		Transaction beginTransaction = currentSesssion.beginTransaction();
		try
		{
			//根据查找tuser
			User tuser = dao.findUserById("1");
			if(tuser!=null)
			{
				//如果找到了,根据id修改名字
				dao.ChangeUserByUserId(tuser.getId());
			}
			else
			{
				//没找到,不做任何操作
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			beginTransaction.rollback();
		}
			
		//提交事务
		beginTransaction.commit();
		}

}
