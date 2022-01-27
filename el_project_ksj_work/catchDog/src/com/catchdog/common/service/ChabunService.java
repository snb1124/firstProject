package com.catchdog.common.service;

import com.catchdog.disadoption.vo.DisadoptionVO;
import com.catchdog.disappearance.vo.DisappearanceVO;
import com.catchdog.goods.vo.GoodsVO;
import com.catchdog.member.vo.MemberVO;
import com.catchdog.notice.vo.NoticeVO;
import com.catchdog.review.vo.ReviewVO;

public interface ChabunService {
	//VO 클래스에서 임포트후 겟 채번 함수 만들기 
		// ex) public CatchDogNoticeVO getNoticeChabun();
		
	public GoodsVO getGoodsChabun();
	public GoodsVO getGpdChabun();
	public MemberVO getMemChabun();
	public ReviewVO getReviewChabun();
	public NoticeVO getNoticeChabun();
	public DisadoptionVO getDisadoptionChabun();
	public DisappearanceVO getDisappearanceChabun();
}
