<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>el_05</title>
</head>
<body>
<h3>el_05</h3>
<hr>
입력 문자열 str1 : ${param.str1}<br>
입력 문자열 str2 : ${param.str2}<br>
문자열 대소 비교 : ${param.str1.compareTo(param.str2) > 0 ? param.str1 : param.str2}<br>
두 문자열이 같나? : ${param.str1 eq para.str2 ? "예" :	"아니오"}<br>
<br><br><br>
<%
	String str1 = request.getParameter("str1");
	String str2 = request.getParameter("str2");
	out.println("입력 문자열 str1 = "+ str1 +"<br>");
	out.println("입력 문자열 str1 = "+ str1 +"<br>");
	out.println("두문자열이 같나요 "+ (str1.equals(str2)? "예" :"아니요"));
%> 
<br>
입력 문자열 str1 : <%= str1  %><br>
입력 문자열 str2 : <%= str2  %><br>
두 문자열이 같나요 : <%= (str1.equals(str2))? "예" : "아니오" %>
</body>
</html>