package co.yedam.board.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.yedam.board.common.Dao;
import co.yedam.board.vo.User;

public class UserServiceJdbc implements UserService {

	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String query;
	
	void disconn() {
		try {
			if(rs!=null) rs.close();
			
			if(psmt!=null) psmt.close();
			
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public User checkLogin(User user) {
		query = "SELECT * FROM users WHERE user_id = ? AND user_pw = ?";
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			psmt.setString(1, user.getId());
			psmt.setString(2, user.getPw());
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				User userInfo = new User();
				userInfo.setId(rs.getString("user_id"));
				userInfo.setPw(rs.getString("user_pw"));
				userInfo.setName(rs.getString("user_nm"));
				return userInfo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return null;
	}
}
