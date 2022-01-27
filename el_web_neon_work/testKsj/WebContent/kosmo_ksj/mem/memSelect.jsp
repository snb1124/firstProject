<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@page import="a.b.c.com.ksj.mem.service.MemberService"%>
<%@page import="a.b.c.com.ksj.mem.service.MemberServiceImpl"%>    
<%@page import="a.b.c.com.ksj.mem.vo.MemberVO"%>  
<%@page import="a.b.c.com.common.CodeUtil"%>   
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>글 전체조회</title>
<style type="text/css">
	* {
		margin: 0 auto;
		/*text-align: center;*/
	}
	
	div {
		margin: 50px 0px 0px 100px;
	}			

	td, th {
		 padding: 5px;
	}
	
	.tt {
		text-align: center;
	}
</style>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<!-- 다음 주소록 OPEN API CDN 불러오기  -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">
	
	$(document).ready(function(){	
		
		// 이메일 
		$('#kemail2').change(function(){	
		$("#kemail2 option:selected").each(function () {
			if($(this).val()== '1'){ //직접입력일 경우 
					var aa = $("#kemail1").val();
					//alert("aa >>> : " + aa);
					$("#kemail1").val(''); //값 초기화 
					$("#kemail1").attr("readonly",false); //활성화 				
			}else{ //직접입력이 아닐경우 
					$("#kemail1").val($(this).text()); //선택값 입력 
					$("#kemail1").attr("readonly",true); //비활성화 
			}}); 
		}); 	
		
		// 우편번호	
		$("#zonecode").click(function(){
			console.log("zonecode >>> : ");
			new daum.Postcode({
				oncomplete: function(data) {
				    $("#kzonecode").val(data.zonecode); //5자리 새우편번호 사용
				    $("#kroadaddress").val(data.roadAddress); //도로명 주소
				    $("#kgibunaddress").val(data.gibunAddress); //지번주소			
				}
			}).open();
		});
	});

	function memUpdate(actionUpdate){
		console.log("memUpdate 진입 >>> : " + actionUpdate);
				
		if ('U' == actionUpdate){
			var v1 = "UOK";		
			document.memUpdateForm.action="/testKsj/mem?ISUD_TYPE="+v1;			
		}
		
		if ('D' == actionUpdate){
			var v2 = "DOK";
			document.memUpdateForm.action="/testKsj/mem?ISUD_TYPE="+v2;
		}
		
		document.memUpdateForm.method="POST";
		document.memUpdateForm.enctype="application/x-www-form-urlencoded";
		document.memUpdateForm.submit();		
	}
	
	function checkAction(actionName){
		console.log("actionName 진입 >>> : " + actionName);
		
		if ('I' == actionName){	
			location.href="/testKsj/kosmo_ksj/mem/mem.html";
		}
		if ('SALL' == actionName){			
			location.href="/testKsj/mem?ISUD_TYPE=SALL";
		}
	}	
</script>
</head>
<body onload="compCheck()">
<% request.setCharacterEncoding("EUC-KR");%> 
SELECT 
<%
	Object obj = request.getAttribute("aListS");
	if (obj == null) return;
	
	ArrayList<MemberVO> aList = (ArrayList<MemberVO>)obj;
	int nCnt = aList.size();
	out.println(":::: 조건 조회 >>> : " + nCnt + " 건");
		
	String kgender = "";
	String kbirth = "";
	String khp = "";
	String ktel = "";
	String kemail = "";	
	String kzonecode = "";
	String kroadaddress = "";	
	String kroadaddressdetail = "";
	String kgibunaddress = "";
	String khobby = "";				
		
	MemberVO mvo = null;	
	if (nCnt == 1){
		mvo = aList.get(0);
		
		// 성별
		kgender = mvo.getKgender();
		// 생년월일
		kbirth = CodeUtil.birth(mvo.getKbirth());
		// 핸드폰
		khp = CodeUtil.hp(mvo.getKhp());
		// 전화번호
		ktel = CodeUtil.tel(mvo.getKtel());		
		// 이메일 
		kemail = mvo.getKemail();
		// 주소
		kzonecode = mvo.getKzonecode();	
		kroadaddress= mvo.getKroadaddress();
		String addr[] = kroadaddress.split("@");
		kroadaddress = addr[0];
		//배열에서 문제가 생긴거 같음 
		kroadaddressdetail = addr[0];
		kgibunaddress = mvo.getKgibunaddress();		
		// 취미
		khobby = mvo.getKhobby();
	}
