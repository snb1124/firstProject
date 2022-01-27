package com.catchdog.common;

import java.util.UUID;

public abstract class PasswordUtil {

	public static String tempPW(int len) {
		String u = UUID.randomUUID().toString();
		System.out.println("u >>> : " + u);
		
		u = u.replace("-", "").substring(0, len);
		System.out.println("u >>> : " + u);
		
		return u;
	}
	
	public static String randomPW(int len) {
		char c[] = {
					'1','2','3','4','5','6','7','8','9','0', 
		        	'A','B','C','D','E','F','G','H','I','J',
		        	'K','L','M','N','O','P','Q','R','S','T',
		        	'U','V','W','X','Y','Z', 
		        	'a','b','c','d','e','f','g','h','i','j',
		        	'k','l','m','n','o','p','q','r','s','t',
		        	'u','v','w','x','y','z',
		        	'!','@','#','&'				
				
				   };
		
		String p = "";
		
		for (int i=0; i < len; i++) {
			int a = (int)(Math.random()*(c.length));
			
			System.out.println("a >>> : " + a);
			
			p += c[a];
		}
		
		return p;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = PasswordUtil.tempPW(6);
		System.out.println("s1 >>> : " + s1);
		
		String s2 = PasswordUtil.randomPW(6);
		System.out.println("s2 >>> : " + s2);
	}
}
