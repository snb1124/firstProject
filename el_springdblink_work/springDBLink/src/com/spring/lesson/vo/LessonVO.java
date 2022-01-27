package com.spring.lesson.vo;

public class LessonVO {

	private int no;
	private String lnum;
	private String lname;
	
	public LessonVO() {
		
	}
	
	public LessonVO(int no, String lnum, String lname) {
		
		this.no = no;
		this.lnum = lnum;
		this.lname = lname;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getLnum() {
		return lnum;
	}
	public void setLnum(String lnum) {
		this.lnum = lnum;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
}
