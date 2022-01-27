<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>jstl for�� ����ϱ� </title>
</head>
<body>
<h3>jstl for�� ����ϱ�</h3>
<hr>
<%--
JAVA �ݺ��� : for, while, do~while
JSTL �ݺ��� : <c:forEach>���๮</c:forEach>
	<c:forEach var="�ݺ�������" begin="�ʱⰪ" end="������" step="������">���๮</c:forEach>
 --%>
 
 
 
 
 
 JAVA �ݺ��� <br>
 <%
 	for (int i=1; i<=7; i++){
 		out.println("<font size="+i+"> �ڹ� for�� ������� </font> <br>" );
 	}
 %>
 <br>
 
 JSTL �ݺ��� <br>
 <!-- 1���� 7���� 1�� ���� �� 7�� ����  -->
 <c:forEach var="i" begin="1" end="7"> <!-- ������ ���� 1�̶�� ���� �����ϴ�  -->
  <font size="${i }">jstl �ݺ��� ������� </font><br>
  </c:forEach>
  <br>
  <c:forEach var="i" begin="10" end="1" step="2"> <!-- step���� ������������� �ʴ´�. -->
  <font size="${i }"> jstl �ݺ��� �ι�°��� </font><br>
  </c:forEach>
</body>
</html>