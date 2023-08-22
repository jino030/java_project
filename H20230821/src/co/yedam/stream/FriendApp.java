package co.yedam.stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FriendApp {
	Scanner scn = new Scanner(System.in);
	List<Friend> friends = new ArrayList<>();

	public FriendApp() {
		loadFile();
	}

	public void start() {
		boolean run = true;
		while (run) {
			System.out.println("\n| 1.등록 | 2.출력 | 3.종료 |");
			System.out.print("선택>> ");
			int menu = scn.nextInt();
			scn.nextLine(); // 엔터 처리

			switch (menu) {
			case 1:
				add();
				break;
			case 2:
				list();
				break;
			case 3:
				System.out.println("프로그램을 종료합니다.");
				saveFile();
				run = false;
				break;
			default:
				System.out.println("잘못입력하셨습니다.");
				break;
			}
		}
	}// end of start()

	SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");

	private void add() {
		String name = printString("이름입력");
		String phone = printString("연락처입력");
		String birth = printString("생일입력(95-06-03)");

		try {
			Friend fnd = new Friend(name, phone, sdf.parse(birth));
			friends.add(fnd);

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	private void list() {
		for (Friend fnd : friends) {
			System.out.println(fnd.toString());
		}
	}

	private void saveFile() {
		File file = new File("C:/temp/friendList.txt");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// friends 컬렉션에 있는 값 => 텍스트로 저장
		try {
			FileWriter fw = new FileWriter(file); // 여기에 바로 파일 경로를 적어도 됨.
			for (Friend fnd : friends) {
				String line = fnd.getName() + " " + fnd.getPhone() + " " + sdf.format(fnd.getBirth());
				fw.write(line + "\n");
			}
			fw.flush();
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadFile() {
		File file = new File("C:/temp/friendList.txt"); // 파일의 정보(Scanner 등 사용시 매개변수로 사용가능)
		Scanner scn = null;
		try {
			scn = new Scanner(file); // 파일읽어오기
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(true) {
			String line = null;
			try {
				line = scn.nextLine();
			} catch(NoSuchElementException e) {
				// 다음라인이 없으면
				break;
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String[] data = line.split(" ");
			String name = data[0];
			String phone = data[1];
			String birth = data[2];

			Friend fnd = null;
			try {
				fnd = new Friend(name, phone, sdf.parse(birth));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			friends.add(fnd);
		}
		
	}

	public String printString(String msg) {
		System.out.print(msg + ">> ");
		return scn.nextLine();
	}
}
