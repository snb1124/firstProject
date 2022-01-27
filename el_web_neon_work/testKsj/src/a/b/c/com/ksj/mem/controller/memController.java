package a.b.c.com.ksj.mem.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.membership.McastServiceImpl;

import a.b.c.com.common.CommonUtils;
import a.b.c.com.common.FileUploadUtil;
import a.b.c.com.common.GetChabun;
import a.b.c.com.ksj.mem.service.MemberService;
import a.b.c.com.ksj.mem.service.MemberServiceImpl;
import a.b.c.com.ksj.mem.vo.MemberVO;


@WebServlet("/mem")
public class memController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("��Ʈ�ѷ� ����");
		request.setCharacterEncoding("EUC-KR");
		response.setCharacterEncoding("EUC-KR");
		response.setContentType("text/html; charset=EUC-KR");
		PrintWriter out = response.getWriter();
		String isudType = request.getParameter("ISUD_TYPE");
		/*
		 String knum = request.getParameter("knum");
			String kname = request.getParameter("kname");
			String kid = request.getParameter("kid");
			String kpw = request.getParameter("kpw");
			String kgender = request.getParameter("kgender");
			String kbirth = request.getParameter("kbirth");
			String kph = request.getParameter("kph");
			String ktel = request.getParameter("ktel");
			String kemail = request.getParameter("kemail");
			String kzonecode = request.getParameter("kzonecode");
			String zonecode = request.getParameter("zonecode");
			String kroddadrress = request.getParameter("kroddadrress");
			String kroadaddressdetail = request.getParameter("kroadaddressdetail");
			String kgibunaddress = request.getParameter("kgibunaddress");
			String kinfo = request.getParameter("kinfo");
			String kphoto = request.getParameter("kphoto");
			String khobby = request.getParameter("khobby");
			
			System.out.println(knum);
			System.out.println(kname);
			System.out.println(kid);
			System.out.println(kpw);
			System.out.println(kgender);
			System.out.println(kbirth);
			System.out.println(kph);
			System.out.println(ktel);
			System.out.println(kemail);
			System.out.println(kzonecode);
			System.out.println(zonecode);
			System.out.println(kroddadrress);
			System.out.println(kroadaddressdetail);
			System.out.println(kgibunaddress);
			System.out.println(kinfo);
			System.out.println(kphoto);
			System.out.println(khobby);
*/
		
		
		if(isudType!=null &&isudType.length()>0){
			System.out.println("��Ʈ�ѷ� isudType ����");
			isudType = isudType.toUpperCase();
			
	

		//���
		if("I".equals(isudType)){
			System.out.println("ȸ����� isudtype-> "+isudType);
			System.out.println("��Ʈ�ѷ� ȸ�� ��� ���� ");
			boolean bool = request.getContentType().toLowerCase().startsWith("multipart/form-data");
			if(bool){
				System.out.println("ȸ����� ���Ͼ��ε� bool-> "+bool);
				
				String filePaths = CommonUtils.MEMBER_IMG_UPLOAD_PATH;
				int size_limit = CommonUtils.MEMBER_IMG_FILE_SIZE;
				String encode_type = CommonUtils.MEMBER_IMG_ENCODE;
	
				FileUploadUtil fu = new FileUploadUtil();
				boolean bFile = fu.fileUpldad3(request, filePaths, size_limit, encode_type);
		
				if(bFile){
					MemberService ms = new MemberServiceImpl();
					MemberVO mvo = null;
					mvo = new MemberVO();
				
					String knum = GetChabun.getMemChabun("d");
					System.out.println("knum ->"+knum);
					//1��
					mvo.setKnum(knum);
					//2��
					mvo.setKname(fu.getParameter("kname"));
					//3��
					mvo.setKid(fu.getParameter("kid"));
					//4��
					mvo.setKpw(fu.getParameter("kpw"));
					//5��
					mvo.setKgender(fu.getParameter("kgender"));
					
					String kbirth = fu.getParameter("kbirth");
					String kbirth1 = fu.getParameter("kbirth1");
					String kbirth2 = fu.getParameter("kbirth2");
					kbirth = kbirth + kbirth1+ kbirth2;
					//6��
					mvo.setKbirth(kbirth);
					String khp = fu.getParameter("khp");
					String khp1 = fu.getParameter("khp1");
					String khp2 = fu.getParameter("khp2");
					//7��
					khp = khp + khp1 + khp2;
					mvo.setKhp(khp);
				
					// ��ȭ��ȣ
					String ktel = fu.getParameter("ktel");
					String ktel1 = fu.getParameter("ktel1");
					String ktel2 = fu.getParameter("ktel2");
					ktel = ktel + ktel1 + ktel2;
					//8��
					mvo.setKtel(ktel);
					
					// �̸���
					String kemail = fu.getParameter("kemail");
					String kemail1 = fu.getParameter("kemail1");						
					kemail = kemail.concat("@").concat(kemail1);
					//9��
					mvo.setKemail(kemail);
	
					// �ּ� : �����ȣ10��
					mvo.setKzonecode(fu.getParameter("kzonecode"));
	
					// �ּ� : ���θ� �ּ� 						
					String kroadaddress = fu.getParameter("kroadaddress");
					String kroadaddressdetail = fu.getParameter("kroadaddressdetail");						
					kroadaddress = kroadaddress.concat("@").concat(kroadaddressdetail);
					//11��
					mvo.setKroadaddress(kroadaddress);
			
					// �ּ� : ���� �ּ� 12��
					mvo.setKgibunaddress(fu.getParameter("kgibunaddress"));
					
					// ��� �ΰ� ���� ���� �ȵȴ�.13��
					// 1html ���� �޾ƿ� ������ �迭�� �����ϰ� 
					// �迭 �ϳ��ϳ� ������ �ϳ��� ��Ʈ������ ���� , ���� 
					String[] hobby = fu.getParameterValues("khobby");
					String khobby = "";
					for (int i=0; i < hobby.length; i++){
						khobby += hobby[i] + ",";
					}
					//���� Ŭ������ �����ϱ� ���ؼ� �ϳ��� ��Ʈ������ �����
					mvo.setKhobby(khobby);
			
					// ���Ұ�14��
					mvo.setKinfo(fu.getParameter("kinfo"));
					
					// ���� 15��
					ArrayList<String> aFileName = fu.getFileNames();
					String kphoto = aFileName.get(0);				
					mvo.setKphoto(kphoto);
					// ������ 16��
					mvo.setKadmin("00"); // ������
					
					MemberVO.printMemberVO(mvo);
					System.out.println("��Ʈ�ѷ� ȸ�� ��� �� ");
					boolean bInsert = ms.memberInsert(mvo);						
					if (bInsert){						
						request.setAttribute("bInsert", new Boolean(bInsert));				
						RequestDispatcher rd = request.getRequestDispatcher("/kosmo_ksj/mem/memInsert.jsp");
						System.out.println("��Ʈ�ѷ� ȸ����� ���� ");
						rd.forward(request, response);		
						
							}else{
						out.println("<script>");				
						out.println("location.href='/testKsj/kosmo_ksj/mem/mem.html'");
						out.println("</script>");
				
					}
				}//if
			}//if
		}//if
		
		//��ü��ȸ 
		if("SALL".equals(isudType)){
			System.out.println("��Ʈ�ѷ� ��ü��ȸ ����");
			MemberService ms = new MemberServiceImpl ();
			ArrayList aListAll = new ArrayList<MemberVO>();
			aListAll = ms.memberSelectAll();
			if(aListAll !=null && aListAll.size() > 0){
				System.out.println("��Ʈ�ѷ� ��ü��ȸ �� Ʈ�� ");
				request.setAttribute("aListAll", aListAll);
				RequestDispatcher rd = request.getRequestDispatcher("/kosmo_ksj/mem/memSelectAll.jsp");
				rd.forward(request, response);
			}else{
				System.out.println("��Ʈ�ѷ� ��ü��ȸ �޽�");
				out.println("<script>");
				out.println("location.href='/testKsj/mem?ISUD_TYPE=SALL'");
				out.println("</script>");
			}
		}//if "SALL"
		
		if("S".equals(isudType) || "U".equals(isudType) || "D".equals(isudType)){
			System.out.println("ȸ�� ������ȸ : S U D isudType >>> : " + isudType);
			//knumcheck�� ����Ʈ�� ���Ͽ��� �Ѿ��
			System.out.println("��Ʈ�ѷ� sud ���� ����");
			String knum = request.getParameter("knumCheck");
			
			if (knum !=null && knum.length() > 0){
				System.out.println("ȸ�� ��ȣ >>> :  " + knum);
				MemberService ms = new MemberServiceImpl();		
				MemberVO mvo = null;
				mvo = new MemberVO();
				mvo.setKnum(knum);
				ArrayList<MemberVO> aListS = ms.memberSelect(mvo);
				if(aListS !=null && aListS.size() > 0){
					System.out.println("��Ʈ�ѷ� �κ���ȸ �� ����");
					request.setAttribute("aListS", aListS);
					RequestDispatcher rd = request.getRequestDispatcher("/kosmo_ksj/mem/memSelect.jsp");
					rd.forward(request, response);
				}else{
					System.out.println("��Ʈ�ѷ� �κ���ȸ �� ���� ");
					out.println("<script>");
					out.println("location.href='/testKsj/mem?ISUD_TYPE=SALL'");
					out.println("</script>");
				}
			}else{
				System.out.println("ȸ�� ��ȣ ���� Ȯ�� �ٶ�.");
			}
			}//S | U | D
			
			if("UOK".equals(isudType)){
				System.out.println("��Ʈ�ѷ�  U ���� ");
				System.out.println("���� ���� ���� isudtype >>> : " + isudType);

				String knum = request.getParameter("knum");
				String kemail = request.getParameter("kemail") + "@" + request.getParameter("kemail1");
				String kzonecode = request.getParameter("kzonecode");
				String kroadaddress = request.getParameter("kroadaddress") + "@" + request.getParameter("kroadaddressdetail");
				String kgibunaddress = request.getParameter("kgibunaddress");
				String[] khobbies = request.getParameterValues("khobby");
				String khobby = "";
				
				for(int i=0; i<khobbies.length; i++){
					khobby += khobbies[i];
					if(i != khobbies.length - 1){
						khobby += ",";
					}
				}
				
				System.out.println("knum ->"+knum);
				System.out.println("kemail ->"+kemail);
				System.out.println("kzonecode ->"+kzonecode);
				System.out.println("kroadaddress->"+kroadaddress);
				System.out.println("kgibunaddress->"+kgibunaddress);
				System.out.println("khobby->"+khobby);
				
				MemberService ms = new MemberServiceImpl();		
				MemberVO mvo = null;
				mvo = new MemberVO();
				
				mvo.setKnum(knum);
				mvo.setKemail(kemail);
				mvo.setKzonecode(kzonecode);
				mvo.setKroadaddress(kroadaddress);
				mvo.setKgibunaddress(kgibunaddress);
				mvo.setKhobby(khobby);
				
				 MemberVO.printMemberVO(mvo);
				 boolean uUpdate = ms.memberUpdate(mvo);
				 
				 
				if(uUpdate){
					System.out.println("��Ʈ�ѷ� ������Ʈ �� ����");
					request.setAttribute("uUpdate", new Boolean(uUpdate));
					
					RequestDispatcher rd = request.getRequestDispatcher("/kosmo_ksj/mem/memUpdate.jsp");
					rd.forward(request, response);
				}else{
					System.out.println("��Ʈ�ѷ� ������Ʈ �� ����");
					out.println("<script>");
					out.println("location.href='/testKsj/mem?ISUD_TYPE=SALL'");
					out.println("</script>");
					
			}//SECOND UOK
		
		}//UOK
 		
			if("DOK".equals(isudType)){
				System.out.println("��Ʈ�ѷ�  D ���� ");
				System.out.println("���� ���� ���� isudtype >>> : " + isudType);
				String knum = request.getParameter("knum");
				System.out.println("������ �� ��ȣ ->"+knum);
				
				MemberService ms = new MemberServiceImpl();		
				MemberVO mvo = null;
				mvo = new MemberVO();
				mvo.setKnum(knum);
				
				boolean delete = ms.memberDelete(mvo);
				if(delete){
					System.out.println("��Ʈ�ѷ�  �� ����");
					request.setAttribute("delete", new Boolean(delete));
					
					RequestDispatcher rd = request.getRequestDispatcher("/kosmo_ksj/mem/memDelete.jsp");
					rd.forward(request, response);
				}else{
					System.out.println("��Ʈ�ѷ� ����Ʈ BOOL FALSE");
					out.println("<script>");
					out.println("location.href='/testKsj/mem?ISUD_TYPE=SALL'");
					out.println("</script>");
					
			}//SECOND DOK
			}//DOK
			
		
		
		}// first if
	}//end of doget
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
