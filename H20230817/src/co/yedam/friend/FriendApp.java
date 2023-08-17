package co.yedam.friend;

import java.util.Scanner;

public class FriendApp {
	// 배열 > 컬렉션(ArrayList, HashMap... 등) > 외부 파일 입출력(Stream?) > DB에 저장
	Friend[] friends = new Friend[10];
	Scanner scn = new Scanner(System.in);

	// 컨트롤(매개변수의 값이 어떻게 처리되는지 보기위해)
	// 사용자의 입력을 받아서 처리 하기 위한 기능..
	public void start() {
		boolean run = true;
		int menu = -1;

		while (run) {
			System.out.println("\n| 1.추가 | 2.조회 | 3.수정 | 4.삭제 | 5.종료 |");
			System.out.print("선택 >> ");
			menu = scn.nextInt(); // [3 엔터] 치면 엔터가 처리안되고 남아있게 됨.
			scn.nextLine(); // 엔터키를 소진시켜주는 코드가 필요.

			switch (menu) {
			case 1:
				addFriend();
				break;
			case 2:
				search();
				break;
			case 3:
				modify();
				break;
			case 4:
				remove();
				break;
			case 5:
				System.out.println("::::: 시스템을 종료합니다! :::::");
				run = false;
				break;

			default:
				System.out.println("잘못된 매뉴입니다.");
			}

		}
	}

	//
	private String printString(String msg) {
		System.out.print(msg + ">> ");
		return scn.nextLine();
	}

	// 등록
	private void addFriend() {
		System.out.println("| 1.학교 | 2.회사 | 3.기타 |");
		System.out.print("선택 >> ");
		int subMenu = scn.nextInt();
		scn.nextLine(); // 엔터 처리

		Friend friend = null;
		String name = printString("이름입력");
		String phone = printString("연락처입력");

		if (subMenu == 1) {
			String univ = printString("학교입력");
			String major = printString("전공입력");
			friend = new UnivFriend(name, phone, univ, major);

		} else if (subMenu == 2) {
			String comp = printString("회사입력");
			String dept = printString("부서입력");
			friend = new CompFriend(name, phone, comp, dept);

		} else if (subMenu == 3) {
			friend = new Friend(name, phone);

		} else {
			System.out.println("잘못 누르셨습니다.");
		}

		// friends 배열에 담아주기.
		for (int i = 0; i < friends.length; i++) {
			if (friends[i] == null) {
				friends[i] = friend;
				break;
			}
		}

	}

	// 조회 : 이름을 입력 > 해당 친구의 정보만 출력 / 엔터를 입력 > 전체 조회
	private void search() {
		String in = printString("입력");
		int ctn = 0;

		if (in.equals("")) {
			for (int i = 0; i < friends.length; i++) {
				if (friends[i] != null) {
					System.out.println(friends[i].showInfo());
					ctn++;
				}
			}
		} else {
			for (int i = 0; i < friends.length; i++) {
				if (friends[i] != null && in.equals(friends[i].getName())) {
					System.out.println(friends[i].showInfo());
					ctn++;
					break;
				}
			}
		}

		if (ctn == 0) {
			System.out.println(in + ": 등록되지 않았습니다.");
		}
	}

	// 수정 : 연락처 수정
	private void modify() {
		int ctn = 0;
		String name = printString("이름입력");

		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null && name.equals(friends[i].getName())) {
				String phone = printString("연락처입력");
				friends[i].setPhone(phone);
				System.out.println("정상적으로 수정됐습니다!");
				ctn++;
				break;
			}
		}
		if (ctn == 0) {
			System.out.println(name + ": 등록되지 않았습니다.");
		}
	}

	// 삭제
	private void remove() {
		int ctn = 0;
		String name = printString("이름입력");

		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null && name.equals(friends[i].getName())) {
				friends[i] = null;
				System.out.println("정상적으로 삭제됐습니다!");
				ctn++;
				break;
			}
		}
		if (ctn == 0) {
			System.out.println(name + ": 등록되지 않았습니다.");
		}
	}
}
