package co.yedam.stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		try {
			FileInputStream fis = new FileInputStream("C:/Temp/img1.jpg"); // 파일읽어오기
			FileOutputStream fos = new FileOutputStream("C:/Temp/copy.jpg"); // 파일내보내기
			// 100byte씩 읽어오기
			byte[] buf = new byte[100];
			
			while (true) {
				int val = fis.read(buf); // 더이상 읽어올게 없으면 -1을 반환함.
				if (val == -1) {
					break;
				}
				fos.write(buf);
			}

			fis.close();
			fos.flush();
			fos.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("end of prog..");

		// cpu가 아무리빨라도 IO가 많이 일어나면 정체가 일어남..
		long end = System.currentTimeMillis();
		System.out.println("end - " + (end - start) + "ms");
	}
}
