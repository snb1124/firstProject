<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ������ ����</title>
</head>
<body>
<h3>ȸ������ ����</h3>
<hr>

<%
System.out.println("��� ������Ʈ jsp ����");
	Object obj = request.getAttribute("uUpdate");
	if (obj == null) return;
		
	boolean bool = ((Boolean)obj).booleanValue();
	
	if (bool){
		System.out.println("���� ����  bool >>> : " + bool);
%>
		<script>
			alert("��������");
			location.href="/testKsj/mem?ISUD_TYPE=SALL";
		</script>
<%		
	}else{
		
	}
%>
</body>
</html>