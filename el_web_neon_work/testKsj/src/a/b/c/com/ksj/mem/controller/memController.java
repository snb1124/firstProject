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
		System.out.println("컨트롤러 시작");
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
			System.out.println("컨트롤러 isudType 시작");
			isudType = isudType.toUpperCase();
			
	

		//등록
		if("I".equals(isudType)){
			System.out.println("회원등록 isudtype-> "+isudType);
			System.out.println("컨트롤러 회원 등록 시작 ");
			boolean bool = request.getContentType().toLowerCase().startsWith("multipart/form-data");
			if(bool){
				System.out.println("회원등록 파일업로드 bool-> "+bool);
				
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
					//1ㅇ
					mvo.setKnum(knum);
					//2ㅇ
					mvo.setKname(fu.getParameter("kname"));
					//3ㅇ
					mvo.setKid(fu.getParameter("kid"));
					//4ㅇ
					mvo.setKpw(fu.getParameter("kpw"));
					//5ㅇ
					mvo.setKgender(fu.getParameter("kgender"));
					
					String kbirth = fu.getParameter("kbirth");
					String kbirth1 = fu.getParameter("kbirth1");
					String kbirth2 = fu.getParameter("kbirth2");
					kbirth = kbirth + kbirth1+ kbirth2;
					//6ㅇ
					mvo.setKbirth(kbirth);
					String khp = fu.getParameter("khp");
					String khp1 = fu.getParameter("khp1");
					String khp2 = fu.getParameter("khp2");
					//7ㅇ
					khp = khp + khp1 + khp2;
					mvo.setKhp(khp);
				
					// 전화번호
					String ktel = fu.getParameter("ktel");
					String ktel1 = fu.getParameter("ktel1");
					String ktel2 = fu.getParameter("ktel2");
					ktel = ktel + ktel1 + ktel2;
					//8ㅇ
					mvo.setKtel(ktel);
					
					// 이메일
					String kemail = fu.getParameter("kemail");
					String kemail1 = fu.getParameter("kemail1");						
					kemail = kemail.concat("@").concat(kemail1);
					//9ㅇ
					mvo.setKemail(kemail);
	
					// 주소 : 우편번호10ㅇ
					mvo.setKzonecode(fu.getParameter("kzonecode"));
	
					// 주소 : 도로명 주소 						
					String kroadaddress = fu.getParameter("kroadaddress");
					String kroadaddressdetail = fu.getParameter("kroadaddressdetail");						
					kroadaddress = kroadaddress.concat("@").concat(kroadaddressdetail);
					//11ㅇ
					mvo.setKroadaddress(kroadaddress);
			
					// 주소 : 지번 주소 12ㅇ
					mvo.setKgibunaddress(fu.getParameter("kgibunaddress"));
					
					// 취미 널값 들어가면 실행 안된다.13ㅇ
					// 1html 에서 받아온 데이터 배열에 저장하고 
					// 배열 하나하나 꺼내서 하나에 스트링으로 저장 , 기준 
					String[] hobby = fu.getParameterValues("khobby");
					String khobby = "";
					for (int i=0; i < hobby.length; i++){
						khobby += hobby[i] + ",";
					}
					//깡통 클래스에 저장하기 위해서 하나의 스트링으로 만든다
					mvo.setKhobby(khobby);
			
					// 내소개14ㅇ
					mvo.setKinfo(fu.getParameter("kinfo"));
					
					// 사진 15ㅇ
					ArrayList<String> aFileName = fu.getFileNames();
					String kphoto = aFileName.get(0);				
					mvo.setKphoto(kphoto);
					// 관리자 16ㅇ
					mvo.setKadmin("00"); // 관리자
					
					MemberVO.printMemberVO(mvo);
					System.out.println("컨트롤러 회원 등록 끝 ");
					boolean bInsert = ms.memberInsert(mvo);						
					if (bInsert){						
						request.setAttribute("bInsert", new Boolean(bInsert));				
						RequestDispatcher rd = request.getRequestDispatcher("/kosmo_ksj/mem/memInsert.jsp");
						System.out.println("컨트롤러 회원등록 성공 ");
						rd.forward(request, response);		
						
							}else{
						out.println("<script>");				
						out.println("location.href='/testKsj/kosmo_ksj/mem/mem.html'");
						out.println("</script>");
				
					}
				}//if
			}//if
		}//if
		
		//전체조회 
		if("SALL".equals(isudType)){
			System.out.println("컨트롤러 전체조회 시작");
			MemberService ms = new MemberServiceImpl ();
			ArrayList aListAll = new ArrayList<MemberVO>();
			aListAll = ms.memberSelectAll();
			if(aListAll !=null && aListAll.size() > 0){
				System.out.println("컨트롤러 전체조회 값 트루 ");
				request.setAttribute("aListAll", aListAll);
				RequestDispatcher rd = request.getRequestDispatcher("/kosmo_ksj/mem/memSelectAll.jsp");
				rd.forward(request, response);
			}else{
				System.out.println("컨트롤러 전체조회 펄스");
				out.println("<script>");
				out.println("location.href='/testKsj/mem?ISUD_TYPE=SALL'");
				out.println("</script>");
			}
		}//if "SALL"
		
		if("S".equals(isudType) || "U".equals(isudType) || "D".equals(isudType)){
			System.out.println("회원 조건조회 : S U D isudType >>> : " + isudType);
			//knumcheck는 셀렉트올 파일에서 넘어옴
			System.out.println("컨트롤러 sud 통합 시작");
			String knum = request.getParameter("knumCheck");
			
			if (knum !=null && knum.length() > 0){
				System.out.println("회원 번호 >>> :  " + knum);
				MemberService ms = new MemberServiceImpl();		
				MemberVO mvo = null;
				mvo = new MemberVO();
				mvo.setKnum(knum);
				ArrayList<MemberVO> aListS = ms.memberSelect(mvo);
				if(aListS !=null && aListS.size() > 0){
					System.out.println("컨트롤러 부분조회 값 있음");
					request.setAttribute("aListS", aListS);
					RequestDispatcher rd = request.getRequestDispatcher("/kosmo_ksj/mem/memSelect.jsp");
					rd.forward(request, response);
				}else{
					System.out.println("컨트롤러 부분조회 값 없음 ");
					out.println("<script>");
					out.println("location.href='/testKsj/mem?ISUD_TYPE=SALL'");
					out.println("</script>");
				}
			}else{
				System.out.println("회원 번호 없음 확인 바람.");
			}
			}//S | U | D
			
			if("UOK".equals(isudType)){
				System.out.println("컨트롤러  U 시작 ");
				System.out.println("도서 정보 수정 isudtype >>> : " + isudType);

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
					System.out.println("컨트롤러 업데이트 값 있음");
					request.setAttribute("uUpdate", new Boolean(uUpdate));
					
					RequestDispatcher rd = request.getRequestDispatcher("/kosmo_ksj/mem/memUpdate.jsp");
					rd.forward(request, response);
				}else{
					System.out.println("컨트롤러 업데이트 값 없음");
					out.println("<script>");
					out.println("location.href='/testKsj/mem?ISUD_TYPE=SALL'");
					out.println("</script>");
					
			}//SECOND UOK
		
		}//UOK
 		
			if("DOK".equals(isudType)){
				System.out.println("컨트롤러  D 시작 ");
				System.out.println("도서 정보 수정 isudtype >>> : " + isudType);
				String knum = request.getParameter("knum");
				System.out.println("수정할 글 번호 ->"+knum);
				
				MemberService ms = new MemberServiceImpl();		
				MemberVO mvo = null;
				mvo = new MemberVO();
				mvo.setKnum(knum);
				
				boolean delete = ms.memberDelete(mvo);
				if(delete){
					System.out.println("컨트롤러  값 있음");
					request.setAttribute("delete", new Boolean(delete));
					
					RequestDispatcher rd = request.getRequestDispatcher("/kosmo_ksj/mem/memDelete.jsp");
					rd.forward(request, response);
				}else{
					System.out.println("컨트롤러 딜리트 BOOL FALSE");
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
