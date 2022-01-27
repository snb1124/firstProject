package a.b.c.com.emp.dao;

import java.util.List;

import a.b.c.com.emp.vo.SpringEmpVO;

public interface SpringEmpDAO {

	public List springEmpSelectAll();
	public List springEmpSelect(SpringEmpVO evo);
	public int springEmpInsert(SpringEmpVO evo);
	public int springEmpUpdate(SpringEmpVO evo);
}
