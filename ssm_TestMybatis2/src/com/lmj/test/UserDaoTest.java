package com.lmj.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.lmj.bean.User;
import com.lmj.dao.UserDao;
import com.lmj.dao.UserDaoImpl;

public class UserDaoTest {
	
	private static SqlSessionFactory ssf;
	
	static{
		String resource = "sqlMapConfig.xml";
		InputStream in;
		try {
			in = Resources.getResourceAsStream(resource);
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			ssf = ssfb.build(in);
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void DaoTest() {
		UserDao userDao = new UserDaoImpl(ssf);
		User user = userDao.getUserById(1);
		System.out.println(user);
	}
}
