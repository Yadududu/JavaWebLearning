package com.sikiedu.jdbc01;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0DataSource {
	private static final String connectionURL="jdbc:mysql://localhost:3306/web01?useUnicode=true&characterEncoding=UTF8&useSSL=false" ;
	private static final String username = "root";
	private static final String password = "root";
	
	private static ComboPooledDataSource ds ;
	
	static {
		try {
			ds = new ComboPooledDataSource();
			ds.setDriverClass("com.mysql.jdbc.Driver");
			ds.setJdbcUrl(connectionURL);
			ds.setUser(username);
			ds.setPassword(password);
			
			ds.setInitialPoolSize(5);
			ds.setMaxPoolSize(20);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection() {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void close(ResultSet rs,Statement stmt,Connection con) {
		closeResultSet(rs);
		closeStatement(stmt);
		closeConnection(con);
	}
	public static void close(Statement stmt1,Statement stmt2,Connection con) {
		closeStatement(stmt1);
		closeStatement(stmt2);
		closeConnection(con);
	}
	
	
	private static void closeResultSet(ResultSet rs ) {
		try {
			if(rs!=null)rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void closeStatement(Statement stmt) {
		try {
			if(stmt!=null)
				stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void closeConnection(Connection con) {
		try {
			if(con!=null)con.close();//这里会把链接归还给连接池，并不是真正的断开链接
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
