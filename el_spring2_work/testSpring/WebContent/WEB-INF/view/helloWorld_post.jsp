<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>spring post</title>
</head>
<body>
<h3>${post_msg}</h3>
<h3>
<%
	String msg = String.valueOf(request.getAttribute("post_msg"));
%>

</h3>


</body>
</html>