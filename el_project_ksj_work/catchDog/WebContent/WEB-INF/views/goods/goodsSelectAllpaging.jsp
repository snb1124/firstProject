<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.catchdog.goods.vo.GoodsVO"%> 
<%
int pageSize = 0;
int groupSize = 0;
int curPage = 0;
int totalCount = 0;
	
	List<GoodsVO> list = (List<GoodsVO>)request.getAttribute("listAll");
	
	Object objPaging = request.getAttribute("pagingVO");
	GoodsVO pagingVO = (GoodsVO)objPaging;
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품목록</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>

<body>
<jsp:include page="/include/header.jsp" flush="true"></jsp:include>
<form name="goodsList" id="goodsList">
<script>

$(document).on("click", "#I", function(){
	
	location.href="goodsForm.cd";
});
function selectGoods(gnums){
	let id = gnums.id;
	console.log("id->>"+id);
	$("#gnum").val(id);
	
	
	$("#goodsList").attr({
		"action":"/goodsSelect.cd",
		"method":"POST",
		"enctype":"application/x-www-form-urlencoded"
	}).submit();
}
</script>

<table>
	<tr>
	<%
		for(int i = 0; i < list.size(); i++){
			GoodsVO gvo = list.get(i);
			pageSize = Integer.parseInt(pagingVO.getPageSize());
			groupSize = Integer.parseInt(pagingVO.getGroupSize());
			curPage = Integer.parseInt(pagingVO.getCurPage());
			totalCount = Integer.parseInt(gvo.getTotalCount());
			String image = gvo.getGimage();
			if(i%5 == 4){
		%>
			<td><img src='image/goodsimg/<%= image %>' width="150" height="150"
			id="<%=list.get(i).getGnum() %>"
			onclick="selectGoods(this)">
			<input type="text" id="gname" name="gname" value ="<%= gvo.getGname() %>">
			</td>
		</tr>
		<tr>
		<%
			}else{		
		%>	
			<td><img src='image/goodsimg/<%=image %>' width="150" height="150"
			id="<%=list.get(i).getGnum() %>"
			onclick="selectGoods(this)">
			<input type="text" id="gname" name="gname" value ="<%= gvo.getGname() %>">
			</td>
			<%
			}
		}
	%>
	</tr>
	<input type="hidden" id="gnum" name="gnum" value="">

		
		<tr>
		<td colspan="7" align="right">		
		<input type="button" value="글쓰기" id='I'>
		</td>
		</tr>
		<tr>
<td colspan="7">
<jsp:include page="goodsPaging.jsp" flush="true">
	<jsp:param name="url" value="goodsSelectAllpaging.cd"/>
	<jsp:param name="str" value=""/>
	<jsp:param name="pageSize" value="<%=pageSize%>"/>
	<jsp:param name="groupSize" value="<%=groupSize%>"/>
	<jsp:param name="curPage" value="<%=curPage%>"/>
	<jsp:param name="totalCount" value="<%=totalCount%>"/>
</jsp:include>
</td>
</tr>
</table>
</form>
</body>
</html>