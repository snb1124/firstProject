package a.b.c.com.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import a.b.c.com.ksj.board.sql.BoardSqlMap;

import a.b.c.com.ksj.book.sql.BookSqlMap;

public abstract class GetBoardMaxNum {

	// MaxNum ��񿡼� �������� 
	public static String getMaxNum(){
		
		// �������� ���� �ϰ� �ʱ�ȭ �ϱ� 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		String maxNum = "";
		
		try {
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(BoardSqlMap.getMaxChabunQuery());
			System.out.println("ä�� ���� >>> \n" + BoardSqlMap.getMaxChabunQuery());
			rsRs = pstmt.executeQuery();
			
			if (rsRs !=null) {
				while (rsRs.next()) {
					maxNum = rsRs.getString("MAXNUM");									
				}
			}else {
				System.out.println("ä������ ���� >>> : ");
			}
			
			// ��񿡼� ������  �ƽ��� :: 1
			System.out.println("maxNum >>> : " + maxNum);			
 			
			ConnProperty.conClose(conn, pstmt, rsRs);			
		}catch(Exception e) {
			System.out.println("GetBookMaxNum ymdNum ��� ���� >>> : " + e.getMessage());
		}finally {
			ConnProperty.conClose(conn, pstmt, rsRs);
		}
		
		return maxNum;
	}
	
	public static String getMaxNum2(){
		
		// �������� ���� �ϰ� �ʱ�ȭ �ϱ� 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		String maxNum2 = "";
		
		try {
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(BoardSqlMap.getMaxChabunQuery());
			System.out.println("ä�� ���� >>> \n" + BoardSqlMap.getMaxChabunQuery());
			rsRs = pstmt.executeQuery();
			
			if (rsRs !=null) {
				while (rsRs.next()) {
					maxNum2 = rsRs.getString("MAXNUM");									
				}
			}else {
				System.out.println("ä������ ���� >>> : ");
			}
			
			// ��񿡼� ������  �ƽ��� :: 1
			System.out.println("maxNum2 >>> : " + maxNum2);			
 			
			ConnProperty.conClose(conn, pstmt, rsRs);			
		}catch(Exception e) {
			System.out.println("GetBookMaxNum ymdNum ��� ���� >>> : " + e.getMessage());
		}finally {
			ConnProperty.conClose(conn, pstmt, rsRs);
		}
		
		return maxNum2;
	}

		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(">>> : " + GetBoardMaxNum.getMaxNum2());
	}

}
