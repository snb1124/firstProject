<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board 게시판 글쓰기 :)</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$(document).on("click", "#sbbtn", function(){
			$('#boardForm').attr({
				'action':'boardInsert.jin',
				'method':'POST',
				'enctype':'multipart/form-data'
			}).submit();
		});
		
	});
</script>
</head>
<body>
<form name="boardForm" id="boardForm">
	<table border="1" align="center">
		<tr>
			<td colspan="2" align="center"> 게시판 글쓰기 </td>
		</tr>
		<tr>
			<td align="center">글번호 </td>
			<td><input type="text" name="knum" id="kunm" size="20" readonly></td>
		</tr>
		<tr>
			<td align="center">제목 </td>
			<td><input type="text" name="ksubject" id="ksubject" size="53" ></td>
		</tr>
		<tr>
			<td align="center">이름 </td>
			<td><input type="text" name="kname" id="kname" size="53" ></td>
		</tr>
		<tr>
			<td align="center">비밀번호 </td>
			<td><input type="password" name="kpw" id="kpw" size="20" ></td>
		</tr>
		<tr>
			<td align="center">내용 </td>
			<td><textarea type="text" name="kcontent" id="kcontent" rows="10"></textarea></td>
		</tr>
		<tr>
			<td align="center">사진</td>
			<td><input type="file" name="kfile" id="kfile"></td>
		</tr>
		<tr>
			<td colspan="2" align="right"></td>
			<td><input type="button" value="글쓰기" id="sbbtn"></td>
		</tr>
	</table>
</form>
</body>
</html>