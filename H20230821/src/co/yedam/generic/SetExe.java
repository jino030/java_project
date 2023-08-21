package co.yedam.generic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SetExe {
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("홍길동");
		set.add("김길동");
		set.add("박길동");
		set.add("홍길동"); // 중복값은 저장안된다.
		System.out.println(set.size());

		//set.remove("홍길동");

		// 반복자
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {	// 다음 순번 체크(있으면 true 반환, 없으면 false 반환)
			String val = iter.next(); // 값 꺼내기.
			System.out.println(val);
		}
		
		// List와 Set 비교해보기
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(11);
		list.add(12);
		list.add(11); // 중복된 값도 저장된다
		System.out.println("\n**List<Integer> size:" + list.size());
		for(Integer no : list) {
			System.out.println(no);
		}
		
		// 중복된 값은 비허용 => Set 컬렉션 사용
		Set<Integer> iset = new HashSet<>();
		for(Integer no : list) {
			iset.add(no);
		}
		System.out.println("\n**Set<Integer> size:" + iset.size());
		for(Integer no : iset) {
			System.out.println(no);
		}
		
	}
}
