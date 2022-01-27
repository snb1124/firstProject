package a.b.c.com.mem.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.mem.dao.SpringMemberDAO;
import a.b.c.com.mem.vo.SpringMemberVO;

@Transactional
@Service
public class SpringMemberServiceImpl implements SpringMemberService {
	Logger logger = Logger.getLogger(SpringMemberServiceImpl.class);
	
	@Autowired(required=false)
	private SpringMemberDAO springMemberDAO; 
	
	
	@Override
	public List<SpringMemberVO> memberSelectAll(SpringMemberVO mvo) {
		logger.info("서비스 셀렉트올 진입");
		return springMemberDAO.memberSelectAll(mvo);
	}

	@Override
	public List<SpringMemberVO> memberSelect(SpringMemberVO mvo) {
		logger.info("서비스 셀렉트 진입");
		return springMemberDAO.memberSelect(mvo);
	}

	@Override
	public int memberInsert(SpringMemberVO mvo) {
		logger.info("서비스 인서트 진입");
		return springMemberDAO.memberInsert(mvo);
	}

	@Override
	public int memberUpdate(SpringMemberVO mvo) {
		logger.info("서비스 업데이트 진입");
		return springMemberDAO.memberUpdate(mvo);
	}

	@Override
	public int memberDelete(SpringMemberVO mvo) {
		logger.info("서비스 딜리트 진입");
		return springMemberDAO.memberDelete(mvo);
	}

	@Override
	public List<SpringMemberVO> memberIdCheck(SpringMemberVO mvo) {
		logger.info("서비스 아이디체크 진입");
		return springMemberDAO.memberIdCheck(mvo);
	}

}
