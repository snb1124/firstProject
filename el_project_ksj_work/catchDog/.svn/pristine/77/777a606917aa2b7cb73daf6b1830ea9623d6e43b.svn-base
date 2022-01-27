package com.catchdog.mypage.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.catchdog.member.vo.MemberVO;
import com.catchdog.mypage.service.MypageService;


@Controller
public class MypageController {
	
	Logger logger = Logger.getLogger(MypageController.class);
		
	// 마이페이지 폼으로
	@GetMapping("mypageForm")
	public String mypageForm() {
		logger.info("mypageController mypageForm() 함수 진입 >>> : ");
	
		return "mypage/mypageForm";
	}
}
