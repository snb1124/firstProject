<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>void �� �����ϱ� </title>
</head>
<body>
<h3>${mmmm}</h3>
<%
	String voidreturn = String.valueOf(request.getAttribute("mmmm"));
	out.println("voidreturn"+voidreturn);

%>

</body>
</html>