package co.yedam.board;

import java.util.Scanner;

public class BoardApp {

	Scanner scan = new Scanner(System.in);
	Board[] boards = new Board[50];
	int idx = 0;

	// 등록 메서드
	void regist() {
		Board board = new Board();

		int no = getNo();
		String title = printMsgString("제목");
		String body = printMsgString("내용");
		String user = printMsgString("작성자");

		board.setNo(no + 1);
		board.setTitle(title);
		board.setBody(body);
		board.setUser(user);

		boards[idx] = board;

		System.out.println("정상적으로 등록되었습니다!");
		idx++;
	}

	// 목록
	void showList() {
		// 중간에 삭제된 데이터가 있을 수 있으니 새로운 배열에 저장해서 정렬..
		int cnt = 0;
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] == null)
				cnt++;
		}

		Board[] newAry = new Board[boards.length - cnt];

		int idx = 0;
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null) {
				newAry[idx] = boards[i];
				idx++;
			}
		}

		sortAry(newAry);

		System.out.println("-----------------------------------------------------------");
		System.out.printf("%-5s\t %-30s\t\t %-15s\n", "글번호", "제목", "작성자");
		System.out.println("-----------------------------------------------------------");

		for (int i = 0; i < newAry.length; i++) {
			if (newAry[i] != null) {
				// System.out.println(boards[i].toString());
				newAry[i].print();
			}
		}
		System.out.println("-----------------------------------------------------------");
	}

	// 상세보기
	void showDetail() {
		int no = printMsgInt("글번호");
		int cnt = 0;
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && no == boards[i].getNo()) {
				System.out.println(boards[i].toString());
				cnt++;
			}
		}
		if (cnt == 0) {
			System.out.println("삭제되었거나 존재하지 않는 글번호 입니다.");
		}
	}

	// 수정
	void edit() {
		int no = printMsgInt("글번호");
		String newTitle = printMsgString("제목");
		String newBody = printMsgString("글내용");

		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && no == boards[i].getNo()) {
				boards[i].setTitle(newTitle);
				boards[i].setBody(newBody);
				break;
			}
		}

		System.out.println("정상적으로 수정되었습니다!");
	}

	// 삭제
	void del() {
		int no = printMsgInt("글번호");

		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && no == boards[i].getNo()) {
				boards[i] = null;
				break;
			}
		}

		System.out.println(no + "번 글이 삭제되었습니다!");
	}

	// 메시지 출력 후 번호 입력받는 메서드
	int printMsgInt(String msg) {
		System.out.print(msg + " >> ");

		return Integer.parseInt(scan.nextLine());
	}

	// 메시지 출력 후 문자열 입력받는 메서드
	String printMsgString(String msg) {
		System.out.print(msg + ">> ");

		return scan.nextLine();
	}

	// 등록 번호 구하기
	int getNo() {
		// 게시판 배열에 등록된 no를 새로운 배열에 저장하고, 최대값을 찾기
		int cnt = 0;
		int max = 0;
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null)
				cnt++;
		}

		// 새로운 배열에 저장
		int[] nums = new int[cnt];
		int idx = 0;
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null) {
				nums[idx] = boards[i].getNo();
				idx++;
			}
		}

		// 최대값 구하기
		for (int i = 0; i < nums.length; i++) {
			if (max < nums[i]) {
				max = nums[i];
			}
		}

		return max;
	}

	// 정렬
	void sortAry(Board[] arys) {
		// 배열에 저장된 데이터 개수 카운트
		int cnt = 0;
		for (int i = 0; i < arys.length; i++) {
			if (arys[i] != null)
				cnt++;
		}

		// 정렬 반복문
		for (int i = 0; i < cnt - 1; i++) {// 마지막 값은 비교하지 않아도 되니 -1
			if (arys[i] != null) {
				for (int j = 0; j < cnt - 1; j++) {
					if (arys[j] != null && arys[j].getNo() > arys[j + 1].getNo()) {
						Board tmp = arys[j];
						arys[j] = arys[j + 1];
						arys[j + 1] = tmp;
					} else if (arys[j] == null) {
						j--;
					}
				}
			} else if (arys[i] == null) {
				i--;
			}
		}
	}

	// 게시판 프로그램 실행
	static void run() {
		BoardApp app = new BoardApp();
		boolean run = true;

		while (run) {
			System.out.println("\n| 1.등록 | 2.목록 | 3.상세보기 | 4.수정 | 5.삭제 | 6.종료 |");
			int menu = app.printMsgInt("선택");

			switch (menu) {
			case 1:
				// 등록
				app.regist();
				break;
			case 2:
				// 목록
				app.showList();
				break;
			case 3:
				// 상세보기
				app.showDetail();
				break;
			case 4:
				// 수정
				app.edit();
				break;
			case 5:
				// 삭제
				app.del();
				break;
			case 6:
				// 종료
				System.out.println("::::: 프로그램 종료 :::::");
				run = false;
			}
		}

	}

}
