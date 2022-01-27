<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입</title>
		<style type="text/css">
			h3 { align: center; }
			table { align: center;}
			table, tr, td { border: 1px solid black; }
		</style>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				//아이디 중복 체크 시작 =========================
				$("#midbtn").click(function(){
					console.log("idCheck >> : ");
					
					let midVal = $("#mid").val();
					if(midVal == ''){
						alert("중복체크할 아이디를 입력하세요");
						$("#mid").focus();
						return false;
					}
					alert("중복체크 >>> : ");
					syncIdCheckData();
				});
				
				async function syncIdCheckData(){
					let idCheckData = '';
					console.log("start >>> :");
					var vv = $("#mid").val();
					alert("vv >>> : " + vv);
					idCheckData = await ajaxIdCheckData(vv);
					alert("리턴된 데이터 >>> : " + idCheckData);
					
					alert("idCheck data >>> : " + idCheckData);
					if("ID_YES" == idCheckData){
						alert("아이디 사용 가능 >>> : ID_YES");
						$("#mid").attr("readonly", true);
						$("#mid").css("background-color", "yellow");
						$("#mpw").focus();
					}
					else if("ID_NO" == idCheckData){
						alert("중복된 아이디. 사용불가 >>> : ID_NO");
						$("#mid").val();
						$("#mid").focus();
					}
				}
				
				function ajaxIdCheckData(myval){
					alert("myval >>> : " + myval);
					
					let idCheckURL = "memIdCheck.cd";
					let method = "POST";
					let dataParam = { mid: myval };
					
					return $.ajax({
						url: idCheckURL,
						type: method,
						data: dataParam
					});
				}
				//아이디 중복체크 끝 ================================
					
				
				//비밀번호 체크 
				$("#pwCheck").click(function(){
					console.log("pwCheck 함수 진입 ");
					var pw = $("#mpw").val();
					var pw_r = $("#mpw_r").val();
					console.log("mpw >>> : " + pw);
					console.log("mpw_r >>> : " + pw_r);
					if(pw == pw_r){
						alert("비밀번호가 같습니다");
						$("#mpw_r").val('');
						$("#mgender").focus();
						return true;
					} else {
						alert("비밀번호가 다릅니다");
						$("#mpw").val();
						$("#mpw_r").val();
						$("#mpw").focus();
						return false;
					}
				});
				
				//생년월일
				$("#mbirth").on("input", function(){
					var m = $("#mbirth");
					if(m.val().length > m.maxlength){
						m.value = m.value.slice(0, m.maxlength);
					}
				});
				//월
				$("#mbirth1").append("<option value=''>월--- </option>");
		        for(var i = 1; i <= 12; i++){
		        	if (i < 10){ i = '0'+i;}
		            $("#mbirth1").append("<option value='"+ i +"'>"+ i + "</option>");
		        }
		        //일
		        $("#mbirth2").append("<option value=''>일 ---</option>");
		        for(var i = 1; i <= 31; i++){
		        	if (i < 10){ i = '0'+i;}
		            $("#mbirth2").append("<option value='"+ i +"'>"+ i + "</option>");
		        }
		        //이메일
		        $('#memail2').change(function(){	
		    		$("#memail2 option:selected").each(function () {
		    			if($(this).val()== '1'){ //직접입력일 경우 
		    					var aa = $("#memail1").val();
		    					$("#memail1").val(''); 
		    					$("#memail1").attr("readonly",false); 				
		    			}else{ //직접입력이 아닐경우 
		    					$("#memail1").val($(this).text()); 
		    					$("#memail1").attr("readonly",true); 
	    				}
		    		}); 
	    		}); 	
		        //우편번호
		        $("#zonecode").click(function(){
					console.log("zonecode >>> : ");
					new daum.Postcode({
						oncomplete: function(data) {
						    $("#mzonecode").val(data.zonecode); //5자리 새우편번호 사용
						    $("#mroadaddress").val(data.roadAddress); //도로명 주소
						    $("#mjibunaddress").val(data.jibunAddress); //지번주소			
						}
					}).open();
				});
		        //폼태그 데이터 JSP 보내기
		        $("#btn").click(function(){
		        	console.log("btn click() 함수 진입 >>> : ");

		        	console.log("mnum >>> : " + document.memForm.mnum.value);			
					console.log("mname >>> : " + document.memForm.mname.value);
					console.log("mid >>> : " + document.memForm.mid.value);
					console.log("mpw >>> : " + document.memForm.mpw.value);
					console.log("mpw_r >>> : " + document.memForm.mpw_r.value);
		        	$("#memForm").attr({
		        		"action":"memInsert.cd",
		        		"method":"POST",
		        		"enctype":"multipart/form-data"

					
					
		        	}).submit();
		        });
			});
		</script>
	</head>
	<body>
	<jsp:include page="/include/header.jsp" flush="true"></jsp:include>
	
		<hr>
		<form name="memForm" id="memForm">
			<table>
				<tr>
					<td colspan="2" align="center">
						<font size="4" style="color: blue;">회원가입</font>
						
					</td>
				</tr>
				<tr>
					<td>회원번호</td>
					<td><input type="text" name="mnum" id="mnum" readonly></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="mname" id="mname"></td>
				</tr>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="mid" id="mid">
					<input type="button" name="midbtn" id="midbtn" value="중복체크"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="mpw" id="mpw"><br>
					<input type="password" name="mpw_r" id="mpw_r">
					<input type="button" id="pwCheck" value="비밀번호확인"></td>
				</tr>
				<tr>
					<td>성별</td>
					<td><input type="radio" name="mgender" id="mgender" value="01" checked> 여자 
					<input type="radio" name="mgender" id="mgender" value="02"> 남자 </td>
				</tr>
				<tr>
					<td>생년월일</td>
					<td><input type="text" name="mbirth" id="mbirth" placeholder="년도(4자)" maxlength="4" style="width: 50px;">
					<select name="mbirth1" id="mbirth1"></select>
					<select name="mbirth2" id="mbirth2"></select></td>
				</tr>
				<tr>
					<td>핸드폰</td>
					<td><select name="mhp" id="mhp">
						<option value="010">010</option>
						<option value="011">011</option>
						<option value="016">016</option>
						<option value="017">017</option>
					</select>
					<input type="text" name="mhp1" id="mhp1" size="2" maxlength="4">
					<input type="text" name="mhp2" id="mhp2" size="2" maxlength="4"></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="text" name="memail" id="memail" style="width: 100px;">@
					<input type="text" name="memail1" id="memail1" style="width: 100px;" placeholder="직접입력">
					<select name="memail2" id="memail2">
						<option value="1" selected>직접입력</option>
						<option value="naver.com" selected>naver.com</option>
						<option value="gmail.com" selected>gamil.com</option>
						<option value="daum.net" selected>daum.net</option>
					</select></td>
				</tr>
				<tr>
					<td>주소</td>
					<td>
						<input type="text" name="mzonecode" id="mzonecode" placeholder="우편번호" style="width: 50px;" maxlength="6">
						<input type="button" name="zonecode" id="zonecode" value="우편번호찾기"><br>
						<input type="text" name="mroadaddress" id="mroadaddress" placeholder="도로명주소" style="width: 250px;"><br>
						<input type="text" name="mroadaddressdetail" id="mroadaddressdetail" placeholder="도로명주소 상세주소" style="width:250px"><br>	 	
 						<input type="text" name="mjibunaddress" id="mjibunaddress" placeholder="지번주소" style="width:250px">
					</td>
				</tr>
		
				<tr>
					<td colspan="2">
						<button type="button" id="btn">보내기</button>
						<button type="reset">다시</button>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>