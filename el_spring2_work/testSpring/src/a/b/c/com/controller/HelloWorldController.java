package a.b.c.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorldController {

		//�ڵ鷯 ������ ���� ��û���� ���� ������ ��Ʈ�ѷ��� �ִ��� �˻� �� ������ ��Ʈ�ѷ� �Ѿ�Դ�. 
		// viewresolver�� ���� �ش� ��ü�� view�� �ѱ�� views�� ������ �������� �̵��ϰ� Ŭ���̾�Ʈ�� �̵� 
	@RequestMapping("helloWorld_Controller_find")
	public String helloWorld(Model model) {
		
		System.out.println("modle->" + model);
		model.addAttribute("message", "Hello World Spring!!!! again >>>> : ");
		System.out.println("modle2->" + model);
		return "helloWorld_return_jspfile_name";
	}
	
	@RequestMapping(value="helloWorld_get", method=RequestMethod.GET)
		public String helloWorld_get(Model model) {
		System.out.println("helloWorld_get �Լ� ����");
		System.out.println("RequestMethod.GET"+ RequestMethod.GET);
		System.out.println("model-->"+ model);
		model.addAttribute("get_msg", "requestmethod get���");
		System.out.println("model2-->"+ model);
		return "helloWorld_get";
	}
	
	@RequestMapping(value="helloWorld_post", method=RequestMethod.POST)
	public String helloWorld_oist(Model model) {
	System.out.println("helloWorld_oist �Լ� ����");
	model.addAttribute("post_msg", "requestmethod post���");
	
	return "helloWorld_post";
}
	






}//END OF  CLASS
