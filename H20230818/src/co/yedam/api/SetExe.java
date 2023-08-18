package co.yedam.api;

import java.util.HashSet;
import java.util.Set;

public class SetExe {
	public static void main(String[] args) {
		// ArrayList, HashSet(중복된 값 저장 불가)
		// 인터페이스 : Set / 구현체 : HashSet
		Set<String> set = new HashSet<>();
		set.add("홍길동");
		set.add("황길동");
		set.add("김길동");
		set.add("홍길동");
		
		for(String str : set) {
			// 인덱스값이 없으므로 무작위로 출력
			System.out.println(str);
		}
		
		Set<Member> memberSet = new HashSet<>();
		memberSet.add(new Member(101, "Hong"));
		memberSet.add(new Member(102, "Hwang"));
		memberSet.add(new Member(103, "Kim"));
		memberSet.add(new Member(101, "Hong"));
		
		for(Member str : memberSet) {
			// 인덱스값이 없으므로 무작위로 출력
			System.out.println(str);
		}
	}
}
