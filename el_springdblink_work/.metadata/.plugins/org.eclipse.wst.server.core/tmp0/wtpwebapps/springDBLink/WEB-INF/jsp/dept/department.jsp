<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html> 
<html>
<head>
<meta charset="utf-8">
<title>�а� ���̺�</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

	function insertPopup(){
		alert("insertPopup() >>> : ");
		$("#deptid").val("");			
		window.open("selectDepartment.ksj?deptid=", "", "width=500, height=280");	
		// window.open("", "", "width=500, height=280");	
		$("#popupForm").attr("action", "");		
		$("#popupForm").attr("target", "pop");		
		$("#popupForm").submit();
	}
	
	function updatePopup(deptid){
		alert("updatePopup() >>> : deptid ::: " + deptid);		
		window.open("selectDepartment.ksj?deptid="+deptid, "", "width=500, height=280");
		$("#popupForm").attr("action", "");
		$("#popupForm").attr("target", "pop");
		$("#popupForm").submit();		
	}
	
	function listSearch(deptname){
		alert("listSearch() >>> : ");		
		$("#searchForm").attr("action", "listDepartment.ksj");	
		$("#searchForm").submit();				
	}
	
</script>
</head>
<body>
<form id="popupForm" name="popupForm" method="POST">
	<input type="hidden" name="deptid" id="deptid" />
</form>
<div>
	<table>
		<tr><th><h4>�а����̺�[SPING]</h4></th></tr>
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
		<th>�а��ڵ�</th>
		<th>�а��� </th>
		<th>��ȭ��ȣ</th>
		<th>�󼼺���</th>
	</tr>
</thead>
<tbody>
<c:if test="${empty departmentList}">
<tr>
<td colspan="5" align="center">
��ϵ� �а� ������ �������� �ʽ��ϴ�.
</tr>
</c:if>
<c:forEach items="${departmentList}" var="row">
	<tr>
		<td align="center">${row.deptid}</td>
		<td align="center">${row.deptname}</td>
		<td align="center">${row.depttel}</td>
		<td align="center">
			<input type="button" value="[����/����]" onclick="updatePopup('${row.deptid}')"/>
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
				<input type="text" id="deptname" name="deptname" />
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