package co.yedam.api;

public class StringUtils {
	
	/* 후보값
	 * 9501011234567
	 * 9501012234567
	 * 0101013234567
	 * 0101014234567
	 * 010101 3234567
	 * 010101 4234567
	 * 010101-3234567
	 * 010101-4234567
	 * 
	 * 오류값
	 * 9501013234567
	 * 9501014234567
	 * 012345678910111213
	 * 010101 1234 5 6 7
	 * 010101 2234567
	 */
	
	static String checkGender(String ssn) {
		// 주민번호 구분해서 남자, 여자, 오류 케이스 판별..
		String result = "";
		int year = Integer.parseInt(ssn.substring(0,2));
		char sex = ssn.charAt(6);
		// 중간에 공백이나 하이픈이 들어가면
		if (sex == ' ' || sex == '-') {
			sex = ssn.charAt(7);
		}
		// 00 ~ 23 : 3,4
		// 24 ~ 99 : 1,2
		if(year>=24 && year<=99) {
			if(sex == '3' || sex == '4') {
				result = "잘못된 주민등록번호 입니다.";
				return result;
			}
		} else if(year>=0 && year<=23) {
			if(sex == '1' || sex == '2') {
				result = "잘못된 주민등록번호 입니다.";
				return result;
			}
		}
		
		switch (sex) {
		case '1':
		case '3':
			result = "남자입니다.";
			break;
		case '2':
		case '4':
			result = "여자입니다.";
			break;
		default:
			result = "잘못된 주민등록번호 입니다.";
			break;
		}



		return result;
	}

	static String getFileName(String filePath) {
		// 전체경로에서 파일이름만 출력
		String[] data = filePath.split("/");
		int length = data.length;
		String fileName = data[length-1];
		
		return fileName;
	}
}
