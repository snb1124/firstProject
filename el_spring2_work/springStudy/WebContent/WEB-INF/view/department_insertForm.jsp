<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>학과테이블</title>
<style type="text/css">
.required{
	color:red;
}
</style>
<script type = "text/javascript">
function insertData() {
	if (!validateForm())
		return;
	if (confirm('등록을 진행하시겠습니까?')) {
		deptForm.action = "/springStudy/department_insert.jin";
		deptForm.submit();
}
}
function validateForm() {
	if (deptForm.deptid.value.replace(/\s/g, "") == "") {
		alert('학과코드를 입력해주세요.');
		return false;
}
	if (deptForm.deptname.value.replace(/\s/g, "") == "") {
		alert('학과명을 입력해주세요.');
		return false;
}
		return true;
}
	</script>
</head>
<body>
	<div>
		<form id="deptForm" name="deptForm" method="POST">
			<table border="1">
				<thead>
					<tr>
						<td colspan="2" align="center">
							<h4>학과 테이블 {spring}</h4>
						</td>
					</tr>	
				</thead>
				<tbody>
					<tr>
						<th width="100">
						<span class="required">*</span>학과코드</th>
						<td>
				<input type="text" id="deptid" name="deptid" size="52"/>
						</td>		
					</tr>	
					<tr>
						<th width="100">
						<span class="required">*</span>학과명 </th>
						<td>
				<input type="text" id="deptname" name="deptname" size="52"/>
						</td>		
					</tr>	
					<tr>
						<th>
						<span class="required">*</span>전화번호</th>
						<td>
				<input type="text" id="depttel" name="depttel" size="52"/>	
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center">
				<input type="button" id="insert" value="등록" onclick="insertData()"/>		
						</td>
					</tr>					
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>