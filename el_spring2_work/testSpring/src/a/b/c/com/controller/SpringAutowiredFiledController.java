package a.b.c.com.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import a.b.c.com.service.SpringAutowiredFieldService;
import a.b.c.com.vo.FormDataVO;


@Controller
public class SpringAutowiredFiledController {
	private Logger logger = Logger.getLogger(SpringAutowiredFiledController.class);
	
	@Autowired
	private SpringAutowiredFieldService springAutowiredFieldService;
	
	@RequestMapping(value="autowired_testfiled", method=RequestMethod.GET)
	public String autowired_test() {
		logger.info("public class SpringAutowiredFiledController.autowired_test¡¯¿‘");
		return "autowired/autowired_test_filed_return";
	}
	
	
	@RequestMapping(value="autowired_test_get_file", method=RequestMethod.GET)
	public String autowiredTest_Get(FormDataVO fvo, Model model) {
		List<FormDataVO> list = springAutowiredFieldService.autowired_test(fvo);
		int listSize = list.size();
		
		logger.info("listSize->"+listSize);
		model.addAttribute("list",list);
		return "autowired/autowired_test_get_filed_return";
		
	}
	
	

}
