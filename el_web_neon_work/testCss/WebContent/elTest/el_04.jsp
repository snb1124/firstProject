<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%
	//parseInt�Լ��� null�� ������� �ʾ� ����, getParameter�� ����Ѵ�.
	int num1 = Integer.parseInt(request.getParameter("num1"));
	int num2 = Integer.parseInt(request.getParameter("num2"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>el_04</title>
</head>
<body>
<h3>el_04</h3>
<hr>
<!-- el_04.jsp?num1=20&num2=10 -->
num1�� ��(JSP) : <%=num1 %><br />
num2�� ��(JSP) : <%=num2 %><br />
<br />
num1�� ��(EL) : ${param.num1 }<br /> <!-- ${num1 }�� ���ε� ��ü�� ��� ��µ��� �ʴ´�. -->
num2�� ��(EL) : ${param.num2 }<br /> <!-- request.getParameter()�� ������ ��ü�� ��� ��µȴ� -->
num1 + num2(�߸��� �ڵ�) : ${param.num1 } + ${param.num2 }<br />
<br />
[��Ģ ����]<br />
num1 + num2 : ${param.num1 + param.num2 }<br />
num1 - num2 : ${param.num1 - param.num2 }<br />
num1 * num2 : ${param.num1 * param.num2 }<br />
num1 / num2 : ${param.num1 / param.num2 }<br />
num1 % num2 : ${param.num1 % param.num2 }<br />
<br />
[�� ����]<br />
num1�� �� Ů�ϱ�? : ${param.num1 - param.num2 > 0 }<br />
num1�� �� Ů�ϱ�? : ${param.num1 > param.num2 }<br />
num1�� �� Ů�ϱ�? : ${param.num1 gt param.num2 }<br />
num1�� �� Ů�ϱ�? : ${param.num1 gt param.num2 ? "��" : "�ƴϿ�" }<br />
<br />
num1�� num2�� �����ϱ�? : ${param.num1 == param.num2 }<br />
num1�� num2�� �����ϱ�? : ${param.num1 eq param.num2 }<br />
<!-- 
> 	: gt
>= 	: ge
==	: eq
<=	: le
<	: lt
!=	: ne
 -->
</body>
</html>