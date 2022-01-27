package com.catchdog.goods.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.catchdog.goods.vo.GoodsVO;

@Repository
public class GoodsDAOImpl implements GoodsDAO {
	Logger logger = Logger.getLogger(GoodsDAOImpl.class);
	
	@Autowired(required=false)
	private SqlSessionTemplate sqlSession;
	
	
	@Override
	public List<GoodsVO> goodsSelect(GoodsVO gvo) {
		logger.info("다오 셀렉트 진입");
		return sqlSession.selectList("goodsSelect", gvo);
	}

	@Override
	public List<GoodsVO> goodsSelectAll(GoodsVO gvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("goodsSelectAll", gvo);
	}

	@Override
	public int goodsInsert(GoodsVO gvo) {
		// TODO Auto-generated method stub
		return (Integer)sqlSession.insert("goodsInsert", gvo);
	}

	@Override
	public int goodsUpdate(GoodsVO gvo) {
		// TODO Auto-generated method stub
		return (Integer)sqlSession.update("goodsUpdate", gvo);
	}

	@Override
	public int goodsDelete(GoodsVO gvo) {
		// TODO Auto-generated method stub
		return (Integer)sqlSession.delete("goodsDelete", gvo);
	}

	@Override
	public List<GoodsVO> goodsSelectAllpaging(GoodsVO gvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("goodsSelectAllpaging", gvo);
	}

	@Override
	public int goodsPay(GoodsVO gvo) {
		// TODO Auto-generated method stub
		return (Integer)sqlSession.update("goodsPay", gvo);
	}

}
