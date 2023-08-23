package co.yedam.board;

import java.util.List;
import java.util.Scanner;

// 컨트롤, 뷰 역할..
public class BoardApp {

	Scanner scn = new Scanner(System.in);
	BoardService service = new BoardServiceJdbc(); // 방식에따라 구현체만 변경해주면 된다.
	UserService uservice = new UserServiceJdbc();
	ReplyService rservice = new ReplyServiceImpl();
	String id = "";

	public void start() {
		// 사용자 체크
		while (true) {
			// 사용자에게 입력받기
			User user = new User();
			id = printString("id");
			String pw = printString("pw");
			user.setId(id);
			user.setPw(pw);

			// 입력받은값과 저장된 비교하기
			User userInfo = uservice.checkLogin(user);
			if (userInfo != null) {
				System.out.println(userInfo.getName() + "님, 환영합니다!");
				break;
			}
			System.out.println("[X] 로그인 실패!\n");
		}

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
				rservice.save();
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
		} else {
			System.out.println("등록에 실패했습니다.");
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
		// 수정하고자하는 번호 입력받기
		String brdNo = printString("번호입력");

		// 해당 게시들의 작성자와 로그인 id가 일치하는지 검증
		String userId = service.getResponseUser(Integer.parseInt(brdNo));
		if (!userId.equals(id)) {
			System.out.println("권한이 없습니다.");
			return; // 불일치 : 메서드의 실행 중지
		}

		// 일치하면 실행
		String content = printString("내용입력");
		Board brd = new Board();
		brd.setBrdNo(Integer.parseInt(brdNo));
		brd.setBrdContent(content);

		if (service.modify(brd)) { // 정상적으로 수정되면 true, 아니면 false 반환
			System.out.println("정상적으로 수정되었습니다.");
		} else {
			System.out.println("수정 실패..");
		}
	}

	void remove() {
		// 수정하고자하는 번호 입력받기
		String brdNo = printString("번호입력");

		// 해당 게시들의 작성자와 로그인 id가 일치하는지 검증
		String userId = service.getResponseUser(Integer.parseInt(brdNo));
		if (!userId.equals(id)) {
			System.out.println("권한이 없습니다.");
			return; // 불일치 : 메서드의 실행 중지
		}

		// 일치하면 실행
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
			// 게시글 출력
			System.out.println("♥──────────────────────────────────────────────────────♥");
			System.out.println("♥                      Board info                      ♥");
			System.out.println("♥──────────────────────────────────────────────────────♥");
			System.out.println(result.showInfo());
			System.out.println("♥──────────────────────────────────────────────────────♥");

			// 댓글출력 메서드 호출
			System.out.println("♥                      Reply info                      ♥");
			System.out.println("♥──────────────────────────────────────────────────────♥");
			printReply(brdNo);
			System.out.println("♥──────────────────────────────────────────────────────♥");
		}

		reply(brdNo); // 댓글등록 메서드 호출
	}

	void reply(String brdNo) {
		// 댓글기능 추가..
		// 댓글입력 옵션 추가
		int repBrdNo = Integer.parseInt(brdNo);
		String repMode = printString("[댓글입력(i), 댓글삭제(d), 초기화면(q)]");
		if (repMode.equals("i")) {
			// 댓글 입력
			String repContent = printString("댓글작성");
			System.out.println("작성자: " + id);
			// 댓글정보 Reply 객체에 저장
			Reply reply = new Reply(repBrdNo, repContent, id);

			if (rservice.add(reply)) {
				System.out.println("댓글이 정상적으로 등록되었습니다.");
			} else {
				System.out.println("댓글을 등록하지 못했습니다.");
			}
			
		} else if(repMode.equals("d")) {
			// 댓글 삭제
			removeReply();
		}
	}

	void printReply(String brdNo) {
		// 댓글 출력(입력한 게시글 번호와 일치하는 댓글)
		List<Reply> rlist = rservice.list();
		for (Reply r : rlist) {
			if (r.getBrdNo() == Integer.parseInt(brdNo)) {
				System.out.println(r.replyInfo());
				//System.out.println(r.toString());
			}
		}
	}
	
	void removeReply() {
		// 삭제할 댓글번호 받기
		String repNo = printString("댓글번호");
		// 해당 댓글의 작성자와 로그인 id가 일치하는지 검증
		String userId = rservice.getResponseUser(Integer.parseInt(repNo));
		
		if (!userId.equals(id)) {
			System.out.println("자신의 댓글만 삭제 가능합니다.");
			return; // 불일치 : 메서드의 실행 중지
		}

		// 일치하면 실행
		if (rservice.remove(Integer.parseInt(repNo))) { // 정상적으로 삭제되면 true, 아니면 false 반환
			System.out.println("정상적으로 삭제되었습니다.");
		}
	}
}
