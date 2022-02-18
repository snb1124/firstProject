package com.catchdog.disappearance.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.catchdog.disappearance.dao.DisappearanceDAO;
import com.catchdog.disappearance.vo.DisappearanceVO;

@Service
@Transactional
public class DisappearanceServiceImpl implements DisappearanceService {
	Logger logger = Logger.getLogger(DisappearanceServiceImpl.class);
	
	@Autowired(required=false)
	private DisappearanceDAO disappearanceDAO;
	

	
	@Override
	public List<DisappearanceVO> disappearanceselectAll(DisappearanceVO dsvo) {
		// TODO Auto-generated method stub
		logger.info("DisappearanceServiceImpl.disappearanceselectAll() 함수 진입 성공 >>>>>>>> ");
		return disappearanceDAO.disappearanceselectAll(dsvo);
	}

	@Override
	public List<DisappearanceVO> disappearanceselect(DisappearanceVO dsvo) {
		// TODO Auto-generated method stub
		logger.info("DisappearanceServiceImpl.disappearanceselect() 함수 진입 성공 >>>>>>>> ");
		return disappearanceDAO.disappearanceselect(dsvo);
	}

	@Override
	public int disappearanceInsert(DisappearanceVO dsvo) {
		// TODO Auto-generated method stub
		logger.info("DisappearanceServiceImpl.disappearanceInsert() 함수 진입 성공 >>>>>>>> ");
		return disappearanceDAO.disappearanceInsert(dsvo);
	}

//	@Override
//	public int disappearanceUpdate(DisappearanceVO dsvo) {
//		// TODO Auto-generated method stub
//		logger.info("DisappearanceServiceImpl.disappearanceUpdate() 함수 진입 성공 >>>>>>>> ");
//		return disappearanceDAO.disappearanceUpdate(dsvo);
//	}
//
//	@Override
//	public int disappearanceDelete(DisappearanceVO dsvo) {
//		// TODO Auto-generated method stub
//		logger.info("DisappearanceServiceImpl.disappearanceDelete() 함수 진입 성공 >>>>>>>> ");
//		return disappearanceDAO.disappearanceDelete(dsvo);
//	}

}
