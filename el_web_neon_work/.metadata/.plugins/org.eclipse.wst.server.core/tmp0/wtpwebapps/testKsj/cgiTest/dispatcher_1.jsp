<!-- dispatcher���� ���� �����͸� �޾Ҵ� -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="a.b.c.cgitest.EmpVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=EUC-KR">
<title>dispatcher_1</title>
</head>
<body>
<h3>dispatcher_1.jsp</h3>
<hr>
<%
//aList�� �Ӽ����� �ް����ϴ� �Ӽ��̴�. �� obj�� �Ӽ����� ������ϴ� alist�Ӽ�?�򰥸��� 
		//getattribute�� ���� ���쿡�� �����. 
		//			setAttribute������ �Ӽ��� �Ӽ����� �����Ѵ�.
					//�̹� �Ӽ����� �ִٸ� ���� ���ǵ� ������ ����ȴ�. 
					//req �Ӽ� aList�� aList �Ӽ����� �����Ѵ�. 
					//req.setAttribute("aList", aList);
					//�̰� �����°ǰ�?
	Object obj = request.getAttribute("aList");
	if(obj == null) return;
	//������Ʈ Ÿ������ ����ִ� alist�� arraylist�� �ѱ��
	ArrayList<EmpVO> aList = (ArrayList<EmpVO>)obj;
	
	if(aList != null && aList.size() > 0){
		out.println("aList >>> : " + aList.size() + "<br>");
		
		for(int i=0; i<aList.size(); i++){
			EmpVO evo = aList.get(i);
			//�ϳ��������� ��� 
			out.println(evo.getEmpno() + " : ");
			out.println(evo.getEname() + " : ");
			out.println(evo.getJob() + " : ");
			out.println(evo.getMgr() + " : ");
			out.println(evo.getHiredate() + " : ");
			out.println(evo.getSal() + " : ");
			out.println(evo.getComm() + " : ");
			out.println(evo.getDeptno() + "<br>");
		}
	}else{
		out.println("ArrayList�� �����Ͱ� ����� >>> : ");
	}
%>
</body>
</html>