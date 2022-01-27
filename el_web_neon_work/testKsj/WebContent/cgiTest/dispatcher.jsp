<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>dispather.html</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){

		$("#btnSAll").click(function(){
			alert("btnSAll 진입 >>> : ");			
			var v1 = $("#isudtype").val('SALL');
			console.log("v1 >>> : " + v1.val());
			
			formSubmit(v1);
		});
		
		$("#btnS").click(function(){
			alert("btnS 진입 >>> : ");			
			var v2 = $("#isudtype").val('S');
			console.log("v2 >>> : " + v2.val());
			
			formSubmit(v2);
		});
		
		// submit 
		function formSubmit(isudtype){
			alert("isudtype send >>> : " + isudtype);
			
			$("#locationForm").attr({
				"action":"/testKsj/cgiTest/location?isudtype="+isudtype,
				"method":"GET",
				"enctype":"application/x-www-form-urlencoded"
			}).submit();
		}
	});

</script>
</head>
<body>
<h3>dispather.html</h3>
<hr>
<form id="locationForm" name="locationForm">
	
	<input type="hidden" id="isudtype" name="isudtype"><br>
	
	사번 : <input type="text" id="empno" name="empno"><br>
	사원명 : <input type="text" id="ename" name="ename"><br>
	
	<input type="button" id="btnSAll" value="전체조회">
	<input type="button" id="btnS" value="조건조회">
</form>
</body>
</html>