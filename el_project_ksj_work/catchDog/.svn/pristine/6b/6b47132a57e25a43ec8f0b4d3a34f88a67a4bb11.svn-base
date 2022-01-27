<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.catchdog.common.DogSizeUtil" %>
<%@ page import="com.catchdog.common.CatSizeUtil" %>
<%
// 개
String[] dogSize = DogSizeUtil.DOG_SIZE; //사이즈
String[] dogKind = DogSizeUtil.DOG_KIND; //종류

// 고양이
String[] catLength = CatSizeUtil.CAT_LEGNTH; //털길이
String[] catKind = CatSizeUtil.CAT_KIND; //종류
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관심 동물 선택</title>
<style type="text/css">
	form {
		margin-left: auto !important;
		margin-right: auto !important;
		width: 50%;
		align: center;
	}
	#imgAupkind_01, #imgAupkind_02{
		border: 5px solid #e8e8e8;
	}
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){	
		
		// 지역
		$("#acaresite1").on('change',function(){
			
			var idx = $(this).val(); // 첫번째 select 선택 값 가져오기
			
			$('#acaresite2').children('option:not(:first)').remove(); // 두번째 select option값 지우기 (첫번째 option 제외)
			
			for(var i=0; i<cities[idx].length; i++){ // combo1의 크기만큼 for문 반복
				var optiondata = cities[idx][i];
				$('#acaresite2').append('<option value="'+optiondata+'">'+optiondata+'</option>'); // option 추가하기
			}	
			$("#acaresite").val($("#acaresite1 option:checked").text());
		});	
		$("#acaresite2").on('change',function(){
			$("#acaresite").val($("#acaresite1 option:checked").text()+ " " +$("#acaresite2 option:checked").text());			 
		});

		$("#btn").click(function(){
			
			// 성별
			var agender_check = document.getElementsByName('agender');
			for (var i=0; i < agender_check.length; i++){
				if (agender_check[i].checked == true){
					console.log("agender_check["+i+"].value >>> : " + agender_check[i].value);
				}
			}
			
			var agender_check = $('input:radio[name=agender]:checked').val();
			console.log("agender_check.value >>> : " + agender_check);
			
			
			$("#recommendForm").attr({
				"action":"recommendInsert.cd",
				"method":"POST"
			}).submit();
		});
		
		// 종
		$("img[name=imgAupkind]").click(function(){ // 여러 객체 이벤트 동시
			var idNo = ($(this).attr("id")).replace("imgAupkind_",""); // 고유 값 갖고오기
			
			// 다시 누를 경우를 생각하여 다 숨기고 시작한다.
			$(".long").hide();
			$(".short").hide();
			$(".big").hide();
			$(".mid").hide();
			$(".small").hide();
			
			if(idNo == "01"){ // 고유값에 따른 처리 분기
				$("#imgAupkind_02").css("border", "5px solid #e8e8e8");
				$("#catsize").hide();
				$(".long").hide();
				$(".short").hide();
				if($("#dogsize").is(":visible")){
					$("#dogsize").slideUp("slow");					
					$("#imgAupkind_01").css("border", "5px solid #e8e8e8");
					$("#aupkind").val("");
					$("[name=asize]").attr("checked", false);
				} else {
					$("#dogsize").slideDown("slow");
					$("#imgAupkind_01").css("border", "5px solid #F7AA58");
					$("#aupkind").val(idNo);
				}
				$("[name=afur]").attr("checked", false);
				$("[name=akind]").attr("checked", false);
			} else if (idNo == "02"){
				$("#imgAupkind_01").css("border", "5px solid #e8e8e8");
				$("#dogsize").hide();
				$(".big").hide();
				$(".mid").hide();
				$(".small").hide();
				if($("#catsize").is(":visible")){
					$("#catsize").slideUp("slow");	
					$("#imgAupkind_02").css("border", "5px solid #e8e8e8");
					$("#aupkind").val("");
					$("[name=afur]").attr("checked", false);
				}else{
					$("#catsize").slideDown("slow");
					$("#imgAupkind_02").css("border", "5px solid #F7AA58");
					$("#aupkind").val(idNo);
				}
				$("[name=asize]").attr("checked", false);
				$("[name=akind]").attr("checked", false);
			}
			
			
			//alert($("#aupkind").val())
		});
		
		// 크기(개)
		$("[name=asize]").click(function(){
			var asize = $(this).val();
			if (asize == "대형견"){
				$(".big").show();
				$(".mid").hide();
				$(".small").hide();
			}else if(asize == "중형견"){
				$(".mid").show();
				$(".big").hide();
				$(".small").hide();
			}else if(asize == "소형견"){
				$(".small").show();
				$(".big").hide();
				$(".mid").hide();
			}
		});
		
		// 털길이(고양이)
		$("[name=afur]").click(function(){
			var afur = $(this).val();
			if (afur == "장모"){
				$(".long").show();
				$(".short").hide();
			}else if(afur == "단모"){
				$(".long").hide();
				$(".short").show();
			}
		});
		
		/* $(document).on("click", "#S", function(){
			$("#recommendForm").attr({"method":"POST", "action":"recommendSelect.cd"}).submit();
		}); */
		var cities = [
			["강남구","강동구","강북구","강서구","관악구","광진구","구로구","금천구","노원구","도봉구","동대문구","동작구","마포구","서대문구","서초구","성동구","성북구","송파구","양천구","영등포구","용산구","은평구","종로구","중구","중랑구"],
			["강서구","금정구","기장군","남구","동구","동래구","부산진구","북구","사상구","사하구","서구","수영구","연제구","영도구","중구","해운대구"],
			["남구","달서구","달성군","동구","북구","서구","수성구","중구"],
			["강화군","계양구","남동구","동구","미추홀구","부평구","서구","연수구","옹진군","중구"],
			["광산구","남구","동구","북구","서구"],																																											
			["대덕구","동구","서구","유성구","중구"],																																											
			["남구","동구","북구","울주군","중구"],																																											
			[],
			["가평군","고양시 덕양구","고양시 일산동구","고양시 일산서구","과천시","광명시","광주시","구리시","군포시","김포시","남양주시","동두천시","부천시","성남시 분당구","성남시 수정구","성남시 중원구","수원시 권선구","수원시 영통구","수원시 장안구","수원시 팔달구","시흥시","안산시 단원구","안산시 상록구","안성시","안양시 동안구","안양시 만안구","양주시","양평군","여주시","연천군","오산시","용인시 기흥구","용인시 수지구","용인시 처인구","의왕시","의정부시","이천시","파주시","평택시","포천시","하남시","화성시"],
			["강릉시","고성군","동해시","삼척시","속초시","양구군","양양군","영월군","원주시","인제군","정선군","철원군","춘천시","태백시","평창군","홍천군","화천군","횡성군"],																																										
			["괴산군","단양군","보은군","영동군","옥천군","음성군","제천시","증평군","진천군","청주시 상당구","청주시 서원구","청주시 청원구","청원시 흥덕구","충주시"],
			["계룡시","공주시","금산군","논산시","당진시","보령시","부여군","서산시","서천군","아산시","예산군","천안시 동남구","천안시 서북구","청양군","태안군","홍성군"],
			["고창군","군산시","김제시","남원시","무주군","부안군","순창군","완주군","익산시","임실군","장수군","전주시 덕진구","전주시 완산구","정읍시","진안군"],
			["강진군","고흥군","곡성군","광양시","구례군","나주시","담양군","목포시","무안군","보성군","순천시","신안군","여수시","영광군","영암군","완도군","장성군","장흥군","진도군","함평군","해남군","화순군"],
			["경산시","경주시","고령군","구미시","군위군","김천시","문경시","봉화군","상주시","성주군","안동시","영덕군","영양군","영주시","영천시","예천군","울릉군","울진군","의성군","청도군","청송군","칠곡군","포항시 남구","포항시 북구"],
			["거제시","거창군","고성군","김해시","남해군","밀양시","사천시","산청군","양산시","의령군","진주시","창녕군","창원시 마산합포구","창원시 마산회원구","창원시 성산구","창원시 의창구","창원시 진해구","통영시","하동군","함안군","함양군","합천군"],
			["서귀포시","제주시"]
		];
	});
	
	
