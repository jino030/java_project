package co.yedam.array;

import java.util.Arrays;

public class TodoApp {

	public static void main(String[] args) {
		// 등록/완료/조회(날짜)/미완료
		// 등록 : ([1] 할일 0812), 순번은 계산해서, done은 기본 false이고 완료했을때 true로
		// 완료 : 1 2 4를 입력시 1 2 4의 상태를 완료로 변경한다
		// 조회 : 날짜를 넣으면 해당날짜의 목록을 보여준다(여러건 가능)
		// 미완료 : 미완료 상태인 목록을 출력(순번기준으로 정렬)
	}
	
	public static void sortSample() {
		int[] intAry = {95, 55, 88, 77, 65, 8};
		Arrays.sort(intAry);
		System.out.println(Arrays.toString(intAry));
	}

}
