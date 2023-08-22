package co.yedam.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//2. DB에 저장하는 방식
public class BoardServiceJdbc implements BoardService {

	// 저장공간: Oracle DB
	// Connection 객체 : DB 연결
	// PreparedStatement 객체 : 구문(SQL) 실행
	// String 객체 : 구문(SQL) 저장

	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String query;

	@Override
	public boolean add(Board board) {
		return false;
	}

	@Override
	public List<Board> list(int page) {
		List<Board> list = new ArrayList<>();

		conn = Dao.conn(); // DB연결
		query = "SELECT * FROM board";
		try {
			psmt = conn.prepareStatement(query);
			rs = psmt.executeQuery();
			while (rs.next()) {
				// rs => 담긴 값을 list로..
				Board board = new Board();
				board.setBrdNo(rs.getInt("brd_no")); // 컬럼명 적어주기
				board.setBrdTitle(rs.getString("brd_title"));
				board.setBrdContent(rs.getString("brd_content"));

				list.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getTotal() {
		return 0;
	}

	@Override
	public boolean modify(Board board) {
		query = "UPDATE board SET brd_content = '" + board.getBrdContent() + "' WHERE brd_no = " + board.getBrdNo();
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			int r = psmt.executeUpdate();
			if(r == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean remove(int brdNo) {
		query = "DELETE FROM board WHERE brd_no = " + brdNo;
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			int r = psmt.executeUpdate(); // insert, update, delete => 사용하는 메소드, 처리된 건수 반환..
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public Board search(int brdNo) {
		query = "SELECT * FROM board WHERE brd_no = " + brdNo;
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			rs = psmt.executeQuery();
			if (rs.next()) {
				Board board = new Board();
				board.setBrdNo(rs.getInt("brd_no"));
				board.setBrdWriter(rs.getString("brd_writer"));
				board.setBrdTitle(rs.getString("brd_title"));
				board.setBrdContent(rs.getString("brd_content"));
				board.setWriteDate(rs.getDate("write_date"));
				board.setUpdateDate(rs.getDate("update_date"));
				return board;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void save() {

	}

}
