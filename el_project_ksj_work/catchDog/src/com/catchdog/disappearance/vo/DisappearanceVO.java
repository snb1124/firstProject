package com.catchdog.disappearance.vo;

import org.apache.log4j.Logger;

public class DisappearanceVO {
	
	private static Logger logger = Logger.getLogger(DisappearanceVO.class);
	
	private String dinum; // 게시판번호(1)
	private String mnum; //회원번호(2)
	private String diname; // 실종동물 이름(3)
	private String diupkind; // 강아지, 고양이 구분 (4)
	private String dikind; // 강아지, 고양이 종 구분(5)
	private String didate; // 실종날짜(6)
	private String diimage;//실종동물 사진(7)
	private String dispecial; //실종동물 특징(8)
	private String diage; // 실종동물 나이(9)
	private String dihp; // 회원 연락처(10)
	private String diposition; //실종위치(11)
	private String diinsertdate; // 신청일(12)
	private String diupdatedate; // 수정일(13)
	private String dideleteyn; // 삭제여부(14)
	
	private String curPage; // 현재 페이지
	private String pageSize; // 페이지 사이즈(한화면에 보여주는 로우갯수)
	private String groupSize; // 그룹사이즈(페이지 이동시 누르는부분)
	private String totalCount; // 종 로우 갯수
		
	public DisappearanceVO() {
		
	}

	public DisappearanceVO(String dinum, String mnum, String diname, String diupkind, String dikind, String didate,
					       String diimage, String dispecial, String diage, String dihp, String diposition, String diinsertdate,
					       String diupdatedate, String dideleteyn, String curPage, String pageSize, String groupSize,
					       String totalCount) {

		this.dinum = dinum;
		this.mnum = mnum;
		this.diname = diname;
		this.diupkind = diupkind;
		this.dikind = dikind;
		this.didate = didate;
		this.diimage = diimage;
		this.dispecial = dispecial;
		this.diage = diage;
		this.dihp = dihp;
		this.diposition = diposition;
		this.diinsertdate = diinsertdate;
		this.diupdatedate = diupdatedate;
		this.dideleteyn = dideleteyn;
		this.curPage = curPage;
		this.pageSize = pageSize;
		this.groupSize = groupSize;
		this.totalCount = totalCount;
	}

	public String getDinum() {
		return dinum;
	}

	public void setDinum(String dinum) {
		this.dinum = dinum;
	}

	public String getMnum() {
		return mnum;
	}

	public void setMnum(String mnum) {
		this.mnum = mnum;
	}

	public String getDiname() {
		return diname;
	}

	public void setDiname(String diname) {
		this.diname = diname;
	}

	public String getDiupkind() {
		return diupkind;
	}

	public void setDiupkind(String diupkind) {
		this.diupkind = diupkind;
	}

	public String getDikind() {
		return dikind;
	}

	public void setDikind(String dikind) {
		this.dikind = dikind;
	}

	public String getDidate() {
		return didate;
	}

	public void setDidate(String didate) {
		this.didate = didate;
	}

	public String getDiimage() {
		return diimage;
	}

	public void setDiimage(String diimage) {
		this.diimage = diimage;
	}

	public String getDispecial() {
		return dispecial;
	}

	public void setDispecial(String dispecial) {
		this.dispecial = dispecial;
	}

	public String getDiage() {
		return diage;
	}

	public void setDiage(String diage) {
		this.diage = diage;
	}

	public String getDihp() {
		return dihp;
	}

	public void setDihp(String dihp) {
		this.dihp = dihp;
	}

	public String getDiposition() {
		return diposition;
	}

	public void setDiposition(String diposition) {
		this.diposition = diposition;
	}

	public String getDiinsertdate() {
		return diinsertdate;
	}

	public void setDiinsertdate(String diinsertdate) {
		this.diinsertdate = diinsertdate;
	}

	public String getDiupdatedate() {
		return diupdatedate;
	}

	public void setDiupdatedate(String diupdatedate) {
		this.diupdatedate = diupdatedate;
	}

	public String getDideleteyn() {
		return dideleteyn;
	}

	public void setDideleteyn(String dideleteyn) {
		this.dideleteyn = dideleteyn;
	}

	public String getCurPage() {
		return curPage;
	}

	public void setCurPage(String curPage) {
		this.curPage = curPage;
	}

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

	public String getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}
	
	public static void printVO (DisappearanceVO dsvo ) {
		logger.info("DisappearanceVO 데이터 확인 시작 >>> : ");
	    
		logger.info("게시판번호(1) >>> : " + dsvo.getDinum());
		logger.info("회원번호(2) >>> : " + dsvo.getMnum());
		logger.info("실종동물 이름(3)>>> : " + dsvo.getDiname());
		logger.info("강아지, 고양이 구분 (4) >>> : " + dsvo.getDiupkind());
		logger.info("강아지, 고양이 종 구분(5) >>> : " + dsvo.getDikind());
		logger.info("실종날짜(6) >>> : " + dsvo.getDidate());
		logger.info("실종동물 사진(7) >>> : " + dsvo.getDiimage());
		logger.info("실종동물 특징(8) >>> : " + dsvo.getDispecial());
		logger.info("실종동물 나이(9) >>> : " + dsvo.getDiage());
		logger.info("회원 연락처(10) >>> : " + dsvo.getDihp());
		logger.info("실종위치(11) >>> : " + dsvo.getDiposition());
		logger.info("신청일(12) >>> : " + dsvo.getDiinsertdate());
		logger.info("수정일(13) >>> : " + dsvo.getDiupdatedate());
		logger.info("삭제여부(14) >>> : " + dsvo.getDideleteyn());
		logger.info("페이징 데이터 확인 >>>");
		logger.info("페이지 >>> : " + dsvo.getPageSize());
		logger.info("그룹사이즈 >>> : " + dsvo.getGroupSize());
		logger.info("현재페이지 >>> : " + dsvo.getCurPage());
		logger.info("전체건수 >>> : " + dsvo.getTotalCount());
		
		
		logger.info("DisappearanceVO 데이터 확인 끝  >>> : ");
		
	}
	
	
	
}
