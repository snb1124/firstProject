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
	
	//�ΰ� ��üȭ�ϱ�? �����ڵ���..?
	private Logger logger = Logger.getLogger(SpringAutowiredController.class);
	
	//SpringAutowiredService springAutowiredService = new SpringwiredServiceImpl();
	final private SpringAutowiredService springAutowiredSerivce;
	
	//������ ����
	@Autowired(required=false)
	public SpringAutowiredController(SpringAutowiredService springAutowiredSerivce) {
		this.springAutowiredSerivce = springAutowiredSerivce;
	}
	//������̼����� �����ϱ�? �ٹ��
	@RequestMapping(value="autowired_test", method=RequestMethod.GET)
	public String autowired_test() {
		logger.info("autowired_test�Լ� ����");
		
		return "autowired/autowired_test_return";
	}
	//������̼����� �����ϱ� �ٹ��
	@RequestMapping(value="autowired_test_get", method=RequestMethod.GET)
	public String autowiredTest_Get(FormDataVO fvo, Model model) {
		
		//����ƮŬ���� ����ؼ� ���񽺿��� �޾ƿ� voŬ���� ����Ʈ�� ���
		List<FormDataVO> list = springAutowiredSerivce.autowiredTest(fvo);
		//����Ʈ ������ ũ�� �ʱ�ȭ
		int listSize=list.size();
		
		//�α����?
		logger.info("listsize->"+listSize);
		System.out.println("listsize->"+listSize);
		
		//�� ��ü�� key and value�� �ʱ�ȭ�ϱ�?
		model.addAttribute("list", list);
		
		//������ �ѱ� ���� ��Ʈ��Ÿ������ �����ϱ� 
		return "autowired/autowired_test_get_return";
		
	}
	
	
	
}
