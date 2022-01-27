<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%
	String[] fruit= {"���", "���", "������", "�ٳ���", "���ξ���"};
	pageContext.setAttribute("fruit", fruit);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>for�� ����ؼ� �迭 ������ </title>
</head>
<body>
<h3>for�� ����ؼ� �迭 ������ </h3>
<hr>
<ul>
<%
	out.println("java for ����ؼ� �ݺ��� ������<br> ");
	for(int i =0; i < fruit.length; i++){
		out.println("<li>"+fruit[i]+"</li>");
		
	}
%>

</ul>
<%--
JSTL �ݺ��� : <c:forEach>���๮</c:forEach>
	<c:forEach var="�ݺ�������" items="${�迭��}" >���๮</c:forEach>
 --%>
 <ul>
 JSTL �ݺ��� ����ؼ� �迭 ������ 
	<c:forEach var="i" items="${fruit }">
		<li>${i }</li>
	</c:forEach>
</ul>
</body>
</html>