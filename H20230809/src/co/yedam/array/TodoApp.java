package co.yedam.array;

import java.util.Scanner;

public class TodoApp {

	public static void main(String[] args) {

		// 등록/완료/조회(날짜)/미완료
		// 등록 : ([1] 할일 0812), 순번은 계산해서, done은 기본 false이고 완료했을때 true로
		// 완료 : 1 2 4를 입력시 1 2 4의 상태를 완료로 변경한다
		// 조회 : 날짜를 넣으면 해당날짜의 목록을 보여준다(여러건 가능)
		// 미완료 : 미완료 상태인 목록을 출력(순번기준으로 정렬)

		Scanner scan = new Scanner(System.in);
		Todo[] todos = new Todo[50]; // Todo 타입의 배열 생성
		boolean run = true;
		int idx = 0;

		while (run) {
			System.out.println("\n============================================");
			System.out.println(" 1.등록 | 2.완료 | 3.조회 | 4.미완료 목록 | 5.종료  ");
			System.out.println("============================================");
			System.out.print("선택 >> ");

			int menu = Integer.parseInt(scan.nextLine());

			if (menu == 1) {
				System.out.print("등록 >> ");

				// 유저에게 입력 받기
				String[] data = scan.nextLine().split(",");
				// 1 과제하기 0810
				// data[0] = 1
				// data[1] = 과제하기
				// data[2] = 0810

				// Todo 객체 생성
				Todo todo = new Todo();

				todo.no = Integer.parseInt(data[0]);
				todo.todo = data[1];
				todo.dueDate = data[2];
				todo.done = false;

				// Todo 객체를 todos[]에 넣기
				todos[idx] = todo;
				idx++;

			} else if (menu == 2) {
				// 완료 : 1 2 4를 입력시 1 2 4의 상태를 완료로 변경한다
				System.out.print("번호 입력 >> ");
				String[] no = scan.nextLine().split(",");

				for (int j = 0; j < no.length; j++) {

					for (int i = 0; i < todos.length; i++) {
						if (todos[i] != null && Integer.parseInt(no[j]) == todos[i].no) {
							todos[i].done = true;
						}
					}
				}
				System.out.println("완료처리 되었습니다!");

			} else if (menu == 3) {
				System.out.print("조회 >> ");
				String[] date = scan.nextLine().split(",");

				// 정렬위한 배열생성
				Todo[] sortAry = new Todo[date.length];

				for (int i = 0; i < date.length; i++) {
					for (int j = 0; j < todos.length; j++) {
						if (todos[j] != null && date[i].equals(todos[j].dueDate)) {
							// 일치하는 데이터 정렬을 위해 새로운 배열에 담아두기
							sortAry[i] = todos[j];
						}
					}
				}

				// 일치하는 데이터 정렬
				for (int i = 0; i < sortAry.length - 1; i++) {
					if (sortAry[i] != null) {
						for (int j = 0; j < sortAry.length - 1; j++) {
							Todo tmp = new Todo();
							if (sortAry[j] != null && sortAry[j].no > sortAry[j + 1].no) {
								tmp = sortAry[j];
								sortAry[j] = sortAry[j + 1];
								sortAry[j + 1] = tmp;
							}
						}
					}
				}

				// 출력
				for (int i = 0; i < sortAry.length; i++) {
					if (sortAry[i] != null) {
						System.out.printf("%d. %s (%s) %s\n", sortAry[i].no, sortAry[i].todo, sortAry[i].dueDate,
								sortAry[i].done == true ? "완료" : "미완료");
					}
				}

			} else if (menu == 4) {

				int cnt = 0;
				for (int i = 0; i < todos.length; i++) {
					if (todos[i] != null) {
						cnt++;
					}
				}

				// -1하는 이유는 : 마지막값은 비교대상이 없으므로!!마지막값을 다음값과 비교하게되면 null예외 발생!
				for (int i = 0; i < cnt - 1; i++) {
					if (todos[i] != null) {
						for (int j = 0; j < cnt - 1; j++) {
							Todo tmp = new Todo();
							if (todos[j] != null && todos[j].no > todos[j + 1].no) {
								tmp = todos[j];
								todos[j] = todos[j + 1];
								todos[j + 1] = tmp;
							}
						}
					}
				}

				for (int i = 0; i < todos.length; i++) {
					if (todos[i] != null && todos[i].done == false) {
						System.out.printf("%d. %s (%s) %s\n", todos[i].no, todos[i].todo, todos[i].dueDate,
								todos[i].done == true ? "완료" : "미완료");
					}
				}

			} else if (menu == 5) {
				System.out.println("시스템을 종료합니다.");
				run = false;
			} else {
				System.out.println("메뉴를 다시 선택해주세요.");
			}
		}

	}

	public static int[] sortSample(Todo[] todos) {
		int[] nums = new int[todos.length];

		for (int i = 0; i < todos.length; i++) {
			nums[i] = todos[i].no;
		}

		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length - 1; j++) {
				if (nums[j] > nums[j + 1]) {
					int tmp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = tmp;
				}
			}
		}

		return nums;
	}

}
