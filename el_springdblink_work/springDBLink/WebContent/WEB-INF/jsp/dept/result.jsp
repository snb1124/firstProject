<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>��� ȭ��</title>
<script type="text/javascript">
	
	alert("${result}");
	if ("${result}".indexOf("����") > -1){
		history.go(-1);
	}else{
		opener.listSearch();
		window.close();
	}
</script>
</head>
<body>

</body>
</html>