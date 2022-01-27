package com.catchdog.common;

public abstract class ChabunUtil {
	//구분자 본인 게시판 제일 앞글자 넣어서 추가하세요.
	//회원가입 구분
	public static final String GUBUN_M ="M";
	//입양
	public static final String GUBUN_A ="A";
	//입양후기
	public static final String GUBUN_R ="R";
	//파양
	public static final String GUBUN_AA ="AA";
	//실종
	public static final String GUBUN_D ="D";
	//굿즈
	public static final String GUBUN_G ="G";
	public static final String GUBUN_GPD ="GPD";
	//공지사항
	public static final String GUBUN_N ="N";
	//보호소
	public static final String GUBUN_S ="S";
	//관리자
	public static final String GUBUN_ADMIN ="ADMIN";
	
	
	public static String numPad(String t, String c){
		
		for (int i=c.length(); i < 4; i++) {
			c = "0" + c;
		}				
		String ymd = DateFormatUtil.ymdFormats(t);
		
		return ymd.concat(c);
	}
	
	public static String getMemChabun(String type, String memNum) {
		
		return GUBUN_M.concat(ChabunUtil.numPad(type, memNum));
	}
	public static String getAdoptionChabun(String type, String memNum) {
		
		return GUBUN_A.concat(ChabunUtil.numPad(type, memNum));
	}	
	public static String getReviewChabun(String type, String memNum) {
		
		return GUBUN_R.concat(ChabunUtil.numPad(type, memNum));
	}	
	public static String getDisadoptionChabun(String type, String memNum) {
		
		return GUBUN_AA.concat(ChabunUtil.numPad(type, memNum));
	}
	public static String getDisapearanceChabun(String type, String memNum) {
		
		return GUBUN_D.concat(ChabunUtil.numPad(type, memNum));
	}
	//굿즈 게시판 번호 
	public static String getGoodsChabun(String type, String memNum) {
		
		return GUBUN_G.concat(ChabunUtil.numPad(type, memNum));
	}
	//굿즈 상품 번호
	public static String getGpdChabun(String type, String memNum) {
		
		return GUBUN_GPD.concat(ChabunUtil.numPad(type, memNum));
	}
	public static String getNoticeChabun(String type, String memNum) {
		
		return GUBUN_N.concat(ChabunUtil.numPad(type, memNum));
	}
	public static String getShelterChabun(String type, String memNum) {
		
		return GUBUN_S.concat(ChabunUtil.numPad(type, memNum));
	}
	public static String getAdminChabun(String type, String memNum) {
		
		return GUBUN_ADMIN.concat(ChabunUtil.numPad(type, memNum));
	}
	
	

}
