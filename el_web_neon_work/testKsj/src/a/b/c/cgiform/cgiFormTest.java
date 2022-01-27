package a.b.c.cgiform;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/form")
public class cgiFormTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		response.setCharacterEncoding("EUC-KR");
		response.setContentType("text/html;charset=EUC-KR");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><title>CgiFormServlet</title></head><body>");
		out.println("<h3>servlet으로 정보받기 </h3>header<hr>");
		
		String isudtype = request.getParameter("isudtype");
		if(isudtype !=null && isudtype.length()>0){
			System.out.println("isudtype ->"+isudtype);
			System.out.println("remoteIP->"+request.getRemoteAddr());
			System.out.println("method->"+request.getMethod());
		}
		if(isudtype.equals("I")){
			String mname = request.getParameter("maname");
			System.out.println(mname);
			String mid = request.getParameter("mid");
			System.out.println(mid);
			String mpw = request.getParameter("mpw");
			System.out.println(mpw);
			String mhp = request.getParameter("mhp");
			System.out.println(mhp);
			String mlocal = request.getParameter("mlocal");
			System.out.println(mlocal);
			String mmsg = request.getParameter("mmsg");
			System.out.println(mmsg);
			String hobby[] = request.getParameterValues("mhobby");
			 if(hobby !=null){
				 for(int i=0; i< hobby.length; i++){
				String mhobby = hobby[i]+",";
				System.out.println(mhobby);
				 }//for
		}//if
		}//first if
		
		out.println("</body></html>");
		
		}// end of doget

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}//end of class
