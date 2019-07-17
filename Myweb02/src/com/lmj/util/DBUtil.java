package com.lmj.util;

import java.util.HashMap;
import java.util.Map;

import com.lmj.model.User;

public class DBUtil {
	public static Map<String,User> userMap = new HashMap<String,User>();
	
	static {
		addUser(new User("123","123",10,"ÄÐ",true));
	}
	
	private static void addUser(User user) {
		userMap.put(user.getUsername(), user);
	}
}
