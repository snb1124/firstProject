package com.catchdog.login.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.catchdog.login.vo.TempPwVO;
import com.catchdog.member.vo.MemberVO;

@Repository
public class LoginDAOImpl implements LoginDAO{
	Logger logger = Logger.getLogger(LoginDAOImpl.class);

	@Autowired(required=false)
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<MemberVO> loginCheck(MemberVO mvo){
		return sqlSession.selectList("loginCheck", mvo);
	}
	
	@Override
	public List<MemberVO> FindId(MemberVO mvo){
		return sqlSession.selectList("FindId", mvo);
	}
	
	@Override
	public List<MemberVO> IdCheck(MemberVO mvo){
		return sqlSession.selectList("IdCheck", mvo);
	}
	
	@Override
	public int tempPwInsert(TempPwVO tvo) {
		return (Integer)sqlSession.insert("tempPwInsert", tvo);
	}
	
	@Override
	public int updatePw(TempPwVO tvo) {
		return sqlSession.update("updatePw", tvo);
	}
}
