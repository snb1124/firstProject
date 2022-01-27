package a.b.c.com.board.vo;

import org.apache.log4j.Logger;

public class SpringBoardVO {

	private static Logger logger = Logger.getLogger(SpringBoardVO.class);
	
	private String knum;
	private String ksubject;
	private String kname;
	private String kcontent;
	private String kfile;
	private String kpw;
	private String kdelyn;
	private String kinsertdate;
	private String kupdatedate;
	
	private String keyfilter;
	private String keyword;
	private String startdate;
	private String enddate;
	
	private String pageSize;
	private String groupSize;
	private String curPage;
	private String totalCount;
	
	
	public SpringBoardVO() {}
	
	public SpringBoardVO(String knum, String ksubject, String kname, String kcontent, String kfile, String kpw,
			String kdelyn, String kinsertdate, String kupdatedate) {
		
		this.knum = knum;
		this.ksubject = ksubject;
		this.kname = kname;
		this.kcontent = kcontent;
		this.kfile = kfile;
		this.kpw = kpw;
		this.kdelyn = kdelyn;
		this.kinsertdate = kinsertdate;
		this.kupdatedate = kupdatedate;
	}

	public SpringBoardVO(String knum, String ksubject, String kname, String kcontent, String kfile, String kpw,
			String kdelyn, String kinsertdate, String kupdatedate, String keyfilter, String keyword, String startdate,
			String enddate) {
		super();
		this.knum = knum;
		this.ksubject = ksubject;
		this.kname = kname;
		this.kcontent = kcontent;
		this.kfile = kfile;
		this.kpw = kpw;
		this.kdelyn = kdelyn;
		this.kinsertdate = kinsertdate;
		this.kupdatedate = kupdatedate;
		this.keyfilter = keyfilter;
		this.keyword = keyword;
		this.startdate = startdate;
		this.enddate = enddate;
	}

	public SpringBoardVO(String knum, String ksubject, String kname, String kcontent, String kfile, String kpw,
			String kdelyn, String kinsertdate, String kupdatedate, String keyfilter, String keyword, String startdate,
			String enddate, String pageSize, String groupSize, String curPage, String totalCount) {
		
		this.knum = knum;
		this.ksubject = ksubject;
		this.kname = kname;
		this.kcontent = kcontent;
		this.kfile = kfile;
		this.kpw = kpw;
		this.kdelyn = kdelyn;
		this.kinsertdate = kinsertdate;
		this.kupdatedate = kupdatedate;
		this.keyfilter = keyfilter;
		this.keyword = keyword;
		this.startdate = startdate;
		this.enddate = enddate;
		this.pageSize = pageSize;
		this.groupSize = groupSize;
		this.curPage = curPage;
		this.totalCount = totalCount;
	}

	public String getKnum() {
		return knum;
	}

	public void setKnum(String knum) {
		this.knum = knum;
	}

	public String getKsubject() {
		return ksubject;
	}

	public void setKsubject(String ksubject) {
		this.ksubject = ksubject;
	}

	public String getKname() {
		return kname;
	}

	public void setKname(String kname) {
		this.kname = kname;
	}

	public String getKcontent() {
		return kcontent;
	}

	public void setKcontent(String kcontent) {
		this.kcontent = kcontent;
	}

	public String getKfile() {
		return kfile;
	}

	public void setKfile(String kfile) {
		this.kfile = kfile;
	}

	public String getKpw() {
		return kpw;
	}

	public void setKpw(String kpw) {
		this.kpw = kpw;
	}

	public String getKdelyn() {
		return kdelyn;
	}

	public void setKdelyn(String kdelyn) {
		this.kdelyn = kdelyn;
	}

	public String getKinsertdate() {
		return kinsertdate;
	}

	public void setKinsertdate(String kinsertdate) {
		this.kinsertdate = kinsertdate;
	}

	public String getKupdatedate() {
		return kupdatedate;
	}

	public void setKupdatedate(String kupdatedate) {
		this.kupdatedate = kupdatedate;
	}

	public String getKeyfilter() {
		return keyfilter;
	}

	public void setKeyfilter(String keyfilter) {
		this.keyfilter = keyfilter;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
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
	
	public static void printVO(SpringBoardVO bvo){
		logger.info("SpringBoardVO 데이터 확인 시작  >>> : ");
		
		logger.info("글번호 >>> : " + bvo.getKnum());
		logger.info("글제목 >>> : " + bvo.getKsubject());
		logger.info("작성자 >>> : " + bvo.getKname());
		logger.info("글내용 >>> : " + bvo.getKcontent());
		logger.info("첨부파일명 >>> : " + bvo.getKfile());
		logger.info("패스워드 >>> : " + bvo.getKpw());
		logger.info("삭제여부 >>> : " + bvo.getKdelyn());
		logger.info("입력일 >>> : " + bvo.getKinsertdate());
		logger.info("수정일 >>> : " + bvo.getKupdatedate());
		logger.info("페이징 데이터 확인 >>>");
		logger.info("페이지 >>> : " + bvo.getPageSize());
		logger.info("그룹사이즈 >>> : " + bvo.getGroupSize());
		logger.info("현재페이지 >>> : " + bvo.getCurPage());
		logger.info("전체건수 >>> : " + bvo.getTotalCount());
		logger.info("조건검색 데이터 확인 >>>");
		logger.info("검색 필터 >>> : " + bvo.getKeyfilter());
		logger.info("검색 키워드 >>> : " + bvo.getKeyword());
		logger.info("검색 시작일 >>> : " + bvo.getStartdate());
		logger.info("검색 종료일 : " + bvo.getEnddate());
		
		logger.info("SpringBoardVO 데이터 확인 끝  >>> : ");
	}
}
