<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>데이터 넘겨받기 </title>
</head>
<body>
<h3> 데이터 넘겨받기 parseInt 오류</h3>
<hr>
<% 
	out.println("<hr>");
	int num= Integer.parseInt(request.getParameter("num"));
	if(num==1){
		out.println("만난서 반가워 java:if");
		
	}else if(num==2){
		out.println("만나서 반갑다 java:if");
	}else{
		out.println("하위");
	}
	%>
	<br>
	c:if 사용하기 <br>
	<hr>
	<c:if test ="${param.num==1 }"> c:if 하위 </c:if>
	<c:if test ="${param.num==2 }"> c:if2 하위 </c:if>
	<c:if test ="${param.num==3 }"> c:if3 하위 </c:if>
	<br>
	<%
	out.println("자바 스위치문");
	out.println("<hr>");
		switch(num){
		case 1 : 
				out.println("자바 스위치 문이다 ");
		break;
		case 2 : 
				out.println("자바 스위치문 2");
		break;
		case 3 : 
				out.println("스위치문 3");
				break;
		
		}
	%>
	<br>
	
	c:choose 하이
	<hr>
	<c:choose>
	<c:when test="${param.num==1} "> c:choose 반가워 </c:when>
	<c:when test="${param.num==2} "> c:choose 반가2 </c:when>
	<c:otherwise>반갑다 choose </c:otherwise>
	</c:choose>
	
</body>
</html>