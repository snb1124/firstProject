/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.70
 * Generated at: 2021-12-09 07:38:41 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.goods;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class goodsForm_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = null;
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>GoodsInsert</title>\r\n");
      out.write("<script src=\"http://code.jquery.com/jquery-latest.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("	$(document).ready(function(){\r\n");
      out.write("		$(document).on(\"click\", \"#gbtn\", function(){\r\n");
      out.write("			$('#goodsForm').attr({\r\n");
      out.write("				'action':'goodsInsert.cd',\r\n");
      out.write("				'method':'POST',\r\n");
      out.write("				'enctype':'multipart/form-data'\r\n");
      out.write("			}).submit();\r\n");
      out.write("		});\r\n");
      out.write("	});\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<form name=\"goodsForm\" id=\"goodsForm\">\r\n");
      out.write("	<table border=\"1\" align=\"center\">\r\n");
      out.write("<!-- \r\n");
      out.write("	private String gnum; 채번 ㅇ\r\n");
      out.write("	private String gpdnum; 채번 ㅇ\r\n");
      out.write("	private String gname; 입력  ㅇ\r\n");
      out.write("	private String gimage; 파일 이름 ㅇ \r\n");
      out.write("	private String gdday; 달력? 마감일 ㅇ\r\n");
      out.write("	private String gmoney; 입력 현재 금액 X \r\n");
      out.write("	private String gtarget; 입력 목표치 ㅇ\r\n");
      out.write("	private String gprice; 입력 가격 ㅇ\r\n");
      out.write("	private String gdetailpage;  상세페이지 컨텐츠 입력 텍스트 에어리어  ㅇ\r\n");
      out.write(" -->	\r\n");
      out.write(" 	<tr>\r\n");
      out.write(" 		<td colspan=\"2\" align=\"center\"> 상품 판매글 입력</td>\r\n");
      out.write(" 	</tr>\r\n");
      out.write(" 	<tr>\r\n");
      out.write(" 		<td align=\"center\">글번호</td>\r\n");
      out.write(" 		<td><input type=\"text\" name=\"gnum\" id=\"gnum\" size=\"20\" readonly></td>\r\n");
      out.write(" 	</tr>\r\n");
      out.write(" 	<tr>\r\n");
      out.write(" 		<td align=\"center\">상품번호</td>\r\n");
      out.write(" 		<td><input type=\"text\" name=\"gpdnum\" id=\"gpdnum\" size=\"20\" readonly></td>\r\n");
      out.write(" 	<tr>\r\n");
      out.write(" 		<td align=\"center\">상품명</td>\r\n");
      out.write(" 		<td><input type=\"text\" name=\"gname\" id=\"gname\" size=\"53\"></td>\r\n");
      out.write(" 	</tr>\r\n");
      out.write(" 	<tr>\r\n");
      out.write(" 		<td align=\"center\">상품가격</td>\r\n");
      out.write(" 		<td><input type=\"text\" name=\"gprice\" id=\"gprice\" size=\"53\"></td>\r\n");
      out.write(" 	</tr>\r\n");
      out.write(" 	<tr>\r\n");
      out.write(" 		<td align=\"center\">목표금액</td>\r\n");
      out.write(" 		<td><input type=\"text\" name=\"gtarget\" id=\"gtarget\" size=\"53\"></td>\r\n");
      out.write(" 	</tr>\r\n");
      out.write(" 	<tr>\r\n");
      out.write(" 		<td align=\"center\">D-DAY</td>\r\n");
      out.write(" 		<td><input type=\"text\" name=\"gdday\" id=\"gdday\" size=\"20\"></td>\r\n");
      out.write(" 	</tr>\r\n");
      out.write(" 	<tr>\r\n");
      out.write("		<td align=\"center\">내용 </td>\r\n");
      out.write("		<td><textarea type=\"text\" name=\"gdetail\" id=\"gdetail\" rows=\"10\"></textarea></td>\r\n");
      out.write("	</tr>\r\n");
      out.write(" 	<tr>\r\n");
      out.write("		<td align=\"center\">사진</td>\r\n");
      out.write("		<td><input type=\"file\" name=\"gimage\" id=\"gimage\"></td>\r\n");
      out.write("	</tr>\r\n");
      out.write("	<tr>\r\n");
      out.write("		<td><input type=\"hidden\" name=\"mnum\" id=\"mnum\" value=\"M2021120024\"></td>\r\n");
      out.write("	</tr>			\r\n");
      out.write("	<tr>\r\n");
      out.write("		<td colspan=\"2\" align=\"right\"></td>\r\n");
      out.write("		<td><input type=\"button\" value=\"글쓰기\" id=\"gbtn\"></td>\r\n");
      out.write("	</tr>\r\n");
      out.write("	</table>\r\n");
      out.write("</form>\r\n");
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
