package com.spring.lesson.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.lesson.vo.LessonVO;

public class LessonMapperImpl implements LessonMapper {

	
	@Autowired(required=false)
	private SqlSession sqlSession;
	
	
	@Override
	public List<LessonVO> listLesson(LessonVO param) {
		
		return sqlSession.selectList("listLesson", param);
	}

	@Override
	public LessonVO selectLesson(int no) {
		// TODO Auto-generated method stub
		return  (LessonVO)sqlSession.selectList("selectLesson", no);
	}

	@Override
	public int insertLesson(LessonVO param) {
		// TODO Auto-generated method stub
		return (Integer)sqlSession.insert("insertLesson", param);

	}

	@Override
	public int updateLesson(LessonVO param) {
		// TODO Auto-generated method stub
		 return (Integer)sqlSession.update("updateLesson", param);
	}

	@Override
	public int deleteLesson(int no) {
		// TODO Auto-generated method stub
		return (Integer)sqlSession.delete("deleteLesson", no);
	}

}
