<!-- dispatcher에서 받은 데이터를 받았다 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="a.b.c.cgitest.EmpVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=EUC-KR">
<title>dispatcher_1</title>
</head>
<body>
<h3>dispatcher_1.jsp</h3>
<hr>
<%
//aList은 속성값을 받고자하는 속성이다. 즉 obj는 속성값을 얻고자하는 alist속성?헷갈리네 
		//getattribute에 대해 형우에게 물어보자. 
		//			setAttribute선택한 속성의 속성값을 정의한다.
					//이미 속성값이 있다면 새로 정의된 값으로 변경된다. 
					//req 속성 aList를 aList 속성으로 정의한다. 
					//req.setAttribute("aList", aList);
					//이걸 가져온건가?
	Object obj = request.getAttribute("aList");
	if(obj == null) return;
	//오브젝트 타입으로 담겨있는 alist를 arraylist로 넘긴다
	ArrayList<EmpVO> aList = (ArrayList<EmpVO>)obj;
	
	if(aList != null && aList.size() > 0){
		out.println("aList >>> : " + aList.size() + "<br>");
		
		for(int i=0; i<aList.size(); i++){
			EmpVO evo = aList.get(i);
			//하나씩꺼내서 출력 
			out.println(evo.getEmpno() + " : ");
			out.println(evo.getEname() + " : ");
			out.println(evo.getJob() + " : ");
			out.println(evo.getMgr() + " : ");
			out.println(evo.getHiredate() + " : ");
			out.println(evo.getSal() + " : ");
			out.println(evo.getComm() + " : ");
			out.println(evo.getDeptno() + "<br>");
		}
	}else{
		out.println("ArrayList에 데이터가 없어요 >>> : ");
	}
%>
</body>
</html>