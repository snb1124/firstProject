package a.b.c.com.ksj.notice.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import a.b.c.com.common.CommonUtils;
import a.b.c.com.common.FileUploadUtil;
import a.b.c.com.common.GetChabun;
import a.b.c.com.ksj.board.service.BoardService;
import a.b.c.com.ksj.board.service.BoardServiceImpl;
import a.b.c.com.ksj.board.vo.BoardVO;
import a.b.c.com.ksj.mem.service.MemberService;
import a.b.c.com.ksj.mem.service.MemberServiceImpl;
import a.b.c.com.ksj.mem.vo.MemberVO;
import a.b.c.com.ksj.notice.service.NoticeService;
import a.b.c.com.ksj.notice.service.NoticeServiceImpl;
import a.b.c.com.ksj.notice.vo.NoticeVO;

@WebServlet("/notice")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("EUC-KR");
		response.setCharacterEncoding("EUC-KR");
		response.setContentType("text/html; charset=EUC-KR");
		PrintWriter out = response.getWriter();
		
		String isudType = request.getParameter("ISUD_TYPE");	
		
		if (isudType !=null && isudType.length() > 0){
			isudType = isudType.toUpperCase();
			
			// �������� ��� ------------------------------------------------------------------------------
			if ("I".equals(isudType)){
				System.out.println("�������׵��isudType >>> : " + isudType);
				
                boolean bool = request.getContentType().toLowerCase().startsWith("multipart/form-data");				
				if (bool){
					System.out.println("�������׵�� ���Ͼ��ε� ��ƾ :: bool >>> : " + bool);
					
					String filePaths = CommonUtils.NOTICE_IMG_UPLOAD_PATH;
	                int size_limit = CommonUtils.NOTICE_IMG_FILE_SIZE;
	                String  encode_type = CommonUtils.NOTICE_IMG_ENCODE;
					
					FileUploadUtil fu = new FileUploadUtil();					
					boolean bFile = fu.fileUpldad3(request, filePaths, size_limit, encode_type);
					
					if (bFile){
						
						// ���� ȣ���ϱ� 
						NoticeService ns = new NoticeServiceImpl();
						NoticeVO nvo = null;
						nvo = new NoticeVO();
						
						String knum = GetChabun.getNoticeChabun("d");
						System.out.println("knum >>> : " + knum);
						
						// �������� ��ȣ
						nvo.setKnum(knum);
						// �������� ����
						nvo.setKsubject(fu.getParameter("ksubject"));
						// ��������  ����
						nvo.setKmemo(fu.getParameter("kmemo"));						
						// ����
						ArrayList<String> aFileName = fu.getFileNames();
						String kphoto = aFileName.get(0);				
						nvo.setKphoto(kphoto);
						
					
						System.out.println("NoticeController �������� ��� >>> I ");
						NoticeVO.printlnNoticeVO(nvo);
					
						int nCnt = ns.noticeInsert(nvo);
						System.out.println("nCnt >>> : " + nCnt);
						if (nCnt > 0){						
							request.setAttribute("nCnt", new Integer(nCnt));				
							RequestDispatcher rd = request.getRequestDispatcher("/kosmo_ksj/notice/noticeInsert.jsp");
							rd.forward(request, response);						
						}else{
							out.println("<script>");				
							out.println("location.href='/testKsj/kosmo_ksj/notice/notice.html'");
							out.println("</script>");
						}
					
					}else{
						System.out.println("�������� ��� �� ���� ���ε� ���� ");
					}	
				}				
			} // �������� ��� end
			// ��ü �������� ��ȸ ------------------------------------------------------------------------
			if ("SALL".equals(isudType)){
				System.out.println("������������ ��ü��ȸ isudType >>> : " + isudType);
				
				// ���� ȣ���ϱ� 
				NoticeService ns = new NoticeServiceImpl();
				ArrayList<NoticeVO> aListAll = ns.noticeSelectAll();
				
				if (aListAll !=null && aListAll.size() > 0) {
					request.setAttribute("aListAll", aListAll);					
					RequestDispatcher rd= request.getRequestDispatcher("/kosmo_ksj/notice/noticeSelectAll.jsp");
					rd.forward(request, response);
				}else {
					out.println("<script>");					
					out.println("location.href='/testKsj/notice?ISUD_TYPE=SALL'");
					out.println("</script>");
				}		
			} // ��ü ȸ������ ��ȸ end
			
			// �������� ��ȸ : S U D ---------------------------------------------------------------------
			if ("S".equals(isudType) || "U".equals(isudType)){
				System.out.println("�������� ������ȸ : S U D isudType >>> : " + isudType);

				String knum = request.getParameter("knumCheck");				
				if (knum !=null && knum.length() > 0){
					System.out.println("�������� ��ȣ >>> :  " + knum);
					
					// ���� ȣ���ϱ� 
					NoticeService ns = new NoticeServiceImpl();
					NoticeVO nvo = null;
					nvo = new NoticeVO();
					
					nvo.setKnum(knum);					
					ArrayList<NoticeVO> aListS = ns.noticeSelect(nvo);
					
					if (aListS !=null && aListS.size() > 0) {
						System.out.println("aListS.size() >>> : " + aListS.size());						
						request.setAttribute("aListS", aListS);					
						RequestDispatcher rd= request.getRequestDispatcher("/kosmo_ksj/notice/noticeSelect.jsp");
						rd.forward(request, response);
						
					}else {
						out.println("<script>");
						out.println("alert('�������� ��ȸ ����')");
						out.println("location.href='/testKsj/notice?ISUD_TYPE=SALL'");
						out.println("</script>");
					}									
				}else{
					System.out.println("�������� ��ȣ��  �����ϴ�. ");
				}		
			}
			
			// �������� ���� ------------------------------------------------------------------------------
			if ("UOK".equals(isudType)){
				System.out.println("�������� ���� isudType >>> : " + isudType);
				
				String knum = request.getParameter("knum");
				String ksubject = request.getParameter("ksubject");
				String kmemo = request.getParameter("kmemo");				
				System.out.println("knum >>> : " + knum);
				System.out.println("ksubject >>> : " + ksubject);
				System.out.println("kmemo >>> : " + kmemo);
				
				// ���� ȣ���ϱ� 
				NoticeService ns = new NoticeServiceImpl();
				NoticeVO nvo = null;
				nvo = new NoticeVO();
				
				nvo.setKnum(knum);
				nvo.setKsubject(ksubject);
				nvo.setKmemo(kmemo);
				
				int nCnt = ns.noticeUpdate(nvo);
				
				if (nCnt > 0) {
					System.out.println("�������� ������  ���� �Ǿ����ϴ�." + nCnt);					
					request.setAttribute("nCnt", new Integer(nCnt));										
					RequestDispatcher rd= request.getRequestDispatcher("/kosmo_ksj/notice/noticeUpdate.jsp");
					rd.forward(request, response);
					
				}else {
					System.out.println("�� ���� ���� !!!!");
					out.println("<script>");	
					out.println("alert('�� ���� ����')");
					out.println("location.href='/testKsj/notice?ISUD_TYPE=SALL'");
					out.println("</script>");
				}
			}			
			
			// �������� ���� ------------------------------------------------------------------------------
			if ("DOK".equals(isudType)){
				System.out.println("�������� ���� isudType >>> : " + isudType);
				
			
				String knum = request.getParameter("knumCheck");				
				if (knum !=null && knum.length() > 0){
					System.out.println("�������� ��ȣ >>> :  " + knum);
					
					// ���� ȣ���ϱ� 
					NoticeService ns = new NoticeServiceImpl();
					NoticeVO nvo = null;
					nvo = new NoticeVO();
					
					nvo.setKnum(knum);
					int nCnt = ns.noticeDelete(nvo);
					
					if (nCnt > 0) {
						System.out.println("�������� ������  ���� �Ǿ����ϴ�." + nCnt);					
						request.setAttribute("nCnt", new Integer(nCnt));										
						RequestDispatcher rd= request.getRequestDispatcher("/kosmo_ksj/notice/noticeDelete.jsp");
						rd.forward(request, response);
						
					}else {
						System.out.println("�� ���� ���� !!!!");
						out.println("<script>");	
						out.println("alert('�� ���� ����')");
						out.println("location.href='/testKsj/notice?ISUD_TYPE=SALL'");
						out.println("</script>");
					}
				}else{
					System.out.println("�������� ��ȣ�� �� �ѱ⼼�� !!!! ");
				}	
			}	
			
			// �������� �����ϱ� : NOTICE ---------------------------------------------------------------------
			if ("NOTICE".equals(isudType)){
				System.out.println("�������� ������ȸ : NOTICE isudType >>> : " + isudType);

				String knum = "NB202109240005";				
				if (knum !=null && knum.length() > 0){
					System.out.println("�������� ��ȣ >>> :  " + knum);
					
					// ���� ȣ���ϱ� 
					NoticeService ns = new NoticeServiceImpl();
					NoticeVO nvo = null;
					nvo = new NoticeVO();
					
					nvo.setKnum(knum);					
					ArrayList<NoticeVO> aListS = ns.noticeSelect(nvo);
					
					if (aListS !=null && aListS.size() > 0) {
						System.out.println("aListS.size() >>> : " + aListS.size());						
						request.setAttribute("aListS", aListS);					
						RequestDispatcher rd= request.getRequestDispatcher("/kosmo_ksj/notice/noticePopup.jsp");
						rd.forward(request, response);
						
					}else {
						out.println("<script>");
						out.println("alert('�������� ���� ��ȸ����')");					
						out.println("</script>");
					}									
				}else{
					System.out.println("�������� ��ȣ��  �����ϴ�. ");
				}		
			}
		}else{
			System.out.println("form �±׿��� hidden Ÿ���� ISUD_TYPE �� �ѱ⼼�� >>> : ");
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
