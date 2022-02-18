package com.catchdog.review.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.catchdog.review.dao.ReviewDAO;
import com.catchdog.review.vo.ReviewVO;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {
	Logger logger = Logger.getLogger(ReviewServiceImpl.class);
	
	private ReviewDAO reviewDAO;
	
	@Autowired(required=false)
	public ReviewServiceImpl(ReviewDAO reviewDAO) {
		this.reviewDAO = reviewDAO;
	}
	
	@Override
	public List<ReviewVO> reviewSelectAll(ReviewVO rvo) {
		// TODO Auto-generated method stub
		logger.info("ReviewServiceImpl reviewSelectAll() 함수 진입 >>> : ");
		return reviewDAO.reviewSelectAll(rvo);
	}

	@Override
	public List<ReviewVO> reviewSelect(ReviewVO rvo) {
		// TODO Auto-generated method stub
		logger.info("ReviewServiceImpl reviewSelect() 함수 진입 >>> : ");
		return reviewDAO.reviewSelect(rvo);
	}

	@Override
	public int reviewInsert(ReviewVO rvo) {
		// TODO Auto-generated method stub
		logger.info("ReviewServiceImpl reviewInsert() 함수 진입 >>> : ");
		return reviewDAO.reviewInsert(rvo);
	}

	@Override
	public int reviewUpdate(ReviewVO rvo) {
		// TODO Auto-generated method stub
		logger.info("ReviewServiceImpl reviewUpdate() 함수 진입 >>> : ");
		return reviewDAO.reviewUpdate(rvo);
	}

	@Override
	public int reviewDelete(ReviewVO rvo) {
		// TODO Auto-generated method stub
		logger.info("ReviewServiceImpl reviewDelete() 함수 진입 >>> : ");
		return reviewDAO.reviewDelete(rvo);
	}

}
