package com.catchdog.goods.service;

import java.util.List;

import com.catchdog.goods.vo.GoodsVO;

public interface GoodsService {

	public List<GoodsVO> goodsSelect(GoodsVO gvo);
	public int goodsPay(GoodsVO gvo);
	public List<GoodsVO> goodsSelectAll(GoodsVO gvo);
	public int goodsInsert(GoodsVO gvo);
	public int goodsUpdate(GoodsVO gvo);
	public int goodsDelete(GoodsVO gvo);
	public List<GoodsVO> goodsSelectAllpaging(GoodsVO gvo);
}
