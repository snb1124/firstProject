<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>el_05</title>
</head>
<body>
<h3>el_05</h3>
<hr>
�Է� ���ڿ� str1 : ${param.str1}<br>
�Է� ���ڿ� str2 : ${param.str2}<br>
���ڿ� ��� �� : ${param.str1.compareTo(param.str2) > 0 ? param.str1 : param.str2}<br>
�� ���ڿ��� ����? : ${param.str1 eq para.str2 ? "��" :	"�ƴϿ�"}<br>
<br><br><br>
<%
	String str1 = request.getParameter("str1");
	String str2 = request.getParameter("str2");
	out.println("�Է� ���ڿ� str1 = "+ str1 +"<br>");
	out.println("�Է� ���ڿ� str1 = "+ str1 +"<br>");
	out.println("�ι��ڿ��� ������ "+ (str1.equals(str2)? "��" :"�ƴϿ�"));
%> 
<br>
�Է� ���ڿ� str1 : <%= str1  %><br>
�Է� ���ڿ� str2 : <%= str2  %><br>
�� ���ڿ��� ������ : <%= (str1.equals(str2))? "��" : "�ƴϿ�" %>
</body>
</html>