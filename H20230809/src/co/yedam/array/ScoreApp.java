package co.yedam.array;

import java.util.Scanner;

class Member{
	String name;
	int score;
}

public class ScoreApp {

	public static void main(String[] args) {
		// 201p 확인문제
		
		boolean run = true;
		int studentNum = 0;
		Member[] scores = null;
		Scanner scanner = new Scanner(System.in);
		
		while(run) {
			System.out.println("================================================");
			System.out.println(" 1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료 ");
			System.out.println("================================================");
			
			System.out.print("선택 >> ");
			
			int selectNo = Integer.parseInt(scanner.nextLine());
			
			if(selectNo == 1) {
				System.out.print("학생수 >> ");
				studentNum  = Integer.parseInt(scanner.nextLine());
				scores = new Member[studentNum];
				
				
			} else if(selectNo == 2) {
				
				for(int i=0; i<scores.length; i++) {
					System.out.print("이름 점수 >> ");
					String[] data = scanner.nextLine().split(" ");
					
					// 멤버 객체 생성 후 이름, 점수 셋팅
					Member mem = new Member();
					mem.name = data[0];
					mem.score = Integer.parseInt(data[1]);
					
					// 생성된 객체를 scores 배열에 넣기
					scores[i] = mem;
				}
				
			} else if(selectNo == 3) {
				for(int i=0; i<scores.length; i++) {
					System.out.printf("scores[%d]> 이름: %s / 점수: %d\n", i, scores[i].name, scores[i].score);
				}
				
			} else if(selectNo == 4) {
				int max = 0;
				double sum = 0;
				double avg;
				
				for(int i=0; i<scores.length; i++) {
					sum += scores[i].score;
					if(max < scores[i].score) {
						max = scores[i].score;
					}
				}
				avg = sum / scores.length;
				
				System.out.println("최고 점수: " + max);
				System.out.println("평균 점수: " + avg);
				
			} else if(selectNo == 5) {
				run = false;
			} else {
				System.out.println("메뉴를 다시 선택하세요");
			}
		}
		
		System.out.println("프로그램 종료!!");

	}

}
