package a.b.c.com.ksj.board.service;

import java.util.ArrayList;
import a.b.c.com.ksj.board.vo.BoardVO;

public interface BoardService {
	public ArrayList<BoardVO> boardSelectAll();
	public ArrayList<BoardVO> boardSelect(BoardVO kvo);
	public boolean boardInsert(BoardVO kvo);
	public boolean boardUpdate(BoardVO kvo);
	public boolean boardDelete(BoardVO kvo);
}
