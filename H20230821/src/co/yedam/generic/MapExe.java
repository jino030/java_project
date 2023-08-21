package co.yedam.generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class User {
	private String id;
	private String pw;

	public User(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	// 논리동등 객체
	@Override
	public int hashCode() {
		return this.id.hashCode(); // 16진수의 값 반환...
	}

	@Override
	public boolean equals(Object obj) {
		User target = (User) obj;
		
		return this.id.equals(target.id) && this.pw.equals(target.pw);
	}
}

public class MapExe {
	public static void main(String[] args) {
		// Map: key & value
		// Map<key 타입, value 타입>
		Map<String, Integer> map = new HashMap<>();
		map.put("홍길동", 80);
		map.put("김길동", 90);
		map.put("박길동", 75);

		Integer score = map.get("홍길동");
		System.out.println(score);

		// list를 사용해서 id와 pw담을 경우
		List<User> users = new ArrayList<>();
		users.add(new User("user1", "1234"));

		// map을 사용해서 id와 pw담을 경우
		Map<String, String> userMap = new HashMap<>();
		userMap.put("user2", "1111");
		userMap.put("user3", "2222");
		userMap.put("user4", "3333");

		if (userMap.containsKey("user2")) { // key의 존재여부 확인
			System.out.println("user2의 pw: " + userMap.get("user2")); // 해당 key의 value 반환.
		}

		// key 반환.
		Set<String> keyset = userMap.keySet(); // key를 담아주는 메서드

		// 확장for문 사용해서 해당되는 key의 value 출력
		for (String key : keyset) {
			String val = userMap.get(key);
			System.out.printf("key: %s, val: %s\n", key, val);
		}

		// map을 사용해서 User(id와 pw), 이름 담을 경우
		Map<User, String> umap = new HashMap<>();
		umap.put(new User("user1", "1111"), "홍길동");
		umap.put(new User("user2", "2222"), "김길동");
		umap.put(new User("user3", "3333"), "박길동");

		String name = umap.get(new User("user1", "1111")); // 값이 같아도 반환되는 객체는 다름..(논리적으로 같음을 증명하는 메소드를 User클래스에 생성해야한다)
		System.out.println("name: " + name);
	}
}
