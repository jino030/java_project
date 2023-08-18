package co.yedam.api;


class Member {
	private int memberId;
	private String memberName;
	
	public Member(int memberId, String memberName) {
		this.memberId = memberId;
		this.memberName = memberName;
	}
	
	
	
	@Override
	public String toString() {
		//return super.toString();
		return "Member [memberId=" + memberId + ", memberName=" + memberName + "]";
	}

	@Override
	public int hashCode() {
		//return super.hashCode();
		return memberId;
	}
	
	@Override
	public boolean equals(Object obj) {
		//return super.equals(obj);
		Member target = (Member) obj;
		if(this.memberId == target.memberId && this.memberName.equals(target.memberName)) {
			return true; // 논리적 동일
		} else {
			return false;
		}
	}
}

public class EqualsExe {
	public static void main(String[] args) {
		// new : 힙영역에 인스턴스 생성?
		String str1 = new String("Hong");
		String str2 = new String("Hong");
		String str3 = new String("Hwang");
		
		Member mem1 = new Member(101, "Hong");
		Member mem2 = new Member(101, "Hong");
		
		System.out.println(str1);
		System.out.println(str1.toString());
		
		System.out.println(str1 == str2); 		// false
		System.out.println(str1.equals(str2));	// true
		System.out.println(mem1.equals(mem2));	// 오버라이딩한 메서드를 사용 : true
	}
}
