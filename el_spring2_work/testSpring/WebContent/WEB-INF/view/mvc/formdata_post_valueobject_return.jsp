<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@ page import="a.b.c.com.vo.FormDataVO" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>formdata_post_valueobject_return</title>
</head>
<body>
<h3>formdata_post_valueobject_return</h3>

��Ŭ��Ʈ�� �ҷ����� ��.
���������������� �𸣰����� ��Ŭ��Ʈ�� ȣ���� ���� ������ getAttribute�� .getparameter�� �޾������
 el�� �׳� ���� 
<%
	FormDataVO formDataVO = (FormDataVO)request.getAttribute("formDataVO");
	out.println(formDataVO.getDatanum());


%>



<hr>
      <h3>${ formDataVO.getDatanum() }</h3>
      <h3>${ formDataVO.getDataid() }</h3>
      <h3>${ formDataVO.getDatapw() }</h3>
      <h3>${ formDataVO.getDataname() }</h3>
      <hr>
      <h3>${ formDataVO.datanum }</h3>
      <h3>${ formDataVO.dataid }</h3>
      <h3>${ formDataVO.datapw }</h3>
      <h3>${ formDataVO.dataname }</h3>
</body>
</html>