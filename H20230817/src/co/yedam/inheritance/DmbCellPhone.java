package co.yedam.inheritance;

public class DmbCellPhone extends CellPhone {
	private int channel;

	public void changeChannerl(int channel) {
		this.channel = channel;
	}

	public void turnOnDmb() {
		System.out.println("DMB 폰을 켭니다.");
	}

	public void turnOffDmb() {
		System.out.println("DMB 폰을 끕니다.");
	}

	// 재정의(Overriding)
	@Override
	public void turnOn() {
		//super.turnOn(); // super:부모클래스를 지칭.
		System.out.println(getModel() + "모델의 전원을 켭니다.(메소드 재정의)");
	}

}
