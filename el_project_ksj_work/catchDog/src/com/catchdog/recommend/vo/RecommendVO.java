package com.catchdog.recommend.vo;

public class RecommendVO {

	private String mnum;
	private String aupkind;
	private String akind;
	private String asize;
	private String acaresite;
	private String agender;
	private String afur;
	private String deleteyn;
	
	public RecommendVO() {
		
	}

	public RecommendVO(String mnum, String aupkind, String akind, String asize, String acaresite, String agender, String afur, String deleteyn) {
		this.mnum = mnum;
		this.aupkind = aupkind;
		this.akind = akind;
		this.asize = asize;
		this.acaresite = acaresite;
		this.agender = agender;
		this.afur = afur;
		this.deleteyn = deleteyn;
	}

	public String getMnum() {
		return mnum;
	}
	
	public String getAupkind() {
		return aupkind;
	}

	public String getAkind() {
		return akind;
	}
	
	public String getAsize() {
		return asize;
	}

	public String getAcaresite() {
		return acaresite;
	}

	public String getAgender() {
		return agender;
	}
	
	public String getAfur() {
		return afur;
	}
	
	public String getDeleteyn() {
		return deleteyn;
	}

	public void setMnum(String mnum) {
		this.mnum = mnum;
	}
	
	public void setAupkind(String aupkind) {
		this.aupkind = aupkind;
	}
	
	public void setAkind(String akind) {
		this.akind = akind;
	}

	public void setAsize(String asize) {
		this.asize = asize;
	}

	public void setAcaresite(String acaresite) {
		this.acaresite = acaresite;
	}

	public void setAgender(String agender) {
		this.agender = agender;
	}

	public void setAfur(String afur) {
		this.afur = afur;
	}
	
	public void setDeleteyn(String deleteyn) {
		this.deleteyn = deleteyn; 
	}
	
}
