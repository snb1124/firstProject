//이동을 담당하는 페이지 
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
//서블릿 어노테이션
@WebServlet("/board")
public class BoardController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	//응답, 요청
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		//요청 받은 데이터 처리 인코딩 형식
		request.setCharacterEncoding("EUC-KR");
		//처리한 데이터를 넘겨줄 때  인코딩 형식
		response.setCharacterEncoding("EUC-KR");
		// 서블릿도 결국엔 페이지 임으로 해당 페이지를 어떤 형태로 인코딩할지 나타내는 코드?
		response.setContentType("text/html; charset=EUC-KR");
		// 서블릿 페이지에 무언갈 작성하기 위해서 사용하는 클래스 
		PrintWriter out = response.getWriter();
		//요청 받은 데이터값 "ISUD_TYPE"을 변수에 담는다. 
		String isudType = request.getParameter("ISUD_TYPE");
		System.out.println("doGet함수 진입");
		//널값이 아니고 값이 0보다 크면 실행
		if (isudType !=null && isudType.length() > 0){
			//대문자로
			isudType = isudType.toUpperCase();
			
			// 글등록 ------------------------------------------------------------------------
			//만약 값이 I라면 실행
			if ("I".equals(isudType)){
				//
				System.out.println("게시판 글 등록 isudType >>> : " + isudType);
				//저장할 경로 커몬 유틸에서 상수로 정의해 놓고 호출한다. 
				 String saveDirectory = CommonUtils.BOARD_IMG_UPLOAD_PATH;
				 //이미지 파일 경로 위와같이 호출
                 int maxPostSize = CommonUtils.BOARD_IMG_FILE_SIZE;
                 //인코딩 형식 위와 같이 호출
                 String  encoding = CommonUtils.BOOK_IMG_ENCODE;
				
				//getContentType()->클라이언트 정보를 전송할 때 사용한 타입을 리턴함 -> String
                //toLowerCase 소문자
                 //startsWith true/false 반환 어떤 문자열이 다른 문자열로 시작하는지 확인 할 수 있습니다. 대소문자를 구분합니다.
				boolean bool = request.getContentType().toLowerCase().startsWith("multipart/form-data");
				//위 조건식 참이면 시작
				if (bool){
					System.out.println("게시판 글 등록 파일업로드 루틴 :: bool >>> : " + bool);
					
					try {
						//MultipartRequest 파일 업로드를 위한 객체 cos.jar에서 사용
						//fileuploadutil 은  MultipartRequest를 가지고있다.
						// 결국에는 동일한 기능을 하는 두가지 클래스를 사용해 본 것?
						MultipartRequest mr = new MultipartRequest(  request  
													                ,saveDirectory
													                ,maxPostSize
													                ,encoding
													                ,new DefaultFileRenamePolicy());
						//html페이지에서 받아온 데이터를 가져와 변수로저장한다. 
						String ksubject = mr.getParameter("ksubject");
						String kwriter = mr.getParameter("kwriter");
						String kpw = mr.getParameter("kpw");
						String kmemo = mr.getParameter("kmemo");
						// 사진
						// String kphoto = mr.getParameter("ksubject");
						//Enumeration 자료를 얻어내는데 사용하는 인터페이스?
						//구글링 다른 정보로는 Enumeration은 순서를 가지고 있는 배열의 한 종류라 설명하며 
						//커서라는 개념이 가장 중요하다 설명한다. 
						//위 개념은 예전에 자바에서 사용한 것처럼 현재 가르키고 있는 커서가 데이터가 있으면 다음으로 넘어가고
						//없으면 종료되는 것과 비슷?
						
						//여기서는 요청받은 데이터에 파일 이름을 받음 
						Enumeration<String> e = mr.getFileNames();
						//nextElement()
						//nextElement()는 현재 커서가 가리키고 있는 데이타-객체(Object)-를 리턴해주고 커서의 위치를 다음 칸으로 옮깁니다
						String imgName = e.nextElement();
						//getFilesystemName 서버 시스템상 실제로 업로드된 파일의 이름을 string을 가져온다. 
						String kphoto = mr.getFilesystemName(imgName);
						
						System.out.println("ksubject >>> : " + ksubject);
						System.out.println("kwriter >>> : " + kwriter);
						System.out.println("kpw >>> : " + kpw);
						System.out.println("kmemo >>> : " + kmemo);					
						System.out.println("kphoto >>> : " + kphoto);
						//-> html에서 가져온 데이터를 변수에 담는 과정 끝
						// 서비스 인스턴스하고 vo클래스 인스턴스 
						BoardService ks = new BoardServiceImpl();
						BoardVO kvo = null;
						kvo = new BoardVO();
						//인스턴스된 vo클래스에 html에서 받아온 데이터 값을 위에 변수로 선언해 초기화해서
						//vo 클래스로 옮겨 담는다.
						String knum = GetChabun.getBoardChabun("N");
						kvo.setKnum(knum);
						kvo.setKsubject(ksubject);
						kvo.setKwriter(kwriter);
						kvo.setKpw(kpw);
						kvo.setKmemo(kmemo);
						kvo.setKphoto(kphoto);
						
						//daoimpl-> service -> controller 까지 오는 과정이다.
						//다오 임플을 보면 성공적으로 리턴을 받았다면 불리언 값을 true로 리턴받는다
						//그결과 다오 ->서비스 ->현재에 이르기까지 해당 값을 리턴 받아 boolean 값이 있는 것이다. 
						boolean kInsert = ks.boardInsert(kvo);
						if (kInsert){						
							//setAttribute kInsert->자바의 변수명  new Boolean(kInsert) 리터럴값이라고 생각하면될듯?
							//getAttribute는 그 값을 리턴한다?
							//예시를 이것으로 볼 수 있다. document.getElementById( 'abc' ).setAttribute( 'href', 'https://www.codingfactory.net'
							request.setAttribute("kInsert", new Boolean(kInsert));
							// RequestDispatcher 인터페이스 에서 사용하는 getRequestDispatcher 함수에서는 
							// Context 경로를 사용하지  않음
							/*
							 RequestDispatcher는 클라이언트로부터 최초에 들어온 요청을 JSP/Servlet 내에서 원하는 자원으로 요청을 넘기는(보내는) 역할을 수행하거나, 특정 자원에 처리를 요청하고 처리 결과를 얻어오는 기능을 수행하는 클래스입니다.
							 *///request=html에서 받아온 정보 
							RequestDispatcher rd = request.getRequestDispatcher("/kosmo_ksj/board/boardInsert.jsp");
							rd.forward(request, response);						
						}else{
							out.println("<script>");				
							out.println("location.href='/testKsj/kosmo_ksj/board/board.html'");
							out.println("</script>");
						}	
					}catch(Exception e){
						System.out.println("게시글 등록 중 에러가 >>> :" + e.getMessage());
					}
				}				
			} // 글등록 end 
			// 글 전체조회 ---------------------------------------------------------------------
			if ("SALL".equals(isudType)){
				System.out.println("게시판 글 전체조회 isudType >>> : " + isudType);
				// 서비스 호출하기 
				BoardService ks = new BoardServiceImpl();
				ArrayList<BoardVO> aListAll = ks.boardSelectAll();
				if (aListAll !=null && aListAll.size() > 0) {
					request.setAttribute("aListAll", aListAll);					
					//RequestDispatcher는 클라이언트로부터 최초에 들어온 요청을 JSP/Servlet 내에서 원하는 자원으로 요청을 넘기는(보내는) 역할을 수행하거나, 
					//특정 자원에 처리를 요청하고 처리 결과를 얻어오는 기능을 수행하는 클래스입니다.
					//즉 요청받은 데이터를 모두 "/kosmo_ksj/board/bookSelectAll.jsp"로 넘김
					RequestDispatcher rd= request.getRequestDispatcher("/kosmo_ksj/board/bookSelectAll.jsp");
					//forward() 메서드는 다음 방문한 페이지로 이동합니다.
					//그리고 
					rd.forward(request, response);
					
				}else {
					//스크립트
					out.println("<script>");
					//로케이션함수 url로 이동
					out.println("location.href='/testksj/board?ISUD_TYPE=SALL'");
					out.println("</script>");
				}		
			}
			
			// 글 조건조회 : S U D --------------------------------------------------------------------- 
			if ("S".equals(isudType) || "U".equals(isudType) || "D".equals(isudType)){
				System.out.println("글 조건조회 : S U D isudType >>> : " + isudType);

				String knum = request.getParameter("knumCheck");				
				if (knum !=null && knum.length() > 0){
					System.out.println("글 번호 >>> :  " + knum);
					
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
						out.println("alert('글 조회 실패')");
						out.println("location.href='/testksj/board?ISUD_TYPE=SALL'");
						out.println("</script>");
					}									
				}else{
					System.out.println("글번호가  없습니다. ");
				}		
			}
			
			// 글 수정 ------------------------------------------------------------------------
			if ("UOK".equals(isudType)){
				System.out.println("글 수정 isudType >>> : " + isudType);
				
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
					System.out.println("글 정보가  수정 되었습니다." + kUpdate);					
					request.setAttribute("kUpdate", new Boolean(kUpdate));										
					RequestDispatcher rd= request.getRequestDispatcher("/kosmo_ksj/board/boardUpdate.jsp");
					rd.forward(request, response);
					
				}else {
					System.out.println("글 수정 실패 !!!!");
					out.println("<script>");	
					out.println("alert('글 수정 실패')");
					out.println("location.href=/testKsj/board?isudtype=SALL");
					out.println("</script>");
				}
			}
			
			// 글 삭제 ------------------------------------------------------------------------
			if ("DOK".equals(isudType)){
				System.out.println("글 삭제 isudType >>> : " + isudType);
				
				String knum = request.getParameter("knum");
				System.out.println("knum >>> : " + knum);
				
				BoardService ks = new BoardServiceImpl();				
				BoardVO kvo = null;
				kvo = new BoardVO();
				
				kvo.setKnum(knum);

				boolean kDelete = ks.boardDelete(kvo);
				
				if (kDelete) {
					System.out.println("글 정보가  삭제 되었습니다." + kDelete);					
					request.setAttribute("kDelete", new Boolean(kDelete));										
					RequestDispatcher rd= request.getRequestDispatcher("/kosmo_ksj/board/boardDelete.jsp");
					rd.forward(request, response);
					
				}else {
					System.out.println("글 삭제 실패 !!!!");
					out.println("<script>");			
					out.println("alert('글 수정 실패')");
					out.println("location.href='/testksj/board?isudtype=SALL'");
					out.println("</script>");
				}
			}
		}else{
			System.out.println("form 태그에서 hidden 타입의 ISUD_TYPE 잘 넘기세요 >>> : ");
		}		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}

