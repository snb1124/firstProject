/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.70
 * Generated at: 2021-12-11 09:01:14 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.recommend;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.catchdog.common.DogSizeUtil;
import com.catchdog.common.CatSizeUtil;

public final class RecommendForm_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("com.catchdog.common.DogSizeUtil");
    _jspx_imports_classes.add("com.catchdog.common.CatSizeUtil");
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

// 개
String[] dogSize = DogSizeUtil.DOG_SIZE; //사이즈
String[] dogKind = DogSizeUtil.DOG_KIND; //종류

// 고양이
String[] catLength = CatSizeUtil.CAT_LEGNTH; //털길이
String[] catKind = CatSizeUtil.CAT_KIND; //종류

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>관심 동물 선택</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("	form {\r\n");
      out.write("		margin-left: auto !important;\r\n");
      out.write("		margin-right: auto !important;\r\n");
      out.write("		width: 50%;\r\n");
      out.write("		align: center;\r\n");
      out.write("	}\r\n");
      out.write("	#imgAupkind_01, #imgAupkind_02{\r\n");
      out.write("		border: 10px solid #e8e8e8;\r\n");
      out.write("		border-radius: 15px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	#imgAupkind_01 {\r\n");
      out.write("		margin-right:50px;\r\n");
      out.write("	}\r\n");
      out.write("</style>\r\n");
      out.write("<script src=\"http://code.jquery.com/jquery-latest.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("	$(document).ready(function(){	\r\n");
      out.write("		\r\n");
      out.write("		// 지역\r\n");
      out.write("		$(\"#acaresite1\").on('change',function(){\r\n");
      out.write("			\r\n");
      out.write("			var idx = $(this).val(); // 첫번째 select 선택 값 가져오기\r\n");
      out.write("			\r\n");
      out.write("			$('#acaresite2').children('option:not(:first)').remove(); // 두번째 select option값 지우기 (첫번째 option 제외)\r\n");
      out.write("			\r\n");
      out.write("			for(var i=0; i<cities[idx].length; i++){ // combo1의 크기만큼 for문 반복\r\n");
      out.write("				var optiondata = cities[idx][i];\r\n");
      out.write("				$('#acaresite2').append('<option value=\"'+optiondata+'\">'+optiondata+'</option>'); // option 추가하기\r\n");
      out.write("			}	\r\n");
      out.write("			$(\"#acaresite\").val($(\"#acaresite1 option:checked\").text());\r\n");
      out.write("		});	\r\n");
      out.write("		$(\"#acaresite2\").on('change',function(){\r\n");
      out.write("			$(\"#acaresite\").val($(\"#acaresite1 option:checked\").text()+ \" \" +$(\"#acaresite2 option:checked\").text());			 \r\n");
      out.write("		});\r\n");
      out.write("\r\n");
      out.write("		$(\"#btn\").click(function(){\r\n");
      out.write("			\r\n");
      out.write("			// 성별\r\n");
      out.write("			var agender_check = document.getElementsByName('agender');\r\n");
      out.write("			for (var i=0; i < agender_check.length; i++){\r\n");
      out.write("				if (agender_check[i].checked == true){\r\n");
      out.write("					console.log(\"agender_check[\"+i+\"].value >>> : \" + agender_check[i].value);\r\n");
      out.write("				}\r\n");
      out.write("			}\r\n");
      out.write("			\r\n");
      out.write("			var agender_check = $('input:radio[name=agender]:checked').val();\r\n");
      out.write("			console.log(\"agender_check.value >>> : \" + agender_check);\r\n");
      out.write("			\r\n");
      out.write("			\r\n");
      out.write("			$(\"#recommendForm\").attr({\r\n");
      out.write("				\"action\":\"recommendInsert.cd\",\r\n");
      out.write("				\"method\":\"POST\"\r\n");
      out.write("			}).submit();\r\n");
      out.write("		});\r\n");
      out.write("		\r\n");
      out.write("		// 종\r\n");
      out.write("		$(\"img[name=imgAupkind]\").click(function(){ // 여러 객체 이벤트 동시\r\n");
      out.write("			var idNo = ($(this).attr(\"id\")).replace(\"imgAupkind_\",\"\"); // 고유 값 갖고오기\r\n");
      out.write("			\r\n");
      out.write("			// 다시 누를 경우를 생각하여 다 숨기고 시작한다.\r\n");
      out.write("			$(\".long\").hide();\r\n");
      out.write("			$(\".short\").hide();\r\n");
      out.write("			$(\".big\").hide();\r\n");
      out.write("			$(\".mid\").hide();\r\n");
      out.write("			$(\".small\").hide();\r\n");
      out.write("			\r\n");
      out.write("			if(idNo == \"01\"){ // 고유값에 따른 처리 분기\r\n");
      out.write("				$(\"#imgAupkind_02\").css(\"border\", \"10px solid #e8e8e8\");\r\n");
      out.write("				$(\"#catsize\").hide();\r\n");
      out.write("				$(\".long\").hide();\r\n");
      out.write("				$(\".short\").hide();\r\n");
      out.write("				if($(\"#dogsize\").is(\":visible\")){\r\n");
      out.write("					$(\"#dogsize\").slideUp(\"slow\");					\r\n");
      out.write("					$(\"#imgAupkind_01\").css(\"border\", \"10px solid #e8e8e8\");\r\n");
      out.write("					$(\"#aupkind\").val(\"\");\r\n");
      out.write("					$(\"[name=asize]\").attr(\"checked\", false);\r\n");
      out.write("				} else {\r\n");
      out.write("					$(\"#dogsize\").slideDown(\"slow\");\r\n");
      out.write("					$(\"#imgAupkind_01\").css(\"border\", \"10px solid #F7AA58\");\r\n");
      out.write("					$(\"#aupkind\").val(idNo);\r\n");
      out.write("				}\r\n");
      out.write("				$(\"[name=afur]\").attr(\"checked\", false);\r\n");
      out.write("				$(\"[name=akind]\").attr(\"checked\", false);\r\n");
      out.write("			} else if (idNo == \"02\"){\r\n");
      out.write("				$(\"#imgAupkind_01\").css(\"border\", \"10px solid #e8e8e8\");\r\n");
      out.write("				$(\"#dogsize\").hide();\r\n");
      out.write("				$(\".big\").hide();\r\n");
      out.write("				$(\".mid\").hide();\r\n");
      out.write("				$(\".small\").hide();\r\n");
      out.write("				if($(\"#catsize\").is(\":visible\")){\r\n");
      out.write("					$(\"#catsize\").slideUp(\"slow\");	\r\n");
      out.write("					$(\"#imgAupkind_02\").css(\"border\", \"10px solid #e8e8e8\");\r\n");
      out.write("					$(\"#aupkind\").val(\"\");\r\n");
      out.write("					$(\"[name=afur]\").attr(\"checked\", false);\r\n");
      out.write("				}else{\r\n");
      out.write("					$(\"#catsize\").slideDown(\"slow\");\r\n");
      out.write("					$(\"#imgAupkind_02\").css(\"border\", \"10px solid #F7AA58\");\r\n");
      out.write("					$(\"#aupkind\").val(idNo);\r\n");
      out.write("				}\r\n");
      out.write("				$(\"[name=asize]\").attr(\"checked\", false);\r\n");
      out.write("				$(\"[name=akind]\").attr(\"checked\", false);\r\n");
      out.write("			}\r\n");
      out.write("			\r\n");
      out.write("			\r\n");
      out.write("			//alert($(\"#aupkind\").val())\r\n");
      out.write("		});\r\n");
      out.write("		\r\n");
      out.write("		// 크기(개)\r\n");
      out.write("		$(\"[name=asize]\").click(function(){\r\n");
      out.write("			var asize = $(this).val();\r\n");
      out.write("			if (asize == \"대형견\"){\r\n");
      out.write("				$(\".big\").show();\r\n");
      out.write("				$(\".mid\").hide();\r\n");
      out.write("				$(\".small\").hide();\r\n");
      out.write("			}else if(asize == \"중형견\"){\r\n");
      out.write("				$(\".mid\").show();\r\n");
      out.write("				$(\".big\").hide();\r\n");
      out.write("				$(\".small\").hide();\r\n");
      out.write("			}else if(asize == \"소형견\"){\r\n");
      out.write("				$(\".small\").show();\r\n");
      out.write("				$(\".big\").hide();\r\n");
      out.write("				$(\".mid\").hide();\r\n");
      out.write("			}\r\n");
      out.write("		});\r\n");
      out.write("		\r\n");
      out.write("		// 털길이(고양이)\r\n");
      out.write("		$(\"[name=afur]\").click(function(){\r\n");
      out.write("			var afur = $(this).val();\r\n");
      out.write("			if (afur == \"장모\"){\r\n");
      out.write("				$(\".long\").show();\r\n");
      out.write("				$(\".short\").hide();\r\n");
      out.write("			}else if(afur == \"단모\"){\r\n");
      out.write("				$(\".long\").hide();\r\n");
      out.write("				$(\".short\").show();\r\n");
      out.write("			}\r\n");
      out.write("		});\r\n");
      out.write("		\r\n");
      out.write("		/* $(document).on(\"click\", \"#S\", function(){\r\n");
      out.write("			$(\"#recommendForm\").attr({\"method\":\"POST\", \"action\":\"recommendSelect.cd\"}).submit();\r\n");
      out.write("		}); */\r\n");
      out.write("		var cities = [\r\n");
      out.write("			[\"강남구\",\"강동구\",\"강북구\",\"강서구\",\"관악구\",\"광진구\",\"구로구\",\"금천구\",\"노원구\",\"도봉구\",\"동대문구\",\"동작구\",\"마포구\",\"서대문구\",\"서초구\",\"성동구\",\"성북구\",\"송파구\",\"양천구\",\"영등포구\",\"용산구\",\"은평구\",\"종로구\",\"중구\",\"중랑구\"],\r\n");
      out.write("			[\"강서구\",\"금정구\",\"기장군\",\"남구\",\"동구\",\"동래구\",\"부산진구\",\"북구\",\"사상구\",\"사하구\",\"서구\",\"수영구\",\"연제구\",\"영도구\",\"중구\",\"해운대구\"],\r\n");
      out.write("			[\"남구\",\"달서구\",\"달성군\",\"동구\",\"북구\",\"서구\",\"수성구\",\"중구\"],\r\n");
      out.write("			[\"강화군\",\"계양구\",\"남동구\",\"동구\",\"미추홀구\",\"부평구\",\"서구\",\"연수구\",\"옹진군\",\"중구\"],\r\n");
      out.write("			[\"광산구\",\"남구\",\"동구\",\"북구\",\"서구\"],																																											\r\n");
      out.write("			[\"대덕구\",\"동구\",\"서구\",\"유성구\",\"중구\"],																																											\r\n");
      out.write("			[\"남구\",\"동구\",\"북구\",\"울주군\",\"중구\"],																																											\r\n");
      out.write("			[],\r\n");
      out.write("			[\"가평군\",\"고양시 덕양구\",\"고양시 일산동구\",\"고양시 일산서구\",\"과천시\",\"광명시\",\"광주시\",\"구리시\",\"군포시\",\"김포시\",\"남양주시\",\"동두천시\",\"부천시\",\"성남시 분당구\",\"성남시 수정구\",\"성남시 중원구\",\"수원시 권선구\",\"수원시 영통구\",\"수원시 장안구\",\"수원시 팔달구\",\"시흥시\",\"안산시 단원구\",\"안산시 상록구\",\"안성시\",\"안양시 동안구\",\"안양시 만안구\",\"양주시\",\"양평군\",\"여주시\",\"연천군\",\"오산시\",\"용인시 기흥구\",\"용인시 수지구\",\"용인시 처인구\",\"의왕시\",\"의정부시\",\"이천시\",\"파주시\",\"평택시\",\"포천시\",\"하남시\",\"화성시\"],\r\n");
      out.write("			[\"강릉시\",\"고성군\",\"동해시\",\"삼척시\",\"속초시\",\"양구군\",\"양양군\",\"영월군\",\"원주시\",\"인제군\",\"정선군\",\"철원군\",\"춘천시\",\"태백시\",\"평창군\",\"홍천군\",\"화천군\",\"횡성군\"],																																										\r\n");
      out.write("			[\"괴산군\",\"단양군\",\"보은군\",\"영동군\",\"옥천군\",\"음성군\",\"제천시\",\"증평군\",\"진천군\",\"청주시 상당구\",\"청주시 서원구\",\"청주시 청원구\",\"청원시 흥덕구\",\"충주시\"],\r\n");
      out.write("			[\"계룡시\",\"공주시\",\"금산군\",\"논산시\",\"당진시\",\"보령시\",\"부여군\",\"서산시\",\"서천군\",\"아산시\",\"예산군\",\"천안시 동남구\",\"천안시 서북구\",\"청양군\",\"태안군\",\"홍성군\"],\r\n");
      out.write("			[\"고창군\",\"군산시\",\"김제시\",\"남원시\",\"무주군\",\"부안군\",\"순창군\",\"완주군\",\"익산시\",\"임실군\",\"장수군\",\"전주시 덕진구\",\"전주시 완산구\",\"정읍시\",\"진안군\"],\r\n");
      out.write("			[\"강진군\",\"고흥군\",\"곡성군\",\"광양시\",\"구례군\",\"나주시\",\"담양군\",\"목포시\",\"무안군\",\"보성군\",\"순천시\",\"신안군\",\"여수시\",\"영광군\",\"영암군\",\"완도군\",\"장성군\",\"장흥군\",\"진도군\",\"함평군\",\"해남군\",\"화순군\"],\r\n");
      out.write("			[\"경산시\",\"경주시\",\"고령군\",\"구미시\",\"군위군\",\"김천시\",\"문경시\",\"봉화군\",\"상주시\",\"성주군\",\"안동시\",\"영덕군\",\"영양군\",\"영주시\",\"영천시\",\"예천군\",\"울릉군\",\"울진군\",\"의성군\",\"청도군\",\"청송군\",\"칠곡군\",\"포항시 남구\",\"포항시 북구\"],\r\n");
      out.write("			[\"거제시\",\"거창군\",\"고성군\",\"김해시\",\"남해군\",\"밀양시\",\"사천시\",\"산청군\",\"양산시\",\"의령군\",\"진주시\",\"창녕군\",\"창원시 마산합포구\",\"창원시 마산회원구\",\"창원시 성산구\",\"창원시 의창구\",\"창원시 진해구\",\"통영시\",\"하동군\",\"함안군\",\"함양군\",\"합천군\"],\r\n");
      out.write("			[\"서귀포시\",\"제주시\"]\r\n");
      out.write("		];\r\n");
      out.write("	});\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/include/header.jsp", out, true);
      out.write("\r\n");
      out.write("\r\n");
      out.write("	<form name=\"recommendForm\" id=\"recommendForm\" style=\"width: 700px; margin-left:auto; margin-right: auto;\">\r\n");
      out.write("		<input type=\"hidden\" name=\"mnum\" id=\"mnum\" value=\"");
      out.print( request.getAttribute("mnum") );
      out.write("\"/>\r\n");
      out.write("		<input type=\"hidden\" name=\"aupkind\" id=\"aupkind\" value=\"\" />\r\n");
      out.write("		<h1 style=\"font-size: 20px; text-align: center; color: black;\">관심있는 반려동물을 선택해주세요</h1>\r\n");
      out.write("		<div style=\"margin-top: 20px;\">\r\n");
      out.write("				<img name=\"imgAupkind\" id=\"imgAupkind_01\" src=\"image/recommendimg/dog.png\" height=\"280\" width=\"300\" style=\"cursor: pointer;\"/>\r\n");
      out.write("				<img name=\"imgAupkind\" id=\"imgAupkind_02\" src=\"image/recommendimg/cat.png\" height=\"280\" width=\"300\"  style=\"cursor: pointer;\"/>\r\n");
      out.write("\r\n");
      out.write("		</div>\r\n");
      out.write("		<div id=\"dogsize\" style=\"display:none;\">\r\n");
      out.write("			<div class=\"asize\" style=\"margin-top: 15px; text-align: center;\">\r\n");
      out.write("				<label>\r\n");
      out.write("					<input type=\"radio\" name=\"asize\" value=\"대형견\">\r\n");
      out.write("					<div class=\"label\">대형견</div>\r\n");
      out.write("				</label>\r\n");
      out.write("				<label>\r\n");
      out.write("					<input type=\"radio\" name=\"asize\" value=\"중형견\">\r\n");
      out.write("					<div class=\"label\">중형견</div>\r\n");
      out.write("				</label>\r\n");
      out.write("				<label>\r\n");
      out.write("					<input type=\"radio\" name=\"asize\" value=\"소형견\">\r\n");
      out.write("					<div class=\"label\">소형견</div>\r\n");
      out.write("				</label>					\r\n");
      out.write("			</div>\r\n");
      out.write("			\r\n");
      out.write("			<div class=\"akind\" style=\"margin-top: 15px; text-align: center;\">\r\n");
      out.write("			");

			for(int i=0; i<dogSize.length; i++){
				if (dogSize[i] == "대형") {
					
      out.write("\r\n");
      out.write("					<label class=\"big\" style=\"display: none;\">\r\n");
      out.write("						<input type=\"radio\" name=\"akind\" value=\"");
      out.print(dogKind[i] );
      out.write("\">\r\n");
      out.write("						<div class=\"label\">");
      out.print(dogKind[i] );
      out.write("</div>\r\n");
      out.write("					</label>\r\n");
      out.write("					");

				} else if (dogSize[i] == "중형") {
					
      out.write("\r\n");
      out.write("					<label class=\"mid\" style=\"display: none;\">\r\n");
      out.write("						<input type=\"radio\" name=\"akind\" value=\"");
      out.print(dogKind[i] );
      out.write("\">\r\n");
      out.write("						<div class=\"label\">");
      out.print(dogKind[i] );
      out.write("</div>\r\n");
      out.write("					</label>\r\n");
      out.write("					");

				} else if (dogSize[i] == "소형") {
					
      out.write("\r\n");
      out.write("					<label class=\"small\" style=\"display: none;\">\r\n");
      out.write("						<input type=\"radio\" name=\"akind\" value=\"");
      out.print(dogKind[i] );
      out.write("\">\r\n");
      out.write("						<div class=\"label\">");
      out.print(dogKind[i] );
      out.write("</div>\r\n");
      out.write("					</label>\r\n");
      out.write("					");

				}
			}
			
      out.write("\r\n");
      out.write("			</div>				\r\n");
      out.write("		</div>\r\n");
      out.write("		<div id=\"catsize\" style=\"display:none;\">\r\n");
      out.write("					<div class=\"afur\" style=\"margin-top: 15px; text-align: center;\">\r\n");
      out.write("						<label>\r\n");
      out.write("							<input type=\"radio\" name=\"afur\" value=\"장모\"/>\r\n");
      out.write("							<div class=\"label\">장모</div>\r\n");
      out.write("						</label>\r\n");
      out.write("						<label>\r\n");
      out.write("							<input type=\"radio\" name=\"afur\" value=\"단모\" />\r\n");
      out.write("							<div class=\"label\">단모</div>\r\n");
      out.write("						</label>			\r\n");
      out.write("					<div class=\"akind\" style=\"margin-top: 15px; text-align: center;\">\r\n");
      out.write("						");

							for (int i=0; i < catLength.length; i++){
								if (catLength[i] == "장모"){
						
      out.write("\r\n");
      out.write("						<label class=\"long\" style=\"display:none;\">\r\n");
      out.write("							<input type=\"radio\" name=\"akind\" value=\"");
      out.print( catKind[i] );
      out.write("\">\r\n");
      out.write("							<div class=\"label\">");
      out.print( catKind[i] );
      out.write("</div>\r\n");
      out.write("						</label>\r\n");
      out.write("						");

								}else if(catLength[i] == "단모"){
						
      out.write("\r\n");
      out.write("						<label class=\"short\" style=\"display:none;\">\r\n");
      out.write("							<input type=\"radio\" name=\"akind\" value=\"");
      out.print( catKind[i] );
      out.write("\">\r\n");
      out.write("							<div class=\"label\">");
      out.print( catKind[i] );
      out.write("</div>\r\n");
      out.write("						</label>\r\n");
      out.write("						");

								}
							}
						
      out.write("\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("		</div>\r\n");
      out.write("		<div>\r\n");
      out.write("			<table style=\"width: 100%; margin: 20px 0; border-top: 1px solid #cccccc;\">\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>성별</td>\r\n");
      out.write("					<td>\r\n");
      out.write("						<input type=\"radio\" name=\"agender\" value=\"암컷\" checked /> 암컷\r\n");
      out.write("						<input type=\"radio\" name=\"agender\" value=\"수컷\" /> 수컷\r\n");
      out.write("					</td>		\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>지역</td>\r\n");
      out.write("					<td>\r\n");
      out.write("						<input type=\"hidden\" name=\"acaresite\" id=\"acaresite\" />\r\n");
      out.write("						<select name=\"acaresite1\" id=\"acaresite1\">\r\n");
      out.write("							<option>시/도 선택</option>\r\n");
      out.write("							<option value=\"0\" title=\"서울특별시\">서울특별시</option>\r\n");
      out.write("							<option value=\"1\" title=\"부산광역시\">부산광역시</option>\r\n");
      out.write("							<option value=\"2\" title=\"대구광역시\">대구광역시</option>\r\n");
      out.write("							<option value=\"3\" title=\"인천광역시\">인천광역시</option>\r\n");
      out.write("							<option value=\"4\" title=\"광주광역시\">광주광역시</option>\r\n");
      out.write("							<option value=\"5\" title=\"대전광역시\">대전광역시</option>\r\n");
      out.write("							<option value=\"6\" title=\"울산광역시\">울산광역시</option>\r\n");
      out.write("							<option value=\"7\" title=\"세종특별자치시\">세종특별자치시</option>\r\n");
      out.write("							<option value=\"8\" title=\"경기도\">경기도</option>\r\n");
      out.write("							<option value=\"9\" title=\"강원도\">강원도</option>\r\n");
      out.write("							<option value=\"10\" title=\"충청북도\">충청북도</option>\r\n");
      out.write("							<option value=\"11\" title=\"충청남도\">충청남도</option>\r\n");
      out.write("							<option value=\"12\" title=\"전라북도\">전라북도</option>\r\n");
      out.write("							<option value=\"13\" title=\"전라남도\">전라남도</option>\r\n");
      out.write("							<option value=\"14\" title=\"경상북도\">경상북도</option>\r\n");
      out.write("							<option value=\"15\" title=\"경상남도\">경상남도</option>\r\n");
      out.write("							<option value=\"16\" title=\"제주특별자치도\">제주특별자치도</option>\r\n");
      out.write("						</select>\r\n");
      out.write("						<select name=\"acaresite2\" id=\"acaresite2\">\r\n");
      out.write("							<option value=\"선택\">시/군/구 선택</option>\r\n");
      out.write("						</select>\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("			</table>\r\n");
      out.write("		</div>\r\n");
      out.write("\r\n");
      out.write("		<div style=\"text-align:center; margin-bottom: 20px;\">\r\n");
      out.write("			<button type=\"button\" id=\"btn\">저장하기</button>\r\n");
      out.write("			<button type=\"reset\">다시</button>\r\n");
      out.write("			<!-- <button type=\"button\" id=\"S\">조회테스트</button> -->\r\n");
      out.write("		</div>\r\n");
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
