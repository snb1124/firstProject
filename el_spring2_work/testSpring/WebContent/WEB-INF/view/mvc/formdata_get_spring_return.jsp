<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@ page import="a.b.c.com.vo.FormDataVO" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>spring data method get </title>
</head>
<body>
<h3>spring data method get</h3>
<%
	Object obj = request.getAttribute("m_fvo");
	FormDataVO fdvo = (FormDataVO)obj; 	

	out.println("��Ʈ�ѷ����� ���� �� �����ϱ� getAttribute��� �������� ��->"+fdvo);
	out.println("��Ʈ�ѷ����� ���� �� �����ϱ� getAttribute��� voŬ���� get�Լ�ȣ���ϱ�->"+fdvo);
	out.println("��Ʈ�ѷ����� ���� �� �����ϱ� getAttribute��� voŬ���� get�Լ�ȣ���ϱ�->"+fdvo.getDatanum());
	out.println("��Ʈ�ѷ����� ���� �� �����ϱ� getAttribute��� voŬ���� get�Լ�ȣ���ϱ�->"+fdvo.getDataid());
	out.println("��Ʈ�ѷ����� ���� �� �����ϱ� getAttribute��� voŬ���� get�Լ�ȣ���ϱ�->"+fdvo.getDatapw());
	out.println("��Ʈ�ѷ����� ���� �� �����ϱ� getAttribute��� voŬ���� get�Լ�ȣ���ϱ�->"+fdvo.getDataname());
	
%>
<hr>
el������ 
��Ʈ�ѷ����� ��Ʈ�� Ÿ�� ������ �޾Ƽ� ����ϱ� <br>
���� ����� �ƴϴ� �Ѱܹ��� ���������� �״�� ����� �� �ִ�. 
${m_datanum}
${m_dataid}
${m_datapw}
${m_dataname}<br>
<hr>
�Ѱܹ��� �������� ����ؼ� el�� ����ϱ� 
${m_fvo} 
${m_fvo.datanum}
${m_fvo.dataid}
${m_fvo.datapw}
${m_fvo.dataname}

<hr>
$ {m_fvo } >>> : ${m_fvo }<br>
$ {m_fvo.datanum } >>> : ${m_fvo.datanum }<br>
$ {fvo.dataid } >>> : ${fvo.dataid }<br>
$ {formDataVO.datapw } >>> : ${formDataVO.datapw } : FormDataVO<br>
<!--  FormDataVO formDataVO = new FormDataVO(); -->
<!-- ������ �����ӿ�ũ�� ����������Ʈ�� ���Ͱ��� �ν��Ͻ��س��´�. �׷��� ���� ������� ��� �����ϴ�. -->

</body>
</html>