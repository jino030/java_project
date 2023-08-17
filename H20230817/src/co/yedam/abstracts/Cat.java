package co.yedam.abstracts;

public class Cat extends Animal {

	public Cat(String name) {
		super(name);
	}

	@Override
	public void sound() {
		System.out.println("내이름은 " + getName() + "임. 냥냥!");
	}

}
