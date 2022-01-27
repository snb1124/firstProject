package a.b.c.com.study.vo;

public class StudyVO {

	private String sid;
	private String spw;
	private String sname;
	
	public StudyVO(String sid, String spw, String sname) {
		
		this.sid = sid;
		this.spw = spw;
		this.sname = sname;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSpw() {
		return spw;
	}
	public void setSpw(String spw) {
		this.spw = spw;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	
	
	
}
