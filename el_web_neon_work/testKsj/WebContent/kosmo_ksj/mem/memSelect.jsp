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
<title>�� ��ü��ȸ</title>
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
<!-- ���� �ּҷ� OPEN API CDN �ҷ�����  -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">
	
	$(document).ready(function(){	
		
		// �̸��� 
		$('#kemail2').change(function(){	
		$("#kemail2 option:selected").each(function () {
			if($(this).val()== '1'){ //�����Է��� ��� 
					var aa = $("#kemail1").val();
					//alert("aa >>> : " + aa);
					$("#kemail1").val(''); //�� �ʱ�ȭ 
					$("#kemail1").attr("readonly",false); //Ȱ��ȭ 				
			}else{ //�����Է��� �ƴҰ�� 
					$("#kemail1").val($(this).text()); //���ð� �Է� 
					$("#kemail1").attr("readonly",true); //��Ȱ��ȭ 
			}}); 
		}); 	
		
		// �����ȣ	
		$("#zonecode").click(function(){
			console.log("zonecode >>> : ");
			new daum.Postcode({
				oncomplete: function(data) {
				    $("#kzonecode").val(data.zonecode); //5�ڸ� �������ȣ ���
				    $("#kroadaddress").val(data.roadAddress); //���θ� �ּ�
				    $("#kgibunaddress").val(data.gibunAddress); //�����ּ�			
				}
			}).open();
		});
	});

	function memUpdate(actionUpdate){
		console.log("memUpdate ���� >>> : " + actionUpdate);
				
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
		console.log("actionName ���� >>> : " + actionName);
		
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
	out.println(":::: ���� ��ȸ >>> : " + nCnt + " ��");
		
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
		
		// ����
		kgender = mvo.getKgender();
		// �������
		kbirth = CodeUtil.birth(mvo.getKbirth());
		// �ڵ���
		khp = CodeUtil.hp(mvo.getKhp());
		// ��ȭ��ȣ
		ktel = CodeUtil.tel(mvo.getKtel());		
		// �̸��� 
		kemail = mvo.getKemail();
		// �ּ�
		kzonecode = mvo.getKzonecode();	
		kroadaddress= mvo.getKroadaddress();
		String addr[] = kroadaddress.split("@");
		kroadaddress = addr[0];
		//�迭���� ������ ����� ���� 
		kroadaddressdetail = addr[0];
		kgibunaddress = mvo.getKgibunaddress();		
		// ���
		khobby = mvo.getKhobby();
	}
