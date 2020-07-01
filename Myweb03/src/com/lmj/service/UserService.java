package com.lmj.service;

import com.lmj.dao.UserDao;
import com.lmj.model.User;
import com.lmj.util.DButil;

public class UserService {
	public boolean register(String username,String password,String sex,int phoneNumber) {
		UserDao ud = new UserDao();
		if(ud.usernameisExist(username))return false;
		if(ud.passwordisExist(username))return false;
		if(ud.phoneNumberisExist(username))return false;
		ud.addUser(username, password, sex, phoneNumber);
		return true;
	}
	
	public User login(String username,String password) {
		UserDao ud = new UserDao();
		if(ud.usernameisExist(username) == false)return null;
		return new UserDao().getUserByUp(username, password);
	}
	
	public User FinePassword(String username,int phoneNumber) {
		UserDao ud = new UserDao();
		if(ud.usernameisExist(username) == false)return null;
		return ud.getUserFind(username, phoneNumber);
	}
	
	public boolean isExist(String username) {
		return new UserDao().usernameisExist(username);
	}
	
	public boolean isCorrectPassword(String password) {
		if(password.length()>=3 & password.length()<=6)return true;
		return false;
	}
	
	public boolean isRepetition(String password,String Repassword) {
		return password.equals(Repassword);
	}
	
	public boolean isEmpty(String phoneNumber) {
		return phoneNumber.isEmpty();
	}
}
