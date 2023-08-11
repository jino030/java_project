package co.yedam.classes.friend;

import java.util.Scanner;

public class FriendApp {

	Friend[] friends = new Friend[10];
	Scanner scn = new Scanner(System.in);
	String name;

	// FriendApp 생성자(객체 생성시 초기화 담당)
	FriendApp() {

	}

	void addFriend() {
		System.out.print("이름 연락처 생년월일 >> ");
		String[] data = scn.nextLine().split(" ");
		// 19950828
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//		Date birth = null; // String => Date

		Friend friend = new Friend(data[0], data[1], data[2]);

		for (int i = 0; i < friends.length; i++) {
			if (friends[i] == null) {
				friends[i] = friend;
				break;
			}
		}
	}// end of addFriend()

	void list() {
		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null) {
				System.out.println(friends[i].toString());
			}
		}
	}// end of list()

	void findFriend() {
		System.out.print("이름 입력 >> ");
		name = scn.nextLine();

		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null && name.equals(friends[i].getName())) {
				System.out.println(friends[i].toString());
				break;
			}
		}
	}// end of findFriend()

	void editFriend() {
		System.out.print("이름 번호 입력 >> ");
		String[] data = scn.nextLine().split(" ");
		name = data[0];

		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null && name.equals(friends[i].getName())) {
				friends[i].setPhone(data[1]);
				break;
			}
		}

		System.out.println("::::: 정상적으로 수정되었습니다 :::::");
	}// end of editFriend()

	void delFriend() {
		System.out.print("이름 입력 >> ");
		name = scn.nextLine();

		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null && name.equals(friends[i].getName())) {
				friends[i] = null;
				break;
			}
		}

		System.out.println("::::: 삭제되었습니다 :::::");
	}// end of delFriend()

	static void start() {

		FriendApp app = new FriendApp();
		boolean run = true;

		while (run) {
			System.out.println("\n| 1.등록 | 2.목록 | 3.조회(이름) | 4.수정 | 5.삭제(이름) | 9.종료 |");
			System.out.print("선택 >> ");

			int menu = Integer.parseInt(app.scn.nextLine());

			switch (menu) {
			case 1:
				app.addFriend();
				break;
			case 2:
				app.list();
				break;
			case 3:
				app.findFriend();
				break;
			case 4:
				app.editFriend();
				break;
			case 5:
				app.delFriend();
				break;
			case 9:
				System.out.println("시스템을 종료합니다.");
				run = false;
			}// end of switch
		} // end of while
	}// end of start()

}
