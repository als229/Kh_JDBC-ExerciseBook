package com.kh.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kh.model.vo.Member;

public class MemberDao {
	/**
	 * JDBC 용 객체 - Connection : DB의 연결정보를 담고 있는 객체(ip주소 , port 번호, 계정명, 비밀번호) -
	 * (Prepared) Statement : 해당 DB에 SQL문을 전달하고 실행한 후 결과를 받아내는 객체 - ResultSet : 만일
	 * 실행한 SQL문이 SELECT문일 경우 조회된 결과들이 담겨있는 객체
	 * 
	 * ** PreparedStatement 특징 : SQL문을 바로 실행하지 않고 잠시 보관하는 개념 미완성된 SQL문을 먼저 전달하고
	 * 실행하기전에 완성형태로 만든 후 실행만 하면 됨 미완성된 SQL문 만들기(사용자가 입력한 값들이 들어갈 수 있는 공간을 ?(위치홀더, 테스쳐마크)로
	 * 확보) 각 위치홀더에 맞는 값들을 세팅 ** Statement(부모)와 PreparedStatement(자식) 관계 *차이점 1)
	 * Statement 는 완성된 SQL문, PreparedStatement는 미완성된 SQL문
	 * 
	 * 2) Statement 객체 생성시 stmt = conn.createStatement(); PreparedStatement 객체 생성 시
	 * pstmt = conn.prepareStatement(sql);
	 * 
	 * 3) Statement 로 SQL문 실행 시 결과 = stmt.excuteXXX(sql); PreparedStatement 로 SQL문
	 * 실행시 ?로 빈 공간을 실제 값으로 채워 준뒤 실행한다. pstmt.setString(?위치, 실제값); pstmt.setInt(?위치,
	 * 실제값); 결과 = pstmt.executeXXXX();
	 * 
	 * ** JDBC 처리순서 1) JDBC Driver 등록 : 해당 DBMS가 제공하는 클래스 등록 2) Connection 객체 생성 :
	 * 접속하고자 하는 DB의 정보를 입력해서 DB에 접속하면서 생성(url, 계정, 비번) 3_1) PreparedStatement 객체 생성
	 * : Connection객체를 이용해서 생성(미완성된 SQL문을 담아서) 3_2) 현재 미완성된 SQL문을 완성형태로 채우기 => 미완성된
	 * 경우에만 해당 / 완성된 경우에는 생략 가능 4) SQL문 실행 : executeXXX() = sql 매개변수 없음!! > SELECT문의
	 * 경우 : executeQuery() 메서드호출 > 나머지 DML문의 경우 : executeUpdate() 메서드호출 5) 결과 받기 >
	 * SELECT문의 경우 : ResultSet 객체(조회된 데이터들이 담겨있음)로 받기 =>6_1) > 나머지의 DML의 경우 :
	 * int형(처리된 행의 갯수)으로 받기 => 6_2)
	 *
	 * 6_1) ResultSet에 담겨있는 데이터들을 하나씩 뽑아서 VO객체에 담기(많으면 ArrayList로 관리) 6_2)
	 * 트랜젝션처리(성공이면 COMMIT, 실패면 ROLLBACK) 7) 다 쓴 JDBC용 객체들은 반드시 자원반납(close()) => 생성된
	 * 순서의 역순으로!!! 8) 결과 반환() > SELECT 문의 경우 6_1) 에서 만들어진 결과 > 나머지 DML문의 경우 처리된 행의
	 * 갯수
	 */
	

	
}
