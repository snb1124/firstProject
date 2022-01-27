package a.b.c.com.rboard.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.board.dao.SpringBoardDAO;
import a.b.c.com.rboard.dao.SpringRboardDAO;
import a.b.c.com.rboard.vo.SpringRboardVO;

@Service
@Transactional
public class SpringRboardServiceImpl implements SpringRboardService {
	Logger logger = Logger.getLogger(SpringRboardServiceImpl.class);
	
	
	@Autowired(required=false)
	private SpringRboardDAO springRboardDAO;
	
	
	@Override
	public List<SpringRboardVO> rboardSelect(SpringRboardVO rbvo) {
		logger.info("서비스 셀렉트 진입");
		return springRboardDAO.rboardSelect(rbvo);
	}

	@Override
	public List<SpringRboardVO> rboardSelectAll(SpringRboardVO rbvo) {
		logger.info("서비스 셀렉트올 진입");
		return springRboardDAO.rboardSelectAll(rbvo);
	}

	@Override
	public int rboardInsert(SpringRboardVO rbvo) {
		logger.info("서비스 셀렉트인서트 진입");
		return springRboardDAO.rboardInsert(rbvo);
	}

	@Override
	public int rboardDelete(SpringRboardVO rbvo) {
		logger.info("서비스 딜리트 진입");
		return springRboardDAO.rboardDelete(rbvo);
	}

}
