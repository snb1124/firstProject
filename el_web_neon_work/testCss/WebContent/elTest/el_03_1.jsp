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
	out.println("[스크립트클립]<br>");
	out.println(irum+"회원님이 키우고싶은 동물은 ");
	
	String[]animal = request.getParameterValues("animal");
	if(animal !=null){
		for(int i = 0; i< animal.length; i++){
			if(i != animal.length -1){
				out.println(animal[i]+",");
			}else{
				out.println(animal[i]+"입니다<br>");
			}
		}
	}else {
		out.println("선택하신 사항이 없습니다. <br>");
	}
%>
[EL 문법]<br>
${param.irum} 회원님 께서 키우고 싶은 애완동물은 <br>
${paramValues.animal[0]}
${paramValues.animal[1]}
${paramValues.animal[2]}
${paramValues.animal[3]}
${paramValues.animal[4]}
${paramValues.animal[5]} 입니다 
 
</body>
</html>