package com.catchdog.login.vo;

public class TempAuthNumVO {

	private int anum;
	private String authnum;
	private String memail;
	private String insertdate;
	
	public TempAuthNumVO() {
	}
	
	public TempAuthNumVO(int anum, String authnum, String memail, String insertdate) {
		this.anum = anum;
		this.authnum = authnum;
		this.memail = memail;
		this.insertdate = insertdate;
	}

	public int getAnum() {
		return anum;
	}

	public String getAuthnum() {
		return authnum;
	}

	public String getMemail() {
		return memail;
	}

	public String getInsertdate() {
		return insertdate;
	}

	public void setAnum(int anum) {
		this.anum = anum;
	}

	public void setAuthnum(String authnum) {
		this.authnum = authnum;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	public void setInsertdate(String insertdate) {
		this.insertdate = insertdate;
	}
	
	
}
