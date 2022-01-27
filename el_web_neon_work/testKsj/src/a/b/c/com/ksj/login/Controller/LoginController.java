package a.b.c.com.ksj.login.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import a.b.c.com.ksj.login.Service.LoginService;
import a.b.c.com.ksj.login.Service.LoginServiceImpl;
import a.b.c.com.ksj.mem.vo.MemberVO;

/**
 * Servlet implementation class loginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		response.setCharacterEncoding("EUC-KR");
		response.setContentType("text/html; charset=EUC-KR");
		PrintWriter out = response.getWriter();
		String login_type = request.getParameter("login_type");
		if (login_type !=null) login_type.toUpperCase();
		
		String remoteIP = request.getRemoteAddr();
		String method = request.getMethod();
		
		if("LOGIN".equals(login_type)){
			out.println("로그인 체크 login_type >>> : " + login_type);
			System.out.println("로그인 체크 login_type >>> : " + login_type);						
			System.out.println("method >>> : " + method);		
			System.out.println("remoteIP >>> : " + remoteIP);
			
			String kid = request.getParameter("kid");
			String kpw = request.getParameter("kpw");
			System.out.println("아이디 kid >>> : " + kid);
			System.out.println("비밀번호 kpw >>> : " + kpw);	
			
			LoginService ls = new LoginServiceImpl();
			MemberVO mvo = null;
			mvo = new MemberVO();
			
			mvo.setKid(kid);
			mvo.setKpw(kpw);								
			int nCnt = ls.loginCheckCnt(mvo);
			System.out.println("LoginController LOGIN nCnt >>> : " + nCnt);
			
			if (nCnt == 1) {
				request.setAttribute("nCnt", new Integer(nCnt));
				RequestDispatcher rd= request.getRequestDispatcher("/kosmo_ksj/login/login.jsp");
				rd.forward(request, response);					
			}else {
				out.println("<script>");	
				out.println("alert('로그인 실패 !!')");	
				out.println("location.href='/testKsj/kosmo_ksj/login/login.html'");
				out.println("</script>");
			}	
		}//equals if
		
		// 로그아웃 
		if("LOGOUT".equals(login_type)){
			out.println("로그아웃 login_type >>> : " + login_type);
			System.out.println("로그아웃 login_type >>> : " + login_type);
					
			String kid = request.getParameter("kid");
			boolean bool = false;
			
			if (kid !=null && kid.length() > 0){
				bool = true;
			}
			
			if (bool) {
				RequestDispatcher rd= request.getRequestDispatcher("/kosmo_ksj/login/logout.jsp");
				rd.forward(request, response);					
			}else {
			}					
		
	}else{
		System.out.println("login_type을 잘 넘기세요 >>> : " + login_type);
	}
		
		
		
	}// do get

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
