<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

<% if("N".equals((String)request.getAttribute("IdCheck"))){%>
alert('입력하신 아이디를 찾을 수 없습니다');
history.back();
<%}  %>

</script>
</head>
<body>

</body>
</html>