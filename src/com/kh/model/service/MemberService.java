package com.kh.model.service;

import java.sql.Connection;

import com.kh.common.JDBCTemplate;
import com.kh.model.dao.MemberDao;
import com.kh.model.vo.Member;

/*
	Service : 기존의 DAO의 역할을 분담
			  컨트롤에서 서비스 호출(Connection 객체 생성) 후 서비스를 거쳐서
			  DAO로 넘어갈 것
 			  DAO 호출시 커넥션 객체와 기존에 넘기고자 했던 매개변수를 같이 넘겨줌
 			  DAO 처리가 끝나면 서비스단에서 결과에 따른 트랜잭션 처리도 같이 해줌
 			  => 서비스 단을 추가함으로써 DAO에는 순수하게 SQL문을 처리하는 부분만 남음
 */



public class MemberService {

	public int insertMember(Member m) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		// DAO 호출 시 Connection 객체와 기존에 넘기고자 했던 매개변수를 같이 넘김
		int result = new MemberDao().insertMember(conn,m);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		// Connection 객체 반납
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	
	
	
}
