package co.yedam.exceptions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClassNotFoundExe {
	public static void main(String[] args) {
		// DB 연결처리 예외
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection conn = null;
		try {
			// ("jdbc:subprotocol:subname", "계정", "패스워드")
			// oracle url = "jdbc:oracle:thin:@hostname:port:SID"
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			System.out.println(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 테스트
		try {
			Statement stmt = conn.createStatement();
			// 처리결과를 담는 클래스 ResultSet
			ResultSet rs = stmt.executeQuery("SELECT * FROM employees");

			while (rs.next()) { // data가 있으면..
				// [employee_id]와 [first_name]을 가져온다
				System.out.println("사원번호 : " + rs.getInt("employee_id")//
						+ ", 이름 : " + rs.getString("first_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Wow....");
		}

		System.out.println("end of prog...");
	}
}
