<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="java.util.ArrayList" %>
<html>
<head>
<meta charset="EUC-KR">
<title>fileUpload</title>
</head>
<body>
<h3>fileUpload.jsp</h3>
<%
	Object obj = request.getAttribute("aList");
	if(obj==null)return;
	
	ArrayList<String>aList = (ArrayList<String>)obj;
	
	if(aList !=null && aList.size()>0){
		for(int i=0; i < aList.size(); i++){
			out.println("->"+aList.get(i)+"<br>");
		}
		
	}
%>
<table border="1">
  <tr>
	<td><img src="/testKsj/fileupload/<%= aList.get(2) %>"></td>
	<td><img src="/testKsj/fileupload/<%= aList.get(2) %>"></td>
	<td><img src="/testKsj/fileupload/<%= aList.get(2) %>"></td>
	<td><img src="/testKsj/fileupload/<%= aList.get(2) %>"></td>
  </tr>
  <tr>
	<td><img src="/testKsj/fileupload/<%= aList.get(3) %>"></td>
	<td><img src="/testKsj/fileupload/<%= aList.get(3) %>"></td>
	<td><img src="/testKsj/fileupload/<%= aList.get(3) %>"></td>
	<td><img src="/testKsj/fileupload/<%= aList.get(3) %>"></td>
  </tr>
  <tr>
	<td><img src="/testKsj/fileupload/<%= aList.get(2) %>"></td>
	<td><img src="/testKsj/fileupload/<%= aList.get(2) %>"></td>
	<td><img src="/testKsj/fileupload/<%= aList.get(2) %>"></td>
	<td><img src="/testKsj/fileupload/<%= aList.get(2) %>"></td>
  </tr>
   <tr>
	<td><img src="/testKsj/fileupload/<%= aList.get(3) %>"></td>
	<td><img src="/testKsj/fileupload/<%= aList.get(3) %>"></td>
	<td><img src="/testKsj/fileupload/<%= aList.get(3) %>"></td>
	<td><img src="/testKsj/fileupload/<%= aList.get(3) %>"></td>
  </tr>
  </table>	
</body>
</html>