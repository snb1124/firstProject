<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "a.b.c.com.vo.FormDataVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>formdata_post_spring_modelattribute_return</title>
</head>
<body>
<h3>formdata_post_spring_modelattribute_return</h3>
<hr>
<h4>el������ ����ϱ� </h4>
${ma_fdvo.dataid}<br>
${ma_fdvo.datapw}<br>
${ma_fdvo.datanum}<br>
${ma_fdvo.dataname}<br>
<hr>
<h4>�������� fdvo���</h4>
${fdvo.dataid}<br>
${fdvo.datapw}<br>
${fdvo.datanum}<br>
${fdvo.dataname}<br>
<hr>
<h4>�ڹٽ�ũ��Ʈ�����</h4>
<%
	Object obj = request.getAttribute("ma_fdvo");
	FormDataVO fdvo = (FormDataVO)obj;
	
	System.out.println("formdata_post_spring_mdoelattribute_return.jsp->fdvo->"+fdvo);
	out.println("formdata_post_spring_mdoelattribute_return.jsp->fdvo->"+fdvo);
	
	

%>

</body>
</html>