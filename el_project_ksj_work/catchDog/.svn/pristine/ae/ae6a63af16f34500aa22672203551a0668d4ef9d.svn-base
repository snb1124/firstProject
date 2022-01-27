package com.catchdog.login.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.catchdog.login.dao.LoginDAO;
import com.catchdog.login.vo.TempPwVO;
import com.catchdog.member.vo.MemberVO;

@Service
@Transactional
public class LoginServiceImpl implements LoginService{
	Logger logger = Logger.getLogger(LoginServiceImpl.class);
	
	private LoginDAO loginDAO;
	
	@Autowired(required=false)
	public LoginServiceImpl(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}
	
	@Override
	public List<MemberVO> loginCheck(MemberVO mvo){
		return loginDAO.loginCheck(mvo);
	}
	
	@Override
	public List<MemberVO> FindId(MemberVO mvo){
		return loginDAO.FindId(mvo);
	}
	
	@Override
	public List<MemberVO> IdCheck(MemberVO mvo){
		return loginDAO.IdCheck(mvo);
	}
	
	@Override
	public int tempPwInsert(TempPwVO tvo) {
		return loginDAO.tempPwInsert(tvo);
	}
	
	@Override
	public int updatePw(TempPwVO tvo) {
		return loginDAO.updatePw(tvo);
	}
}
