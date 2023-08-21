package co.yedam.generic;

public class Box<T> {
	// 타입을 Box 클래스를 사용하는 시점에 지정하기 위한 것 : 제네릭
	// T : type parameter
	// <T> : 제네릭
	T obj;
	
	T get() {
		return obj;
	}
	
	void set(T obj) {
		this.obj = obj;
	}
}
