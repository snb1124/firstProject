package com.catchdog.recommend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.catchdog.recommend.dao.RecommendDAO;
import com.catchdog.recommend.vo.RecommendVO;

@Service
@Transactional
public class RecommendServiceImpl implements RecommendService {

	private RecommendDAO recommendDAO;
	
	@Autowired(required=false)
	public RecommendServiceImpl(RecommendDAO recommendDAO) {
		this.recommendDAO = recommendDAO;
	}
	
	@Override
	public List<RecommendVO> recommendSelect(RecommendVO rvo){
		return recommendDAO.recommendSelect(rvo);
	}
	
	@Override
	public int recommendInsert(RecommendVO rvo) {
		return recommendDAO.recommendInsert(rvo);
	}
	
	@Override
	public int recommendUpdate(RecommendVO rvo) {
		return recommendDAO.recommendUpdate(rvo);
	}
	
	@Override
	public int recommendDelete(RecommendVO rvo) {
		return recommendDAO.recommendDelete(rvo);
	}
}
