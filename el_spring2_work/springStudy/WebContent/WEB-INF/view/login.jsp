<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>로그인 만들기 </title>
<style type="text/css">
div{
	font:12px"굴림";
}
</style>
</head>
<body>
	<div align="center" class="body">
		<h3>로그인 입력 화면</h3>
			<form:form commandName="userVO" method="POST">
				<table width="250" border="1">
					<tr>
						<th>id</th>
						<td><form:input path="mid"/></td>
					</tr>
					<tr>
						<th>pw</th>
						<td><form:password path="mpw"/></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit" value="로그인"></td>
					</tr>
				</table>		
			</form:form>
		</div>
		
	
</body>
</html>