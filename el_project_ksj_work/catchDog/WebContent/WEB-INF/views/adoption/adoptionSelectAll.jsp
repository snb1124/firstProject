<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.catchdog.adoption.vo.AdoptionVO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.catchdog.common.RegionUtil" %>
<%
	List<AdoptionVO> listAll = (List<AdoptionVO>)request.getAttribute("listAll");
	System.out.println("listAll >>> : " + listAll);
	
	AdoptionVO avopaging = (AdoptionVO)request.getAttribute("adoptionVO");
	int pageSize = avopaging.getPageSize();
	int curPage = avopaging.getCurPage();
	int groupSize = avopaging.getGroupSize();
	int totalCount = avopaging.getTotalCount();
	String agend = avopaging.getAgender();
	if(agend == null) agend = "";
	String asiz = avopaging.getAsize();
	if(asiz == null) asiz = "";
	String region = avopaging.getAcaresite();
	if(region == null) region = "allregion";
	System.out.println("adoptionSelectAll string region >>> : " + RegionUtil.getRegionValue(region));
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>입양신청 목록</title>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				
				let asiz = '<%=asiz%>';
				let agend = '<%=agend%>';
				let region = '<%=RegionUtil.getRegionValue(region)%>';
				if(asiz != null) $("#asize").val(asiz);
				if(agend != null) $("#agender").val(agend);
				$("#regionSelect").val(region).prop("selected", true);
				console.log($("#regionSelect option:selected").val(region).text());
				$("#acaresite").val($("#regionSelect option:selected").val(region).text());
				
				$("#regionSelect").change(function(){
					$("#regionSelect option:selected").each(function(){
						//alert("this.text >>> : " + $(this).text());
						$("#acaresite").val($(this).text());
					});
					$("#asize").val("");
					$("#agender").val("");
					$("#curPage").val(1);
					$("#adoptionSelectAllForm").attr({
						"action":"/adoptionSelectAll.cd",
						"method":"GET",
						"enctype":"application/x-www-form-urlencoded"
					}).submit();
				});
				
				$("#shortfur").click(function(){
					$("#acaresite").val("");
					$("#agender").val("");
					$("#asize").val($("#shortfur").text());
					$("#curPage").val(1);
					$("#adoptionSelectAllForm").attr({
						"action":"/adoptionSelectAll.cd",
						"method":"GET",
						"enctype":"application/x-www-form-urlencoded"
					}).submit();
				});
				$("#longfur").click(function(){
					$("#acaresite").val("");
					$("#agender").val("");
					$("#asize").val($("#longfur").text());
					$("#curPage").val(1);
					$("#adoptionSelectAllForm").attr({
						"action":"/adoptionSelectAll.cd",
						"method":"GET",
						"enctype":"application/x-www-form-urlencoded"
					}).submit();
				});
				$("#smallsize").click(function(){
					$("#acaresite").val("");
					$("#agender").val("");
					$("#asize").val($("#smallsize").text());
					$("#curPage").val(1);
					$("#adoptionSelectAllForm").attr({
						"action":"/adoptionSelectAll.cd",
						"method":"GET",
						"enctype":"application/x-www-form-urlencoded"
					}).submit();
				});
				$("#middlesize").click(function(){
					$("#acaresite").val("");
					$("#agender").val("");
					$("#asize").val($("#middlesize").text());
					$("#curPage").val(1);
					$("#adoptionSelectAllForm").attr({
						"action":"/adoptionSelectAll.cd",
						"method":"GET",
						"enctype":"application/x-www-form-urlencoded"
					}).submit();
				});
				$("#bigsize").click(function(){
					$("#acaresite").val("");
					$("#agender").val("");
					$("#asize").val($("#bigsize").text());
					$("#curPage").val(1);
					$("#adoptionSelectAllForm").attr({
						"action":"/adoptionSelectAll.cd",
						"method":"GET",
						"enctype":"application/x-www-form-urlencoded"
					}).submit();
				});
				$("#male").click(function(){
					$("#acaresite").val("");
					$("#asize").val("");
					$("#agender").val('M');
					$("#curPage").val(1);
					$("#adoptionSelectAllForm").attr({
						"action":"/adoptionSelectAll.cd",
						"method":"GET",
						"enctype":"application/x-www-form-urlencoded"
					}).submit();
				});
				$("#female").click(function(){
					$("#acaresite").val("");
					$("#asize").val("");
					$("#agender").val('F');
					$("#curPage").val(1);
					$("#adoptionSelectAllForm").attr({
						"action":"/adoptionSelectAll.cd",
						"method":"GET",
						"enctype":"application/x-www-form-urlencoded"
					}).submit();
				});
				
			});
				
			function selectAdoption(ele){
				let id = ele.id;
				$("#anum").val(id);
				//alert("id >>> : " + id);
				$("#curPage").val(1);
				
				$("#adoptionSelectAllForm").attr({
					"action":"/adoptionSelect.cd",
					"method":"GET",
					"enctype":"application/x-www-form-urlencoded"
				}).submit();
			}
			
			function goAdoptionSelectAll(curPage){
				//alert("goAdoptionSelectAll Parameter >>> : " + curPage);
				$("#curPage").val(curPage);
				//alert("goAdoptionSelectAll region >>> : " + $("#regionSelect option:selected").val());
				$("#adoptionSelectAllForm").attr({
					"action":"/adoptionSelectAll.cd",
					"method":"GET",
					"enctype":"application/x-www-form-urlencoded"
				}).submit();
			}
		</script>
	</head>
	<body>
		<jsp:include page="/include/header.jsp" flush="true"></jsp:include>
		<form name="adoptionSelectAllForm" id="adoptionSelectAllForm">
			<!-- 검색 테이블 -->
			<table border="1" style="text-align:center;">
				<tr>
					<td colspan="3" style="text-align:center;">분류</td>
				</tr>
				<tr>
					<td rowspan="3">지역 : <select id="regionSelect">
						<option value="allregion">전체</option>
						<option value="seoul">서울특별시</option>
						<option value="busan">부산광역시</option>
						<option value="daegu">대구광역시</option>
						<option value="incheon">인천광역시</option>
						<option value="gwangju">광주광역시</option>
						<option value="daejeon">대전광역시</option>
						<option value="ulsan">울산광역시</option>
						<option value="sejong">세종특별자치시</option>
						<option value="kyungki">경기도</option>
						<option value="kangwon">강원도</option>
						<option value="chungbuk">충청북도</option>
						<option value="chungnam">충청남도</option>
						<option value="jeonbuk">전라북도</option>
						<option value="jeonnam">전라남도</option>
						<option value="kyungbuk">경상북도</option>
						<option value="kyungnam">경상남도</option>
						<option value="jeju">제주도</option>
					</select></td>
					<td><span id="catonly">고양이 :</span> <span id="shortfur">단모</span> <span id="longfur">장모</span></td>
				</tr>
				<tr>
					<td><span id="dogonly">강아지 :</span> <span id="smallsize">소형</span> <span id="middlesize">중형</span> <span id="bigsize">대형</span></td>
				</tr>
				<tr>
					<td><span id="anigender">성별 :</span> <span id="male">남</span> <span id="female">여</span></td>
				</tr>
			</table>
			<!-- 동물 사진 테이블 -->
			<table style="text-align:center; margin: 0px auto;">
				<tr>
			<%
				for(int i=0; i<listAll.size(); i++){
					AdoptionVO avo = listAll.get(i);
					String image = avo.getAimage();
					
					if(i%5 == 4){
			%>
					<td><div><img src='<%= image %>' width="150" height="150"
					onerror="this.src='image/image-available.jpg'"
					id="<%= listAll.get(i).getAnum() %>"
					onclick="selectAdoption(this)">
					</div></td>
				</tr>
				<tr>
			<%
					} else {
			%>
					<td><div><img src='<%= image %>' width="150" height="150"
					onerror="this.src='image/image-available.jpg'"
					id="<%= listAll.get(i).getAnum() %>"
					onclick="selectAdoption(this)">
					</div></td>
			<%
					}
				}
			%>
			</tr>
			<tr>
				<!-- 검색을 위한 히든태그들 -->
				<td><input type="hidden" id="anum" name="anum" value=""></td>
				<td><input type="hidden" id="acaresite" name="acaresite" value=""></td>
				<td><input type="hidden" id="asize" name="asize" value=""></td>
				<td><input type="hidden" id="agender" name="agender" value=""></td>
				<td><input type="hidden" id="curPage" name="curPage" value=""></td>
			</tr>
			<tr>
				<td colspan="13">
					<jsp:include page="adoptionPaging.jsp" flush="true">
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