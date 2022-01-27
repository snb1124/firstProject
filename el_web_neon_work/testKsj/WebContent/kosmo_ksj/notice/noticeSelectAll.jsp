<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@page import="a.b.c.com.ksj.notice.service.NoticeService"%>
<%@page import="a.b.c.com.ksj.notice.service.NoticeServiceImpl"%>    
<%@page import="a.b.c.com.ksj.notice.vo.NoticeVO"%>    
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�������� ��ü��ȸ</title>
<style type="text/css">
	* {
		margin: 0 auto;
		/*text-align: center;*/
	}
				

	td, th {
		 padding: 5px;
	}
	
	.tt {
		text-align: center;
	}
</style>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

	//üũ�ڽ� üũ Ȯ���ϱ� 
	function checkOnly(chk){
		// alert(">>> : " + chk);
		var chkObj = document.getElementsByName("knumCheck");
		console.log("chkObj >>> : " + chkObj);
		for (var i=0; i < chkObj.length; i++){
			if (chkObj[i] != chk){
				chkObj[i].checked = false;
			}
		}
	}
	
	$(document).ready(function(){	

		// ����ϱ� 
		$("#I").click(function(){			
			location.href='/testKsj/kosmo_ksj/notice/notice.html';			
		});
		
		// ��ü��ȸ
		$("#S").click(function(){			
			var isudType = document.noticeSelectAllForm.ISUD_TYPE.value = "S";			
			send(isudType);		
		});
		
		// �����ϱ� 
		$("#U").click(function(){			

			var nCnt = chkInfo();			
			if (nCnt == 0){	
				console.log('üũ�ڽ��� üũ�ϼ���');
				alert('üũ�ڽ��� üũ�ϼ���');
			}else{					// jQuery ���� 
				var v1 = $("#ISUD_TYPE").val('U');
				alert("v1 >>> : " + v1.val());
				send(v1);				
			}			
		});
		
	
		// �����ϱ� 
		$("#DOK").click(function(){			
			
			var nCnt = chkInfo();
			if (nCnt == 0){	
				console.log('üũ�ڽ��� üũ�ϼ���');
				alert('üũ�ڽ��� üũ�ϼ���');
			}else{				
				// jQuery ���� 
				var v2 = $("#ISUD_TYPE").val('DOK');
				alert("���������� �����Ͻðڽ��ϱ�.  >>> : " + v2.val());
				send(v2);
			}					
		});
		
		// üũ�ڽ� üũ ī��Ʈ
		function chkInfo(){			
			var obj = document.getElementsByName("knumCheck");
			var nCnt = 0;			
			for(var i=0; i < obj.length; i++){ 
	          	if (obj[i].checked == true){ 
	          		nCnt++;
	          	}		          			            
	        }			
			console.log('nCnt >>> : ' + nCnt);			
			return nCnt;
		}
		
		// submit 
		function send(isudType){
			alert("isudType send >>> : " + isudType);
			
			$("#noticeSelectAllForm").attr({
				"action":"/testKsj/notice2?ISUD_TYPE="+isudType,
				"method":"GET",
				"enctype":"application/x-www-form-urlencoded"
			}).submit();
		}
	});

</script>	
</head>
<% request.setCharacterEncoding("EUC-KR");%> 
SELECT ALL
<%
	Object obj = request.getAttribute("aListAll");
	if (obj == null) return;
	
	ArrayList<NoticeVO> aList = (ArrayList<NoticeVO>)obj;
	int nCnt = aList.size();
	out.println(":::: ��ü ��ȸ �Ǽ�  " + nCnt + " ��");	
%>
<table>
<tr>
<td calspan="2">
<font size="4" color="blue">
	<!-- <img src="/testKosmo/img/img_mando/ase.gif" width="25" height="25" alter="image"> -->
	NOTICE TEST
</font>
</td>
</tr>
</table>
<hr>
<hr>
<form name="noticeSelectAllForm" id="noticeSelectAllForm">
<table border="1">
<thead>
<tr>
	<td class="tt"><input type="checkbox" name="chkAll" id="chkAll"></td>
	<td class="tt">����</td>
	<td class="tt">��ȣ</td>
	<td class="tt">������</td>
	<td class="tt">����</td>
	<td class="tt">����</td>
	<td class="tt">��������</td>
	<td class="tt">�����</td>
	<td class="tt">������</td>
</tr>
</thead>
<%
	for(int i=0; i<nCnt; i++){
		
		NoticeVO nvo = aList.get(i);

%>					
<tbody>
<tr>
	<td class="tt">
		<input type="checkbox" id="knumCheck" name="knumCheck" value=<%= nvo.getKnum() %> onclick="checkOnly(this)">
	</td>		
	<td class="tt"><%= i + 1 %></td>
	<td class="tt"><%= nvo.getKnum() %> </td>
	<td class="tt"><%= nvo.getKsubject() %> </td>
	<td class="tt"><%= nvo.getKmemo() %> </td>
	<td class="tt"><img src="/testKsj/fileupload/notice/<%= nvo.getKphoto() %> " border="1" width="25" height="25" alt="image"></td>
	<td class="tt"><%= nvo.getDeleteyn() %> </td>		
	<td class="tt"><%= nvo.getInsertdate() %> </td>
	<td class="tt"><%= nvo.getUpdatedate() %> </td>		
</tr>	
<%
	}//end of if
%>						
<tr>
	<td colspan="9" align="right">
		<input type="hidden" name="ISUD_TYPE" id="ISUD_TYPE" value="">			
		<input type="button" value="���" id="I">
		<input type="button" value="��ȸ" id="S">
		<input type="button" value="����" id="U">
		<input type="button" value="����" id="DOK">									
	</td>
</tr>	
</tbody>			
</table>
</form>		
</body>
</html>

