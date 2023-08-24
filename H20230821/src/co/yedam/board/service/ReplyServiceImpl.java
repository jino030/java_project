package co.yedam.board.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import co.yedam.board.vo.Reply;

public class ReplyServiceImpl implements ReplyService {

	List<Reply> replyList = new ArrayList<>(); 
	
	public ReplyServiceImpl() {
		init();
	}
	
	// 저장된 댓글 불러오기
	private void init() {
		try {
			FileInputStream fis = new FileInputStream("C:/temp/reply.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			replyList = (List<Reply>) ois.readObject(); // 역직렬화
			ois.close();
			fis.close();

		} catch (Exception e) {
			// e.printStackTrace();
		}
	}
	
	// 댓글번호 가져오기..
	private int getMaxNo() {
		int repNo = 0;
		for(int i=0; i<replyList.size(); i++) {
			if(replyList.get(i).getrepNo() > repNo) {
				repNo = replyList.get(i).getrepNo();
			}
		}
		return repNo + 1; // 등록된 댓글이 없으면 1반환.
	}
	
	@Override
	public boolean add(Reply reply) {
		reply.setrepNo(getMaxNo()); // 글번호 세팅
		return replyList.add(reply);
	}

	@Override
	public void list(int brdNo) {
		for (Reply r : replyList) {
			if (r.getBrdNo() == brdNo) {
				System.out.println(r.replyInfo());
			}
		}
	}

	@Override
	public boolean remove(int repNo) {
		for(int i=0; i<replyList.size(); i++) {
			if(replyList.get(i).getrepNo() == repNo) {
				replyList.remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public String getResponseUser(int repNo) {
		for (int i = 0; i < replyList.size(); i++) {
			if(repNo == replyList.get(i).getrepNo()) {
				return replyList.get(i).getrepWriter();
			}
		}
		return null;
	}

	// 종료시 댓글내용 파일로 저장
	@Override
	public void save() {
		try {
			FileOutputStream fos = new FileOutputStream("C:/temp/reply.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(replyList); // 댓글 객체 저장
			
			oos.flush();
			oos.close();
			fos.flush();
			fos.close();
			
			System.out.println("댓글 파일저장 성공~!");
			
		} catch (Exception e) {
			System.out.println("댓글 파일저장 실패!");
			e.printStackTrace();
		}
	}

}
