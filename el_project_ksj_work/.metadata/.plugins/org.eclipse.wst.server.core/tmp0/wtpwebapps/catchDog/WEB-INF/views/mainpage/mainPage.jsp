<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.catchdog.mainpage.vo.MainPageVO" %>
<%@ page import="com.catchdog.common.K_Session" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%
	K_Session ks = K_Session.getInstance();
	Map<String,Object> ssMap = ks.getSession(request);
	String mnum = "";
	if(ssMap.get("ssMnum") != null) mnum = (String)ssMap.get("ssMnum"); 
	List<MainPageVO> alist = (List<MainPageVO>)request.getAttribute("alist");
	List<MainPageVO> dlist = (List<MainPageVO>)request.getAttribute("dlist");
	List<MainPageVO> glist = (List<MainPageVO>)request.getAttribute("glist");
 %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>CatchDog</title>
		<style type="text/css">
			img {
				cursor:pointer;
			}
		</style>
		<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&display=swap" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css2?family=Yeon+Sung&display=swap" rel="stylesheet">
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
		
			function selectAdoption(ele){
				let id = ele.id;
				$("#anum").val(id);
				
				$("#boardnum").attr({
					"action":"/adoptionSelect.cd",
					"method":"GET",
					"enctype":"application/x-www-form-urlencoded"
				}).submit();
			}
			function selectDisappearance(ele){
				let id = ele.id;
				$("#dinum").val(id);
				
				$("#boardnum").attr({
					"action":"/disappearanceSelect.cd",
					"method":"POST",
					"enctype":"application/x-www-form-urlencoded"
				}).submit();
			}
			function selectGoods(ele){
				let id = ele.id;
				$("#gnum").val(id);
				
				$("#boardnum").attr({
					"action":"/goodsSelect.cd",
					"method":"POST",
					"enctype":"application/x-www-form-urlencoded"
				}).submit();
			}
		</script>
	</head>
	<body id="main">
		<jsp:include page="/include/header.jsp" flush="true"></jsp:include>
		<div class="blue"></div>
		<img class="logo" src="image/bg/b.jpg" alt="" style="cursor: default;">
		<table id="adoption" class="adoption">
			<tr>
				<td colspan="4"><p>당신을 위한 맞춤 추천!</p></td>
				<td><a href="adoptionSelectAll.cd"><p style="font-size:25px; text-align:right;">더보기>></p></a></td>
			</tr>
			<tr>
			<%
				if(!alist.isEmpty()){
					for(int i=0; i<alist.size(); i++){
						
						if(!alist.get(i).getAnum().contains("AA")){
			%>
				<td><img src="<%= alist.get(i).getImage() %>" 
				onerror="this.src='image/image-available.jpg'"
				id="<%= alist.get(i).getAnum() %>"
				onclick="selectAdoption(this)"><br>
            <input type="text" value="<%= alist.get(i).getSpecialvaluea() + ", " + alist.get(i).getSpecialvalueb() %>"></td>
			<%
						}
						
						else{
			%>
				<td><img src="/image/disadoptionimg/<%= alist.get(i).getImage() %>" 
				onerror="this.src='image/image-available.jpg'"
				id="<%= alist.get(i).getAnum() %>"
				onclick="selectAdoption(this)"><br>
            	<input type="text" value="<%= alist.get(i).getSpecialvaluea() + ", " + alist.get(i).getSpecialvalueb() %>"></td>
			<%			
						}
					}
				}
			%>
			</tr>
		</table>
		<table id="disappearance">
			<tr>
				<td colspan="4"><p>찾아주세요</p></td>
				<td><a href="/disappearanceselectAll.cd"><p style="font-size:25px; text-align:right;">더보기>></p></a></td>
			</tr>
			<tr>
			<%
				if(!dlist.isEmpty()){
					for(int i=0; i<dlist.size(); i++){
			%>
				<td><img src="/image/disappearanceimg/<%= dlist.get(i).getImage() %>"
				onerror="this.src='image/image-available.jpg'"
				id="<%= dlist.get(i).getDinum() %>"
				onclick="selectDisappearance(this)"><br>
				<b>실종위치</b>
<input type="text" value="<%= dlist.get(i).getSpecialvaluea() %>"></td>
			<%
					}
				}
			%>
			</tr>
		</table>
		<table id="goods">
			<tr>
				<td colspan="4"><p>굿즈</p></td>
				<td><a href="/goodsSelectAllpaging.cd"><p style="font-size:25px; text-align:right;">더보기>></p></a></td>
			</tr>
			<tr>
			<%
				if(!glist.isEmpty()){
					for(int i=0; i<glist.size(); i++){
			%>
				<td><img src="/image/goodsimg/<%= glist.get(i).getImage() %>" 
				onerror="this.src='image/image-available.jpg'"
				id="<%= glist.get(i).getGnum() %>"
				onclick="selectGoods(this)"><br>
<input  type="text" class="goods" value="<%= glist.get(i).getSpecialvaluea() %>"><br>
<input  type="text" class="goods" value="<%= glist.get(i).getSpecialvalueb() %>"></td>
			<%
					}
					if(glist.size() < 5){
						for(int i=glist.size(); i<5; i++){
							%>
								<td><img src="/image/goodsimg/noimage.png"
								onerror="this.src='image/image-available.jpg'"
								id="noData"
								onclick="selectGoods(this)"></td>
							<%
						}
					}
				}
			%>
			</tr>
		</table>
		<form id="boardnum">
			<input type="hidden" id="boardnumber" name="boardnumber">
			<input type="hidden" id="mnum" name="mnum">
			<input type="hidden" id="anum" name="anum">
			<input type="hidden" id="dinum" name="dinum">
			<input type="hidden" id="gnum" name="gnum">
		</form>
	</body>
</html>