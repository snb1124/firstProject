package a.b.c.com.vo;

public class UserVO {
	private String mid;
	private String mpw;
		
	public UserVO() {
		
	}
	
	public UserVO(String mid, String mpw) {

		this.mid = mid;
		this.mpw = mpw;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpw() {
		return mpw;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	
	
}
