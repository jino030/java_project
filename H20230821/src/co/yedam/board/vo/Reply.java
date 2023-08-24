package co.yedam.board.vo;

//댓글기능
//3번글 테스트 uuser3
//ㄴ 1. 첫번째 댓글입니다. (user2)
//ㄴ 2. 두번째 댓글입니다. (user3)
//필요한 항목 => 댓글번호(pk), 원본글번호, 댓글내용, 댓글작성자(fk?) : Reply.java

public class Reply implements java.io.Serializable {
	private int repNo;
	private int brdNo;
	private String repContent;
	private String repWriter;

	// constructor
	public Reply() {

	}

	public Reply(int brdNo, String repContent, String repWriter) {
		super();
		this.brdNo = brdNo;
		this.repContent = repContent;
		this.repWriter = repWriter;
	}

	// get/set
	public int getrepNo() {
		return repNo;
	}

	public void setrepNo(int repNo) {
		this.repNo = repNo;
	}

	public int getBrdNo() {
		return brdNo;
	}

	public void setBrdNo(int brdNo) {
		this.brdNo = brdNo;
	}

	public String getrepContent() {
		return repContent;
	}

	public void setrepContent(String repContent) {
		this.repContent = repContent;
	}

	public String getrepWriter() {
		return repWriter;
	}

	public void setrepWriter(String repWriter) {
		this.repWriter = repWriter;
	}

	@Override
	public String toString() {
		return "Reply [repNo=" + repNo + ", brdNo=" + brdNo + ", repContent=" + repContent + ", repWriter=" + repWriter
				+ "]";
	}
	
	public String replyInfo() {
		return "  ㄴ[Reply] " + repNo + ". " + repContent + "(" + repWriter + ")";
	}

}
