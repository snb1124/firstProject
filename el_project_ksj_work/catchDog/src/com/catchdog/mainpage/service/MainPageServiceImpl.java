package com.catchdog.mainpage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.catchdog.mainpage.dao.MainPageDAO;
import com.catchdog.mainpage.vo.MainPageVO;

@Service
@Transactional
public class MainPageServiceImpl implements MainPageService {
	
	private MainPageDAO mainPageDAO;
	
	@Autowired(required=false)
	public MainPageServiceImpl(MainPageDAO mainPageDAO) {
		this.mainPageDAO = mainPageDAO;
	}

	@Override
	public List<MainPageVO> selectAdoption(MainPageVO mvo) {
		// TODO Auto-generated method stub
		return mainPageDAO.selectAdoption(mvo);
	}

	@Override
	public List<MainPageVO> selectDisappearance(MainPageVO mvo) {
		// TODO Auto-generated method stub
		return mainPageDAO.selectDisappearance(mvo);
	}

	@Override
	public List<MainPageVO> selectGoods(MainPageVO mvo) {
		// TODO Auto-generated method stub
		return mainPageDAO.selectGoods(mvo);
	}

}
