package co.yedam.array;

import java.util.Arrays;

/*
 *	학생 클래스 
 */
class Student {
	String name;
	int score;
}

public class ArrayExe3 {

	public static void main(String[] args) {
		
		Student[] students = new Student[3];
		
		// 학생3명 생성
		Student s1 = new Student();
		s1.name = "고구마";
		s1.score = 97;
		
		Student s2 = new Student();
		s2.name = "고길동";
		s2.score = 83;
		
		Student s3 = new Student();
		s3.name = "고동색";
		s3.score = 87;
		
		students[0] = s1;
		students[1] = s2;
		students[2] = s3;
		
		int max = 0;
		String name = "";
		//System.out.println(students[0].name + students[0].score);
		for(int i=0; i<students.length; i++) {
			if(max < students[i].score) {
				max = students[i].score;
				name = students[i].name;
			}
		}
		System.out.println("\n (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ ▒ 1등은 " + name + ", " + max +"점 입니다 ▒ *:･ﾟ✧*:･ﾟ✧");

		
		
		
		
		String[] names = {"홍길동", "김길동", "박길동", "최길동"};
		int[] scores = {88, 98, 67, 73};
		
		// 젤 높은 점수를 받은 학생의 이름 출력
		max = 0;
		int idx = 0;
		for(int i=0; i<names.length; i++) {
			if(max < scores[i]) {
				max = scores[i];
				idx = i;
			}
		}
		System.out.println("\n (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ ▒ 1등은 " + names[idx] + ", " + scores[idx] +"점 입니다 ▒ *:･ﾟ✧*:･ﾟ✧");
		
	}

}
