package com.kh.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.kh.controller.MemberController;
import com.kh.model.vo.Member;

public class MemberView {

	// 사람추가, 전체 조회, 아이디로 검색, 이름 키워드로 검색, 회원 수정, 회원 삭제,프로그램 종료
	Scanner sc = new Scanner(System.in);
	MemberController mc = new MemberController();

	public void mainMenu() {
		while (true) {
			System.out.println("아냐세염 회원 관리시스템임다.");
			System.out.println("원하시는 시스템을 골라주세여~.~");
			System.out.println("1. 회원 등록");
			System.out.println("2. 회원 전체 조회");
			System.out.println("3. 아이디로 회원 검색하기");
			System.out.println("4. 키워드로 이름 검색하기");
			System.out.println("5. 회원 수정하기");
			System.out.println("6. 회원 삭제하기");
			System.out.println("0. 프로그램 종료하기");
			System.out.print("메뉴 입력 : ");
			int menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1:
				isertMember();
				break;
//			case 2:
//				selectAllMember();
//				break;
//			case 3:
//				searchByMemberId();
//				break;
//			case 4:
//				searchByKeyword();
//				break;
//			case 5:
//				updateMember();
//				break;
//			case 6:
//				deleteMember();
//				break;
			case 0:
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력하세영 ㅡㅡ");

			}

		}
	}

	private void isertMember() {
		System.out.println("----- 회원 등록하기 -----");
		System.out.print("등록할 회원 ID");
		String userId = sc.nextLine();

		System.out.println("비밀번호");
		String userPwd = sc.nextLine();

		System.out.println("이름");
		String userName = sc.nextLine();

		System.out.println("성별 (M/F)");
		String gender = sc.nextLine();

		System.out.println("나이");
		int age = sc.nextInt();
		sc.nextLine();

		System.out.println("Email");
		String email = sc.nextLine();

		System.out.println("전화번호");
		String phone = sc.nextLine();

		System.out.println("주소");
		String address = sc.nextLine();

		System.out.println("취미(띄어쓰기없이 , 로 나눠주세영)");
		String hobby = sc.nextLine();

		mc.insertMember(userId, userPwd, userName, gender, age, email, phone, address, hobby);

	}

	public void displaySuccess(String message) {

		System.out.println("\n요청에 성공했슴다 / " + message);

	}

	public void displayFail(String message) {

		System.out.println("\n요청에 실패했슴다 / " + message);

	}

	public void printList(ArrayList<Member> list) {

		Iterator it = list.iterator();

		System.out.println("\n" + list.size() + "건이 검색되었습니다.\n");
		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}
	
	public void noData(String message) {
		System.out.println(message);
	}
	
	public void displayOne(Member m ) {
		System.out.println("\n조회된 내용입니다.");
		System.out.println(m);
		
	}

}
