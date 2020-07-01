package com.sikiedu.service;

import java.sql.SQLException;

import com.sikiedu.dao.UserDao;
import com.sikiedu.domain.User;

public class UserService {

	public boolean findUser(User user) throws SQLException {
		
		UserDao userDao = new UserDao();
		User temp = userDao.findUser(user);
		
		
		return temp==null?false:true;
	}

}
