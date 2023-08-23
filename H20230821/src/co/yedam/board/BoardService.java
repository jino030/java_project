package co.yedam.board;

import java.util.List;

// 1. 파일에 저장하는 방식 : 프로그램을 종료, 실행할때 저장.출력.
// 2. DB에 저장하는 방식
// 인터페이스 생성(규칙을 정의하기 위함)
// 규칙에따라 메소드 이름을 정해놓지 않으면 기능들의 이름이 달라질 수 있으므로..
public interface BoardService {

	// 등록(추가)
	public boolean add(Board board);
	
	// 목록
	public List<Board> list(int page);
	public int getTotal();
	
	// 수정: 글내용 수정.
	public boolean modify(Board board);
	
	// 삭제
	public boolean remove(int brdNo);

	// 상세조회
	public Board search(int brdNo);
	
	// 종료
	public void save();
	
	// 글번호(input) => 작성자(output)
	public String getResponseUser(int brdNo);
	
}
