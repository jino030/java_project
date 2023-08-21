package co.yedam.stream;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamExe {
	public static void main(String[] args) {
		try {
			// input
			FileInputStream fis = new FileInputStream("C:/Temp/out.data");
			while (true) {
				int val = fis.read(); // 1byte씩 읽어옴..
				if(val == -1) {
					break;
				}
				System.out.println(val);
			}

			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("end of prog..");
	}

}
