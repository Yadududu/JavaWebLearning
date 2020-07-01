package com.sikiedu.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sikiedu.model.Goods;
import com.sikiedu.model.User;

public class DBUtil {
	public static Map<String, User> userMap = new HashMap<String, User>();
	
	public static List<Goods> goodsList = new ArrayList<Goods>();
	
	static {
		addUser(new User("siki","123",10,"ÄĞ",true));
		addUser(new User("123","123",10,"ÄĞ",true));

		goodsList.add(new Goods("Ïã½¶","ÏÄÍşÒÄÏã½¶",100,400));
		goodsList.add(new Goods("ÒÂ·ş","·Ç³£ºÃ¿´",100,56));
		goodsList.add(new Goods("Ïã½¶","ÏÄÍşÒÄÏã½¶",100,34));
		goodsList.add(new Goods("»Æ¹Ï","Ë®¹û»Æ¹Ï",100,22));
		goodsList.add(new Goods("Ïã½¶","ÏÄÍşÒÄÏã½¶",100,777));
		goodsList.add(new Goods("Ïã½¶","ÏÄÍşÒÄÏã½¶",34,45));
		goodsList.add(new Goods("Ã¢¹û","ÏÄÍşÒÄÏã½¶",100,456));
		goodsList.add(new Goods("Ïã½¶","ÏÄÍşÒÄÏã½¶",34,456));
		goodsList.add(new Goods("Ïã½¶","ÏÄÍşÒÄÏã½¶",100,400));
		goodsList.add(new Goods("Ïã½¶","ÏÄÍşÒÄÏã½¶",100,89));
		goodsList.add(new Goods("Æ»¹û","ÏÄÍşÒÄÏã½¶",34,400));
		goodsList.add(new Goods("Ïã½¶","ÏÄÍşÒÄÏã½¶",100,456));
		goodsList.add(new Goods("Ïã³¦","·Ç³£Ïã",34,546));
		goodsList.add(new Goods("Ïã½¶","ÏÄÍşÒÄÏã½¶",100,89));
		goodsList.add(new Goods("Ïã½¶","ÏÄÍşÒÄÏã½¶",23,400));
	}
	private static void addUser(User user) {
		userMap.put(user.getUsername(), user);
	}
	
}
