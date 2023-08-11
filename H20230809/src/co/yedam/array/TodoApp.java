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
		Todo[] todos = new Todo[50];	//Todo 타입의 배열 생성
		boolean run = true;
		int idx = 0;
		
		while(run) {
			System.out.println("\n============================================");
			System.out.println(" 1.등록 | 2.완료 | 3.조회 | 4.미완료 목록 | 5.종료  ");
			System.out.println("============================================");
			System.out.print("선택 >> ");
			
			int menu = Integer.parseInt(scan.nextLine());
			
			if(menu == 1) {
				System.out.print("등록 >> ");
				
				// 유저에게 입력 받기
				String[] data = scan.nextLine().split(",");
				//1 과제하기 0810
				//data[0] = 1
				//data[1] = 과제하기
				//data[2] = 0810
				
				// Todo 객체 생성
				Todo todo = new Todo();
				
				todo.no = Integer.parseInt(data[0]);
				todo.todo = data[1];
				todo.dueDate = data[2];
				todo.done = false;
				
				// Todo 객체를 todos[]에 넣기
				todos[idx] = todo;
				idx++;
				
			} else if(menu == 2) {
				// 완료 : 1 2 4를 입력시 1 2 4의 상태를 완료로 변경한다
				System.out.print("번호 입력 >> ");
				String[] no = scan.nextLine().split(",");
				
				for(int j=0; j<no.length; j++) {
					
					for(int i=0; i<todos.length; i++) {
						if(todos[i] != null && Integer.parseInt(no[j]) == todos[i].no ) {
							todos[i].done = true;
						}
					}
				}
				System.out.println("완료처리 되었습니다!");
				
			} else if(menu == 3) {
				System.out.print("조회 >> ");
				String[] date = scan.nextLine().split(",");
				
				// date배열에 담긴 날짜와 일치하는 날짜의 정보 출력
				for(int j=0; j<date.length; j++) {
					for(int i=0; i<todos.length; i++) {
						if(todos[i] != null && date[j].equals(todos[i].dueDate)) {
							System.out.printf("%d. %s (%s) %s\n", todos[i].no, todos[i].todo, todos[i].dueDate, todos[i].done == true ? "완료" : "미완료");
						}
					}
				}
				
			} else if(menu == 4) {
				System.out.println(sortSample(todos));
//				int arrLeng = sortSample(todos).length;
//				int[] nums = sortSample(todos);
//				
//				for(int i=0; i<arrLeng; i++) {
//					for(int j=0; j<todos.length; j++) {
//						if(nums[i] == todos[j].no) {
//							System.out.println(
//								todos[j].no + ". " + todos[j].todo + " (" + todos[j].dueDate + ") " + (todos[j].done == true ? "완료" : "미완료")
//							);
//						}
//					}
//				}
				
			} else if(menu == 5) {
				System.out.println("시스템을 종료합니다.");
				run = false;
			} else {
				System.out.println("메뉴를 다시 선택해주세요.");
			}
		}
		
		
	}
	
	public static int[] sortSample(Todo[] todos) {
		int[] nums = new int[todos.length];
		
		for(int i=0; i<todos.length; i++) {
			nums[i] = todos[i].no;
		}
		
		for(int j=0; j<nums.length; j++) {
			for(int i=0; i<nums.length-1; i++) {
				if(nums[i]>nums[i+1]) {
					int tmp = nums[i];
					nums[i] = nums[i+1];
					nums[i+1] = tmp;
				}
			}
		}
		
		return nums;
	}

}
