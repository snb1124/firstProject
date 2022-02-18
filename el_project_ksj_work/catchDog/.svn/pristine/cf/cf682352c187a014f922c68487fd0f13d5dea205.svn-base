<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.io.File" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collection" %>

<%
	/**********************************
	전달해야 할 변수
	***********************************/
	String	url = null;
	String	str = null;
	
	url = request.getParameter("url");
	System.out.println("url >>> : " + url);
	
	str = request.getParameter("str");
	System.out.println("str >>> " + str);
	
	if(str != null && str.length() > 0){
		str = str + "&";
		System.out.println("str + &>>>"+str);
	}
%>

<%
	/**********************************
	페이지 네비게이션 관련 변수
	***********************************/
	// 한페이지에 보여질 게시물의 수
	int pageSize = 0;

	// 그룹의 크기
	int groupSize = 0;
	
	// 전체 게시물의 개수
	int totalCount = 0;
	
	//현재 페이지
	int curPage = 0;
	
	// 전체 페이지의 개수
	int pageCount = 0;
	
	
	//SpringBoardSelectPaging.jsp에서 받아온 pageSize=null이 아니면 int형 타입의 pageSize에 형변환 후 초기화시킨다. 
	if(request.getParameter("pageSize") != null){
		pageSize = Integer.parseInt(request.getParameter("pageSize"));//10
		System.out.println("pageSize >>> : " + pageSize);
	}
	//SpringBoardSelectPaging.jsp에서 받아온 groupSize=null이 아니면 int형 타입의 groupSize 형변환 후 초기화시킨다. 
	if(request.getParameter("groupSize") != null){
		groupSize = Integer.parseInt(request.getParameter("groupSize"));//5
		System.out.println("groupSize >>> : " + groupSize);
	}
	//SpringBoardSelectPaging.jsp에서 받아온 curPage=null이 아니면 int형 타입의 curPage 형변환 후 초기화시킨다. 
	if(request.getParameter("curPage") != null){
		curPage = Integer.parseInt(request.getParameter("curPage"));//1
		System.out.println("curPage >>> : " + curPage);
		
	}
	//SpringBoardSelectPaging.jsp에서 받아온 totalCount=null이 아니면 int형 타입의 totalCount 형변환 후 초기화시킨다. 
	if(request.getParameter("totalCount") != null){
		totalCount = Integer.parseInt(request.getParameter("totalCount"));//400
		System.out.println("totalCount >>> : " + totalCount);
	}
	
	// 전체게시물수와 페이지크기를 가지고 전체 페이지 개수를 계산함.
	// 소수점에 따라 계산상의 오류가 없도록 한것임.
	// total = 38, pagesize =5 , 나머지 포함 pageCount=8이됨.
	pageCount = (int)Math.ceil(totalCount / (pageSize + 0.0));
	System.out.println("totalCount >>> " + totalCount);
	System.out.println("pageSize>> " + pageSize);
	System.out.println("pageCount >>> : " + pageCount);
	//(0/page)
	
	// 현재그룹 설정
	//1-1/5 ==최초 현재페이지는 1-1/ 5=초기세팅값
	int curGroup = (curPage-1) / groupSize;
	System.out.println("curGroup >>> : " + curGroup);
	
	//0*5 =초기 세팅값들
	int linkPage = curGroup * groupSize;
	System.out.println("linkPage >>> : " + linkPage);
%>
<!-- 오른쪽 정렬 -->
<p align="right">
<%
	
	// 첫번째 그룹인 아닌경우
	if(curGroup > 0) {
		
	//boardSelectList.jsp?&curPage=1	
	//boardSelectList.jsp?&curPage=0
%>
	<a href="<%=url%>?<%=str%>curPage=1">◁◁</a>&nbsp;&nbsp;&nbsp;
	<a href="<%=url%>?<%=str%>curPage=<%=linkPage%>">◀</a>&nbsp;&nbsp;&nbsp;
<%
	}else{
%>
		◁◁&nbsp;&nbsp;&nbsp◀&nbsp;&nbsp;&nbsp;
<%
	}
	
	// 다음 링크를 위해 증가시킴 0>>1
	linkPage++;
	System.out.println("linkPage++ >>> : " + linkPage);
	//1
	
	int loopCount = groupSize;
	System.out.println("loopCount >>> : " + loopCount);
	//5
	//그룹사이즈는 5 루프카운트도 5
	// 그룹범위내에서 페이지 링크만듬.
	//5>0 && 1<=40 
	//루프카운트가 0보다 크고 , 링크페이지보다(1) 페이지카운트가 큰경우(8) // 링크를 만드는곳.
	while((loopCount > 0) && (linkPage <= pageCount)){
		//1==1
		if(linkPage == curPage){ // 만약 링크페이지랑 현재페이지가 같으면
			System.out.println("그룹범위내에서 페이지 링크if");
		//linkPage :1
%>
	<%=linkPage%>
<%
		}else{
			System.out.println("그룹범위내에서 페이지 링크else");
			//[2][3][4][5]
%>
	[<a href="<%=url%>?<%=str%>curPage=<%=linkPage%>"><%=linkPage%></a>]&nbsp;
<%
		}
		
		linkPage++;
		loopCount--;
	}
	
	// 다음그룹이 있는 경우
	//		6			40
	if(linkPage <= pageCount){
		System.out.println("다음그룹이 있는 경우 linkPage >>> : " + linkPage);
		System.out.println("다음그룹이 있는 경우pageCount >>> : " + pageCount);
		
	//	boardSelectList.jsp?&curPage=6
	//	boardSelectList.jsp?&curPage=40	
%>
	<a href="<%=url%>?<%=str%>curPage=<%=linkPage %>" >▶</a>&nbsp;&nbsp;&nbsp;
	<a href="<%=url%>?<%=str%>curPage=<%=pageCount %>">▷▷</a>&nbsp;&nbsp;&nbsp;
<%
	}else{
		System.out.println("다음그룹이 있는 경우 linkPage >>> : " + linkPage);
		System.out.println("다음그룹이 있는 경우pageCount >>> : " +pageCount);
		System.out.println("다음그룹이 있는 경우_else");
%>
	▶&nbsp;&nbsp;&nbsp;▷▷&nbsp;&nbsp;&nbsp;
<%
	}
%>
</p>