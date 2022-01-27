<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="a.b.c.com.common.EL_MemberVO" %>
<%@ page import="java.util.ArrayList" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

   	<%
   		ArrayList<EL_MemberVO> list = new ArrayList();
   		list.add(new EL_MemberVO("홍길동", "hong", "1234", 11, "서울특별시", "010-1111-1111"));
   		list.add(new EL_MemberVO("홍길동", "hong", "1234", 12, "서울특별시", "010-1111-1111"));
   		list.add(new EL_MemberVO("홍길동", "hong", "1234", 13, "서울특별시", "010-1111-1111"));
   		list.add(new EL_MemberVO("홍길동", "hong", "1234", 14, "서울특별시", "010-1111-1111"));
   		list.add(new EL_MemberVO("홍길동", "hong", "1234", 15, "서울특별시", "010-1111-1111"));
   		list.add(new EL_MemberVO("홍길동", "hong", "1234", 16, "서울특별시", "010-1111-1111"));
   		
   		//pageContext 객체는 JSP 기본객체로 JSP 페이지에서 따로 선언하지 않아도 참조하여 사용 가능합니다.
   		//pageContext는 JSP 페이지에 대해 1:1로 연결된 객체로 JSP 페이지당 하나의 pageContext 객체가 생성됩니다. 
   		//따라서 같은 JSP 페이지 내에서는 서로 값을 공유할 수 있으며, 주요 기능은 다른 기본객체들을 구할때 사용하거나 페이지 흐름을 제어할 때 사용됩니다. 
   		pageContext.setAttribute("list", list);
   		
   %>
<!DOCTYPE html> 
<html>
<head>
<meta charset="EUC-KR">
<title>어레이리스트에 있는 요소 반복문 사용해서 꺼내기 </title>
</head>
<body>
<hr>
JAVA for<br />
<ul>
	<%
		for(int i = 0; i < list.size(); i++) {
			out.println("<li>" + list.get(i).getIrum());
			out.println(list.get(i).getId());
			out.println(list.get(i).getPw());
			out.println(list.get(i).getAge());
			out.println(list.get(i).getAddr());
			out.println(list.get(i).getTel() + "</li>");
		}
	%>
</ul>
<hr />
JAVA forEach<br />
<ul>
	<%
		for(EL_MemberVO mvo : list) {
			out.println("<li>");
			out.println(mvo.getIrum());
			out.println(mvo.getId());
			out.println(mvo.getPw());
			out.println(mvo.getAge());
			out.println(mvo.getAddr());
			out.println(mvo.getTel());
			out.println("</li>");
		}
	%>
</ul>
<hr />
EL 표기법<br />
<ul>
	<li>${list[0].irum } ${list[0].id } ${list[0].pw } ${list[0].age } ${list[0].addr } ${list[0].tel }</li>
	<li>${list[1].irum } ${list[1].id } ${list[1].pw } ${list[1].age } ${list[1].addr } ${list[1].tel }</li>
	<li>${list[2].irum } ${list[2].id } ${list[2].pw } ${list[2].age } ${list[2].addr } ${list[2].tel }</li>
	<li>${list[3].irum } ${list[3].id } ${list[3].pw } ${list[3].age } ${list[3].addr } ${list[3].tel }</li>
	<li>${list[4].irum } ${list[4].id } ${list[4].pw } ${list[4].age } ${list[4].addr } ${list[4].tel }</li>
</ul>
<hr />
JSTL core<br />
<ul>
	<c:forEach var="i" items="${list }">
		<li>${i.irum } ${i.id  } ${i.pw  } ${i.age  } ${i.addr } ${i.tel  }</li>
	</c:forEach>
</ul>
</body>
</html>