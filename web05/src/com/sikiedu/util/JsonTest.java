package com.sikiedu.util;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.sikiedu.model.Goods;

public class JsonTest {
	
	public static void main(String[] args) {
		
		// ĞòÁĞ»¯ ³Ö¾Ã»¯
//		Goods goods = new Goods("Ïã½¶","ÏÄÍşÒÄÏã½¶",100,400);
//		String json = JSON.toJSONString(goods);
//		System.out.println(json);
		//·´ĞòÁĞ»¯  json½âÎö
//		String s = "{\"des\":\"ÏÄÍşÒÄÏã½¶\",\"inventory\":400,\"name\":\"Ïã½¶\",\"price\":100}";
//		Goods goods = JSON.parseObject(s, Goods.class);
//		System.out.println(goods.getName());
//		System.out.println(goods.getDes());
//		System.out.println(goods.getPrice());
//		System.out.println(goods.getInventory());
		
		String s = "[{" + 
				"	\"name\":\"Midheal\"," + 
				"	\"age\":20," + 
				"	\"sex\":\"ÄĞ\"" + 
				"}," + 
				"{" + 
				"	\"name\":\"Micsdfheal\"," + 
				"	\"age\":21," + 
				"	\"sex\":\"ÄĞ\"" + 
				"}," + 
				"{" + 
				"	\"name\":\"Micsdfsdfeal\"," + 
				"	\"age\":22," + 
				"	\"sex\":\"ÄĞ\"" + 
				"}" + 
				"]";
		List<UserTest> list = JSON.parseArray(s, UserTest.class);
		for(UserTest ut : list) {
			System.out.println(ut);
		}
	}
}
