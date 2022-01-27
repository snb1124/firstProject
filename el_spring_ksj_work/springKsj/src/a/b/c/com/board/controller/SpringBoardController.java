package a.b.c.com.board.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import a.b.c.com.board.service.SpringBoardService;
import a.b.c.com.board.vo.SpringBoardVO;
import a.b.c.com.common.ChabunUtil;
import a.b.c.com.common.CommonUtils;
import a.b.c.com.common.FileUploadUtil;
import a.b.c.com.common.service.ChabunService;

@Controller
public class SpringBoardController {
	Logger logger = Logger.getLogger(SpringBoardController.class);
	
	private SpringBoardService springBoardService;
	private ChabunService chabunService;
	
	@Autowired(required=false)
	public SpringBoardController(SpringBoardService springBoardService, ChabunService chabunService ) {
		this.springBoardService = springBoardService;
		this.chabunService = chabunService;
	}
	
	//입력 폼
	@RequestMapping(value="boardForm", method=RequestMethod.GET)
	public String boardForm() {		
		logger.info("컨트롤러 입력폼 진입");
		return "board/springBoardForm";
	}
	//인서트 
	@RequestMapping(value="boardInsert", method=RequestMethod.POST)
	public String boardInsert(HttpServletRequest req) {
		logger.info("컨트롤러 인서트 진입");
		
		String knum=ChabunUtil.getBoardChabun("N", chabunService.getBoardChabun().getKnum());
		logger.info("인서트 채번 knum ->>"+knum);
		
		FileUploadUtil fu = new FileUploadUtil(	CommonUtils.BOARD_IMG_UPLOAD_PATH
                ,CommonUtils.BOARD_IMG_FILE_SIZE
                ,CommonUtils.BOARD_EN_CODE);
		boolean bool = fu.imgfileUploadSize(req);
		logger.info("보드 인서트 bool ->>>"+bool);
		
		SpringBoardVO _bvo =null;
		_bvo = new SpringBoardVO();
		
		_bvo.setKnum(knum);
		_bvo.setKsubject(fu.getParameter("ksubject"));
		_bvo.setKname(fu.getParameter("kname"));
		_bvo.setKpw(fu.getParameter("kpw"));
		_bvo.setKcontent(fu.getParameter("kcontent"));
		_bvo.setKfile(fu.getParameter("kfile"));
		
		logger.info("SpringBoardController boardInsert _bvo.getKnum() >>> : " + _bvo.getKnum());
		logger.info("SpringBoardController boardInsert _bvo.getKcontent() >>> : " + _bvo.getKcontent());
		logger.info("SpringBoardController boardInsert _bvo.getKfile() >>> : " + _bvo.getKfile());
		
		int nCnt = springBoardService.boardInsert(_bvo);
		logger.info("SpringBoardController boardInsert nCnt >>> : " + nCnt);
		req.setAttribute("nCnt", nCnt);
		
		if (nCnt > 0) { return "board/springBoardInsert";}
		return "board/springBoardForm";
	}
	
