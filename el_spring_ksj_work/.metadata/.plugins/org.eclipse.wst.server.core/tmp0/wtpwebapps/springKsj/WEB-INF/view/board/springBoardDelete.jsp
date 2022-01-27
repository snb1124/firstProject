<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>delete</title>
</head>
<body>
<h3>삭제 성공</h3>
<hr>

<%
	Object obj = request.getAttribute("nCnt");
	int nCnt = (Integer)obj;
%>
	<script>
		alert("삭제 성공한 건수는 "+<%= nCnt %>+"입니다");
		location.href="/springKsj/boardSelectAll.jin"
	</script>
	
	
</body>
</html>