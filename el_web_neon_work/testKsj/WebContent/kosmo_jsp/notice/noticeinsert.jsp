<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ȸ������ JSP</title>



</head>
<body>
<h3>�Խ��� JSP </h3>
<hr>
<%-- �ѱ� ���ڵ� : form �±��� method�� ���� POST �� �� �����Ѵ�. --%>
<% request.setCharacterEncoding("EUC-KR"); %>

<%
	String isud_type = request.getParameter("ISUD_TYPE");
	String nnum = request.getParameter("nnum");
	String nsubject = request.getParameter("nsubject");	
	String nmemo = request.getParameter("nmemo");
	String nphoto = request.getParameter("nphoto");	
	
	System.out.println("isud_type >>> : " + isud_type);
	System.out.println("nnum >>> : " + nnum);
	System.out.println("nsubject >>> : " + nsubject);
	System.out.println("nmemo >>> : " + nmemo);
	System.out.println("nphoto >>> : " + nphoto);	
%>


</body>
</html>