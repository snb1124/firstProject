<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>LOGIN</title>
<style type="text/css">
	div,h3  {
		 text-align: center;
	}
			
	/* a �±� ���� ���ֱ� */
	a { text-decoration:none }
</style>
<script type="text/javascript">
	
</script>
</head>
<body>
<h3>Login Session Testing :: LOGIN SUCCESS</h3>
<hr>
<% request.setCharacterEncoding("EUC-KR"); %>
<%
	Object obj = request.getAttribute("nCnt");
	if (obj == null) return;
	
	int nCnt = ((Integer)obj).intValue();
	
	if (nCnt == 1){
		String kid = request.getParameter("kid");
%>
		<script>
			alert("<%= kid %> �� �α��� ����");
		</script>
		<div>
  			<a href="/testKsj/login?login_type=LOGOUT&kid=<%= kid %>">�α׾ƿ� �ϱ�</a>
		</div>
<% 		
	}
%>
</body>
</html>