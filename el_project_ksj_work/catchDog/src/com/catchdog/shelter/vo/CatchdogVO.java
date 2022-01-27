package com.catchdog.shelter.vo;

public class CatchdogVO {
	private String csnum; // 쉘터 고유번호 
	private String csname; // 쉘터명
	private String csaddress; // 쉘터 주소
	private String cstel;  // 쉘터 번호
	private String cslat;  // 쉘터 위도
	private String cslng;  // 쉘터 경도
	private String cslatlng; //위도경도
	
	// 페이징에 필요한 변수
	private String curPage; //현재 페이지
	private String groupSize; // 그룹 사이즈

	private String pageSize; // 페이지 사이즈
	private String totalCount; // 전체 열 갯수
	
	
	public CatchdogVO() {}

	
	
	public CatchdogVO(String csnum, String csname, String csaddress, String cstel, String cslat, String cslng,
			String cslatlng, String curPage, String groupSize, String pageSize, String totalCount) {

		this.csnum = csnum;
		this.csname = csname;
		this.csaddress = csaddress;
		this.cstel = cstel;
		this.cslat = cslat;
		this.cslng = cslng;
		this.cslatlng = cslatlng;
		this.curPage = curPage;
		this.groupSize = groupSize;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
	}

	
	public String getCsnum() {
		return csnum;
	}





	public void setCsnum(String csnum) {
		this.csnum = csnum;
	}





	public String getCsname() {
		return csname;
	}





	public void setCsname(String csname) {
		this.csname = csname;
	}





	public String getCsaddress() {
		return csaddress;
	}





	public void setCsaddress(String csaddress) {
		this.csaddress = csaddress;
	}





	public String getCstel() {
		return cstel;
	}





	public void setCstel(String cstel) {
		this.cstel = cstel;
	}





	public String getCslat() {
		return cslat;
	}





	public void setCslat(String cslat) {
		this.cslat = cslat;
	}





	public String getCslng() {
		return cslng;
	}





	public void setCslng(String cslng) {
		this.cslng = cslng;
	}





	public String getCslatlng() {
		return cslatlng;
	}





	public void setCslatlng(String cslatlng) {
		this.cslatlng = cslatlng;
	}





	public String getCurPage() {
		return curPage;
	}





	public void setCurPage(String curPage) {
		this.curPage = curPage;
	}





	public String getGroupSize() {
		return groupSize;
	}





	public void setGroupSize(String groupSize) {
		this.groupSize = groupSize;
	}





	public String getPageSize() {
		return pageSize;
	}





	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}





	public String getTotalCount() {
		return totalCount;
	}





	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}
	
	
		
	
	

	
	
	
	
	

}
