package com.catchdog.notice.vo;

public class NoticeVO {
	
	private String nnum; //게시판번호 --1
	private String nadmin; //관리자 --2
	private String ntitle; //제목  --3
	private String ncontent; //글내용 --4
	private String nimage; //사진 --5
	private String ndeleteyn; //삭제여부 --6
	private String ninsertdate; //신청일 --7
	private String nupdatedate; //삭제여부 --8
	
	//페이징
	private String pageSize;
	private String groupSize;
	private String curPage;
	private String totalCount;
	
	//생성자 
	public NoticeVO() {
		
	}
	
	public NoticeVO(String nnum, String nadmin, String ntitle, String ncontent, String nimage, String ndeleteyn,
			String ninsertdate, String nupdatedate) {
		
		this.nnum = nnum;
		this.nadmin = nadmin;
		this.ntitle = ntitle;
		this.ncontent = ncontent;
		this.nimage = nimage;
		this.ndeleteyn = ndeleteyn;
		this.ninsertdate = ninsertdate;
		this.nupdatedate = nupdatedate;
	}
	
	//페이징 생성자 
	public NoticeVO(String pageSize, String groupSize, String curPage, String totalCount) {
		super();
		this.pageSize = pageSize;
		this.groupSize = groupSize;
		this.curPage = curPage;
		this.totalCount = totalCount;
	}

	public String getNnum() {
		return nnum;
	}
	public void setNnum(String nnum) {
		this.nnum = nnum;
	}
	public String getNadmin() {
		return nadmin;
	}
	public void setNadmin(String nadmin) {
		this.nadmin = nadmin;
	}
	public String getNtitle() {
		return ntitle;
	}
	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}
	public String getNcontent() {
		return ncontent;
	}
	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}
	public String getNimage() {
		return nimage;
	}
	public void setNimage(String nimage) {
		this.nimage = nimage;
	}
	public String getNdeleteyn() {
		return ndeleteyn;
	}
	public void setNdeleteyn(String ndeleteyn) {
		this.ndeleteyn = ndeleteyn;
	}
	public String getNinsertdate() {
		return ninsertdate;
	}
	public void setNinsertdate(String ninsertdate) {
		this.ninsertdate = ninsertdate;
	}
	public String getNupdatedate() {
		return nupdatedate;
	}
	public void setNupdatedate(String nupdatedate) {
		this.nupdatedate = nupdatedate;
	}

	//페이징 getter,setter()
	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public String getGroupSize() {
		return groupSize;
	}

	public void setGroupSize(String groupSize) {
		this.groupSize = groupSize;
	}

	public String getCurPage() {
		return curPage;
	}

	public void setCurPage(String curPage) {
		this.curPage = curPage;
	}

	public String getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}
}
