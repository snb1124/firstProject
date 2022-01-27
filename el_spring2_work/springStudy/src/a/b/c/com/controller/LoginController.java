package a.b.c.com.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import a.b.c.com.vo.UserVO;
@Controller
public class LoginController {
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String loginForm(Model model) {
		model.addAttribute("userVO", new UserVO());

			return "login";
	}
@RequestMapping(value = "loginData", method = RequestMethod.POST)
public String onSubmit(@ModelAttribute("userVO") UserVO userVO) {

	System.out.println("onSubmit 구현 메서드 입니다.");

		return "loginData";
	}

}