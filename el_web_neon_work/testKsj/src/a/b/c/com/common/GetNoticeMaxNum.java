package a.b.c.com.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import a.b.c.com.ksj.board.sql.BoardSqlMap;
import a.b.c.com.ksj.book.sql.BookSqlMap;
import a.b.c.com.ksj.notice.sql.NoticeSqlMap;

public abstract class GetNoticeMaxNum {

	// MaxNum 디비에서 가져오기 
	public static String getMaxNum(){
		
		// 지역변수 선언 하고 초기화 하기 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		String maxNum = "";
		
		try {
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(NoticeSqlMap.getMaxChabunQuery());
			System.out.println("채번 쿼리 >>> \n" + NoticeSqlMap.getMaxChabunQuery());
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
			System.out.println("GetNoticeMaxNum ymdNum 디비 에러 >>> : " + e.getMessage());
		}finally {
			ConnProperty.conClose(conn, pstmt, rsRs);
		}
		
		return maxNum;
	}

		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(">>> : " + GetNoticeMaxNum.getMaxNum());
	}

}
