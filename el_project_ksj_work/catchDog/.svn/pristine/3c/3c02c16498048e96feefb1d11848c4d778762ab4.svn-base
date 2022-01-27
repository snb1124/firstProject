package com.catchdog.login.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.catchdog.common.GoogleMailSend;
import com.catchdog.common.K_Session;
import com.catchdog.common.PasswordUtil;
import com.catchdog.login.service.LoginService;
import com.catchdog.login.vo.TempPwVO;
import com.catchdog.member.vo.MemberVO;

@Controller
public class LoginController {

	Logger logger = Logger.getLogger(LoginController.class);
	
	private LoginService loginService;
	
	//생성자 오토와이어드
	@Autowired(required=false)
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}
	
	//로그인 입력폼
	@RequestMapping("loginForm")
	public String loginForm() {
		logger.info("LoginController loginForm() 함수 진입 >>> : ");
		
		return "login/LoginForm";
	}
	
	// 로그인
	@PostMapping("login")
	public String login(HttpServletRequest req, MemberVO mvo, Model model) {
		logger.info("LoginController login() 함수 진입 >>> : ");
		
		List<MemberVO> listLogin = loginService.loginCheck(mvo);
		logger.info("LoginController login() listLogin.size() >>> : " + listLogin.size());
		
		model.addAttribute("loginYN", "N");

		if (listLogin.size() == 1) {
			
			K_Session ks = K_Session.getInstance();
			
			if (!ks.setSession(req, listLogin.get(0))) {
				
				logger.info("SpingLoginController login >>> : 세션부여 하기  >>> : " + mvo.getMid());
				model.addAttribute("loginYN","Y");
			}
		}
		return "login/LoginMessage";
	}
	
	// 로그아웃
	@GetMapping("loginOut")
	public String logout(HttpServletRequest req, MemberVO mvo, Model model) {
		logger.info("LoginController login() 함수 진입 >>> : ");
				
		return "login/LogoutMessage";
	}
	
	// 네이버 콜백
	@GetMapping("NaverCallback")
	public String NaverCallback() {
		logger.info("LoginController NaverCallback() 함수 진입 >>> : ");
		
		return "login/NaverCallback";
	}
	
	// 카카오콜백
	@GetMapping("KakaoCallback")
	public String KakaoCallback() {
		logger.info("LoginController KakaoCallback() 함수 진입 >>> : ");		
		return "login/KakaoCallback";
	}
	
	@GetMapping("FindIdForm")
	public String emailIdFindForm() {
		return "login/LoginFindIdForm";
	}
	
	@PostMapping("FindId")
	public String emailIdCheck(MemberVO mvo, Model model) {
		
		List<MemberVO> result = loginService.FindId(mvo);
		model.addAttribute("result", "N");
		
		if (result.size() > 0) {
			model.addAttribute("result", result);
			return "login/LoginFindId";
		}
		return "login/LoginFindIdMessage";
	}
	
	@GetMapping("IdCheckForm")
	public String IdCheckForm() {
		return "login/LoginIdCheckForm";
	}
	
	@PostMapping("IdCheck")
	public String IdCheck(MemberVO mvo, Model model) {
		logger.info("LoginController IdCheck() 함수 진입 >>> : ");
		
		List<MemberVO> IdCheck = loginService.IdCheck(mvo);
		model.addAttribute("IdCheck", "N");
		
		if (IdCheck.size() > 0) {
			model.addAttribute("IdCheck", IdCheck);
			return "login/LoginFindPw";
		}
		return "login/LoginIdCheckMessage";
	}

	@SuppressWarnings("finally")
	@GetMapping("TempPw")
	public String TempPw(HttpServletRequest req, MemberVO mvo, TempPwVO tvo, Model model) {
		logger.info("LoginController TempPw() 함수 진입 >>> : ");
		
		// 임시 비밀번호(8자) 만들기
		String temp_pw_num = PasswordUtil.randomPW(8);
		// 임시 비밀번호 TEMP_PW 테이블에 입력하기
		tvo.setPtemppw(temp_pw_num);
		tvo.setMnum(req.getParameter("mnum"));
		int tempPwCnt = loginService.tempPwInsert(tvo);
		
		// 입력 성공하면 임시 비밀번호 이메일 보내기
		try {
			if (tempPwCnt == 1) {
				temp_pw_num = tvo.getPtemppw();
				
				String mailSubject = "비밀번호 찾기";
				String sendMail = "catchdogmanager@gmail.com";
				String sendPw = "@catchd20og21";
				String reviceMail = mvo.getMemail();
				String sendMsg = "<div>임시 비밀번호입니다.<br>"+temp_pw_num+"</div>";
				
				GoogleMailSend gms = new GoogleMailSend();
				gms.googleMailSend(mailSubject, sendMail, sendPw, reviceMail, sendMsg);
				
				// idFind에 메시지 띄우기
				model.addAttribute("SUCCESS", "Y");
				loginService.updatePw(tvo);
			}
		}catch(Exception e) {
			model.addAttribute("SUCCESS", "N");
			 e.getCause();
		}finally {
			return "login/LoginTempPw";
		}
	}
	// 로그인 안드로이드
	@RequestMapping(value="loginAndroid", method = {RequestMethod.POST})
	@ResponseBody
	public String loginAndroid(HttpServletRequest req, MemberVO mvo, Model model) {	
		logger.info("LoginController loginAndroid() 함수 진입 >>> : ");		
		//MemberVO.printVO(mvo);
		logger.info("LoginController loginAndroid() 함수 진입 mvo.getMid() >>> : " + mvo.getMid());
		logger.info("LoginController loginAndroid() 함수 진입 mvo.getMpw() >>> : " + mvo.getMpw());
		
		
		String loginFlag="";
		
		List<MemberVO> listLogin = loginService.loginCheck(mvo);
		logger.info("LoginController loginAndroid listLogin.size() >>> : " + listLogin.size());
		
		if (listLogin.size() == 1) loginFlag = "T";				
		else loginFlag = "F";
				
		logger.info("LoginController loginAndroid loginFlag >>> : " + loginFlag);
		return loginFlag;
	}	
}
