package com.catchdog.review.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.catchdog.review.service.ReviewService;
import com.catchdog.review.vo.ReviewVO;
import com.catchdog.common.ChabunUtil;
import com.catchdog.common.CommonUtils;
import com.catchdog.common.FileUploadUtil;
import com.catchdog.common.service.ChabunService;



@Controller
public class ReviewController {
	Logger logger = Logger.getLogger(ReviewController.class);
	
	private ReviewService reviewService;
	private ChabunService chabunService;
	
	//생성자 오토와이어드
	@Autowired(required=false)
	public ReviewController (ReviewService reviewService
							,ChabunService chabunService) {
		this.reviewService = reviewService;
		this.chabunService = chabunService;
		
	}
	
	//입양후기 글 입력 폼
	@GetMapping("/reviewForm")
	public String reviewForm(){
		logger.info("ReviewController reviewForm() 함수진입 >>> : ");
		return "review/reviewForm";
	}
	
	//입양후기글 입력
		@PostMapping("/reviewInsert") 
		public String reviewInsert(HttpServletRequest req) {
			logger.info("ReviewController reviewInsert() 함수 진입 >>> : ");
			
			//게시판 번호 채번구하기 
			System.out.println();
			String rbnum = ChabunUtil.getReviewChabun("R", chabunService.getReviewChabun().getRbnum());
			logger.info("ReviewController reviewInsert rbnum >>> : " + rbnum);
			
			//이미지 업로드 
			FileUploadUtil fu = new FileUploadUtil ( CommonUtils.ADOPTION_REVIEW_PATH
													,CommonUtils.ADOPTION_REVIEW_SIZE
													,CommonUtils.ADOPTION_REVIEW_ENCODE);
			boolean bool = fu.imgfileUpload(req);
//			boolean bool = fu.imgfileUploadSize(req);
			logger.info("BoardController boardInsert bool(이미지 업록드) >>> : "  + bool);
			
			//채번, 이미지 업로드 성공하면 VO 세팅하기 
			ReviewVO _rvo = null;
			_rvo = new ReviewVO();
		
			String rbsubject = fu.getParameter("rbsubject");
			String rbwriter = fu.getParameter("rbwriter");
			String rbinsertdate = fu.getParameter("rbinsertdate");
			String rbcontent = fu.getParameter("rbcontent");
			String rbimage = fu.getFileName("rbimage");
		
			_rvo.setRbnum(rbnum);
			_rvo.setRbsubject(rbsubject);
			_rvo.setRbwriter(rbwriter);
			_rvo.setRbinsertdate(rbinsertdate);
			_rvo.setRbcontent(rbcontent);
			_rvo.setRbimage(rbimage);
			
			logger.info("ReviewController reviewInsert _rvo.getRbnum() >>> : "  + _rvo.getRbnum());
			logger.info("ReviewController reviewInsert _rvo.getRbcontent() >>> : " + _rvo.getRbcontent());
			logger.info("ReviewController reviewInsert _rvo.getRbimage() >>> : " + _rvo.getRbimage());
			
			
			int nCnt = reviewService.reviewInsert(_rvo);
			
			logger.info("ReviewController reviewInsert nCnt >>> : " + nCnt);
			
			if(nCnt > 0) {return "review/reviewInsert";}
			return "review/reviewForm";
			}

	//입양후기 게시판 조회 폼 
	@GetMapping("/reviewSelectAll")
	public String reviewselectAll(ReviewVO rvo, Model model) {
	logger.info("ReviewController reviewSelectAll() 함수 진입 >>> : ");

	//페이징 변수 세팅
	int pageSize = CommonUtils.REVIEW_PAGE_SIZE;
	int groupSize = CommonUtils.REVIEW_GROUP_SIZE;
	int curPage = CommonUtils.REVIEW_CUR_PAGE;
	int totalCount = CommonUtils.REVIEW_TOTAL_COUNT;
	
	if (rvo.getCurPage() !=null) {
		curPage = Integer.parseInt(rvo.getCurPage());
		}
	
	rvo.setPageSize(String.valueOf(pageSize));
	rvo.setGroupSize(String.valueOf(groupSize));
	rvo.setCurPage(String.valueOf(curPage));
	rvo.setTotalCount(String.valueOf(totalCount));
	
	logger.info("ReviewControlloer reviewSelectPaging rvo.getPageSize() >>> : " + rvo.getPageSize());
	logger.info("ReviewControlloer reviewSelectPaging rvo.getGroupSize() >>> : " + rvo.getGroupSize());
	logger.info("ReviewControlloer reviewSelectPaging rvo.getCurPage() >>> : " + rvo.getCurPage());
	logger.info("ReviewControlloer reviewSelectPaging rvo.getTotalCount() >>> : " + rvo.getTotalCount());
	
	
	
	List<ReviewVO> listAll = reviewService.reviewSelectAll(rvo);
	logger.info("ReviewController reviewSelectAll listAll.size() >>> : " + listAll.size());
	
	if(listAll.size() > 0) {
		
		model.addAttribute("listAll" , listAll);
		model.addAttribute("pagingRVO", rvo);
		
		return "review/reviewSelectAll";
		}
	
	return "review/reviewSelectAll";
	}
	
	

