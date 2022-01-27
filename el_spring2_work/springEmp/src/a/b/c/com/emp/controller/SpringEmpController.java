package a.b.c.com.emp.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import a.b.c.com.emp.service.SpringEmpService;
import a.b.c.com.emp.vo.SpringEmpVO;

@Controller
public class SpringEmpController {
	private Logger logger = Logger.getLogger(SpringEmpController.class);
	
	// ��Ʈ�ѷ����� ���� ���� 
	private SpringEmpService springEmpService;
		
	// �����ڿ� @Autowired ������̼�����  DI (������ �����ϱ�)
	@Autowired(required=false)
	public SpringEmpController(SpringEmpService springEmpService) {
		this.springEmpService = springEmpService;		
	}
	
	@RequestMapping(value="springEmpSelectAll", method=RequestMethod.GET)
	public String springEmpSelectAll(Model model) {
		logger.info("SpringEmpController springEmpSelectAll() �Լ� ���� >>> : ");

		List<SpringEmpVO> listAll = springEmpService.springEmpSelectAll();
		int nCnt = listAll.size();
		logger.info("SpringEmpController springEmpSelectAll nCnt >>> : " + nCnt);
		
		if (nCnt > 0) {
			model.addAttribute("listAll", listAll);		
			return "emp/springEmpSelectAll";	
		}
		
		return "emp/springEmpForm";		
	}

	
	@RequestMapping(value="springEmpSelectForm", method=RequestMethod.GET)
	public String springEmpSelectForm(@ModelAttribute SpringEmpVO evo, Model model) {
		logger.info("SpringEmpController springEmpSelectForm �Լ� ���� >>> : ");
			
		return "emp/springEmpSelectForm";		
	}
	
	@RequestMapping(value="springEmpSelect", method=RequestMethod.GET)
	public String springEmpSelect(@ModelAttribute SpringEmpVO evo, Model model) {
		logger.info("SpringEmpController springEmpSelect �Լ� ���� >>> : ");
		logger.info("SpringEmpController evo.getSearchFilter() >>> : " + evo.getSearchFilter());
		logger.info("SpringEmpController evo.getKeyword() >>> : " + evo.getKeyword());
		logger.info("SpringEmpController evo.getStartDate() >>> : " + evo.getStartDate());
		logger.info("SpringEmpController evo.getEndDate() >>> : " + evo.getEndDate());

		List<SpringEmpVO> searchList = springEmpService.springEmpSelect(evo);
		int nCnt = searchList.size();
		logger.info("SpringEmpController springEmpSelect nCnt >>> : " + nCnt);
		
		if (nCnt > 0) {
			model.addAttribute("searchList", searchList);		
			return "emp/springEmpSelect";	
		}
		
		return "emp/springEmpForm";		
	}
	@RequestMapping(value="springEmpInsertForm", method=RequestMethod.GET)
	public String springEmpInsert(Model model) {
		logger.info("SpringEmpController springEmpInsertForm�Լ� ����");
		
		return "emp/springEmpInsertForm";
	}
	@RequestMapping(value="springEmpInsert", method=RequestMethod.GET)
	public String springEmpInsert(Model model, SpringEmpVO evo) {
			logger.info("SpringEmpController springEmpInsert �Լ�����");
			logger.info("SpringEmpController evo.getEmpno->"+evo.getEmpno());
			logger.info("SpringEmpController evo.getEname->"+evo.getEname());
			logger.info("SpringEmpController evo.getHiredate->"+evo.getHiredate());
			
			int insertCnt = springEmpService.springEmpInsert(evo);
			if(insertCnt >0) {
				logger.info("SpringEmpController springEmpInsert nCnt >>> : " + insertCnt);
				
				model.addAttribute("insertCnt",insertCnt);
				
			return "emp/springEmpInsert";
			}
			return "emp/springEmpInsertForm";		
	}
	@RequestMapping(value="springEmpUpdateForm", method=RequestMethod.GET)
	public String spirngEmpUpdate(Model model) {
		logger.info("SpringEmpController.spirngEmpUpdate�Լ�");
		return "emp/springEmpUpdateForm";
		
	}
	
	@RequestMapping(value="springEmpUpdate", method=RequestMethod.GET)
	public String springEmpUpdate(@ModelAttribute SpringEmpVO evo, Model model) {
		logger.info("SpringEmpController springEmpUpdate �Լ� ���� >>> : ");
		logger.info("SpringEmpController evo.getEmpno() >>> : " + evo.getEmpno());
		logger.info("SpringEmpController evo.getEname() >>> : " + evo.getEname());
		logger.info("SpringEmpController evo.getHiredate() >>> : " + evo.getHiredate());
		
		int updateCnt = springEmpService.springEmpUpdate(evo);
		if (updateCnt > 0) {
			logger.info("SpringEmpController springEmpUpdate nCnt >>> : " + updateCnt);
			
			model.addAttribute("updateCnt", updateCnt);		
			return "emp/springEmpUpdate";	
		}
		
		return "emp/springEmpForm";		
	}
	
	
}
