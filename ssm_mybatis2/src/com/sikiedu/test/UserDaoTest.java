package com.sikiedu.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.sikiedu.bean.User;
import com.sikiedu.dao.UserDao;
import com.sikiedu.dao.UserDaoImpl;

public class UserDaoTest {
	
	//sqlSession工厂
	private static SqlSessionFactory ssf;
	
	static {
		String resource = "sqlMapConfig.xml";
		InputStream in;
		try {
			in = Resources.getResourceAsStream(resource );
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			 ssf = ssfb.build(in);
			 in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void DaoTest() {
		UserDao dao = new UserDaoImpl(ssf);
		User user = dao.getUserById(1);
		System.out.println(user);
	}
	
}
