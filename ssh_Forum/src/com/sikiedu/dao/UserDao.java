package com.sikiedu.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.sikiedu.domain.User;
import com.yl.lain.utils.C3p0DataSourceUtils;

public class UserDao {

	public User findUser(User user) throws SQLException {
		
		QueryRunner runner = new QueryRunner(C3p0DataSourceUtils.getDataSource());
		String sql = "select * from user where username = ? and password = ?";
		return runner.query(sql, new BeanHandler<User>(User.class),user.getUsername(),user.getPassword());
	}

}
