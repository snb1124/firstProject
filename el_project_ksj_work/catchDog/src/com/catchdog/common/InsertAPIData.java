package com.catchdog.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.catchdog.adoption.vo.*;

public class InsertAPIData {
	
	public void insertApiData(ArrayList<AdoptionVO> aList) throws Exception {
		Connection conn = ConnProperty.getConnection();
		StringBuffer sqls = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		
		sqls.append("INSERT INTO CATCHDOG_ADOPTIONBOARD		\n");
		sqls.append("VALUES		(	?,		\n");
		sqls.append("				?,		\n");
		sqls.append("				?,		\n");
		sqls.append("				?,		\n");
		sqls.append("				?,		\n");
		sqls.append("				?,		\n");
		sqls.append("				?,		\n");
		sqls.append("				?,		\n");
		sqls.append("				?,		\n");
		sqls.append("				?,		\n");
		sqls.append("				?,		\n");
		sqls.append("				?,		\n");
		sqls.append("				?,		\n");
		sqls.append("				?,		\n");
		sqls.append("				?,		\n");
		sqls.append("				?,		\n");
		sqls.append("				?,		\n");
		sqls.append("				?,		\n");
		sqls.append("				SYSDATE,	\n");
		sqls.append("				'Y'	)	\n");
		
		pstmt = conn.prepareStatement(sqls.toString());
		int nCnt = 0;
		
		for(int i=0; i<aList.size(); i++) {
			AdoptionVO avo = aList.get(i);
			pstmt.setString(1, avo.getMnum());
			pstmt.setString(2, avo.getAnum());
			pstmt.setString(3, avo.getAsubject());
			pstmt.setString(4, avo.getApw());
			pstmt.setString(5, avo.getAdno());
			pstmt.setString(6, avo.getAname());
			pstmt.setString(7, avo.getAupkind());
			pstmt.setString(8, avo.getAkind());
			pstmt.setString(9, avo.getAcolor());
			pstmt.setString(10, avo.getAsize());
			pstmt.setString(11, avo.getAneut());
			pstmt.setString(12, avo.getAage());
			pstmt.setString(13, avo.getAimage());
			pstmt.setString(14, avo.getAgender());
			pstmt.setString(15, avo.getAcaresite());
			pstmt.setString(16, avo.getAcaretel());
			pstmt.setString(17, avo.getAspecial());
			pstmt.setString(18, avo.getAinsertdate());
			
			nCnt += pstmt.executeUpdate();
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsertAPIData iad = new InsertAPIData();
		try {
			iad.insertApiData(ReceiveAPIData.getData());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
