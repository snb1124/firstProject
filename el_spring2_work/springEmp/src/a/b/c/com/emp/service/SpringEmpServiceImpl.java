package a.b.c.com.emp.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.emp.dao.SpringEmpDAO;
import a.b.c.com.emp.vo.SpringEmpVO;

@Service
@Transactional
public class SpringEmpServiceImpl implements SpringEmpService {
	//�ش� Ŭ���� �ΰ� 
	private Logger logger = Logger.getLogger(SpringEmpServiceImpl.class);

	// ���񽺿��� DAO �����ϱ� 
	private SpringEmpDAO springEmpDAO;
	
	// �����ڿ� @Autowired ������̼�����  DI (������ �����ϱ�)
	@Autowired(required=false)
	public SpringEmpServiceImpl(SpringEmpDAO springEmpDAO){
		this.springEmpDAO = springEmpDAO;
	}
	@Override
	public List springEmpSelectAll() {
		// TODO Auto-generated method stub
		logger.info("SpringEmpServiceImpl springEmpSelectAll �Լ� ���� >>> : ");
		//�ٿ��� ����
		return springEmpDAO.springEmpSelectAll();
	}
	@Override
	public List springEmpSelect(SpringEmpVO evo) {
		// TODO Auto-generated method stub
		logger.info("SpringEmpServiceImpl springEmpSelect �Լ� ���� >>> : ");
		return springEmpDAO.springEmpSelect(evo);
	}
	@Override
	public int springEmpInsert(SpringEmpVO evo) {
		// TODO Auto-generated method stub
		logger.info("SpringEmpServiceImpl springEmpInsert �Լ� ���� >>> : ");
		return springEmpDAO.springEmpInsert(evo);
	}
	@Override
	public int springEmpUpdate(SpringEmpVO evo) {
		// TODO Auto-generated method stub
		logger.info("SpringEmpServiceImpl springEmpUpdate �Լ� ���� >>> : ");
		return springEmpDAO.springEmpUpdate(evo);
	}
}
