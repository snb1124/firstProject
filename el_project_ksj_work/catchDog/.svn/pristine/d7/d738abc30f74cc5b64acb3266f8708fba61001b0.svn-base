<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.catchdog.recommend.vo.RecommendVO" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관심 동물 조회</title>
<style type="text/css">
	input[type="text"] {
		border: none !important;
	}
</style>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(document).on("click", "#U", function(){
//		alert("U >>> : ");
		$("#recommendSelect").attr({"method":"POST"
								  ,"action":"recommendUpdateForm.cd"}).submit();
	});
</script>
</head>
<body>
<% request.setCharacterEncoding("EUC-KR");
   Object obj = request.getAttribute("listS");
   if(obj == null) return;
   
   ArrayList<RecommendVO> aList = (ArrayList<RecommendVO>)obj;
   int nCnt = aList.size();
   
   String mnum = "";
   String aupkind = "";
   String akind = "";
   String asize = "";
   String acaresite = "";
   String agender = "";
   String afur = "";
   String deleteyn = "";
   
   RecommendVO rvo = null;
   if (nCnt == 1){
	   rvo = aList.get(0);
	   
	   aupkind = rvo.getAupkind();
	   akind = rvo.getAkind();
	   asize = rvo.getAsize();
	   acaresite = rvo.getAcaresite();
	   agender = rvo.getAgender();
	   afur = rvo.getAfur();
	   deleteyn = rvo.getDeleteyn();
   }
%>
<jsp:include page="/include/header.jsp" flush="true"></jsp:include>
	<form name="recommendSelect" id="recommendSelect">
		<div>
			<input type="text" name="mnum" id="mnum" value="<%= rvo.getMnum() %>" style="width:100px" readonly /> /
			<input type="text" name="aupkind" id="aupkind" value="<%= rvo.getAupkind() %>" style="width:30px" readonly />/
			<input type="text" name="asize" id="asize" value="<%= rvo.getAsize () %>"  style="width:50px" readonly />/
			<input type="text" name="akind" id="akind" value="<%= rvo.getAkind() %>" readonly />/
			<input type="text" name="agender" id="agender" value="<%= rvo.getAgender() %>" style="width:40px" readonly  />/
			<input type="text" name="acaresite" id="acaresite" value="<%=rvo.getAcaresite() %>" readonly />/
			<input type="text" name="afur" id="afur" value="<%= rvo.getAfur() %>" readonly />
			<input type="button" value="수정" id="U"/>			
		</div>
	</form>
</body>
</html>