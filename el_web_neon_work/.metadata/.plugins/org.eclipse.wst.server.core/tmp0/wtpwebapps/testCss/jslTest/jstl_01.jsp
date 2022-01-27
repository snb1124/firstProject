<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>jstl_01</title>
</head>
<body>
<h3>jstl_01</h3>
<hr>
1.기본 프로그래밍 tag(변수, 배열, if, for, switcg-case 등)->core<br>
<%
	int num=100;
%>
<!--JAVA num  100 -->
JAVA num = <%=num %><br>

<%-- JSTL 변수 선언: <c:set~~> --%>
<c:set var= "su1" value="200"/>
JSTL su1 : ${su1 }<br>
<%--JAVA num 값을 JSTL su2 할당  100 --%>
<c:set var="su2" value="<%=num %>"/>
<%--JSTL su1값과 su2값 더한 값 : result 300 --%>
<c:set var="result" value="${su1+su2} "/>
JSTL result : ${result }

</body>
</html>