<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>REVIEW BOARD: 입양후기 게시판 : 글쓰기</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		$(document).on("click", "#rbbtn", function(){
			console.log("rbbtn >>> : ");	
			$('#reviewForm').attr({
				'action' : 'reviewInsert.cd',
				'method' : 'POST',
				'enctype' : 'multipart/form-data'
			}).submit();
		});
		
		$("#rbbtn1").click(function(){
			
			location.href="/reviewSelectAll.cd";
		});
	});
	



</script>
</head>
<body>
<jsp:include page="/include/header.jsp" flush="true"></jsp:include>
<form name="reviewForm" id="reviewForm">
<table border="1" align="center">
	<tr>
		<td colspan="2" align="center">입양 후기</td>
	</tr>
	<tr>
		<td align="center">글번호	</td>
		<td><input type="text" name="rbnum" id="rbnum" size="20" readonly></td>
	</tr>
	<tr>
		<td align="center">제목</td>
		<td><input type="text" name="rbsubject" id="rbsubject" size="53"></td>
	</tr>
	<tr>
		<td align="center">작성자</td>
		<td><input type="text" name="rbwriter" id="rbwriter" size="53"></td>
	</tr>
		<tr>
		<td align="center">작성일</td>
		<td><input type="text" name="rbinsertdate" id="rbinsertdate" size="53"></td>
	</tr>
	<tr>
		<td align="center">글내용</td>
		<td>
		<textarea name="rbcontent" id="rbcontent" cols="50" rows="10"></textarea>
		</td>
		</tr>
	<tr>
		<td align="center">사진</td>
		<td>
		<input type="file" name="rbimage" id="rbimage">
	</td>
	</tr>
	<tr>
		<td colspan="2" align="right">
		<input type="button" value="글쓰기" id="rbbtn">
	</td>
	</tr>
	

	<tr>
		<td colspan="2" align="right">
		<input type="button" value="글목록" id="rbbtn1">
	</td>
	</tr>
	
</table>
</form>
</body>
</html>














