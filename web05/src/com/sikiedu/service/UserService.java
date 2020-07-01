package com.sikiedu.service;

import com.sikiedu.dao.UserDao;
import com.sikiedu.model.User;

public class UserService {
	public boolean register(String username,String password,int age ,String sex) {
		UserDao userDao = new UserDao();
		boolean isExist = userDao.isExist(username);
		if(isExist) {
			return false;
		}
		else {
			userDao.addUser(username, password, age, sex);
			return true;
		}
	}
	public User login(String username,String password) {
		return new UserDao().getUserByUP(username, password);
	}
	public boolean isExist(String username) {
		return new UserDao().isExist(username);
	}
}
