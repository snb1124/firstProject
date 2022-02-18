<%@page import="java.util.List"%>
<%@page import="com.catchdog.disadoption.vo.DisadoptionVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<style type="text/css">
.tt{ text-align:center; font-weight:bold;}
.button { border:none;}
</style>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript">

$(document).ready(function(){			
	// anum
	$(document).on("click", "#anum", function(){
		//alert("chkInAnum >>> : ");		
		if($(this).prop('checked')){			 
			//$('input[type="checkbox"][name="anum"]').prop('checked',false);
			$('.anum').prop('checked',false);
			$(this).prop('checked',true);
		}
	});
	//  I
	$(document).on("click", "#I", function(){
		alert("I >>> : ");
		location.href="/disadoptionBoardInsert.cd";
	});
	//  U
	$(document).on("click", "#U", function(){
		// alert("U >>> : ");	
		// anum 체크 안했을 때 
		if ($('.anum:checked').length == 0){
			alert("수정할 글번호 하나를 선택하세요!!");
			return;
		}
		//체크된 anum가지고  컨트롤러 disadoptionPwCheckForm 로
		 $("#boardList").attr({ "method":"POST"
			                   ,"action":"disadoptionPwCheckForm.cd"}).submit();
	});
	//  D
	$(document).on("click", "#D", function(){
		//alert("D >>> : ");	
		if ($('.anum:checked').length == 0){
			alert("삭제할 글번호 하나를 선택하세요!!");
			return;  
		}
		alert(length);
		$("#boardList").attr({ "method":"POST"
			                  ,"action":"disadoptionPwCheck.cd"}).submit();
	});
});
	
</script>

</head>
<body>

<% request.setCharacterEncoding("utf-8"); %>
<jsp:include page="/include/header.jsp" flush="true"></jsp:include>
<%
	//페이징 변수 세팅
	int pageSize = 0;
	int groupSize = 0;
	int curPage = 0;
	int totalCount = 0;

	Object objPaging = request.getAttribute("pagingDVO");
	DisadoptionVO pagingDVO = (DisadoptionVO)objPaging;
	
	Object obj = request.getAttribute("listAll");
	List<DisadoptionVO> list = (List)obj;
	System.out.println("Obj >>> : " + list);
	int nCnt= list.size();
	System.out.println("nCnt >>> : " + nCnt);
%>
	
	<form name="boardList" id="boardList" class="boardList">
		<table border="1" align="center">
			<thead>
			<tr>
				<td colspan ="10" align="center">
					<h2>파양신청게시판</h2>
				</td>	
			</tr>
			<tr>
				<th class="tt">체크</th>
				<th class="tt">글번호</th>
				<th class="tt">제목</th>
				<th class="tt">이름</th>		
				<th class="tt">최종작성일</th>
			</tr>
			</thead>
<%
for(int i=0; i<nCnt; i++){
		DisadoptionVO dvo = list.get(i);
		System.out.println("dvo.getAnum >>> : " + dvo.getAnum());
		System.out.println("dvo.getMname() >>> : " + dvo.getMname());
		pageSize = Integer.parseInt(pagingDVO.getPageSize());
		groupSize = Integer.parseInt(pagingDVO.getGroupSize());
		curPage = Integer.parseInt(pagingDVO.getCurPage());
		totalCount = Integer.parseInt(dvo.getTotalCount());
%>	
	<tbody>
		<tr>
	<td align="center">
		<input type="checkbox" name="anum" id="anum" class="anum" value=<%= dvo.getAnum() %> >
	</td>		
	<td class="tt"><%= dvo.getAnum() %> </td>
	<td class="tt"><%= dvo.getAsubject() %> </td>
	<td class="tt"><%= dvo.getMname() %> </td>
	<td class="tt"><%= dvo.getInsertdate() %> </td>
</tr>
		
<%
}// end of for	
%>	
	<tr>
	<td colspan="7">
	<jsp:include page="disadoptionBoardSelectPaging.jsp" flush="true">
		<jsp:param name="url" value="disadoptionBoardSelectPaging.cd"/>
		<jsp:param name="str" value=""/>
		<jsp:param name="pageSize" value="<%=pageSize%>"/>
		<jsp:param name="groupSize" value="<%=groupSize%>"/>
		<jsp:param name="curPage" value="<%=curPage%>"/>
		<jsp:param name="totalCount" value="<%=totalCount%>"/>
	</jsp:include>
	</td>
	</tr>
	<tr class="button">
		<td colspan="7" align="right">
			<input type="button" value="파양신청하기" id="I">
			<input type="button" value="글수정" id="U">
			<input type="button" value="글삭제" id="D">
		</td>	
	</tr>

	</tbody>		
		</table>
	</form>
</body>
</html>