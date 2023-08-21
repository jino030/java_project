package co.yedam.friend;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class FriendApp {
	// 추가, 수정, 삭제, 목록:

	// 필드,
	Map<String, String> userList = new HashMap<>();
	Scanner scan = new Scanner(System.in);
	List<Friend> friends = new ArrayList<Friend>();

	// 생성자,
	public FriendApp() {
		userList.put("user1", "1234");
		userList.put("user2", "5678");
		userList.put("user3", "9087");
	}

	private boolean userCheck() {
		while (true) {
			System.out.print("\nid>> ");
			String id = scan.nextLine();
			String pw = "";

			// 입력한 id,pw가 일치하는지 검증
			if (userList.containsKey(id)) { // key(id)가 존재하면
				// 비밀번호 입력 받기
				System.out.print("pw>> ");
				pw = scan.nextLine();
			} else {
				System.out.println("존재하지 않는 아이디 입니다.");
				continue;
			}

			// key 반환 (keySet() : key를 담아주는 메서드)
			Set<String> keyset = userList.keySet();
			
			for (String key : keyset) { // 해당 key(id)의 pw 검증
				String val = userList.get(key);
				if (key.equals(id) && val.equals(pw)) { // id, pw 일치
					return true;
				}
			}
			return false;
		}
	}

	public void start() {
		boolean run = true;
		int menu = -1;

		while (true) {
			if (userCheck()) {
				break;
			}
			System.out.println("로그인 실패..");
		}
		while (run) {
			System.out.println("\n| 1.추가 | 2.수정 | 3.삭제 | 4.목록 | 5.종료 |");
			System.out.print("선택>> ");

			try {
				menu = scan.nextInt();
			} catch (InputMismatchException e) {
				// menu : -1 => 오류발생 시 default 실행
			} finally {
				scan.nextLine(); // 엔터처리
			}

			switch (menu) {
			case 1:
				add();
				break;
			case 2:
				edit();
				break;
			case 3:
				del();
				break;
			case 4:
				list();
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				run = false;
				break;
			default:
				System.out.println("메뉴는 1~5 까지 선택 가능..");
				break;
			}
		}

	}

	SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");

	private void add() {
		System.out.print("이름>> ");
		String name = scan.nextLine();
		System.out.print("연락처>> ");
		String phone = scan.nextLine();
		System.out.print("생일(980805)>> ");
		try {
			Date birth = sdf.parse(scan.nextLine());
			friends.add(new Friend(name, phone, birth));
		} catch (ParseException e) {
			System.out.println("날짜형식이 아닙니다. (ex. 980805)");
		}

	}

	private void edit() {
		if (friends.size() > 0) {
			System.out.print("이름>> ");
			String name = scan.nextLine();
			for (int i = 0; i < friends.size(); i++) {
				if (name.equals(friends.get(i).getName())) {
					System.out.print("연락처(수정)>> ");
					String phone = scan.nextLine();
					friends.get(i).setPhone(phone);
					System.out.println(name + "님의 정보가 정상적으로 수정되었습니다.");
					break;
				} else {
					System.out.println("일치하는 정보가 없습니다.");
				}
			}
		} else {
			System.out.println("등록된 친구는 " + friends.size() + "명 입니다.");
		}
	}

	private void del() {
		if (friends.size() > 0) {
			System.out.print("이름>> ");
			String name = scan.nextLine();
			for (int i = 0; i < friends.size(); i++) {
				if (name.equals(friends.get(i).getName())) {
					friends.remove(i);
					System.out.println(name + "님의 정보가 정상적으로 삭제되었습니다.");
					break;
				} else {
					System.out.println("일치하는 정보가 없습니다.");
				}
			}
		} else {
			System.out.println("등록된 친구는 " + friends.size() + "명 입니다.");
		}
	}

	private void list() {
		if (friends.size() > 0) {
			for (int i = 0; i < friends.size(); i++) {
				System.out.println(friends.get(i).toString());
			}
		} else {
			System.out.println("등록된 친구는 " + friends.size() + "명 입니다.");
		}
	}

}
