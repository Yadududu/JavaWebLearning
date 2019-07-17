package com.lmj.dao;

import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.lmj.bean.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class UserDaoImpl implements UserDao{
	
	private static ComboPooledDataSource dataSource;
	
	static {
		//����c3p0 //�������ݿ� c3p0
		try {
			dataSource = new ComboPooledDataSource();
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
			dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/ssm_spring?useSSL=false");
			dataSource.setUser("root");
			dataSource.setPassword("root");
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public User selectUserById(Integer id) {
		JdbcTemplate jt = new JdbcTemplate(dataSource);
		
		String sql = "select * from user where u id =?";
		User user = jt.queryForObject(sql, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int index) throws SQLException {
				// TODO Auto-generated method stub
				User u = new User();
				u.setU_id(rs.getInt("u_id"));
				u.setU_username(rs.getString("u_username"));
				u.setU_password(rs.getString("u_password"));
				return u;
			}
			
		},id);
		
		return user;
	}

	@Override
	public void saveUser(User u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(User u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> selectAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer selectUserCount() {
		// TODO Auto-generated method stub
		return null;
	}
}