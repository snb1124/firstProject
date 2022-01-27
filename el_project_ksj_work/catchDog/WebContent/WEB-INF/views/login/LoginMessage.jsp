<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.catchdog.common.K_Session" %>
<%@ page import="java.util.Map" %>
<%
	K_Session ks = K_Session.getInstance();
	Map<String,Object> ssMap = ks.getSession(request);
	String userName = "";
	if(ssMap.get("ssMnum") != null){
		userName = (String) ssMap.get("ssMname");
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Message</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
<% if("Y".equals((String)request.getAttribute("loginYN"))){%>
alert("☆★☆★ <%=userName %>" + ' 님 환영합니다 ☆★☆★');
location.href="/";
<% } else { %>
alert('로그인 정보가 일치하지 않습니다 .');
location.href="/loginForm.cd";
<% } %>
</script>
</head>
<body>
</body>
</html>