</script>
</head>
<body>
<jsp:include page="/include/header.jsp" flush="true"></jsp:include>

	<form name="recommendForm" id="recommendForm">
		<input type="hidden" name="mnum" id="mnum" value="<%= request.getParameter("mnum") %>"/>
		<input type="hidden" name="aupkind" id="aupkind" value="" />
		
		<div style="margin: auto;">종
				<img name="imgAupkind" id="imgAupkind_01" src="image/recommendimg/88_1423.jpg" height="200" width="200" style="cursor: pointer;"/>
				<img name="imgAupkind" id="imgAupkind_02" src="image/recommendimg/KakaoTalk_20210913_100553050.jpg" height="200" width="200"  style="cursor: pointer;"/>

		</div>
		<div id="dogsize" style="display:none;">
			<div>크기
				<div class="asize">
					<label>
						<input type="radio" name="asize" value="대형견">
						<div class="label">대형견</div>
					</label>
					<label>
						<input type="radio" name="asize" value="중형견">
						<div class="label">중형견</div>
					</label>
					<label>
						<input type="radio" name="asize" value="소형견">
						<div class="label">소형견</div>
					</label>					
				</div>
			</div>
				
				<div class="akind">
				<%
				for(int i=0; i<dogSize.length; i++){
					if (dogSize[i] == "대형") {
						%>
						<label class="big" style="display: none;">
							<input type="radio" name="akind" value="<%=dogKind[i] %>">
							<div class="label"><%=dogKind[i] %></div>
						</label>
						<%
					} else if (dogSize[i] == "중형") {
						%>
						<label class="mid" style="display: none;">
							<input type="radio" name="akind" value="<%=dogKind[i] %>">
							<div class="label"><%=dogKind[i] %></div>
						</label>
						<%
					} else if (dogSize[i] == "소형") {
						%>
						<label class="small" style="display: none;">
							<input type="radio" name="akind" value="<%=dogKind[i] %>">
							<div class="label"><%=dogKind[i] %></div>
						</label>
						<%
					}
				}
				%>
				</div>				
		</div>
		<div id="catsize" style="display:none;">
			<div>털 길이
					<div class="afur">
						<label>
							<input type="radio" name="afur" value="장모"/>
							<div class="label">장모</div>
						</label>
						<label>
							<input type="radio" name="afur" value="단모" />
							<div class="label">단모</div>
						</label>			
					</div>
					<div class="akind">
						<%
							for (int i=0; i < catLength.length; i++){
								if (catLength[i] == "장모"){
						%>
						<label class="long" style="display:none;">
							<input type="radio" name="akind" value="<%= catKind[i] %>">
							<div class="label"><%= catKind[i] %></div>
						</label>
						<%
								}else if(catLength[i] == "단모"){
						%>
						<label class="short" style="display:none;">
							<input type="radio" name="akind" value="<%= catKind[i] %>">
							<div class="label"><%= catKind[i] %></div>
						</label>
						<%
								}
							}
						%>
					</div>
				</div>
		</div>
			<div>성별
				<input type="radio" name="agender" value="암컷" checked /> 암컷
				<input type="radio" name="agender" value="수컷" /> 수컷

			<div>지역
				<input type="hidden" name="acaresite" id="acaresite" />
				<select name="acaresite1" id="acaresite1">
					<option>시/도 선택</option>
					<option value="0" title="서울특별시">서울특별시</option>
					<option value="1" title="부산광역시">부산광역시</option>
					<option value="2" title="대구광역시">대구광역시</option>
					<option value="3" title="인천광역시">인천광역시</option>
					<option value="4" title="광주광역시">광주광역시</option>
					<option value="5" title="대전광역시">대전광역시</option>
					<option value="6" title="울산광역시">울산광역시</option>
					<option value="7" title="세종특별자치시">세종특별자치시</option>
					<option value="8" title="경기도">경기도</option>
					<option value="9" title="강원도">강원도</option>
					<option value="10" title="충청북도">충청북도</option>
					<option value="11" title="충청남도">충청남도</option>
					<option value="12" title="전라북도">전라북도</option>
					<option value="13" title="전라남도">전라남도</option>
					<option value="14" title="경상북도">경상북도</option>
					<option value="15" title="경상남도">경상남도</option>
					<option value="16" title="제주특별자치도">제주특별자치도</option>
				</select>
				<select name="acaresite2" id="acaresite2">
					<option value="선택">시/군/구 선택</option>
				</select>
			</div>

		<div>
			<button type="button" id="btn">가입하기</button>
			<button type="reset">다시</button>
			<!-- <button type="button" id="S">조회테스트</button> -->
		</div>
		</div>
</form>
</body>
</html>