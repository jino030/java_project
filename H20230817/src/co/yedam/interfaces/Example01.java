package co.yedam.interfaces;

public class Example01 {
	public static void main(String[] args) {
		int[][] intAry = new int[5][5];

		int snum = 1;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				intAry[i][j] = snum++;
			}
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.printf("%3d", intAry[i][j]);
				//System.out.printf("%5s", "[" + i + "," + j + "]");
			}
			System.out.println("");
		}
		System.out.println("");
		
		snum=1;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				intAry[j][i] = snum++;
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.printf("%3d", intAry[i][j]);
				//System.out.printf("%5s", "[" + i + "," + j + "]");
			}
			System.out.println("");
		}
		System.out.println("");
		
		
		snum=1;
		for (int i = 0; i < 5; i++) {
			for (int j = 4; j >= 0; j--) {
				intAry[j][i] = snum++;
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.printf("%3d", intAry[i][j]);
				//System.out.printf("%5s", "[" + i + "," + j + "]");
			}
			System.out.println("");
		}
		System.out.println("");
		
		snum = 25;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				intAry[i][j] = snum--;
			}
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.printf("%3d", intAry[i][j]);
				//System.out.printf("%5s", "[" + i + "," + j + "]");
			}
			System.out.println("");
		}
		System.out.println("");
		
		snum=25;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				intAry[j][i] = snum--;
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.printf("%3d", intAry[i][j]);
				//System.out.printf("%5s", "[" + i + "," + j + "]");
			}
			System.out.println("");
		}
		System.out.println("");
	}
}