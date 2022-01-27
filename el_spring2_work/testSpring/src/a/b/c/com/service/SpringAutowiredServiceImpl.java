package a.b.c.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.dao.SpringAutowiredDAO;
import a.b.c.com.vo.FormDataVO;

@Service
@Transactional
public class SpringAutowiredServiceImpl implements SpringAutowiredService {

	final private SpringAutowiredDAO springAutowiredDAO;
	
	@Autowired(required=false)
	public SpringAutowiredServiceImpl(SpringAutowiredDAO springAutowiredDAO) {
		this.springAutowiredDAO=springAutowiredDAO;
	}
	
	
	@Override
	public List<FormDataVO> autowiredTest(FormDataVO fvo) {
	
		List<FormDataVO>list = springAutowiredDAO.autowiredTest(fvo);
		return list;
	}

}
