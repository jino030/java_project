package co.yedam.board.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.board.common.Dao;
import co.yedam.board.vo.Board;

//2. DB에 저장하는 방식
public class BoardServiceJdbc implements BoardService {

	// 저장공간: Oracle DB
	// Connection 객체 : DB 연결
	// PreparedStatement 객체 : 구문(SQL) 실행
	// String 객체 : 구문(SQL) 저장
	// 리소스 사용완료 시 세션확보를 위해 연결해제!!!!

	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String query;

	void disconn() {
		try {
			if (rs != null)
				rs.close();

			if (psmt != null)
				psmt.close();

			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean add(Board board) {
		query = "INSERT INTO board (brd_no, brd_title, brd_content, brd_writer)"
				+ "VALUES ((SELECT NVL(MAX(brd_no),0)+1 brd_no FROM board),?,?,?)";
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			// 파라미터 넘겨주기..
			psmt.setString(1, board.getBrdTitle());
			psmt.setString(2, board.getBrdContent());
			psmt.setString(3, board.getBrdWriter());
			int r = psmt.executeUpdate();
			if (r == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn(); // 연결 끊기
		}
		return false;
	}

	@Override
	public List<Board> list(int page) {
		List<Board> list = new ArrayList<>();

		conn = Dao.conn(); // DB연결
		query = "SELECT *\r\n" + "FROM ( SELECT ROWNUM rn, A.*\r\n" + "       FROM ( SELECT * FROM board\r\n"
				+ "              ORDER BY brd_no) A\r\n" + "       WHERE ROWNUM <= (?*5)) B\r\n"
				+ "WHERE B.rn > ((?-1)*5)";
		try {
			psmt = conn.prepareStatement(query);
			psmt.setInt(1, page);
			psmt.setInt(2, page);

			rs = psmt.executeQuery();
			while (rs.next()) {
				// rs => 담긴 값을 list로..
				Board board = new Board();
				board.setBrdNo(rs.getInt("brd_no")); // 컬럼명 적어주기
				board.setBrdTitle(rs.getString("brd_title"));
				board.setBrdWriter(rs.getString("brd_writer"));

				list.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn(); // 연결 끊기
		}
		return list;
	}

	@Override
	public int getTotal() {
		int num = 0;
		query = "SELECT COUNT(1) cnt FROM board";
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			rs = psmt.executeQuery();
			if (rs.next()) {
				num = rs.getInt("cnt");
				return num;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn(); // 연결 끊기
		}
		return num;
	}

	@Override
	public boolean modify(Board board) {
		// query = "UPDATE board SET brd_content = '" + board.getBrdContent() + "',
		// update_date = SYSDATE WHERE brd_no = " + board.getBrdNo();
		query = "UPDATE board SET brd_content = ?, update_date = SYSDATE WHERE brd_no = ?"; // ? : 파라미터로 받을 수 있음
		// System.out.println(query);
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			// 파라미터 넘겨주기..
			psmt.setString(1, board.getBrdContent());
			psmt.setInt(2, board.getBrdNo());
			int r = psmt.executeUpdate();
			if (r == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn(); // 연결 끊기
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
		} finally {
			disconn(); // 연결 끊기
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
		} finally {
			disconn(); // 연결 끊기
		}
		return null;
	}

	@Override
	public void save() {

	}

	@Override
	public String getResponseUser(int brdNo) {
		query = "SELECT brd_writer FROM board WHERE brd_no = ?";
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			psmt.setInt(1, brdNo);
			rs = psmt.executeQuery();

			if (rs.next()) {
				return rs.getString("brd_writer");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn(); // 연결 끊기
		}

		return null;
	}

}
