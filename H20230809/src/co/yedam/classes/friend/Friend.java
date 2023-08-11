package co.yedam.classes.friend;

import java.util.Date;

public class Friend {
	private String name;
	private String phone;
	private String birth;
	//private Date birth;

	// 생성자
	public Friend(String name, String phone, String birth) {
		// super(); // 상속받은 경우, 부모가 가진 생성자를 호출한다는 뜻..
		this.name = name;
		this.phone = phone;
		this.birth = birth;
	}

	// getter, setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	// 출력 메소드(재정의)
	@Override
	public String toString() {
		return "칭긔 [ 이름: " + name + ", 전화번호: " + phone + ", 생일: " + birth + " ]";
	}

}
