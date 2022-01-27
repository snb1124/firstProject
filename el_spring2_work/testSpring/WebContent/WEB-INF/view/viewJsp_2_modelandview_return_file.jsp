<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ModelAndReturn TEST</title>
</head>
<body>

${mavdata}
<%
	String mavdata = String.valueOf(request.getAttribute("mavdata"));
	out.println("mavdata->>>>>>>"+mavdata);
%>

</body>
</html>