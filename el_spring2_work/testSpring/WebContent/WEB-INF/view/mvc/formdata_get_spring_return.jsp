<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@ page import="a.b.c.com.vo.FormDataVO" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>spring data method get </title>
</head>
<body>
<h3>spring data method get</h3>
<%
	Object obj = request.getAttribute("m_fvo");
	FormDataVO fdvo = (FormDataVO)obj; 	

	out.println("컨트롤러에서 들어온 값 추출하기 getAttribute방식 참조변수 값->"+fdvo);
	out.println("컨트롤러에서 들어온 값 추출하기 getAttribute방식 vo클래스 get함수호출하기->"+fdvo);
	out.println("컨트롤러에서 들어온 값 추출하기 getAttribute방식 vo클래스 get함수호출하기->"+fdvo.getDatanum());
	out.println("컨트롤러에서 들어온 값 추출하기 getAttribute방식 vo클래스 get함수호출하기->"+fdvo.getDataid());
	out.println("컨트롤러에서 들어온 값 추출하기 getAttribute방식 vo클래스 get함수호출하기->"+fdvo.getDatapw());
	out.println("컨트롤러에서 들어온 값 추출하기 getAttribute방식 vo클래스 get함수호출하기->"+fdvo.getDataname());
	
%>
<hr>
el문형식 
컨트롤러에서 스트링 타입 변수로 받아서 출력하기 <br>
좋은 방법이 아니다 넘겨받은 참조변수를 그대로 사용할 수 있다. 
${m_datanum}
${m_dataid}
${m_datapw}
${m_dataname}<br>
<hr>
넘겨받은 참조변수 사용해서 el문 출력하기 
${m_fvo} 
${m_fvo.datanum}
${m_fvo.dataid}
${m_fvo.datapw}
${m_fvo.dataname}

<hr>
$ {m_fvo } >>> : ${m_fvo }<br>
$ {m_fvo.datanum } >>> : ${m_fvo.datanum }<br>
$ {fvo.dataid } >>> : ${fvo.dataid }<br>
$ {formDataVO.datapw } >>> : ${formDataVO.datapw } : FormDataVO<br>
<!--  FormDataVO formDataVO = new FormDataVO(); -->
<!-- 스프링 프레임워크가 벨류오브젝트를 위와같이 인스턴스해놓는다. 그래서 따로 선언없이 사용 가능하다. -->

</body>
</html>