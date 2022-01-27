<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="a.b.c.com.ksj.board.service.BoardService"%>
<%@page import="a.b.c.com.ksj.board.service.BoardServiceImpl"%>    
<%@page import="a.b.c.com.ksj.board.vo.BoardVO"%>    
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�Խ��� ��ü ��ȸ</title>
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
		text-color : BLACK;
	}
</style>
<!-- CDN -->
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

sendFunc = null;

	$(document).ready(function(){
		console.log("aa");
		sendFunc = send;
		
		// Insert
		$("#I").click(function(){
			location.href="/TestPjw/Pjw/Board/board.html";
		});
		
		// submit 
		function send(isudType){
			
			var num = $("#buumh").val();
			
			console.log("isudType send >>> : " + num);
			
			$("#boardSelectAllForm").attr({
				"action":"/TestPjw/board?ISUD_TYPE="+isudType,
				"method":"GET",
				"enctype":"application/x-www-form-urlencoded"
			}).submit();
			
			 
		}
	});



	function clicksub(a) {
		
		document.getElementById("buumh").value = a;		
		sendFunc('S');
	}
	

	

</script>
</head>
<body>
<% request.setCharacterEncoding("EUC-KR");%> 
<%
	
	Object obj = request.getAttribute("aListAll");
	if (obj == null) return;
	
	ArrayList<BoardVO> aList = (ArrayList<BoardVO>)obj;
	int nCnt = aList.size();
	out.println(":::: ��ü ��ϵ� �Խñ� �Ǽ�  " + nCnt + " ��");	
	
%>
	<table>
		<tr>
			<td calspan="2">
			<font size="4" color="blue">�� ȥ�� ���� �Խ���</font>
			<img src="/TestPjw/img/gif/ase.gif" width="25" height="25" alter="image">
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
				<td class="tt">�۾���</td>
				<td class="tt">�����</td>
				<td class="tt">������</td>
			</tr>
		</thead>
		<%
		for(int i=0; i<nCnt; i++){
			BoardVO bvo = aList.get(i);
			String n = bvo.getKnum();
		%>					
		<tbody>
			<tr>
				<td class="tt">
					<input type="checkbox" id="bnumCheck" name="bnumCheck" value=<%= bvo.getKnum() %> onclick="checkOnly(this)">
				</td>		
				<td class="tt"><%= i + 1 %></td>
				<td class="tt"><%= bvo.getKnum() %></td>
				<td class="tt" ><a href = "#" onclick = 'clicksub("<%=n %>")'><%= bvo.getKsubject() %></a></td>
				<td class="tt"><%= bvo.getKwriter() %> </td>	
				<td class="tt"><%= bvo.getInsertdate() %> </td>
				<td class="tt"><%= bvo.getUpdatedate() %> </td>		
			</tr>	
			<%
				}//end of if
			%>						
			<tr>
				<td colspan="20" align="right">
					<input type="hidden" name="ISUD_TYPE" id="ISUD_TYPE" value="S">	
					<input type="hidden" name= "buumh" id = "buumh" value="a">		
					<input type="button" value="���" id="I">
					<input type="button" value="��ȸ" id="SALL">
					<input type="button" value="����" id="U">
					<input type="button" value="����" id="D">									
				</td>
			</tr>	
		</tbody>			
	</table>
	</form>
</body>
</html>