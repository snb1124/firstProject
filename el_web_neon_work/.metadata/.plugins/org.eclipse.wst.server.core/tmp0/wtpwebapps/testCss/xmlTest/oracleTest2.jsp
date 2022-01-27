<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingException" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>OracleTest</title>
</head>
<body>
<!-- 
	JNDI InitalContext
	JNDI : Java Naming and Directory Interface	
	JNDI 는 자바에서 자기 컴퓨터(서버) 또는 다른 컴퓨터(다른 서버)의
	디렉토리를(디렉토리에있는 파일을) 이름으로 찾아가는 서비스이다. 
 -->
<h3>
	JNDI InitalContext <br>
	JNDI : Java Naming and Directory Interface   
</h3>
<hr>
<%
	
	
	Context context = new InitialContext();
	DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g_orclKOSMO00");

	Connection conn = dataSource.getConnection();
	PreparedStatement stmt = conn.prepareStatement("SELECT * FROM EMP");
	ResultSet rsRs = stmt.executeQuery();
	
	while (rsRs.next()){
		out.println(rsRs.getString(1) + " ");
		out.println(rsRs.getString(2) + " ");
		out.println(rsRs.getString(3) + " ");
		out.println(rsRs.getString(4) + " ");
		out.println(rsRs.getString(5) + " ");
		out.println(rsRs.getString(6) + " ");
		out.println(rsRs.getString(7) + " ");
		out.println(rsRs.getString(8) + " <br>");
	}

%>

</body>
</html>