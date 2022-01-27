package a.b.c.com.mem.service;

import java.util.List;

import a.b.c.com.mem.vo.SpringMemberVO;

public interface SpringMemberService {
	public List<SpringMemberVO> memberSelectAll(SpringMemberVO mvo);
	public List<SpringMemberVO> memberSelect(SpringMemberVO mvo);
	public int memberInsert(SpringMemberVO mvo);
	public int memberUpdate(SpringMemberVO mvo);
	public int memberDelete(SpringMemberVO mvo);
	public List<SpringMemberVO> memberIdCheck(SpringMemberVO mvo);
}
