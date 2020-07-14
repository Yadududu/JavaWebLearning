package com.sikiedu.jdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//dbcp c3p0 数据源
public class JDBCUtils {
	
	private static final String connectionURL="jdbc:mysql://localhost:3306/siki?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=Asia/Shanghai&zeroDateTimeBehavior=CONVERT_TO_NULL";
	private static final String username = "root";
	private static final String password = "root";
	
	private static ArrayList<Connection> conList = new ArrayList<Connection>();
	
	static {
		for(int i =0;i<5;i++) {
			Connection con = createConnection();
			conList.add(con);
		}
	}
	
	public static Connection getConnection() {
		if(conList.isEmpty()==false) {
			Connection con = conList.get(0);
			conList.remove(con);
			return con;
		}else {
			return createConnection();
		}
	}
	
	
	private static Connection createConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			return DriverManager.getConnection(connectionURL, username, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print("打不进开");
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
//		try {
//			if(con!=null)con.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		conList.add(con);
	}
}
