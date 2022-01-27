package com.catchdog.login.dao;

import java.util.List;

import com.catchdog.login.vo.TempPwVO;
import com.catchdog.member.vo.MemberVO;

public interface LoginDAO {
	
	public List<MemberVO> loginCheck(MemberVO mvo);
	
	// ID 찾기
	public List<MemberVO> FindId(MemberVO mvo);
	
	// PW 찾기
	// 아이디 체크
	public List<MemberVO> IdCheck(MemberVO mvo);
	// 임시 비밀번호 입력 :TEMP_PW 테이블
	public int tempPwInsert(TempPwVO tvo);
	// 임시 비밀번호로 업데이트
	public int updatePw(TempPwVO tvo);
}
