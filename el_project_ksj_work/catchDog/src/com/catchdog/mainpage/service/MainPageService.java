package com.catchdog.mainpage.service;

import java.util.List;

import com.catchdog.mainpage.vo.MainPageVO;

public interface MainPageService {
	public List<MainPageVO> selectAdoption(MainPageVO mvo);
	public List<MainPageVO> selectDisappearance(MainPageVO mvo);
	public List<MainPageVO> selectGoods(MainPageVO mvo);
}
