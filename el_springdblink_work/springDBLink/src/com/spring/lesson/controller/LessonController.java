package com.spring.lesson.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.spring.lesson.service.LessonService;
import com.spring.lesson.vo.LessonVO;

@Controller
@RequestMapping(value="/lesson")

// /WEB-INF/jsp/lesson/
public class LessonController {
	private static final String CONTEXT_PATH="lesson";
	private Logger logger = Logger.getLogger(LessonController.class);
	
	@Autowired(required=false)
	private LessonService lessonService;
	
	//전체조회
	@RequestMapping("/listLesson")
	public ModelAndView listLesson(@ModelAttribute LessonVO param) {
		logger.info("컨트롤 전체조회 함수 진입");
		List<LessonVO>list = lessonService.listLesson(param);
		ModelAndView mav = new ModelAndView();
		mav.addObject("lessonList", list);
		mav.addObject("paraName", param.getLname());
		mav.setViewName(CONTEXT_PATH+"/lesson");
		return mav;
	}
	//상세 정보보기 
	@RequestMapping("/selectLesson")
	public ModelAndView selectLesson(@RequestParam("no")int no) {
		logger.info("컨트롤 상세조회 함수 진입");
		ModelAndView mav= new ModelAndView();
		if(no==0) {
			mav.addObject("mode", "insert");
		}else {
			mav.addObject("lessonVO", lessonService.selectLesson(no));
			mav.addObject("mode","update");
		}
		mav.setViewName(CONTEXT_PATH+"/lesson_pop");
		return mav;
	}
	//insert
	@RequestMapping("/insertLesson")
	public ModelAndView insertLesson(@ModelAttribute LessonVO param) {
		logger.info("컨트롤 인서트 함수 진입");
		String resultStr="";
		int result = lessonService.insertLesson(param);
		
		if(result>0) resultStr="등록 완료";
		else resultStr="문제 발생 등록 미완료";
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("result",resultStr);
		mav.setViewName("/result");
		return mav;
	}
	//update
	@RequestMapping("/updateLesson")
	public ModelAndView updateLesson(@ModelAttribute LessonVO param) {
		logger.info("컨트롤 수정 함수 진입");
		String resultStr="";
		int result = lessonService.updateLesson(param);
		
		if(result>0) resultStr="수정 완료";
		else resultStr="문제 발생 수정 미완료";
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("result",resultStr);
		mav.setViewName("/result");
		return mav;
	}
	//delete
	@RequestMapping("/deleteLesson")
	public ModelAndView deleteLesson(@RequestParam("no")int no) {
		logger.info("컨트롤 삭제 함수 진입");
		String resultStr="";
		int result = lessonService.deleteLesson(no);
		
		if(result>0) resultStr="삭제 완료";
		else resultStr="문제 발생 삭제 미완료";
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("result",resultStr);
		mav.setViewName("/result");
		return mav;
	}
	
	
}
