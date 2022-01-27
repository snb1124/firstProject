package a.b.c.com.ksj.login.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import a.b.c.com.common.ConnProperty;
import a.b.c.com.ksj.login.Sql.LoginSqlMap;
import a.b.c.com.ksj.mem.vo.MemberVO;

public class LoginDAOImpl implements LoginDAO {

	@Override
	public int loginCheck(MemberVO mvo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		int nCnt = 0;
		
		try{
			conn=ConnProperty.getConnection();
			pstmt = conn.prepareStatement(LoginSqlMap.getLoginCheckCntQuery());
			System.out.println("로긴 체크 >>> : \n"+ LoginSqlMap.getLoginCheckCntQuery());
			pstmt.clearParameters();
			pstmt.setString(1, mvo.getKid());
			pstmt.setString(2, mvo.getKpw());
			rsRs= pstmt.executeQuery();
			if(rsRs!=null){
				while(rsRs.next()){
					nCnt = rsRs.getInt(1);
				}
				
			}//if rsRs!=null
			ConnProperty.conClose(conn, pstmt, rsRs);
		}catch(Exception e){
			System.out.println("디비 연결 문제 발생 ->"+e.getMessage());
			
		}finally {
			try {
				ConnProperty.conClose(conn, pstmt, rsRs);				
			}catch(Exception e2) {}
		}
				
		return nCnt;
	}
}
