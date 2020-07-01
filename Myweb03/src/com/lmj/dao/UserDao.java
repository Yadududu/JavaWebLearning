package com.lmj.dao;

import com.lmj.model.User;
import com.lmj.util.DButil;

public class UserDao {
	public boolean usernameisExist(String username) {
		return DButil.UserMap.containsKey(username);
	}
	public boolean passwordisExist(String password) {
		return DButil.UserMap.containsKey(password);
	}
	public boolean phoneNumberisExist(String phoneNumber) {
		return DButil.UserMap.containsKey(phoneNumber);
	}
	public boolean addUser(String username,String password,String sex,int phoneNumber) {
		User user = new User(username,password,sex,phoneNumber, false);
		DButil.UserMap.put(user.getUsername(), user);
		return true;
	}
	public User getUserByUp(String username,String password) {
		User user = DButil.UserMap.get(username);
		if(user.getPassword().equals(password)) {
			return user;
		}else {
			return null;
		}
	}
	public User getUserFind(String username,int phoneNumber) {
		User user = DButil.UserMap.get(username);
		if(user.getPhoneNumber() == phoneNumber) {
			return user;
		}else {
			return null;
		}
	}
	
}

