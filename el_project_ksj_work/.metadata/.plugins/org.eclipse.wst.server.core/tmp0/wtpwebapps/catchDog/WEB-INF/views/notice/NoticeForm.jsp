<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 게시판 </title>
<script src ="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		
		$(document).on("click","#ntbtn",function(){
			console.log("ntbtn>>>");
			
			$("#noticeForm").attr({
				'action':'noticeInsert.cd',
				'method':'POST',
				'enctype':'multipart/form-data'
			}).submit();
			
		});
	
	});

</script>
</head>
<body>
<jsp:include page="/include/header.jsp" flush="true"></jsp:include>	
<form name="noticeForm" id="noticeForm">
<table border="1" align="center">
	<tr>
		<th align="center">게시판번호</th>
		<td><input type="text" name="nnum" id="nnum" size="20" readonly></td>
	</tr>
  <tr>
		<th align="center">제목</th>
		<td><input type="text" name="ntitle" id="ntitle" size="53"></td>
	</tr>
  <tr>
		<th align="center">내용</th>
    <td><textarea name="ncontent" id="ncontent" cols="50" rows="10"></textarea></td>
	</tr>
  <tr>
      <th align="center">사진</th>
      <td><input type="file" name="nimage" id="nimage"></td>
  </tr>
  <tr>
    <td colspan="2" align="right">
    <input type="button" value="글쓰기" id="ntbtn">
  </td>
  </tr>
</table>
</form>
</body>
</html>