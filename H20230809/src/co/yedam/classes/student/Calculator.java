package co.yedam.classes.student;

public class Calculator {

	double pi = 3.14; // 인스턴스 멤버

	// 인스턴스 멤버
	public double sum(double n1, double n2) {
		return n1 + n2;
	}

	public double minus(double n1, double n2) {
		return n1 - n2;
	}

	// static(정적메소드) : 클래스가 메모리에 로딩될때 static로 선언된 메소들들도 같이 로딩되어 사용준비를 마침.
	public static double multi(double n1, double n2) {
		return n1 * n2;
	}

}
