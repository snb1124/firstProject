<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>model return test</title>
</head>
<body>
<h3>el</h3>
${modeldata}
<hr>

<h3>자바사용</h3>
<%
	String modeldata = String.valueOf(request.getAttribute("modeldata"));
	out.println("modeldata->>>>"+modeldata);
%>

</body>
</html>