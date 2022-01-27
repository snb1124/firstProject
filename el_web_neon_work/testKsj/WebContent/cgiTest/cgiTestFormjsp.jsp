<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.Enumeration" %>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>cgiformjsp</h3>
<hr>
<% request.setCharacterEncoding("EUC-KR"); %>
<%
  
	Enumeration<String> em = request.getHeaderNames();
	while(em.hasMoreElements()){
	String name = em.nextElement();
	String value = request.getHeader(name);
	out.println(name+":"+value+"<br>");
	System.out.println(name+":"+value);
	
}
%>
<h3>getParameter</h3>
<hr>

<%
 String method = request.getMethod();
 String isudtype = request.getParameter("isudtype");
 if(isudtype!=null) isudtype.toUpperCase();
 if(isudtype!=null&&isudtype.length() >0){
	 System.out.println("isudtype ->"+isudtype);
	 System.out.println("method->"+method);
	 
	 if("I".equals(isudtype)){
		 String name= request.getParameter("mname");
		 String mid = request.getParameter("mid");
		 String mpw = request.getParameter("mpw");
		 String mgender = request.getParameter("mgender");
		 String mhobby = "";
		 String hobby[] = request.getParameterValues("mhobby");
		 if(hobby !=null){
			 for(int i=0; i<hobby.length; i++){
				 mhobby+=hobby[i]+",";
			 }
			 System.out.println("mname->"+name);
			 System.out.println("mid->"+mid);
			 System.out.println("mgender->"+mgender);
			 System.out.println("mhobby->"+mhobby);
			 
		 }
	 }else{
		 System.out.println("데이터를 잘 넘겨라");
	 }
	 String mlocal = request.getParameter("mlocal");
	 String mmsg = request.getParameter("mmsg");
	 

	 
	 
 }
%>
</body>
</html>