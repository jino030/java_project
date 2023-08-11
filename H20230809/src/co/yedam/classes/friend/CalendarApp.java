package co.yedam.classes.friend;

import java.util.Calendar;

public class CalendarApp {
	public void showCalendar(int year, int month) {
		Calendar cal = Calendar.getInstance();

		cal.set(year, month - 1, 1);

		int lastdate = cal.getActualMaximum(Calendar.DATE);
		int space = cal.get(Calendar.DAY_OF_WEEK) - 1;

		// 요일 출력
		String[] days = { "Sun", "Mon", "Thu", "Thr", "Wed", "Fri", "Sat" };
		for (int i = 0; i < days.length; i++) {
			System.out.printf("%4s", days[i]);
		}
		System.out.println();

		// 시작요일 전 공백 출력
		for (int i = 0; i < space; i++) {
			System.out.printf("%4s", " ");
		}

		// 1일부터 마지막날까지 날짜 출력
		for (int i = 1; i <= lastdate; i++) {
			System.out.printf("%4d", i);

			if ((i + space) % 7 == 0)
				System.out.println();
		}
	}
}
