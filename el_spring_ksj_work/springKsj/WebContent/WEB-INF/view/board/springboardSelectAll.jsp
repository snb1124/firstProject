<%@ page language="java" contentType="text/html; charse
t=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="a.b.c.com.board.vo.SpringBoardVO" %> 
<%@ page import="java.util.List" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Select All</title>
<style type="text/css">
	.tt{
		text-align:center;
		font-weight: bold;
	}
</style>
<link rel="stylesheet" href="springKsj/common/datepiker/jquery-ui-1.12.1/jquery-ui.min.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="/springKsj/common/datepiker/jquery-ui-1.12.1/jquery-ui.min.js"></script>
<script type="text/javascript">
	
	$(document).ready(function(){
		
		$(document).on("click", "#knum", function(){
			if($(this).prop('checked')){
				$('.knum').prop('checked', false);
				$(this).prop('checked', true);
			}
		});
		
		$(document).on("click", "#searchBtn", function(){
			alert("searchBtn 이벤트 진입");
			$("#boardList").attr({ "method":"GET", "action":"boardSelectAll.jin"}).submit();
		});
		
		$("#startdate").datepicker({
			showOn:"button",
			buttonImage : "springKsj/img/cal_0.gif",
			buttonImageOnly : true,
			buttonText : "날짜선택",
			dateFormat : "yy-mm-dd",
			changeMonth : true,
			onClose : function(selectedDate){
				$("enddate").datepicker("option", "minDate", selectDate);
			}
		});
	
	$("#enddate").datepicker({
		showOn:"button",
		buttonImage : "springKsj/img/cal_0.gif",
		buttonImageOnly : true,
		buttonText : "날짜선택",
		dateFormat : "yy-mm-dd",
		changeMonth : true,
		onClose : function(selectedDate){
			$("startdate").datepicker("option", "maxDate", selectDate);
		}
	});
	$(document).on("click", "#I", function(){
		location.href="boardForm.jin";
	});
	$(document).on("click", "#U", function(){
		if($('.knum:checked').length==0){
			alert("수정할 글번호 하나를 선택하시오");
			return
		}
		$("#boardList").attr({"method":"POST", "action":"boardSelect.jin"}).submit();
		
	});
	$(document).on("click", "#D", function(){
		if($('.knum:checked').length == 0){
			alert("삭제할 글번호를 선택하시오");
			return;
		}
		$("#boardList").attr({"method":"POST", "action":"boardSelect.jin"}).submit();		
	});
	});

</script>  
</head>
<body>

<%--request.setCharacterEncoding("EUC-KR");--%>
<%
	Object obj = request.getAttribute("listAll");
	List<SpringBoardVO> list = (List)obj;
	
	int nCnt = list.size();
	System.out.println("nCnt->>>"+nCnt);;
%>
<form name="boardList" id="boardList">
	<table border="1" align="center">
		<thead>
		<tr>
			<td colspan="10" align=center>
				<h2>게시판</h2>
			</td>
		</tr>
		<tr>
		<td colspan="10" align="left">
			<select id="keyfilter" name="keyfilter">
				<option value="key1">제목</option>
				<option value="key2">내용</option>
				<option value="key3">제목+내용</option>
				<option value="key4">작성장</option>
				<option value="key5">글번호</option>
			</select>
		<input type="text" id="keyword" name="keyword" placeholder="검색어 입력"><br>
		<input type="text" id="startdate" name="startdate" size="12" placeholder="시작일"><br>
		<input type="text" id="enddate" name="enddate" size= "12" placeholder="종료일"><br>
		<button type="button" id="searchBtn"> 검색 </button>			
		</td>
		</tr>
		<tr>
			<td class="tt">체크</td>
			<td class="tt">글번호 </td>
			<td class="tt">제목</td>
			<td class="tt">이름</td>
			<td class="tt">내용</td>
			<td class="tt">최종작성일</td>
			<td class="tt">사진</td>
		</tr>	
		</thead>
		<%
			for(int i=0; i<nCnt; i++){
				SpringBoardVO bvo = list.get(i);
		
		%>
	<tbody>
		<tr>
			<td align="center">
				<input type="checkbox" name="knum" id="knum" class="knum" value=<%= bvo.getKnum() %> >
			</td>
			<td class="tt"> <%=bvo.getKnum() %> </td>
			<td class="tt"> <%=bvo.getKsubject() %> </td>
			<td class="tt"> <%=bvo.getKname() %> </td>
			<td class="tt"> <%=bvo.getKcontent() %> </td>
			<td class="tt"> <%=bvo.getKupdatedate() %> </td>
			<td class="tt"><img src="/springKsj/imgupload/sm_<%=bvo.getKfile() %>"></td>	
		</tr>		
		<%} %>
		<tr>
			<td colspan="7" align="right">
				<input type="button" value="글쓰기" id="I">
				<input type="button" value="글수정" id="U">
				<input type="button" value="글삭제" id="D">
			</td>
		</tr>	
	</tbody>	
	</table>
</form>
</body>
</html>