package co.yedam.loop;

import java.util.Scanner;

public class LoopTest {

	public static void main(String[] args) {
		
		// 160p 확인문제(2)
		System.out.println("============ 확인문제(2) ============");
		int sum = 0;
		
		for(int i=1; i<=100; i++) {
			if(i%3 == 0) {
				sum += i;
			}
		}
		System.out.println("1~100 사이의 3의 배수 합 : " + sum);
		
		// 160p 확인문제(3)
		System.out.println("\n============ 확인문제(3) ============");
		while(true) {
			int num1 = (int) (Math.random()*6)+1;
			int num2 = (int) (Math.random()*6)+1;
			
			System.out.printf("(%d, %d)\n", num1, num2);
			
			if(num1 + num2 == 5) {
				System.out.println("주사위의 합이 5!! \n프로그램 종료!");
				break;
			} else {
				continue;
			}
		}
		
		// 160p 확인문제(4)
		System.out.println("\n============ 확인문제(4) ============");
		for(int x=-10; x<=10; x++) {
			for(int y=-10; y<=10; y++) {
				if(4*x + 5*y == 60) {
					System.out.printf("(%d, %d)\n", x, y);
				}
			}
		}
		
		// 160p 확인문제(5)
		System.out.println("\n============ 확인문제(5) ============");
		for(int i=1; i<=4; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
		// 160p 확인문제(6)
		System.out.println("\n============ 확인문제(6) ============");
		for(int i=1; i<=4; i++) {
			for(int j=3; j>=i; j--) {
				System.out.print(" ");
			}
			for(int s=1; s<=i; s++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
		// 160p 확인문제(7)
		System.out.println("\n============ 확인문제(7) ============");
		boolean run = true;
		int balance = 0;
		Scanner scanner = new Scanner(System.in);
		
		while(run) {
			
			System.out.println("\n ─────────────────────────────────");
			System.out.println("  1.예금 | 2. 출금 | 3. 잔고 | 4.종료 ");
			System.out.println(" ―――――――――――――――――――――――――――――――――");
			
			System.out.print(" 선택> ");
			int num = scanner.nextInt();
			
			if(num == 1) {
				System.out.print(" 예금액> ");
				int money = scanner.nextInt();
				if(money>0) {
					balance += money;
				} else {
					System.out.println(" 입금 불가");
				}
			} else if(num == 2) {
				System.out.print(" 출금액> ");
				int money = scanner.nextInt();
				if(money > 0 && (balance - money) >= 0) {
					balance -= money;
				} else {
					System.out.println(" 출금 불가");
				}
			} else if(num == 3) {
				System.out.println(" 잔고> " + balance);
			} else if(num == 4) {
				break;
			}
		}
		
		System.out.println("\n 프로그램 종료");
		
	}

}