	@RequestMapping(value="boardSelectPaging", method=RequestMethod.GET)
	public String boardSelectPaging(SpringBoardVO bvo, Model model) {
		logger.info("스프링보드 컨트롤러 페이징 진입");
		
		int pageSize = CommonUtils.BOARD_PAGE_SIZE;
		int groupSize = CommonUtils.BOARD_GROUP_SIZE;
		int curPage = CommonUtils.BOARD_CUR_PAGE;
		int totalCount = CommonUtils.BOARD_TOTAL_COUNT;
		
		if (bvo.getCurPage() !=null){
			logger.info("getCurPage ->> null");
			curPage = Integer.parseInt(bvo.getCurPage());
		}
			bvo.setPageSize(String.valueOf(pageSize));
			bvo.setGroupSize(String.valueOf(groupSize));
			bvo.setCurPage(String.valueOf(curPage));
			bvo.setTotalCount(String.valueOf(totalCount));
			
			logger.info("SpringBoardController boardSelectPaging bvo.getPageSize() >>> : " + bvo.getPageSize());
			logger.info("SpringBoardController boardSelectPaging bvo.getGroupSize() >>> : " + bvo.getGroupSize());
			logger.info("SpringBoardController boardSelectPaging bvo.getCurPage() >>> : " + bvo.getCurPage());
			logger.info("SpringBoardController boardSelectPaging bvo.getTotalCount() >>> : " + bvo.getTotalCount());
			
			SpringBoardVO.printVO(bvo);
			
			List<SpringBoardVO> listAll = springBoardService.boardSelectPaging(bvo);
			logger.info("SpringBoardController boardSelectPaging listAll.size() >>> : " + listAll.size());
			
			if(listAll.size()>0) {
				for (int i=0; i < listAll.size(); i++) {
				SpringBoardVO sbvo = (SpringBoardVO)listAll.get(i);
					logger.info("listAll ::: bvo.getPageSize() >>> : " + sbvo.getPageSize());
					logger.info("listAll ::: bvo.getGroupSize() >>> : " + sbvo.getGroupSize());
					logger.info("listAll ::: bvo.getCurPage() >>> : " + sbvo.getCurPage());
					logger.info("listAll ::: bvo.getTotalCount() >>> : " + sbvo.getTotalCount());
			}
				
				model.addAttribute("pagingBVO", bvo);
				model.addAttribute("listAll", listAll);
				return "board/springBoardSelectPaging";
			}
			return "board/springBoardForm";
	}//paging ()
	
	
	
	
	//전체조회 
	@RequestMapping(value="boardSelectAll", method=RequestMethod.GET)
	public String boardSelectAll (SpringBoardVO bvo, Model model) {
		logger.info("컨트롤 boardSelectAll 함수 진입");
		logger.info("컨트롤러 전체조회 bvo.getKeyfilter()"+bvo.getKeyfilter());
		logger.info("컨트롤러 전체조회 bvo.getKeyword()"+bvo.getKeyword());
		logger.info("컨트롤러 전체조회 bvo.getStartdate()"+bvo.getStartdate());
		logger.info("컨트롤러 전체조회 bvo.getKeyEnddate()"+bvo.getEnddate());
		
		List<SpringBoardVO> listAll = springBoardService.boardSelectAll(bvo);
		
		logger.info("컨트롤러 셀렉트올 함수 listAll.size ->>>"+listAll.size());
		
		if(listAll.size()>0) {
			model.addAttribute("listAll", listAll);
			return "board/springboardSelectAll";
		}
		logger.info("컨트롤러 listAll.size() 널값");
		return "board/springboardSelectForm";
		
	}
	@RequestMapping(value="boardSelect", method=RequestMethod.POST)
	public String boardSelect(SpringBoardVO bvo, Model model) {
		logger.info("컨트롤 셀렉트 함수 진입");
		logger.info("선택한 글의 번호는 ->>>"+bvo.getKnum());
		
		List<SpringBoardVO>listS = springBoardService.boardSelect(bvo);
		logger.info("listS.size() ->>"+listS.size());
		
		if(listS.size()==1){
			model.addAttribute("listS", listS);
			return "board/springBoardSelect";
		}
			//강사님이은 form으로 보냄
		 	return "board/springboardSelectAll";
	}
	//업데이트
	@RequestMapping(value="boardUpdate", method=RequestMethod.POST)
	public String boardUpdate(SpringBoardVO bvo, Model model) {
		logger.info("컨트롤러 업데이트 진입");
		
		logger.info("선택한 글 번호"+bvo.getKnum());
		logger.info("선택한 글 내용"+bvo.getKcontent());
		int nCnt = springBoardService.boardUpdate(bvo);
		if(nCnt>0) {
			model.addAttribute("nCnt", nCnt);
			return "board/springBoardUpdate";}
		logger.info("업데이트 실패 ");
		//강사님은 폼으로 보냄 
		return "board/springboardSelectAll";
	}
	
	@RequestMapping(value="boardDelete", method=RequestMethod.POST)
	public String boardDelete(SpringBoardVO bvo, Model model) {
		logger.info("컨트롤러 삭제 진입");
		
		logger.info("선택한 글 번호"+bvo.getKnum());
		int nCnt = springBoardService.boardDelete(bvo);
		if(nCnt>0) {
			model.addAttribute("nCnt", nCnt);
			return "board/springBoardDelete";}
		logger.info("삭제 실패 ");
		//강사님은 폼으로 보냄 
		return "board/springboardSelectAll";
	}
	
	@RequestMapping(value="boardPwCheck", method=RequestMethod.POST)
	@ResponseBody
	public Object boardPwCheck(SpringBoardVO bvo) {
		logger.info("컨트롤 패스워드 체크 진입");
		logger.info("선택한 글 번호"+bvo.getKnum());
		logger.info("선택한 글 비밀번호"+bvo.getKpw());
		
		List<SpringBoardVO>list = springBoardService.boardPwCheck(bvo);
		
		String msg = "";
		if(list.size()==1) {msg="PW_GOOD";}
		else {msg ="PW_BAD";}
		
		
		return msg;
	}
	
	
}
