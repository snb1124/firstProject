<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="a.b.c.com.vo.FormDataVO" %>
<%@ page import="java.util.List" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>autowired_test_get_return</title>
</head>
<body>
<h3> autowired_test_get_return </h3>
<hr>

<%
	Object obj = request.getAttribute("list");
	if(obj==null) return;
	
	List<FormDataVO>list=(List)obj;
	if(list.size()>0){
		FormDataVO fdvo = list.get(0);
		out.println("fdvo.getDatanum()->>>>>>"+fdvo.getDatanum());
		out.println("fdvo.getDataid()->>>>>>"+fdvo.getDataid());
		out.println("fdvo.getDatapw()->>>>>>"+fdvo.getDatapw());
		out.println("fdvo.getDataname()->>>>>>"+fdvo.getDataname());
	}
%>
<hr>
el���� �ǳ�?...
$ {fvo.getDataid() } �� ��� �ȵ�
$ {fdvo.getDataid() } �� ��� �ȵ� 
${list.get(0)}	�� �ּҰ��� ��µ� 
${list.get(0).getDatanum()} ü�̴� �Լ��� ��¿Ϸ� 
</body>
</html>