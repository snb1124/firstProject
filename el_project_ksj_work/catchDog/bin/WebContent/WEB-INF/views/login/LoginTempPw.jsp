<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TEMPPW</title>
</head>
<body>
<%
	Object obj = request.getAttribute("SUCCESS");
	if (obj == null) return;
	
	String temp_pw_num = obj.toString();
	String ptemppwStr = "임시 비밀번호로 로그인한 후 비밀번호를 변경해주세요.";
	System.out.println("ptemppwStr >>> : " + ptemppwStr);
%>
<?xml version='1.0' encoding='UTF-8'?>
<login>
	<result><%= ptemppwStr %></result>
</login>
</body>
</html>