package co.yedam.abstracts;

public class Dog extends Animal {

	public Dog(String name) {
		super(name);
	}

	@Override
	public void sound() {
		System.out.println("내이름은 " + getName() + "임. 왕왕!");
	}

}
