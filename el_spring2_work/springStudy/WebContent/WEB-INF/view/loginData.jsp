<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>로그인 확인 화면</title>
</head>
<body>
	<div align="center" class="body">
		<h3>로그인 입력 데이터</h3>
		<table width="250" border="1">
			<tr>
				<td>id :</td>
				<td align="center"><b>${userVO.mid}</b></td>
			</tr>
			<tr>
				<td>pw :</td>
				<td align="center"><b>${userVO.mpw}</b></td>
			</tr>
		</table>
	</div>


</body>
</html>