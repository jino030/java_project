package co.yedam.classes.student;

public class Main {
	public static void main(String[] args) {

		Calculator cal = new Calculator(); // 인스턴스
		double result = cal.sum(20, 40);
		System.out.println(result);
		
		double result2 = Calculator.multi(100, 20);	//인스턴스를 생성하지 않고 바로 사용가능(정적메소드)
		System.out.println(result2);
	}
}
