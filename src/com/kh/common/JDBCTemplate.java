package com.kh.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {

	// JDBC과정 중 반복적으로 쓰이는 구문들을 각각 메서드로 정의해 둘 곳
	// "재사용할 목적"으로 공통 템플릿 작업 진행
 
	// 이 클래스에서의 모든 메서드들은 다 static 메서드로 만들것!!
	// 싱글톤패턴 : 메모리영역에 단 한번만 올라간 것을 재사용한 개념!

	// 공통적인 부분 뽑아내기

	// 1. DB와 접속된 Conenection 객체를 생성해서 반환시켜주는 메서드

	public static Connection getConnection() {
		
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","JDBC","JDBC");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
//	public static Statement getStatement() {
//		
//		Statement stmt = null;
//		Connection conn = getConnection();
//		try {
//			stmt = conn.createStatement();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		
//
//		return stmt;
//	}
	
	public static void close(Connection conn) {
		
		try {
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		
		try {
			if(stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void close(ResultSet rSet) {
		
		try {
			if(rSet != null && !rSet.isClosed()) {
				rSet.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void commit(Connection conn) {
		
		try {
			if(conn != null && !conn.isClosed()) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void rollback(Connection conn) {
		
		try {
			if(conn != null && !conn.isClosed()) {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}













}
