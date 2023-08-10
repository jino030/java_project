package co.yedam.array;

import java.util.Scanner;

public class FriendApp {
	
	static Friend[] friends = new Friend[10];
	static Scanner scan = new Scanner(System.in);
	static int cnt = 0;
	static String name = "";
	static String phone = "";
	static Gender gender = null;
	
	public static boolean checkFriend(String name) {
		for(int i=0; i<friends.length; i++) {
			if(friends[i] != null && name.equals(friends[i].name)) {
				return true;
			}
		}
		return false;
	}
	
	public static void testData(int num) {
		// 테스트용 데이터
		for(int i=0; i<num; i++) {
			Friend fnd = new Friend();
			
			fnd.name = "친구" + i;
			fnd.phone = "010-1234-123" + i;
			fnd.gender = i%2 == 0? Gender.MEN : Gender.WOMEN;
			
			friends[i] = fnd;
		}
	}
	
	public static void printMenu() {
		System.out.println("\n메뉴 >> 1.친구 추가 | 2.정보 수정 | 3.삭제 | 4.단건 조회 | 5.전체 목록 | 6.종료");
	}
	
	public static void addFriend() {
		cnt = 0;
		
		for(int i=0; i<friends.length; i++) {
			if(friends[i] != null) 	cnt++;
		}
		
		if(cnt>=friends.length) {
			System.out.println(">> 등록된 친구 :: " + cnt + "명");
			System.out.println(">> [!!] 더이상 친구를 추가할 수 없습니다.");
		} else {
			System.out.print("이름 >> ");
			name = scan.nextLine();
			System.out.print("연락처 >> ");
			phone = scan.nextLine();
			System.out.print("성별(①남 ②여) >> ");
			gender = null;
			int choice = Integer.parseInt(scan.nextLine());
			
			if(choice == 1) {
				gender = Gender.MEN;
			}else {
				gender = Gender.WOMEN;
			}
			Friend fnd = new Friend();
			fnd.name = name;
			fnd.phone = phone;
			fnd.gender = gender;
			
			for(int i=0; i<friends.length; i++) {
				if(friends[i] == null) {
					friends[i] = fnd;
					break;	// null을 가진 위치에 입력하면 반복문을 멈춘다.
				}
			}
			System.out.println("::: 정상적으로 등록되었습니다.");
		}
	}
	
	public static void edit() {
		System.out.print("이름 >> ");
		name = scan.nextLine();
		
		if(!checkFriend(name)) {
			System.out.println(">> 등록된 이름이 아닙니다.");
			return;	//메소드의 실행을 멈출때
		}
		
		System.out.print("수정 연락처 >> ");
		phone = scan.nextLine();
		
		for(int i=0; i<friends.length; i++) {
			if(friends[i] != null) {
				if(name.equals(friends[i].name)) {
					friends[i].phone = phone;
					break;	// for문 종료
				}
			}
		}
	}
	
	public static void del() {
		System.out.print("이름 >> ");
		name = scan.nextLine();
		
		if(!checkFriend(name)) {
			System.out.println(">> 등록된 이름이 아닙니다.");
			return;
		}
		
		for(int i=0; i<friends.length; i++) {
			if(friends[i] != null) {
				if(name.equals(friends[i].name)) {
					friends[i] = null;
					break; // for문 종료
				}
			}
		}
	}

	public static void search() {
		System.out.print("이름 >> ");
		name = scan.nextLine();
		
		cnt = 0;
		
		for(int i=0; i<friends.length; i++) {
			if(name.equals(friends[i].name))	cnt++;
		}
		
		if(cnt == 0) {
			System.out.println(">> 등록된 이름이 아닙니다.");
		} else {
			for(int i=0; i<friends.length; i++) {
				if(friends[i] != null) {
					if(name.equals(friends[i].name)) {
						friends[i].showInfo();
						break; // for문 종료
					}
				}
			}
		}
	}
	
	public static void searchAll() {
		for(int i=0; i<friends.length; i++) {
			if(friends[i] != null) {
				System.out.print(" friends[" + (i) + "] ");
				friends[i].briefInfo();
			}
		}
	}
	
	public static void main(String[] args) {

		
		// 친구 추가, 정보 수정, 삭제, 단건 조회, 전체 목록
		boolean run = true;
		
		// 테스트용 데이터 생성 함수
		testData(10);
		
		
		while(run) {
			printMenu();
			System.out.print("선택 >> ");
			
			int menu = Integer.parseInt(scan.nextLine());
			
			switch(menu) {
			//친구 추가
			case 1:
				addFriend();
				break;
				
			//정보 수정
			case 2:
				edit();
				break;
				
			//삭제
			case 3:
				del();
				break;
				
			//단건 조회(이름,연락처,성별)
			case 4:
				search();
				break;
				
			//전체 목록(이름,연락처)
			case 5:	
				searchAll();
				break;
				
			//종료
			case 6:
				System.out.println("::::: 프로그램을 종료합니다 :::::");
				run = false;
				break;
				
			default :
				System.out.println("::::: 메뉴를 다시 선택하세요 :::::");
			}
		}
		
		
	}

}
