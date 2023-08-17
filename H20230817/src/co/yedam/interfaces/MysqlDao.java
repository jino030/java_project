package co.yedam.interfaces;

public class MysqlDao implements Dao {

	@Override
	public void insert() {
		System.out.println("MySQL 입력기능");
	}

	@Override
	public void update() {
		System.out.println("MySQL 수정기능");
	}

	@Override
	public void delete() {
		System.out.println("MySQL 삭제기능");
	}

	@Override
	public void select() {
		System.out.println("MySQL 조회기능");
	}

}
