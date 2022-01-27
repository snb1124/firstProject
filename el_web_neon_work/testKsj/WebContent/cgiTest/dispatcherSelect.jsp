<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@ page import ="java.util.ArrayList" %>
 <%@ page import ="a.b.c.cgitest.EmpVO" %>
 <!DOCTYPE html>

<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>dispatcherSelect</h3>
<hr>

<%
// 속성값 가져온다nCnt의
	Object obj = request.getAttribute("nCnt");
//만약 널이라면 리턴때리고 종료
	if(obj==null) return;
	
//오브젝트 타입에 담긴 데이터를 인트타입으로 형변환해서 초기화
	int nCnt = ((Integer)obj).intValue();
	//포장 패키지 풀었으니까 1 이 ncnt와 같다면 아래 실행
	if (1==nCnt){
		System.out.println("로그인성공"+nCnt);
	%>
	
		<script>
		//알람
			alert("로그인 성공");
		//위치시킨다"/testKsj/cgiTest/testJsp_1.jsp"
			location.href="/testKsj/cgiTest/testjsp_1.jsp";
		</script>
<%

	}

%>
</body>
</html>