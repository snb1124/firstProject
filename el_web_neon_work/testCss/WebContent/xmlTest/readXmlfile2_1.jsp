<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ page import="javax.xml.parsers.DocumentBuilderFactory" %> 
<%@ page import="javax.xml.parsers.DocumentBuilder" %>
<%@ page import="org.w3c.dom.Document" %>
<%@ page import="org.w3c.dom.NodeList" %>
<%@ page import="org.w3c.dom.Node" %>
<%@ page import="org.w3c.dom.Element" %>
<%@ page import="java.io.File" %>

<%@ page import="a.b.c.com.common.CommonXML" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%!
	// jsp 에서 함수를 사용하려먼 <%! 에서 사용하면 된다. 
	private static String getTagValue(String sTag, Element eElement) 
	{
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);
		return nValue.getNodeValue();
	}
%>
<%
	// 파일의 url 읽기 
	
	String xmlURLPath = "http://localhost:8088/testCss/cssTest/xmlTest/file.xml";
	// 파일의 절대 경로 읽기 
	String xmlFilePath = CommonXML.XML_FILE_PATH;
	 File fXmlFile = new File(xmlFilePath + "/file.xml");
	// File fXmlFile = new File("/testCss/xmlTest/file.xml");
	System.out.println(fXmlFile);
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	
	//파일 로 xml데이터를 가져올 때 는 절대경로 사용
	// url로 xml데이터를 가져올  때는 상대경로를 사용 
	Document doc = dBuilder.parse(fXmlFile);	
	//Document doc = dBuilder.parse(xmlURLPath);	
	doc.getDocumentElement().normalize();
	
	out.println("Root element : " + doc.getDocumentElement().getNodeName() + "<br>");
	System.out.println("요거임 -> "+doc.getDocumentElement().getNodeName());
	
	NodeList nList = doc.getElementsByTagName("staff");
	out.println("-----------------------<br>");
	
	for (int temp = 0; temp < nList.getLength(); temp++) 
	{
		Node nNode = nList.item(temp);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	
		Element eElement = (Element) nNode;
	
		out.println("First Name : " + getTagValue("firstname", eElement) + "<br>");
		out.println("Last Name : " + getTagValue("lastname", eElement) + "<br>");
		out.println("Nick Name : " + getTagValue("nickname", eElement) + "<br>");
		out.println("Salary : " + getTagValue("salary", eElement) + "<br>");
	
		}
	}
%>
</body>
</html>