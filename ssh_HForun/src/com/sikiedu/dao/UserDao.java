package com.sikiedu.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.sikiedu.domain.User;
import com.yl.lain.utils.C3p0DataSourceUtils;

public class UserDao {

	public void addUser(User user) throws SQLException {
		
		QueryRunner runner = new QueryRunner(C3p0DataSourceUtils.getDataSource());
		String sql = "insert into user values(?,?,?,?,?,?)";
		runner.update(sql,user.getId(),user.getUsername(),user.getPassword(),user.getName(),user.getEmail(),user.getTelephone());
	}

	
	
}
