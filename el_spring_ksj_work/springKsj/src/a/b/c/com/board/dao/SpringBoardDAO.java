package a.b.c.com.board.dao;

import java.util.List;

import a.b.c.com.board.vo.SpringBoardVO;

public interface SpringBoardDAO {

	public List<SpringBoardVO> boardSelect(SpringBoardVO bvo);
	public List<SpringBoardVO> boardSelectAll(SpringBoardVO bvo);
	public int boardInsert(SpringBoardVO bvo);
	public int boardUpdate(SpringBoardVO bvo);
	public int boardDelete(SpringBoardVO bvo);
	public List<SpringBoardVO> boardPwCheck(SpringBoardVO bvo);
	public List<SpringBoardVO> boardSelectPaging(SpringBoardVO bvo);
}
