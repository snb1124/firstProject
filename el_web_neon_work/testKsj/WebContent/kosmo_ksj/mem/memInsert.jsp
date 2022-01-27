<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert</title>
</head>
<body>
<h3>Insert</h3>
<hr>
<%
System.out.println("인서트 로고 1");
Object obj = request.getAttribute("bInsert");
if(obj== null){
	System.out.println("데이터가 제대로 넘어오지 못했습니다. from insert.jsp");
}
boolean bool = ((Boolean)obj).booleanValue();
System.out.println("인서트로고2");
if (bool){
	System.out.println("데이터 입력 성공");

%>
<script>
location.href="/testKsj/mem?ISUD_TYPE=SALL";
</script>
<%
}else{
	
}
%>
</body>
</html>