<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@page import="a.b.c.com.ksj.board.service.BoardService"%>
<%@page import="a.b.c.com.ksj.board.service.BoardServiceImpl"%>    
<%@page import="a.b.c.com.ksj.board.vo.BoardVO"%>    
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�� ��ü��ȸ</title>

<!--css-->
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
<!-- jquery-->
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
			location.href='/testKsj/kosmo_ksj/board/board.html';			
		});
		
		// ��ȸ
		$("#S").click(function(){			
			var isudType = document.boardSelectAllForm.ISUD_TYPE.value = "S";			
			send(isudType);		
		});
		
		// �����ϱ� 
		$("#U").click(function(){			

			var nCnt = chkInfo();			
			if (nCnt == 0){	
				console.log('üũ�ڽ��� üũ�ϼ���');
				alert('üũ�ڽ��� üũ�ϼ���');
			}else{	
				var v1 = $("#ISUD_TYPE").val('U');
				alert("v1 >>> : " + v1.val());
				send(v1);				
			}			
		});
		/* �ڹٽ�ũ��Ʈ ����
		document.boardSelectAllForm.ISUD_TYPE.value = "U";
		alert("isudType U >>> : " + document.boardSelectAllForm.ISUD_TYPE.value);
		send(document.boardSelectAllForm.ISUD_TYPE.value);	
	*/
	// jQuery ���� 
		
	
		// �����ϱ� 
		$("#D").click(function(){			
			
			var nCnt = chkInfo();
			if (nCnt == 0){	
				console.log('üũ�ڽ��� üũ�ϼ���');
				alert('üũ�ڽ��� üũ�ϼ���');
			}else{	
				/* �ڹٽ�ũ��Ʈ ����
					document.boardSelectAllForm.ISUD_TYPE.value = "D";
					alert("isudType D >>> : " + document.boardSelectAllForm.ISUD_TYPE.value);
					send(document.boardSelectAllForm.ISUD_TYPE.value);	
				*/
				
				// jQuery ���� 
				var v2 = $("#ISUD_TYPE").val('D');
				alert("v2 >>> : " + v2.val());
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
			
			$("#boardSelectAllForm").attr({
				"action":"/testKsj/board?ISUD_TYPE="+isudType,
				"method":"GET",
				"enctype":"multipart/form-data"
			}).submit();
		}
	});

</script>	
</head>
<% request.setCharacterEncoding("EUC-KR");%> 
SELECT ALL
<%
//alistall-> ��Ʈ�ѿ��� ->����->�ٿ�(�����ͺ��̽����� ��� ������ ��ȸ�ؼ� ������)->�ٽ� ��Ʈ�ѷ����� setattribute�� ����ؼ� aListAll�� �ʱ�ȭ��
//�� ���� ���� ����� getAttribute�� ���ؼ� ������
//�� �������� �ٷ� ���� �ȿ����� ������ ������ �����Ͱ� �־�� obj�� null�� �ƴѵ� null�� �Ǳ⶧���� return �Ǿ� �����.
//�� �������� �����Ų�ٸ� �޾ƿ� �����Ͱ� ���� ������ ������ �߻��Ѵ�.?
// �׷��ٸ� �� �ȿ� �ٷ� �����͸� �޾ƿ��� �Ѵٸ�?..

	Object obj = request.getAttribute("aListAll");
	if (obj == null) return;
	
	ArrayList<BoardVO> aList = (ArrayList<BoardVO>)obj;
	int nCnt = aList.size();
	out.println(":::: ��ü ��ȸ �Ǽ�  " + nCnt + " ��");	
%>
<table>
<tr>
<td calspan="2">
<font size="4" color="blue">
	<!-- <img src="/testKosmo/img/img_mando/ase.gif" width="25" height="25" alter="image"> -->
	BOARD TEST
</font>
</td>
</tr>
</table>
<hr>
<hr>
<form name="boardSelectAllForm" id="boardSelectAllForm">
<table border="1">
<thead>
<tr>
	<td class="tt"><input type="checkbox" name="chkAll" id="chkAll"></td>
	<td class="tt">����</td>
	<td class="tt">�۹�ȣ</td>
	<td class="tt">������</td>
	<td class="tt">����</td>
	<td class="tt">�н�����</td>
	<td class="tt">����</td>
	<td class="tt">�̹���</td>	
	<td class="tt">��������</td>
	<td class="tt">�����</td>
	<td class="tt">������</td>
</tr>
</thead>
<%
	for(int i=0; i<nCnt; i++){
		
		BoardVO kvo = aList.get(i);

%>					
<tbody>
<tr>
	<td class="tt">
		<input type="checkbox" id="knumCheck" name="knumCheck" value=<%= kvo.getKnum() %> onclick="checkOnly(this)">
	</td>		
	<td class="tt"><%= i + 1 %></td>
	<td class="tt"><%= kvo.getKnum() %> </td>
	<td class="tt"><%= kvo.getKsubject() %> </td>
	<td class="tt"><%= kvo.getKwriter() %> </td>
	<td class="tt"><%= kvo.getKpw() %> </td>	
	<td class="tt"><%= kvo.getKmemo() %> </td>
	<!--  <td class="tt"><img src="/testKsj/fileupload/board/<%= kvo.getKphoto() %>"></td>-->
	<td class="tt"><%= kvo.getDeleteyn() %> </td>		
	<td class="tt"><%= kvo.getInsertdate() %> </td>
	<td class="tt"><%= kvo.getUpdatedate() %> </td>		
</tr>	
<%
	}//end of if
%>						
<tr>
	<td colspan="20" align="right">
		<input type="hidden" name="ISUD_TYPE" id="ISUD_TYPE" value="">			
		<input type="button" value="���" id="I">
		<input type="button" value="��ȸ" id="S">
		<input type="button" value="����" id="U">
		<input type="button" value="����" id="D">									
	</td>
</tr>	
</tbody>			
</table>
</form>		
</body>
</html>

