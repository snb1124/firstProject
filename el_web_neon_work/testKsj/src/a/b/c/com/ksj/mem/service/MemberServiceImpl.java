package a.b.c.com.ksj.mem.service;

import java.util.ArrayList;

import a.b.c.com.ksj.mem.dao.MemberDAO;
import a.b.c.com.ksj.mem.dao.MemberDAOImpl;
import a.b.c.com.ksj.mem.vo.MemberVO;

public class MemberServiceImpl implements MemberService {

	@Override
	public ArrayList<MemberVO> memberSelectAll() {
		System.out.println("������� ����Ʈ�� ���� ");
		MemberDAO mdo = new MemberDAOImpl();
		return mdo.memberSelectAll();
	}

	@Override
	public ArrayList<MemberVO> memberSelect(MemberVO mvo) {
		System.out.println("������� ����Ʈ ���� ");
		MemberDAO mdo = new MemberDAOImpl();
		return mdo.memberSelect(mvo);
	}

	@Override
	public boolean memberInsert(MemberVO mvo) {
		System.out.println("��� ���� �μ�Ʈ ����  ");
	MemberDAO mdo = new MemberDAOImpl();
	boolean bool = mdo.memberInsert(mvo);
		return bool;
	}

	@Override
	public boolean memberUpdate(MemberVO mvo) {
		System.out.println("��� ���� ������Ʈ ����  ");
	MemberDAO mdo = new MemberDAOImpl();
	boolean bool = mdo.memberUpdate(mvo);
	System.out.println(bool);
		return bool;
	}

	@Override
	public boolean memberDelete(MemberVO mvo) {
		System.out.println("��� ���� ����Ʈ ����  ");
	MemberDAO mdo = new MemberDAOImpl();
	boolean bool = mdo.memberDelete(mvo);
	System.out.println(bool);
		return bool;
	}

}
