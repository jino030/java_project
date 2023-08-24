package co.yedam.board.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Board implements java.io.Serializable {
	private int brdNo; // brd_no(오라클 명명규칙! 자바에서는 대소문자 구분을 하므로 카멜케이스 사용!!)
	private String brdTitle;
	private String brdContent;
	private String brdWriter;
	private Date writeDate;
	private Date updateDate;

	// constructor
	public Board() {

	}

	public Board(String brdTitle, String brdContent, String brdWriter) {
		super();
		this.brdTitle = brdTitle;
		this.brdContent = brdContent;
		this.brdWriter = brdWriter;
	}

	// get/set
	public int getBrdNo() {
		return brdNo;
	}

	public void setBrdNo(int brdNo) {
		this.brdNo = brdNo;
	}

	public String getBrdTitle() {
		return brdTitle;
	}

	public void setBrdTitle(String brdTitle) {
		this.brdTitle = brdTitle;
	}

	public String getBrdContent() {
		return brdContent;
	}

	public void setBrdContent(String brdContent) {
		this.brdContent = brdContent;
	}

	public String getBrdWriter() {
		return brdWriter;
	}

	public void setBrdWriter(String brdWriter) {
		this.brdWriter = brdWriter;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "Board [글번호=" + brdNo + ", 제목=" + brdTitle + ", 내용=" + brdContent + ", 작성자=" + brdWriter + ", 작성일자="
				+ writeDate + ", 수정일자=" + updateDate + "]";
	}
	
	// 날짜 포멧..
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public String listInfo() {
		String result = "[" + brdNo + "]\t " + brdTitle + "\t " + brdWriter;
		
		
		return result;
	}
	
	public String showInfo() {
		Date date = updateDate == null ? writeDate : updateDate;
		String result = " ♬ 글번호 [" + brdNo + "] "
				+ " ♬ 작성자 [" + brdWriter + "]\n"
				+ " ♬ 제   목 [" + brdTitle + "]\n"
				+ " ♬ 내   용 [" + brdContent + "]\n"
				+ " ♬ 작성일자 [" + sdf.format(writeDate) + "]\n"
				+ " ♬ 수정일자 [" + sdf.format(date) + "]";
		
		
		return result;
	}

}
