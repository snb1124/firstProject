<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "com.catchdog.shelter.vo.CatchdogVO" %>
<%@ page import = "java.util.List" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>지역동물보호소찾기</title>
</head>
<body>
<% request.setCharacterEncoding("UTF-8");%> 
<%
	int curPage = 0;
	int pageSize = 0;
	int groupSize = 0;
	int totalCount = 0;
	
	//페이징 데이터
	Object objPaging = request.getAttribute("pagingVO");
	CatchdogVO pagingVO = (CatchdogVO)objPaging;

	// 게시판 데이터 
	Object obj = request.getAttribute("aList");
	List<CatchdogVO> list = (List)obj;

	int nCnt = list.size();
	System.out.println("nCnt >>> : " + nCnt);		
%>  
<jsp:include page="/include/header.jsp"	flush="true"></jsp:include>
<div id="map" style= "width:600px;height:300px;margin-top:50px;margin-left:auto;margin-right:auto;"></div>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=aaab031f80e0cd017ab6fa5edea946d3&libraries=services"></script>
<script>
$(document).ready(function(){
	

	// 주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();
	
	geocoder.addressSearch($(".address").eq(1).text(), function(result, status) {
		
	    // 정상적으로 검색이 완료됐으면 
	     if (status === kakao.maps.services.Status.OK) {
	
	        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
	
	        // 결과값으로 받은 위치를 마커로 표시합니다
	        var marker = new kakao.maps.Marker({
	            map: map,
	            position: coords
	        });
	
	        // 인포윈도우로 장소에 대한 설명을 표시합니다
	        var infowindow = new kakao.maps.InfoWindow({
	            content: $(".address").eq(1).text() // 여기에 꾸며주면됨.
	        });
	        infowindow.open(map, marker);
	
	        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
	        map.setCenter(coords);
	  	  } 
	});  
	
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(35.922355665, 128.599034473), // 초기 지도 중심좌표값
        level: 3 // 지도의 확대 레벨
    };  
	    
	// 지도를 생성합니다    
	var map = new kakao.maps.Map(mapContainer, mapOption);
		
		$('.address').click(function(){
		
			var address = $(this).text();

//			alert(address);
	
	geocoder.addressSearch(address, function(result, status) {
	
	    // 정상적으로 검색이 완료됐으면 
	     if (status === kakao.maps.services.Status.OK) {
	
	        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
	
	        // 결과값으로 받은 위치를 마커로 표시합니다
	        var marker = new kakao.maps.Marker({
	            map: map,
	            position: coords
	        });
	
	        // 인포윈도우로 장소에 대한 설명을 표시합니다
	        var infowindow = new kakao.maps.InfoWindow({
	            content: address // 여기에 꾸며주면됨.
	        });
	        infowindow.open(map, marker);
	
	        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
	        map.setCenter(coords);
	  	  } 
		});  

	});

});
</script>
<form name="boardList" id="boardList">
	<table border="1">
		<thead>
			<tr>
				<td colspan="10" align="center">
				<h2>게시판</h2>
				</td>
			</tr>
		
			<tr>
				<td class="tt">보호소 명</td>
				<td class="address">보호소 주소</td>
				<td class="tt">보호소 번호</td>

			</tr>
		</thead>
		<%
			curPage = Integer.valueOf(pagingVO.getCurPage());
			pageSize = Integer.valueOf(pagingVO.getPageSize());
			groupSize = Integer.valueOf(pagingVO.getGroupSize());
			totalCount = Integer.valueOf(pagingVO.getTotalCount());
			
			for(int i=0; i<nCnt; i++){		
				CatchdogVO cdvo = list.get(i);			
		%>
		<tbody>
			<tr class="mapp" >
				<td class="tt" id="csname"><%=cdvo.getCsname() %></td>
				<td class="address"><%=cdvo.getCsaddress() %></td> 
				<td class="tt"><%=cdvo.getCstel() %></td>

			</tr>
			<% 
			} // end of for
			%>
			<tr>
				<td colspan="7">
				
				<jsp:include page="shelterPasing.jsp" flush="true">
					<jsp:param name="url" value="shelter.cd" />
					<jsp:param name="str" value=""/>
					<jsp:param name="curPage" value="<%=curPage %>" />
					<jsp:param name="pageSize" value="<%=pageSize %>" />
					<jsp:param name="groupSize" value="<%=groupSize %>" />
					<jsp:param name="totalCount" value="<%=totalCount %>" />
				</jsp:include>
				</td>
			</tr>
		</tbody>
	</table>
</form>
</body>
</html>