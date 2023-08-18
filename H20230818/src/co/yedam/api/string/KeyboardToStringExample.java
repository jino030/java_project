package co.yedam.api.string;

import java.io.IOException;

public class KeyboardToStringExample {

	public static void main(String[] args) {
		byte[] bytes = new byte[100];

		System.out.print("입력 : ");
		int readByteNo = 0;
		try {
			readByteNo = System.in.read(bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}

		String str = new String(bytes, 0, readByteNo - 2);
		System.out.println(str);
	}

}
