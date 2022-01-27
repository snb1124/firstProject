package com.catchdog.adoption.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.catchdog.adoption.dao.AdoptionDAO;
import com.catchdog.adoption.vo.AdoptionVO;

@Service
@Transactional
public class AdoptionServiceImpl implements AdoptionService {

	private AdoptionDAO adoptionDAO;
	
	@Autowired(required=false)
	public AdoptionServiceImpl(AdoptionDAO adoptionDAO) {
		this.adoptionDAO = adoptionDAO;
	}
	
	@Override
	public List<AdoptionVO> adoptionSelectAll(AdoptionVO avo) {
		// TODO Auto-generated method stub
		return adoptionDAO.adoptionSelectAll(avo);
	}

	@Override
	public List<AdoptionVO> adoptionSelect(AdoptionVO avo) {
		// TODO Auto-generated method stub
		return adoptionDAO.adoptionSelect(avo);
	}

}
