<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%
	String[] fruit= {"사과", "멜론", "오렌지", "바나나", "파인애플"};
	pageContext.setAttribute("fruit", fruit);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>for문 사용해서 배열 꺼내기 </title>
</head>
<body>
<h3>for문 사용해서 배열 꺼내기 </h3>
<hr>
<ul>
<%
	out.println("java for 사용해서 반복문 꺼내기<br> ");
	for(int i =0; i < fruit.length; i++){
		out.println("<li>"+fruit[i]+"</li>");
		
	}
%>

</ul>
<%--
JSTL 반복문 : <c:forEach>실행문</c:forEach>
	<c:forEach var="반복변수명" items="${배열명}" >실행문</c:forEach>
 --%>
 <ul>
 JSTL 반복문 사용해서 배열 꺼내기 
	<c:forEach var="i" items="${fruit }">
		<li>${i }</li>
	</c:forEach>
</ul>
</body>
</html>