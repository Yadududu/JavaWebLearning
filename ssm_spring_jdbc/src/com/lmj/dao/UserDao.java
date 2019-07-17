package com.lmj.dao;

import java.util.List;

import com.lmj.bean.User;

public interface UserDao {
	//增
	void saveUser(User u);
	
	//删
	void deleteUserById(Integer id);
	
	//改
	void updateUser(User u);
	
	//查
	//根据id查找用户
	User selectUserById(Integer id);
	
	//查找全部用户List
	List<User> selectAllUser();
	
	//查找用户数量
	Integer selectUserCount();
}
