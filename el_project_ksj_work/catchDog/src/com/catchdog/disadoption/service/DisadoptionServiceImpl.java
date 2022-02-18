package com.catchdog.disadoption.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.catchdog.disadoption.dao.DisadoptionDAO;
import com.catchdog.disadoption.vo.DisadoptionVO;
import com.sun.istack.internal.logging.Logger;

@Service
@Transactional
public class DisadoptionServiceImpl implements DisadoptionService {
	Logger logger = Logger.getLogger(DisadoptionServiceImpl.class);
	
	private  DisadoptionDAO disadoptionDAO;
	
	
	// 의존성 주입
	@Autowired(required = false)
	public DisadoptionServiceImpl(DisadoptionDAO disadoptionDAO) {
		this.disadoptionDAO = disadoptionDAO;
		
	}
	// 파양게시판 전체 조회
	@Override
	public List<DisadoptionVO> disadoptionboardSelectAll(DisadoptionVO dvo) {
		// TODO Auto-generated method stub
		logger.info("DisadoptionServiceImpl disadoptionboardSelectAll()함수 진입 >>> : ");
		
		List<DisadoptionVO> res = disadoptionDAO.disadoptionboardSelectAll(dvo);
		return disadoptionDAO.disadoptionboardSelectAll(dvo);
	}
	// 파양게시판 선택조회
	@Override
	public List<DisadoptionVO> disadoptionboardSelect(DisadoptionVO dvo) {
		// TODO Auto-generated method stub
		logger.info("DisadoptionServiceImpl disadoptionboardSelect()함수 진입 >>> : ");
		return disadoptionDAO.disadoptionboardSelect(dvo);
}
	// 파양게시판 등록
	@Override
	public int disadoptionboardInsert(DisadoptionVO dvo) {
		// TODO Auto-generated method stub
		logger.info("DisadoptionServiceImpl disadoptionboardInsert()함수 진입 >>> : ");
		return disadoptionDAO.disadoptionboardInsert(dvo);
	}
	
	// 페이징
	@Override
	public List<DisadoptionVO> disadoptionboardSelectPaging(DisadoptionVO dvo) {
		// TODO Auto-generated method stub
		logger.info("DisadoptionServiceImpl disadoptionboardSelectPaging()함수 진입 >>> : ");
		return disadoptionDAO.disadoptionboardSelectPaging(dvo);
		
	}
	// 파양게시판 비밀번호 체크
	@Override
	public List<DisadoptionVO> disadoptionPwCheck(DisadoptionVO dvo) {
		// TODO Auto-generated method stub
		logger.info("DisadoptionServiceImpl disadoptionPwCheck()함수 진입 >>> : ");
		return disadoptionDAO.disadoptionPwCheck(dvo);
	}
	// 파양게시판 수정
	@Override
	public int disadoptionboardUpdate(DisadoptionVO dvo) {
		// TODO Auto-generated method stub
		logger.info("DisadoptionServiceImpl disadoptionboardUpdate()함수 진입 >>> : ");
		return disadoptionDAO.disadoptionboardUpdate(dvo);
	}
	//파양게시판 삭제
	@Override
	public int disadoptionboardDelete(DisadoptionVO dvo) {
		// TODO Auto-generated method stub
		logger.info("DisadoptionServiceImpl disadoptionboardDelete()함수 진입 >>> : ");
		return disadoptionDAO.disadoptionboardDelete(dvo);
	}

}
