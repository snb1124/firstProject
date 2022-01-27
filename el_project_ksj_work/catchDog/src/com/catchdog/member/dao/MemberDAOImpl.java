package com.catchdog.member.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.catchdog.member.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{

	Logger logger = Logger.getLogger(MemberDAOImpl.class);
	
	@Autowired(required=false)
	private SqlSessionTemplate sqlSession;

	@Override
	public List<MemberVO> memberSelectAll(MemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("MemberDAOImpl memberSelectAll() 함수 진입 >>> : ");
		
		return sqlSession.selectList("memberSelectAll", mvo);
	}

	@Override
	public List<MemberVO> memberSelect(MemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("MemberDAOImpl memberSelect() 함수 진입 >>> : ");
		
		return sqlSession.selectList("memberSelect", mvo);
	}

	@Override
	public int memberInsert(MemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("MemberDAOImpl memberInsert() 함수 진입 >>> : ");
		
		return (Integer)sqlSession.insert("memberInsert", mvo);
	}

	@Override
	public int memberUpdate(MemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("MemberDAOImpl memberUpdate() 함수 진입 >>> : ");
		
		return (Integer)sqlSession.update("memberUpdate", mvo);
	}

	@Override
	public int memberDelete(MemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("MemberDAOImpl memberDelete() 함수 진입 >>> : ");
		
		return (Integer)sqlSession.delete("memberDelete", mvo);
	}

	@Override
	public List<MemberVO> memberIdCheck(MemberVO mvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("memberIdCheck", mvo);
	}
	
	@Override
	public List<MemberVO> socialCheck(MemberVO mvo){
		return sqlSession.selectList("socialCheck", mvo);
	}
	
}
