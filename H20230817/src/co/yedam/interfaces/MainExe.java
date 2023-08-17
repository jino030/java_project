package co.yedam.interfaces;

import java.util.Scanner;

public class MainExe {
	public static void main(String[] args) {
		//Dao dao = new MysqlDao();
		Dao dao = new OracleDao();
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		int menu = -1;

		while (run) {
			System.out.println("\n| 1.입력 | 2.조회 | 3.수정 | 4.삭제 | 5.종료 |");
			System.out.print("선택 >> ");
			menu = scn.nextInt(); // [3 엔터] 치면 엔터가 처리안되고 남아있게 됨.
			scn.nextLine(); // 엔터키를 소진시켜주는 코드가 필요.

			switch (menu) {
			case 1:
				dao.insert();
				break;
			case 2:
				dao.select();
				break;
			case 3:
				dao.update();
				break;
			case 4:
				dao.delete();
				break;
			case 5:
				System.out.println("::::: 시스템을 종료합니다! :::::");
				run = false;
				break;

			default:
				System.out.println("잘못된 매뉴입니다.");
			}// end of switch
		} // end of while
	}// end of main
}
