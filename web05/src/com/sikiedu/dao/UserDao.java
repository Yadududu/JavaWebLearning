package com.sikiedu.dao;

import com.sikiedu.model.User;
import com.sikiedu.util.DBUtil;

public class UserDao {
	public boolean isExist(String username) {
		return DBUtil.userMap.containsKey(username);
	}
	public boolean addUser(String username,String password,int age ,String sex) {
		if(isExist(username))return false;
		User u = new User(username,password,age,sex,false);
		DBUtil.userMap.put(u.getUsername(), u);
		return true;
	}
	public User getUserByUP(String username,String password) {
		if(isExist(username)==false)return null;
		User u = DBUtil.userMap.get(username);
		if(u.getPassword().equals(password))return u;
		else return null;
	}
}
