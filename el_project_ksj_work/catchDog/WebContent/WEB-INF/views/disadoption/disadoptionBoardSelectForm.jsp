<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>	
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript">
	//location.href="/disadoptionBoardSelectAll.cd";
	
	 $(document).ready(function(){
		 $("#disadoptionBoardSelectAll").attr({ "method":"POST"
	         ,"action":"disadoptionBoardSelectAll.cd"}).submit();
		});
</script>
<form name="disadoptionBoardSelectAll" id="disadoptionBoardSelectAll"></form>
</body>
</html>