package com.catchdog.notice.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.catchdog.notice.vo.NoticeVO;

@Repository
public class NoticeDAOImpl implements NoticeDAO {

	@Autowired(required=false)
	private SqlSession sqlSession;

	@Override
	public List<NoticeVO> noticeSelect(NoticeVO nvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("noticeSelect",nvo);
	}

	@Override
	public int noticeInsert(NoticeVO nvo) {
		// TODO Auto-generated method stub
		return (Integer)sqlSession.insert("noticeInsert",nvo);
				
	}

	@Override
	public int noticeUpdate(NoticeVO nvo) {
		// TODO Auto-generated method stub
		return (Integer)sqlSession.update("noticeUpdate",nvo);
	}

	@Override
	public int noticeDelete(NoticeVO nvo) {
		// TODO Auto-generated method stub
		return (Integer)sqlSession.update("noticeDelete",nvo);
	}

	@Override
	public List<NoticeVO> noticeSelectAll(NoticeVO nvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("noticeSelectAll",nvo);
	}

	@Override
	public List<NoticeVO> noticeSelectPaging(NoticeVO nvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("noticeSelectPaging",nvo);
	}

}
