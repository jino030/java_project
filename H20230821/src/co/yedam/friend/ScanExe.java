package co.yedam.friend;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ScanExe {
	public static void main(String[] args) {
		File file = new File("src/co/yedam/friend/friends.txt");
		Scanner scn = null;

		try {
			scn = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

//		while(scn.hasNext()) {
//			String word = scn.next(); //공백을 기준으로
//			System.out.println(word);
//		}

		List<Friend> friends = new ArrayList<>();
		while (true) {
			String line = null;
			try {
				line = scn.nextLine();
			} catch (NoSuchElementException e) {
				// 다음라인이 없을때..
				break;
			}

			// 홍길동 010-1111-1111 1995-05-05 => 공백을 기준으로 잘라서 배열에 담기.
			String[] data = line.split(" ");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			try {
				Date birth = sdf.parse(data[2]); // 1995-05-05 => Date 타입으로 변환
				friends.add(new Friend(data[0], data[1], birth)); // List 컬렉션에 추가.
			} catch (ParseException e) {
				System.out.println(data[0] + "님은 날짜형식에 오류가 발생..");
			} catch (ArrayIndexOutOfBoundsException e) {
				// 중간에 비어있는 라인을 만났을때..
			}
		}

		// ArrayList에 담긴 Friend 객체의 정보 출력하기.
		for (Friend fnd : friends) {
			System.out.println(fnd.toString());
		}

		System.out.println("end of prog");
	}
}
