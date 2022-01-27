package com.catchdog.review.dao;

import java.util.List;

import com.catchdog.review.vo.ReviewVO;

public interface ReviewDAO {
	
	public List<ReviewVO> reviewSelectAll(ReviewVO rvo);
	public List<ReviewVO> reviewSelect(ReviewVO rvo);
	public int reviewInsert(ReviewVO rvo);
	public int reviewUpdate(ReviewVO rvo);
	public int reviewDelete(ReviewVO rvo);

}
