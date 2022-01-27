
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript">
<% 
	// model에 담은 anum 가져오기
	String 	mnum = request.getParameter("mnum");
	System.out.println("mnum >>> : " + mnum);
%>

	 $(document).ready(function(){
		 //alert($("#mnum").val());
		 $("#mypageselect").attr({ "method":"GET"
	         ,"action":"memSelect.cd"}).submit();
			
		 $("#memberForm").submit();
	 });
	 
</script>
<form name="mypageselect" id="mypageselect">
		<input type="hidden" name="mnum" id="mnum" value="<%= mnum %>"/>
</form>
</body>
</html>
</body>
</html>