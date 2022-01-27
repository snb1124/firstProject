package a.b.c.com.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import a.b.c.com.ksj.board.sql.BoardSqlMap;

import a.b.c.com.ksj.book.sql.BookSqlMap;

public abstract class GetBoardMaxNum {

	// MaxNum 디비에서 가져오기 
	public static String getMaxNum(){
		
		// 지역변수 선언 하고 초기화 하기 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		String maxNum = "";
		
		try {
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(BoardSqlMap.getMaxChabunQuery());
			System.out.println("채번 쿼리 >>> \n" + BoardSqlMap.getMaxChabunQuery());
			rsRs = pstmt.executeQuery();
			
			if (rsRs !=null) {
				while (rsRs.next()) {
					maxNum = rsRs.getString("MAXNUM");									
				}
			}else {
				System.out.println("채번쿼리 실패 >>> : ");
			}
			
			// 디비에서 가져온  맥스값 :: 1
			System.out.println("maxNum >>> : " + maxNum);			
 			
			ConnProperty.conClose(conn, pstmt, rsRs);			
		}catch(Exception e) {
			System.out.println("GetBookMaxNum ymdNum 디비 에러 >>> : " + e.getMessage());
		}finally {
			ConnProperty.conClose(conn, pstmt, rsRs);
		}
		
		return maxNum;
	}
	
	public static String getMaxNum2(){
		
		// 지역변수 선언 하고 초기화 하기 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		String maxNum2 = "";
		
		try {
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(BoardSqlMap.getMaxChabunQuery());
			System.out.println("채번 쿼리 >>> \n" + BoardSqlMap.getMaxChabunQuery());
			rsRs = pstmt.executeQuery();
			
			if (rsRs !=null) {
				while (rsRs.next()) {
					maxNum2 = rsRs.getString("MAXNUM");									
				}
			}else {
				System.out.println("채번쿼리 실패 >>> : ");
			}
			
			// 디비에서 가져온  맥스값 :: 1
			System.out.println("maxNum2 >>> : " + maxNum2);			
 			
			ConnProperty.conClose(conn, pstmt, rsRs);			
		}catch(Exception e) {
			System.out.println("GetBookMaxNum ymdNum 디비 에러 >>> : " + e.getMessage());
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
