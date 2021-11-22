package com.kh.exercise.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Exercis_01_jdbc {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet result = null;
		
		String sql = "SELECT * FROM TEST";
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("드라이버 등록 성공");
			
			conn = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe", "JDBC","JDBC");
			System.out.println("Connection 객체 생성!");
			stmt = conn.createStatement();
			System.out.println("Statement 객체 생성!!");
			result = stmt.executeQuery(sql);
			
			
			while(result.next()) {
				int tNo = result.getInt("TNO");
				String tName = result.getString("TNAME");
				Date tDate = result.getDate("TDATE");
				
				System.out.println(tNo+ ", " + tName + ", " + tDate);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				result.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
//		Scanner sc = new Scanner(System.in);
//		
//		
//		System.out.println("너 번호가 뭐니?");
//		int num = sc.nextInt();
//		sc.nextLine();
//		System.out.println("너 이름이 뭐니?");
//		String name = sc.nextLine();
//		
//		int result = 0;
//		Connection conn = null;
//		Statement stmt = null;
//		
//		String sql = "INSERT INTO TEST VALUES("+num+", +'"+name+"', SYSDATE)";
//		
//		try {
//			Class.forName("oracle.jdbc.OracleDriver");
//			System.out.println("드라이브 생성완료");
//			conn = DriverManager.getConnection
//					("jdbc:oracle:thin:@localhost:1521:xe","JDBC","JDBC");
//			System.out.println("Connection 겍체 생성!");
//			stmt = conn.createStatement();
//			System.out.println("Statement 객체 생성!");
//			
//			result = stmt.executeUpdate(sql);
//			
//			if(result > 0) {
//				conn.commit();
//			}else {
//				conn.rollback();
//			}
//			
//			
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				conn.close();
//				stmt.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			
//		}
//		if(result > 0) {
//			System.out.println("insert 성공^^");
//		}else System.out.println("insert 실패!");
//		
//		
//		
//		
	}

}
