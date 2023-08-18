package co.yedam.exceptions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class ThrowExe {
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		System.out.println(scn.getClass());
		
		try {
			dbSearch();
		} catch (Exception e) {
			// 에러나는 위치의 로그를 찍어줌..
			e.printStackTrace();
		}
	}

	// 예외 떠넘기기..(해당 메서드를 호출하는 곳에서 예외처리를 하도록 떠넘긴다)
	public static void dbSearch() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
	}
}
