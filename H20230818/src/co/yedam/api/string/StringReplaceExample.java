package co.yedam.api.string;

public class StringReplaceExample {
	public static void main(String[] args) {
		String oldStr = "자바는 객체 지향 언어입니다. 자바는 풍부한 API를 지원합니다.";
		String newStr = oldStr.replace("자바", "JAVA");
		System.out.println(oldStr);
		System.out.println(newStr);
		
		String testStr = "공백을 제거할 수 있을까요?"; //가능하군요..
		String testStr2 = testStr.replace(" ", "");
		System.out.println(testStr);
		System.out.println(testStr2);
	}
}
