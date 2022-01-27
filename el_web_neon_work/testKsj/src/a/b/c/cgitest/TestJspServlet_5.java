package a.b.c.cgitest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestJspServlet_5
 */
@WebServlet("/testjsp_5")
public class TestJspServlet_5 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Servlet</title></head><body>");
		String remoteAddr = request.getRemoteAddr();
		out.println("remoteAddr"+remoteAddr+"<br>");
		System.out.println("remoteAddr"+remoteAddr+"<br>");
		String protocol = request.getProtocol();
		out.println("protocol"+protocol+"<br>");
		System.out.println("protocol"+protocol+"<br>");
		String method = request.getMethod();
		out.println("method"+method+"<br>");
		System.out.println("method"+method+"<br>");
		String uri = request.getRequestURI();
		out.println("uri"+uri+"<br>");
		System.out.println("uri"+uri+"<br>");
		String url = request.getRequestURL().toString();
		out.println("url"+url+"<br>");
		System.out.println("url"+url+"<br>");
		String context = request.getContextPath();
		out.println("context"+context+"<br>");
		System.out.println("context"+context+"<br>");
		String serverName=request.getServerName();
		out.println("serverName"+serverName+"<br>");
		System.out.println("serverName"+serverName+"<br>");
		String serverPort = String.valueOf(request.getServerPort());
		out.println("serverPort"+serverPort+"<br>");
		System.out.println("serverPort"+serverPort+"<br>");	
		String remotePort = String.valueOf(request.getRemotePort());
		out.println("remotePort"+remotePort+"<br>");
		System.out.println("remotePort"+remotePort+"<br>");
		out.println("</body></html>");
		//http://192.168.219.115:8088/testKsj/cgiTest/testjsp_5.jsp
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