%>
<hr>
<div>
<form name="memUpdateForm" id="memUpdateForm">
<table border="1">
<script>
function compCheck(){
	console.log("compCheck >>> 진입 >>> : ");

	// 성별
	var gen = '<%= kgender %>';
	console.log("gen >>> : "  + gen);
	if ('01' == gen){
		document.getElementsByName("kgender")[0].checked = true;
	}
	if ('02' == gen){
		document.getElementsByName("kgender")[1].checked = true;
	}
	
	// 이메일 
	var email = '<%= kemail %>';	
	var emails = email.split('@');
	document.getElementById("kemail").value = emails[0];
	document.getElementById("kemail1").value = emails[1];
	
	// 취미
	var hobs = '<%= khobby %>';
	console.log("hobs >>> : "  + hobs);
	var hob = hobs.split(',');
	for (var m=0; m < hob.length; m++){
		var hobValue = hob[m];
		console.log("hobValue >>> : " + hobValue);
		if ('01' == hobValue){
			document.getElementsByName("khobby")[0].checked = true;
		}
		if ('02' == hobValue){
			document.getElementsByName("khobby")[1].checked = true;
		}
		if ('03' == hobValue){
			document.getElementsByName("khobby")[2].checked = true;
		}
		if ('04' == hobValue){
			document.getElementsByName("khobby")[3].checked = true;
		}
		if ('05' == hobValue){
			document.getElementsByName("khobby")[4].checked = true;
		}		
	}
}
</script>
<tr>	
	<td colspan="2" align="center">	
					
		<font size="4" style="color:blue;">회원정보 수정 && 삭제</font> 
	<!-- 	<img src="/testKsj/img/img_mando/ase.gif" width="25" height="25" alt="image"> -->		
	</td>				
</tr>
<tr>
	<td>회원번호</td>
	<td><input type="text" name="knum" id="knum" value="<%= mvo.getKnum() %>" readonly /></td>
 </tr>
<tr>
	<td>이름</td>
	<td><input type="text" name="kname" id="kname" value="<%= mvo.getKname() %>" readonly /></td>
</tr>
<tr>
	<td>아이디</td>
	<td>
		<input type="text" name="kid" id="kid" style="width:100px" value="<%= mvo.getKid() %>" readonly />	
	</td>
</tr>
<tr>
	<td>패스워드</td>
	<td>
		<input type="text" name="kpw" id="kpw" style="width:100px" value="<%= mvo.getKpw() %>" readonly /><br/>		
	</td>
</tr>
<tr>
	<td>성별</td>
	<td> 
		<input type="radio" name="kgender" id="kgender" value="01" checked /> 여자
      	<input type="radio" name="kgender" id="kgender" value="02" /> 남자
    </td>
</tr>
<tr>
	<td>생년월일</td>
	<td>		
		<input type="text" name="kbirth" id=kbirth value="<%= kbirth %>" readonly />		
	</td>
</tr>
<tr>
	<td>핸드폰</td>
	<td>
		<input type="text" name="khp" id="khp" value="<%= khp %>" readonly />
	</td>
</tr>
<tr>
	<td>전화번호</td>
	<td>
		<input type="text" name="ktel" id="ktel" value="<%= ktel %>" readonly />
	</td>
	</td>
</tr>
<tr>
	<td>이메일</td>
	<td>		
		<input type="text" name="kemail"  id="kemail" style="width:100px"  />
		@ <input type="text" name="kemail1" id="kemail1" style="width:100px" 
			placeholder="직접입력" />
		<select name="kemail2" id="kemail2">
        	 <option value="1" selected>직접입력</option>
       		 <option value="naver.com">naver.com</option>	       	   
      		 <option value="gmail.com">gmail.com</option>
      		 <option value="daum.net">daum.net</option>	       	   
         </select>
	</td>
</tr>
<tr>
 	<td>주소</td>
 	<td>
 		<input type="text" name="kzonecode" id="kzonecode" 
 			placeholder="우편번호" style="width:50px" value="<%= kzonecode %>" >
 		<input type="button" name="zonecode" id="zonecode" value="우편번호 찾기"><br>	 	
 		<input type="text" name="kroadaddress" id="kroadaddress" 
 			placeholder="도로명주소" style="width:250px" value="<%= kroadaddress %>" ><br>	 	
 		<input type="text" name="kroadaddressdetail" id="kroadaddressdetail" 
 			placeholder="도로명주소 상세주소" style="width:250px" value="<%= kroadaddressdetail %>" ><br>	 	
 		<input type="text" name="kgibunaddress" id="kgibunaddress"
 			 placeholder="지번주소" style="width:250px" value="<%= kgibunaddress %>">
 	</td>
</tr>	 
<tr>
	<td>취미</td>
	<td> 
		<input type="checkbox" name="khobby" value="01" />알고리즘		      
        <input type="checkbox" name="khobby" value="02" />코딩
        <input type="checkbox" name="khobby" value="03" />분석설계<br>
        <input type="checkbox" name="khobby" value="04" />데이터베이스
        <input type="checkbox" name="khobby" value="05" />스크립트
    </td>
</tr>	 
<tr>
	<td>소개글</td>
	<td>
		<textarea name="kinfo" id="kinfo" rows="5" cols="50"><%= mvo.getKinfo() %>				
		</textarea>
	</td>
 </tr>
 <tr>
	<td>사진</td>
	<td> 
		<img src="/testKsj/fileupload/member/<%= mvo.getKphoto() %> " border="1" width="25" height="25" alt="image">
    </td>
</tr>
<tr>
	<td colspan="2" align="center">	
	<input type="hidden" name="ISUD_TYPE" id="ISUD_TYPE" >
	<input type="button" value="수정" onclick="memUpdate('U')"/>
	<input type="button" value="삭제" onclick="memUpdate('D')"/>
    <input type="reset" value="취소" />
    &nbsp;&nbsp;&nbsp;&nbsp;
    <input type="button" value="입력" onclick="checkAction('I')"/>
	<input type="button" value="목록" onclick="checkAction('SALL');">
</td>	
<tr>			
</table>
</form>
</div>
</body>
</html>