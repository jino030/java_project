package co.yedam.loop;

public class ForExe {

	public static void main(String[] args) {
		
		int sum = 0;
		
		for(int i=1; i<6; i++) {
			sum += i;
		}
		
		System.out.println("sum = " + sum);
		
		// 150p - 1~10까지 출력
		for(int i=1; i<=10; i++) {
			System.out.println("i : " + i);
		}
		
		// 151p - 1~100까지 합 출력
		sum = 0;
		for(int i=1; i<=100; i++) {
			sum += i;
		}
		System.out.println("1~100 합 : " + sum );
	}

}
