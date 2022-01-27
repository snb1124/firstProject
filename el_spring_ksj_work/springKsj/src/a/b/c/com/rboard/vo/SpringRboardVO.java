package a.b.c.com.rboard.vo;

public class SpringRboardVO {

	private String rsknum;
	private String knum;
	private String rskname;
	private String rskcontent;
	private String rskpw;
	private String rskdelyn;
	private String rskinsertdate;
	
	public SpringRboardVO() {
		
	}
	
	
	public SpringRboardVO(String rsknum, String knum, String rskname, String rskcontent, String rskpw, String rskdelyn,
			String rskinsertdate) {
		this.rsknum = rsknum;
		this.knum = knum;
		this.rskname = rskname;
		this.rskcontent = rskcontent;
		this.rskpw = rskpw;
		this.rskdelyn = rskdelyn;
		this.rskinsertdate = rskinsertdate;
	}


	public String getRsknum() {
		return rsknum;
	}


	public void setRsknum(String rsknum) {
		this.rsknum = rsknum;
	}


	public String getKnum() {
		return knum;
	}


	public void setKnum(String knum) {
		this.knum = knum;
	}


	public String getRskname() {
		return rskname;
	}


	public void setRskname(String rskname) {
		this.rskname = rskname;
	}


	public String getRskcontent() {
		return rskcontent;
	}


	public void setRskcontent(String rskcontent) {
		this.rskcontent = rskcontent;
	}


	public String getRskpw() {
		return rskpw;
	}


	public void setRskpw(String rskpw) {
		this.rskpw = rskpw;
	}


	public String getRskdelyn() {
		return rskdelyn;
	}


	public void setRskdelyn(String rskdelyn) {
		this.rskdelyn = rskdelyn;
	}


	public String getRskinsertdate() {
		return rskinsertdate;
	}


	public void setRskinsertdate(String rskinsertdate) {
		this.rskinsertdate = rskinsertdate;
	}
	
}
