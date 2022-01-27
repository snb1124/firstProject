package a.b.c.com.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import a.b.c.com.service.SpringAutowiredService;
import a.b.c.com.vo.FormDataVO;


@Controller
public class SpringAutowiredController {
	
	//로거 객체화하기? 무슨코드지..?
	private Logger logger = Logger.getLogger(SpringAutowiredController.class);
	
	//SpringAutowiredService springAutowiredService = new SpringwiredServiceImpl();
	final private SpringAutowiredService springAutowiredSerivce;
	
	//생성자 주입
	@Autowired(required=false)
	public SpringAutowiredController(SpringAutowiredService springAutowiredSerivce) {
		this.springAutowiredSerivce = springAutowiredSerivce;
	}
	//어노테이션으로 매핑하기? 겟방식
	@RequestMapping(value="autowired_test", method=RequestMethod.GET)
	public String autowired_test() {
		logger.info("autowired_test함수 진입");
		
		return "autowired/autowired_test_return";
	}
	//어노테이션으로 매핑하기 겟방식
	@RequestMapping(value="autowired_test_get", method=RequestMethod.GET)
	public String autowiredTest_Get(FormDataVO fvo, Model model) {
		
		//리스트클래스 사용해서 서비스에서 받아온 vo클래스 리스트에 담기
		List<FormDataVO> list = springAutowiredSerivce.autowiredTest(fvo);
		//리스트 사이즈 크기 초기화
		int listSize=list.size();
		
		//로그찍기?
		logger.info("listsize->"+listSize);
		System.out.println("listsize->"+listSize);
		
		//모덱 객체에 key and value값 초기화하기?
		model.addAttribute("list", list);
		
		//데이터 넘길 파일 스트링타입으로 리턴하기 
		return "autowired/autowired_test_get_return";
		
	}
	
	
	
}
