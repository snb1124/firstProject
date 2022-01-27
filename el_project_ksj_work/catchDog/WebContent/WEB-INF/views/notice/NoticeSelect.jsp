<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.catchdog.notice.vo.NoticeVO" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NOTICE SELECT </title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	//U
	$(document).on("click","#U", function(){
//		alert("수정하기 버튼>>>");
		$("#noticeUpdateForm").attr({
									"method":"POST"
									,"action":"noticeUpdate.cd"
			
		}).submit();
		
	});
	
	//D
	$(document).on("click","#D",function(){
//		alert("삭제하기 >>>");
		$("#noticeUpdateForm").attr({
									"method":"POST"
									,"action" : "noticeDelete.cd"
			
		}).submit();
	});
});
</script>
</head>
<body>
<jsp:include page="/include/header.jsp" flush="true"></jsp:include>
<%
	Object obj = request.getAttribute("listS");
	List<NoticeVO> list = (List)obj;
	NoticeVO nvo = null;
	if(list.size() ==1){
		nvo = list.get(0);
	};
%>
<div>
<form name="noticeUpdateForm" id="noticeUpdateForm">
<table border="1">
<tr>
<td colspan="2" align="center">게시판 글 수정하기 </td>
</tr>
<tr>
<th class="nnum">글번호</th>
<td><input type="text" name="nnum" id="nnum" value="<%= nvo.getNnum() %>" readonly/></td>
</tr>
<tr>
<th class="ntitle">제목</th>
<td><input type="text" name="ntitle" id="ntitle" value="<%= nvo.getNtitle() %>" /></td>
</tr>
<tr>
<th class="ncontent">글내용</th>
<td><textarea name="ncontent" id="ncontent" rows="5" cols="50"><%= nvo.getNcontent() %></textarea>
</td>
</tr>
<tr>
<th class="nimage">사진 </th>
<td><img src ="/image/noticeimg<%=nvo.getNimage() %>"border="1" width="40" height="50" alt="image"></td>
</tr>
<tr>
<th class="nupdatedate">최종작성일</th>
<td><input type="text" name="nupdatedate" id="nupdatedate" value="<%= nvo.getNupdatedate() %>" readonly /></td>
</tr>
<tr>
	<td colspan="2" align="right">
	<button type="button" id="U">수정</button>
	<button type="button" id="D">삭제 </button>
	</td>
</tr>
</table>
</form>
</div>
</body>
</html>