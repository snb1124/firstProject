<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.catchdog.member.vo.MemberVO" %>
<%@ page import="com.catchdog.common.CodeUtil" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원 목록</title>
		<style type="text/css">
				* { margin: 0 auto;}
				td, th{ padding: 5px;}
				.tt {text-align: center;}
		</style>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				
				$(document).on("click", "#mnum",function(){
					if($(this).prop("checked")){
						$('.mnum').prop('checked', false);
						$(this).prop('checked', true);
					}
				});
				
				$(document).on("click", "#I", function(){
					location.href="memForm.cd";
				});
				
				$(document).on("click", "#SALL", function(){
					$("memSelectAllForm").attr({"method":"GET","action":"memSelectAll.cd"}).submit();
				});
				
				$(document).on("click","#U", function(){
					if($('.mnum:checked').length==0){
						alert("글번호를 선택하세요");
						return;
					}
					$("#memSelectAllForm").attr({"method":"GET","action":"memSelect.cd"}).submit();
				});
				
				$(document).on("click", "#D", function(){
					if($('.mnum:checked').length==0){
						alert("글번호를 선택하세요");
						return;
					}
					$("#memSelectAllForm").attr({"method":"GET", "action":"memSelect.cd"}).submit();
				});
			});
		</script>
	</head>
	<body>
	<jsp:include page="/include/header.jsp" flush="true"></jsp:include>
			<% request.setCharacterEncoding("UTF-8"); %>
			
			<%
				Object obj = request.getAttribute("listAll");
				if(obj==null) return;
				
				ArrayList<MemberVO> aList = (ArrayList<MemberVO>)obj;
				int nCnt = aList.size();
				out.println("목록 건수 >>> : " + nCnt);
			%>
			<table>
					<tr>
						<td colspan="2">
							<font size="4" color="blue">
								전체 회원
							</font>
						</td>
					</tr>
			</table>
			<form name="memSelectAllForm" id="memSelectAllForm">
					<table border="1">
							<tr>
								<th class="tt"><input type="checkbox" name="chkAll" id="chkAll"></th>
								<th class="tt">순번</th>
								<th class="tt">회원번호</th>
								<th class="tt">이름</th>
								<th class="tt">아이디</th>
								<th class="tt">성별</th>
								<th class="tt">생년월일</th>
								<th class="tt">핸드폰</th>
								<th class="tt">이메일</th>
								<th class="tt">주소</th>
								<th class="tt">수정일</th>
							</tr>
							<%
								String gender = "";
								String birth = "";
								String hp = "";
								String email = "";
								String addr = "";
								
								for(int i=0;i<nCnt;i++){
									MemberVO mvo = aList.get(i);
									gender = CodeUtil.gender(mvo.getMgender());
									birth = CodeUtil.birth(mvo.getMbirth());
									hp = CodeUtil.hp(mvo.getMhp());
									addr = mvo.getMzonecode() + "" + mvo.getMroadaddress().replace("@","");
									
								
 							%>
 							<tr>
 								<td class="tt">
 									<input type="checkbox" id="mnum" name="mnum" class="mnum" value=<%= mvo.getMnum() %>>
 								</td>
 								<td class="tt"><%= i + 1 %></td>
 								<td class="tt"><%= mvo.getMnum() %></td>
 								<td class="tt"><%= mvo.getMname() %></td>
 								<td class="tt"><%= mvo.getMid() %></td>
 								<td class="tt"><%= gender %></td>
 								<td class="tt"><%= birth %></td>
 								<td class="tt"><%= hp %></td>
 								<td class="tt"><%= mvo.getMemail() %></td>
 								<td class="tt"><%= addr %></td>
 								<td class="tt"><%= mvo.getMupdatedate() %></td>
 							</tr>
 							<%
 								}
 							%>
 							<tr>
 								<td colspan="20" align="right">
 								<input type="button" value="등록" id="I">
 								<input type="button" value="조회" id="SALL">
 								<input type="button" value="수정" id="U">
 								<input type="button" value="삭제" id="D">
 								</td>
 							</tr>
					</table>
			</form>
	</body>
</html>