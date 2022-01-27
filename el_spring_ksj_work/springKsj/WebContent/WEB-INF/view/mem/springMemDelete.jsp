<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>delete</title>
</head>
<body>
Update
<hr>
<%
	Object obj = request.getAttribute("nCnt");
	int nCnt = (Integer)obj;
	out.println("삭제 완료 건수 "+nCnt);
%>


<script type="text/javascript">
 	location.href = "/springKsj/springMemSelectAll.jin";
</script>

</body>
</html>