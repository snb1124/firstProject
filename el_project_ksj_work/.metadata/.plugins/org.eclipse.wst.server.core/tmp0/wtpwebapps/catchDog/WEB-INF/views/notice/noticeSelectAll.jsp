<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8" %>
<%@ page import = "java.util.List" %>
<%@ page import = "com.catchdog.notice.vo.NoticeVO" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록 </title>
<script src = "http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
		$(document).on("click","#nnum",function(){
			if($(this).prop('checked')){
				$('.nnum').prop('checked',false);
				$(this).prop('checked',true);
			}
		});
		
		//검색 버튼 누르면 
		$(document).on("click","#searchBtn",function(){
//			alert("searchBtn>>>");
			$("#noticeList").attr({
									"method":"GET"
									,"action":"noticeSelectAll.cd"
									
							}).submit();
			
		});
		
		//I
		$(document).on("click","#I",function(){
			
			location.href ="noticeForm.cd";
		
		});
		
		//U
		$(document).on("click","#U",function(){
			if($('.nnum:checked').length == 0){
				alert('수정할 글 번호 하나를 선택하세요');
				return;
			}
			$("#noticeList").attr({
							"method":"POST"
							,"action":"noticeSelect.cd"
						
			}).submit();
		});
		
		//d버튼 
		$(document).on("click","#D",function(){
			if($('.nnum:checked').length == 0){
				alert('수정할 글 번호 하나를 선택하세요');
				return;
			}
			$("#noticeList").attr({
							"method":"POST"
							,"action":"noticeSelect.cd"
							
			}).submit();
		});
	});

</script>
</head>
<body>
<jsp:include page="/include/header.jsp" flush="true"></jsp:include>
<%
	Object obj = request.getAttribute("listAll");
	List<NoticeVO> list = (List)obj;
	
	int nCnt = list.size();
	System.out.println("nCnt >>>:" + nCnt);
%>

<form name="noticeList" id="noticeList">
<table border="1" align="center">
<thead>
<tr>
	<td colspan="10" align="center">
		<h2>공지사항</h2>
	</td>
</tr>
<tr>
	<td colspan="10" align="left">
	<select id="keyfilter" name="keyfilter">
		<option value="key1">제목</option>
		<option value="key2">내용</option>
		<option value="key3">제목+내용</option>
	</select>
	<input type="text" id="keyword" name="keyword" placeholder = "검색어 입력">
	<button	type="button" id="searchBtn">검색 </button>
</td>
</tr>

<tr>
	<td class="tt">체크</td>
	<td class="tt">글번호</td>
	<td class="tt">제목</td>	
	<td class="tt">내용</td>
	<td class="tt">최종작성일</td>
	<td class="tt">사진</td>
</tr>
</thead>
<%
for(int i=0; i<nCnt; i++){
	NoticeVO nvo = list.get(i);

%>
<tbody>
<tr>
	<!--  체크 글번호 제목 내용 최종작성일 사진 -->
	<td align="center">
		<input type="checkbox" name="nnum" id="nnum"
		class= "nnum" value=<%= nvo.getNnum() %>>
	</td>
	<td class="tt"><%= nvo.getNnum() %></td>
	<td class="tt"><%= nvo.getNtitle() %></td>
	<td class="tt"><%= nvo.getNcontent() %></td>
	<td class="tt"><%= nvo.getNupdatedate() %></td>
	<td class ="tt"><img src ="image/noticeimg/<%=nvo.getNimage() %>">
	</td>
	</tr>
	<%
}
	%>
	<tr>
	<td colspan="7" align="right">
		<input type="button" value="글쓰기 " id='I'>
		<input type="button" value="글수정 " id='U'>
		<input type="button" value="글삭제 " id='D'>
	</td>
</tr>
</tbody>			
</table>
</form>	
</body>
</html>