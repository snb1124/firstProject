<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.catchdog.member.vo.MemberVO" %>
<%
	Object obj = request.getAttribute("IdCheck");
	if (obj == null) return;
	
	ArrayList<MemberVO> result = (ArrayList<MemberVO>)obj;
	int nCnt = result.size();
	
	String mname = "";
	String memail = "";
	String mid = "";
	String mnum = "";
	String minsertdate = "";
	
	for (int i=0; i<result.size(); i++){
		MemberVO mvo = result.get(i);
		
		mname = mvo.getMname();
		memail = mvo.getMemail();
		mid = mvo.getMid();
		mnum = mvo.getMnum();
		minsertdate = mvo.getMinsertdate();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FindPw</title>
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
	$(document).ready(function(){
		$("#button").click(function(){
			let url = "TempPw.cd";
			let midVal = $("#mid").val();
			let memailVal = $("#memail").val();
			let mnumVal = $("#mnum").val();
			
			if (memailVal != "<%= memail%>"){
				alert('등록된 이메일과 일치하지 않습니다.');
				return false;
			}
			$.get(url
				,{"mid": midVal, "memail": memailVal, "mnum": mnumVal}
				,function(data){
					var sVal = $(data).find("result").text();
//					alert(sVal);
					location.href="loginForm.cd";
				});
		});
	});
</script>
</head>
<body>
<jsp:include page="/include/header.jsp" flush="true"></jsp:include>

<form id="FindPw" name="FindPw">
	<div style="width: 100%;height: 250px;border: 1px solid #ccc;border-top:1px solid black;align-items: center;text-align: center;line-height: 40px;padding-top: 45px; margin-top: 35px;">
		<h1 style="font-size: 30px; color: black;">비밀번호 찾기</h1>
		<h2 style="color:black;">회원가입시 등록한 아이디과 이메일로 회원님의 비밀번호를 찾을 수 있습니다.</h2>
		<input type="hidden" name="mnum" id="mnum" value="<%= mnum %>">
		<span style="font-weight: bold; font-size:12px; display:inline-block; width:48%; text-align: right; padding-right: 10px;">아이디 : <%= mid %></span>
		<span style="font-weight: bold; font-size:12px; display:inline-block; width:48%; text-align: left;">가입일 : <%= minsertdate %> </span>
		<input type="text" name="memail" id="memail" placeholder="이메일을 입력하세요"/>
		<input type="button" name="button" id="button" value="임시비밀번호 발송" style="display:inline-block; padding:0 15px; background:#393939; color:#FFF; line-height:30px; font-weight:bold; border:none; cursor:pointer;">
	</div>
</form>
</body>
</html>