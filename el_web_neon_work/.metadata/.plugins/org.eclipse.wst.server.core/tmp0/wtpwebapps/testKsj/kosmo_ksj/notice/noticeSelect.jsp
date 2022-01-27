<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@page import="a.b.c.com.ksj.notice.service.NoticeService"%>
<%@page import="a.b.c.com.ksj.notice.service.NoticeServiceImpl"%>    
<%@page import="a.b.c.com.ksj.notice.vo.NoticeVO"%>    
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�������� ������ȸ</title>
<style type="text/css">
	* {
		margin: 0 auto;
		/*text-align: center;*/
	}
	
	div {
		margin: 50px 0px 0px 100px;
	}			

	td, th {
		 padding: 5px;
	}
	
	.tt {
		text-align: center;
	}
</style>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

	function noticeUpdate(actionUpdate){
		console.log("noticeUpdate ���� >>> : " + actionUpdate);
				
		if ('U' == actionUpdate){
			var v1 = "UOK";		
			document.noticeUpdateForm.action="/testKsj/notice2?ISUD_TYPE="+v1;			
		}
		
		if ('D' == actionUpdate){
			var v2 = "DOK";
			document.noticeUpdateForm.action="/testKsj/notice2?ISUD_TYPE="+v2;
		}
		
		document.noticeUpdateForm.method="POST";
		document.noticeUpdateForm.enctype="application/x-www-form-urlencoded";
		document.noticeUpdateForm.submit();		
	}
	
	function checkAction(actionName){
		console.log("actionName ���� >>> : " + actionName);
		
		if ('I' == actionName){	
			location.href="/testKsj/kosmo_ksj/notice/notice.html";
		}
		if ('SALL' == actionName){			
			location.href="/testKsj/notice2?ISUD_TYPE=SALL";
		}
	}	
</script>
</head>
<body>
<% request.setCharacterEncoding("EUC-KR");%> 
SELECT 

<%
	Object obj = request.getAttribute("aListS");
	if (obj == null) return;
	
	ArrayList<NoticeVO> aList = (ArrayList<NoticeVO>)obj;
	int nCnt = aList.size();
	out.println(":::: ���� ��ȸ >>> : " + nCnt + " ��");
	
	String knum = "";
	String ksubject = "";		
	String kmemo = "";
	String kphoto = "";
	String deleteyn = "";
	String insertdate = "";
	String updatedate = "";	
	
	if (nCnt == 1){
		NoticeVO nvo = aList.get(0);
		
		knum = nvo.getKnum();
		ksubject = nvo.getKsubject();
		kmemo = nvo.getKmemo();
		kphoto = nvo.getKphoto();
		deleteyn = nvo.getDeleteyn();
		insertdate = nvo.getInsertdate();
		updatedate = nvo.getUpdatedate();		
	}
%>
<hr>
<div>
<form name="noticeUpdateForm" id="noticeUpdateForm">
<table border="1">
<tr>	
	<td colspan="2" align="center">	
					
		<font size="4" style="color:blue;">�������� ����</font> 
		<!-- <img src="/testKosmo/img/img_mando/ase.gif" width="25" height="25" alt="image"> -->		
	</td>				
</tr>
<tr>
	<td class="tt">�۹�ȣ</td>
	<td><input type="text" name="knum" id="knum" size="20"  value="<%= knum %>" readonly></td>
</tr>
<tr>
	<td class="tt">����</td>
	<td><input type="text" name="ksubject" id="ksubject" value="<%= ksubject %>" size="55"></td>
</tr>
<tr>
	<td  class="tt">����</td>
	<td>
	<textarea name="kmemo" id="kmemo" cols="50" rows="10"><%= kmemo %></textarea>
</td>
</tr>
<tr>
	<td  class="tt">����</td>
	<td>
	<img src="/testKsj/fileupload/notice/<%= kphoto %>" border="1" width="40" height="50" alt="image">		
</td>
</tr>
<tr>
	<td colspan="2" align="center">	
	<input type="hidden" name="ISUD_TYPE" id="ISUD_TYPE" >
	<input type="button" value="����" onclick="noticeUpdate('U')"/>
    <input type="reset" value="���" />
    &nbsp;&nbsp;&nbsp;&nbsp;
    <input type="button" value="�Է�" onclick="checkAction('I')"/>
	<input type="button" value="���" onclick="checkAction('SALL');">
</td>	
<tr>			
</table>
</form>
</div>
</body>
</html>