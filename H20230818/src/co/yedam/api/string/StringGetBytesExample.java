package co.yedam.api.string;

import java.io.UnsupportedEncodingException;

public class StringGetBytesExample {
	public static void main(String[] args) {
		String str = "안녕하세요";

		// 문자열 str을 인코딩 (바이트배열로 저장)
		byte[] bytes1 = str.getBytes();
		System.out.println("bytes1.length: " + bytes1.length);
		// 인코딩된 바이트 배열을 디코딩
		String str1 = new String(bytes1);
		System.out.println("bytes1->String: " + str1);

		// 문자셋 지정후 인코딩, 디코딩
		try {
			
			// EUC-KR
			byte[] bytes2 = str.getBytes("EUC-KR"); // 문자셋 지정한 인코딩 => 예외처리 필수
			System.out.println("bytes2.length: " + bytes2.length);
			String str2 = new String(bytes2, "EUC-KR"); // 문자셋 지정한 디코딩
			System.out.println("bytes2->String: " + str2);
			
			// UTF-8
			byte[] bytes3 = str.getBytes("UTF-8");
			System.out.println("bytes3.length: " + bytes3.length);
			String str3 = new String(bytes3, "UTF-8");
			System.out.println("bytes3->String: " + str3);
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
