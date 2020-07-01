package com.lmj.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.lmj.bean.User;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	@Override
	public User getUserById(Integer id) {
		
		//生产一个sqlSession
		//SqlSession session = ssf.openSession();
		SqlSession session = getSqlSession();
		//操作数据库
		//参数1：要操作的sql语句   参数2 sql语句的参数
		return session.selectOne("UserMapper.selectUserById", 1);
	}

}
