package co.yedam.api;

import java.util.Scanner;

public class StringExe2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// 파일명 출력하기
		String file = "C:/Dev/temp/flower.jpg";
		String fileName = StringUtils.getFileName(file);
		
		System.out.println(fileName);
		
		
		// 주민번호로 성별 구분하기
		boolean run = true;
		String gender = "";
		while(run) {
			System.out.println("1.주민번호 입력 2. 종료");
			System.out.print("선택>> ");
			int menu = scan.nextInt();
			scan.nextLine();
			
			switch(menu) {
			case 1:
				System.out.print("주민번호>> ");
				String ssn = scan.nextLine(); //"9501011234567";
				gender = StringUtils.checkGender(ssn);
				System.out.println(gender);
				break;
			case 2:
				System.out.println("프로그램을 종료합니다.");
				run = false;
				break;
			default:
				System.out.println("잘못누르셨습니다.");
				break;
			}
			
		}
	}
}
