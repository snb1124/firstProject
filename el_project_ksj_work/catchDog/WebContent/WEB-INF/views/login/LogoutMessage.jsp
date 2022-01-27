<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LogoutMessage</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
<%
session.invalidate();
%>
alert("로그아웃 되었습니다.");
location.href="/loginForm.cd";
</script>
</head>
<body>

</body>
</html>