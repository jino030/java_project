package co.yedam.generic;

import java.util.ArrayList;
import java.util.List;

public class ListExe {
	public static void main(String[] args) {
		// List : interface / ArrayList : implements List
		List<String> list = new ArrayList<>(); // == new ArrayList<String>();
		list.add("Hello");
		list.add(new String("World"));
		list.add("Good");

		String result = list.get(0);
		System.out.println(result);

		// size() : 크기 가져오기..
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}

		// set() : 값변경
		list.set(1, "Change Value");
		System.out.println("\n↓수정 후");

		for (String str : list) {
			System.out.print(str + " ");
		}
		
		// remove() : 삭제
		list.remove(1);
		System.out.println("\n↓삭제 후");
		for (String str : list) {
			System.out.print(str + " ");
		}
		
		// clear() : 모든 요소 삭제
		list.clear();
		System.out.println("\n↓전체 삭제 후");
		for (String str : list) {
			System.out.print(str + " ");
		}
	}
}
