package a.b.c.com.mem.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.mem.vo.SpringMemberVO;


@Repository
public class SpringMemberDAOImpl implements SpringMemberDAO {
	Logger logger = Logger.getLogger(SpringMemberDAOImpl.class);
	
	@Autowired(required=false)
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<SpringMemberVO> memberSelectAll(SpringMemberVO mvo) {
		logger.info("다오 셀렉트올 함수 진입 ");
		return sqlSession.selectList("memberSelectAll", mvo);
	}

	@Override
	public List<SpringMemberVO> memberSelect(SpringMemberVO mvo) {
		logger.info("다오 셀렉트함수 진입 ");
		return sqlSession.selectList("memberSelect", mvo);
	}

	@Override
	public int memberInsert(SpringMemberVO mvo) {
		logger.info("다오 인서트함수 진입 ");
		return (Integer)sqlSession.insert("memberInsert", mvo);
	}

	@Override
	public int memberUpdate(SpringMemberVO mvo) {
		logger.info("다오 업데이트 함수 진입 ");
		return (Integer)sqlSession.update("memberUpdate", mvo);
	}

	@Override
	public int memberDelete(SpringMemberVO mvo) {
		// TODO Auto-generated method stub
		return (Integer)sqlSession.delete("memberDelete", mvo);
	}

	@Override
	public List<SpringMemberVO> memberIdCheck(SpringMemberVO mvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("memberIdCheck", mvo);
	}

}
