<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>b_0</title>
</head>
<body>
<h3>b_0</h3><br>
setAttribute(java.lang.String, java.lang.Object) :: getAttribute(java.lang.String)
<hr>
<%
// 리퀘스트 어트리뷰트 선언?
	request.setAttribute("abc", "최세라");
//스트링 변수에 담기
	String abc = String.valueOf(request.getAttribute("abc")); 
	out.println("abc >>> : " + abc + "<br>");

	
	ArrayList<String> aList = new ArrayList<String>();
	//어레이리스트 선언하고 담기
	aList.add("오재영");
	aList.add("25");
	aList.add("코스모교육센터에서 공부중");
	aList.add("의정부시 호원동");
	//리퀘스트 셋어트리뷰트에 세팅하고 담기
	request.setAttribute("aListRequest", aList);

	//해당 객체 request해서 꺼내오기 오브젝트 형태이기때문에 Object로 받아야함
	Object obj = request.getAttribute("aListRequest");
	//비어있으면 종료
	if (obj == null) return;
	
	//오브젝트 어레이리스트로 형변환해 담기
	ArrayList<String> _aList = (ArrayList<String>)obj;
	//반복문 이용 꺼내오기 
	if (_aList !=null && _aList.size() > 0){
		for (int i=0; i < _aList.size(); i++){
			out.println("b_0.jsp ::: _aList.get("+i+") >>> : " + _aList.get(i) + "<br>");
			System.out.println("b_0.jsp ::: _aList.get("+i+") >>> : " + _aList.get(i));
		}
		
	}
	//세션 셋 어트리뷰트 위와 동일한과정 진행
	session.setAttribute("abc00", "최세라");
	String abc00 = String.valueOf(session.getAttribute("abc00")); 
	out.println("abc00 >>> : " + abc00 + "<br>");
	//session.setAttribute("abc00", aList);
	
	ArrayList<String> aListSession = new ArrayList<String>();
	aListSession.add("오재영");
	aListSession.add("25");
	aListSession.add("코스모교육센터에서 공부중");
	aListSession.add("의정부시 호원동");
	session.setAttribute("aListSession", aListSession);
	
	Object objSession = session.getAttribute("aListSession");
	if (objSession == null) return;
	
	ArrayList<String> _aListSession = (ArrayList<String>)obj;
	if (_aListSession !=null && _aListSession.size() > 0){
		for (int i=0; i < _aListSession.size(); i++){
			out.println("b_0.jsp ::: _aListSession.get("+i+") >>> : " + _aListSession.get(i) + "<br>");
			System.out.println("b_0.jsp ::: _aListSession.get("+i+") >>> : " + _aListSession.get(i));
		}		
	}
	
	application.setAttribute("abc11", "최세라");
	String abc11 = String.valueOf(application.getAttribute("abc11")); 
	out.println("abc11 >>> : " + abc11 + "<br>");
	
	ArrayList<String> aListApplication = new ArrayList<String>();
	aListApplication.add("오재영");
	aListApplication.add("25");
	aListApplication.add("코스모교육센터에서 공부중");
	aListApplication.add("의정부시 호원동");
	session.setAttribute("aListApplication", aListApplication);
	
	Object objApplicatoin = session.getAttribute("aListApplication");
	if (objSession == null) return;
	
	ArrayList<String> _aListApplication = (ArrayList<String>)obj;
	if (_aListApplication !=null && _aListApplication.size() > 0){
		for (int i=0; i < _aListApplication.size(); i++){
			out.println("b_0.jsp ::: _aListApplication.get("+i+") >>> : " + _aListApplication.get(i) + "<br>");
			System.out.println("b_0.jsp ::: _aListApplication.get("+i+") >>> : " + _aListApplication.get(i));
		}		
	}
%>

</body>
</html>