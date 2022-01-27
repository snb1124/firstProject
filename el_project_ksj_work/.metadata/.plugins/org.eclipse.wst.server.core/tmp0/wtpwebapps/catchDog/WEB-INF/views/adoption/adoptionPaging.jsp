<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.File" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collection" %>

<%
	String url = null;
	String str = null;
	
	url = request.getParameter("url");
	str = request.getParameter("str");
	if(str != null){
		str = str + "&";
	}
%>

<%
	int pageSize = 0;
	int groupSize = 0;
	int totalCount = 0;
	int curPage = 0;
	int pageCount = 0;
	if(request.getParameter("pageSize") != null){
		pageSize = Integer.parseInt(request.getParameter("pageSize"));
		System.out.println("pageSize >>> : " + pageSize);
	}
	if(request.getParameter("groupSize") != null){
		groupSize = Integer.parseInt(request.getParameter("groupSize"));
		System.out.println("groupSize >>> : " + groupSize);
	}
	if(request.getParameter("curPage") != null){
		curPage = Integer.parseInt(request.getParameter("curPage"));
		System.out.println("curPage >>> : " + curPage);
	}
	if(request.getParameter("totalCount") != null){
		totalCount = Integer.parseInt(request.getParameter("totalCount"));
		System.out.println("totalCount >>> : " + totalCount);
	}
	
	pageCount = (int)Math.ceil(totalCount/(pageSize + 0.0));
	System.out.println("pageCount >>> : " + pageCount);
	
	int curGroup = (curPage - 1) / groupSize;
	System.out.println("curGroup >>> : " + curGroup);
	
	int linkPage = curGroup * groupSize;
	System.out.println("linkPage >>> : " + linkPage);
%>
<p align="center">
<%
	if(curGroup > 0){
	
%>
	<span onclick="goAdoptionSelectAll(1)">◁◁</span>&nbsp;&nbsp;&nbsp;
	<span onclick="goAdoptionSelectAll(<%= linkPage %>)">◀</span>&nbsp;&nbsp;&nbsp;
<% 
	}
	else
	{
%>
	◁◁&nbsp;&nbsp;&nbsp;◀&nbsp;&nbsp;&nbsp;
<%
	}
	
	linkPage++;
	System.out.println("linkPage >>> : " + linkPage);
	
	int loopCount = groupSize;
	System.out.println("loopCount >>> : " + loopCount);
	
	while((loopCount > 0) && (linkPage <= pageCount)){
		if(linkPage == curPage){
			System.out.println("그룹범위내에서 페이지 링크 if");
%>
	<%= linkPage %>
<%
		}
		else{
			System.out.println("그룹범위내에서 페이지 링크else");
%>
	[<span onclick="goAdoptionSelectAll(<%= linkPage %>)"><%= linkPage %></span>]&nbsp;
<%
		}
		linkPage++;
		loopCount--;
	}
	
	if(linkPage <= pageCount){
		System.out.println("다음그룹이 있는 경우 linkPage >>> : "+linkPage);
		System.out.println("다음그룹이 있는 경우 pageCount >>> : "+pageCount);
%>
	<span onclick="goAdoptionSelectAll(<%= linkPage %>)">▶</span>&nbsp;&nbsp;&nbsp;
	<span onclick="goAdoptionSelectAll(<%= pageCount %>)">▷▷</span>&nbsp;&nbsp;&nbsp;
<%
	}
	else{
		System.out.println("다음그룹이 있는 경우 linkPage >>> : "+linkPage);
		System.out.println("다음그룹이 있는 경우 pageCount >>> : "+pageCount);
		System.out.println("다음그룹이 있는 경우 else");
%>
	▶&nbsp;&nbsp;&nbsp;▷▷&nbsp;&nbsp;&nbsp;
<%
	}
%>
</p>