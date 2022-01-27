package com.catchdog.kakao.controller;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
//import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class KakaoController {

	Logger logger = Logger.getLogger(KakaoController.class);
	@RequestMapping(value="kakaoPay", method=RequestMethod.GET)
	@ResponseBody
	public String kakaoPay(Model mv, HttpServletRequest req) {
		try {
			URL url = new URL("https://kapi.kakao.com/v1/payment/ready");
			HttpURLConnection huc = (HttpURLConnection) url.openConnection();
			huc.setRequestMethod("POST");
			huc.setRequestProperty("Authorization", "KakaoAK 9ffd891be1a8452f3fac69e2426810ff");
			huc.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
			//커넥션 서버에 두아웃풋 전해줄것이 있으면 트루 
			huc.setDoOutput(true);
			
			String param = "cid=TC0ONETIME"
					+ "&partner_order_id=GPD202112120009"
					+ "&partner_user_id=KOSMO"
					+ "&item_name=hardcase"
					+ "&quantity=2"
					+ "&total_amount=20000"
					+ "&tax_free_amount=1636"
					+ "&approval_url=http://localhost:8088/kakaoPaySuccess.cd"
					+ "&cancel_url=http://localhost:8088/kakaoPayCancel.cd"
					+ "&fail_url=http://localhost:8088/kakaoPaySuccessFail.cd";
			OutputStream ops = huc.getOutputStream();
			DataOutputStream dos = new DataOutputStream(ops);
			dos.writeBytes(param);
			dos.close();
			
			int result = huc.getResponseCode();
			
			InputStream ips;
			if(result==200) {
				ips = huc.getInputStream();
			}else {
				ips = huc.getErrorStream();
			}
			InputStreamReader ipr = new InputStreamReader(ips);
			BufferedReader bfr = new BufferedReader(ipr);
			String kaka;
			kaka = bfr.readLine();		
			System.out.println("kaka--->>>" + kaka);
		
			String[] tidall = kaka.split(",");
			
			String tid2 = tidall[0];
			String tid = tid2.substring(8, tid2.length()-1);
			System.out.println("tid--->>>" + tid);
			req.getSession().setAttribute("tid", tid);
			
			return kaka;
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{\"result\":\"NO\"}";
		
	}
	
	
	
	@RequestMapping(value="kakaoPaySuccess", method=RequestMethod.GET)
	public String kakaoPaySuccess(@RequestParam("pg_token") String pg_token, HttpServletRequest req) {
        logger.info("kakaoPaySuccess get............................................");
        logger.info("kakaoPaySuccess pg_token : " + pg_token);
        try {
			URL url = new URL("https://kapi.kakao.com/v1/payment/approve");
			HttpURLConnection huc = (HttpURLConnection) url.openConnection();
			huc.setRequestMethod("POST");
			huc.setRequestProperty("Authorization", "KakaoAK 9ffd891be1a8452f3fac69e2426810ff");
			huc.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
			//커넥션 서버에 두아웃풋 전해줄것이 있으면 트루 
			//필수족으로 들어가야할 값 cid, tid, partner_order_id, partner_user_id, pg_token
			// kakaopay클래스에서 넘어온 값을 넘겨받아서 사용해야한다. 전역변수? vo클래스?
			huc.setDoOutput(true);
		      String tid = (String)req.getSession().getAttribute("tid");
	        
		      logger.info("kakaoPaySuccess tid"+tid);
			String param = "cid=TC0ONETIME"
					+ "&tid="+tid
					+ "&partner_order_id=GPD202112120009"
					+ "&partner_user_id=KOSMO"
					+ "&pg_token="+pg_token
					+ "&total_amount=20000";
			OutputStream ops = huc.getOutputStream();
			DataOutputStream dos = new DataOutputStream(ops);
			dos.writeBytes(param);
			dos.close();
			
			int result = huc.getResponseCode();
			
			InputStream ips;
			if(result==200) {
				ips = huc.getInputStream();
			}else {
				ips = huc.getErrorStream();
			}
			InputStreamReader ipr = new InputStreamReader(ips);
			BufferedReader bfr = new BufferedReader(ipr);
			String kaka;
			kaka = bfr.readLine();
			String s[] = kaka.split(",");
			
			for (int i=0; i < s.length; i++) {

				
				if (8 == i) {

					String ss[] = s[i].split(":");
					
					for (int j=0; j < ss.length; j++) {

						if (!"amount".equals(ss[j]) && !"{total".equals(ss[j])) {
							String kaka2 = ss[j];
							req.setAttribute("kaka2", kaka2);
						}
					}
				}	
			}	
			
			return "kakao/kakaoPaySuccess";
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{\"result\":\"NO\"}";
		
	}
	
	@RequestMapping(value="kakaoPayCancel")
	public String kakaoPayCancel() {
		logger.info("카카오페이 취소");
		
		return "kakao/kakaoPayCancel";
	}
	
	@RequestMapping(value="kakaoPaySuccessFail")
	public String kakaoPaySuccessFail() {
		logger.info("카카오페이 취소");
		
		return "kakao/kakaoPaySuccessFail";
	}

}
