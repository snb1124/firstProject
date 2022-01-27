<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@page import="a.b.c.com.ksj.board.service.BoardService"%>
<%@page import="a.b.c.com.ksj.board.service.BoardServiceImpl"%>    
<%@page import="a.b.c.com.ksj.board.vo.BoardVO"%>    
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>글 전체조회</title>

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

	//체크박스 체크 확인하기 
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

		// 등록하기 
		$("#I").click(function(){			
			location.href='/testKsj/kosmo_ksj/board/board.html';			
		});
		
		// 조회
		$("#S").click(function(){			
			var isudType = document.boardSelectAllForm.ISUD_TYPE.value = "S";			
			send(isudType);		
		});
		
		// 수정하기 
		$("#U").click(function(){			

			var nCnt = chkInfo();			
			if (nCnt == 0){	
				console.log('체크박스를 체크하세요');
				alert('체크박스를 체크하세요');
			}else{	
				var v1 = $("#ISUD_TYPE").val('U');
				alert("v1 >>> : " + v1.val());
				send(v1);				
			}			
		});
		/* 자바스크립트 버전
		document.boardSelectAllForm.ISUD_TYPE.value = "U";
		alert("isudType U >>> : " + document.boardSelectAllForm.ISUD_TYPE.value);
		send(document.boardSelectAllForm.ISUD_TYPE.value);	
	*/
	// jQuery 버전 
		
	
		// 삭제하기 
		$("#D").click(function(){			
			
			var nCnt = chkInfo();
			if (nCnt == 0){	
				console.log('체크박스를 체크하세요');
				alert('체크박스를 체크하세요');
			}else{	
				/* 자바스크립트 버전
					document.boardSelectAllForm.ISUD_TYPE.value = "D";
					alert("isudType D >>> : " + document.boardSelectAllForm.ISUD_TYPE.value);
					send(document.boardSelectAllForm.ISUD_TYPE.value);	
				*/
				
				// jQuery 버전 
				var v2 = $("#ISUD_TYPE").val('D');
				alert("v2 >>> : " + v2.val());
				send(v2);
			}					
		});
		
		// 체크박스 체크 카운트
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
//alistall-> 컨트롤에서 ->서비스->다오(데이터베이스에서 모든 데이터 조회해서 가져옴)->다시 컨트롤러에서 setattribute를 사용해서 aListAll에 초기화함
//그 값을 현재 페이즈에 getAttribute를 통해서 꺼내옴
//이 페이지를 바로 열면 안열리는 이유가 가져온 데이터가 있어야 obj가 null이 아닌데 null이 되기때문에 return 되어 종료됨.
//이 페이지만 실행시킨다면 받아온 데이터가 없기 때문에 오류가 발생한다.?
// 그렇다면 이 안에 바로 데이터를 받아오게 한다면?..

	Object obj = request.getAttribute("aListAll");
	if (obj == null) return;
	
	ArrayList<BoardVO> aList = (ArrayList<BoardVO>)obj;
	int nCnt = aList.size();
	out.println(":::: 전체 조회 건수  " + nCnt + " 건");	
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
	<td class="tt">순번</td>
	<td class="tt">글번호</td>
	<td class="tt">글제목</td>
	<td class="tt">저자</td>
	<td class="tt">패스워드</td>
	<td class="tt">내용</td>
	<td class="tt">이미지</td>	
	<td class="tt">삭제여부</td>
	<td class="tt">등록일</td>
	<td class="tt">수정일</td>
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
		<input type="button" value="등록" id="I">
		<input type="button" value="조회" id="S">
		<input type="button" value="수정" id="U">
		<input type="button" value="삭제" id="D">									
	</td>
</tr>	
</tbody>			
</table>
</form>		
</body>
</html>

