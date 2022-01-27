<!-- 
contentType : 현재 jsp 문서의 문서형태와 인코딩 설정
text/html : MIME : 이 현재 페이지는 html 형식을 하고 있다.
MIME : Multipurose Internet Mail Extensions : 전자우편을 위한 인터넷 표준 포맷. 
		파일의 포맷 및 인코딩 설정 표시   https://ko.wikipedia.org/wiki/MIME 함 읽어보셈
charset="EUC-KR" : 현재 jsp 페이지의 인코딩이 EUC-KR 이다. ->jsp과 관련된 코드만 EUC-KR로 인코딩하겠단 것 다른건 안함
 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"  pageEncoding="EUC-KR"%>
<!-- jsp파일에 객체 불러오기  jre api가 있기때문에 가능 ,-->
<%@ page import="java.util.Date" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
<!-- 현재 페이지 html 인코딩이 EUC-KR이다. -->
<meta charset="EUC-KR">
<title>jsp 태그틀</title>
</head>
<body>
<h3>JSP 태그(요소,엘리먼트) 사용법</h3>
<hr>
<%-- jsp 주석 : 웹브라우저(클라이언트)로 넘어가지 않는다.--%>
<% out.println("이곳은 스크립틀릿 영역이다. <br>");
   out.println("자바 코드를 구현하면 된다. <br>");
   out.println("1.jsp 내장형 오브젝트 : request, response<br>");
   out.println("2. Servlet 코드<br>");
   out.println("3. java 코드 <br>");
   out.println("4. 프로그램 실행 결과만 클라이언트로 응답한다. <br>");
   out.println(new Date());
%>
<%= "이곳은 표현식 영역이다." %>
<%= "하는 역할은 브라우저에 출력을 담당한다." %>
<%= "스크립틀릿 영역에서 사용하는 out.println()과 동일한 기능을 한다" %>
<%--불러온 객체 사용하기  --%>
<%= new Date() %><br>
<!-- 메인 페이지 footer 용도로 사용한다. 페이지를 불러오는데 변경은 불가능하다. -->
<%@ include file="testjsp.jsp" %>
</body>
</html>