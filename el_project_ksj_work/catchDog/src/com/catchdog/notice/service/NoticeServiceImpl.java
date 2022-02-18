package com.catchdog.notice.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.catchdog.notice.dao.NoticeDAO;
import com.catchdog.notice.vo.NoticeVO;

@Service
@Transactional
public class NoticeServiceImpl implements NoticeService {
	Logger logger = Logger.getLogger(NoticeServiceImpl.class);
	private NoticeDAO noticeDAO;
	
	@Autowired(required=false)
	public NoticeServiceImpl(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}
	

	@Override
	public List<NoticeVO> noticeSelect(NoticeVO nvo) {
		// TODO Auto-generated method stub
		logger.info("NoticeServiceImpl.noticeSelect() >>>");
		return noticeDAO.noticeSelect(nvo);
	}
	
	@Override
	public int noticeInsert(NoticeVO nvo) {
		// TODO Auto-generated method stub
		logger.info("NoticeServiceImpl.noticeInsert() >>>");
		return noticeDAO.noticeInsert(nvo);
	}

	@Override
	public int noticeUpdate(NoticeVO nvo) {
		// TODO Auto-generated method stub
		logger.info("NoticeServiceImpl.noticeUpdate() >>>");
		return noticeDAO.noticeUpdate(nvo);
	}

	@Override
	public int noticeDelete(NoticeVO nvo) {
		// TODO Auto-generated method stub
		logger.info("NoticeServiceImpl.noticeDelete()>>>");
		return noticeDAO.noticeDelete(nvo);
	}

	@Override
	public List<NoticeVO> noticeSelectAll(NoticeVO nvo) {
		// TODO Auto-generated method stub
		logger.info("NoticeServiceImpl.noticeSelectAll()>>>");
		return noticeDAO.noticeSelectAll(nvo);
	}

	//페이징
	@Override
	public List<NoticeVO> noticeSelectPaging(NoticeVO nvo) {
		// TODO Auto-generated method stub
		return noticeDAO.noticeSelectPaging(nvo);
	}

}
