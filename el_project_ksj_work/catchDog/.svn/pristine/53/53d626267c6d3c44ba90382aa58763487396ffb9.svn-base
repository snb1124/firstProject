package com.catchdog.mainpage.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.catchdog.mainpage.vo.MainPageVO;

@Repository
public class MainPageDAOImpl implements MainPageDAO {
	
	@Autowired(required=false)
	private SqlSession sqlSession;

	@Override
	public List<MainPageVO> selectAdoption(MainPageVO mvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("selectAdoption", mvo);
	}

	@Override
	public List<MainPageVO> selectDisappearance(MainPageVO mvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("selectDisappearance", mvo);
	}

	@Override
	public List<MainPageVO> selectGoods(MainPageVO mvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("selectGoods", mvo);
	}

}
