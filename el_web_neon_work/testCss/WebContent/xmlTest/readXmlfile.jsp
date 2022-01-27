<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "javax.xml.parsers.DocumentBuilderFactory" %>
<%@ page import = "javax.xml.parsers.DocumentBuilder" %>
<%@ page import = "org.w3c.dom.Document" %>
<%@ page import = "org.w3c.dom.NodeList" %>
<%@ page import="org.w3c.dom.Node" %>
<%@ page import = "org.w3c.dom.Element" %>
<%@ page import = "java.io.File" %>
<%@ page import = "a.b.c.com.common.CommonXML" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%!
// ���������� �����̺���Ʈ ��Ʈ�� ���� �Ű����� ��Ʈ��, ������Ʈ �ϳ���
private static String getTagValue(String sTag, Element eElement){
	//nodelist ��� �迭 eElement.�±��̸��������� �Լ� getElementsByTagName stag(�Ű�����)��������
	//�ش� �±�Ʈ���� 0��° �±� �� �ڽ� �±� ������ �ʱ�ȭ �Ƹ� 0��°�̱� ������ ��Ʈ �±��� ������ �����Ѵ�. 
	NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
	//��� Ÿ�� ���� �� ������ ������ �±׵��� 0��° �±� �� ��Ʈ�±׸� �ʱ�ȭ 
	Node nValue = (Node) nlList.item(0);
	//sTag ��Ʈ�±��� ������ �����ϴ� �Լ�?
	return nValue.getNodeValue();
}
%>
<%
//��Ʈ�� Ÿ�� ���� xmlFilePath�� ���� �н� �ʱ�ȭ
//������ ���� ��� ã�Ƽ� ������ ���� 
	String xmlFilePath = CommonXML.XML_FILE_PATH;
//���� Ŭ���� fXmlFile ��äȭ �Ű������� ��� �������� 
//������ ������ ã�� �о�°� 
	File fXmlFile = new File(xmlFilePath + "/file.xml");
//xml�� �������� ���� ��Ȯ�� �������� �������� �̷��� ���¸� ��� ���� �˾ư����� 
	DocumentBuilderFactory dbFactroy = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactroy.newDocumentBuilder();
//��ť��Ʈ doc�� dBuilderŬ������ �Ľ� �Լ��� ȣ���Ѵ� �Ű������� ����Ŭ���� ���¿� �Ű����� ���ϰ�θ� �������ִ� ��ü�� �ʱ�ȭ 
	Document doc = dBuilder.parse(fXmlFile);
//normalize?  ��ü ����ȭ �� ������ �ִµ� �����ϰ� ���ؼ� xml������ �����ϰ� ���弼��
		//setparamter���� clear�ϴ� ����� �Ȱ��� 
	doc.getDocumentElement().normalize();
	
//��Ʈ �±׸� ������ ���
	out.println("Root element" + doc.getDocumentElement().getNodeName()+"<br>");
//�±� ����Ʈ�� 
	NodeList nList = doc.getElementsByTagName("staff");
	out.println("---------------<br>");
	
	for(int temp = 0; temp < nList.getLength(); temp++){
		
		Node nNode = nList.item(temp);
		if(nNode.getNodeType() == Node.ELEMENT_NODE){
			Element eElement = (Element) nNode;
			
			out.println("First Name" + getTagValue("firstname", eElement)+"<br>");
			out.println("Last Name" + getTagValue("lastname", eElement)+"<br>");
			out.println("Nick Name" + getTagValue("nickname", eElement)+"<br>");
			out.println("Salary" + getTagValue("salary", eElement)+"<br>");
		}
		
		
	}
%>

</body>
</html>