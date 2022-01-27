<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MEMBER INSERT</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		alert($("#mnum").val());
		$("#memberForm").submit();
	})
</script>
</head>
<body>
	<form name="memberForm" id="memberForm" method="post" action="recommendForm.cd">
		<input type="hidden" name="mnum" id="mnum" value="<%= request.getAttribute("mnum") %>"/>
	</form>
</body>
</html>