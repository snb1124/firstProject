package a.b.c.com.common;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
 
public class ReadXMLClass {
	
	public static void main(String argv[]) {
		
		String testClass = "";
		
		try {
			// 파일경로 문자열 변수에 초기화 
			String xmlFilePath = CommonXML.XML_FILE_PATH;
			// 파일 객체 인스턴스화 매개변수로 스트링 타입 경로 
			File fXmlFile = new File( xmlFilePath + "/fileClass.xml");
			// 팩토리 디자인 패턴 : 형식 : xml 파일을 읽어서 파싱할 때 이 패턴이 좋다 
			// 물리적인 xml 파일을 xml 객체로 변환하기 위해서 팩토리 디자인 패턴을 이용한다. 
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			// 도큐먼트 타입 변수 doc에 위 경로에서 가져온 파일 파싱해서 저장
			Document doc = dBuilder.parse(fXmlFile);
			//normalize 가져오는  xml 파일을 깨끗하게 직렬화 등 한다. 
			doc.getDocumentElement().normalize();
			// 가져온 xml파일에 루트 태그를 출력한다
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			//가져온 xml파일에 testclass 태그 네임을 가져온다. 
			NodeList nList = doc.getElementsByTagName("testclass");
			System.out.println("-----------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {
				// item 함수는 get 함수와 비슷 arraylist
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
	
					testClass = getTagValue("test", eElement);
					System.out.println("test : " + testClass);				     			
				}
			}
			
			try{
				Class cla_1 = Class.forName(testClass);
				TestClass classAction = (TestClass)cla_1.newInstance();
				System.out.println(" classAction >>> : " + classAction);	
				classAction.test();
			}catch(Exception e0){}
			
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}

	private static String getTagValue(String sTag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);
		return nValue.getNodeValue();
	}
}
//tag = key and value?
//환경설정파일?..역할?..