package com.catchdog.disappearance.controller;

import java.util.ArrayList;
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

import com.catchdog.common.ChabunUtil;
import com.catchdog.common.CommonUtils;
import com.catchdog.common.FileUploadUtil;
import com.catchdog.common.service.ChabunService;
import com.catchdog.disappearance.service.DisappearanceService;
import com.catchdog.disappearance.vo.DisappearanceVO;

@Controller
public class DisappearanceController {
	Logger logger = Logger.getLogger(DisappearanceController.class);
	

	private DisappearanceService disappearanceService;
	private ChabunService chabunService;
	
	@Autowired(required=false)
	public DisappearanceController(DisappearanceService disappearanceService, ChabunService chabunService) {
		this.disappearanceService = disappearanceService;
		this.chabunService = chabunService;
	}
	

	//실종화면 Form 
	@GetMapping("disappearanceForm")
	public String disapperancForm() {
		logger.info("DisappearanceController.disapperancForm() 함수 진입 성공  >>>>>>>>>>>>>>> ");
		return "disappearance/disappearanceForm";
	} // 실종화면 Form 종료
	
	//실종 글 입력 
	@RequestMapping(value="disappearanceInsert", method=RequestMethod.POST)
	public String disappearanceInsert(HttpServletRequest req) {
		logger.info("DisappearanceController disappearanceInsert 함수 진입 >>> : ");
		
		//채번 구하기 
		String dinum = ChabunUtil.getDisapearanceChabun("D", chabunService.getDisappearanceChabun().getDinum());
		logger.info("DisappearanceController disappearanceInsert dinum >>> : " + dinum);
		
		//이미지 업로드 
		FileUploadUtil fu = new FileUploadUtil( CommonUtils.DISAPPEARANCE_PATH
												,CommonUtils.DISAPPEARANCE_SIZE
												,CommonUtils.DISAPPEARANCE_ENCODE);
		
		// 이미지 파일 원본 사이즈 
		// boolean bool = fu.imgfileUpload(req);
		// 이미지 파일 원본 사이즈 크기 조절 하기 
		boolean bool  = fu.imgfileUpload(req);
		logger.info("disappearanceInsert >>> : " + bool);
		
		DisappearanceVO _dsvo = null;
		_dsvo = new DisappearanceVO();
		
		_dsvo.setDinum(dinum); // 1
		_dsvo.setMnum("M2021110011"); // 일단 그냥 넣음
		_dsvo.setDiname(fu.getParameter("diname")); // 2
		_dsvo.setDiupkind(fu.getParameter("diupkind")); // 3
		_dsvo.setDikind(fu.getParameter("dikind")); // 4
		_dsvo.setDidate(fu.getParameter("didate")+fu.getParameter("didate1")+fu.getParameter("didate2")); // 5
		
		ArrayList<String> aFileName = fu.getFileNames();
		String aimage = aFileName.get(0);
		_dsvo.setDiimage(aimage);
		
		_dsvo.setDispecial(fu.getParameter("dispecial"));// 7
		_dsvo.setDiage(fu.getParameter("diage"));// 8 
		_dsvo.setDihp(fu.getParameter("dihp")+fu.getParameter("dihp1")+fu.getParameter("dihp2")); // 9
		_dsvo.setDiposition(fu.getParameter("diposition")); // 10
			
//		logger.info("_dsvo.getDinum() >>>>>> : " + _dsvo.getDinum());
//		logger.info("_dsvo.getMnum() >>>>>> :  " +   _dsvo.getMnum());
//		logger.info("_dsvo.getDiname() >>>>>> : " + _dsvo.getDiname());
//		logger.info("_dsvo.getDiupkind() >>>>>> : " + _dsvo.getDiupkind());
//		logger.info("_dsvo.getDikind() >>>>>> : " + _dsvo.getDikind());
//		logger.info("_dsvo.getDidate() >>>>>> : " + _dsvo.getDidate());
//		logger.info("_dsvo.getDiimage() >>>>>> : " + _dsvo.getDiimage());
//		logger.info("_dsvo.getDispecial() >>>>>> : " + _dsvo.getDispecial());
//		logger.info("_dsvo.getDiage() >>>>>> : " + _dsvo.getDiage());
//		logger.info("_dsvo.getDihp() >>>>>> : " + _dsvo.getDihp());
//		logger.info("_dsvo.getDiposition() >>>>>> : " + _dsvo.getDiposition());
		
		int nCnt = disappearanceService.disappearanceInsert(_dsvo);
		logger.info("nCnt >>>>>> : " + nCnt);
		if (nCnt > 0){return "disappearance/disappearanceInsertForm";}

		return"disappearance/disappearanceForm";
	}
	
	
	//실종전단 전체화면.
	@GetMapping("disappearanceselectAll")
	public String disappearanceselectAll(DisappearanceVO dsvo, Model model){
		logger.info("DisappearanceController.disappearanceselectAll() 함수 진입 성공");
		
		// 페이징화면에 필요한 지역변수 선언
		int pageSize = CommonUtils.DISAPPEARANCE_PAGE_SIZE;
		int curPage = CommonUtils.DISAPPEARANCE_CUR_PAGE;
		int groupSize = CommonUtils.DISAPPEARANCE_GROUP_SIZE;
		int totalCount =CommonUtils.DISAPPEARANCE_TOTAL_COUNT;
		
		// 깡통에 데이터가 들어있으면
		if(dsvo.getCurPage() != null) {
			curPage = Integer.parseInt(dsvo.getCurPage());
		}
		
		dsvo.setCurPage(String.valueOf(curPage));
		dsvo.setPageSize(String.valueOf(pageSize));
		dsvo.setGroupSize(String.valueOf(groupSize));
		dsvo.setTotalCount(String.valueOf(totalCount));
		
		
		//데이터가 담겨있는 aListAll
		List<DisappearanceVO> listAll = disappearanceService.disappearanceselectAll(dsvo);
		logger.info("disappearanceselectAll()함수 listAll.size() >>>>>> : " + listAll.size());
		
		//aListAll.size에 데이터가 있는지 확인
		if(listAll.size() > 0) {
			
			model.addAttribute("listAll", listAll); // 게시판 데이터가 담김
			model.addAttribute("Pasing", dsvo);
			
			return "disappearance/disappearanceSelectAllForm";
		}
		return "disappearance/disappearanceSelectAllForm";
	}

	
	//실종글 선택조회
	@PostMapping("/disappearanceSelect")
	public String disappearanceselect(DisappearanceVO dsvo,  Model model) {
		logger.info("DisappearanceController disappearanceSelect()>>> : ");
		logger.info("DisappearanceController disappearanceSelect() dsvo.getDinum() >>>> : " + dsvo.getDinum());
		 
		 List<DisappearanceVO> listSelect = disappearanceService.disappearanceselect(dsvo);
		 logger.info("DisappearanceController.disappearanceSelect listDs.size() >>> : " + listSelect.size());
		 
		 if(listSelect.size() ==1 ) {
			 
			 model.addAttribute("listSelect", listSelect);
			 return "disappearance/disappearanceSelect";
		 }
		 return "disappearance/DisappearanceForm";
	}
	
//	//글 수정 
//	@PostMapping("/disappearanceUpdate")
//	public String disappearanceInsert(DisappearanceVO dsvo, Model model) {
//		logger.info("DisappearanceController.DisappearanceUpdate() >>> ");
//		logger.info("DisappearanceController.DisappearanceUpdate.dsvo.getDinum() >>> : " + dsvo.getDinum());
//		
//		int nCnt = disappearanceService.disappearanceUpdate(dsvo);
//		logger.info("DisappearanceController.DisappearanceUpdate.nCnt" + nCnt);
//		if(nCnt > 0) {return "disappearance/DisappearanceUpdate";}
//		return "disappearance/DisappearanceForm";
//	}
//	
//	//글 삭제 
//	@PostMapping("/disappearanceDelete")
//	public String disappearanceDelete(DisappearanceVO dsvo , Model model) {
//		logger.info("DisappearanceController.disappearanceDelete() >>> : " );
//		logger.info("DisappearanceController.disappearanceUpdate.dsvo.getDinum() >>> :" + dsvo.getDinum());
//		int nCnt = disappearanceService.disappearanceDelete(dsvo);
//		logger.info("DisappearanceController.disappearanceDelete.nCnt" + nCnt);
//		
//		if(nCnt > 0) {return "disappearance/DisappearanceDelete";}
//		return "disappearance/DisappearanceForm";
//		
//	}


	
}












