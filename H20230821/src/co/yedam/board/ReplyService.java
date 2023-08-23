package co.yedam.board;

//기능 => 댓글등록, 댓글목록, 댓글삭제 : ReplyService.java(interface) => ReplyServiceImple || ReplyServiceJdbc

public interface ReplyService {

	// 댓글등록
	public boolean add(Reply reply);

	// 댓글목록
	public void list(int brdNo);

	// 댓글삭제
	public boolean remove(int repNo);

	// 댓글번호 받아오기
	public String getResponseUser(int repNo);

	// 종료시 댓글내용 파일로 저장
	public void save();

}
