<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>springEmpUpdateForm</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
		$(document).on("click", "#updatebtn", function(){
			console.log("updateBtn->>>>>>>");
			
			$('#springEmpUpdate').attr({
				'action':'springEmpUpdate.k',
				'method':'GET',
				'enctype':'application/x-www-form-urlencoded'
			}).submit();	
		});
	});
</script>
</head>
<body>
<h3>springEmpUpdateForm</h3>
<hr>
<form name="springEmpUpdate" id="springEmpUpdate">
<table border="1" class="align">
	<tr>
		<td colspan="2" class="align">EMP ����</td>
	</tr>
	<tr>
		<td class="align">�����ȣ </td>
		<td><input type="text" name="empno" id="empno" size="20"></td>
	</tr>
	<tr>
		<td class="align">����̸� </td>
		<td><input type="text" name="ename" id="ename" size="20"></td>
	</tr>
	<tr>
		<td class="align">�Ի��� </td>
		<td><input type="text" name="hiredate" id="hiredate" size="20"></td>
	</tr>
	<tr>
		<td colspan="2" class="align">
		<input type="button" value="EMP����" id="updatebtn">	
		</td>
	</tr>		
</table>
</form>
</body>
</html>