<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원정보 수정</title>
</head>
<body>
<h3>회원정보 수정</h3>
<hr>

<%
System.out.println("멤버 업데이트 jsp 진입");
	Object obj = request.getAttribute("uUpdate");
	if (obj == null) return;
		
	boolean bool = ((Boolean)obj).booleanValue();
	
	if (bool){
		System.out.println("수정 성공  bool >>> : " + bool);
%>
		<script>
			alert("수정성공");
			location.href="/testKsj/mem?ISUD_TYPE=SALL";
		</script>
<%		
	}else{
		
	}
%>
</body>
</html>