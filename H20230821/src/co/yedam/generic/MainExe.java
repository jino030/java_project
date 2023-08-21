package co.yedam.generic;

public class MainExe {
	public static void main(String[] args) {
		Box<String> box = new Box<String>();
		box.set("Hello");
		String result = box.get();
		System.out.println(result);
		
		Box<Integer> ibox = new Box<Integer>();
		ibox.set(10);
		Integer iresult = ibox.get();
		System.out.println(iresult);
		
		// Box의 필드가 Object 타입일때..
		// box.set(10);	// 10 (Integer : 매퍼클래스?)
		// result = (String) box.get();	// 캐스팅 오류..
	}
}
