package co.yedam.array;

public class FuncExe {
	
	public static void main(String[] args) {
		
		// 메소드 호출
		printStar();
		printStar(3);
		printStar(5);
		printString(3, "배고파요..");
		
		int result = sum(5,7);
		System.out.println(result);
		
		int[] intAry = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		int result2 = sum(intAry);
		System.out.println(result2);
		
		Friend f = getFriend("정재륜","큐티짱짱",Gender.WOMEN);
		f.showInfo();
	}
	
	
	// 리턴값이 없는 메소드
	public static void printStar() {
		System.out.println("★");
	}
	
	// 매개변수를 가진 메소드
	public static void printStar(int times) {
		for(int i=0; i<times; i++) {
			System.out.print("★");
		}
		System.out.println("");
	}
	
	public static void printString(int times, String str) {
		for(int i=0; i<times; i++) {
			System.out.print(str);
		}
		System.out.println("");
	}
	
	// 리턴값이 있는 메소드
	public static int sum(int num1, int num2) {
		int result = num1 + num2;
		return result;
	}
	
	// 매개변수의 타입이 배열
	public static int sum(int[] arry) {
		int sum = 0;
		
		for(int i=0; i<arry.length; i++) {
			sum += arry[i];
		}
		
		return sum;
	}
	
	public static Friend getFriend(String name, String phone, Gender gender) {
		Friend f = new Friend();
		f.name = name;
		f.phone = phone;
		f.gender = gender;
		
		return f;
	}
}
