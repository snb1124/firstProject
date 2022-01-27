package a.b.c.com.common;

public abstract class CodeUtil {
	
		
	// 성별 라벨
	public static final String[] gender_value = {"여자","남자"};
	
	// 핸드폰 라벨
	public static final String[] hp_value = {"010", "011", "016", "017"};
		
	// 전화번호 라벨
	public static final String[] tel_value = {"02", "031", "041", "051", "061"};
	
	// 취미 라벨
	public static final String[] hobby_lavel = {"알고리즘", "코딩", "분석설계", "데이터베이스", "스크립트"};
	public static final String[] hobby_value = {"01", "02", "03", "04", "05"};
	
	// 생년월일 
	public static String birth(String s) {

		String s0 = "";
		String s1 = "";
		String s2 = "";
		String ss = "";
		
		if (s !=null && s.length() > 0){			
			int sLen = s.length();			
			if (8 == sLen) {
				s0 = s.substring(0, 4);
				s1 = s.substring(4, 6);
				s2 = s.substring(6);				
				ss = s0 + "-" + s1 + "-" + s2;
			}
		}		
		return ss;
	}
	
	// 성별
	public static String gender(String s) {
		//조건부 ? 좌항이 참이라면 우항에 :를 기준으로 왼쪽 트루 오른쪽 펄스 반환 
		return "F".equals(s.toUpperCase()) ? "여자" : "남자";
	}
	
	// 전화번호 
	public static String tel(String s) {

		String s0 = "";
		String s1 = "";
		String s2 = "";
		String ss = "";
		
		if (s !=null && s.length() > 0){			
			int sLen = s.length();			
			if (10 == sLen) {
				s0 = s.substring(0, 2);
				s1 = s.substring(2, 6);
				s2 = s.substring(6);
				ss = s0 + "-" + s1 + "-" + s2;
			}		
			if (11 == sLen) {
				s0 = s.substring(0, 3);
				s1 = s.substring(3, 7);
				s2 = s.substring(7);
				ss = s0 + "-" + s1 + "-" + s2;
			}
		}
		return ss;
	}
	
	// 전화번호 
	public static String hp(String s) {

		String s0 = "";
		String s1 = "";
		String s2 = "";
		String ss = "";
		
		if (s !=null && s.length() > 0){			
			int sLen = s.length();			
			if (11 == sLen) {
				s0 = s.substring(0, 3);
				s1 = s.substring(3, 7);
				s2 = s.substring(7);
				ss = s0 + "-" + s1 + "-" + s2;
			}
		}		
		return ss;
	}

	// 취미들 
	//s는 깡통클래스에 저장된 취미들 
	// split 함수를 이용해서 하나하나 쪼개서 배열로 만듬
	public static String hobbys(String s){
		System.out.println(s);
		String h = "";
		//쉽표 기준으로 쪼개서 배열로 다시 입력 
		String ss[] = s.split(",");
		for (int i=0; i < ss.length; i++){	
			System.out.println(hobby(ss[i]));
			h += hobby(ss[i]) + " ";
		}		
		return h;
	}
	
	// 취미
	public static String hobby(String s) {
		//스트링 변수 선언
		String h = "";
		// 매개변수가 있다면 실행
		if (s !=null && s.length() > 0){
			//반복 1번부터  hobby_lavel의 길이만큼
			//왜 1부터 실행?
			for (int i=0; i < hobby_lavel.length; i++) {	
				if (("0" + i).equals(s)) {
					h = CodeUtil.hobby_lavel[i];
				}
			}			
		}		
		return h;
	}
	
	// 취미 value(코드) 세팅
	public static String setHobby(String s) {
		String h = "";						
		for (int i=0; i < CodeUtil.hobby_lavel.length; i++) {			
			if (CodeUtil.hobby_lavel[i].equals(s)) {
				h = CodeUtil.hobby_value[i];
			}			
		}		
		return h;
	}
	
	// 취미, 직업 value(코드) 세팅
	public static int getComboIndex(String s) {		
		int c = 0;			
		if ("01".equals(s)) { c = 0; }		
		if ("02".equals(s)) { c = 1; }		
		if ("03".equals(s)) { c = 2; }
		if ("04".equals(s)) { c = 3; }		
		if ("05".equals(s)) { c = 4; }		
		if ("06".equals(s)) { c = 5; }
		return c;
	}	
		
	public static void main(String args[]) {
		
		// 생년월일
		String b = CodeUtil.birth("20210801");		
		System.out.println("b >>> : " + b);
		
		// 전화번호
		String t = CodeUtil.tel("03212341234");		
		System.out.println("t >>> : " + t);
		
		// 핸드폰
		String hp = CodeUtil.tel("01012341234");		
		System.out.println("hp >>> : " + hp);		
		
		// 성별
		String g = CodeUtil.gender("02");
		System.out.println("g >>> : " + g);
		// 취미
		String h = CodeUtil.hobby("02");
		System.out.println("h >>> : " + h);
		// 취미들
		String hs = CodeUtil.hobbys("01,02,03");
		System.out.println("hs >>> : " + hs);
		
		
	}
}
