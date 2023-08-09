package co.yedam.array;

import java.util.Scanner;

public class StudentApp {

	public static void main(String[] args) {

		// 학생 데이터를 담는 공간(배열) 정의
		Student[] students = new Student[10];
		
		// 1. 등록 | 2. 조회 | 3. 목록 | 4. 종료
		Scanner scan = new Scanner(System.in);
		int idx = 0;
		
		while(true) {
			System.out.println("");
			System.out.println("=============================================== ");
			System.out.println(" 1. 학생 등록 | 2. 성적 조회 | 3. 학생 목록 | 4. 종료  ");
			System.out.println("=============================================== ");
			
			System.out.print("입력 > ");
			int num = scan.nextInt();
			
			switch(num) {
			case 1 :
				// 학생 등록
				Student st = new Student();
				
				System.out.print("이름 입력 > ");
				st.name = scan.next();
				
				System.out.print("점수 입력 > ");
				st.score = scan.nextInt();
				
				students[idx] = st;
				idx++;
				
				continue;
				
			case 2 :
				// 이름을 입력하면 점수를 출력
				System.out.print("학생 이름 > ");
				String name = scan.next();
				
				for(int i=0; i<idx; i++) {
					String arrName = students[i].name;
					
					if(arrName.equals(name)) {
						System.out.println( ">>> " + arrName + "학생의 점수는 [" 
											+ students[i].score + "점] 입니다.");
					}
				}
				
				continue;
				
			case 3 :
				// 전체 목록 출력
				System.out.println("");
				System.out.println("   =====================");
				System.out.println("     학생명   |    점수    ");
				System.out.println("   =====================");
				
				for(int i=0; i<idx; i++) {
					System.out.printf("     %s   |    %d점     \n", students[i].name, students[i].score);
					System.out.println("   ---------------------");
				}
				
				continue;
			
			case 4 :
				// 종료
				break;
			}
			break;
		}
		
		System.out.println("\n:::::::::: 프로그램을 종료합니다 ::::::::::");
		
	}

}
