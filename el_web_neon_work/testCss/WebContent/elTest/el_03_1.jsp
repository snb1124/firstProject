<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCYTPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>el_03_1</title>
</head>
<body>
<h3>el_03_1</h3>
<hr>
<%
	String irum = request.getParameter("irum");
	out.println("[��ũ��ƮŬ��]<br>");
	out.println(irum+"ȸ������ Ű������ ������ ");
	
	String[]animal = request.getParameterValues("animal");
	if(animal !=null){
		for(int i = 0; i< animal.length; i++){
			if(i != animal.length -1){
				out.println(animal[i]+",");
			}else{
				out.println(animal[i]+"�Դϴ�<br>");
			}
		}
	}else {
		out.println("�����Ͻ� ������ �����ϴ�. <br>");
	}
%>
[EL ����]<br>
${param.irum} ȸ���� ���� Ű��� ���� �ֿϵ����� <br>
${paramValues.animal[0]}
${paramValues.animal[1]}
${paramValues.animal[2]}
${paramValues.animal[3]}
${paramValues.animal[4]}
${paramValues.animal[5]} �Դϴ� 
 
</body>
</html>