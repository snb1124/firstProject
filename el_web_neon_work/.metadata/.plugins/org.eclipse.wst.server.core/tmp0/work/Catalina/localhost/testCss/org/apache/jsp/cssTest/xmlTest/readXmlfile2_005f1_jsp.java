/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.70
 * Generated at: 2021-09-29 10:33:37 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.cssTest.xmlTest;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import a.b.c.com.common.CommonXML;

public final class readXmlfile2_005f1_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {


	// jsp 에서 함수를 사용하려먼 <%! 에서 사용하면 된다. 
	private static String getTagValue(String sTag, Element eElement) 
	{
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);
		return nValue.getNodeValue();
	}

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("a.b.c.com.common.CommonXML");
    _jspx_imports_classes.add("org.w3c.dom.NodeList");
    _jspx_imports_classes.add("org.w3c.dom.Element");
    _jspx_imports_classes.add("org.w3c.dom.Document");
    _jspx_imports_classes.add("javax.xml.parsers.DocumentBuilder");
    _jspx_imports_classes.add("org.w3c.dom.Node");
    _jspx_imports_classes.add("javax.xml.parsers.DocumentBuilderFactory");
    _jspx_imports_classes.add("java.io.File");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=EUC-KR");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("    \r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"EUC-KR\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write('\r');
      out.write('\n');

	// 파일의 url 읽기 
	//http://localhost:8088/testCss/cssTest/xmlTest/file.xml
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

      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
