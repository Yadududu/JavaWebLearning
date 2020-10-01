package com.sikiedu.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.sikiedu.bean.User;
import com.sikiedu.bean.UserExample;
import com.sikiedu.mapper.UserMapper;

public class MapperTest {
	
	@Test
	public void Test1() throws IOException {
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource );
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = ssf.openSession();
		
		UserMapper mapper = session.getMapper(UserMapper.class);
		
		//按住键查询
		User user = mapper.selectByPrimaryKey(1);
		System.out.println(user);
	}
	
	@Test
	public void Test2() throws IOException {
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource );
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = ssf.openSession();
		
		UserMapper mapper = session.getMapper(UserMapper.class);
		
		UserExample example = new UserExample();
		//将条件封装到createCriteria集合中
		example.createCriteria().andUSexEqualTo("1").andUUsernameLike("%王%");
		
		//按条件查询
		List<User> list = mapper.selectByExample(example);
		
		for (User user : list) {
			System.out.println(user);
		}
	
	}
	
	@Test
	public void Test3() throws IOException {
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource );
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = ssf.openSession();
		
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = new User() ;
		user.setuUsername("赵云");
		
		mapper.insertSelective(user);
		
		session.commit();
	}
	
	
}
