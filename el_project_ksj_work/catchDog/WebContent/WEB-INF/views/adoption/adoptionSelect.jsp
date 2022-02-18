<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.catchdog.adoption.vo.AdoptionVO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.catchdog.common.CodeUtil" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>입양 신청 정보 확인</title>
		<style type="text/css">
			table, tr, td, input, textarea{text-align:center;}
		</style>
	</head>
	<body>
		<jsp:include page="/include/header.jsp" flush="true"></jsp:include>
		<%
			Object obj = request.getAttribute("listSel");
			List<AdoptionVO> listSel = null;
			AdoptionVO avo = null;
			if(obj != null){
				listSel = (List<AdoptionVO>)obj;
				if(listSel != null){
					System.out.println("SelectJSP listSel.size >>> : " + listSel.size());
					avo = listSel.get(0);
				}
			}
			
			System.out.println("SelectJSP avo >>> : " + avo);
			if(avo == null){
				avo = new AdoptionVO();
			}
			System.out.println("SelectJSP iamge >>> : " + avo.getAimage());
		%>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				$("#adoptionBtn").click(function(){
					let mnum = <%= avo.getMnum() %>;
					alert("입양신청 완료")
					if(mnum == null){
						
					}else{
						
					}
				});
			});
		</script>
		<form id="adoptionSelectForm" name="adoptionSelectForm">
			<table>
				<tr>
					<td rowspan="7">
						<img src='<%= avo.getAimage() %>' width="300" height="300"
						onerror="this.src='image/image-available.jpg'">
					</td>
					<td>
						이름 : <input type="text" id="aname" name="aname" value="<%= CodeUtil.aname(avo.getAname()) %>">
					</td>
				</tr>
				<tr>
					<td>
						종 : <input type="text" id="akind" name="akind" value="<%= CodeUtil.akind(avo.getAkind()) %>">
					</td>
				</tr>
				<tr>
					<td>
						나이 : <input type="text" id="aage" name="aage" value="<%= CodeUtil.aage(avo.getAage()) %>">
					</td>
				</tr>
				<tr>
					<%
						String clr = CodeUtil.acolors(avo.getAcolor());
						if(clr.charAt(clr.length()-1) == ',') clr = clr.subSequence(0, clr.length()-1).toString();
					%>
					<td>
						색 : <input type="text" id="acolor" name="acolor" value="<%= clr %>">
					</td>
				</tr>
				<tr>
					<%
						String[] individual = CodeUtil.aindividuality(avo);
						System.out.println("individual >>> : " + individual[0] + ", " + individual[1]);
						String indiv = "";
						if(individual[1] == null || individual[1].equals("")) indiv = individual[0];
						else	indiv = individual[0] + ", " + individual[1];
					%>
					<td>
						종특 및 무게 : <input type="text" id="aindividual" name="aindividual" value="<%= indiv %>">
					</td>
				</tr>
				<tr>
					<td>
						성별 : <input type="text" id="agender" name="agender" value="<%= CodeUtil.agender(avo.getAgender()) %>">
					</td>
				</tr>
				<tr>
					<td>
						중성화여부 : <input type="text" id="aneut" name="aneut" value="<%= CodeUtil.aneut(avo.getAneut()) %>">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<script src="http://code.jquery.com/jquery-latest.min.js">
							let specialSize = '<%= avo.getAspecial().length() %>';
						</script>
						<p style="margin-top: 30px;">특이사항 :</p><textarea id="aspecial" name="aspecial"><%= avo.getAspecial() %></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="button" id="adoptionBtn" name="adoptionBtn" value="입양상담신청" style="margin-top: 10px;">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>