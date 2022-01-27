package com.catchdog.member.dao;

import java.util.List;

import com.catchdog.member.vo.MemberVO;

public interface MemberDAO {

	public List<MemberVO> memberSelectAll(MemberVO mvo);
	public List<MemberVO> memberSelect(MemberVO mvo);
	public int memberInsert(MemberVO mvo);
	public int memberUpdate(MemberVO mvo);
	public int memberDelete(MemberVO mvo);
	
	//아이디 중복체크
	public List<MemberVO> memberIdCheck(MemberVO mvo);
	
	// 소셜 로그인 체크
	public List<MemberVO> socialCheck(MemberVO mvo);
}
