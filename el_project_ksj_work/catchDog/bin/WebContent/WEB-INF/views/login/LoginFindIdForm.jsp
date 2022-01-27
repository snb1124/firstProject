<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FindIdForm</title>
<style type="text/css">
	form {
		margin-left: auto !important;
		margin-right: auto !important;
		width: 50%;
		align: center;
	}
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		$(document).on("click", "#button", function(){
			$("#FindIdForm").attr({
				"method":"POST",
				"action":"FindId.cd"
			}).submit();
		});
	});
</script>
</head>
<body>
<jsp:include page="/include/header.jsp" flush="true"></jsp:include>
<form name="FindIdForm" id="FindIdForm">
		<div style="width: 100%;height: 250px;border: 1px solid #ccc;border-top:1px solid black;align-items: center;text-align: center;line-height: 40px;padding-top: 45px; margin-top: 35px;">
			<h1 style="font-size: 30px; color: black;">아이디 찾기</h1>
			<h2 style="color:black;">회원가입시 등록한 이름과 이메일로 회원님의 아이디를 찾을 수 있습니다.</h2>
			<input type="text" name="mname" id="mname" placeholder="이름 입력"><br>
			<input type="text" name="memail" id="meamil" placeholder="이메일 입력"><br>
			<input type="button" name="button" id="button" value="찾기" style="display:inline-block; padding:0 15px; background:#393939; color:#FFF; line-height:30px; font-weight:bold; border:none; cursor:pointer;">
		</div>
	</form>
</body>
</html>