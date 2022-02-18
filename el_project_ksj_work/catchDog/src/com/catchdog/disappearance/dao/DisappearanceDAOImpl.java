package com.catchdog.disappearance.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.catchdog.disappearance.vo.DisappearanceVO;

@Repository
public class DisappearanceDAOImpl implements DisappearanceDAO {
	
	Logger logger = Logger.getLogger(DisappearanceDAOImpl.class);
	
	@Autowired(required=false)
	private SqlSessionTemplate sqlSession;
	
	

	@Override
	public List<DisappearanceVO> disappearanceselectAll(DisappearanceVO dsvo) {
		// TODO Auto-generated method stub
		logger.info("DisappearanceDAOImpl.disappearanceselectAll()함수  진입");
		return sqlSession.selectList("disappearanceselectAll", dsvo);
	}

	@Override
	public List<DisappearanceVO> disappearanceselect(DisappearanceVO dsvo) {
		// TODO Auto-generated method stub
		logger.info("DisappearanceDAOImpl.disappearanceselect()함수  진입");
		return sqlSession.selectList("disappearanceselect", dsvo);
	}

	@Override
	public int disappearanceInsert(DisappearanceVO dsvo) {
		// TODO Auto-generated method stub
		logger.info("DisappearanceDAOImpl.disappearanceInsert()함수  진입");
		return sqlSession.insert("disappearanceInsert", dsvo);
	}
//
//	@Override
//	public int disappearanceUpdate(DisappearanceVO dsvo) {
//		// TODO Auto-generated method stub
//		logger.info("DisappearanceDAOImpl.disappearanceUpdate()함수  진입");
//		return sqlSession.update("disappearanceUpdate", dsvo);
//	}
//
//	@Override
//	public int disappearanceDelete(DisappearanceVO dsvo) {
//		// TODO Auto-generated method stub
//		logger.info("DisappearanceDAOImpl.disappearanceDelete()함수  진입");
//		return sqlSession.update("disappearanceDelete", dsvo);
//	}

}
