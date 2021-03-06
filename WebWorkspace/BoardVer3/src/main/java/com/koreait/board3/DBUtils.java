package com.koreait.board3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {
//  잘 되는지 확인하기 위한 것
//	public static void main(String[] args) {
//		try {
//			getCon();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
					//다리놓는 작업
	public static Connection getCon() throws Exception {
		final String DRIVER = "com.mysql.cj.jdbc.Driver";
		final String URL = "jdbc:mysql://localhost:3308/boardver3"; //jdbc:DBMS명://IP주소:포트번호(디폴트3306)/DB명;
		final String USER_NAME = "root";
		final String PASSWORD = "koreait";

		Class.forName(DRIVER); //생략가능
		Connection con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		System.out.println("연결성공");
		return con;

	}
	
	public static void close(Connection con, PreparedStatement ps) {
		close(con,ps,null);
	}
	
	
	public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
		if(rs != null) {
			try {rs.close();} catch(SQLException e) {e.printStackTrace();}
		}
		
		if(ps != null) {
			try {ps.close();} catch(SQLException e) {e.printStackTrace();}
		}
		
		if(con != null) {
			try {con.close();} catch(SQLException e) {e.printStackTrace();}
		}
	}
}
