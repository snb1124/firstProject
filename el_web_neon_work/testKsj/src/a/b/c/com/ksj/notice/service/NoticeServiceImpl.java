package a.b.c.com.ksj.notice.service;

import java.util.ArrayList;

import a.b.c.com.ksj.notice.dao.NoticeDAO;
import a.b.c.com.ksj.notice.dao.NoticeDAOImpl;
import a.b.c.com.ksj.notice.vo.NoticeVO;

public class NoticeServiceImpl implements NoticeService {

	@Override
	public ArrayList<NoticeVO> noticeSelectAll() {
		// TODO Auto-generated method stub
		System.out.println("NoticeServiceImpl noticeSelectAll() �Լ� ���� >>> : ");		
		
		NoticeDAO ndao = new NoticeDAOImpl();
		return ndao.noticeSelectAll();
	}

	@Override
	public ArrayList<NoticeVO> noticeSelect(NoticeVO nvo) {
		// TODO Auto-generated method stub
		System.out.println("NoticeServiceImpl noticeSelect() �Լ� ���� >>> : ");		
		
		NoticeDAO ndao = new NoticeDAOImpl();
		return ndao.noticeSelect(nvo);
	}

	@Override
	public int noticeInsert(NoticeVO nvo) {
		// TODO Auto-generated method stub
		System.out.println("NoticeServiceImpl noticeInsert() �Լ� ���� >>> : ");		
		
		NoticeDAO ndao = new NoticeDAOImpl();
		return ndao.noticeInsert(nvo);
	}

	@Override
	public int noticeUpdate(NoticeVO nvo) {
		// TODO Auto-generated method stub
		System.out.println("NoticeServiceImpl noticeUpdate() �Լ� ���� >>> : ");		
		
		NoticeDAO ndao = new NoticeDAOImpl();
		return ndao.noticeUpdate(nvo);
	}

	@Override
	public int noticeDelete(NoticeVO nvo) {
		// TODO Auto-generated method stub
		System.out.println("NoticeServiceImpl noticeDelete() �Լ� ���� >>> : ");		
		
		NoticeDAO ndao = new NoticeDAOImpl();
		return ndao.noticeDelete(nvo);
	}

}
