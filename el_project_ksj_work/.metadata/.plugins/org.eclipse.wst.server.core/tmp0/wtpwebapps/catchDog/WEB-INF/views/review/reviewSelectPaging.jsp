<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.File" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "java.util.Collection" %>

<%
	/*전달해야할 변수*/
	
	String url = null;
	String str = null;
	
	url = request.getParameter("url");
	System.out.println("url >>>:" + url);
	
	str = request.getParameter("str");
	System.out.println("str >>>:" + str);
	
	if(str!= null && str.length()>0){
		str = str + "&";
		System.out.println("str + & >>>" + str);
	}
%>

<%
	/*페이지 네비게이션 관련 변수*/
	
	//한페이지에 보여질 게시물 수 
	int pageSize = 0;
	//그룹의 크기
	int groupSize = 0;
	//전체 게시물의 개수
	int totalCount= 0;
	//현재페이지
	int curPage = 0;
	//전체 페이지의 개수 
	int pageCount = 0;
	
	if(request.getParameter("pageSize") != null){
		pageSize = Integer.parseInt(request.getParameter("pageSize"));
		System.out.println("pageSize >>>:" + pageSize);
	}
	
	if(request.getParameter("groupSize") != null){
		groupSize = Integer.parseInt(request.getParameter("groupSize"));
		System.out.println("groupSize >>>:" + groupSize);
	}
	
	if(request.getParameter("totalCount") != null){
		totalCount = Integer.parseInt(request.getParameter("totalCount"));
		System.out.println("totalCount >>>:" + totalCount);
	}
	
	if(request.getParameter("curPage") != null){
		curPage = Integer.parseInt(request.getParameter("curPage"));
		System.out.println("curPage >>>:" + curPage);
	}
	
	//현재 그룹 설정 1-1/5
	int curGroup = (curPage-1) / groupSize;
	System.out.println("curGroup>>>:"+curGroup);
	
	//전체 게시물수와 페이지 크기를 가지고 전체 페이지 개수를 계산함 
	//소수점에 따라 계산상의 오류가 없도록 한것 
	
	//강사님 코드는 gorupsize 로 나눳는데 pageSize로 나눠야 잘 나옴 **
	pageCount = (int)Math.ceil(totalCount/(pageSize+0.0)); // 4.6 -> 5
	System.out.println("pageCount >>>:" + pageCount);
	//(0/page)
	
	//0*0
	int linkPage = curGroup * groupSize;
	System.out.println("linkPage >>>:" +linkPage);
%>
<p align="right">
<%
	//첫번째 그룹이 아닌경우
	if(curGroup >0){

%>
	<a href ="<%=url%>?<%=str%>curPage = 1">◁◁</a>&nbsp;&nbsp;&nbsp;
	<a href ="<%=url%>?<%=str%>curPage=<%=linkPage%>">◀</a>&nbsp;&nbsp;&nbsp;
<%
}else{
%>
	◁◁&nbsp;&nbsp;&nbsp◀&nbsp;&nbsp;&nbsp;
<%
}

//다음 링크를 위해 증가시킴
linkPage++;
System.out.println("linkPage++ >>>:" + linkPage);

int loopCount = groupSize;
System.out.println("loopCount >>>:" + loopCount);

//그룹 범위내에서 페이지 링크만듦 5>0 && 1<=40
while((loopCount >0) && (linkPage <= pageCount)){
	if(linkPage == curPage){
		System.out.println("그룹 범위내에서 페이지 링크 if");
%>
	<%=linkPage %>
<%
	}else{
		System.out.println("그룹 범위내에서 페이지 링크 else");
		//[2][3][4][5]
%>
	[<a href="<%=url %>?<%=str %>curPage=<%=linkPage %>"><%=linkPage %></a>]&nbsp;

<%
}
	linkPage++;
	loopCount--;
}

//다음 그룹이 있는 경우
if(linkPage <= pageCount){
	System.out.println("다음 그룹이 있는 경우linkPage >>>>:" + linkPage);
	System.out.println("다음 그룹이 있는 경우 pageCount >>>>:" + pageCount);
	
%>	
<a href ="<%=url%>?<%=str%>curPage=<%=linkPage %>">▶</a>&nbsp;&nbsp;&nbsp;
<a href ="<%=url%>?<%=str%>curPage=<%=pageCount%>">▷▷</a>&nbsp;&nbsp;&nbsp;

<%
}else{
	System.out.println("다음 그룹이 있는 경우linkPage >>>>:" + linkPage);
	System.out.println("다음 그룹이 있는 경우 pageCount >>>>:" + pageCount);
	System.out.println("다음 구룹이 있는 경우_else");
	
%>
	▶&nbsp;&nbsp;&nbsp;▷▷&nbsp;&nbsp;&nbsp;
<%
}
%>
