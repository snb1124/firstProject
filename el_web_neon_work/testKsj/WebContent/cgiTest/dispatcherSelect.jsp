<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@ page import ="java.util.ArrayList" %>
 <%@ page import ="a.b.c.cgitest.EmpVO" %>
 <!DOCTYPE html>

<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>dispatcherSelect</h3>
<hr>

<%
// �Ӽ��� �����´�nCnt��
	Object obj = request.getAttribute("nCnt");
//���� ���̶�� ���϶����� ����
	if(obj==null) return;
	
//������Ʈ Ÿ�Կ� ��� �����͸� ��ƮŸ������ ����ȯ�ؼ� �ʱ�ȭ
	int nCnt = ((Integer)obj).intValue();
	//���� ��Ű�� Ǯ�����ϱ� 1 �� ncnt�� ���ٸ� �Ʒ� ����
	if (1==nCnt){
		System.out.println("�α��μ���"+nCnt);
	%>
	
		<script>
		//�˶�
			alert("�α��� ����");
		//��ġ��Ų��"/testKsj/cgiTest/testJsp_1.jsp"
			location.href="/testKsj/cgiTest/testjsp_1.jsp";
		</script>
<%

	}

%>
</body>
</html>