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
System.out.println("�μ�Ʈ �ΰ� 1");
Object obj = request.getAttribute("bInsert");
if(obj== null){
	System.out.println("�����Ͱ� ����� �Ѿ���� ���߽��ϴ�. from insert.jsp");
}
boolean bool = ((Boolean)obj).booleanValue();
System.out.println("�μ�Ʈ�ΰ�2");
if (bool){
	System.out.println("������ �Է� ����");

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