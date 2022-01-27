<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URL" %>
<%@ page import="java.net.HttpURLConnection" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.InputStreamReader" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js"></script>
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	var naver_id_login = new naver_id_login("i2N985GdjT6UNzp8kb8g", "http://localhost:8088/NaverCallback.cd");
	// 네이버 사용자 프로필 조회
	naver_id_login.get_naver_userprofile("naverSignInCallback()");
	// 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
	function naverSignInCallback() {
	  // 접근 토큰 값 출력
		$("#token", opener.document).val(naver_id_login.oauthParams.access_token);
		$("#name", opener.document).val(naver_id_login.getProfileData('name'));
		$("#gender", opener.document).val(naver_id_login.getProfileData('gender'));
		$("#birthday", opener.document).val(naver_id_login.getProfileData('birthday'));
		$("#birthyear", opener.document).val(naver_id_login.getProfileData('birthyear'));
		$("#mobile", opener.document).val(naver_id_login.getProfileData('mobile'));
		$("#email", opener.document).val(naver_id_login.getProfileData('email'));
		$("#social", opener.document).val("N");
		if($("#token", opener.document).val() != null){
			$("#socialLogin", opener.document).submit();
			window.close();
		}	  
	}
</script>
</head>
<body>
	
</body>
</html>