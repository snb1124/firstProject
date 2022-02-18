package com.catchdog.mainpage.vo;

public class MainPageVO {
	String rnum;
	String image;
	String mnum;
	String anum;
	String dinum;
	String gnum;
	String specialvaluea;
	String specialvalueb;
	
	public MainPageVO() {}

	public MainPageVO(String rnum, String image, String mnum, String anum, String dinum, String gnum,
			String specialvaluea, String specialvalueb) {
		this.rnum = rnum;
		this.image = image;
		this.mnum = mnum;
		this.anum = anum;
		this.dinum = dinum;
		this.gnum = gnum;
		this.specialvaluea = specialvaluea;
		this.specialvalueb = specialvalueb;
	}

	public String getRnum() {
		return rnum;
	}

	public void setRnum(String rnum) {
		this.rnum = rnum;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getMnum() {
		return mnum;
	}

	public void setMnum(String mnum) {
		this.mnum = mnum;
	}

	public String getDinum() {
		return dinum;
	}

	public String getGnum() {
		return gnum;
	}

	public void setDinum(String dinum) {
		this.dinum = dinum;
	}

	public void setGnum(String gnum) {
		this.gnum = gnum;
	}

	public String getAnum() {
		return anum;
	}
	
	public void setAnum(String anum) {
		this.anum = anum;
	}

	public String getSpecialvaluea() {
		return specialvaluea;
	}

	public void setSpecialvaluea(String specialvaluea) {
		this.specialvaluea = specialvaluea;
	}

	public String getSpecialvalueb() {
		return specialvalueb;
	}

	public void setSpecialvalueb(String specialvalueb) {
		this.specialvalueb = specialvalueb;
	}
	
}
