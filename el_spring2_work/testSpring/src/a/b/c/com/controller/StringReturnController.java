package a.b.c.com.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class StringReturnController {
	//return형 스트링
	@RequestMapping("viewJsp_1_stringTest_find")
	public String returnStringTest(Model model) {
		System.out.println("StringReturnController.returnStringTest()진입");
		System.out.println("model->"+ model);
		//데디터는 model.addAttribute(key, value)로 보낸다
		model.addAttribute("modeldata", "view에 데이터를 전달할 때는 가능하면 Model 인터페이스를 사용하자");
		System.out.println("model->"+ model);
		//view 페이지는 함수 리턴형을 스트링으로 해서 String return value로 보낸다.
		return "viewJsp_1_stringTest_find_return_file";
	}//returnStringTest
	//리턴형 모델엔뷰
	@RequestMapping("viewJsp_2_modelandview_find")
	public ModelAndView returnModelandView() {
		System.out.println("returnModelandView()진입");
		
		//mav.addObject에 (key, value)로 데이터 전송
		//mav.setViewName(view페이지 이름);
		ModelAndView mav = new ModelAndView();
		System.out.println("mav ->"+ mav);
		mav.addObject("mavdata", "ModelAndView Return data");
		mav.setViewName("viewJsp_2_modelandview_return_file");
		System.out.println("mav2 ->"+ mav);
		return mav;
	}
	@RequestMapping("viewJsp_3_voidTest_find")
	public void voidTest(Model md) {
	md.addAttribute("mmmm", "스프링에서는 void 리턴형도 리턴이 되어서 신기하다. 단 조건이 있다. 요쳥 url 이름과 view 이름이 같아야함. ");
}
	
}//class
