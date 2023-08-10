package co.yedam.array;

public class CalendarExe {

	public static void main(String[] args) {

		int month = 2;
		
		// 달력. 31까지 있는 달. 날짜를 출력
		String[] days = {"Sun", "Mon", "Thu", "Thr", "Wed", "Fri", "Sat"};
		for(int i=0; i<days.length; i++) {
			System.out.printf("%4s", days[i]);
		}
		System.out.println();
		
		int space = getFirstDay(month);
		for(int i=0; i<space; i++) {
			System.out.printf("%4s", " ");
		}
		
		for(int i=1; i<=getLastDate(month); i++) {
			System.out.printf("%4d", i);
			
			if((i+space)%7 == 0) {
				System.out.println();
			}
		}
		
		
	}
	
	public static int getFirstDay(int month) {
		int day = 0;
		
		
		
		return day;
	}
	
	public static int getLastDate(int month) {
		// 31 : 1,3,5,7,8,10,12
		// 30 : 4,6,9,11
		
		int lastDate = 31;
		
		if(month == 4 || month == 6 || month == 9 || month == 11 ) lastDate = 30;
		else if(month == 2) lastDate = 28;
		
		return lastDate;
	}

}
