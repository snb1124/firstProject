<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="a.b.c.com.emp.vo.SpringEmpVO" %>
<%@ page import="java.util.List" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>EMP SELECT ALL</title>
</head>
<body>
<h3>EMP SELECT ALL : jsp </h3>
<hr>
<%
	Object obj = request.getAttribute("listAll");
	if (obj == null){ return; }
	
	List<SpringEmpVO> list = (List<SpringEmpVO>)obj;
	if (list.size() > 0){
		for (int i=0; i < list.size(); i++){
			SpringEmpVO evo = list.get(i);
%>
			<%= evo.getEmpno() %>			
			<%= evo.getEname() %>
			<%= evo.getHiredate() %><br>
<%			
			//out.println(evo.getEmpno());
			//out.println(evo.getEname());
			//out.println(evo.getHiredate() + "<br>");
		}
	}
%>

<h3>EMP SELECT ALL : jstl & el </h3>
<hr>
	<c:forEach items="${listAll}" var="emp">
		${emp.empno}
		${emp.ename}
		${emp.hiredate}<br>
	</c:forEach>
		
<h3>EMP SELECT ALL : jsp & el </h3>
<hr>	
<%
	Object obj1 = request.getAttribute("listAll");
	if (obj1 == null){ return; }
	
	List<SpringEmpVO> list1 = (List<SpringEmpVO>)obj1;
	pageContext.setAttribute("list11", list1);	
	
%>
		${list11[0].empno } ${list11[0].ename } ${list11[0].hiredate }<br>
		${list11[1].empno } ${list11[1].ename } ${list11[1].hiredate }<br>
		${list11[2].empno } ${list11[2].ename } ${list11[2].hiredate }<br>
		${list11[3].empno } ${list11[3].ename } ${list11[3].hiredate }<br>
		${list11[4].empno } ${list11[4].ename } ${list11[4].hiredate }<br>
		${list11[5].empno } ${list11[5].ename } ${list11[5].hiredate }<br>
		${list11[6].empno } ${list11[6].ename } ${list11[6].hiredate }<br>
		${list11[7].empno } ${list11[7].ename } ${list11[7].hiredate }<br>
		${list11[8].empno } ${list11[8].ename } ${list11[8].hiredate }<br>
		${list11[9].empno } ${list11[9].ename } ${list11[9].hiredate }<br>
		${list11[10].empno } ${list11[10].ename } ${list11[10].hiredate }<br>
		
		
		
		
</body>
</html>