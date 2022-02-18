<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.List" %>
<%@ page import = "com.catchdog.disappearance.vo.DisappearanceVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript"></script>
</head>
<body>
	<% request.setCharacterEncoding("UTF-8"); %>
	<jsp:include page="/include/header.jsp"	flush="true"></jsp:include>
	<%
	
	//페이지 변수 세팅
	int pageSize= 0;
	int groupSize = 0;
	int curPage = 0;
	int totalCount = 0;
	
	Object objPaging = request.getAttribute("Pasing");
	DisappearanceVO pagingDIVO = (DisappearanceVO)objPaging;
	
	Object obj = request.getAttribute("listAll");
	List<DisappearanceVO> list= (List)obj;
	System.out.println("Obj >>> : " + list);
	int nCnt = list.size();
	System.out.println("nCnt >>> : "+ nCnt);
	
	%>
	<form name = "disappearanceSelectAllForm" id="disappearanceSelectAllForm" class="disappearanceSelectAllForm">
		<script>
		
			//입력버튼 클릭시
			$(document).on("click", "#I", function(){
				console.log("sbbtn >>>> : " );
				$('#disappearanceSelectAllForm').attr({
					'action': 'disappearanceForm.cd',
					'method' : 'GET',
					'enctype' : 'application/x-www-form-urlencoded'
				}).submit();	
			});
			//이미지 클릭시
			function disappearanceSelectAll(ele){
				let id = ele.id;
				$("#dinum").val(id);
				alert("id >>> : " + id);
				
				$("#disappearanceSelectAllForm").attr({
					"action":"/disappearanceSelect.cd",
					"method":"POST",
					"enctype":"application/x-www-form-urlencoded"
				}).submit();
			}
		</script>	
		<table>
		<thead>
		<tr>
			<%
				for(int i=0; i<list.size(); i++){
					DisappearanceVO divo = list.get(i);
					String image = divo.getDiimage();
					System.out.println("image >>>> : " + image);
					
					if(i%5 == 4){
			%>

			<td><img src='/image/disappearanceimg/<%= image %>' width="150" height="150"
				onerror="this.src='image/image-available.jpg'"
				id="<%= list.get(i).getDinum() %>"
				onclick="disappearanceSelectAll(this)"><br>
				
				<input type="text" name="diname" id="diname" value="이름:<%=list.get(i).getDiname() %>" readonly><br>
				<input type="text" name="diage" id="diage" value="나이 :<%=list.get(i).getDiage() %>" readonly><br>
				<input type="text" name="didate" id="didate"  value="실종일:<%=list.get(i).getDidate() %>" readonly><br>
			</td>
		</tr>
		<tr>
			<%
				}else {
			%>
			<td><img src='/image/disappearanceimg/<%= image %>' width="150" height="150"
				onerror="this.src='image/image-available.jpg'"
				id="<%= list.get(i).getDinum() %>"
				onclick="disappearanceSelectAll(this)"><br>
				
				<input type="text" name="diname" id="diname" value="이름:<%=list.get(i).getDiname() %>" readonly><br>
				<input type="text" name="diage" id="diage" value="나이 :<%=list.get(i).getDiage() %>" readonly><br>
				<input type="text" name="didate" id="didate"  value="실종일:<%=list.get(i).getDidate() %>" readonly><br>
			</td>

			<%
					}
					
				}
			%>
			</tr>

		</thead>

<%
for(int i=0; i<nCnt; i++){
		DisappearanceVO divo = list.get(i);
		pageSize = Integer.parseInt(pagingDIVO.getPageSize());
		groupSize = Integer.parseInt(pagingDIVO.getGroupSize());
		curPage = Integer.parseInt(pagingDIVO.getCurPage());
		totalCount = Integer.parseInt(divo.getTotalCount());
%>

	<tbody>
	<%
	}//end of for
	%>
		<tr class="button">
			<td colspan="7" align="right">
				<input type="button" value="실종동물등록" id="I">
				<input type="hidden" id="dinum" name="dinum" value="">
			</td>
		</tr>
		<tr>
			<td colspan="7">
			<jsp:include page="disappearanceSelectPaging.jsp" flush="true">
				<jsp:param name="url" value="disappearanceselectAll.cd" />
				<jsp:param name="str" value=""/>
				<jsp:param name="curPage" value="<%=curPage %>" />
				<jsp:param name="pageSize" value="<%=pageSize %>" />
				<jsp:param name="groupSize" value="<%=groupSize %>" />
				<jsp:param name="totalCount" value="<%=totalCount %>" />
			</jsp:include>
			</td>
		</tr>
		</tbody>
		</table>
	</form>
</body>
</html>