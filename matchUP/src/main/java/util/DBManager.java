package main.java.util;

import java.sql.*;

public class DBManager {
	public static Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:mysql://database-1.c44jadddyzoj.ap-northeast-2.rds.amazonaws.com:3306/matchup?serverTimeZone=UTC";
		String username = "admin";
		String password = "4seiCcEF9Ec5pPWwaDLu";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Database 연동 성공");
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Database 연동 실패");			
		}
		
		return conn;
	}
	
	public static void close(Connection conn, PreparedStatement pstmt) {
		try {
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
