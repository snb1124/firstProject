<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import ="java.sql.Connection" %>
<%@ page import ="java.sql.DriverManager" %>
<%@ page import ="java.sql.Statement" %>
<%@ page import ="java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>DB ����</title>
</head>
<body>
<%
String empno = request.getParameter("empno");
String ename = request.getParameter("ename");

String _empno = "";
String _ename = "";
%>
<%
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orclKOSMO00", "scott","1234");
Statement stmt = conn.createStatement();
ResultSet rsRs = stmt.executeQuery("SELECT * FROM EMP WHERE EMPNO = "+empno+"AND ENAME="+"'"+ename+"'");
while (rsRs.next()){
	_empno = rsRs.getString(1);
	_ename = rsRs.getString(2);
	
}

if (empno.equals(_empno) && ename.equals(_ename)){
%>	
	<script>
	alert("�α��μ���");
	location.href="testKsj/cgiTest/testjsp_1.jsp";
	</script>
<% 
	out.println("�α��μ���");
}else{
%>
	<script>
		alert("�α��ν���");
		history.go(-1);
		</script>
		<% 
		out.println("�α��ν���");
}
%>
</body>
</html>