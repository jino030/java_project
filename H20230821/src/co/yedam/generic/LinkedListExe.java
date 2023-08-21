package co.yedam.generic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExe {
	public static void main(String[] args) {
		// ArrayList 와 LinkedList의 시간 차이 구해보기..
		// ArrayList 테스트
		List<String> list = new ArrayList<>();
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			//list.add("" + i); // 마지막에 넣기
			list.add(0, "" + i); // 특정 위치에 넣기
		}
		long end = System.currentTimeMillis();
		System.out.println("ArrayList: " + (end - start) + "ms");

		// LinkedList 테스트
		list = new LinkedList<>();
		start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			//list.add("" + i); // 마지막에 넣기
			list.add(0, "" + i); // 특정 위치에 넣기
		}
		end = System.currentTimeMillis();
		System.out.println("LinkedList: " + (end - start) + "ms");
	}
}
