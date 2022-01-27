<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>include Action tag</h2>
actionInclude.jsp<br>
<jsp:include page="c_subInclude.jsp"/>

<p><br>
c_actionInclude.jsp 파일 끝 부분이다.<br>
<jsp:include page="c_subInclude.jsp">
	<jsp:param value="aaa" name="id"/>
	<jsp:param value="aaa00" name="pw"/>
</jsp:include>

<%
	String id1 = request.getParameter("id");
	String pw1 = request.getParameter("pw");
%>
<br>
<%= "c_actionInclude.jsp ::: id1 >>> : " + id1 %><br>
<%= "c_actionInclude.jsp ::: pw1 >>> : " + pw1 %>


</body>
</html>