package co.yedam.loop;

public class WhileExe {

	public static void main(String[] args) {

		boolean run = true;
		
		while(run) {
			int tmp = (int) (Math.random() * 100);
			if(tmp > 90) {
				//break;
				run = false;
			}
			System.out.println(tmp);
		}
		System.out.println("end of while..");
		
	}

}
