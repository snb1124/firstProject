package a.b.c.com.ksj.mem.vo;

import a.b.c.com.ksj.board.vo.BoardVO;

public class MemberVO {

	private String knum;
	private String kname;
	private String kid;
	private String kpw;
	private String kgender;
	private String kbirth;
	private String khp;
	private String ktel;
	private String kemail;
	private String kzonecode;
	private String kroadaddress;
	private String kgibunaddress;
	private String khobby;				
	private String kinfo;
	private String kphoto;		
	private String kadmin;		
	private String deleteyn;
	private String insertdate;
	private String updatedate;
	
	public MemberVO(){
		
	}
	
	public MemberVO(String knum, String kname, String kid, String kpw, String kgender, String kbirth, String khp,
			String ktel, String kemail, String kzonecode, String kroadaddress, String kgibunaddress, String khobby,
			String kinfo, String kphoto, String kadmin, String deleteyn, String insertdate, String updatedate) {

		this.knum = knum;
		this.kname = kname;
		this.kid = kid;
		this.kpw = kpw;
		this.kgender = kgender;
		this.kbirth = kbirth;
		this.khp = khp;
		this.ktel = ktel;
		this.kemail = kemail;
		this.kzonecode = kzonecode;
		this.kroadaddress = kroadaddress;
		this.kgibunaddress = kgibunaddress;
		this.khobby = khobby;
		this.kinfo = kinfo;
		this.kphoto = kphoto;
		this.kadmin = kadmin;
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
	public String getKname() {
		return kname;
	}
	public void setKname(String kname) {
		this.kname = kname;
	}
	public String getKid() {
		return kid;
	}
	public void setKid(String kid) {
		this.kid = kid;
	}
	public String getKpw() {
		return kpw;
	}
	public void setKpw(String kpw) {
		this.kpw = kpw;
	}
	public String getKgender() {
		return kgender;
	}
	public void setKgender(String kgender) {
		this.kgender = kgender;
	}
	public String getKbirth() {
		return kbirth;
	}
	public void setKbirth(String kbirth) {
		this.kbirth = kbirth;
	}
	public String getKhp() {
		return khp;
	}
	public void setKhp(String khp) {
		this.khp = khp;
	}
	public String getKtel() {
		return ktel;
	}
	public void setKtel(String ktel) {
		this.ktel = ktel;
	}
	public String getKemail() {
		return kemail;
	}
	public void setKemail(String kemail) {
		this.kemail = kemail;
	}
	public String getKzonecode() {
		return kzonecode;
	}
	public void setKzonecode(String kzonecode) {
		this.kzonecode = kzonecode;
	}
	public String getKroadaddress() {
		return kroadaddress;
	}
	public void setKroadaddress(String kroadaddress) {
		this.kroadaddress = kroadaddress;
	}
	public String getKgibunaddress() {
		return kgibunaddress;
	}
	public void setKgibunaddress(String kgibunaddress) {
		this.kgibunaddress = kgibunaddress;
	}
	public String getKhobby() {
		return khobby;
	}
	public void setKhobby(String khobby) {
		this.khobby = khobby;
	}
	public String getKinfo() {
		return kinfo;
	}
	public void setKinfo(String kinfo) {
		this.kinfo = kinfo;
	}
	public String getKphoto() {
		return kphoto;
	}
	public void setKphoto(String kphoto) {
		this.kphoto = kphoto;
	}
	public String getKadmin() {
		return kadmin;
	}
	public void setKadmin(String kadmin) {
		this.kadmin = kadmin;
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

	
		public static void printMemberVO (MemberVO mvo){
			System.out.print(mvo.getKnum() + " : ");
			System.out.print(mvo.getKname() + " : ");
			System.out.print(mvo.getKid() + " : ");
			System.out.print(mvo.getKpw() + " : ");
			System.out.print(mvo.getKgender() + " : ");
			System.out.print(mvo.getKbirth() + " : ");
			System.out.print(mvo.getKhp() + " : ");
			System.out.print(mvo.getKtel() + " : ");
			System.out.print(mvo.getKemail() + " : ");
			System.out.print(mvo.getKzonecode() + " : ");
			System.out.print(mvo.getKroadaddress() + " : ");
			System.out.print(mvo.getKgibunaddress() + " : ");
			System.out.print(mvo.getKhobby() + " : ");
			System.out.print(mvo.getKinfo() + " : ");
			System.out.print(mvo.getKphoto() + " : ");
			System.out.print(mvo.getKadmin() + " : ");
			System.out.print(mvo.getDeleteyn() + " : ");
			System.out.print(mvo.getInsertdate() + " : ");
			System.out.println(mvo.getUpdatedate());
		}
		
		public static void printlnMemberVO (MemberVO mvo){
			System.out.println(mvo.getKnum() );
			System.out.println(mvo.getKname() );
			System.out.println(mvo.getKid() );
			System.out.println(mvo.getKpw() );
			System.out.println(mvo.getKgender());
			System.out.println(mvo.getKbirth() );
			System.out.println(mvo.getKhp() );
			System.out.println(mvo.getKtel());
			System.out.println(mvo.getKemail());
			System.out.println(mvo.getKzonecode());
			System.out.println(mvo.getKroadaddress());
			System.out.println(mvo.getKgibunaddress());
			System.out.println(mvo.getKhobby());
			System.out.println(mvo.getKinfo());
			System.out.println(mvo.getKphoto());
			System.out.println(mvo.getKadmin());
			System.out.println(mvo.getDeleteyn());
			System.out.println(mvo.getInsertdate());
			System.out.println(mvo.getUpdatedate());
		}

	
	
}//END OF CLASS
