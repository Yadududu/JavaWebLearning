package com.sikiedu.exception;

import java.util.ArrayList;

public class ExceptionDemo01 {
	
	public static void main(String[] args) throws Exception {
		
//		try {
//			//list目前为空，因为还没有new，是不能使用的
//			ArrayList<Integer> list = null;
//			
//			list.add(34);
//			list.add(344);
//		}catch(NullPointerException e) {
////			System.out.println("出现了空指针异常");
//			throw e;
//		}
//		
//		try {
			test(19);
			test(0);
			test(200);
			test(-90);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
	}
	
	
	public static void test(int age) throws Exception  {
		if(age>=0&&age<18) {
			System.out.println("未成年人");
		}else if(age>=18&&age<=150) {
			System.out.println("成年人");
		}else {
			throw new Exception("年龄输入不合法");
		}
	}
	
}
