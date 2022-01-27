package a.b.c.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorldController {

		//핸들러 맵핑을 통해 요청받은 것을 매핑한 컨트롤러가 있는지 검색 후 있으면 컨트롤로 넘어왔다. 
		// viewresolver를 통해 해당 객체를 view로 넘기고 views는 디스패쳐 서블릿으로 이동하고 클라이언트로 이동 
	@RequestMapping("helloWorld_Controller_find")
	public String helloWorld(Model model) {
		
		System.out.println("modle->" + model);
		model.addAttribute("message", "Hello World Spring!!!! again >>>> : ");
		System.out.println("modle2->" + model);
		return "helloWorld_return_jspfile_name";
	}
	
	@RequestMapping(value="helloWorld_get", method=RequestMethod.GET)
		public String helloWorld_get(Model model) {
		System.out.println("helloWorld_get 함수 진입");
		System.out.println("RequestMethod.GET"+ RequestMethod.GET);
		System.out.println("model-->"+ model);
		model.addAttribute("get_msg", "requestmethod get방식");
		System.out.println("model2-->"+ model);
		return "helloWorld_get";
	}
	
	@RequestMapping(value="helloWorld_post", method=RequestMethod.POST)
	public String helloWorld_oist(Model model) {
	System.out.println("helloWorld_oist 함수 진입");
	model.addAttribute("post_msg", "requestmethod post방식");
	
	return "helloWorld_post";
}
	






}//END OF  CLASS
