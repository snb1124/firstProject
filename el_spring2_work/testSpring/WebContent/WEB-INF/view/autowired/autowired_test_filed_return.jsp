<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>autowired_test_filed_return</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		$(document).on("click", "#getbtn", function(){
			console.log("getbtn ����");
			
			$("#formData").attr({
				"action":"autowired_test_get_file.ksj",
				"method":"GET",
				"ectype":"application/x-www-form-urlencoded"
			}).submit();
			});
	})

</script>
</head>
<body>
	<h3 align="left">�������� �ʵ忡 ����.</h3>
	<hr>
	<form name="formData" id="formData">
		<table>
			<tr>
				<td>ȸ����ȣ : </td>
				<td><input type="text" name="datanum" id="datanum"></td>
			</tr>
			<tr>
				<td>ȸ��id : </td>
				<td><input type="text" name="dataid" id="dataid"></td>
			</tr>
			<tr>
				<td>ȸ��pw : </td>
				<td><input type="text" name="datapw" id="datapw"></td>
			</tr>
			<tr>
				<td>ȸ���̸� : </td>
				<td><input type="text" name="dataname" id="dataname"></td>
			</tr>
			<tr>
				<td colspan="2"> 
					<button type="button" id="getbtn">get autowired filed</button>
				</td>
			</tr>
		</table>
	
	</form>

</body>
</html>