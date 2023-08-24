package co.yedam.board.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import co.yedam.board.vo.User;

public class UserServiceImpl implements UserService {

	List<User> userList = new ArrayList<>();

	@Override
	public User checkLogin(User user) {

		// 파일에 저장된 정보 => userList.add
		File file = new File("C:/temp/users.txt");
		
		// 1. 파일 읽어오기.
		Scanner scn = null;
		try {
			scn = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		// 2. 파일의 내용 읽어오기
		while(true) {
			String line = null;
			try {
				line = scn.nextLine();
			} catch(NoSuchElementException e) {
				// 더이상 읽어올 라인이 없으면 반복문 종료
				break;
			}
			
			String[] data = line.split(" ");
			String id = data[0];
			String pw = data[1];
			String name = data[2];
			
			userList.add(new User(id, pw, name));
		}

		// 사용자에게 받은 user객체와 userList(파일)의 정보 비교하기
		for (int i = 0; i < userList.size(); i++) {
			if(user.getId().equals(userList.get(i).getId()) && //
					user.getPw().equals(userList.get(i).getPw())) {
				return userList.get(i);
			}
		}
		return null;
	}

}
