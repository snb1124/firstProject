/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.70
 * Generated at: 2021-12-11 07:21:26 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.notice;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.catchdog.notice.vo.NoticeVO;
import java.util.List;

public final class NoticeSelectPaging_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("com.catchdog.notice.vo.NoticeVO");
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>공지사항 페이징 목록 </title>\r\n");
      out.write("<script src =\"http://code.jquery.com/jquery-latest.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("	$(document).ready(function(){\r\n");
      out.write("		\r\n");
      out.write("		$(document).on(\"click\",\"#nnum\",function(){\r\n");
      out.write("			if($(this).prop('checked')){\r\n");
      out.write("				$('.nnum').prop('checked',false);\r\n");
      out.write("				$(this).prop('checked',true);\r\n");
      out.write("			}\r\n");
      out.write("		});\r\n");
      out.write("		\r\n");
      out.write("		//검색 버튼 누르면 \r\n");
      out.write("		$(document).on(\"click\",\"#searchBtn\",function(){\r\n");
      out.write("			alert(\"searchBtn>>>\");\r\n");
      out.write("			$(\"#noticeList\").attr({\r\n");
      out.write("									\"method\":\"GET\"\r\n");
      out.write("									,\"action\":\"NoticeSelectPaging.cd\"\r\n");
      out.write("									\r\n");
      out.write("							}).submit();\r\n");
      out.write("			\r\n");
      out.write("		});\r\n");
      out.write("		\r\n");
      out.write("		//I\r\n");
      out.write("		$(document).on(\"click\",\"#I\",function(){\r\n");
      out.write("			\r\n");
      out.write("			location.href =\"noticeForm.cd\";\r\n");
      out.write("		\r\n");
      out.write("		});\r\n");
      out.write("		\r\n");
      out.write("		//U\r\n");
      out.write("		$(document).on(\"click\",\"#U\",function(){\r\n");
      out.write("			if($('.nnum:checked').length == 0){\r\n");
      out.write("				alert('수정할 글 번호 하나를 선택하세요');\r\n");
      out.write("				return;\r\n");
      out.write("			}\r\n");
      out.write("			$(\"#noticeList\").attr({\r\n");
      out.write("							\"method\":\"POST\"\r\n");
      out.write("							,\"action\":\"noticeSelect.cd\"\r\n");
      out.write("						\r\n");
      out.write("			}).submit();\r\n");
      out.write("		});\r\n");
      out.write("		\r\n");
      out.write("		//d버튼 \r\n");
      out.write("		$(document).on(\"click\",\"#D\",function(){\r\n");
      out.write("			if($('.nnum:checked').length == 0){\r\n");
      out.write("				alert('수정할 글 번호 하나를 선택하세요');\r\n");
      out.write("				return;\r\n");
      out.write("			}\r\n");
      out.write("			$(\"#noticeList\").attr({\r\n");
      out.write("							\"method\":\"POST\"\r\n");
      out.write("							,\"action\":\"noticeSelect.cd\"\r\n");
      out.write("							\r\n");
      out.write("			}).submit();\r\n");
      out.write("		});\r\n");
      out.write("	});\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/include/header.jsp", out, true);
      out.write('	');
      out.write('\r');
      out.write('\n');
 
	//페이징 변수 세팅
	int pageSize = 0;
 	int groupSize = 0;
 	int curPage = 0;
 	int totalCount= 0;
 	
 	Object objPaging = request.getAttribute("pagingNVO");
 	NoticeVO pagingNVO = (NoticeVO)objPaging;
 	
 	Object obj = request.getAttribute("listAll");
 	List<NoticeVO> list = (List)obj;
 	
 	int nCnt = list.size();
 	System.out.println("nCnt >>>:" + nCnt);
 	

      out.write("\r\n");
      out.write("<form name=\"noticeList\" id=\"noticeList\">\r\n");
      out.write("<table border =\"1\" align=\"center\">\r\n");
      out.write("<thead>\r\n");
      out.write("<tr>\r\n");
      out.write("	<td colspan=\"10\" align=\"center\">\r\n");
      out.write("		<h2>공지사항</h2>\r\n");
      out.write("	</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("	<td colspan=\"10\" align=\"left\">\r\n");
      out.write("	<select id=\"keyfilter\" name=\"keyfilter\">\r\n");
      out.write("		<option value=\"key1\">제목</option>\r\n");
      out.write("		<option value=\"key2\">내용</option>\r\n");
      out.write("		<option value=\"key3\">제목+내용</option>\r\n");
      out.write("	</select>\r\n");
      out.write("	<input type=\"text\" id=\"keyword\" placeholder=\"검색어입력\"><br>\r\n");
      out.write("	<button type=\"button\" id=\"searchBtn\">검색 </button>\r\n");
      out.write("	</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("	<th class=\"tt\">체크</th>\r\n");
      out.write("	<th class=\"tt\">글번호</th>\r\n");
      out.write("	<th class=\"tt\">제목</th>	\r\n");
      out.write("	<th class=\"tt\">내용</th>\r\n");
      out.write("	<th class=\"tt\">최종작성일</th>\r\n");
      out.write("	<th class=\"tt\">사진</th>	\r\n");
      out.write("</tr>\r\n");
      out.write("</thead>\r\n");
      out.write("\r\n");

	for(int i=0; i<nCnt; i++){
		NoticeVO nvo = list.get(i);
		pageSize = Integer.parseInt(pagingNVO.getPageSize());
		groupSize=Integer.parseInt(pagingNVO.getGroupSize());
		curPage=Integer.parseInt(pagingNVO.getCurPage());
		totalCount =Integer.parseInt(nvo.getTotalCount());


      out.write("\r\n");
      out.write("<tbody>\r\n");
      out.write("<tr>\r\n");
      out.write("	<td align=\"center\">\r\n");
      out.write("		<input type=\"checkbox\" name=\"nnum\" id=\"nnum\" class=\"nnum\" value=\"");
      out.print(nvo.getNnum() );
      out.write("\">\r\n");
      out.write("	</td>\r\n");
      out.write("	<td class=\"tt\">");
      out.print( (curPage-1)*pageSize + i + 1 );
      out.write("</td>\r\n");
      out.write("	<td class=\"tt\">");
      out.print( nvo.getNtitle() );
      out.write("</td>\r\n");
      out.write("	<td class=\"tt\">");
      out.print( nvo.getNcontent() );
      out.write("</td>\r\n");
      out.write("	<td class=\"tt\">");
      out.print( nvo.getNupdatedate() );
      out.write("</td>\r\n");
      out.write("	<td class =\"tt\"><img src =\"/image/noticeimg/");
      out.print(nvo.getNimage() );
      out.write("\"></td>\r\n");
      out.write("</tr>\r\n");

	}//end of for

      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("	<td colspan=\"7\" align=\"right\">\r\n");
      out.write("		<input type=\"button\" value=\"글쓰기 \" id='I'>\r\n");
      out.write("		<input type=\"button\" value=\"글수정 \" id='U'>\r\n");
      out.write("		<input type=\"button\" value=\"글삭제 \" id='D'>\r\n");
      out.write("	</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<td colspan=\"7\">\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "NoticePaging.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("url", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("NoticeSelectPaging.cd", request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("str", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("", request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("pageSize", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(pageSize ), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("groupSize", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(groupSize ), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("curPage", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(curPage ), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("totalCount", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(totalCount ), request.getCharacterEncoding()), out, true);
      out.write("\r\n");
      out.write("</td>\r\n");
      out.write("</tbody>\r\n");
      out.write("</table>\r\n");
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
