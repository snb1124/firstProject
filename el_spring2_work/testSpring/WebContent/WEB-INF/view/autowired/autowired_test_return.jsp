<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>AUTOWIRED TEST</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		// alert("ready >>> : ");
		
		// GET ���
		$(document).on("click", "#getbtn", function(){
			alert("getbtn >>> : ���� ");
			
			$("#formData").attr({
				"action":"autowired_test_get.ksj",
				"method":"GET",
				"enctype":"application/x-www-form-urlencoded"
			}).submit();		
		});		
	})

</script>
</head>
<body>
FORM DATA AUTOWIRED
<hr>
<form name="formData" id="formData">
ȸ����ȣ : <input type="text" name="datanum" id="datanum"><br>
���̵� : <input type="text" name="dataid" id="dataid"><br>
��й�ȣ : <input type="text" name="datapw" id="datapw"><br>
�̸� : <input type="text" name="dataname" id="dataname"><br>
<button type="button" id="getbtn">GET AUTOWIRED</button>
</form>
</body>
</html>