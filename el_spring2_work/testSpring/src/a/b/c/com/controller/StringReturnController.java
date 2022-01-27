package a.b.c.com.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class StringReturnController {
	//return�� ��Ʈ��
	@RequestMapping("viewJsp_1_stringTest_find")
	public String returnStringTest(Model model) {
		System.out.println("StringReturnController.returnStringTest()����");
		System.out.println("model->"+ model);
		//�����ʹ� model.addAttribute(key, value)�� ������
		model.addAttribute("modeldata", "view�� �����͸� ������ ���� �����ϸ� Model �������̽��� �������");
		System.out.println("model->"+ model);
		//view �������� �Լ� �������� ��Ʈ������ �ؼ� String return value�� ������.
		return "viewJsp_1_stringTest_find_return_file";
	}//returnStringTest
	//������ �𵨿���
	@RequestMapping("viewJsp_2_modelandview_find")
	public ModelAndView returnModelandView() {
		System.out.println("returnModelandView()����");
		
		//mav.addObject�� (key, value)�� ������ ����
		//mav.setViewName(view������ �̸�);
		ModelAndView mav = new ModelAndView();
		System.out.println("mav ->"+ mav);
		mav.addObject("mavdata", "ModelAndView Return data");
		mav.setViewName("viewJsp_2_modelandview_return_file");
		System.out.println("mav2 ->"+ mav);
		return mav;
	}
	@RequestMapping("viewJsp_3_voidTest_find")
	public void voidTest(Model md) {
	md.addAttribute("mmmm", "������������ void �������� ������ �Ǿ �ű��ϴ�. �� ������ �ִ�. �䫊 url �̸��� view �̸��� ���ƾ���. ");
}
	
}//class
