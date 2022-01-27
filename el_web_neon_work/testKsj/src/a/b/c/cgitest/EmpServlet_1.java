package a.b.c.cgitest;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LocationServlet
 */
//서블렛 어노테이션
@WebServlet("/location_1")
//클래스 
public class EmpServlet_1 extends HttpServlet {
	//클래스 고유번호
	private static final long serialVersionUID = 1L;

	//Get 방식으로 보낼때 request, response
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		//요청받은 정보 인코딩 방식
		req.setCharacterEncoding("EUC-KR");
		//요청 받은 데이터 형식
		res.setContentType("text/html; charset=EUC-KR");
		//인수에 저장된 값을 받아서 보낼때 보낼때 사용?
		PrintWriter out = res.getWriter();
		
		out.println("<html><head></head>");
		out.println("<body>");
		out.println("<h3>EmpServlet_1 :: 페이지 이동 테스트</h3>");
		out.println("<hr>");
		/*
		out.println("<script>");
		out.println("location.href='http://www.naver.com'");
		out.println("</script>");
		*/

		// dispather.html 폼태그에서 넘어온 input 태그의 hidden 타입 값을 받는다.
		//->dispatcher_1.html 에서 sall버튼을 눌렀으면 sall, s를 눌렀으면가 매개변수로 들어온다. 
		String isudtype = req.getParameter("isudtype");
		String empno = req.getParameter("empno");
		String ename = req.getParameter("ename");
		//isud 타입이 널 값이 아니라는 조건
		if (isudtype !=null && isudtype.length() > 0){
			//대문자로 
			isudtype = isudtype.toUpperCase();
			//동일하면 전체조회
			if ("SALL".equals(isudtype)){
				System.out.println("전체조회 isudtype >>> : " + isudtype);
				
				ArrayList<EmpVO> aList = null;
				try {
					//connection부분
					//클래스폴네임 리플렉스 api의 일부로 어떤 데이터 타입이 오든 받을 수 있다. 이름만알면?
					Class.forName("oracle.jdbc.driver.OracleDriver");
					//Connection데이터 베이스와 연결하는 객체 실제로 작동되는 드라이브는 다른 것?
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orclKOSMO00", "scott","1234");
					//sql구문을 실행하는 역할을한다.
					Statement stmt = conn.createStatement();
					//쿼리가 실행되면 ResultSet타입으로 결과값을 받는다. 
					ResultSet rsRs = stmt.executeQuery("SELECT * FROM EMP");
					//어레이 리스트 선언
					aList = new ArrayList<EmpVO>();
					//반복문 시작 next함수 false가 나올 때까지 false는 데이터가 없는경우
					while (rsRs.next()){
						EmpVO evo = new EmpVO();
						//vo클래스 셋함수 사용 초기화
						evo.setEmpno(rsRs.getString(1));
						evo.setEname(rsRs.getString(2));
						evo.setJob(rsRs.getString(3));
						evo.setMgr(rsRs.getString(4));
						evo.setHiredate(rsRs.getString(5));
						evo.setSal(rsRs.getString(6));
						evo.setComm(rsRs.getString(7));
						evo.setDeptno(rsRs.getString(8));
						//초기화된 vo클래스의 인스턴스를 참조변수로 어레이리스트에 담는다
						aList.add(evo);
						
					}
					//aList = null;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					// e.printStackTrace();
					System.out.println("에러가 >>> : " + e.getMessage());
				}
				
				
				if (aList !=null && aList.size() > 0){
					
				//setAttribute선택한 속성의 속성값을 정의한다.
					//이미 속성값이 있다면 새로 정의된 값으로 변경된다. 
					//req 속성 aList를 aList 속성으로 정의한다. 
					req.setAttribute("aList", aList);
					
					//RequestDispatcher->이동하는 객체 즉 현재 요청받은걸 dispatcher_1.jsp로 보냄
					RequestDispatcher rd = req.getRequestDispatcher("/cgiTest/dispatcher_1.jsp");
					rd.forward(req, res);			
				}else{
					//스크립트 구문 if문 조건을 만족하지 못하면
					out.println("<script>");
					
					out.println("alert('데이터 조회 실패')");
					//로케이션객체를 이용해 '/testKsj/location_1' 이곳으로 이동시킨다. 
					out.println("location.href='/testKsj/location_1'");
					out.println("</script>");
				}				
			}
			//조건 조회 버튼 눌렀을 때 매개변수로 s가 들어오게 val 객체를 통해 설계됨 html 파일에서 
			if ("S".equals(isudtype)){
				System.out.println("조건조회 isudtype >>> : " + isudtype);				
				out.println("<h3>조건조회 실행 블럭</h3><br>");		

				int nCnt = 0;
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orclKOSMO00", "scott","1234");
					Statement stmt = conn.createStatement();
					ResultSet rsRs = stmt.executeQuery("SELECT COUNT(EMPNO) NCNT FROM EMP WHERE EMPNO = " + empno + " AND ENAME = " + "'" + ename + "'");
					while (rsRs.next()){
						nCnt = rsRs.getInt(1);					
					}
				} catch (Exception e) {
					System.out.println("에러가 >>> : " + e.getMessage());
				}
				
				if (1 == nCnt){					
					// dispatherSelect.jsp 로 보내는 ArrayList 객체 세팅
					req.setAttribute("nCnt", new Integer(nCnt));
					// RequestDispatcher 인터페이스 에서 사용하는 getRequestDispatcher 함수에서는 
					// Context 경로를 사용하지  않음
					//위 try catch에서 ncnt가 1라면 현재 구문 실행 ->"/cgiTest/dispatcherSelect.jsp"로 이동 
					RequestDispatcher rd = req.getRequestDispatcher("/cgiTest/dispatcherSelect.jsp");
					rd.forward(req, res);								
				}else{
					out.println("<script>");
					out.println("alert('데이터 조회 실패')");
					out.println("location.href='/testKsj/cgiTest/dispatcher_1.html'");
					out.println("</script>");
				}							
			}
			
		}else{
			System.out.println("isudtype을 잘 보내시오 !!!! ");
		}
		
		out.println("</body></html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
