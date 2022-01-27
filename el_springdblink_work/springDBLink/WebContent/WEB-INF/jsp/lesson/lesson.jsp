<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html> 
<html>
<head>
<meta charset="utf-8">
<title>���� ���̺�</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

	function insertPopup(){
		alert("insertPopup() >>> : ");
		$("#no").val(0);					
		window.open("", "pop", "width=500, height=280");	
		$("#popupForm").attr("action", "selectLesson.ksj");		
		$("#popupForm").attr("target", "pop");		
		$("#popupForm").submit();
	}
	
	function updatePopup(no){
		$("#no").val(no);
		alert("updatePopup() >>> : no ::: " + no);				
		window.open("", "pop", "width=500, height=280");
		$("#popupForm").attr("action", "selectLesson.ksj");
		$("#popupForm").attr("target", "pop");
		$("#popupForm").submit();		
	}
	
	function listSearch(deptname){
		alert("listSearch() >>> : ");		
		$("#searchForm").attr("action", "listLesson.kpsj");	
		$("#searchForm").submit();				
	}
	
</script>
<style type="text/css">
	table {width: 570px;}
	#searchForm table th{width: 114px;}
	#searchForm table td{width: 104px; text-align:center;}
	#lname {width: 328px;}
</style>
</head>
<body>
<form id="popupForm" name="popupForm" method="POST">
	<input type="hidden" name="no" id="no" />
</form>
<div>
	<table border="0" cellpadding="1" cellspacing="1">
		<tr><th width="650"><h4>���� ���̺�[SPING]</h4></th></tr>
	</table>
</div>
<div>
<table border="1">
<colgroup>
<col width="120px"/>
<col width="220px"/>
<col width="120px"/>
<col width="110px"/>
</colgroup>
<thead>
	<tr>
		<th>��ȣ</th>
		<th>�����ڵ� </th>
		<th>�����</th>
		<th>�󼼺���</th>
	</tr>
</thead>
<tbody>
<c:if test="${empty lessonList}">
<tr>
<td colspan="5" align="center">
��ϵ� ���� �����Ͱ� �������� �ʽ��ϴ�.
</tr>
</c:if>
<c:forEach items="${lessonList }" var="row">
	<tr>
		<td align="center">${row.no}</td>
		<td align="center">${row.lnum}</td>
		<td align="center">${row.lname}</td>
		<td align="center">
			<input type="button" value="[����/����]" onclick="updatePopup('${row.no}')"/>
		</td>
	</tr>
</c:forEach>
<tr>
	<td colspan="3" align="center">ó���� ��ư�� �����ϼ���</td>
	<td align="center">
		<input type="button" onclick="insertPopup()" value="[���]"/>
	</td>
</tr>
</tbody>

<p></p>
<div>
<form id="searchForm" name="searchForm" method="POST">
	<table border="1" cellpadding="1" cellspacing="1">
		<tr>
			<th>�� �� ��</th>
			<td>
				<input type="text" id="lname" name="lname" />
			</td>
			<td>
				<input type="button" onclick="listSearch()" value="�˻�" />
			</td>				
		</tr>
	</table>
</form>
</div>		
</table>	
</div>
</body>
</html>