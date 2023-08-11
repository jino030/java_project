package co.yedam.classes.friend;

import java.util.Calendar;

public class FriendMain {

	public static void main(String[] args) {

		FriendApp.start();
		
		
		Calendar cal = Calendar.getInstance();
		cal.set(2023, 2-1, 1);
		
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		System.out.println(cal.getActualMaximum(Calendar.DATE));
	}

}