%>
<hr>
<div>
<form name="memUpdateForm" id="memUpdateForm">
<table border="1">
<script>
function compCheck(){
	console.log("compCheck >>> ���� >>> : ");

	// ����
	var gen = '<%= kgender %>';
	console.log("gen >>> : "  + gen);
	if ('01' == gen){
		document.getElementsByName("kgender")[0].checked = true;
	}
	if ('02' == gen){
		document.getElementsByName("kgender")[1].checked = true;
	}
	
	// �̸��� 
	var email = '<%= kemail %>';	
	var emails = email.split('@');
	document.getElementById("kemail").value = emails[0];
	document.getElementById("kemail1").value = emails[1];
	
	// ���
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
					
		<font size="4" style="color:blue;">ȸ������ ���� && ����</font> 
	<!-- 	<img src="/testKsj/img/img_mando/ase.gif" width="25" height="25" alt="image"> -->		
	</td>				
</tr>
<tr>
	<td>ȸ����ȣ</td>
	<td><input type="text" name="knum" id="knum" value="<%= mvo.getKnum() %>" readonly /></td>
 </tr>
<tr>
	<td>�̸�</td>
	<td><input type="text" name="kname" id="kname" value="<%= mvo.getKname() %>" readonly /></td>
</tr>
<tr>
	<td>���̵�</td>
	<td>
		<input type="text" name="kid" id="kid" style="width:100px" value="<%= mvo.getKid() %>" readonly />	
	</td>
</tr>
<tr>
	<td>�н�����</td>
	<td>
		<input type="text" name="kpw" id="kpw" style="width:100px" value="<%= mvo.getKpw() %>" readonly /><br/>		
	</td>
</tr>
<tr>
	<td>����</td>
	<td> 
		<input type="radio" name="kgender" id="kgender" value="01" checked /> ����
      	<input type="radio" name="kgender" id="kgender" value="02" /> ����
    </td>
</tr>
<tr>
	<td>�������</td>
	<td>		
		<input type="text" name="kbirth" id=kbirth value="<%= kbirth %>" readonly />		
	</td>
</tr>
<tr>
	<td>�ڵ���</td>
	<td>
		<input type="text" name="khp" id="khp" value="<%= khp %>" readonly />
	</td>
</tr>
<tr>
	<td>��ȭ��ȣ</td>
	<td>
		<input type="text" name="ktel" id="ktel" value="<%= ktel %>" readonly />
	</td>
	</td>
</tr>
<tr>
	<td>�̸���</td>
	<td>		
		<input type="text" name="kemail"  id="kemail" style="width:100px"  />
		@ <input type="text" name="kemail1" id="kemail1" style="width:100px" 
			placeholder="�����Է�" />
		<select name="kemail2" id="kemail2">
        	 <option value="1" selected>�����Է�</option>
       		 <option value="naver.com">naver.com</option>	       	   
      		 <option value="gmail.com">gmail.com</option>
      		 <option value="daum.net">daum.net</option>	       	   
         </select>
	</td>
</tr>
<tr>
 	<td>�ּ�</td>
 	<td>
 		<input type="text" name="kzonecode" id="kzonecode" 
 			placeholder="�����ȣ" style="width:50px" value="<%= kzonecode %>" >
 		<input type="button" name="zonecode" id="zonecode" value="�����ȣ ã��"><br>	 	
 		<input type="text" name="kroadaddress" id="kroadaddress" 
 			placeholder="���θ��ּ�" style="width:250px" value="<%= kroadaddress %>" ><br>	 	
 		<input type="text" name="kroadaddressdetail" id="kroadaddressdetail" 
 			placeholder="���θ��ּ� ���ּ�" style="width:250px" value="<%= kroadaddressdetail %>" ><br>	 	
 		<input type="text" name="kgibunaddress" id="kgibunaddress"
 			 placeholder="�����ּ�" style="width:250px" value="<%= kgibunaddress %>">
 	</td>
</tr>	 
<tr>
	<td>���</td>
	<td> 
		<input type="checkbox" name="khobby" value="01" />�˰���		      
        <input type="checkbox" name="khobby" value="02" />�ڵ�
        <input type="checkbox" name="khobby" value="03" />�м�����<br>
        <input type="checkbox" name="khobby" value="04" />�����ͺ��̽�
        <input type="checkbox" name="khobby" value="05" />��ũ��Ʈ
    </td>
</tr>	 
<tr>
	<td>�Ұ���</td>
	<td>
		<textarea name="kinfo" id="kinfo" rows="5" cols="50"><%= mvo.getKinfo() %>				
		</textarea>
	</td>
 </tr>
 <tr>
	<td>����</td>
	<td> 
		<img src="/testKsj/fileupload/member/<%= mvo.getKphoto() %> " border="1" width="25" height="25" alt="image">
    </td>
</tr>
<tr>
	<td colspan="2" align="center">	
	<input type="hidden" name="ISUD_TYPE" id="ISUD_TYPE" >
	<input type="button" value="����" onclick="memUpdate('U')"/>
	<input type="button" value="����" onclick="memUpdate('D')"/>
    <input type="reset" value="���" />
    &nbsp;&nbsp;&nbsp;&nbsp;
    <input type="button" value="�Է�" onclick="checkAction('I')"/>
	<input type="button" value="���" onclick="checkAction('SALL');">
</td>	
<tr>			
</table>
</form>
</div>
</body>
</html>