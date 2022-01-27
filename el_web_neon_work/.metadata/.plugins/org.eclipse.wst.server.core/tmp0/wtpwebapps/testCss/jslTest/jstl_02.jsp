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
<!-- page 넘겨 데이터를 이동하기 위해서는  scope="request" 이 필요하다 -->
		
<c:set var="code" value="abc001" scope="request" />
<c:set var="name" value="컴퓨터" scope="request" />
<c:set var="price" value="5000000" scope="request" />
<jsp:forward page="jstl_02_1.jsp" />
</body>
</html>