package co.yedam.friend;

public class UnivFriend extends Friend {
	private String univ;
	private String major;

	// 상위클래스에 기본 생성자가 없기 때문에 오류 발생
	// https://blog.devez.net/ko/99
	public UnivFriend(String name, String phone, String univ, String major) {
		super(name, phone);
		this.univ = univ;
		this.major = major;
	}
	
	public String getUniv() {
		return univ;
	}

	public void setUniv(String univ) {
		this.univ = univ;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	@Override
	public String showInfo() {
		//return super.showInfo();	// 부모클래스의 showInfo를 호출..
		// 학교와 전공정보도 출력하기 위해 메소드 재정의
		return super.showInfo() + ", 학교는 " + univ + ", 전공은 " + major;
	}

}
