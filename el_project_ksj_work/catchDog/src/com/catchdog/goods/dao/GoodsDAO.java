package com.catchdog.goods.dao;
import java.util.List;

import com.catchdog.goods.vo.GoodsVO;

public interface GoodsDAO {


	
	public List<GoodsVO> goodsSelect(GoodsVO gvo);
	public List<GoodsVO> goodsSelectAll(GoodsVO gvo);
	public int goodsPay(GoodsVO gvo);
	public int goodsInsert(GoodsVO gvo);
	public int goodsUpdate(GoodsVO gvo);
	public int goodsDelete(GoodsVO gvo);
	public List<GoodsVO> goodsSelectAllpaging(GoodsVO gvo);
	
	
	
}
