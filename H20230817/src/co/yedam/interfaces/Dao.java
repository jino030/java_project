package co.yedam.interfaces;

public interface Dao {
	// 규칙을 정하는게 가장 큰 목표!(규칙선언)
	// 필드 선언 = 상수!
	
	static final double pi = 3.14;
	
	// abstract 키워드를 넣지 않아도 추상 메서드로 인식함.
	void insert();
	void update();
	void delete();
	void select();
}
