package com.spring.dept.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dept.service.DeptService;
import com.spring.dept.vo.DeptVO;

@Controller
public class DepartmentController {
	private Logger logger = Logger.getLogger(DepartmentController.class);
	private static final String CONTEXT_PATH ="dept";
	
	@Autowired
	private DeptService deptService;
	
	//전체조회 
	@RequestMapping(value="listDepartment")
		public ModelAndView listDepartment(@ModelAttribute DeptVO param) {
		logger.info("DepartmentController listDepartment >>>> ");
		List<DeptVO>list=deptService.listDepartment(param);
		
		ModelAndView mav= new ModelAndView();
		mav.addObject("departmentList", list);
		mav.setViewName(CONTEXT_PATH+"/department");
		
		return mav;
	}
	//상세정보보기
	@RequestMapping("selectDepartment")
	public ModelAndView selectDepartment(@RequestParam("deptid")String deptid) {
		logger.info("selectDepartment함수 진입");
		
		ModelAndView mav = new ModelAndView();
		
		if(deptid.equals("")) {
		mav.addObject("mode","insert");
	}else {
		mav.addObject("DeptVO",deptService.selectDepartment(deptid));
		mav.addObject("mode", "update");
	}
		mav.setViewName(CONTEXT_PATH+"/department_pop");
		return mav;
	}

	//insert
	@RequestMapping("insertDepartment")
	public ModelAndView insertDepartment(@ModelAttribute DeptVO param) {
		logger.info("컨트롤 인서트 진입");
		
		String resultStr ="";
		
		int result= deptService.insertDepartment(param);
		
		if(result > 0) resultStr="등록이 완료되었습니다. ";
		else resultStr= "문제가 발생되어 등록을 완료하지 못했습니다. ";
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", resultStr);
		mav.setViewName(CONTEXT_PATH+"/result");
		
		return mav;
	}
	
	//update
	@RequestMapping("updateDepartment")
	public ModelAndView updateDepartment(@ModelAttribute DeptVO param) {
		logger.info("컨트롤 업데이트 진입");
		
		String resultStr="";
		logger.info("1");
		//요기서 문제 발생. 
		int result= deptService.updateDepartment(param);
		logger.info("result->>>>"+result);
		if(result > 0) resultStr="수정이 완료되었습니다. ";
		else resultStr= "문제가 발생되어 수정을 완료하지 못했습니다. ";
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("result", resultStr);
		mav.setViewName(CONTEXT_PATH+"/result");
		return mav;
	}
	//delete
	@RequestMapping("deleteDepartment")
	public ModelAndView deleteDepartment(@ModelAttribute DeptVO param) {
		logger.info("컨트롤 딜리트 진입");
		
		String resultStr="";
		
		int result= deptService.deleteDepartment(param);
		
		if(result > 0) resultStr="삭제가 완료되었습니다. ";
		else resultStr= "문제가 발생되어 삭제를 완료하지 못했습니다. ";
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("result", resultStr);
		mav.setViewName(CONTEXT_PATH+"/result");
		return mav;

	}
	
	
}
