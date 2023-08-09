package co.yedam.condition;

public class ConditionExe {

	public static void main(String[] args) {
		// 임의의 수가 나오는 케이스
		// 1 : 가위
		// 2 : 바위
		// 3 : 보
		
		int ranNum = (int) (Math.random()*3) + 1;
		
		switch(ranNum) {
		case 1 : 
			System.out.printf("%d는 '가위'입니다.\n", ranNum);
			break;
		case 2 : 
			System.out.printf("%d는 '바위'입니다.\n", ranNum);
			break;
		case 3 : 
			System.out.printf("%d는 '보'입니다.\n", ranNum);
			break;
		}
		
		int num = 97;
		char chr = 97;	// 2바이트 정수형 데이터 타입, ~6500, 각 숫자에 매핑된 문자 값이 있음.
		System.out.println(chr);

		// 147p 문제
		
		char chrRan = (char) ((Math.random() * 4) + 65);
		
		System.out.println("chrRan값은 " + chrRan + "입니다.");
		switch(chrRan) {
		case 'A' :
			System.out.println("VVIP 혜택 적용 가능");
			break;
		case 'B' :
			System.out.println("VIP 혜택 적용 가능");
			break;
		case 'C' :
			System.out.println("우수회원 혜택 적용 가능");
			break;
		case 'D' :
			System.out.println("일반회원 혜택 적용 가능");
			break;
		default :
			System.out.println("혜택이 없습니다");
		}
		
		
		while(true) {
			int ran = (int) (Math.random()*67) + 1;
			//System.out.println(ran + " 반복문 들어옴");
			if(ran>64 && ran<68) {
				char chr2 = (char) ran;
				switch(chr2) {
				case 65 :
					System.out.printf("%d(%s)는 'A'입니다.\n", ran, chr2);
					break;
				case 66 :
					System.out.printf("%d(%s)는 'B'입니다.\n", ran, chr2);
					break;
				case 67 :
					System.out.printf("%d(%s)는 'C'입니다.\n", ran, chr2);
					break;
				}
				//System.out.println(ran + " if문 들어옴 :::: chr2 = " + chr2);
				break;
			}
		}
	}

}
