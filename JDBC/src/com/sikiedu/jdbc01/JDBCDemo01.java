package com.sikiedu.jdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class JDBCDemo01 {
	public static void main(String[] args) {
		selectAll();
		//登录校验
//		System.out.println(selectByUsernamePassword("Micheal", "d123"));
		//sql注入
//		System.out.println(selectByUsernamePassword("xxsdf", "sdfds' or '1'='1"));
		
//		System.out.println(selectByUP2("Micheal", "123"));
		
//		System.out.println(selectByUP2("xxsdf", "sdfds' or '1'='1"));
		
		//分页查询
//		selectUserByPage(3, 4);
		
//		selectAll();
		
//		insert("东方不败", "123456");
		
//		delete(32);
		
//		update(33, "");
		
//		transferAccounts("东方不败", "令狐冲", 1000);
	}
	
	public static void selectAll() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = JDBCUtils.getConnection();
			
			stmt = con.createStatement();
			
			rs = stmt.executeQuery("select * from user");//excuteXXX
			
			//跟iterator遍历器
			while(rs.next()) {
//				System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3));
				System.out.println(rs.getInt("id")+","+rs.getString("username")+","+rs.getString("password"));
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			
			JDBCUtils.close(rs, stmt, con);
			
		}
	}

	public static boolean selectByUsernamePassword(String username,String password) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/siki?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=Asia/Shanghai&zeroDateTimeBehavior=CONVERT_TO_NULL";
			con = DriverManager.getConnection(url, "root", "root");
			
			stmt = con.createStatement();
			
			String sql = "select * from user where username = '"+username+"' and password = '"+password+"'";
			System.out.println(sql);
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

				
			try {
				if(stmt!=null)
					stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				if(con!=null)con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return false;
	}
	
	public static boolean selectByUP2(String username,String password) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/web01?useUnicode=true&characterEncoding=UTF8&useSSL=false";
			con = DriverManager.getConnection(url, "root", "root");
			
			String sql = "select * from user where username = ? and password = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery();
			if(rs.next())return true;
			else return false;
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

				
			try {
				if(stmt!=null)
					stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				if(con!=null)con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return false;
	}
	
	// pageNumber是页数，第几页  pageCount是每页显示多少条数据
	public static void selectUserByPage(int pageNumber,int pageCount) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");//使用什么驱动连接数据库

			//String url = "jdbc:mysql://localhost:3306/web01";
			String url = "jdbc:mysql://localhost:3306/web01?useUnicode=true&characterEncoding=UTF8&useSSL=false";
			String user = "root";
			String password ="root";
			con = DriverManager.getConnection(url, user, password);
			
			stmt = con.prepareStatement("select * from user limit ?,?");
			
			stmt.setInt(1, (pageNumber-1)*pageCount );
			stmt.setInt(2, pageCount);
			
			rs = stmt.executeQuery();
			
			//跟iterator遍历器
			while(rs.next()) {
//				System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3));
				System.out.println(rs.getInt("id")+","+rs.getString("username")+","+rs.getString("password"));
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			
			try {
				if(rs!=null)rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

				
			try {
				if(stmt!=null)
					stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				if(con!=null)con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	// crud  create read update delete
	
	public static void insert( String username,String password ) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = JDBCUtils.getConnection();
			
			String sql = "insert into user(username,password) values(?,?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, password);
			int result =stmt.executeUpdate();// 返回值代表收到影响的行数
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(rs, stmt, con);
		}
	}
	
	public static void delete(int id) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = JDBCUtils.getConnection();
			
			String sql = "delete from user where id = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			int result =stmt.executeUpdate();// 返回值代表收到影响的行数
			if(result>0) {
				System.out.println("删除成功");
			}else {
				System.out.println("删除失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(rs, stmt, con);
		}
	}
	
	public static void update(int id,String newPassword) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = JDBCUtils.getConnection();
			
			String sql = "update user set password = ? where id = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, newPassword);
			stmt.setInt(2, id);
			int result =stmt.executeUpdate();// 返回值代表收到影响的行数
			if(result>0) {
				System.out.println("修改成功");
			}else {
				System.out.println("修改失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(rs, stmt, con);
		}
	}

	//事务
	// 余额   a b 
	
	//放在一个事务里面
	// a -1000
	//断电 数据库崩溃
	// b +1000
	public static void transferAccounts(String username1,String username2,int money) {
		Connection con = null;
		PreparedStatement stmt1 = null;
		PreparedStatement stmt2 = null;
		ResultSet rs = null;
		try {
//			con = JDBCUtils.getConnection();
			con = C3P0DataSource.getConnection();
			
			con.setAutoCommit(false);//开启事务
			
			String sql = "update user set balance = balance - ? where username = ?";
			stmt1 = con.prepareStatement(sql);
			stmt1.setInt(1, money);
			stmt1.setString(2, username1);
			stmt1.executeUpdate();// 返回值代表收到影响的行数
			
//			String s = null;
//			s.charAt(2);
			
			sql = "update user set balance = balance + ? where username = ?";
			stmt2 = con.prepareStatement(sql);
			stmt2.setInt(1, money);
			stmt2.setString(2, username2);
			stmt2.executeUpdate();// 返回值代表收到影响的行数
			
			con.commit();//提交事务
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			C3P0DataSource.close(stmt2, stmt1, con);
		}
	}
}
