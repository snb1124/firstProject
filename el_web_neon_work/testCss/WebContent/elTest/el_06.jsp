<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<%@ page import="a.b.c.com.common.EL_MemberVO" %>
<%@ page import="java.util.ArrayList" %>

<%
	// 스트링 배열 선언 
	String[] study = {"JAVA", "View", "SQL", "Servlet/JSP/SPRING", "Android", "IoT", "Project"};
	// setAttribute 벨류값 집어넣기 
	request.setAttribute("study", study);
	//어레이리스트 선언, 요소 추가하기 
	ArrayList<String> list = new ArrayList<>();
	list.add("오렌지");
	list.add("바나나");
	list.add("사과");
	list.add("멜론");
	list.add("레몬");
	//setAttribute 벨류값 집어넣기 
	request.setAttribute("list", list);
	// vo 클래스 인스턴스화
	EL_MemberVO mvo = new EL_MemberVO();
	//값 집어넣기 
	mvo.setIrum("김자성");
	mvo.setId("KJS");
	mvo.setPw("1234");
	mvo.setAge(24);
	mvo.setAddr("경기도 호법");
	mvo.setTel("032-111-2222");
	request.setAttribute("mvo", mvo);
	
	//다른 어레이리스트 요소 추가 
	ArrayList<EL_MemberVO> mlist = new ArrayList<>();
	//어떻게 함수에 들어가는거지? 
	mlist.add(new EL_MemberVO("홍길동", "hong", "1234", 11, "서울시", "010-1111-1111"));
	mlist.add(new EL_MemberVO("홍길동", "hong", "1234", 22, "서울시", "010-1111-1111"));
	mlist.add(new EL_MemberVO("홍길동", "hong", "1234", 33, "서울시", "010-1111-1111"));
	mlist.add(new EL_MemberVO("홍길동", "hong", "1234", 44, "서울시", "010-1111-1111"));
	mlist.add(new EL_MemberVO("홍길동", "hong", "1234", 55, "서울시", "010-1111-1111"));
	//setAttribute 벨류값 추가 
	request.setAttribute("mlist", mlist);
%>
<!-- 이동  -->
<jsp:forward page="el_06_1.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>el_06</title>
</head>
<body>
<h3>el_06</h3>
<hr>

</body>
</html>