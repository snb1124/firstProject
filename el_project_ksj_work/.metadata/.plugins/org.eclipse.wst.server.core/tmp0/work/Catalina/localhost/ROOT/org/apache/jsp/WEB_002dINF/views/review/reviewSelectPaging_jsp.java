/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.70
 * Generated at: 2021-12-11 07:18:18 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.review;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

public final class reviewSelectPaging_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

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
    _jspx_imports_classes.add("java.util.Collection");
    _jspx_imports_classes.add("java.io.File");
    _jspx_imports_classes.add("java.util.ArrayList");
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	/*전달해야할 변수*/
	
	String url = null;
	String str = null;
	
	url = request.getParameter("url");
	System.out.println("url >>>:" + url);
	
	str = request.getParameter("str");
	System.out.println("str >>>:" + str);
	
	if(str!= null && str.length()>0){
		str = str + "&";
		System.out.println("str + & >>>" + str);
	}

      out.write("\r\n");
      out.write("\r\n");

	/*페이지 네비게이션 관련 변수*/
	
	//한페이지에 보여질 게시물 수 
	int pageSize = 0;
	//그룹의 크기
	int groupSize = 0;
	//전체 게시물의 개수
	int totalCount= 0;
	//현재페이지
	int curPage = 0;
	//전체 페이지의 개수 
	int pageCount = 0;
	
	if(request.getParameter("pageSize") != null){
		pageSize = Integer.parseInt(request.getParameter("pageSize"));
		System.out.println("pageSize >>>:" + pageSize);
	}
	
	if(request.getParameter("groupSize") != null){
		groupSize = Integer.parseInt(request.getParameter("groupSize"));
		System.out.println("groupSize >>>:" + groupSize);
	}
	
	if(request.getParameter("totalCount") != null){
		totalCount = Integer.parseInt(request.getParameter("totalCount"));
		System.out.println("totalCount >>>:" + totalCount);
	}
	
	if(request.getParameter("curPage") != null){
		curPage = Integer.parseInt(request.getParameter("curPage"));
		System.out.println("curPage >>>:" + curPage);
	}
	
	//현재 그룹 설정 1-1/5
	int curGroup = (curPage-1) / groupSize;
	System.out.println("curGroup>>>:"+curGroup);
	
	//전체 게시물수와 페이지 크기를 가지고 전체 페이지 개수를 계산함 
	//소수점에 따라 계산상의 오류가 없도록 한것 
	
	//강사님 코드는 gorupsize 로 나눳는데 pageSize로 나눠야 잘 나옴 **
	pageCount = (int)Math.ceil(totalCount/(pageSize+0.0)); // 4.6 -> 5
	System.out.println("pageCount >>>:" + pageCount);
	//(0/page)
	
	//0*0
	int linkPage = curGroup * groupSize;
	System.out.println("linkPage >>>:" +linkPage);

      out.write("\r\n");
      out.write("<p align=\"right\">\r\n");

	//첫번째 그룹이 아닌경우
	if(curGroup >0){


      out.write("\r\n");
      out.write("	<a href =\"");
      out.print(url);
      out.write('?');
      out.print(str);
      out.write("curPage = 1\">◁◁</a>&nbsp;&nbsp;&nbsp;\r\n");
      out.write("	<a href =\"");
      out.print(url);
      out.write('?');
      out.print(str);
      out.write("curPage=");
      out.print(linkPage);
      out.write("\">◀</a>&nbsp;&nbsp;&nbsp;\r\n");

}else{

      out.write("\r\n");
      out.write("	◁◁&nbsp;&nbsp;&nbsp◀&nbsp;&nbsp;&nbsp;\r\n");

}

//다음 링크를 위해 증가시킴
linkPage++;
System.out.println("linkPage++ >>>:" + linkPage);

int loopCount = groupSize;
System.out.println("loopCount >>>:" + loopCount);

//그룹 범위내에서 페이지 링크만듦 5>0 && 1<=40
while((loopCount >0) && (linkPage <= pageCount)){
	if(linkPage == curPage){
		System.out.println("그룹 범위내에서 페이지 링크 if");

      out.write('\r');
      out.write('\n');
      out.write('	');
      out.print(linkPage );
      out.write('\r');
      out.write('\n');

	}else{
		System.out.println("그룹 범위내에서 페이지 링크 else");
		//[2][3][4][5]

      out.write("\r\n");
      out.write("	[<a href=\"");
      out.print(url );
      out.write('?');
      out.print(str );
      out.write("curPage=");
      out.print(linkPage );
      out.write('"');
      out.write('>');
      out.print(linkPage );
      out.write("</a>]&nbsp;\r\n");
      out.write("\r\n");

}
	linkPage++;
	loopCount--;
}

//다음 그룹이 있는 경우
if(linkPage <= pageCount){
	System.out.println("다음 그룹이 있는 경우linkPage >>>>:" + linkPage);
	System.out.println("다음 그룹이 있는 경우 pageCount >>>>:" + pageCount);
	

      out.write("	\r\n");
      out.write("<a href =\"");
      out.print(url);
      out.write('?');
      out.print(str);
      out.write("curPage=");
      out.print(linkPage );
      out.write("\">▶</a>&nbsp;&nbsp;&nbsp;\r\n");
      out.write("<a href =\"");
      out.print(url);
      out.write('?');
      out.print(str);
      out.write("curPage=");
      out.print(pageCount);
      out.write("\">▷▷</a>&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\r\n");

}else{
	System.out.println("다음 그룹이 있는 경우linkPage >>>>:" + linkPage);
	System.out.println("다음 그룹이 있는 경우 pageCount >>>>:" + pageCount);
	System.out.println("다음 구룹이 있는 경우_else");
	

      out.write("\r\n");
      out.write("	▶&nbsp;&nbsp;&nbsp;▷▷&nbsp;&nbsp;&nbsp;\r\n");

}

      out.write('\r');
      out.write('\n');
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
