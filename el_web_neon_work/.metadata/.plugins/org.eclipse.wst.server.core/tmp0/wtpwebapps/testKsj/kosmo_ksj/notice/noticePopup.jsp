<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@page import="a.b.c.com.ksj.notice.service.NoticeService"%>
<%@page import="a.b.c.com.ksj.notice.service.NoticeServiceImpl"%>    
<%@page import="a.b.c.com.ksj.notice.vo.NoticeVO"%>    
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>공지 사항</title>
<style type="text/css">

	html {overflow:hidden;} 

	div {
		width: 80%;		
		margin: 0 auto;
	}			

	td, th {
		 padding: 5px;
	}
	
	.tt {
		text-align: left;
	}
	
	.tt1 {
		text-align: center;
	}
</style>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

	function closePopup(){
		alert("구현은 다음에");
	}
	
</script>
</head>
<body>
<% request.setCharacterEncoding("EUC-KR");%> 
<%
	Object obj = request.getAttribute("aListS");
	if (obj == null) return;
	
	ArrayList<NoticeVO> aList = (ArrayList<NoticeVO>)obj;
	int nCnt = aList.size();
	
	String knum = "";
	String ksubject = "";		
	String kmemo = "";
	String kphoto = "";
	
	if (nCnt == 1){
		NoticeVO nvo = aList.get(0);
		
		knum = nvo.getKnum();
		ksubject = nvo.getKsubject();
		kmemo = nvo.getKmemo();
		kphoto = nvo.getKphoto();
	}
%>
<h4>공지사항 팝업</h4>
<hr>
<div>
<form name="noticeForm" id="noticeForm">
<table>
<tr>	
	<td align="center">					
		<font size="4" style="color:blue;">전사 공지 </font> 
	<!-- 	<img src="/testKosmo/img/img_mando/ase.gif" width="25" height="25" alt="image"> -->		
	</td>				
</tr>
<tr>
	<td class="tt">공지번호 : <%= knum %></td>
</tr>
<tr>
	<td class="tt">제목 : <%= ksubject %></td>	
</tr>
<tr>
	<td class="tt">내용 : <%= kmemo %>	
</td>
</tr>
<tr>
	<td class="tt1">
		<img src="/testKsj/fileupload/notice/<%= kphoto %>" border="1" width="60" height="50" alt="image">		
	</td>
</tr>
<tr>			
<tr>
	<td>
		<input type="checkbox" name="notice" onClick="closePopup()"> <font style="font-size:10px">오늘 하루 동안 열지 않음</font>	
	</td>
</tr>

</table> 
</form>
</div>
</body>
</html>