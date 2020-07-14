package com.sikiedu.service;

import java.sql.SQLException;

import com.sikiedu.dao.UserDao;
import com.sikiedu.domain.User;

public class UserService {

	public void addUser(User user) throws SQLException {
		UserDao userDao = new UserDao();
		userDao.addUser(user);
		
	}

}
