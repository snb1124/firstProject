package com.catchdog.adoption.service;

import java.util.List;

import com.catchdog.adoption.vo.AdoptionVO;

public interface AdoptionService {
	List<AdoptionVO> adoptionSelectAll(AdoptionVO avo);
	List<AdoptionVO> adoptionSelect(AdoptionVO avo);
}
