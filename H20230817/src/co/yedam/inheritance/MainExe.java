package co.yedam.inheritance;

public class MainExe {
	public static void main(String[] args) {
		CellPhone cell = new CellPhone();
		cell.setModel("SM1100");
		cell.setColor("black");
		cell.turnOn();
		cell.turnOff();
		System.out.println(cell.toString());
		System.out.println("------------------------------------------------------");

		DmbCellPhone dmb = new DmbCellPhone();
		dmb.setModel("DMB1100");
		dmb.setColor("white");
		dmb.turnOn();
		dmb.turnOff();
		dmb.turnOnDmb();
		dmb.turnOffDmb();
		System.out.println(dmb.toString());
		System.out.println("------------------------------------------------------");

		// promotion
		CellPhone cell2 = new DmbCellPhone();
		cell2.turnOn();
		// cell2.turnOnDmb(); // The method turnOnDmb() is undefined for the type CellPhone 오류 발생
		System.out.println("------------------------------------------------------");

		if (cell2 instanceof DmbCellPhone) {
			DmbCellPhone dmb2 = (DmbCellPhone) cell2; // 부모클래스는 자식클래스로 자동형변환이 되지 않으므로 명시적으로 강제적 형변환을 해야함.
			dmb2.turnOffDmb(); // 자식클래스에 정의된 기능 사용.
		} else {
			System.out.println("실행하지 못합니다.");
		}
		System.out.println("------------------------------------------------------");

		if (cell instanceof DmbCellPhone) {
			DmbCellPhone dmb3 = (DmbCellPhone) cell;
			dmb3.turnOnDmb(); // 인스턴스의 값이 부모클래스인 경우 실행시점에 에러발생 가능.. => 검증절차 필요 (instanceof 키워드 사용)
		} else {
			System.out.println("실행하지 못합니다.");
		}
		System.out.println("------------------------------------------------------");

		CellPhone[] phones = new CellPhone[5];
		phones[0] = cell;
		phones[1] = dmb;
		phones[2] = cell2;

		// 다형성..
		phones[0].turnOn(); // CellPhone 인스턴스
		phones[1].turnOn(); // DmbCellPhone 인스턴스

		System.out.println("------------------------------------------------------");

	}
}
