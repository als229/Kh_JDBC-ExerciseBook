package com.kh.controller;

import com.kh.model.service.MemberService;
import com.kh.model.vo.Member;
import com.kh.view.MemberView;

public class MemberController {

	public void insertMember(String userId, String userPwd, String userName, String gender, int age, String email,
			String phone, String address, String hobby) {
		
		int result = 0;
		
		Member m = new Member(userId,userPwd,userName,gender,age,email,phone,address,hobby);
			result = new MemberService().insertMember(m);
		
		if(result > 0) {
			new MemberView().displaySuccess("회원 추가 성공!");
		}else {
			new MemberView().displayFail("회원 추가 실패 ~");
		}
		
	}

	
	/*
	public void selectAllMember() {

		ArrayList<Member> list = new MemberDao().selectAllMember();

		if (list.isEmpty()) {
			new MemberView().displayNodata("조회할게 없슴다");
		} else {
			new MemberView().displayList(list);

		}

	}

	public void selectByKeyword(String keyword) {

		ArrayList<Member> list = new MemberDao().selectByKeyword(keyword);

		if (list.isEmpty()) {
			new MemberView().displayNodata("조회할게 없잖여");
		} else {
			new MemberView().displayList(list);
		}

	}

	public void selectByUserId(String UserId) {
		Member m = new MemberDao().selectByUserId(UserId);

		if (m.getUserId() == null) {
			new MemberView().displayNodata("그런 아이디 없는데영?");
		} else {
			new MemberView().displayOne(m);
		}

	}

	public void updateMember(String userId, String userPwd, String email, String phone, String address) {

		int result = new MemberDao().updateMember(userId, userPwd, email, phone, address);

		if (result > 0) {
			new MemberView().displaySuccess("수정에 성공하셨슴다");
		} else {
			new MemberView().displayFail("그런 아이디 없나봐용??");
		}
	}

	public void deleteMember(String userId) {

		int result = new MemberDao().deleteMember(userId);

		if (result > 0) {
			new MemberView().displaySuccess("삭제에 성공하셨슴다");
		} else {
			new MemberView().displayFail("그런 아이디 없나봐용??");
		}

	}
*/
}
