package com.catchdog.disadoption.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.catchdog.disadoption.service.DisadoptionServiceImpl;
import com.catchdog.disadoption.vo.DisadoptionVO;
import com.sun.istack.internal.logging.Logger;
@Repository
public class DisadoptionDAOImpl implements DisadoptionDAO {
	Logger logger = Logger.getLogger(DisadoptionDAOImpl.class);
	
	// 의존성 주입
	@Autowired(required = false)
	private SqlSessionTemplate sqlSession;

	// 파양게시판 전체조회
	@Override
	public List<DisadoptionVO> disadoptionboardSelectAll(DisadoptionVO dvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("disadoptionboardSelectAll",dvo);
	}
	// 파양게시판 선택조회
	@Override
	public List<DisadoptionVO> disadoptionboardSelect(DisadoptionVO dvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("disadoptionboardSelect",dvo);
	}
	// 파양게시판 등록
	@Override
	public int disadoptionboardInsert(DisadoptionVO dvo) {
		// TODO Auto-generated method stub
		return(Integer)sqlSession.insert("disadoptionboardInsert",dvo);
		}
	// 페이징
	@Override
	public List<DisadoptionVO> disadoptionboardSelectPaging(DisadoptionVO dvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("disadoptionboardSelectPaging",dvo);
	}
	
	// 파양게시판 비밀번호 체크
	@Override
	public List<DisadoptionVO> disadoptionPwCheck(DisadoptionVO dvo) {
		logger.info("DisadoptionDAOImpl.disadoptionPwCheck() >>> : ");		
		// TODO Auto-generated method stub
		return sqlSession.selectList("disadoptionPwCheck", dvo);
	}
	@Override
	public int disadoptionboardUpdate(DisadoptionVO dvo) {
		// TODO Auto-generated method stub
		return (Integer)sqlSession.update("disadoptionboardUpdate",dvo);
	}
	@Override
	public int disadoptionboardDelete(DisadoptionVO dvo) {
		// TODO Auto-generated method stub
		return (Integer)sqlSession.delete("disadoptionboardDelete",dvo);
	}

}
