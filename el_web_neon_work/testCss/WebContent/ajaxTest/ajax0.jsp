<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Ajax</title>

<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	
	$(document).ready(function(){
		
		alert('>>>');
		
		var url = "/testCss/ajaxTest/data0.jsp";
		//req.responseText = ajax���� data
		$.get(url, 
			  function(data){
			  alert("Ajax ��� ���� ��� >>> : " + data);
			  console.log("Ajax ��� ���� ��� >>> : " + data);
			  $('#testData').html("ȭ�鿡 ���� ������ ��� html ver: "  + data);
			  $('#testData1').text("ȭ�鿡 ���� ������ ��� text ver : "  + data);
			  console.log("typeof->"+typeof(data));
		});
		
		

	});
	
</script>
</head>
<body>
	<div id="testData"></div>
	<div id="testData1"></div>
</body>
</html>