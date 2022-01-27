//�̵��� ����ϴ� ������ 
package a.b.c.com.ksj.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import a.b.c.com.common.CommonUtils;
import a.b.c.com.common.GetChabun;
import a.b.c.com.ksj.board.service.BoardService;
import a.b.c.com.ksj.board.service.BoardServiceImpl;
import a.b.c.com.ksj.board.vo.BoardVO;
//���� ������̼�
@WebServlet("/board")
public class BoardController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	//����, ��û
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��û ���� ������ ó�� ���ڵ� ����
		request.setCharacterEncoding("EUC-KR");
		//ó���� �����͸� �Ѱ��� ��  ���ڵ� ����
		response.setCharacterEncoding("EUC-KR");
		// ������ �ᱹ�� ������ ������ �ش� �������� � ���·� ���ڵ����� ��Ÿ���� �ڵ�?
		response.setContentType("text/html; charset=EUC-KR");
		// ���� �������� ���� �ۼ��ϱ� ���ؼ� ����ϴ� Ŭ���� 
		PrintWriter out = response.getWriter();
		//��û ���� �����Ͱ� "ISUD_TYPE"�� ������ ��´�. 
		String isudType = request.getParameter("ISUD_TYPE");
		System.out.println("doGet�Լ� ����");
		//�ΰ��� �ƴϰ� ���� 0���� ũ�� ����
		if (isudType !=null && isudType.length() > 0){
			//�빮�ڷ�
			isudType = isudType.toUpperCase();
			
			// �۵�� ------------------------------------------------------------------------
			//���� ���� I��� ����
			if ("I".equals(isudType)){
				//
				System.out.println("�Խ��� �� ��� isudType >>> : " + isudType);
				//������ ��� Ŀ�� ��ƿ���� ����� ������ ���� ȣ���Ѵ�. 
				 String saveDirectory = CommonUtils.BOARD_IMG_UPLOAD_PATH;
				 //�̹��� ���� ��� ���Ͱ��� ȣ��
                 int maxPostSize = CommonUtils.BOARD_IMG_FILE_SIZE;
                 //���ڵ� ���� ���� ���� ȣ��
                 String  encoding = CommonUtils.BOOK_IMG_ENCODE;
				
				//getContentType()->Ŭ���̾�Ʈ ������ ������ �� ����� Ÿ���� ������ -> String
                //toLowerCase �ҹ���
                 //startsWith true/false ��ȯ � ���ڿ��� �ٸ� ���ڿ��� �����ϴ��� Ȯ�� �� �� �ֽ��ϴ�. ��ҹ��ڸ� �����մϴ�.
				boolean bool = request.getContentType().toLowerCase().startsWith("multipart/form-data");
				//�� ���ǽ� ���̸� ����
				if (bool){
					System.out.println("�Խ��� �� ��� ���Ͼ��ε� ��ƾ :: bool >>> : " + bool);
					
					try {
						//MultipartRequest ���� ���ε带 ���� ��ü cos.jar���� ���
						//fileuploadutil ��  MultipartRequest�� �������ִ�.
						// �ᱹ���� ������ ����� �ϴ� �ΰ��� Ŭ������ ����� �� ��?
						MultipartRequest mr = new MultipartRequest(  request  
													                ,saveDirectory
													                ,maxPostSize
													                ,encoding
													                ,new DefaultFileRenamePolicy());
						//html���������� �޾ƿ� �����͸� ������ �����������Ѵ�. 
						String ksubject = mr.getParameter("ksubject");
						String kwriter = mr.getParameter("kwriter");
						String kpw = mr.getParameter("kpw");
						String kmemo = mr.getParameter("kmemo");
						// ����
						// String kphoto = mr.getParameter("ksubject");
						//Enumeration �ڷḦ ���µ� ����ϴ� �������̽�?
						//���۸� �ٸ� �����δ� Enumeration�� ������ ������ �ִ� �迭�� �� ������ �����ϸ� 
						//Ŀ����� ������ ���� �߿��ϴ� �����Ѵ�. 
						//�� ������ ������ �ڹٿ��� ����� ��ó�� ���� ����Ű�� �ִ� Ŀ���� �����Ͱ� ������ �������� �Ѿ��
						//������ ����Ǵ� �Ͱ� ���?
						
						//���⼭�� ��û���� �����Ϳ� ���� �̸��� ���� 
						Enumeration<String> e = mr.getFileNames();
						//nextElement()
						//nextElement()�� ���� Ŀ���� ����Ű�� �ִ� ����Ÿ-��ü(Object)-�� �������ְ� Ŀ���� ��ġ�� ���� ĭ���� �ű�ϴ�
						String imgName = e.nextElement();
						//getFilesystemName ���� �ý��ۻ� ������ ���ε�� ������ �̸��� string�� �����´�. 
						String kphoto = mr.getFilesystemName(imgName);
						
						System.out.println("ksubject >>> : " + ksubject);
						System.out.println("kwriter >>> : " + kwriter);
						System.out.println("kpw >>> : " + kpw);
						System.out.println("kmemo >>> : " + kmemo);					
						System.out.println("kphoto >>> : " + kphoto);
						//-> html���� ������ �����͸� ������ ��� ���� ��
						// ���� �ν��Ͻ��ϰ� voŬ���� �ν��Ͻ� 
						BoardService ks = new BoardServiceImpl();
						BoardVO kvo = null;
						kvo = new BoardVO();
						//�ν��Ͻ��� voŬ������ html���� �޾ƿ� ������ ���� ���� ������ ������ �ʱ�ȭ�ؼ�
						//vo Ŭ������ �Ű� ��´�.
						String knum = GetChabun.getBoardChabun("N");
						kvo.setKnum(knum);
						kvo.setKsubject(ksubject);
						kvo.setKwriter(kwriter);
						kvo.setKpw(kpw);
						kvo.setKmemo(kmemo);
						kvo.setKphoto(kphoto);
						
						//daoimpl-> service -> controller ���� ���� �����̴�.
						//�ٿ� ������ ���� ���������� ������ �޾Ҵٸ� �Ҹ��� ���� true�� ���Ϲ޴´�
						//�װ�� �ٿ� ->���� ->���翡 �̸������ �ش� ���� ���� �޾� boolean ���� �ִ� ���̴�. 
						boolean kInsert = ks.boardInsert(kvo);
						if (kInsert){						
							//setAttribute kInsert->�ڹ��� ������  new Boolean(kInsert) ���ͷ����̶�� �����ϸ�ɵ�?
							//getAttribute�� �� ���� �����Ѵ�?
							//���ø� �̰����� �� �� �ִ�. document.getElementById( 'abc' ).setAttribute( 'href', 'https://www.codingfactory.net'
							request.setAttribute("kInsert", new Boolean(kInsert));
							// RequestDispatcher �������̽� ���� ����ϴ� getRequestDispatcher �Լ������� 
							// Context ��θ� �������  ����
							/*
							 RequestDispatcher�� Ŭ���̾�Ʈ�κ��� ���ʿ� ���� ��û�� JSP/Servlet ������ ���ϴ� �ڿ����� ��û�� �ѱ��(������) ������ �����ϰų�, Ư�� �ڿ��� ó���� ��û�ϰ� ó�� ����� ������ ����� �����ϴ� Ŭ�����Դϴ�.
							 *///request=html���� �޾ƿ� ���� 
							RequestDispatcher rd = request.getRequestDispatcher("/kosmo_ksj/board/boardInsert.jsp");
							rd.forward(request, response);						
						}else{
							out.println("<script>");				
							out.println("location.href='/testKsj/kosmo_ksj/board/board.html'");
							out.println("</script>");
						}	
					}catch(Exception e){
						System.out.println("�Խñ� ��� �� ������ >>> :" + e.getMessage());
					}
				}				
			} // �۵�� end 
			// �� ��ü��ȸ ---------------------------------------------------------------------
			if ("SALL".equals(isudType)){
				System.out.println("�Խ��� �� ��ü��ȸ isudType >>> : " + isudType);
				// ���� ȣ���ϱ� 
				BoardService ks = new BoardServiceImpl();
				ArrayList<BoardVO> aListAll = ks.boardSelectAll();
				if (aListAll !=null && aListAll.size() > 0) {
					request.setAttribute("aListAll", aListAll);					
					//RequestDispatcher�� Ŭ���̾�Ʈ�κ��� ���ʿ� ���� ��û�� JSP/Servlet ������ ���ϴ� �ڿ����� ��û�� �ѱ��(������) ������ �����ϰų�, 
					//Ư�� �ڿ��� ó���� ��û�ϰ� ó�� ����� ������ ����� �����ϴ� Ŭ�����Դϴ�.
					//�� ��û���� �����͸� ��� "/kosmo_ksj/board/bookSelectAll.jsp"�� �ѱ�
					RequestDispatcher rd= request.getRequestDispatcher("/kosmo_ksj/board/bookSelectAll.jsp");
					//forward() �޼���� ���� �湮�� �������� �̵��մϴ�.
					//�׸��� 
					rd.forward(request, response);
					
				}else {
					//��ũ��Ʈ
					out.println("<script>");
					//�����̼��Լ� url�� �̵�
					out.println("location.href='/testksj/board?ISUD_TYPE=SALL'");
					out.println("</script>");
				}		
			}
			
			// �� ������ȸ : S U D --------------------------------------------------------------------- 
			if ("S".equals(isudType) || "U".equals(isudType) || "D".equals(isudType)){
				System.out.println("�� ������ȸ : S U D isudType >>> : " + isudType);

				String knum = request.getParameter("knumCheck");				
				if (knum !=null && knum.length() > 0){
					System.out.println("�� ��ȣ >>> :  " + knum);
					
					BoardService ks = new BoardServiceImpl();				
					BoardVO kvo = null;
					kvo = new BoardVO();
					
					kvo.setKnum(knum);					
					ArrayList<BoardVO> aListS = ks.boardSelect(kvo);
					
					if (aListS !=null && aListS.size() > 0) {
						System.out.println("aListS.size() >>> : " + aListS.size());						
						request.setAttribute("aListS", aListS);					
						RequestDispatcher rd= request.getRequestDispatcher("/kosmo_ksj/board/boardSelect.jsp");
						rd.forward(request, response);
						
					}else {
						out.println("<script>");
						out.println("alert('�� ��ȸ ����')");
						out.println("location.href='/testksj/board?ISUD_TYPE=SALL'");
						out.println("</script>");
					}									
				}else{
					System.out.println("�۹�ȣ��  �����ϴ�. ");
				}		
			}
			
			// �� ���� ------------------------------------------------------------------------
			if ("UOK".equals(isudType)){
				System.out.println("�� ���� isudType >>> : " + isudType);
				
				String knum = request.getParameter("knum");
				String ksubject = request.getParameter("ksubject");
				String kmemo = request.getParameter("kmemo");				
				System.out.println("knum >>> : " + knum);
				System.out.println("ksubject >>> : " + ksubject);
				System.out.println("kmemo >>> : " + kmemo);
				
				BoardService ks = new BoardServiceImpl();				
				BoardVO kvo = null;
				kvo = new BoardVO();
				
				kvo.setKnum(knum);
				kvo.setKsubject(ksubject);
				kvo.setKmemo(kmemo);
				
				boolean kUpdate = ks.boardUpdate(kvo);
				
				if (kUpdate) {
					System.out.println("�� ������  ���� �Ǿ����ϴ�." + kUpdate);					
					request.setAttribute("kUpdate", new Boolean(kUpdate));										
					RequestDispatcher rd= request.getRequestDispatcher("/kosmo_ksj/board/boardUpdate.jsp");
					rd.forward(request, response);
					
				}else {
					System.out.println("�� ���� ���� !!!!");
					out.println("<script>");	
					out.println("alert('�� ���� ����')");
					out.println("location.href=/testKsj/board?isudtype=SALL");
					out.println("</script>");
				}
			}
			
			// �� ���� ------------------------------------------------------------------------
			if ("DOK".equals(isudType)){
				System.out.println("�� ���� isudType >>> : " + isudType);
				
				String knum = request.getParameter("knum");
				System.out.println("knum >>> : " + knum);
				
				BoardService ks = new BoardServiceImpl();				
				BoardVO kvo = null;
				kvo = new BoardVO();
				
				kvo.setKnum(knum);

				boolean kDelete = ks.boardDelete(kvo);
				
				if (kDelete) {
					System.out.println("�� ������  ���� �Ǿ����ϴ�." + kDelete);					
					request.setAttribute("kDelete", new Boolean(kDelete));										
					RequestDispatcher rd= request.getRequestDispatcher("/kosmo_ksj/board/boardDelete.jsp");
					rd.forward(request, response);
					
				}else {
					System.out.println("�� ���� ���� !!!!");
					out.println("<script>");			
					out.println("alert('�� ���� ����')");
					out.println("location.href='/testksj/board?isudtype=SALL'");
					out.println("</script>");
				}
			}
		}else{
			System.out.println("form �±׿��� hidden Ÿ���� ISUD_TYPE �� �ѱ⼼�� >>> : ");
		}		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}

