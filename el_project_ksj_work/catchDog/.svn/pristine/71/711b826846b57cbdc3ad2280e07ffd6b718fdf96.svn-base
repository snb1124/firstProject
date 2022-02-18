<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.catchdog.member.vo.MemberVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FindId</title>
<style type="text/css">
	form {
		margin-left: auto !important;
		margin-right: auto !important;
		width: 50%;
		align: center;
	}
</style>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(document).on("click", "#FindPw", function(){
		$("#FindId").attr({
			"action":"IdCheck.cd",
			"method":"POST"
		}).submit();
	});
	
	$(document).on("click", "#Login", function(){
		$("#FindId").attr({
			"action":"loginForm.cd",
			"method":"GET"
		}).submit();
	});
</script>
</head>
<body>
<jsp:include page="/include/header.jsp" flush="true"></jsp:include>
<%
	Object obj = request.getAttribute("result");
	if (obj == null) return;
	
	ArrayList<MemberVO> result = (ArrayList<MemberVO>)obj;
	int nCnt = result.size();
	
	String mname = "";
	String memail = "";
	String mid = "";
	String minsertdate="";
	
	for (int i=0; i<result.size(); i++){
		MemberVO mvo = result.get(i);
		
		mname = mvo.getMname();
		memail = mvo.getMemail();
		mid = mvo.getMid();
		minsertdate = mvo.getMinsertdate();
		
	}
%>
<form name="FindId" id="FindId">
	<div style="width: 100%;height: 250px;border: 1px solid #ccc;border-top:1px solid black; align-items: center; text-align: center;line-height: 40px;padding-top: 45px; margin-top: 35px;">
			<h1 style="font-size: 30px; color: black;">아이디 찾기</h1>
			<h2 style="color:black;">입력하신 정보와 일치하는 아이디입니다.</h2>
			<div style="margin: 10px auto; border-top: 0.5px dashed; border-bottom: 0.5px dashed; width: 80%; display:block;">
				<span style="font-weight: bold; font-size:12px; display:inline-block; width:48%; text-align: right; padding-right: 10px;">아이디 :</span>
				<span style="font-weight: bold; font-size:12px; display:inline-block; width:48%; text-align: left;"> <%= mid %></span>
				<span style="font-weight: bold; font-size:12px; display:inline-block; width:48%; text-align: right; padding-right: 10px;">가입일 :</span>
				<span style="font-weight: bold; font-size:12px; display:inline-block; width:48%; text-align: left;"> <%= minsertdate %></span>
			</div>
			<input type="button" name="Login" id="Login" value="로그인하기" style="display:inline-block; padding:0 15px; background:#393939; color:#FFF; line-height:30px; font-weight:bold; border:none; cursor:pointer;">
			<input type="button" name="FindPw" id="FindPw" value="비밀번호 찾기" style="display:inline-block; padding:0 15px; background:#393939; color:#FFF; line-height:30px; font-weight:bold; border:none; cursor:pointer;">
	</div>
	

</form>
</body>
</html>