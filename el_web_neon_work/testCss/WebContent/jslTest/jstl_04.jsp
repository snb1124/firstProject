<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>������ �Ѱܹޱ� </title>
</head>
<body>
<h3> ������ �Ѱܹޱ� parseInt ����</h3>
<hr>
<% 
	out.println("<hr>");
	int num= Integer.parseInt(request.getParameter("num"));
	if(num==1){
		out.println("������ �ݰ��� java:if");
		
	}else if(num==2){
		out.println("������ �ݰ��� java:if");
	}else{
		out.println("����");
	}
	%>
	<br>
	c:if ����ϱ� <br>
	<hr>
	<c:if test ="${param.num==1 }"> c:if ���� </c:if>
	<c:if test ="${param.num==2 }"> c:if2 ���� </c:if>
	<c:if test ="${param.num==3 }"> c:if3 ���� </c:if>
	<br>
	<%
	out.println("�ڹ� ����ġ��");
	out.println("<hr>");
		switch(num){
		case 1 : 
				out.println("�ڹ� ����ġ ���̴� ");
		break;
		case 2 : 
				out.println("�ڹ� ����ġ�� 2");
		break;
		case 3 : 
				out.println("����ġ�� 3");
				break;
		
		}
	%>
	<br>
	
	c:choose ����
	<hr>
	<c:choose>
	<c:when test="${param.num==1} "> c:choose �ݰ��� </c:when>
	<c:when test="${param.num==2} "> c:choose �ݰ�2 </c:when>
	<c:otherwise>�ݰ��� choose </c:otherwise>
	</c:choose>
	
</body>
</html>