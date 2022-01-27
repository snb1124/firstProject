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
		//req.responseText = ajax에서 data
		$.get(url, 
			  function(data){
			  alert("Ajax 통신 성공 결과 >>> : " + data);
			  console.log("Ajax 통신 성공 결과 >>> : " + data);
			  $('#testData').html("화면에 리턴 데이터 출력 html ver: "  + data);
			  $('#testData1').text("화면에 리턴 데이터 출력 text ver : "  + data);
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