package com.catchdog.common;

public class RegionUtil {
	public static final String[] REGION_VALUE = {
		"allregion", "seoul", "busan", "daegu", "incheon", 
		"gwangju", "daejeon", "ulsan", "sejong", "kyungki",
		"kangwon", "chungbuk", "chungnam", "jeonbuk", "jeonnam",
		"kyungbuk", "kyungnam", "jeju"
	};
	public static final String[] REGION_TEXT = {
		"전체", "서울특별시", "부산광역시", "대구광역시", "인천광역시", 
		"광주광역시", "대전광역시", "울산광역시", "세종특별자치시", "경기도",
		"강원도", "충청북도", "충청남도", "전라북도", "전라남도",
		"경상북도", "경상남도", "제주도"
	};
	
	public static String getRegionValue(String text) {
		if(text == null) return "allregion";
		for(int i=0; i<REGION_TEXT.length; i++) {
			if(text.equals(REGION_TEXT[i])) return REGION_VALUE[i];
		}
		return "allregion";
	}
	
	public static int getRegionIndex(String text){
		System.out.println("RegionUtil text >>> : " + text);
		if(text == null) return 0;
		for(int i=0; i<REGION_TEXT.length; i++) {
			if(text.equals(REGION_TEXT[i])) return i;
		}
		return 0;
	}
}
