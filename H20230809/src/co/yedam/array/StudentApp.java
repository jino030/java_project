package co.yedam.array;

import java.util.Scanner;

public class StudentApp {

	public static void main(String[] args) {

		// 학생 데이터를 담는 공간(배열) 정의
		Student[] students = new Student[10];
		
		// 1. 등록 | 2. 조회 | 3. 목록 | 4. 종료
		Scanner scan = new Scanner(System.in);
		
		
		while(true) {
			System.out.println(" =============================================== ");
			System.out.println("  1. 학생 등록 | 2. 성적 조회 | 3. 학생 목록 | 4. 종료  ");
			System.out.println(" =============================================== ");
			
			System.out.print(" 입력> ");
			int num = scan.nextInt();
			int idx = 0;
			
			switch(num) {
			case 1 :
				// 학생 등록
				Student st = new Student();
				
				System.out.print(" 이름 입력> ");
				st.name = scan.nextLine();
				
				System.out.print(" 점수 입력> ");
				st.score = scan.nextInt();
				
				students[idx] = st;
				idx++;
				
				break;
				
			case 2 :
				// 이름을 입력하면 점수를 출력
				String name = scan.nextLine();
				
//				for() {
//					
//				}
				
				System.out.println("미완성");
				
				break;
				
			case 3 :
				// 전체 목록 출력
				System.out.println("[이 름] [점 수]");
				
				for(int i=0; i<students.length; i++) {
					System.out.printf("[%s] [%d점]", students[i].name, students[i].score);
				}
				
				break;
			
			case 4 :
				// 종료
				break;
			}
			break;
		}
		
		System.out.println("end of prog...");
		
		
	}

}
