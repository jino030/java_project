package co.yedam.board;

public class Board {
	
	private int no;
	private String title;
	private String body;
	private String user;
	
	Board(){
		
	}
	
	Board(int no, String title, String body, String user){
		this.no = no;
		this.title = title;
		this.body = body;
		this.user = user;
	}

	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "글번호: " + no + "  작성자: " + user + "\n글내용: " + body;
	}
	
	public void print() {
		System.out.printf("%-5d\t %-30s\t %-15s\n", no, title, user);
	}
	
	
}
