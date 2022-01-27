package a.b.c.com.mem.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;

import a.b.c.com.common.ChabunUtil;
import a.b.c.com.common.CommonUtils;
import a.b.c.com.common.FileUploadUtil;
import a.b.c.com.common.service.ChabunService;
import a.b.c.com.mem.service.SpringMemberService;
import a.b.c.com.mem.vo.SpringMemberVO;

@Controller
public class SpringMemberController {
	Logger logger = Logger.getLogger(SpringMemberController.class);
	
	private SpringMemberService springMemberService; 
	private ChabunService chabunService;
	
	
	@Autowired(required=false)
	public SpringMemberController(SpringMemberService springMemberService, ChabunService chabunService) {
		
		
		this.springMemberService = springMemberService;
		this.chabunService = chabunService;
	}
	
	@RequestMapping(value="memForm", method=RequestMethod.GET)
	public String memForm() {
		logger.info("컨트롤러 폼 함수 진입");
		return "mem/springMemForm";
	}
	//?? 웬 오류일까 제대로 맞춰줫는디
	@RequestMapping(value="memInsert", method= {RequestMethod.POST, RequestMethod.GET})
	public String memInsert(HttpServletRequest req) {
		logger.info("컨트롤러 인서트 진입");
		//getMemChabun "D"는 데이트 포멧에서 연월일 모두 불러오는 매개변수 
		String mnum=ChabunUtil.getMemChabun("D", chabunService.getMemberChabun().getMnum());
		logger.info("인서트 채번 mnum ->>"+mnum);
		FileUploadUtil fu = new FileUploadUtil(	CommonUtils.MEMBER_IMG_UPLOAD_PATH
                ,CommonUtils.MEMBER_IMG_FILE_SIZE
                ,CommonUtils.MEMBER_EN_CODE);
		
		boolean bool = fu.imgfileUploadSize(req);
		logger.info("멤버 인서트 bool ->>>"+bool);
		SpringMemberVO mvo =null;
		mvo = new SpringMemberVO();
		
		// 회원번호
		mvo.setMnum(mnum);
		// 회원이름
		mvo.setMname(fu.getParameter("mname"));
		// 아이디
		mvo.setMid(fu.getParameter("mid"));
		// 패스워드
		mvo.setMpw(fu.getParameter("mpw"));
		
		// 성별
		mvo.setMgender(fu.getParameter("mgender"));
		
		// 생년월일
		String mbirth = fu.getParameter("mbirth");
		String mbirth1 = fu.getParameter("mbirth1");
		String mbirth2 = fu.getParameter("mbirth2");
		mbirth = mbirth + mbirth1 + mbirth2;
		mvo.setMbirth(mbirth);
		
		// 핸드폰
		String mhp = fu.getParameter("mhp");
		String mhp1 = fu.getParameter("mhp1");
		String mhp2 = fu.getParameter("mhp2");
		mhp = mhp + mhp1 + mhp2;
		mvo.setMhp(mhp);
		
		// 전화번호
		String mtel = fu.getParameter("mtel");
		String mtel1 = fu.getParameter("mtel1");
		String mtel2 = fu.getParameter("mtel2");
		mtel = mtel + mtel1 + mtel2;
		mvo.setMtel(mtel);
		
		// 이메일
		String memail = fu.getParameter("memail");
		String memail1 = fu.getParameter("memail1");						
		memail = memail.concat("@").concat(memail1);
		mvo.setMemail(memail);
		
		// 주소 : 우편번호
		mvo.setMzonecode(fu.getParameter("mzonecode"));
		
		// 주소 : 도로명 주소						
		String mroadaddress = fu.getParameter("mroadaddress");
		String mroadaddressdetail = fu.getParameter("mroadaddressdetail");						
		mroadaddress = mroadaddress.concat("@").concat(mroadaddressdetail);
		mvo.setMroadaddress(mroadaddress);
		
		// 주소 : 지번 주소 
		mvo.setMjibunaddress(fu.getParameter("mjibunaddress"));
		
		//취미
		String[] hobby = fu.getParameterValues("mhobby");
		String mhobby= "";
		for(int i=0; i < hobby.length; i++) {
			mhobby += hobby[i] + ",";
		}
		mvo.setMhobby(mhobby);
		
		// 소개
		mvo.setMinfo(fu.getParameter("minfo"));
		
		// 사진
		//사진 이름 가져오는 구조를 모르겠음
		ArrayList<String> aFileName = fu.getFileNames();
		String mphoto = aFileName.get(0);				
		mvo.setMphoto(mphoto);
		
		// 관리자
		mvo.setMadmin("00"); // 관리자
		
		int nCnt = springMemberService.memberInsert(mvo);
		
		if(nCnt>0) {return "mem/springMemInsert";}
		
		//폼으로 돌아가야하는거 아닌가?...
		return "mem/springMemForm";
	}	
	
