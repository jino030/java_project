package co.yedam.api;

import java.io.UnsupportedEncodingException;

public class StringExe {
	public static void main(String[] args) {
		
		String str1 = "글";
		try {
			byte[] bin = str1.getBytes( "UTF-8" );

			for(byte b : bin) {
				System.out.println(b);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		//byte[] bytes = { 104, 101, 108, 108, 111 };
		byte[] bytes = { -19, -107, -100, -22, -72, -128};
		String str = null;
		try {
			str = new String(bytes, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(str);
	}
}
