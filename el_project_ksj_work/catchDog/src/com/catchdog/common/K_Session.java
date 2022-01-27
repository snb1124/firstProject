package com.catchdog.common;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.catchdog.member.vo.MemberVO;

public class K_Session {

	private static final String K_SESSION_ID = "KID";
	private static final String K_SESSION_NUM = "KNUM";
	private static final String K_SESSION_NAME = "KNAME";
	
	private static class LazyHolder{
		public static final K_Session SESSIONLISTENER_INSTANCE = new K_Session();
	}
	
	public static K_Session getInstance() {
		return LazyHolder.SESSIONLISTENER_INSTANCE;
	}
	
	public K_Session() {
		super();
	}
	
	public void killSession(final HttpServletRequest hReq) {
		HttpSession hSession = hReq.getSession(false);
		if (hSession != null) {
			hSession.removeAttribute(K_SESSION_ID);
			hSession.invalidate();
		}
	}
	
	public boolean setSession(final HttpServletRequest hReq, final MemberVO mvo) {
		
		HttpSession hSession = hReq.getSession();
		String k_session_val = (String)hSession.getAttribute(K_SESSION_ID);
		int nCnt = 0;
		
		if (k_session_val != null) {
			boolean b1 = k_session_val.equals(mvo.getMid());
			
			if (b1) {
				nCnt++;
			}else {
				System.out.println("세션 없음 >>> : ");
			}
		}else {
			System.out.println("세션 없음 >>> : ");
		}
		
		if (nCnt == 0) {
			hSession.setAttribute(K_SESSION_ID, mvo.getMid());
			hSession.setAttribute(K_SESSION_NUM, mvo.getMnum());
			hSession.setAttribute(K_SESSION_NAME, mvo.getMname());
			hSession.setMaxInactiveInterval(60*60);
			
			return false;
		}
		return true;
	}
	
	public Map<String, Object> getSession(final HttpServletRequest hReq) {
		
		Map<String, Object> sessionMap = new HashMap<String, Object>();
		HttpSession hSession = hReq.getSession(false);
		if (hSession != null) {
			sessionMap.put("ssMid", hSession.getAttribute(K_SESSION_ID));
			sessionMap.put("ssMnum", hSession.getAttribute(K_SESSION_NUM));
			sessionMap.put("ssMname", hSession.getAttribute(K_SESSION_NAME));
		}
		return sessionMap;
	}
}
