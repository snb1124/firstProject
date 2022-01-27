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
//���� ������̼�
@WebServlet("/location_1")
//Ŭ���� 
public class EmpServlet_1 extends HttpServlet {
	//Ŭ���� ������ȣ
	private static final long serialVersionUID = 1L;

	//Get ������� ������ request, response
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��û���� ���� ���ڵ� ���
		req.setCharacterEncoding("EUC-KR");
		//��û ���� ������ ����
		res.setContentType("text/html; charset=EUC-KR");
		//�μ��� ����� ���� �޾Ƽ� ������ ������ ���?
		PrintWriter out = res.getWriter();
		
		out.println("<html><head></head>");
		out.println("<body>");
		out.println("<h3>EmpServlet_1 :: ������ �̵� �׽�Ʈ</h3>");
		out.println("<hr>");
		/*
		out.println("<script>");
		out.println("location.href='http://www.naver.com'");
		out.println("</script>");
		*/

		// dispather.html ���±׿��� �Ѿ�� input �±��� hidden Ÿ�� ���� �޴´�.
		//->dispatcher_1.html ���� sall��ư�� �������� sall, s�� �������鰡 �Ű������� ���´�. 
		String isudtype = req.getParameter("isudtype");
		String empno = req.getParameter("empno");
		String ename = req.getParameter("ename");
		//isud Ÿ���� �� ���� �ƴ϶�� ����
		if (isudtype !=null && isudtype.length() > 0){
			//�빮�ڷ� 
			isudtype = isudtype.toUpperCase();
			//�����ϸ� ��ü��ȸ
			if ("SALL".equals(isudtype)){
				System.out.println("��ü��ȸ isudtype >>> : " + isudtype);
				
				ArrayList<EmpVO> aList = null;
				try {
					//connection�κ�
					//Ŭ���������� ���÷��� api�� �Ϻη� � ������ Ÿ���� ���� ���� �� �ִ�. �̸����˸�?
					Class.forName("oracle.jdbc.driver.OracleDriver");
					//Connection������ ���̽��� �����ϴ� ��ü ������ �۵��Ǵ� ����̺�� �ٸ� ��?
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orclKOSMO00", "scott","1234");
					//sql������ �����ϴ� �������Ѵ�.
					Statement stmt = conn.createStatement();
					//������ ����Ǹ� ResultSetŸ������ ������� �޴´�. 
					ResultSet rsRs = stmt.executeQuery("SELECT * FROM EMP");
					//��� ����Ʈ ����
					aList = new ArrayList<EmpVO>();
					//�ݺ��� ���� next�Լ� false�� ���� ������ false�� �����Ͱ� ���°��
					while (rsRs.next()){
						EmpVO evo = new EmpVO();
						//voŬ���� ���Լ� ��� �ʱ�ȭ
						evo.setEmpno(rsRs.getString(1));
						evo.setEname(rsRs.getString(2));
						evo.setJob(rsRs.getString(3));
						evo.setMgr(rsRs.getString(4));
						evo.setHiredate(rsRs.getString(5));
						evo.setSal(rsRs.getString(6));
						evo.setComm(rsRs.getString(7));
						evo.setDeptno(rsRs.getString(8));
						//�ʱ�ȭ�� voŬ������ �ν��Ͻ��� ���������� ��̸���Ʈ�� ��´�
						aList.add(evo);
						
					}
					//aList = null;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					// e.printStackTrace();
					System.out.println("������ >>> : " + e.getMessage());
				}
				
				
				if (aList !=null && aList.size() > 0){
					
				//setAttribute������ �Ӽ��� �Ӽ����� �����Ѵ�.
					//�̹� �Ӽ����� �ִٸ� ���� ���ǵ� ������ ����ȴ�. 
					//req �Ӽ� aList�� aList �Ӽ����� �����Ѵ�. 
					req.setAttribute("aList", aList);
					
					//RequestDispatcher->�̵��ϴ� ��ü �� ���� ��û������ dispatcher_1.jsp�� ����
					RequestDispatcher rd = req.getRequestDispatcher("/cgiTest/dispatcher_1.jsp");
					rd.forward(req, res);			
				}else{
					//��ũ��Ʈ ���� if�� ������ �������� ���ϸ�
					out.println("<script>");
					
					out.println("alert('������ ��ȸ ����')");
					//�����̼ǰ�ü�� �̿��� '/testKsj/location_1' �̰����� �̵���Ų��. 
					out.println("location.href='/testKsj/location_1'");
					out.println("</script>");
				}				
			}
			//���� ��ȸ ��ư ������ �� �Ű������� s�� ������ val ��ü�� ���� ����� html ���Ͽ��� 
			if ("S".equals(isudtype)){
				System.out.println("������ȸ isudtype >>> : " + isudtype);				
				out.println("<h3>������ȸ ���� ��</h3><br>");		

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
					System.out.println("������ >>> : " + e.getMessage());
				}
				
				if (1 == nCnt){					
					// dispatherSelect.jsp �� ������ ArrayList ��ü ����
					req.setAttribute("nCnt", new Integer(nCnt));
					// RequestDispatcher �������̽� ���� ����ϴ� getRequestDispatcher �Լ������� 
					// Context ��θ� �������  ����
					//�� try catch���� ncnt�� 1��� ���� ���� ���� ->"/cgiTest/dispatcherSelect.jsp"�� �̵� 
					RequestDispatcher rd = req.getRequestDispatcher("/cgiTest/dispatcherSelect.jsp");
					rd.forward(req, res);								
				}else{
					out.println("<script>");
					out.println("alert('������ ��ȸ ����')");
					out.println("location.href='/testKsj/cgiTest/dispatcher_1.html'");
					out.println("</script>");
				}							
			}
			
		}else{
			System.out.println("isudtype�� �� �����ÿ� !!!! ");
		}
		
		out.println("</body></html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
