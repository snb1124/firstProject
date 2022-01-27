package a.b.c.com.board.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.board.dao.SpringBoardDAO;
import a.b.c.com.board.vo.SpringBoardVO;

@Service
@Transactional
public class SpringBoardServiceImpl implements SpringBoardService {
	Logger logger = Logger.getLogger(SpringBoardServiceImpl.class);
	
	
	private SpringBoardDAO springBoardDAO;
	
	@Autowired(required=false)
	public SpringBoardServiceImpl(SpringBoardDAO springBoardDAO) {
		this.springBoardDAO = springBoardDAO;
	}
	
	@Override
	public List<SpringBoardVO> boardSelect(SpringBoardVO bvo) {
		logger.info("서비스 boardSelect 함수 진입 ");
				
		return springBoardDAO.boardSelect(bvo);
	}

	@Override
	public List<SpringBoardVO> boardSelectAll(SpringBoardVO bvo) {
		logger.info("서비스 boardSelectAll 함수 진입 ");
		return springBoardDAO.boardSelectAll(bvo);
	}

	@Override
	public int boardInsert(SpringBoardVO bvo) {
		logger.info("서비스 boardInsert 함수 진입 ");
		return springBoardDAO.boardInsert(bvo);
	}

	@Override
	public int boardUpdate(SpringBoardVO bvo) {
		logger.info("서비스 boardUpdate 함수 진입 ");
		return springBoardDAO.boardUpdate(bvo);
	}

	@Override
	public int boardDelete(SpringBoardVO bvo) {
		logger.info("서비스 boardDelete 함수 진입 ");
		return springBoardDAO.boardDelete(bvo);
	}

	@Override
	public List<SpringBoardVO> boardPwCheck(SpringBoardVO bvo) {
		logger.info("서비스 boardPwCheck 함수 진입 ");
		return springBoardDAO.boardPwCheck(bvo);
	}

	@Override
	public List<SpringBoardVO> boardSelectPaging(SpringBoardVO bvo) {
		// TODO Auto-generated method stub
		return springBoardDAO.boardSelectPaging(bvo);
	}

}
