<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>jstl ���� �̿��ؼ� ����Ʈ, ���� Ŭ���� �ٷ�� </title>
</head>
<body>
<h3>jstl_10</h3>
<hr>
<c:set var="date" value="<%=new Date() %>" />
<h3>��¥�� �ð��� �⺻���� ǥ�� : ${date }</h3>
������ ��¥ : <fmt:formatDate value="${date }" type="date" /><br/>
������ �ð� : <fmt:formatDate value="${date }" type="time" /><br/>
��¥�� �ð� : <fmt:formatDate value="${date }" type="both" /><br/>
Short : <fmt:formatDate value="${date }" type="both" dateStyle="short" timeStyle="short" /><br/>
Medium : <fmt:formatDate value="${date }" type="both" dateStyle="medium" timeStyle="medium" /><br/>
Long : <fmt:formatDate value="${date }" type="both" dateStyle="long" timeStyle="long" /><br/>
Full : <fmt:formatDate value="${date }" type="both" dateStyle="full" timeStyle="full" /><br/>
Pattern1 : <fmt:formatDate value="${date }" type="date" pattern="yyyy�� MM�� dd��(E)" /><br/>
Pattern2 : <fmt:formatDate value="${date }" type="time" pattern="(a) hh�� mm��" /><br/>
<br /><hr /><br />
<%
	Date now = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd�� HH�� mm�� ss��");
%>
JAVA : <%=now %><br />
JAVA Format : <%=sdf.format(now) %>
</body>
</html>