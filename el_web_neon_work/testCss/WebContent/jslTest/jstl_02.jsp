<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>jstl_02</title>
</head>
<body>
<h3>jstl_02</h3>
<hr>
<!-- page �Ѱ� �����͸� �̵��ϱ� ���ؼ���  scope="request" �� �ʿ��ϴ� -->
		
<c:set var="code" value="abc001" scope="request" />
<c:set var="name" value="��ǻ��" scope="request" />
<c:set var="price" value="5000000" scope="request" />
<jsp:forward page="jstl_02_1.jsp" />
</body>
</html>