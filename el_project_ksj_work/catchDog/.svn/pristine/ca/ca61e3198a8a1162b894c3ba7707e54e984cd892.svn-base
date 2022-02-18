package com.catchdog.mainpage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.catchdog.common.K_Session;
import com.catchdog.mainpage.service.MainPageService;
import com.catchdog.mainpage.vo.MainPageVO;

@Controller
public class MainPageController {
	private MainPageService mainPageService;
	
	@Autowired(required=false)
	public MainPageController(MainPageService mainPageService) {
		this.mainPageService = mainPageService;
	}
	
	@RequestMapping("mainpageData")
	public String mainAdoption(MainPageVO mvo, Model model, HttpServletRequest req) {
		K_Session ks = K_Session.getInstance();
		mvo.setMnum((String)ks.getSession(req).get("ssMnum"));
		List<MainPageVO> adoptionList = mainPageService.selectAdoption(mvo);
		List<MainPageVO> disappearanceList = mainPageService.selectDisappearance(mvo);
		List<MainPageVO> goodsList = mainPageService.selectGoods(mvo);
		model.addAttribute("alist", adoptionList);
		model.addAttribute("dlist", disappearanceList);
		model.addAttribute("glist", goodsList);
		return "mainpage/mainPage";
	}
}
