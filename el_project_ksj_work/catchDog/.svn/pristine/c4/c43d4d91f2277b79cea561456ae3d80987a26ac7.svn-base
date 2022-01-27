<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.catchdog.common.K_Session" %>
<%@ page import="java.util.Map" %>
<%
    K_Session ks = K_Session.getInstance();
    Map<String,Object> ssMap = ks.getSession(request);
    String ssMname = "";
	if(ssMap.get("ssMid") != null){
		ssMap.get("ssMname");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	BOARDINSERTFORM
	<hr>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript">
	//location.href="/disadoptionBoardInsertForm.cd";
	/*
	 $(document).ready(function(){
		 $("#disadoptionBoardInsertForm").attr({ "method":"POST"
	         ,"action":"disadoptionBoardInsertForm.cd"}).submit();
		});
	*/


//alert("자바스크립트 블럭 시작 >>> : ")

	$(document).ready(function(){	
		//alert("제이쿼리 블럭 시작 >>> : ")
		// 회원번호 		
		// 이름 
		
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
		// 비밀번호 체크 
		$("#pwCheck").click(function(){
			console.log(" pwCheck 함수 진입");
			var pw = $("#mpw").val();
			// var pw = document.getElementById("mpw").value;
			// var pw_r = document.getElementById("mpw_r").value;			
			// alert(pw + " : " + pw_r);
			 if (pw == "") {
            alert("비밀번호를 입력해 주세요.");
            pw.focus();
            return;
			 }
		});
		
		// 폼태그 데이터 JSP 보내기 
		$("#btn").click(function(){
			//alert("btn click() 함수 진입 >>> : ");
			console.log("btn click() 함수 진입 >>> : ");
			
			/* 
			form 태그에서 서블릿으로 전송되는 데이터 
			콘솔에서 확인하기, alert으로 확인하기				
		*/
		
		//############################################# START
		/*
			자바스크립트 버전 
			
			id 값 : 
				var v1 = document.getElementById('id_name').value;
			name 값 : 
				var v2 = document.form_name.input_name.value;
			class 값 : 
				var v3 = document.getElementsByName('mgender');
			
		*/		
		/*
		1. console.log() : 함수는 웹 브라우저 콘솔에 프린트 하는 함수 이다. 
		                    System.out.println() 과 같다.
		2. document : <html></html>
		3. disadoptionBoardInsertForm : form 태그의 name 속성의 값 form name="disadoptionBoardInsertForm"
		4. mnum : disadoptionBoardInsertForm 태그의 intpu name="mnum" 속성
		5. value : mnum 의 값
		
		<form name="disadoptionBoardInsertForm" id="disadoptionBoardInsertForm">
			<input type="text" name="mnum" id="mnum" readonly/>
		</from>
		*/			
			console.log("anum >>> : " + document.disadoptionBoardInsertForm.anum.value);
			console.log("asubject >>> : " + document.disadoptionBoardInsertForm.asubject.value);
			console.log("apw >>> : " + document.disadoptionBoardInsertForm.apw.value);
			console.log("apw_r >>> : " + document.disadoptionBoardInsertForm.apw_r.value);
			console.log("aname >>> : " + document.disadoptionBoardInsertForm.aname.value);
		
			// 종구분
			var aupkind_check = document.getElementsByName('aupkind');
			for (var i=0; i < aupkind_check.length; i++){
				if(aupkind_check[i].checked == true){
					console.log("aupkind_check["+i+"].value >>> : " + aupkind_check[i].value);
				}
			}
			
			// 세부종
			console.log("akind >>> : " + document.disadoptionBoardInsertForm.akind.value);
			
			console.log("acolor >>> : " + document.disadoptionBoardInsertForm.acolor.value);
			console.log("asize >>> : " + document.disadoptionBoardInsertForm.asize.value);
			console.log("aneut >>> : " + document.disadoptionBoardInsertForm.aneut.value);
			console.log("aage >>> : " + document.disadoptionBoardInsertForm.aage.value);
			// 사진
			console.log("aimage >>> : " + document.disadoptionBoardInsertForm.aimage.value);
			// 거주지역			
			console.log("acaresite >>> : " + document.disadoptionBoardInsertForm.acaresite.value);
			
			// 보호자 연락처
			console.log("acaretel >>> : " + document.disadoptionBoardInsertForm.acaretel.value);
			console.log("acaretel1 >>> : " + document.disadoptionBoardInsertForm.acaretel1.value);
			console.log("acaretel2 >>> : " + document.disadoptionBoardInsertForm.acaretel2.value);
	
			
			// 소개글
			console.log("aspecial >>> : " + document.disadoptionBoardInsertForm.aspecial.value);			
			//############################################# END
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
			
			//############################################# START
		
			$("#disadoptionBoardInsertForm")
			.attr({
					"action":"disadoptionBoardInsertForm.cd",
				    "method":"POST",
				    "enctype":"multipart/form-data"
			       })
			.submit();	
		});
		
	});
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
</script>	
</head>
<body>
<jsp:include page="/include/header.jsp" flush="true"></jsp:include>

<hr>
<form name="disadoptionBoardInsertForm" id="disadoptionBoardInsertForm">
<table border="1" align="center">
	
	<tr>
		<th>글번호</th>
		<td><input type="text" name="anum" id="anum" readonly/></td>
	</tr>
	<tr>
		<th>제목</th>
		<td><input type="text" name="asubject" id="asubject"/></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td><input type="text" name="mname" id="mname" value="<%= ssMap.get("ssMname") %>" readonly/></td>
	</tr>
	<tr>
		<th>글비밀번호</th>
			<td>
			<input type="text" name="apw" id="apw" /><br/>	
			<input type="text" id="apw_r" name="apw_r" placeholder="비밀번호확인" />
			<input type="button" value="비밀번호확인" id="pwCheck"/><br/>
		</td>
	</tr>
	<tr>
		<th>이름</th>
		<td><input type="text" name="aname" id="aname" /></td>
	</tr>
	<tr>
	<th>종구분</th>
	<td> 
		<input type="radio" name="aupkind" id="aupkind" value="01" checked /> 고양이
      	<input type="radio" name="aupkind" id="aupkind" value="02" /> 강아지
    </td>
	</tr>
	<tr>
	<th>세부종</th>		
	<td><input type="text" name="akind" id="akind"/></td>
	</tr>
	<tr>
	<th>색상</th>
	<td>
		<select name="acolor" id="acolor">
        	<option value="1">흰</option>
        	<option value="2">검</option>
        	<option value="2">갈</option>
        	<option value="4">노</option>		        	
        	<option value="5">고등어</option>		        	
        	<option value="6">주</option>		        	
        	<option value="7">회</option>		        	
         </select>
	</td>
	</tr>
	<tr>
	<th>털길이</th>
	<td>
		<select name="afur" id="afur">
        	<option value="01">중장모</option>
        	<option value="02">단모</option>
        	<option value="03">장모</option>	        	
         </select>
	</td>
	</tr>
	<tr>
	<th>크기</th>
	<td>
		<select name="asize" id="asize">
        	<option value="대">대</option>
        	<option value="중">중</option>
        	<option value="소">소</option>	        	
         </select>
	</td>
	</tr>
	<tr>
	<th>중성화 여부</th>
	<td>
		<select name="aneut" id="aneut">
        	<option value="유">유</option>
        	<option value="무">무</option>
        	<option value="미상">미상</option>	        	
         </select>
	</td>
	</tr>
	<tr>
		<th>추정나이</th>
		<td><input type="text" name="aage" id="aage"/></td>
	</tr>
	<tr>
	<th>사진</th>
	<td> 
		<input type="file" name="aimage"  /><br>
    </td>
    </tr>
    <tr>
    <th>성별</th>
    <td> 
		<input type="radio" name="agender" id="agender" value="01" checked /> 남
      	<input type="radio" name="agender" id="agender" value="02" /> 여
    </td>
    </tr>
    <tr>
	<th>보호중인 장소</th>
	<td><input type="hidden" name="acaresite" id="acaresite" />
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
		</select></td>
	</tr>
	<tr>
	<th>보호자 전화번호</th>
	<td>
		<select name="acaretel" id="acaretel">
        	<option value="010">010</option>
        	<option value="011">011</option>        			       
         </select>
		- <input type="text" name="acaretel1" id="acaretel1" size="2" maxlength="4" />
		- <input type="text" name="acaretel2" id="acaretel2" size="2" maxlength="4" />
	</td>
	</tr>
	<tr>
	<th>특징</th>
	<td>
		<textarea name="aspecial" id="aspecial" rows="5" cols="50"> 파양이유 , 소개 , 접종여부					
		</textarea>
	</td>
 	</tr>
<!-- 	
<tr>
	<td>취미</td>
	<td> 
		<input type="checkbox" name="mhobby" value="01" />알고리즘		      
        <input type="checkbox" name="mhobby" value="02" />코딩
        <input type="checkbox" name="mhobby" value="03" />분석설계<br>
        <input type="checkbox" name="mhobby" value="04" />데이터베이스
        <input type="checkbox" name="mhobby" value="05" />스크립트
    </td>
</tr>
 -->	 

<tr>
	<td colspan="2"> 			
		<button type="button" id="btn">보내기</button>
		<button type="reset">다시 </button>	
	</td>				
</tr>
</table>				 		        		     
</form>	
</body>
</html>