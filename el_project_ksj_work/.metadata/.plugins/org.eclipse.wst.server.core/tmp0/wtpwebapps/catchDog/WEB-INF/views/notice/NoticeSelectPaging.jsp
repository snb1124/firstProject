<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "com.catchdog.notice.vo.NoticeVO"%>
<%@ page import = "java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 페이징 목록 </title>
<style type="text/css">
	th.tt{
		text-align: center;
		}
	td.tt{
	text-align: center;
		}
</style>
<script src ="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		
		$(document).on("click","#nnum",function(){
			if($(this).prop('checked')){
				$('.nnum').prop('checked',false);
				$(this).prop('checked',true);
			}
		});
		
		$(document).on("click", ".subject", function(){
			$("#nnum").val($(this).attr("id"));
			$("#noticeList").attr({ "method":"POST"
                 ,"action":"noticeSelect.cd"}).submit();
		});
		
		//검색 버튼 누르면 
		$(document).on("click","#searchBtn",function(){
//			alert("searchBtn>>>");
			$("#noticeList").attr({
									"method":"GET"
									,"action":"NoticeSelectPaging.cd"
									
							}).submit();
			
		});
		
		//I
		$(document).on("click","#I",function(){
			
			location.href ="noticeForm.cd";
		
		});
		

	});
</script>

</head>
<body>
<jsp:include page="/include/header.jsp" flush="true"></jsp:include>	
<% 
	//페이징 변수 세팅
	int pageSize = 0;
 	int groupSize = 0;
 	int curPage = 0;
 	int totalCount= 0;
 	
 	Object objPaging = request.getAttribute("pagingNVO");
 	NoticeVO pagingNVO = (NoticeVO)objPaging;
 	
 	Object obj = request.getAttribute("listAll");
 	List<NoticeVO> list = (List)obj;
 	
 	int nCnt = list.size();
 	System.out.println("nCnt >>>:" + nCnt);
 	
%>
<form name="noticeList" id="noticeList">
<input type="hidden" name="nnum" id="nnum"/>
<table align="center" style="border-top:none;">
<thead>
<tr>
	<td colspan="10" align="center">
		<h1 style="font-size: 25px; color:black; margin-bottom:15px;">공지사항</h1>
	</td>
</tr>
<tr>
	<th class="tt">글번호</th>
	<th class="tt">제목</th>	
	<th class="tt">내용</th>
	<th class="tt"></th>	
	<th class="tt">작성일</th>
</tr>
</thead>

<%
	for(int i=0; i<nCnt; i++){
		NoticeVO nvo = list.get(i);
		pageSize = Integer.parseInt(pagingNVO.getPageSize());
		groupSize=Integer.parseInt(pagingNVO.getGroupSize());
		curPage=Integer.parseInt(pagingNVO.getCurPage());
		totalCount =Integer.parseInt(nvo.getTotalCount());

%>
<tbody>
<tr>
	<td class="tt"><%= (curPage-1)*pageSize + i + 1 %></td>
	<td class="tt"><%= nvo.getNtitle() %></td>
	<td class="tt">
	<span class="subject" id="<%= nvo.getNnum() %>" style="cursor:pointer;"><%= nvo.getNcontent() %></span></td>
	<td class ="tt"><img src ="/image/noticeimg/<%=nvo.getNimage() %>"></td>
	<td class="tt"><%= nvo.getNupdatedate() %></td>
</tr>
<%
	}//end of for
%>
<tr style="border:none;">
	<td colspan="10" align="center">
		<select id="keyfilter" name="keyfilter">
			<option value="key1">제목</option>
			<option value="key2">내용</option>
			<option value="key3">제목+내용</option>
		</select>
		<input type="text" id="keyword" placeholder="검색어입력">
		<button type="button" id="searchBtn">검색 </button>
		<input type="button" value="글쓰기 " id='I' style="float:right;">	
	</td>
</tr>
<tr style="border:none;">
<td colspan="5">
<jsp:include page="NoticePaging.jsp" flush="true">
	<jsp:param  name="url" value="NoticeSelectPaging.cd"/>
	<jsp:param  name="str" value=""/>
	<jsp:param  name="pageSize" value="<%=pageSize %>"/>
	<jsp:param  name="groupSize" value="<%=groupSize %>"/>
	<jsp:param  name="curPage" value="<%=curPage %>"/>
	<jsp:param  name="totalCount" value="<%=totalCount %>"/>
</jsp:include>
</td>
</tr>
</tbody>
</table>
</form>
</body>
</html>