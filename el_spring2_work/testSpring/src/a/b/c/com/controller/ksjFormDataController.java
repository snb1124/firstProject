package a.b.c.com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import a.b.c.com.vo.FormDataVO;

@Controller
public class ksjFormDataController {
	
		@RequestMapping(value="formdata_find____11", method=RequestMethod.GET)
			public String formdata() {
			System.out.println("formdata�Լ� ���� ");
			
			return "mvc/formdata_return";
		}
		@RequestMapping(value="formdata_get_servlet", method=RequestMethod.GET)
		public String formdata_get(HttpServletRequest req, Model m) {
			
			//request.getparameter �̿� ������ �ѱ�� 
			String datanum = req.getParameter("datanum");
			String dataid = req.getParameter("dataid");
			String datapw = req.getParameter("datapw");
			String dataname = req.getParameter("dataname");
			
			
			System.out.println("FormDataController.formdata_get() :::: datanum >>> : " + datanum);
			System.out.println("FormDataController.formdata_get() :::: dataid >>> : " + dataid);
			System.out.println("FormDataController.formdata_get() :::: datapw >>> : " + datapw);
			System.out.println("FormDataController.formdata_get() :::: dataname >>> : " + dataname);
			
			//request.setatribute �̿� ������ �ѱ�� 
			req.setAttribute("request_datanum", datanum);
			req.setAttribute("request_dataid", dataid);
			req.setAttribute("request_datapw", datapw);
			req.setAttribute("request_dataname", dataname);
			
			//�� �̿��ؼ� ������ �ѱ��. 
			m.addAttribute("el_datanum", datanum);
			m.addAttribute("el_dataid", dataid);
			m.addAttribute("el_datapw", datapw);
			m.addAttribute("el_dataname", dataname);
			
			return "mvc/formdata_get_servlet";
		}
		
		@RequestMapping(value="formdata_get_spring", method=RequestMethod.GET)
		public String formdata_get_spring(HttpServletRequest req, FormDataVO fvo, Model m) {
			System.out.println("FormDataController formdata_get_spring�Լ� ����");
			System.out.println("fvo.getDataname->"+fvo.getDatanum());
			System.out.println("fvo.getDataname->"+fvo.getDataname());
			System.out.println("fvo.getDataid->"+fvo.getDataid());
			System.out.println("fvo.getDatapw->"+fvo.getDatapw());
			
			String datanum = fvo.getDatanum();
			String dataid = fvo.getDataid();
			String datapw = fvo.getDatapw();
			String dataname = fvo.getDataname();
			
			req.setAttribute("request_datanum", datanum);
			req.setAttribute("request_dataid", dataid);
			req.setAttribute("request_datapw", datapw);
			req.setAttribute("request_dataname", dataname);
			
			
			m.addAttribute("m_fvo",fvo);
			m.addAttribute("m_datanum",datanum);
			m.addAttribute("m_dataid",dataid);
			m.addAttribute("m_datapw",datapw);
			m.addAttribute("m_dataname",dataname);
			
			
			return "mvc/formdata_get_spring_return";
		}
		
		//�����ϱ�� @ModelAttribute ma_fdvo�� ��Ʈ����Ʈ value , �� fdvo�� �Ű���.. �ڼ����� �𸣰ڴ�. 
		@RequestMapping(value="formdata_post_spring", method=RequestMethod.POST)
		public String formdata_post_modelattribute(@ModelAttribute("ma_fdvo") FormDataVO fdvo) {
			/*
			 * �̰� �� ���ϴ� ����?
			name="datanum"  ---> private String datanum
			name="dataid"   ---> private String dataid
			name="datapw"   ---> private String datapw
			name="dataname" ---> private String datapw
			
			�� ��ü�� ����� �� name������ �������ϴ� ���� ������ �¾ƾ��Ѵ�. �ƴϸ� ������ ����. 
		*/
			return "mvc/formdata_post_spring_modelattribute_return";
		}
		
		@RequestMapping(value="formdata_post_valueobject", method=RequestMethod.POST)
		public String formdata_post_valueobject(FormDataVO fvo) {
			
			return "mvc/formdata_post_valueobject_return";
		}
		
		
		
		
}//controller
