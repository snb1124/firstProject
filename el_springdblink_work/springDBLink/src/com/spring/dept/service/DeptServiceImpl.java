package com.spring.dept.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dept.dao.DeptMapper;
import com.spring.dept.vo.DeptVO;

@Service
@Transactional
public class DeptServiceImpl implements DeptService{
	private Logger logger = Logger.getLogger(DeptServiceImpl.class);
	
	@Autowired
	private DeptMapper deptMapper;
	
	@Override
	public List<DeptVO> listDepartment(DeptVO param) {
		logger.info("DeptServiceImpl listDepartment 진입 ");
		logger.info("DeptServiceImpl listDepartment param --> " + param);
		
		List<DeptVO> list = new ArrayList<DeptVO>();
		list = deptMapper.listDepartment(param);
		logger.info("DeptServiceImpl listDepartment list >>>> " + list);
		
		return list;
	}

	@Override
	public DeptVO selectDepartment(String deptid) {
		// TODO Auto-generated method stub
		logger.info("서비스 selectDepartment 함수 진입");
		return deptMapper.selectDepartment(deptid);
	}

	@Override
	public int insertDepartment(DeptVO param) {
		logger.info("서비스 insertDepartment 함수 진입");
		return deptMapper.insertDepartment(param);
	}

	@Override
	public int updateDepartment(DeptVO param) {
		logger.info("서비스 updateDepartment 함수 진입");
		return deptMapper.updateDepartment(param);
	}

	@Override
	public int deleteDepartment(DeptVO param) {
		logger.info("서비스 deleteDepartment 함수 진입");
		return deptMapper.deleteDepartment(param);
	}

}
