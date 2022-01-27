package a.b.c.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import a.b.c.com.vo.DeptVO;

@Controller
public class DepartmentController {
	@RequestMapping(value="department_insertForm", method=RequestMethod.GET)
	public String department_insertForm() {
		return "department_insertForm";
	}
	@RequestMapping(value="department_insert", method=RequestMethod.POST)
	public String department_insert(DeptVO dvo, Model model) {
		model.addAttribute("dvo", dvo);
		return "department_insert";
	}
	
	
	
	
}
