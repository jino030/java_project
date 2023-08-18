package co.yedam.exceptions;

// 예외처리 : 프로그램이 비정상적으로 종료되는 것을 막기 위함.
public class NullPointExe {
	public static void main(String[] args) {
		String msg = null;
		msg = "123";
		//msg = "Hello~";
		
		try {
			System.out.println(msg.toString());
			int val = Integer.parseInt(msg);
			System.out.println("결과는 " + val);
		} catch(NullPointerException e) {
			System.out.println("[Exception] msg 값이 null을 참조합니다!!");
			System.out.println("[Exception] NullPointerException 예외가 발생했습니다.");
		} catch(NumberFormatException e) {
			System.out.println("[Exception] msg 값을 숫자로 변환할 수 없습니다!!");
			System.out.println("[Exception] NumberFormatException 예외가 발생했습니다.");
		} finally {
			System.out.println("예외의 발생과는 상관없이 실행할 코드를 작성하는 곳입니다.");
		}
		
		System.out.println("end of prog.");
	}
}
