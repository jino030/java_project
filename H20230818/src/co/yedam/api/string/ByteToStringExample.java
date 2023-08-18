package co.yedam.api.string;

public class ByteToStringExample {
	public static void main(String[] args) {
		// 바이트 배열을 문자열로 변환하기
		byte[] bytes = { 72, 101, 108, 108, 111, 32, 74, 97, 118, 97 };

		String str1 = new String(bytes);
		System.out.println(str1);
		
		// idx 6부터 4개 가져와라..[6,7,8,9]
		String str2 = new String(bytes, 6, 4);
		System.out.println(str2);
	}
}
