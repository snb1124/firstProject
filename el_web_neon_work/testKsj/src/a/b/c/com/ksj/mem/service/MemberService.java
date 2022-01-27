package a.b.c.com.ksj.mem.service;

import java.util.ArrayList;

import a.b.c.com.ksj.mem.vo.MemberVO;

public interface MemberService {
	public ArrayList<MemberVO> memberSelectAll();
	public ArrayList<MemberVO> memberSelect(MemberVO mvo);
	public boolean memberInsert(MemberVO mvo);
	public boolean memberUpdate(MemberVO mvo);
	public boolean memberDelete(MemberVO mvo);
	
}
