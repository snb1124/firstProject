<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingException" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="a.b.c.com.cgi.session.K_Session"%>

<% 
	String mid = request.getParameter("mid");
	String mpw = request.getParameter("mpw");
	System.out.println(mid);
	System.out.println(mpw);
	
	int nCnt =0;
	boolean result = false;
	
	Context context = new InitialContext();
	DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g_orclKOSMO00");
	Connection conn = dataSource.getConnection();
	
	String sqls = "SELECT COUNT(A.MID) NCNT FROM SPRING_MEMBER A WHERE A.MID = ? AND A.MPW = ?";
	PreparedStatement pstmt = conn.prepareStatement(sqls);
	
	pstmt.setString(1, mid);
	pstmt.setString(2, mid);
	ResultSet rsRs = pstmt.executeQuery();
	
	while (rsRs.next()){
		nCnt = rsRs.getInt(1);
	}
	if (nCnt == 1) result = true;
%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 정보 처리하기</title>
</head>
<body>

<%
	if(result){
		K_Session ks = K_Session.getInstance();
		String kID = ks.getSession(request);
		if(kID !=null && kID.equals(mid)){
			out.println("이미 로그인 중 입니다");
			%>
	<script>
		alert("안녕하세요 :<%=mid%>님 이미 로그인 중 입니다.");
	
	</script>
	
	
		}
		
	}


</body>
</html>