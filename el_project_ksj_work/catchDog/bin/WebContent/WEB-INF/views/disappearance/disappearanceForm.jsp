<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOARD 게시판 : 글쓰기</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript" src="/data/data.js"></script>
</head>
<script>
$(function () {	//화면 로딩후 시작
	$("#dikind").autocomplete({  //오토 컴플릿트 시작
		source: List,	// source는 data.js파일 내부의 List 배열
		focus : function(event, ui) { // 방향키로 자동완성단어 선택 가능하게 만들어줌	
			return false;
		},
		minLength: 1,// 최소 글자수
		delay: 100,	//autocomplete 딜레이 시간(ms)
		//disabled: true, //자동완성 기능 끄기
	});
});
</script>
<body>
<jsp:include page="/include/header.jsp" flush="true"></jsp:include>
<script>

		$(document).ready(function(){
		
			
			$("#didate").on("input", function(){
				var m = $("#didate");
				if(m.val().length > m.maxlength){
					m.value = m.value.slice(0, m.maxlength);
				}
			});
			//월
			$("#didate1").append("<option value=''>월--- </option>");
	        for(var i = 1; i <= 12; i++){
	        	if (i < 10){ i = '0'+i;}
	            $("#didate1").append("<option value='"+ i +"'>"+ i + "</option>");
	        }
	        //일
	        $("#didate2").append("<option value=''>일 ---</option>");
	        for(var i = 1; i <= 31; i++){
	        	if (i < 10){ i = '0'+i;}
	            $("#didate2").append("<option value='"+ i +"'>"+ i + "</option>");
	        }
	        
	        $("#position").click(function(){
				console.log("position >>> : ");
				new daum.Postcode({
					oncomplete: function(data) {
					    $("#diposition").val(data.roadAddress); //도로명 주소	
					}
				}).open();
			});
			
			
			$(document).on("click", "#dibtn", function(){
				console.log("sbbtn >>>> : " );
				$('#disappearanceForm').attr({
					'action': 'disappearanceInsert.cd',
					'method' : 'POST',
					'enctype' : 'multipart/form-data'
				}).submit();	
			});
		});
</script>
<form name="disappearanceForm" id="disappearanceForm">
	<table border="1" align="center">
		<tr>
			<td colspan="2" align="center">게시판 글쓰기</td>
		</tr>
		<tr>	
			<td align="center">실종번호</td>
			<td><input type="text" name="dinum" id="dinum" size="20" readonly></td>
		</tr>
		<tr>
			<td align="center">이름</td>
			<td><input type="text" name="diname" id="diname" size="20"></td>
		</tr>
		<tr>
			<td  align="center" >강아지 or 고양이</td>
			<td><select id="diupkind" name = "diupkind">
				<option value="">-------</option>
				<option value="강아지">강아지</option>
				<option value="고양이">고양이</option>
			</select>
			</td>
		</tr>
		<tr>
			<td  align="center">종 구분</td>
			<td><input type="text" name="dikind" id="dikind" >
			</td>
		</tr>
		<tr>
			<td align="center">생년월일</td>
			<td><input type="text" name="didate" id="didate" placeholder="년도(4자)" maxlength="4" style="width: 50px;">
			<select name="didate1" id="didate1"></select>
			<select name="didate2" id="didate2"></select></td>
		</tr>
		<tr>
			<td align="center">나이</td>
			<td><input type="text" id="diage" name="diage" size="20">
			</td>
		</tr>
		<tr>
			<td align="center">핸드폰</td>
			<td><select name="dihp" id="dihp">
				<option value="010">010</option>
				<option value="011">011</option>
				<option value="016">016</option>
				<option value="017">017</option>
			</select>
			<input type="text" name="dihp1" id="dihp1" size="2" maxlength="4">
			<input type="text" name="dihp2" id="dihp2" size="2" maxlength="4"></td>
		</tr>
		<tr>
			<td align="center">실종위치</td>
			<td><input type="text" id ="diposition" name="diposition" size="50" readonly>
				<input type="button" id="position" name="position" value="검색">
			</td>
			
		</tr>
		<tr>
			<td  align="center">사진</td>
			<td>
			<input type="file" name="diimage" id="diimage">
			</td>
		</tr>
		<tr>
			<td align="center">특징</td>
			<td><textarea  id="dispecial" name="dispecial" cols="50" rows="10" ></textarea>
			</td>
		</tr> 
		<tr>
			<td colspan="2" align="right">						
			<input type="button" value="등록" id="dibtn">	
			<input type="reset" value="다시">	
			
			</td>				
		</tr>	
	</table>
</form>
</body>
</html>