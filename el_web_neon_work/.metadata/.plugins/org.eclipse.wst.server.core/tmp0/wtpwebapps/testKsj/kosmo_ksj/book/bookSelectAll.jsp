<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page
import="a.b.c.com.ksj.book.service.BookService" %>
 <%@page import="a.b.c.com.ksj.book.service.BookServiceImpl"%>
 <%@page import="a.b.c.com.ksj.book.vo.BookVO" %>
 <%@page import="java.util.ArrayList" %>
 <!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>BookSelectAll</title>
<style type ="text/css">
*{
	margin: 0 auto;
	/*text-align: center;*/
}
fieldset{
	width: 1000px;
}
legend{
	font-size:1.5em;
	font-weight: bold;
}

td,th{
	padding:5px;
}
.tt{
	text-align: center;
}
</style>
<script
src="http://code.jquery.com/jquery-latest.min.js">
</script>
<script type="text/javascript">
	function checkOnly(chk){
		var chkObj = document.getElementsByName("knumCheck");
		console.log("chkObj->"+chkObj);
		for(var i=0; i < chkObj.length;i++){
			if(chkObj[i] !=chk){
				chkObj[i].checked=false;
		}
	}
	}
	$(document).ready(function(){
		//insert
		$("#I").click(function(){
			location.href='/testKsj/kosmo_ksj/book/book.html';
		});
		//select
		$("#S").click(function(){
			var isudtype = document.bookSelectAllForm.isudtype.value="S";
			send(isudtype);
		});
		//update
		$("#U").click(function(){
			var nCnt = chkInfo();
			if (nCnt==0){
				console.log('üũ�ڽ��� üũ�ϼ���');
				alert('üũ�ڽ��� üũ�ϼ���');
			}else{
				document.bookSelectAllForm.isudtype.value="U";
				alert("isudtype U->"+document.bookSelectAllForm.isudtype.value);
				send(document.bookSelectAllForm.isudtype.value);	
			}
		});
		$("#D").click(function(){
			var nCnt = chkInfo();
			if(nCnt==0){
				console.log('üũ�ڽ� Ȯ��');
				alert('üũ�ڽ��� Ȯ��');
			}else{
				document.bookSelectAllForm.isudtype.value="D";
				alert("isudtype D->"+ document.bookSelectAllForm.isudtype.value);
				send(document.bookSelectAllForm.isudtype.value);
			}
		});
		//üũ�ڽ� ī��Ʈ
		function chkInfo(){
			var obj= document.getElementsByName("knumCheck");
			var nCnt = 0;
			for(var i=0; i < obj.length; i++){
				if(obj[i].checked == true){
					nCnt++
				}
		}
		console.log('nCnt->'+nCnt);
		return nCnt;
		}
	function send(isudtype){
	alert("isudtype send->"+isudtype);
	$("#bookSelectAllForm").attr({
		"action":"/testKsj/book?isudtype="+isudtype,
		"method":"POST",
		"enctype":"application/x-www-form-urlencoded"
	}).submit();
}
	});//�������� �Լ� �� 
</script>
</head>
<body>
<% request.setCharacterEncoding("EUC-KR");%>
SELECT ALL
<%
 	Object obj = request.getAttribute("aListAll");
	if(obj ==null) return;
	ArrayList<BookVO> aList = (ArrayList<BookVO>)obj;
	int nCnt = aList.size();
	out.println("��ü��ȸ�Ǽ�"+nCnt+"��");
%>
<table>
<tr>
<td calspan = "2">
<font size="4" color="blue">
	<!-- <img src="/testKosmo/img/img_mando/ase.gif" width="25" height="25" alter="image"> -->
	BOOK TEST
	</font>
	</td>
	</tr>
</table>
<hr>
<hr>
<fieldset>
<legend>����������ȸ</legend>
<form name="bookSelectAllForm" id ="bookSelectAllForm">
<table border="1">
<thead>
<tr>
	<td class="tt"><input type="checkbox" name="chkAll" id="chkAll"></td>
	<td class="tt">����</td>
	<td class="tt">������ȣ</td>
	<td class="tt">������</td>
	<td class="tt">����</td>
	<td class="tt">ISBN</td>
	<td class="tt">���ǻ�</td>
	<td class="tt">�ܰ�</td>
	<td class="tt">����</td>
	<td class="tt">ǥ��</td>	
	<td class="tt">��������</td>
	<td class="tt">�����</td>
	<td class="tt">������</td>
</tr>
</thead>
<%
	for(int i=0; i<nCnt; i++){
		BookVO bvo = aList.get(i);
%>					
<tbody>
<tr>
	<td class="tt">
		<input type="checkbox" name="knumCheck" id="knumCheck" value=<%= bvo.getKnum() %> onclick="checkOnly(this)">
	</td>		
	<td class="tt"><%= i + 1 %></td>
	<td class="tt"><%= bvo.getKnum() %> </td>
	<td class="tt"><%= bvo.getKtitle() %> </td>
	<td class="tt"><%= bvo.getKauth() %> </td>
	<td class="tt"><%= bvo.getIsbn() %> </td>	
	<td class="tt"><%= bvo.getKcomp() %> </td>
	<td class="tt"><%= bvo.getKprice() %> </td>
	<td class="tt"><%= bvo.getKqty() %> </td>		
	<td class="tt"><img src="/testKsj/fileupload/book/<%= bvo.getKcover() %>" border="1" width="25" height="25" alt="image"></td>
	<td class="tt"><%= bvo.getDeleteyn() %> </td>		
	<td class="tt"><%= bvo.getInsertdate() %> </td>
	<td class="tt"><%= bvo.getUpdatedate() %> </td>		
</tr>	
<%
	}//end of for
%>						
<tr>
	<td colspan="20" align="right">
		<input type="hidden" name="isudtype" id="isudtype" value="">			
		<input type="button" value="�����������" id="I">
		<input type="button" value="����������ȸ" id="S">
		<input type="button" value="������������" id="U">
		<input type="button" value="������������" id="D">									
	</td>
</tr>	
</tbody>
</table>
</form>
</fieldset>
</body>
</html>