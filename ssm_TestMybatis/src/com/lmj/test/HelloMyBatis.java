package com.lmj.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.lmj.bean.User;

public class HelloMyBatis {
	@Test
	//入门程序 通过ID 查询用户
	public void text1() throws IOException {
		String resource = "sqlMapConfig.xml";
		
		//读取配置文件
		InputStream in = Resources.getResourceAsStream(resource);
		//需要sqlSessionFactoryBulider
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		//创建sqlSessionfactory
		SqlSessionFactory ssf = ssfb.build(in);
		//生产一个sqlSession
		SqlSession session = ssf.openSession();
		//操作数据库
		//参数1：要操作的sql语句   参数2 sql语句的参数
		User user = session.selectOne("UserMapper.selectUserById", 1);
		System.out.println(user);
	}
	@Test
	//入门程序 模糊查询  查询用户
	public void text2() throws IOException {
		String resource = "sqlMapConfig.xml";
		
		//读取配置文件
		InputStream in = Resources.getResourceAsStream(resource);
		//需要sqlSessionFactoryBulider
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		//创建sqlSessionfactory
		SqlSessionFactory ssf = ssfb.build(in);
		//生产一个sqlSession
		SqlSession session = ssf.openSession();
		//操作数据库
		//参数1：要操作的sql语句   参数2 sql语句的参数
		List<User> list = session.selectList("UserMapper.selectUserByName","王");
		for(User user:list) {
			System.out.println(user);
		}
	}
	@Test
	//入门程序	添加用户
	public void text3() throws IOException {
		String resource = "sqlMapConfig.xml";
		
		//读取配置文件
		InputStream in = Resources.getResourceAsStream(resource);
		//需要sqlSessionFactoryBulider
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		//创建sqlSessionfactory
		SqlSessionFactory ssf = ssfb.build(in);
		//生产一个sqlSession
		SqlSession session = ssf.openSession();
		//操作数据库
		User u = new User();
		u.setU_username("小明");
		u.setU_password("123");
		u.setU_sex("1");
		u.setU_createTime(new Date());
		u.setU_cid(1);
		
		session.insert("UserMapper.insertUser",u);
		session.commit();
	}
	@Test
	//入门程序	修改用户
	public void text4() throws IOException {
		String resource = "sqlMapConfig.xml";
		
		//读取配置文件
		InputStream in = Resources.getResourceAsStream(resource);
		//需要sqlSessionFactoryBulider
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		//创建sqlSessionfactory
		SqlSessionFactory ssf = ssfb.build(in);
		//生产一个sqlSession
		SqlSession session = ssf.openSession();
		//操作数据库
		User u = new User();
		u.setU_id(14);
		u.setU_username("小彭");
		
		session.update("UserMapper.updateUser",u);
		session.commit();
	}
	@Test
	//入门程序	删除用户
	public void text5() throws IOException {
		String resource = "sqlMapConfig.xml";
		
		//读取配置文件
		InputStream in = Resources.getResourceAsStream(resource);
		//需要sqlSessionFactoryBulider
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		//创建sqlSessionfactory
		SqlSessionFactory ssf = ssfb.build(in);
		//生产一个sqlSession
		SqlSession session = ssf.openSession();
		//操作数据库
		session.delete("UserMapper.deleteUserById",16);
		session.commit();
	}
}
