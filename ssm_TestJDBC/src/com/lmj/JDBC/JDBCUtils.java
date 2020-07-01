package com.lmj.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtils {
	
	public static final String ConnectionUrl = "jdbc:mysql://localhost:3306/ssm_mybatis?serverTimezone=UTC";
	public static final String Username = "root";
	public static final String Password = "root";

	public static Connection GetConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(ConnectionUrl, Username, Password);
			
	} 
	
	public static void Close(Connection con,PreparedStatement ps,ResultSet rs) throws SQLException {
		if(con!=null)con.close();
		if(ps!=null)ps.close();
		if(rs!=null)rs.close();
	}
}
