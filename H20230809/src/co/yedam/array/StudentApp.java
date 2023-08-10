package co.yedam.array;

import java.util.Scanner;

public class StudentApp {

	public static void main(String[] args) {

		// 학생 데이터를 담는 공간(배열) 정의
		Student[] students = new Student[10];
		
		//테스트데이터
		Student s1 = new Student();
		s1.name = "일길동";
		s1.score = 97;
		s1.height = 189.6;
		s1.gender = Gender.MEN;
		
		Student s2 = new Student();
		s2.name = "이길동";
		s2.score = 83;
		s1.height = 168.7;
		s1.gender = Gender.MEN;
		
		Student s3 = new Student();
		s3.name = "삼길동";
		s3.score = 87;
		s1.height = 165.3;
		s1.gender = Gender.WOMEN;
		
		students[0] = s1;
		students[1] = s2;
		students[2] = s3;
		//테스트데이터
		
		// 1. 등록 | 2. 조회 | 3. 목록 | 4. 키큰학생 | 5. 종료
		Scanner scan = new Scanner(System.in);
		int idx = 2;
		boolean run = true;
		
		while(run) {
			System.out.println("");
			System.out.println("=========================================================== ");
			System.out.println(" 1. 학생 등록 | 2. 성적 조회 | 3. 학생 목록 | 4. 키큰학생 | 5. 종료  ");
			System.out.println("=========================================================== ");
			
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
				
				System.out.print("키 입력 > ");
				st.height = scan.nextDouble();
				
				students[idx] = st;
				idx++;
				
				continue;
				
			case 2 :
				// 이름을 입력하면 점수를 출력
				System.out.print("학생 이름 > ");
				String name = scan.next();
				int cnt = 0;
				
				for(int i=0; i<idx; i++) {
					String arrName = students[i].name;
					
					if(arrName.equals(name)) {
						System.out.println( 
							">>> " + arrName + "학생의 점수는 [" + students[i].score + "점] 입니다."
						);
						cnt++;
					}
				}
				
				if(cnt == 0) {
					System.out.println(">>> 일치하는 학생이 없습니다.");
				}
				
				continue;
				
			case 3 :
				// 전체 목록 출력
				System.out.println("");
				System.out.println("   ======================================");
				System.out.println("     학생명   |    점수    |       키       ");
				System.out.println("   ======================================");
				
				for(int i=0; i<students.length; i++) {
					if(students[i] != null && students[i].gender == Gender.MEN) {
						System.out.printf("     %s   |    %d점    |%10.1f     \n", students[i].name, students[i].score, students[i].height);
						System.out.println("   --------------------------------------");
					}
				}
				
				continue;
			
			case 4 :
				// 키가 가장 큰 학생의 이름
				//double height = Double.parseDouble(scan.nextLine());
				double max = 0;
				int h_idx = 0;
				
				// 키의 max값 찾기
				for(int i=0; i<idx; i++) {
					if(max < students[i].height) {
						max = students[i].height;
						h_idx = i;
					}
				}
				System.out.println("키가 가장 큰 학생 >> " + students[h_idx].name);
				
				continue;
				
			case 5 :
				// 종료
				run = false;
			}
		}
		
		System.out.println("\n:::::::::: 프로그램을 종료합니다 ::::::::::");
		
	}

}
