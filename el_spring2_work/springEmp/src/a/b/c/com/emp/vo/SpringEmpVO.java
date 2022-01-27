package a.b.c.com.emp.vo;

public class SpringEmpVO {

	private String empno;
	private String ename;
	private String hiredate;
	
	private String keyword;
	private String searchFilter;
	private String startDate;
	private String endDate;
	
	
	public SpringEmpVO() {
		
	}
	

	public SpringEmpVO(String empno, String ename, String hiredate, String keyword, String searchFilter,
			String startDate, String endDate) {
		this.empno = empno;
		this.ename = ename;
		this.hiredate = hiredate;
		this.keyword = keyword;
		this.searchFilter = searchFilter;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public SpringEmpVO(String empno, String ename, String hiredate) {		
		this.empno = empno;
		this.ename = ename;
		this.hiredate = hiredate;
	}
	
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getSearchFilter() {
		return searchFilter;
	}

	public void setSearchFilter(String searchFilter) {
		this.searchFilter = searchFilter;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}
