package co.yedam.classes.student;

public class Student {
	// 라이브러리 용도
	private int stdNo; // 0
	private String stdName; // null
	private int score;

	// 생성자 : 필드의 값 초기화
	Student() {
		// 기본생성자
	}

	// 생성자 오버로딩 : 매개변수를 달리하는 생성자를 여러개 선언...매개변수의 타입, 개수, 위치를 다르게...?
	Student(int stdNo) {
		this.stdNo = stdNo;
	}

	Student(int stdNo, String stdName, int score) {
		this.stdNo = stdNo;
		this.stdName = stdName;
		this.score = score;
	}

	// 메소드
	void stdInfo() {
		System.out.println("학번: " + stdNo //
				+ ", 학생이름: " + stdName //
				+ ", 점수: " + score);
	}

	//setter
	void setStdNo(int stdNo) {
		this.stdNo = stdNo;
	}

	void setStdName(String stdName) {
		this.stdName = stdName;
	}

	void setScore(int score) {
		if (score > 0 && score <= 100) {
			this.score = score;
		} else {
			this.score = 0;
		}
	}

	//getter
	public int getStdNo() {
		return stdNo;
	}
	
	public String getStdName() {
		return stdName;
	}
	
	public int getScore() {
		return score;
	}
	
}
