package com.catchdog.disappearance.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.catchdog.disappearance.vo.DisappearanceVO;

public interface DisappearanceService {
	Logger logger = Logger.getLogger(DisappearanceService.class);
	
	public List<DisappearanceVO> disappearanceselectAll(DisappearanceVO dsvo);
	public List<DisappearanceVO> disappearanceselect(DisappearanceVO dsvo);
	public int disappearanceInsert(DisappearanceVO dsvo);
//	public int disappearanceUpdate(DisappearanceVO dsvo);
//	public int disappearanceDelete(DisappearanceVO dsvo);

}
