package a.b.c.com.common.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.board.vo.SpringBoardVO;
import a.b.c.com.common.dao.ChabunDAO;
import a.b.c.com.mem.vo.SpringMemberVO;
import a.b.c.com.rboard.vo.SpringRboardVO;

@Service
@Transactional
public class ChabunServiceImpl implements ChabunService {
	private Logger logger = Logger.getLogger(ChabunServiceImpl.class);
	
	private ChabunDAO chabunDAO;
	
	@Autowired(required=false)
	public ChabunServiceImpl(ChabunDAO chabunDAO) {
		this.chabunDAO = chabunDAO;
	}

	@Override
	public SpringBoardVO getBoardChabun() {
		logger.info("보드 채번 서비스 함수");
		return chabunDAO.getBoardChabun();
	}

	@Override
	public SpringRboardVO getRboardChabun() {
		logger.info("댓글 채번 서비스 함수");
		return chabunDAO.getRboardChabun();
	}

	@Override
	public SpringMemberVO getMemberChabun() {
		logger.info("멤버 채번 서비스 함수");
		return chabunDAO.getMemberChabun();
	}

} 
