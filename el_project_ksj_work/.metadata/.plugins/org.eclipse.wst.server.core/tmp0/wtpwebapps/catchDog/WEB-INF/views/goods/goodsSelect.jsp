<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.catchdog.goods.vo.GoodsVO" %> 
<%@ page import="java.util.List" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table, tr, td, input, textarea{text-align:center;}
</style>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	//  U
	$(document).on("click", "#U", function(){
		//alert("U >>> : ");		
		$("#goodsUpdateForm").attr({ "method":"GET"
			                        ,"action":"goodsUpdate.cd"}).submit();
	});
	$(document).on("click", "#D", function(){
		//alert("D >>> : ");
		$("#goodsUpdateForm").attr({ "method":"GET"
			                        ,"action":"goodsDelete.cd"}).submit();
	});
	$(document).on("click", "#PayButton", function(){
		$("#goodsUpdateForm").attr({ "method":"POST"
            ,"action":"goodsPay.cd"}).submit();
});
});//ready
</script>			
</head>					
<body>					
<jsp:include page="/include/header.jsp" flush="true"></jsp:include>		
<%
	Object obj = request.getAttribute("listS");
	List<GoodsVO> list = (List)obj;
	GoodsVO gvo = null;
	if (list.size() == 1) {
		gvo = list.get(0);
	};
	System.out.println("셀렉트 gvo.getGnum()->>>"+gvo.getGnum());
	System.out.println("셀렉트 gvo.getGpdnum-->>>"+gvo.getGpdnum());
	System.out.println("셀렉트 gvo.getGimage ->> "+gvo.getGimage());
%>


<form name="goodsUpdateForm" id="goodsUpdateForm">
<table>

<input type="hidden" name="gimage" id="gimage" value="<%= gvo.getGimage() %>">					
<tr>				
<td rowspan="7"><img src='image/goodsimg/<%= gvo.getGimage() %>' width="300" height="300"></td>
<td> 상품명 : <input type="text" name="gname" id="gname" value="<%= gvo.getGname() %>" readonly/>
</td>
</tr>
<tr>						
<td>글번호 : <input type="text" name="gnum" id="gnum" value="<%= gvo.getGnum() %>" readonly/></td>
</tr>						
<tr>						
<td>상품번호 : <input type="text" name="gpdnum" id="gpdnum" value="<%= gvo.getGpdnum() %>" readonly/></td>
</tr>															
<tr>						
<td>등록일 : <input type="text" name="gdday" id="gdday" value="<%= gvo.getGdday() %>" readonly />		      
</td>					
</tr>					
<tr>					
<td>목표금액 : <input type="text" name="gtarget" id="gtarget" value="<%= gvo.getGtarget() %>" readonly/>		      
</td>				
</tr>				
<tr>				
<td>상품가격 : <input type="text" name="gprice" id="gprice" value="<%= gvo.getGprice() %>" readonly/>		      
</td>				
</tr>
<tr>					
<td colspan="2" align="center" > 		
<!--  <button type="button" id="U">수정</button>-->
<!--  <button type="button" id="D">삭제</button>-->
<input type="button" id="PayButton" value="결제하기">
</td>				
</tr>
<tr>				
<td><script src="http://code.jquery.com/jquery-latest.min.js">
							let specialSize = '<%= gvo.getGdetail() %>';
						</script>
<p style="margin-top: 30px;">상세사항 : </p><textarea id="gdetail" name="gdetail" readonly><%= gvo.getGdetail()%></textarea>
</td>					
</tr>							
			
</table>		
</form>			
</body>		
</html>		