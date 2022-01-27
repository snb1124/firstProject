<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="a.b.c.com.ksj.book.service.BookService"%>
<%@page import="a.b.c.com.ksj.book.service.BookServiceImpl"%>    
<%@page import="a.b.c.com.ksj.book.vo.BookVO"%>    
<%@page import="java.util.ArrayList"%>

<html>
<head>
<meta charset="EUC-KR">
<title>도서 정보 조회 화면</title>
<style type="text/css">
	* {
		margin: 0 auto;
		text-align: center;
	}
	
	fieldset {
		width: 400px;
	}

	legend {
		font-size: 1.2em;
		/*font-weight: bold;*/
	}

	td {
		padding: 5px;
	}
	
	.attr {
		font-weight: bold;
	}
	
	.align {
		text-align: left;
	}
</style><style type= "text/css">
*{
	margin : 0 auto;
	text-align: center;
}
	fieldset{
		width:400px
	}
</style>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
function bookUpdate(actionUpdate){
console.log("book update 진입 ->"+actionUpdate);

if(actionUpdate='U'){
document.bookUpdateForm.action="/testKsj/book?isudtype=UOK";
}
if(actionUpdate='D'){
document.bookUpdateForm.action="/testKsj/book?isudtype=DOK";
}
document.bookUpdateForm.method ="POST";
document.bookUpdateForm.enctype ="application/x-www-form-urlencoded";
document.bookUpdateForm.submit();
}
function checkAction(actionName){
	console.log("actionname 진입"+ actionName);
	
	if('I'==actionName){
		location.href = "testKsj/kosmo_ksj/book/book.html";
	
	}
	if('SALL'==actionName){
		location.href = 'testKsj/book?isudtype=SALL';
	}
}
</script>
</head>
<body>
<% request.setCharacterEncoding("EUC-KR");%> 
SELECT
<%
Object obj =request.getAttribute("aList");

ArrayList<BookVO>aList = (ArrayList<BookVO>)obj;
int nCnt = aList.size();
out.println(" 조회 건수는 "+nCnt+"입니다");


String knum = "";
String ktitle = "";
String kauth = "";
String isbn = "";	
String kcomp = "";
String kprice = "";
String kqty = "";	
String kcover = "";
String deleteyn = "";
String insertdate = "";
String updatedate = "";

if(nCnt == 1){
	BookVO bvo = aList.get(0);
	knum = bvo.getKnum();
	ktitle = bvo.getKtitle();
	kauth = bvo.getKauth();
	isbn = bvo.getIsbn();
	kcomp = bvo.getKcomp();
	kprice = bvo.getKprice();
	kqty = bvo.getKqty();
	kcover = bvo.getKcover();
	deleteyn = bvo.getDeleteyn();		
	insertdate = bvo.getInsertdate();
}
%>
<table>
<tr>
<td colsapan="2">
<font size="4" color="blue">
<!-- <img src="/testKosmo/img/img_mando/ase.gif" width="25" height="25" alter="image"> -->

</font>
</td>
</tr>
</table>
<hr>
<hr>
<fieldset>
<legend>도서 정보 조회 </legend>
<form name="bookUpdateForm" id="bookUpdateForm">
<table border=1>
<tr>
	<td class="attr">  도서번호 </td>
	<td> <input type="text" id="knum" name="knum" class="align" value="<%=knum%>"readonly></td>
	</tr>
<tr>
	<td class="attr"> 도서명 </td>
	<td> <input type="text" id="ktitle" name="ktitle" class="align" value="<%=ktitle%>"readonly></td>
	</tr>

<tr>
	<td class="attr">  저&nbsp;&nbsp;&nbsp;자 </td>
	<td> <input type="text" id="kauth" name="kauth" class="align" value="<%=kauth%>"readonly></td>
	</tr>
	<tr>
	<td style="letter-spacing: 3px" class="attr">ISBN</td>
	<td><input type="text" id="isbn" name="isbn"  class="align" value="<%= isbn %>" readonly /></td>
	<tr>
	<td class="attr"> 출판사 </td>
	<td><input type="text" id= "kcomp" name = "kcomp" class="align" value="<%=kcomp %>"readonlt></td> 
</tr>
<tr>
<td class="attr">단&nbsp;&nbsp;&nbsp;가</td>
<td><input type="number" id="kprice" name="kprice"  class="align" value="<%= kprice %>" /></td>
</tr>
<tr>
<td class="attr">수&nbsp;&nbsp;&nbsp;량</td>
<td><input type="number" id="kqty" name="kqty"  class="align" value="<%= kqty %>" /></td>
</tr>
<tr>
<td class="attr">표&nbsp;&nbsp;&nbsp;지</td>
<td><input type="text" id="kcover" name="kcover" class="align" value="<%= kcover %>" /></td>
</tr>
<tr>
<td class="attr">삭제여부</td>
<td> 
<input type="text" name="kdeleteyn" id="kdeleteyn" class="align" value="<%= deleteyn %>" disabled  />		      
</td>
</tr>
<tr>
<td class="attr">등록일</td>
<td> 
<input type="text" name="kinsertdate" id="kinsertdate" class="align" value="<%= insertdate %>" disabled />		      
</td>
</tr>	
<tr> 
<td class="attr">수정일</td>
<td> 
<input type="text" name="kupdatedate" id="kupdatedate" class="align" value="<%= updatedate %>" disabled />		      
</td>
</tr>
	<td colspan="2"> 
		<input type="hidden" name="isudtype" id="isudtype" />	
		<input type="button" value="수정" onclick="bookUpdate('U')"/>
		<input type="button" value="삭제" onclick="bookUpdate('D')"/>
	    <input type="reset" value="취소" />
	    &nbsp;&nbsp;&nbsp;&nbsp;
	    <input type="button" value="입력" onclick="checkAction('I')"/>
		<input type="button" value="목록" onclick="checkAction('SALL');">
</td>
</table>
</form>
</body>
</html>