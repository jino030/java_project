package co.yedam.stream;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamExe {
	public static void main(String[] args) {
		try {
			// output
			FileOutputStream fos = new FileOutputStream("C:/Temp/out.data");
			fos.write(100);
			fos.write(110);
			fos.write(120);

			fos.flush(); // 버퍼에 남아있는 캐시값을 비우겠다..
			fos.close(); // 사용한 리소스를 os에 환원하겠다..

			

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("end of prog..");
	}
}
