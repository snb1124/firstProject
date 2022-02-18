package com.catchdog.goods.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.catchdog.goods.dao.GoodsDAO;
import com.catchdog.goods.vo.GoodsVO;

@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {
	Logger logger = Logger.getLogger(GoodsServiceImpl.class);

	@Autowired(required=false)
	private GoodsDAO goodsDAO;
	
	
	
	@Override
	public List<GoodsVO> goodsSelect(GoodsVO gvo) {
		logger.info("서비스 셀렉트 진입");
		return goodsDAO.goodsSelect(gvo);
	}

	@Override
	public List<GoodsVO> goodsSelectAll(GoodsVO gvo) {
		logger.info("서비스 셀렉트올 진입");
		return goodsDAO.goodsSelectAll(gvo);
	}

	@Override
	public int goodsInsert(GoodsVO gvo) {
		logger.info("서비스 인서트 진입");
		return goodsDAO.goodsInsert(gvo);
	}

	@Override
	public int goodsUpdate(GoodsVO gvo) {
		// TODO Auto-generated method stub
		return goodsDAO.goodsUpdate(gvo);
	}

	@Override
	public int goodsDelete(GoodsVO gvo) {
		logger.info("서비스 딜리트 진입");
		return goodsDAO.goodsDelete(gvo);
	}

	@Override
	public List<GoodsVO> goodsSelectAllpaging(GoodsVO gvo) {
		// TODO Auto-generated method stub
		return goodsDAO.goodsSelectAllpaging(gvo);
	}

	@Override
	public int goodsPay(GoodsVO gvo) {
		// TODO Auto-generated method stub
		return goodsDAO.goodsPay(gvo);
	}

}
