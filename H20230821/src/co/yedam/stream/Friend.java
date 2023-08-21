package co.yedam.stream;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Friend {
	private String name;
	private String phone;
	private Date birth;	// 1998-08-05 sdf.parse() 사용해서 문자열을 Date타입으로 변환
	
	public Friend(String name, String phone, Date birth) {
		super();
		this.name = name;
		this.phone = phone;
		this.birth = birth;
	}
	
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
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return "이름: " + name + ", 연락처: " + phone + ", 생일: " + sdf.format(birth);
	}
}