	//게시글 수정/삭제 글 조회 
	@RequestMapping(value="reviewSelect", method=RequestMethod.POST)
	public String reviewSelect(ReviewVO rvo, Model model) {
		logger.info("ReviewController reviewSelect 함수 진입 >>> : ");
		logger.info("ReviewController reviewSelect rvo.getrbnum() >>> : "  + rvo.getRbnum());
		
		List<ReviewVO> listR = reviewService.reviewSelect(rvo);
		logger.info("ReviewController reviewSelect listR.size() >>> : " + listR.size());
		logger.info(">>>>>>>>"+rvo.getRbcontent());
		
		if(listR.size() == 1 ) {
			model.addAttribute("listR", listR);
			return "review/reviewSelect";
		}
		return "review/reviewSelectPaging";
		
	}
	

	//글 수정하기
	@RequestMapping(value="reviewUpdate", method=RequestMethod.POST)
	public String reviewUpdate(ReviewVO rvo, Model model) {
		logger.info("ReviewController boardUpdate 함수 진입 >>> : ");
		
		logger.info("ReviewController boardUpdate rvo.getRbnum() >>> : " + rvo.getRbnum());
		logger.info("ReviewController boardUpdate rvo.getRbcontent() >>> : " + rvo.getRbcontent());
		int nCnt = reviewService.reviewUpdate(rvo);
		logger.info("ReviewController boardUpdate nCnt >>> : " + nCnt);
		
		if (nCnt > 0) {return "review/reviewUpdate";}
		return "review/reviewSelectAll";
		
	}
	
	//글 삭제하기 
	@RequestMapping(value="reviewDelete", method=RequestMethod.POST)
	public String reviewDelete(ReviewVO rvo, Model model) {
		logger.info("ReviewController boardDelete 함수 진입 >>> : ");
		
		logger.info("ReviewController boardDelete rvo.getRbnum() >>> : " + rvo.getRbnum());
		int nCnt = reviewService.reviewDelete(rvo);
		logger.info("ReviewController boardDelete nCnt >>> : " + nCnt);
		
		if( nCnt > 0) {return "review/reviewDelete";}
		return "review/reviewSelectAll";
	}
	
/*
	
	//페이징 
		@RequestMapping(value="reviewSelectPaging",method= {RequestMethod.POST, RequestMethod.GET})
		public String ReviewSelectPaging(ReviewVO rvo , Model model) {
			logger.info("ReviewController.ReviewSelectPaging()>>>:");
			
			//페이징 변수 세팅
			int pageSize= CommonUtils.REVIEW_PAGE_SIZE;
			int groupSize=CommonUtils.REVIEW_GROUP_SIZE;
			int curPage = CommonUtils.REVIEW_CUR_PAGE;
			int totalCount=CommonUtils.REVIEW_TOTAL_COUNT;
			
			if(rvo.getCurPage() !=null) {
				curPage = Integer.parseInt(rvo.getCurPage());
			}
			rvo.setPageSize(String.valueOf(pageSize));
			rvo.setGroupSize(String.valueOf(groupSize));
			rvo.setCurPage(String.valueOf(curPage));
			rvo.setTotalCount(String.valueOf(totalCount));
			
			logger.info("ReviewController.ReviewSelectPaging.nvo.getPageSize()>>>:" + rvo.getPageSize());
			logger.info("ReviewController.ReviewSelectPaging.nvo.getGroupSize()>>>:" +rvo.getGroupSize());
			logger.info("ReviewController.ReviewSelectPaging.nvo.getCurPage()>>>:" + rvo.getCurPage());
			logger.info("ReviewController.ReviewSelectPaging.nvo.getTotalCount()>>>:" + rvo.getTotalCount());
			
			List<ReviewVO> listAll = reviewService.reviewSelectAll(rvo);
			logger.info("ReviewController.ReviewSelectPaging.listAll.size()>>>:" + listAll.size());
			
			if(listAll.size()>0) {
				model.addAttribute("pagingRVO",rvo);
				model.addAttribute("listAll", listAll);
				return "review/reviewSelectPaging";
			}
			return "review/ReviewForm";
		}
*/
	
}

