package a.b.c.com.ksj.board.vo;

public class BoardVO {
	private String knum;
	private String ksubject;
	private String kwriter;
	private String kpw;
	private String kmemo;
	private String kphoto;
	private String deleteyn;
	private String insertdate;
	private String updatedate;
	
	public BoardVO(){
		
	}
	
	public BoardVO(String knum, String ksubject, String kwriter, String kpw, String kmemo, String kphoto,
			String deleteyn, String insertdate, String updatedate) {
		
		this.knum = knum;
		this.ksubject = ksubject;
		this.kwriter = kwriter;
		this.kpw = kpw;
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
	public String getKwriter() {
		return kwriter;
	}
	public void setKwriter(String kwriter) {
		this.kwriter = kwriter;
	}
	public String getKpw() {
		return kpw;
	}
	public void setKpw(String kpw) {
		this.kpw = kpw;
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
	
	// ÇÁ¸°Æ® 
	public static void printBoardVO (BoardVO kvo){
		System.out.print(kvo.getKnum() + " : ");
		System.out.print(kvo.getKsubject() + " : ");
		System.out.print(kvo.getKwriter() + " : ");
		System.out.print(kvo.getKpw() + " : ");
		System.out.print(kvo.getKmemo() + " : ");
		System.out.print(kvo.getDeleteyn() + " : ");
		System.out.print(kvo.getInsertdate() + " : ");
		System.out.println(kvo.getUpdatedate());
	}
	
	public static void printlnHbeBoardVO (BoardVO kvo){
		System.out.println("kvo.getKnum() 			>>> : " + kvo.getKnum());
		System.out.println("kvo.getKsubject() 		>>> : " + kvo.getKsubject());
		System.out.println("kvo.getKwriter() 		>>> : " + kvo.getKwriter());		
		System.out.println("kvo.getKpw() 			>>> : " + kvo.getKpw());
		System.out.println("kvo.getKmemo() 			>>> : " + kvo.getKmemo());
		System.out.println("kvo.getDeleteyn() 		>>> : " + kvo.getDeleteyn());
		System.out.println("kvo.getInsertdate() 	>>> : " + kvo.getInsertdate());
		System.out.println("kvo.getUpdatedadte() 	>>> : " + kvo.getUpdatedate());
	}
	

}
