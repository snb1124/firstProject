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
var sell_price;
var amount;

function init () {
	
	sell_price2 = document.form.sell_price.value;
	sell_price = parseInt(sell_price2);
	amount = document.form.amount.value;
	document.form.sum.value = sell_price;
	change();
}

function add () {
	hm = document.form.amount;
	sum = document.form.sum;
	hm.value ++ ;

	sum.value = parseInt(hm.value) * sell_price;
}

function del () {
	hm = document.form.amount;
	sum = document.form.sum;
		if (hm.value > 1) {
			hm.value -- ;
			sum.value = parseInt(hm.value) * sell_price;
		}
}

function change () {
	hm = document.form.amount;
	sum = document.form.sum;

		if (hm.value < 0) {
			hm.value = 0;
		}
	sum.value = parseInt(hm.value) * sell_price;
}   

$(document).ready(function(){
	
	$('#kakaoPay').click(function(){
		$.ajax({
			url : 'kakaoPay.cd',
			dataType : 'json',
			success : function(data){
				var box = data.next_redirect_pc_url;
				var tid = data.tid;
				$("#tid").val(data.tid);
				console.log(data);
				window.open(box);
			},
			error : function(error){
				console.log(error);
			}	
		});
	});

});//ready
</script>			
</head>					
<body onload="init()">					
<jsp:include page="/include/header.jsp" flush="true"></jsp:include>		
<%
	System.out.println("goodspay.jsp진입");
	Object obj = request.getAttribute("gvo");
	GoodsVO  gvo = (GoodsVO)obj;
	String str = gvo.getGprice();
%>
<form name="form" method="get">
<table border ="1">
	<tr>
		<th><img src="image/goodsimg/<%=gvo.getGimage() %>"></th>
		<th><%= gvo.getGprice() %></th>
		<th>주소 : 경기도 성남시 중원구 현성아파트 301호</th>
		<th>가격 : <%=gvo.getGprice()%>
		<th>수량 : <input type="hidden" name="sell_price" id="sell_price" value="<%=gvo.getGprice()%>" >
				 <input type="text" name="amount" id="amount" value="1" size="3" onchange="change();">
				 <input type="button" value=" + " onclick="add();">
				 <input type="button" value=" - " onclick="del();"><br>
		        금액 :<input type="text" name="sum" id = "sum" size="11" readonly>원 
			 	 
			</th>
				 
		<th><input type ="button"  id="kakaoPay"name="kakaoPay" value="카카오페이로 결제하기"></th>	
</table>
 </form>
</body>		
</html>		