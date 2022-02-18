package com.catchdog.recommend.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.catchdog.recommend.vo.RecommendVO;

public class RecommendDAOImpl implements RecommendDAO {

	@Autowired(required=false)
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<RecommendVO> recommendSelect(RecommendVO rvo){
		return sqlSession.selectList("recommendSelect", rvo);
	}
	
	@Override
	public int recommendInsert(RecommendVO rvo) {
		return sqlSession.insert("recommendInsert", rvo);
	}
	
	@Override
	public int recommendUpdate(RecommendVO rvo) {
		return sqlSession.update("recommendUpdate", rvo);
	}
	
	@Override
	public int recommendDelete(RecommendVO rvo) {
		return sqlSession.delete("recommendDelete", rvo);
	}
}
