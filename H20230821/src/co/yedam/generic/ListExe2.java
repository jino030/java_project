package co.yedam.generic;

import java.util.ArrayList;
import java.util.List;

public class ListExe2 {
	public static void main(String[] args) {
		List<Member> list = new ArrayList<Member>();
		list.add(new Member(1001, "Hong"));
		Member member = new Member(1002, "Hwang");
		list.add(member);

		// 해당되는 member의 이름 바꾸기
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getMemberId() == 1001) { // null값을 체크할 필요가 없다!!
				list.get(i).setMemberName("홍홍");
			}
		}

		// 출력해보기
		for (Member mem : list) {
			System.out.printf("이름은 %s\n", mem.getMemberName());
		}

		// 해당되는 member 삭제
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getMemberId() == 1001) {
				list.remove(i);
			}
		}

		// 출력해보기
		System.out.println("↓삭제후");
		for (Member mem : list) {
			System.out.printf("이름은 %s\n", mem.getMemberName());
		}
	}
}
