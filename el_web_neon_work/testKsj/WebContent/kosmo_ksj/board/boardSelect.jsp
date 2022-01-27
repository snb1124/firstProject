<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@page import="a.b.c.com.ksj.board.service.BoardService"%>
<%@page import="a.b.c.com.ksj.board.service.BoardServiceImpl"%>    
<%@page import="a.b.c.com.ksj.board.vo.BoardVO"%>    
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>글 조건조회</title>
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

	function boardUpdate(actionUpdate){
		console.log("boardUpdate 진입 >>> : " + actionUpdate);
				//업데이트 UOK로 서블릿으로 넘어감
		if ('U' == actionUpdate){
			var v1 = "UOK";		
			document.boardUpdateForm.action="/testKsj/board?ISUD_TYPE="+v1;			
		}
		//딜리트 ISUD DOK로 넘어감 
		if ('D' == actionUpdate){
			var v2 = "DOK";
			document.boardUpdateForm.action="/testKsj/board?ISUD_TYPE="+v2;
		}
		
		document.boardUpdateForm.method="POST";
		document.boardUpdateForm.enctype="application/x-www-form-urlencoded";
		document.boardUpdateForm.submit();		
	}
	
	function checkAction(actionName){
		console.log("actionName 진입 >>> : " + actionName);
		
		if ('I' == actionName){	
			location.href="/testKsj/kosmo_ksj/board/board.html";
		}
		if ('S' == actionName){			
			location.href="/testKsj/board?ISUD_TYPE=S";
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
	
	ArrayList<BoardVO> aList = (ArrayList<BoardVO>)obj;
	int nCnt = aList.size();
	out.println(":::: 조건 조회 >>> : " + nCnt + " 건");
	
	String knum = "";
	String ksubject = "";	
	String kwriter = "";
	String kpw = "";
	String kmemo = "";
	String kphoto = "";
	String deleteyn = "";
	String insertdate = "";
	String updatedate = "";	
	
	if (nCnt == 1){
		BoardVO kvo = aList.get(0);
		
		knum = kvo.getKnum();
		ksubject = kvo.getKsubject();
		kwriter = kvo.getKwriter();
		kpw = kvo.getKpw();
		kmemo = kvo.getKmemo();
		kphoto = kvo.getKphoto();
		deleteyn = kvo.getDeleteyn();
		insertdate = kvo.getInsertdate();
		updatedate = kvo.getUpdatedate();		
	}
%>
<hr>
<div>
<form name="boardUpdateForm" id="boardUpdateForm">
<table border="1">
<tr>	
	<td colspan="2" align="center">	
					
		<font size="4" style="color:blue;">게시판 글 수정 && 삭제</font> 
		<!-- <img src="/testksj/img/img_mando/ase.gif" width="25" height="25" alt="image">-->		
	</td>				
</tr>
<tr>
	<td class="tt">글번호</td>
	<td><input type="text" name="knum" id="knum" size="20"  value="<%= knum %>" readonly></td>
</tr>
<tr>
	<td class="tt">제목</td>
	<td><input type="text" name="ksubject" id="ksubject" value="<%= ksubject %>" size="55"></td>
</tr>
<tr>
	<td  class="tt">이름</td>.
	<td><input type="text" name="kwriter" id="kwriter" value="<%= kwriter %>" size="20" readonly></td>
</tr>
<tr>
	<td  class="tt">비밀번호</td>
	<td><input type="password" name="bpw" id="kpw" value="<%= kpw %>" size="20" readonly></td>
</tr>
<tr>
	<td  class="tt">삭제여부</td>
	<td><input type="text" name="deleteyn" size="20" value="<%= deleteyn %>" disabled></td>
</tr>
<tr>
	<td  class="tt">입력일</td>
	<td><input type="text" name="insertdate" size="20" value="<%= insertdate %>" disabled></td>
</tr>
<tr>
	<td  class="tt">수정일</td>
	<td><input type="text" name="updatedate" size="20" value="<%= updatedate %>" disabled></td>
</tr>
<tr>
	<td  class="tt">내용</td>
	<td>
	<textarea name="kmemo" id="kmemo" cols="50" rows="10"><%= kmemo %></textarea>
</td>
</tr>
<tr>
	<td  class="tt">사진</td>
	<td>
	<img src="/testksj/fileupload/board/<%= kphoto %>" border="1" width="40" height="50" alt="image">		
</td>
</tr>
<tr>
	<td colspan="2" align="center">	
	<input type="hidden" name="ISUD_TYPE" id="ISUD_TYPE" >
	<input type="button" value="수정" onclick="boardUpdate('U')"/>
	<input type="button" value="삭제" onclick="boardUpdate('D')"/>
    <input type="reset" value="취소" />
    &nbsp;&nbsp;&nbsp;&nbsp;
    <input type="button" value="입력" onclick="checkAction('I')"/>
	<input type="button" value="목록" onclick="checkAction('S');">
</td>	
<tr>			
</table>
</form>
</div>
</body>
</html>