		@RequestMapping(value="springMemSelectAll", method= {RequestMethod.GET})
		public String memSelectAll(SpringMemberVO mvo, Model model) {
			logger.info("컨트롤러 셀렉트 올 함수 진입");
			
			List listAll = springMemberService.memberSelectAll(mvo);
			logger.info("listAll.size()->>>>>"+listAll.size());
			
			model.addAttribute("listAll", listAll);
			
			if(listAll.size()>0) {return "mem/springMemSelectAll";}
			return  "mem/springMemForm";
			
		}
		@RequestMapping(value="memSelect", method=RequestMethod.GET)
		public String memSelect(SpringMemberVO mvo, Model model) {
			logger.info("컨트롤 수정, 삭제, 조회 진입 ");
			logger.info("컨트롤러 select mvo.getMnum() ->>>"+mvo.getMnum());
			
			List<SpringMemberVO> listS = springMemberService.memberSelect(mvo);
			if(listS.size()>0) {
				model.addAttribute("listS", listS);
				return "mem/springMemSelect";
			}
			
			return "mem/springMemForm";
		}
		
		@RequestMapping(value="memUpdate", method=RequestMethod.POST)
		public String boardUpdate(HttpServletRequest req, SpringMemberVO mvo, Model model) {
			logger.info("컨트롤러 업데이트 진입");
			
			// 이메일
			String memail = req.getParameter("memail");
			String memail1 = req.getParameter("memail1");						
			memail = memail.concat("@").concat(memail1);
			mvo.setMemail(memail);		
			// 주소 : 우편번호
			mvo.setMzonecode(req.getParameter("mzonecode"));		
			// 주소 : 도로명 주소						
			String mroadaddress = req.getParameter("mroadaddress");
			String mroadaddressdetail = req.getParameter("mroadaddressdetail");						
			mroadaddress = mroadaddress.concat("@").concat(mroadaddressdetail);
			mvo.setMroadaddress(mroadaddress);		
			// 주소 : 지번 주소 
			mvo.setMjibunaddress(req.getParameter("mjibunaddress"));
			
			logger.info("SpringMemberController boardUpdate bvo.getSbnum() >>> : " + mvo.getMnum());
		
			int nCnt = springMemberService.memberUpdate(mvo);
			model.addAttribute("nCnt", nCnt);
			logger.info("SpringMemberController boardUpdate nCnt >>> : " + nCnt);
			
			if (nCnt > 0) { return "mem/springMemUpdate";}
			return "mem/springMemForm";
		}
		
		@RequestMapping(value="memDelete", method=RequestMethod.POST)
		public String memDelete(SpringMemberVO mvo, Model model) {
			logger.info("컨트롤러 딜리트 함수 진입");
			logger.info("컨트롤러 삭제할 멤버번호 mvo.getMnum() ->>>"+mvo.getMnum());
			int nCnt = springMemberService.memberDelete(mvo);
			logger.info("SpringMemberController nCnt >>> : " + nCnt);
			model.addAttribute("nCnt", nCnt);
			if (nCnt > 0) { return "mem/springMemDelete";}
			return "mem/springMemSelectAll";
		}
	
		
	
	
	
	
	
	
	
	
	
	
}
