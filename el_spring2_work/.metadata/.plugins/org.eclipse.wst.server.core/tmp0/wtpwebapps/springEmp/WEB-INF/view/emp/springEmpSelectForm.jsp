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
			alert(" 검색 버튼 클릭 -> 전체조회 조건검색 컨트롤러로 이동");
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
		<option value="key_00">전체--</option>
		<option value="key_01">사번-------</option>
		<option value="key_02">이름-------</option>
	</select>
	<input type="text" id="keyword" name="keyword" placeholder="검색어입력"><br>
	<input type="text" id="startDate" name="startDate" size="10" placeholder="시작일">
	<input type="text" id="endDate" name="endDate" size="10" placeholder="종료일"><br>
	<input type="button" id="search_btn" name="search_btn" value="검색">
	<input type="reset" id="reset_btn" name="reset_btn" value="리셋"><br>
</form>
</body>
</html>