package co.yedam.api.string;

public class StringIndexOfExample {
	public static void main(String[] args) {
		String subject = "자바 프로그래밍";
		
		// subject에 저장된 문자열에서 "프로그래밍"의 위치 반환
		int location = subject.indexOf("프로그래밍");
		System.out.println(location);
		
		if(subject.indexOf("자바") != -1) {
			System.out.println("자바와 관련있는 책입니다!");
		} else {
			System.out.println("자바와 관련없는 책입니다...");
		}
	}
}
