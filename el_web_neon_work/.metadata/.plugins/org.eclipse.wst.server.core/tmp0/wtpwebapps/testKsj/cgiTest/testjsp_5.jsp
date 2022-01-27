<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<html>
<head>
<meta charset="EUC-KR">
<title>클라이언트와 서버정보 </title>
</head>
<body>
<h3> 클라이언트와 서버정보</h3>
<hr>
<%
	//jsp 스크립틀리에서 request 내장형 오브젝트 (built in Obejct)를 선언하면
	//HttpServletRequest 인터페이스에 있는 자원을 사용할 수 있다. 
	String remoteAddr = request.getRemoteAddr();
	out.println("remoteAddr"+remoteAddr+"<br>");
	System.out.println("remoteAddr"+remoteAddr+"<br>");
	String protocol = request.getProtocol();
	out.println("protocol"+protocol+"<br>");
	System.out.println("protocol"+protocol+"<br>");
	String method = request.getMethod();
	out.println("method"+method+"<br>");
	System.out.println("method"+method+"<br>");
	String uri = request.getRequestURI();
	out.println("uri"+uri+"<br>");
	System.out.println("uri"+uri+"<br>");
	String url = request.getRequestURL().toString();
	out.println("url"+url+"<br>");
	System.out.println("url"+url+"<br>");
	String context = request.getContextPath();
	out.println("context"+context+"<br>");
	System.out.println("context"+context+"<br>");
	
	String serverName=request.getServerName();
	out.println("serverName"+serverName+"<br>");
	System.out.println("serverName"+serverName+"<br>");

	String serverPort = String.valueOf(request.getServerPort());
	out.println("serverPort"+serverPort+"<br>");
	System.out.println("serverPort"+serverPort+"<br>");	
	
	String remotePort = String.valueOf(request.getRemotePort());
	out.println("remotePort"+remotePort+"<br>");
	System.out.println("remotePort"+remotePort+"<br>");
	
%>
<!-- http://192.168.219.115:8088/testKsj/cgiTest/testjsp_5.jsp -->
</body>
</html>