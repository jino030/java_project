package co.yedam.board;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//1. 파일에 저장하는 방식
public class BoardServiceImpl implements BoardService {

	List<Board> boardList = new ArrayList<>();

	public BoardServiceImpl() {
		init();
	}

	private void init() {
		try {
			FileInputStream fis = new FileInputStream("C:/temp/board.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			boardList = (List<Board>) ois.readObject(); // 역직렬화
			ois.close();
			fis.close();

		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	private int getMaxNo() {
		int brdNo = 0;
		for (int i = 0; i < boardList.size(); i++) {
			if (boardList.get(i).getBrdNo() > brdNo) {
				brdNo = boardList.get(i).getBrdNo();
			}
		}
		return brdNo + 1;
	}

	// 등록날짜, 수정날짜
	private Date getDate() {
		Date sysdate = new Date();
		return sysdate;
	}

	@Override
	public boolean add(Board board) {
		board.setBrdNo(getMaxNo()); // 글번호 구하기
		board.setWriteDate(getDate()); // 작성일자
		return boardList.add(board); // 정상적으로 등록되면 true값이 리턴된다.
	}

	@Override
	public List<Board> list(int page) {
		int start = (page - 1) * 5;
		int end = page * 5;

		List<Board> pageList = new ArrayList<>();
		// 5page => 20 ~ 25;
		// 23개밖에 없으면
		for (int i = 0; i < boardList.size(); i++) { // i = 0; i < 23 i++
			if (i >= start && i < end) { // i >= 21 && i < 25
				pageList.add(boardList.get(i)); // pageList.add(boardList.get(23));
			}
		}

		return pageList;
	}

	@Override
	public int getTotal() {
		return boardList.size();
	}

	@Override
	public boolean modify(Board board) {
		for (int i = 0; i < boardList.size(); i++) {
			if (boardList.get(i).getBrdNo() == board.getBrdNo()) {
				boardList.get(i).setBrdContent(board.getBrdContent());
				boardList.get(i).setUpdateDate(getDate());
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean remove(int brdNo) {
		for (int i = 0; i < boardList.size(); i++) {
			if (boardList.get(i).getBrdNo() == brdNo) {
				boardList.remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public Board search(int brdNo) {
		for (int i = 0; i < boardList.size(); i++) {
			if (boardList.get(i).getBrdNo() == brdNo) {
				return boardList.get(i);
			}
		}
		return null;
	}

	// 종료시 파일 저장
	@Override
	public void save() {
		try {
			// 객체 => 바이트 : 직렬화 <> 역직렬화
			// 단, java.io.Serializable 인터페이스를 구현한 객체만 직렬화 가능..
			FileOutputStream fos = new FileOutputStream("C:/temp/board.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos); // 보조스트림
			oos.writeObject(boardList); // 데이터 직렬화..
			oos.flush();
			oos.close();
			fos.flush();
			fos.close();

			System.out.println("게시글 파일저장 성공~!");
		} catch (Exception e) {
			System.out.println("게시글 파일저장 실패!");
			e.printStackTrace();
		}
	}

	@Override
	public String getResponseUser(int brdNo) {
		for (int i = 0; i > boardList.size(); i++) {
			if(brdNo == boardList.get(i).getBrdNo()) {
				return boardList.get(i).getBrdWriter();
			}
		}
		return null;
	}

}
