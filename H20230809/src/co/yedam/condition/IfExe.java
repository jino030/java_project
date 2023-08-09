package co.yedam.condition;

public class IfExe {

	public static void main(String[] args) {
		int score = 85;
		score = (int) (Math.random() * 100) + 1;
		String grade = "";
		
		if(score >= 90) {
			grade = "A";
		} else if(score >= 80) {
			grade = "B";
		} else if(score >= 70) {
			grade = "C";
		} else if(score >= 60) {
			grade = "D";
		} else {
			grade = "F";
		}
		System.out.printf("점수 %d, 등급 %s\n", score, grade);

		int score1 = score / 10;
		switch(score1) {
		case 10 : 
			grade = "A";
			break;
		case 9 : 
			grade = "A";
			break;
		case 8 : 
			grade = "B";
			break;
		case 7 : 
			grade = "C";
			break;
		case 6 : 
			grade = "D";
			break;
		default :
			grade = "F";
		}
		System.out.printf("점수 %d, 등급 %s", score, grade);
	}

}
