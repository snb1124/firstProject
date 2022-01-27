package com.spring.dept.dao;

import java.util.List;

//import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.spring.dept.service.DeptServiceImpl;
import com.spring.dept.vo.DeptVO;

public class DeptMapperImpl extends SqlSessionDaoSupport implements DeptMapper{
	private Logger logger = Logger.getLogger(DeptServiceImpl.class);
	
	private final String PACKAGE_PATH = "com.spring.dept.dao.DeptDAO.";

	@Override
	public List<DeptVO> listDepartment(DeptVO param) {
		// TODO Auto-generated method stub		
		logger.info("매퍼 listDepartment함수진입");
		return getSqlSession().selectList(PACKAGE_PATH+"listDepartment");
	}

	@Override
	public DeptVO selectDepartment(String deptid) {
		// TODO Auto-generated method stub
		logger.info("매퍼 select함수진입");
		return (DeptVO)getSqlSession().selectOne(PACKAGE_PATH+"selectDepartment");
	}

	@Override
	public int insertDepartment(DeptVO param) {
		logger.info("매퍼 insert함수진입");
		return (int)getSqlSession().insert(PACKAGE_PATH+"insertDepartment");
	}

	@Override
	public int updateDepartment(DeptVO param) {
		logger.info("매퍼 update함수진입");
		return (int)getSqlSession().update(PACKAGE_PATH+"updateDepartment");
	}

	@Override
	public int deleteDepartment(DeptVO param) {
		logger.info("매퍼 딜리트 함수진입");
		return (int)getSqlSession().delete(PACKAGE_PATH+"deleteDepartment");
	}


}
