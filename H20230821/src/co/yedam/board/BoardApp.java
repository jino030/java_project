package co.yedam.board;

import java.util.List;
import java.util.Scanner;

// 컨트롤, 뷰 역할..
public class BoardApp {

	Scanner scn = new Scanner(System.in);
	BoardService service = new BoardServiceJdbc(); // 방식에따라 구현체만 변경해주면 된다.
	UserService uservice = new UserServiceImpl();
	String id = "";

	public void start() {
		// 사용자 체크
//		while(true){
//			User user = new User();
//			id = printString("id");
//			String pw = printString("pw");
//			user.setId(id);
//			user.setPw(pw);
//			
//			if(uservice.checkLogin(user)) {
//				System.out.println("[O] 로그인 성공!\n");
//				break;
//			}
//			System.out.println("[X] 로그인 실패!\n");
//		}

		boolean run = true;

		while (run) {
			System.out.println("");
			System.out.println("| 1.글등록 | 2.목록 | 3.수정 | 4.삭제 | 5.상세조회 | 9.종료 |");
			System.out.print("선택>> ");

			int menu = scn.nextInt();
			scn.nextLine(); // 엔터처리.

			switch (menu) {
			case 1: // 등록
				register();
				break;

			case 2: // 목록
				boardList();
				break;

			case 3: // 수정
				modify();
				break;

			case 4: // 삭제
				remove();
				break;

			case 5: // 상세조회
				boardDetail();
				break;

			case 9:
				service.save();
				System.out.println("종료합니다.");
				run = false;
				break;

			}
		}
		System.out.println("end of prog.");
	}// end of start.

	public String printString(String msg) {
		System.out.print(msg + ">> ");
		return scn.nextLine();
	}

	void register() {
		String title = printString("제목입력");
		String content = printString("내용입력");
		// String writer = printString("작성자입력");
		System.out.println("작성자: " + id);
		Board board = new Board(title, content, id);

		if (service.add(board)) { // 정상적으로 등록되면 true, 아니면 false 반환
			System.out.println("정상적으로 등록되었습니다.");
		}
	}

	void boardList() {
		int page = 1;
		while (true) {
			List<Board> list = service.list(page);
			System.out.println("\n| 글번호\t| 제 목\t| 작성자 |\t");
			System.out.println("========================");
			for (Board b : list) {
				System.out.println(b.listInfo());
			}
			System.out.println("========================");

			int totalCnt = service.getTotal();
			int lastPage = (int) Math.ceil(totalCnt / 5.0);

			System.out.print("\t");
			for (int i = 1; i <= lastPage; i++) {
				if (i == page) {
					System.out.printf("[%d] ", i);
				} else {
					System.out.printf("%2d ", i);
				}
			}
			System.out.print("\n   <<페이지(exit:99)>> ");
			page = scn.nextInt();

			if (page == 99) {
				break;
			}

		}
	}

	void modify() {
		String brdNo = printString("번호입력");
		String content = printString("내용입력");
		System.out.println("here1");
		Board brd = new Board();
		System.out.println("here2");
		brd.setBrdNo(Integer.parseInt(brdNo));
		System.out.println("here3");
		brd.setBrdContent(content);
		System.out.println("here4");

		if (service.modify(brd)) { // 정상적으로 수정되면 true, 아니면 false 반환
			System.out.println("정상적으로 수정되었습니다.");
		} else {
			System.out.println("수정 실패..");
		}
	}

	void remove() {
		String brdNo = printString("번호입력");
		if (service.remove(Integer.parseInt(brdNo))) { // 정상적으로 삭제되면 true, 아니면 false 반환
			System.out.println("정상적으로 삭제되었습니다.");
		}
	}

	void boardDetail() {
		String brdNo = printString("번호입력");
		Board result = service.search(Integer.parseInt(brdNo));
		if (result == null) {
			System.out.println("해당글번호가 없습니다.");
		} else {
			System.out.println(result.showInfo());
		}
	}
}
