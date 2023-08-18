package co.yedam.friend;

public class FriendExe {
	public static void main(String[] args) {
		// name, phone
		// 배열선언[5]. 인스턴스 3명.
		// name = "홍길동";
		Friend[] friends = new Friend[5];

		friends[0] = new Friend("홍길동", "010-1111-2222");
		friends[1] = new Friend("김길동", "010-3333-2222");
		friends[2] = new Friend("박길동", "010-4444-2222");

		String name = "홍길동";
		String phone = "010-1234-5678";
		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null && friends[i].getName().equals(name)) {
				friends[i].setPhone(phone);
				System.out.println(friends[i].showInfo());
			}
		}
	}
}
