<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GoodsInsert</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$(document).on("click", "#gbtn", function(){
			console.log("gbtn click() 함수 진입 >>> : ");			
			console.log("gname >>> : " + document.goodsForm.gname.value);
			$('#goodsForm').attr({
				'action':'goodsInsert.cd',
				'method':'POST',
				'enctype':'multipart/form-data'
			}).submit();
		});
	});
</script>
</head>
<body>
<form name="goodsForm" id="goodsForm">
	<table border="1" align="center">

 	<tr>
 		<td colspan="2" align="center"> 상품 판매글 입력</td>
 	</tr>
 	<tr>
 		<td align="center">글번호</td>
 		<td><input type="text" name="gnum" id="gnum" size="20" readonly></td>
 	</tr>
 	<tr>
 		<td align="center">상품번호</td>
 		<td><input type="text" name="gpdnum" id="gpdnum" size="20" readonly></td>
 	</tr>
 	<tr>
 		<td align="center">회원번호</td>
 		<td><input type="text" name="mnum" id="mnum" value = "M2021110001" size="20"></td>
 	</tr>
 	<tr>
 		<td align="center">상품명</td>
 		<td><input type="text" name="gname" id="gname" size="53"></td>
 	</tr>
 	<tr>
 		<td align="center">상품가격</td>
 		<td><input type="text" name="gprice" id="gprice" size="53"></td>
 	</tr>
 	<tr>
 		<td align="center">목표금액</td>
 		<td><input type="text" name="gtarget" id="gtarget" size="53"></td>
 	</tr>
 	<tr>
 		<td align="center">D-DAY</td>
 		<td><input type="text" name="gdday" id="gdday" size="20"></td>
 	</tr>
 	<tr>
		<td align="center">내용 </td>
		<td><textarea type="text" name="gdetail" id="gdetail" rows="10"></textarea></td>
	</tr>
 	<tr>
		<td align="center">사진</td>
		<td><input type="file" name="gimage" id="gimage" value="gimage"></td>
	</tr>			
	<tr>
		<td colspan="2" align="right"></td>
		<td><input type="button" value="글쓰기" name="gbtn" id="gbtn"></td>
	</tr>
	</table>
</form>
</body>
</html>