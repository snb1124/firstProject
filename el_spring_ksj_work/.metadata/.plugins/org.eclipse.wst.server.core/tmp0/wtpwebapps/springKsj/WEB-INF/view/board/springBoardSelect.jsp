<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="a.b.c.com.board.vo.SpringBoardVO" %> 
<%@ page import="java.util.List" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Select</title>
<style type="text/css">
	dib{
		margin: 50px 0px 0px 100px;
	}
	.mem{text-align: center}
</style>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$(document).on("click", "#pwbtn", function(){
			alert("pwbtn 이벤트 발생");
			
			let pwcheckURL ="boardPwCheck.jin";
			let reqType ="POST";
			let dataParam={
					knum: $("#knum").val(),
					kpw: $("#kpw").val(),
			};
			$.ajax({
				url:pwcheckURL,
				type:reqType,
				data:dataParam,
				success:whenSuccess,
				error:whenError
			});
			
			function whenSuccess(resData){
				alert("resData->>>>"+resData);
				if("PW_GOOD"==resData){
					alert("비밀번호 일치");
					$("kpw").attr("readonly", true);
					$("U").css('backgroun-color', 'yellow');
					$("D").css('color', 'red');
				}else if("PW_GOOD"==resData){
					alert("비밀번호 불일치");
					$("#kpw").val('');
					$("#kpw").focus();
				};
					
			}
			function whenError(e){
				alert("에러발생-->>>"+ e.responseText);
			}
		});
		
		$(document).on("click","#U", function(){
			//alert("업데이트 이벤트 발생");
			$("#boardUpdateForm").attr({"method":"POST", "action":"boardUpdate.jin"}).submit();
		});
		$(document).on("click","#D", function(){
			//alert("딜리트 이벤트 발생");
			$("#boardUpdateForm").attr({"method":"POST", "action":"boardDelete.jin"}).submit();
		});
		});
</script>
</head>
<body>
<h3>boardSelect</h3>
<hr>
<%
	Object obj = request.getAttribute("listS");
	List<SpringBoardVO>list = (List)obj;
	//코드 잘못된거 같은데
	SpringBoardVO bvo = null;
	if(list.size()==1){
		bvo=list.get(0);
	}

%>
<div>
	<form name="boardUpdateForm" id="boardUpdateForm">
	<table border="1">
		<tr>
			<td colspan="2" align="center"> 게시판 글 수정</td>
		</tr>
		<tr>
		<td class="mem">글번호 </td>
		<td><input type="text" name="knum" id="knum" value="<%= bvo.getKnum() %>" readonly/></td>
		</tr>	
		<tr>
		<td class="mem">제목 </td>
		<td><input type="text" name="ksubject" id="ksubject" value="<%= bvo.getKsubject() %>" style="width:100px" readonly/></td>
		</tr>
		<tr>
		<td class="mem">이름</td>
		<td><input type="text" name="kname" id="kname" value="<%=bvo.getKname() %>" readonly></td>
		</tr>
		<tr>
		<td class="mem">소개글</td>
		<td>
		<textarea name="kcontent" id="kcontent" rows="5" cols="50"> <%= bvo.getKcontent() %></textarea>
		</td>
		</tr>
		<tr>
		<td class="mem">사진</td>
		<td>
		<img src="/springKsj/imgupload/sm_<%=bvo.getKfile()%>" border="1" width="40" height="50" alt="이미지">
		</td>
		</tr>
		<tr>
		<td class="mem">등록일</td>
		<td> 
		<input type="text" name="kinsertdate" id="kinsertdate" value="<%= bvo.getKinsertdate()%>" readonly/>
		</td>
		</tr>
		<tr>
		<td class="mem">수정일</td>
		<td> 
		<input type="text" name="kupdatedate" id="kupdatedate" value="<%= bvo.getKupdatedate()%>" readonly/>
		</td>
		</tr>
		<tr>
		<td class="mem">패스워드</td>
		<td>
		 <input type="text" name="kpw" id="kpw" />
		 <button type="button" id="pwbtn">비밀번호</button>
		 </td>
		 </tr>
		 <tr>
		 <td colspan="2" align="right">
		 <button type="button" id="U">수정 </button>
		 <button type="button" id="D">삭제 </button>
		 </td>
		 </tr>
	</table>
	</form>
</div>
<p>
<h3>댓글 처리하는 루틴</h3>
<hr>
<c:import url="/rboardForm.jin">
	<c:param name="knum" value="<%= bvo.getKnum()%>"></c:param>
</c:import>
</body>
</html>