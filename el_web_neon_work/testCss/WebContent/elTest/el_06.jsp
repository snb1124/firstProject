<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<%@ page import="a.b.c.com.common.EL_MemberVO" %>
<%@ page import="java.util.ArrayList" %>

<%
	// ��Ʈ�� �迭 ���� 
	String[] study = {"JAVA", "View", "SQL", "Servlet/JSP/SPRING", "Android", "IoT", "Project"};
	// setAttribute ������ ����ֱ� 
	request.setAttribute("study", study);
	//��̸���Ʈ ����, ��� �߰��ϱ� 
	ArrayList<String> list = new ArrayList<>();
	list.add("������");
	list.add("�ٳ���");
	list.add("���");
	list.add("���");
	list.add("����");
	//setAttribute ������ ����ֱ� 
	request.setAttribute("list", list);
	// vo Ŭ���� �ν��Ͻ�ȭ
	EL_MemberVO mvo = new EL_MemberVO();
	//�� ����ֱ� 
	mvo.setIrum("���ڼ�");
	mvo.setId("KJS");
	mvo.setPw("1234");
	mvo.setAge(24);
	mvo.setAddr("��⵵ ȣ��");
	mvo.setTel("032-111-2222");
	request.setAttribute("mvo", mvo);
	
	//�ٸ� ��̸���Ʈ ��� �߰� 
	ArrayList<EL_MemberVO> mlist = new ArrayList<>();
	//��� �Լ��� ���°���? 
	mlist.add(new EL_MemberVO("ȫ�浿", "hong", "1234", 11, "�����", "010-1111-1111"));
	mlist.add(new EL_MemberVO("ȫ�浿", "hong", "1234", 22, "�����", "010-1111-1111"));
	mlist.add(new EL_MemberVO("ȫ�浿", "hong", "1234", 33, "�����", "010-1111-1111"));
	mlist.add(new EL_MemberVO("ȫ�浿", "hong", "1234", 44, "�����", "010-1111-1111"));
	mlist.add(new EL_MemberVO("ȫ�浿", "hong", "1234", 55, "�����", "010-1111-1111"));
	//setAttribute ������ �߰� 
	request.setAttribute("mlist", mlist);
%>
<!-- �̵�  -->
<jsp:forward page="el_06_1.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>el_06</title>
</head>
<body>
<h3>el_06</h3>
<hr>

</body>
</html>