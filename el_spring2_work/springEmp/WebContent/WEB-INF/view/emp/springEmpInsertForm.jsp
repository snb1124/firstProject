<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>springEmpInsertForm</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$(document).on("click", "#insertBtn", function(){
			console.log("insertBtn->>");
			
			$("#springEmpInsert").attr({
				"action":"springEmpInsert.k",
				"method":"GET",
				"enctype":"application/x-www-form-urlencoded"
			}).submit();
		});
	});
</script>

</head>
<body>
	<h3>springEmpInsertForm</h3>
<form name="springEmpInsert" id ="springEmpInsert">
	<table border="1" class="align">
		<tr>
			<td colspan="2" class="align">EMP �Է�</td>
		</tr>	
		<tr>
			<td class="align">�����ȣ</td>
			<td><input type="text" name="empno" id="empno" size="20"></td>
		</tr>
		<tr>
			<td class="align">����̸�</td>
			<td><input type="text" name="ename" id="ename" size="20"></td>
		</tr>
		<tr>
			<td class="align">�Ի���</td>
			<td><input type="text" name="hiredate" id="hiredate" size="20"></td>
		</tr>	
		<tr>
			<td colspan="2" class="align">
			<input type="button" value="EMP_�Է�" id="insertBtn">
			</td>
		</tr>	
	</table>
</form>
</body>
</html>