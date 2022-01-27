package a.b.c.com.ksj.board.service;

import java.util.ArrayList;

import a.b.c.com.ksj.board.dao.BoardDAO;
import a.b.c.com.ksj.board.dao.BoardDAOImpl;
import a.b.c.com.ksj.board.vo.BoardVO;

public class BoardServiceImpl implements BoardService {

	@Override
	public ArrayList<BoardVO> boardSelectAll() {
		System.out.println("BoardServiceImpl boardSelectAll() �Լ� ���� >>> : ");
		BoardDAO bdao = new BoardDAOImpl();
		return bdao.boardSelectAll();
	}

	@Override
	public ArrayList<BoardVO> boardSelect(BoardVO kvo) {
		// TODO Auto-generated method stub
		System.out.println("BoardServiceImpl boardSelect() �Լ� ���� >>> : ");
		
		BoardDAO bdao = new BoardDAOImpl();
		return bdao.boardSelect(kvo);
	}

	@Override
	public boolean boardInsert(BoardVO kvo) {
		// TODO Auto-generated method stub
		System.out.println("BoardServiceImpl boardInsert() �Լ� ���� >>> : ");
		
		BoardDAO bdao = new BoardDAOImpl();
		//boolean bool = bdao.boardInsert(kvo);
		return bdao.boardInsert(kvo);
	}

	@Override
	public boolean boardUpdate(BoardVO kvo) {
		// TODO Auto-generated method stub
		System.out.println("BoardServiceImpl boardUpdate() �Լ� ���� >>> : ");
		
		BoardDAO bdao = new BoardDAOImpl();
		return bdao.boardUpdate(kvo);
	}

	@Override
	public boolean boardDelete(BoardVO kvo) {
		// TODO Auto-generated method stub
		System.out.println("BoardServiceImpl boardDelete() �Լ� ���� >>> : ");
		
		BoardDAO bdao = new BoardDAOImpl();
		return bdao.boardDelete(kvo);
	}

}
