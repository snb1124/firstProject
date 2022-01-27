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
// 접근제한자 프라이베이트 스트링 리턴 매개변수 스트링, 엘리먼트 하나씩
private static String getTagValue(String sTag, Element eElement){
	//nodelist 노드 배열 eElement.태그이름가져오는 함수 getElementsByTagName stag(매개변수)가져오고
	//해당 태그트리의 0번째 태그 의 자식 태그 가져와 초기화 아마 0번째이기 때문에 루트 태그일 것으로 추측한다. 
	NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
	//노드 타입 변수 에 위에서 가져온 태그들의 0번째 태그 즉 루트태그를 초기화 
	Node nValue = (Node) nlList.item(0);
	//sTag 루트태그의 벨류를 리턴하는 함수?
	return nValue.getNodeValue();
}
%>
<%
//스트링 타입 변수 xmlFilePath에 파일 패스 초기화
//물리적 파일 경로 찾아서 변수에 저장 
	String xmlFilePath = CommonXML.XML_FILE_PATH;
//파일 클래스 fXmlFile 객채화 매개변수로 경로 가져간다 
//물리적 파일을 찾아 읽어온것 
	File fXmlFile = new File(xmlFilePath + "/file.xml");
//xml을 가져오는 패턴 정확히 이해하지 못했지만 이러한 형태를 띈다 점차 알아가보자 
	DocumentBuilderFactory dbFactroy = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactroy.newDocumentBuilder();
//도큐먼트 doc에 dBuilder클래스에 파스 함수를 호출한다 매개변수로 파일클래스 형태에 매개변수 파일경로를 가지고있는 객체를 초기화 
	Document doc = dBuilder.parse(fXmlFile);
//normalize?  객체 질렬화 등 개념이 있는데 간단하게 말해서 xml문서를 깨끗하게 만드세요
		//setparamter에서 clear하는 개념과 똑같음 
	doc.getDocumentElement().normalize();
	
//루트 태그를 가져와 출력
	out.println("Root element" + doc.getDocumentElement().getNodeName()+"<br>");
//태그 리스트에 
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