package com.catchdog.notice.dao;

import java.util.List;

import com.catchdog.notice.vo.NoticeVO;

public interface NoticeDAO {

	public List<NoticeVO>noticeSelectAll(NoticeVO nvo);
	public List<NoticeVO>noticeSelect(NoticeVO nvo);
	public int noticeInsert(NoticeVO nvo);
	public int noticeUpdate(NoticeVO nvo);
	public int noticeDelete(NoticeVO nvo);
	
	//페이징 
	public List<NoticeVO>noticeSelectPaging(NoticeVO nvo);
}
