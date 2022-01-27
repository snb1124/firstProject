package com.spring.lesson.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.lesson.dao.LessonMapper;
import com.spring.lesson.vo.LessonVO;

@Service
@Transactional
public class LessonServiceImpl implements LessonService {
	private Logger logger = Logger.getLogger(LessonServiceImpl.class);
	
	@Autowired(required=false)
	private LessonMapper lessonMapper;
	
	@Override
	public List<LessonVO> listLesson(LessonVO param) {
		logger.info("서비스 listLesson함수 진입 param->>>>>>>"+param);
		List<LessonVO> list = new ArrayList<LessonVO>();
		list= lessonMapper.listLesson(param);
		return list;
	}

	@Override
	public LessonVO selectLesson(int no) {
		logger.info("서비스 selectLesson함수 진입");
	return lessonMapper.selectLesson(no);
	}

	@Override
	public int insertLesson(LessonVO param) {
		logger.info("서비스 insertLesson함수 진입");
		return lessonMapper.insertLesson(param);
	}

	@Override
	public int updateLesson(LessonVO param) {
		logger.info("서비스 updateLesson함수 진입");
		return lessonMapper.updateLesson(param);
	}

	@Override
	public int deleteLesson(int no) {
		logger.info("서비스 deleteLesson함수 진입");
		return lessonMapper.deleteLesson(no);

	}

}
