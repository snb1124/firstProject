/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.70
 * Generated at: 2021-12-12 15:26:53 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.disappearance;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.catchdog.disappearance.vo.DisappearanceVO;
import java.util.List;

public final class disappearanceSelect_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("com.catchdog.disappearance.vo.DisappearanceVO");
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
      out.write("	<head>\r\n");
      out.write("		<meta charset=\"UTF-8\">\r\n");
      out.write("		<title>실종 전단 화면</title>\r\n");
      out.write("		<style type=\"text/css\">\r\n");
      out.write("			table, tr, td, input, textarea{text-align:center;}\r\n");
      out.write("		</style>\r\n");
      out.write("	</head>\r\n");
      out.write("	<body>\r\n");
      out.write("		");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/include/header.jsp", out, true);
      out.write("\r\n");
      out.write("		\r\n");
      out.write("		");

			Object obj = request.getAttribute("listSelect");
			List<DisappearanceVO> listSelect = null;
			DisappearanceVO divo = null;
			if(obj != null){
				listSelect = (List<DisappearanceVO>)obj;
				if(listSelect != null){
				divo = listSelect.get(0);
				}
			}
		
      out.write("\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("		<form id=\"disappearanceSelectForm\" name=\"disappearanceSelectForm\">\r\n");
      out.write("			<table>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td rowspan=\"7\">\r\n");
      out.write("						<img src='/image/disappearanceimg/");
      out.print(divo.getDiimage() );
      out.write("' width=\"300\" height=\"300\"\r\n");
      out.write("							onerror=\"this.src='image/image-available.jpg'\">\r\n");
      out.write("					</td>\r\n");
      out.write("					<td>\r\n");
      out.write("						이름 : <input type=\"text\" id=\"diname\" name=\"diname\" value=\"");
      out.print(divo.getDiname());
      out.write("\" readonly>\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>\r\n");
      out.write("						나이 : <input type=\"text\" id = \"diage\" name=\"diage\" value=\"");
      out.print(divo.getDiage());
      out.write("\" readonly>\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>\r\n");
      out.write("						종 : <input type=\"text\" id=\"dikind\" name=\"dikind\" value=\"");
      out.print(divo.getDikind());
      out.write("\" readonly>\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>\r\n");
      out.write("						실종날짜 : <input type=\"text\" id = \"didate\" name=\"didate\" value=\"");
      out.print(divo.getDidate());
      out.write("\" readonly>\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>\r\n");
      out.write("						실종위치 : <input type=\"text\" id = \"diposition\" name=\"diposition\" value=\"");
      out.print(divo.getDiposition() );
      out.write("\" readonly>\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>\r\n");
      out.write("						특징 : <input type=\"text\" id = \"dispecial\" name=\"dispecial\" value= \"");
      out.print(divo.getDispecial());
      out.write("\"  readonly>\r\n");
      out.write("							 \r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td> \r\n");
      out.write("						연락처 : <input type=\"text\" id = \"dihp\" name=\"dihp\" value=\"");
      out.print(divo.getDihp() );
      out.write("\" readonly>\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>	\r\n");
      out.write("			</table>\r\n");
      out.write("\r\n");
      out.write("		</form>\r\n");
      out.write("		<div id=\"map\" style= \"width:800px;height:400px;margin-top:50px;margin-left:auto;margin-right:auto;\"></div>\r\n");
      out.write("<script src=\"http://code.jquery.com/jquery-latest.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"//dapi.kakao.com/v2/maps/sdk.js?appkey=aaab031f80e0cd017ab6fa5edea946d3&libraries=services\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("$(document).ready(function(){\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("\r\n");
      out.write("	var mapContainer = document.getElementById('map'), // 지도를 표시할 div \r\n");
      out.write("    mapOption = {\r\n");
      out.write("        center: new kakao.maps.LatLng(35.922355665, 128.599034473), // 초기 지도 중심좌표값\r\n");
      out.write("        level: 3 // 지도의 확대 레벨\r\n");
      out.write("    };  \r\n");
      out.write("	    \r\n");
      out.write("	// 지도를 생성합니다    \r\n");
      out.write("	var map = new kakao.maps.Map(mapContainer, mapOption); \r\n");
      out.write("\r\n");
      out.write("	// 주소-좌표 변환 객체를 생성합니다\r\n");
      out.write("	var geocoder = new kakao.maps.services.Geocoder();\r\n");
      out.write("		\r\n");
      out.write("	var address = \"");
      out.print(divo.getDiposition());
      out.write("\";\r\n");
      out.write("	\r\n");
      out.write("	geocoder.addressSearch(address, function(result, status) {\r\n");
      out.write("	\r\n");
      out.write("	    // 정상적으로 검색이 완료됐으면 \r\n");
      out.write("	     if (status === kakao.maps.services.Status.OK) {\r\n");
      out.write("	\r\n");
      out.write("	        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);\r\n");
      out.write("	\r\n");
      out.write("	        // 결과값으로 받은 위치를 마커로 표시합니다\r\n");
      out.write("	        var marker = new kakao.maps.Marker({\r\n");
      out.write("	            map: map,\r\n");
      out.write("	            position: coords\r\n");
      out.write("	        });\r\n");
      out.write("	\r\n");
      out.write("	        // 인포윈도우로 장소에 대한 설명을 표시합니다\r\n");
      out.write("	        var infowindow = new kakao.maps.InfoWindow({\r\n");
      out.write("	            content: \"실종위치\"\r\n");
      out.write("	  \r\n");
      out.write("	        });\r\n");
      out.write("	        infowindow.open(map, marker);\r\n");
      out.write("	\r\n");
      out.write("	        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다\r\n");
      out.write("	        map.setCenter(coords);\r\n");
      out.write("	  	  } \r\n");
      out.write("		});  \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("});\r\n");
      out.write("		</script>\r\n");
      out.write("	</body>\r\n");
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