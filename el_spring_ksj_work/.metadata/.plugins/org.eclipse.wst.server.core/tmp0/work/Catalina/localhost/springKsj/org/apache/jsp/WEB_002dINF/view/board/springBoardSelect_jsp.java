/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.70
 * Generated at: 2021-10-26 06:48:04 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import a.b.c.com.board.vo.SpringBoardVO;
import java.util.List;

public final class springBoardSelect_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("a.b.c.com.board.vo.SpringBoardVO");
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
      out.write(" \r\n");
      out.write("  \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Board Select</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("	dib{\r\n");
      out.write("		margin: 50px 0px 0px 100px;\r\n");
      out.write("	}\r\n");
      out.write("	.mem{text-align: center}\r\n");
      out.write("</style>\r\n");
      out.write("<script  src=\"http://code.jquery.com/jquery-latest.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("	$(document).ready(function(){\r\n");
      out.write("		$(document).on(\"click\", \"#pwbtn\", function(){\r\n");
      out.write("			alert(\"pwbtn 이벤트 발생\");\r\n");
      out.write("			\r\n");
      out.write("			let pwcheckURL =\"boardPwCheck.jin\";\r\n");
      out.write("			let reqType =\"POST\";\r\n");
      out.write("			let dataParam={\r\n");
      out.write("					knum: $(\"#knum\").val(),\r\n");
      out.write("					kpw: $(\"#kpw\").val(),\r\n");
      out.write("			};\r\n");
      out.write("			$.ajax({\r\n");
      out.write("				url:pwcheckURL,\r\n");
      out.write("				type:reqType,\r\n");
      out.write("				data:dataParam,\r\n");
      out.write("				success:whenSuccess,\r\n");
      out.write("				error:whenError\r\n");
      out.write("			});\r\n");
      out.write("			\r\n");
      out.write("			function whenSuccess(resData){\r\n");
      out.write("				alert(\"resData->>>>\"+resData);\r\n");
      out.write("				if(\"PW_GOOD\"==resData){\r\n");
      out.write("					alert(\"비밀번호 일치\");\r\n");
      out.write("					$(\"kpw\").attr(\"readonly\", true);\r\n");
      out.write("					$(\"U\").css('backgroun-color', 'yellow');\r\n");
      out.write("					$(\"D\").css('color', 'red');\r\n");
      out.write("				}else if(\"PW_GOOD\"==resData){\r\n");
      out.write("					alert(\"비밀번호 불일치\");\r\n");
      out.write("					$(\"#kpw\").val('');\r\n");
      out.write("					$(\"#kpw\").focus();\r\n");
      out.write("				};\r\n");
      out.write("					\r\n");
      out.write("			}\r\n");
      out.write("			function whenError(e){\r\n");
      out.write("				alert(\"에러발생-->>>\"+ e.responseText);\r\n");
      out.write("			}\r\n");
      out.write("		});\r\n");
      out.write("		\r\n");
      out.write("		$(document).on(\"click\",\"#U\", function(){\r\n");
      out.write("			//alert(\"업데이트 이벤트 발생\");\r\n");
      out.write("			$(\"#boardUpdateForm\").attr({\"method\":\"POST\", \"action\":\"boardUpdate.jin\"}).submit();\r\n");
      out.write("		});\r\n");
      out.write("		$(document).on(\"click\",\"#D\", function(){\r\n");
      out.write("			//alert(\"딜리트 이벤트 발생\");\r\n");
      out.write("			$(\"#boardUpdateForm\").attr({\"method\":\"POST\", \"action\":\"boardDelete.jin\"}).submit();\r\n");
      out.write("		});\r\n");
      out.write("		});\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<h3>boardSelect</h3>\r\n");
      out.write("<hr>\r\n");

	Object obj = request.getAttribute("listS");
	List<SpringBoardVO>list = (List)obj;
	//코드 잘못된거 같은데
	SpringBoardVO bvo = null;
	if(list.size()==1){
		bvo=list.get(0);
	}


      out.write("\r\n");
      out.write("<div>\r\n");
      out.write("	<form name=\"boardUpdateForm\" id=\"boardUpdateForm\">\r\n");
      out.write("	<table border=\"1\">\r\n");
      out.write("		<tr>\r\n");
      out.write("			<td colspan=\"2\" align=\"center\"> 게시판 글 수정</td>\r\n");
      out.write("		</tr>\r\n");
      out.write("		<tr>\r\n");
      out.write("		<td class=\"mem\">글번호 </td>\r\n");
      out.write("		<td><input type=\"text\" name=\"knum\" id=\"knum\" value=\"");
      out.print( bvo.getKnum() );
      out.write("\" readonly/></td>\r\n");
      out.write("		</tr>	\r\n");
      out.write("		<tr>\r\n");
      out.write("		<td class=\"mem\">제목 </td>\r\n");
      out.write("		<td><input type=\"text\" name=\"ksubject\" id=\"ksubject\" value=\"");
      out.print( bvo.getKsubject() );
      out.write("\" style=\"width:100px\" readonly/></td>\r\n");
      out.write("		</tr>\r\n");
      out.write("		<tr>\r\n");
      out.write("		<td class=\"mem\">이름</td>\r\n");
      out.write("		<td><input type=\"text\" name=\"kname\" id=\"kname\" value=\"");
      out.print(bvo.getKname() );
      out.write("\" readonly></td>\r\n");
      out.write("		</tr>\r\n");
      out.write("		<tr>\r\n");
      out.write("		<td class=\"mem\">소개글</td>\r\n");
      out.write("		<td>\r\n");
      out.write("		<textarea name=\"kcontent\" id=\"kcontent\" rows=\"5\" cols=\"50\"> ");
      out.print( bvo.getKcontent() );
      out.write("</textarea>\r\n");
      out.write("		</td>\r\n");
      out.write("		</tr>\r\n");
      out.write("		<tr>\r\n");
      out.write("		<td class=\"mem\">사진</td>\r\n");
      out.write("		<td>\r\n");
      out.write("		<img src=\"/springKsj/imgupload/sm_");
      out.print(bvo.getKfile());
      out.write("\" border=\"1\" width=\"40\" height=\"50\" alt=\"이미지\">\r\n");
      out.write("		</td>\r\n");
      out.write("		</tr>\r\n");
      out.write("		<tr>\r\n");
      out.write("		<td class=\"mem\">등록일</td>\r\n");
      out.write("		<td> \r\n");
      out.write("		<input type=\"text\" name=\"kinsertdate\" id=\"kinsertdate\" value=\"");
      out.print( bvo.getKinsertdate());
      out.write("\" readonly/>\r\n");
      out.write("		</td>\r\n");
      out.write("		</tr>\r\n");
      out.write("		<tr>\r\n");
      out.write("		<td class=\"mem\">수정일</td>\r\n");
      out.write("		<td> \r\n");
      out.write("		<input type=\"text\" name=\"kupdatedate\" id=\"kupdatedate\" value=\"");
      out.print( bvo.getKupdatedate());
      out.write("\" readonly/>\r\n");
      out.write("		</td>\r\n");
      out.write("		</tr>\r\n");
      out.write("		<tr>\r\n");
      out.write("		<td class=\"mem\">패스워드</td>\r\n");
      out.write("		<td>\r\n");
      out.write("		 <input type=\"text\" name=\"kpw\" id=\"kpw\" />\r\n");
      out.write("		 <button type=\"button\" id=\"pwbtn\">비밀번호</button>\r\n");
      out.write("		 </td>\r\n");
      out.write("		 </tr>\r\n");
      out.write("		 <tr>\r\n");
      out.write("		 <td colspan=\"2\" align=\"right\">\r\n");
      out.write("		 <button type=\"button\" id=\"U\">수정 </button>\r\n");
      out.write("		 <button type=\"button\" id=\"D\">삭제 </button>\r\n");
      out.write("		 </td>\r\n");
      out.write("		 </tr>\r\n");
      out.write("	</table>\r\n");
      out.write("	</form>\r\n");
      out.write("</div>\r\n");
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
