package co.yedam.friend;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExe {
	public static void main(String[] args) {
		Date today = new Date();
		// 원하는 날짜 형태로 만들기.
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(today);
		System.out.println(sdf.format(today)); // Date => String

		String strTime = "2023-09-01 13:22:33";
		try {
			Date newDate = sdf.parse(strTime); // String => Date
			System.out.println(sdf.format(newDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
}
