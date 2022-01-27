<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>jstl for문 사용하기 </title>
</head>
<body>
<h3>jstl for문 사용하기</h3>
<hr>
<%--
JAVA 반복문 : for, while, do~while
JSTL 반복문 : <c:forEach>실행문</c:forEach>
	<c:forEach var="반복변수명" begin="초기값" end="최종값" step="증감값">실행문</c:forEach>
 --%>
 
 
 
 
 
 JAVA 반복문 <br>
 <%
 	for (int i=1; i<=7; i++){
 		out.println("<font size="+i+"> 자바 for문 돌린드아 </font> <br>" );
 	}
 %>
 <br>
 
 JSTL 반복문 <br>
 <!-- 1부터 7까지 1씩 증가 즉 7번 실행  -->
 <c:forEach var="i" begin="1" end="7"> <!-- 스텝의 값이 1이라면 생략 가능하다  -->
  <font size="${i }">jstl 반복문 돌린드아 </font><br>
  </c:forEach>
  <br>
  <c:forEach var="i" begin="10" end="1" step="2"> <!-- step값은 음수를허용하지 않는다. -->
  <font size="${i }"> jstl 반복문 두번째드아 </font><br>
  </c:forEach>
</body>
</html>