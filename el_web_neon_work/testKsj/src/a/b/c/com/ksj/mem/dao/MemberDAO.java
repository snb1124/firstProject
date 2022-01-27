package a.b.c.com.ksj.mem.dao;
import java.util.ArrayList;
import a.b.c.com.ksj.mem.vo.MemberVO;

public interface MemberDAO {
	public ArrayList<MemberVO> memberSelectAll();
	public ArrayList<MemberVO> memberSelect(MemberVO mvo);
	public boolean memberInsert(MemberVO mvo);
	public boolean memberUpdate(MemberVO mvo);
	public boolean memberDelete(MemberVO mvo);
	
}
