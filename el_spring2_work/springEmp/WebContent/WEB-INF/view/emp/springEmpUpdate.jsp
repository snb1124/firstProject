<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>springEmpUpdate</title>
</head>
<body>
<%
	Object obj = request.getAttribute("updateCnt");
	int nCnt = (Integer)obj;
	out.println(nCnt+"���� �Է� �Ǿ����ϴ�. ");
%>

</body>
</html>