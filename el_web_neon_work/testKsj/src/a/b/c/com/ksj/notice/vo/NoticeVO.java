package a.b.c.com.ksj.notice.vo;

public class NoticeVO {
	private String knum;
	private String ksubject;
	private String kmemo;
	private String kphoto;
	private String deleteyn;
	private String insertdate;
	private String updatedate;
	
	public NoticeVO(){}
	
	public NoticeVO(String knum, String ksubject, String kmemo, String kphoto, String deleteyn, String insertdate,
			String updatedate) {
		
		this.knum = knum;
		this.ksubject = ksubject;
		this.kmemo = kmemo;
		this.kphoto = kphoto;
		this.deleteyn = deleteyn;
		this.insertdate = insertdate;
		this.updatedate = updatedate;
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
	public String getKmemo() {
		return kmemo;
	}
	public void setKmemo(String kmemo) {
		this.kmemo = kmemo;
	}
	public String getKphoto() {
		return kphoto;
	}
	public void setKphoto(String kphoto) {
		this.kphoto = kphoto;
	}
	public String getDeleteyn() {
		return deleteyn;
	}
	public void setDeleteyn(String deleteyn) {
		this.deleteyn = deleteyn;
	}
	public String getInsertdate() {
		return insertdate;
	}
	public void setInsertdate(String insertdate) {
		this.insertdate = insertdate;
	}
	public String getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}

	public static void printNoticeVO(NoticeVO nvo) {
		
		System.out.print(nvo.getKnum() 			+ ", ");
		System.out.print(nvo.getKsubject() 		+ ", ");
		System.out.print(nvo.getKmemo()			+ ", ");
		System.out.print(nvo.getKphoto() 		+ ", ");					
		System.out.print(nvo.getDeleteyn() 		+ ", ");
		System.out.print(nvo.getInsertdate() 	+ ", ");
		System.out.println(nvo.getUpdatedate());
	}

	public static void printlnNoticeVO(NoticeVO nvo) {
		
		System.out.println(nvo.getKnum());
		System.out.println(nvo.getKsubject());
		System.out.println(nvo.getKmemo());
		System.out.println(nvo.getKphoto());					
		System.out.println(nvo.getDeleteyn());
		System.out.println(nvo.getInsertdate());
		System.out.println(nvo.getUpdatedate());
	}

}
