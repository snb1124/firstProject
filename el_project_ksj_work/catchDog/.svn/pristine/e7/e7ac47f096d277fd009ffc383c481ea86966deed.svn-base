<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.catchdog.common.K_Session" %>
<%@ page import="java.util.Map" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/index.css">
<link rel="stylesheet" type="text/css" href="css/default.css"> 
<link rel="stylesheet" type="text/css" href="css/sub.css"> 

</head>
<body>
<header class ="header">
	<h1>
    	<a href="index.jsp"><img src="image/CatchDog_1.png" alt="로고"></a>
    	<span class="hide">CatchDOG</span>
    </h1>
    <nav class="lnb clear">
        <ul>
        <li><a href="adoptionSelectAll.cd">입양</a></li>   
        <li><a href="reviewSelectAll.cd">입양후기</a></li>         
        <li><a href="disadoptionBoardSelectForm.cd">파양</a></li>
        <li><a href="disappearanceselectAll.cd">실종동물</a></li>
        <li><a href="shelter.cd">지역동물보호소 찾기</a></li>
        <li><a href="NoticeSelectPaging.cd">공지사항</a></li>
        </ul>
    </nav>
    <nav class="spot">
    	<ul>
    	<%
    		K_Session ks = K_Session.getInstance();
    		Map<String,Object> ssMap = ks.getSession(request);
    		if(ssMap.get("ssMnum") != null){
    	%>
    		<li><b><%=ssMap.get("ssMname") %></b> 님 환영합니다!</li>
    		<li><a href="loginOut.cd">로그아웃</a></li>
    		<li><a href="mypageForm.cd">마이페이지</a></li>
    	<%
    		} else {	
    	%>
    		<li><a href="loginForm.cd">로그인</a></li>
    		<li><a href="memForm.cd">회원가입</a></li>	
    	<%}  %>	
    		<li><a href="goodsSelectAllpaging.cd"><img src="image/layout/ico_cart.jpg" alt="카트">굿즈</a></li>
    	</ul>
    </nav> 
    <img class="fo" src="image/layout/fo.PNG"/>
	
</header>

</body>
</html>