package com.catchdog.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.catchdog.common.ChabunUtil;
import com.catchdog.common.CommonUtils;
import com.catchdog.common.FileUploadUtil;
import com.catchdog.common.K_Session;
import com.catchdog.common.service.ChabunService;
import com.catchdog.member.service.MemberService;
import com.catchdog.member.vo.MemberVO;

@Controller
public class MemberController {

	Logger logger = Logger.getLogger(MemberController.class);
	
	private MemberService memberService;
	private ChabunService chabunService;
	
	@Autowired(required=false)
	public MemberController(MemberService memberService, ChabunService chabunService) {
		this.memberService = memberService;
		this.chabunService = chabunService;
	}
	
	@RequestMapping(value="memForm", method=RequestMethod.GET)
	public String memForm() {
		logger.info("Controller Form >>> : ");
		
		return "member/MemForm";
	}
	
	@RequestMapping(value="memInsert", method=RequestMethod.POST)
	public String memInsert(HttpServletRequest req, Model model) {
		logger.info("Controller Insert >>> : ");
		
		String mnum = ChabunUtil.getMemChabun("M", chabunService.getMemChabun().getMnum());
		logger.info("Controller mnum >>> : " + mnum);
		
		FileUploadUtil fu = new FileUploadUtil(CommonUtils.MEMBER_PATH, CommonUtils.MEMBER_SIZE, CommonUtils.MEMBER_ENCODE);
		boolean bool = fu.imgfileUpload(req);
		logger.info("Controller FileUpload result >>> : " + bool);
		
		MemberVO mvo = new MemberVO();
		
		mvo.setMnum(mnum);
		mvo.setMname(fu.getParameter("mname"));
		mvo.setMid(fu.getParameter("mid"));
		mvo.setMpw(fu.getParameter("mpw"));
		mvo.setMgender(fu.getParameter("mgender"));
		mvo.setMbirth(fu.getParameter("mbirth") + fu.getParameter("mbirth1") + fu.getParameter("mbirth2"));
		mvo.setMhp(fu.getParameter("mhp") + fu.getParameter("mhp1") + fu.getParameter("mhp2"));
		mvo.setMemail(fu.getParameter("memail") + "@" + fu.getParameter("memail1"));
		mvo.setMzonecode(fu.getParameter("mzonecode"));
		mvo.setMroadaddress(fu.getParameter("mroadaddress") + "@" + fu.getParameter("mroadaddressdetail"));
		mvo.setMjibunaddress(fu.getParameter("mjibunaddress"));
		mvo.setMadmin("00");
		
		int nCnt = memberService.memberInsert(mvo);
		model.addAttribute("mnum", mnum);
		
		if(nCnt>0) return "member/MemInsert";
		return "member/MemForm";
	}
	
	@RequestMapping(value="memSelectAll", method=RequestMethod.GET)
	public String memSelectAll(MemberVO mvo, Model model) {
		logger.info("Controller SelectAll >>> : ");
		
		List<MemberVO> listAll = memberService.memberSelectAll(mvo);
		logger.info("Controller listAll.size >>> : " + listAll.size());
		
		if(listAll.size() > 0) {
			model.addAttribute("listAll", listAll);
			return "member/MemSelectAll";
		}
		return "member/MemForm";
	}
	
	@RequestMapping(value="memSelect", method=RequestMethod.GET)
	public String memSelect(MemberVO mvo, Model model) {
		logger.info("Controller Select >>> : ");
		logger.info("Controller mnum >>> : " + mvo.getMnum());
		
		List<MemberVO> listS = memberService.memberSelect(mvo);
		logger.info("Controller listS.size >>> : " + listS.size());
		
		if(listS.size()==1) {
			model.addAttribute("listS", listS);
			return "member/MemSelect";
		}
		return "member/MemForm";
	}
	
	@RequestMapping(value="memUpdate", method=RequestMethod.POST)
	public String memUpdate(HttpServletRequest req, MemberVO mvo, Model model) {
		logger.info("Controller mnum >>> : " + mvo.getMnum());
		
		mvo.setMemail(req.getParameter("memail") + "@" + req.getParameter("memail1"));
		mvo.setMzonecode(req.getParameter("mzonecode"));
		mvo.setMroadaddress(req.getParameter("mroadaddress") + "@" + req.getParameter("mroadaddressdetail"));
		mvo.setMjibunaddress(req.getParameter("mjibunaddress"));
		
		logger.info("Controller mnum >>> : " + mvo.getMnum());
		
		int nCnt = memberService.memberUpdate(mvo);
		logger.info("Controller nCnt >>> : " + nCnt);
		
		if(nCnt > 0) {return "member/MemUpdate";}
		return "member/MemForm";
	}
	
	@RequestMapping(value="memDelete", method=RequestMethod.POST)
	public String memDelete(MemberVO mvo, Model model) {
		logger.info("Controller Delete >>> : ");
		logger.info("Controller mnum >>> : " + mvo.getMnum());
		
		int nCnt = memberService.memberDelete(mvo);
		logger.info("Controller nCnt >>> : " + nCnt);
		
		if(nCnt > 0) {return "member/MemDelete";}
		return "member/MemForm";
	}
	
	@RequestMapping(value="memIdCheck", method=RequestMethod.POST)
	@ResponseBody
	public Object memIdCheck(MemberVO mvo) {
		logger.info("Controller memIdCheck >>> : ");
		logger.info("Controller mid >>> : " + mvo.getMid());
		
		List<MemberVO> list = memberService.memberIdCheck(mvo);
		logger.info("Controller list.size >>> : " + list.size());
		
		String msg = "";
		if(list.size()==0) {msg="ID_YES";}
		else {msg="ID_NO";}
		
		return msg;
	}
	
	@PostMapping("socialLogin")
	public String socialLogin(HttpServletRequest req, Model model, MemberVO mvo) {
		
		
		String mbirth = req.getParameter("birthyear") + (req.getParameter("birthday")).replace("-", "");
		
		mvo.setMtoken(req.getParameter("token"));
		mvo.setMname(req.getParameter("name"));
		mvo.setMgender(req.getParameter("gender"));
		mvo.setMbirth(mbirth);
		mvo.setMhp(req.getParameter("mobile")); ;
		mvo.setMemail(req.getParameter("email")); ;
		mvo.setMsocial( req.getParameter("social"));
		
		List<MemberVO> listS = memberService.socialCheck(mvo);
		if (listS.size() > 0) {
			// 로그인 처리
			K_Session ks = K_Session.getInstance();
			if (!ks.setSession(req, listS.get(0))) {
				logger.info("SpingLoginController login >>> : 세션부여 하기  >>> : " + mvo.getMid());
				model.addAttribute("loginYN","Y");
			}
			return "login/LoginMessage";
		} else {
			// 회원 가입 처리
			String mnum = ChabunUtil.getMemChabun("M", chabunService.getMemChabun().getMnum());
			mvo.setMnum(mnum);
			int nCnt = memberService.memberInsert(mvo);
			
			if(nCnt > 0) {
				model.addAttribute("mnum", mnum);
				return "recommend/RecommendForm";
			} else {
				return "login/LoginForm";
			}
		}
		
	}
	
	@PostMapping("memberComplete")
	public String memberComplete(MemberVO mvo, Model model) {
		List<MemberVO> listS = memberService.memberSelect(mvo);
		
		if (listS.size() > 0) {
			model.addAttribute("listS", listS);
			return "member/MemberComplete";
		}else {
			return "member/MemForm";
		}
	}
}
