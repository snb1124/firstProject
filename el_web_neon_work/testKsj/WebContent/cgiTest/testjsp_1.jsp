<!-- 
contentType : ���� jsp ������ �������¿� ���ڵ� ����
text/html : MIME : �� ���� �������� html ������ �ϰ� �ִ�.
MIME : Multipurose Internet Mail Extensions : ���ڿ����� ���� ���ͳ� ǥ�� ����. 
		������ ���� �� ���ڵ� ���� ǥ��   https://ko.wikipedia.org/wiki/MIME �� �о��
charset="EUC-KR" : ���� jsp �������� ���ڵ��� EUC-KR �̴�. ->jsp�� ���õ� �ڵ常 EUC-KR�� ���ڵ��ϰڴ� �� �ٸ��� ����
 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"  pageEncoding="EUC-KR"%>
<!-- jsp���Ͽ� ��ü �ҷ�����  jre api�� �ֱ⶧���� ���� ,-->
<%@ page import="java.util.Date" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
<!-- ���� ������ html ���ڵ��� EUC-KR�̴�. -->
<meta charset="EUC-KR">
<title>jsp �±�Ʋ</title>
</head>
<body>
<h3>JSP �±�(���,������Ʈ) ����</h3>
<hr>
<%-- jsp �ּ� : ��������(Ŭ���̾�Ʈ)�� �Ѿ�� �ʴ´�.--%>
<% out.println("�̰��� ��ũ��Ʋ�� �����̴�. <br>");
   out.println("�ڹ� �ڵ带 �����ϸ� �ȴ�. <br>");
   out.println("1.jsp ������ ������Ʈ : request, response<br>");
   out.println("2. Servlet �ڵ�<br>");
   out.println("3. java �ڵ� <br>");
   out.println("4. ���α׷� ���� ����� Ŭ���̾�Ʈ�� �����Ѵ�. <br>");
   out.println(new Date());
%>
<%= "�̰��� ǥ���� �����̴�." %>
<%= "�ϴ� ������ �������� ����� ����Ѵ�." %>
<%= "��ũ��Ʋ�� �������� ����ϴ� out.println()�� ������ ����� �Ѵ�" %>
<%--�ҷ��� ��ü ����ϱ�  --%>
<%= new Date() %><br>
<!-- ���� ������ footer �뵵�� ����Ѵ�. �������� �ҷ����µ� ������ �Ұ����ϴ�. -->
<%@ include file="testjsp.jsp" %>
</body>
</html>