<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="a.b.c.com.paging.BoardDAO"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.HashMap"%>

<!DOCTYPE html>
<html>
<head>
<title> SELECT LIST </title>
<style type="text/css">

	table, td {
		border: 1px solid red;		
	}
	table {
		width: 70%;
		height: 80%;
		margin: auto;
		text-align: center;
	}
</style>
</head>
<body>
<%
	BoardDAO dao = new BoardDAO();

	//현재 row갯수
	int pageSize = 7;
	//목록그룹
	int groupSize = 5;	
	//현재 페이지
	int curPage = 1;
	//전체 글수
	int totalCount = 0;
	
	System.out.println("curPage>>>>"+request.getParameter("curPage"));
	
	//처음 실행되면 null값이 들어온다.
	//현재 페이지를 이동시키면 null값이 아니라서 if문이 실행된다.
	if(request.getParameter("curPage") != null){
		//getParameter의 리턴값이 String임으로 int로 형변환 해준다.		
		curPage = Integer.parseInt(request.getParameter("curPage"));
		System.out.println("curPage2>>>>"+curPage);
	}
	
	System.out.println("pageSize>>>>"+pageSize);
	ArrayList al = dao.selectList(pageSize, curPage);
	
	//ArrayList인 al의 사이즈가 0이면
	if (al.size() == 0) return;

	//Iterator :데이터를 읽을 때 사용하는 클래스
	Iterator iter = al.iterator();
%>	
<table>
<tr>
	<td align="center" colspan="13">select된 행의 내용 : HashMap 사용</td>
</tr>
<tr>
	<td>글번호</td>
	<td>제목</td>
	<td>작성자</td>
	<td>이메일</td>
	<td>글내용</td>
	<td>비밀번호</td>
	<td>REF</td>
	<td>STEP</td>
	<td>DEPTH</td>
	<td>작성일</td>
	<td>조회수</td>
	<td>페이지번호</td>
	<td>전체글수</td>
</tr>
<%
	//iter의 값이 있으면 동작한다.
	while(iter.hasNext()) {
		HashMap hm = (HashMap)iter.next();
		totalCount = Integer.parseInt((String)hm.get("TOTALCOUNT"));
%>
<tr>
	<td> <%=hm.get("mnum")%></td>
	<td> <%=hm.get("mtitle")%></td>
	<td> <%=hm.get("mname")%></td>
	<td> <%=hm.get("memail")%></td>
	<td> <%=hm.get("marea")%></td>
	<td> <%=hm.get("mpass")%></td>
	<td> <%=hm.get("mref")%></td>
	<td> <%=hm.get("mstep")%></td>
	<td> <%=hm.get("mdepth")%></td>
	<td> <%=hm.get("mwriteday")%></td>
	<td> <%=hm.get("mhits")%></td>
	<td> <%=hm.get("PAGENO")%></td>
	<td> <%=hm.get("TOTALCOUNT")%></td>
</tr>
<%
	}
%>
<tr>
	<td colspan="13">
		<jsp:include page="paging.jsp" flush="true">
			<jsp:param name="url" value="boardSelectList.jsp"/>
			<jsp:param name="str" value=""/>
			<jsp:param name="pageSize" value="<%=pageSize%>"/>
			<jsp:param name="groupSize" value="<%=groupSize%>"/>
			<jsp:param name="curPage" value="<%=curPage%>"/>
			<jsp:param name="totalCount" value="<%=totalCount%>"/>
		</jsp:include>
	</td>
</tr>
</table>
</body>
</html>
<!--
se_BoardSelectList.jsp?searchString=111&searchtype=name&curPage=3
	str 파리미터에 넘길 값 : searchString=111&searchtype=name
-->