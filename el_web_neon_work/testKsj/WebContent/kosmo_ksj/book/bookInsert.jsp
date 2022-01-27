<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>도서정보등록</title>
</head>
<body>
<h3>도서정보 등록</h3>
<hr>
<%
	Object obj = request.getAttribute("nCnt");
	//if(obj==null) return;
	
	int nCnt =((Integer)obj).intValue();
	
	if(nCnt>0){
		System.out.println("입력 성공  ncnt ->"+nCnt);
	
	%>
	<script>
		location.href = "/testKsj/book?isudtype=SALL";
	</script>
	<%
	}else{
	//원래 기존 페이지로 이동시키면 될듯 	
	}
	%>
</body>
</html>