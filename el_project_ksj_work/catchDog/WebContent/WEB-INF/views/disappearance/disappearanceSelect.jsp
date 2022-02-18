<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.catchdog.disappearance.vo.DisappearanceVO" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>실종 전단 화면</title>
		<style type="text/css">
			table, tr, td, input, textarea{text-align:center;}
		</style>
	</head>
	<body>
		<jsp:include page="/include/header.jsp" flush="true"></jsp:include>
		
		<%
			Object obj = request.getAttribute("listSelect");
			List<DisappearanceVO> listSelect = null;
			DisappearanceVO divo = null;
			if(obj != null){
				listSelect = (List<DisappearanceVO>)obj;
				if(listSelect != null){
				divo = listSelect.get(0);
				}
			}
		%>
		
		
		<form id="disappearanceSelectForm" name="disappearanceSelectForm">
			<table>
				<tr>
					<td rowspan="7">
						<img src='/image/disappearanceimg/<%=divo.getDiimage() %>' width="300" height="300"
							onerror="this.src='image/image-available.jpg'">
					</td>
					<td>
						이름 : <input type="text" id="diname" name="diname" value="<%=divo.getDiname()%>" readonly>
					</td>
				</tr>
				<tr>
					<td>
						나이 : <input type="text" id = "diage" name="diage" value="<%=divo.getDiage()%>" readonly>
					</td>
				</tr>
				<tr>
					<td>
						종 : <input type="text" id="dikind" name="dikind" value="<%=divo.getDikind()%>" readonly>
					</td>
				</tr>
				<tr>
					<td>
						실종날짜 : <input type="text" id = "didate" name="didate" value="<%=divo.getDidate()%>" readonly>
					</td>
				</tr>
				<tr>
					<td>
						실종위치 : <input type="text" id = "diposition" name="diposition" value="<%=divo.getDiposition() %>" readonly>
					</td>
				</tr>
				<tr>
					<td>
						특징 : <input type="text" id = "dispecial" name="dispecial" value= "<%=divo.getDispecial()%>"  readonly>
							 
					</td>
				</tr>
				<tr>
					<td> 
						연락처 : <input type="text" id = "dihp" name="dihp" value="<%=divo.getDihp() %>" readonly>
					</td>
				</tr>	
			</table>

		</form>
		<div id="map" style= "width:800px;height:400px;margin-top:50px;margin-left:auto;margin-right:auto;"></div>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=aaab031f80e0cd017ab6fa5edea946d3&libraries=services"></script>
<script>
$(document).ready(function(){
	
	

	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(35.922355665, 128.599034473), // 초기 지도 중심좌표값
        level: 3 // 지도의 확대 레벨
    };  
	    
	// 지도를 생성합니다    
	var map = new kakao.maps.Map(mapContainer, mapOption); 

	// 주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();
		
	var address = "<%=divo.getDiposition()%>";
	
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
	            content: "실종위치"
	  
	        });
	        infowindow.open(map, marker);
	
	        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
	        map.setCenter(coords);
	  	  } 
		});  


});
		</script>
	</body>
</html>