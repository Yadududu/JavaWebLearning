package com.lmj.dao;

import java.beans.PropertyVetoException;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.lmj.bean.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class UserDaoImpl implements UserDao {

	private static ComboPooledDataSource dataSource;
	public static void setDataSource(ComboPooledDataSource dataSource) {
		UserDaoImpl.dataSource = dataSource;
	}
	
	
//	static {
//		//����c3p0 //�������ݿ� c3p0
//		try {
//			dataSource = new ComboPooledDataSource();
//			dataSource.setDriverClass("com.mysql.jdbc.Driver");
//			dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/ssm_spring?useSSL=false");
//			dataSource.setUser("root");
//			dataSource.setPassword("root");
//		} catch (PropertyVetoException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	

	@Override
	//ͨ�����ݿ��ȡ�û�
	public User getUserByInfo(User u) {
		try {
			//ʹ��dbutils�������ݿ�,��ѯ�������û�����
			QueryRunner qr = new QueryRunner(dataSource);
			String sql = "select * from user where u_username = ? and u_password = ?";
			return qr.query(sql, new BeanHandler<User>(User.class),u.getU_username(),u.getU_password());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}