package co.yedam.abstracts;

public class MainExe {
	public static void main(String[] args) {
		// 추상클래스는 인스턴스 생성 불가능!!
		//Animal animal = new Animal();
		
		Animal animal = new Dog("대갈");
		animal.sound();
		
		Animal animal2 = new Cat("뿌꾸");
		animal2.sound();
	}
}
