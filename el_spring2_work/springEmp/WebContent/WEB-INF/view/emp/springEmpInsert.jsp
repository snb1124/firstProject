<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import ="a.b.c.com.emp.vo.SpringEmpVO" %>
<%@ page import ="java.util.List" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>springEmpInsert</title>
</head>
<body>
<h3>springEmpInsert</h3>
<hr>
<%
	Object obj= request.getAttribute("insertCnt");
	if(obj == null){return;}
	int nCnt = (Integer)obj;
	out.println(nCnt+"건이  입력 완료 되었습니다.");
%>


</body>
</html>