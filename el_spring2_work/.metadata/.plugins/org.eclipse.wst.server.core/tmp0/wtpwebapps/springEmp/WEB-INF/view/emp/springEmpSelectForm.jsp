<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>EMP SELECT FORM</title>
<link rel="stylesheet" href="/springEmp/calendar_datepicker/jquery-ui-1.12.1/jquery-ui.min.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="/springEmp/calendar_datepicker/jquery-ui-1.12.1/jquery-ui.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		alert("->>")
		$("#search_btn").click(function(){
			alert(" �˻� ��ư Ŭ�� -> ��ü��ȸ ���ǰ˻� ��Ʈ�ѷ��� �̵�");
			$("#empSearchForm").attr({
				"method":"GET",
				"action":"springEmpSelect.k"
			}).submit();
		});	
		$("#startDate").datepicker({
			showOn:"button",
			buttonImage:"/springEmp/calendar_datepicker/images/calendar.gif",
			dateFormat: 'yy-mm-dd',
			buttonImageOnly: false,
			buttonText:"Select date"
			});
		
		$("#endDate").datepicker({
			showOn:"button",
			buttonImage:"/springEmp/calendar_datepicker/images/calendar.gif",
			dateFormat:'yy-mm-dd',
			buttonImageOnly:false,
			buttonText:"Select date"
		});
		
	});
</script>
</head>
<body>
<h3> EMP SELECT FORM </h3>
<hr>

<form naem="empSearchForm" id="empSearchForm">
	<select id="searchFilter" name="searchFilter">
		<option value="key_00">��ü--</option>
		<option value="key_01">���-------</option>
		<option value="key_02">�̸�-------</option>
	</select>
	<input type="text" id="keyword" name="keyword" placeholder="�˻����Է�"><br>
	<input type="text" id="startDate" name="startDate" size="10" placeholder="������">
	<input type="text" id="endDate" name="endDate" size="10" placeholder="������"><br>
	<input type="button" id="search_btn" name="search_btn" value="�˻�">
	<input type="reset" id="reset_btn" name="reset_btn" value="����"><br>
</form>
</body>
</html>