<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>getData JSP</title>
</head>
<body>
<!-- 
http://localhost:8088/testWeb/html_1/getData_1.html?mname=1111&maddr=2222
-->
<%request.setCharacterEncoding("UTF-8"); %>
<% 
	String mname = request.getParameter("mname"); // mname=1111 &
	String maddr = request.getParameter("maddr"); // maddr=2222
	out.println("mname >>> : " + mname);
	out.println("maddr >>> : " + maddr);
	System.out.println("mname >>> : " + mname);
	System.out.println("maddr >>> : " + maddr);
%>
</body>
</html>