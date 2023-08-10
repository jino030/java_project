package co.yedam.array;

public class Friend {
	// 속성
	String name;
	String phone;
	Gender gender;
	
	// 기능(메소드)
	void showInfo(){
		System.out.println(
			  ">> 이름 : " + name + " / 연락처 : " + phone 
			+ " / 성별 : " + (gender == Gender.MEN ? "남" : "여")
		);
	}
	
	void briefInfo() {
		System.out.println(
			 ">> 이름 : " + name + " / 연락처 : " + phone
		);
	}
	
}
