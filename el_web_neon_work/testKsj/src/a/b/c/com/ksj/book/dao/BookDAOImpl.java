package a.b.c.com.ksj.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import a.b.c.com.common.ConnProperty;
import a.b.c.com.ksj.book.sql.BookSqlMap;
import a.b.c.com.ksj.book.vo.BookVO;

public class BookDAOImpl implements BookDAO {

	@Override
	public ArrayList<BookVO> bookSelectAll() {
		System.out.println("�ٿ����� ����");
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rsRs = null;
		ArrayList<BookVO> aList = null;
		try{
		 conn = ConnProperty.getConnection();
		 pstmt = conn.prepareStatement(BookSqlMap.getBookSelectAllQuery());
		 System.out.println("��ü��ȸ"+BookSqlMap.getBookSelectAllQuery());
		 rsRs = pstmt.executeQuery();
		 
		 if (rsRs!=null){
			 aList = new ArrayList<BookVO>();
			 while (rsRs.next()){
				 BookVO _bvo = new BookVO();
				 _bvo.setKnum(rsRs.getString(1));
				 _bvo.setKtitle(rsRs.getString(2));
				 _bvo.setKauth(rsRs.getString(3));
				 _bvo.setIsbn(rsRs.getString(4));
				 _bvo.setKcomp(rsRs.getString(5));
				 _bvo.setKprice(rsRs.getString(6));
				 _bvo.setKqty(rsRs.getString(7));
				 _bvo.setKcover(rsRs.getString(8));
				 _bvo.setDeleteyn(rsRs.getString(9));
				 _bvo.setInsertdate(rsRs.getString(10));
				 _bvo.setUpdatedate(rsRs.getString(11));
				 
				 aList.add(_bvo);
			 }
		 }
		 
		 
			ConnProperty.conClose(conn, pstmt, rsRs);
		}catch(Exception e){
			System.out.println("��񿬵� ���� �߻�->"+ e.getMessage());
			
			
		}finally{
			ConnProperty.conClose(conn, pstmt, rsRs);
		}
		
		return aList;
	}

	// ��ȸ�ϱ�
		@Override
		public ArrayList<BookVO> bookSelect(BookVO bvo) {
			// TODO Auto-generated method stub
			System.out.println("BookDAOImpl bookSelect() �Լ� ���� >>> : ");
			
			// ����� ��ü�� ���������� �����ϰ� �ʱ�ȭ �ϱ� 
			Connection 			conn = null;
			PreparedStatement 	pstmt = null;
			ResultSet 			rsRs = null;
			ArrayList<BookVO> 	aList = null;
			
			try {			

				conn = ConnProperty.getConnection();
				pstmt = conn.prepareStatement(BookSqlMap.getBookSelectQuery());
				System.out.println("��ü ��ȸ >>> : \n"+ BookSqlMap.getBookSelectQuery());
	  
				pstmt.setString(1, bvo.getKnum());
				rsRs = pstmt.executeQuery();					
				
				if (rsRs !=null) {
					aList = new ArrayList<BookVO>();
					
					while (rsRs.next()) {
						
						BookVO _bvo = new BookVO();
						
						_bvo.setKnum(rsRs.getString(1));
						_bvo.setKtitle(rsRs.getString(2));
						_bvo.setKauth(rsRs.getString(3));
						_bvo.setIsbn(rsRs.getString(4));						
						_bvo.setKcomp(rsRs.getString(5));	
						_bvo.setKprice(rsRs.getString(6));	
						_bvo.setKqty(rsRs.getString(7));
						_bvo.setKcover(rsRs.getString(8));
						_bvo.setDeleteyn(rsRs.getString(9));
						_bvo.setInsertdate(rsRs.getString(10));
						_bvo.setUpdatedate(rsRs.getString(11));

						aList.add(_bvo);
					}
				}	
				
				ConnProperty.conClose(conn, pstmt, rsRs);
			}catch(Exception e) {
				System.out.println("��񿬵��� ������ ������ϴ�. >>> : " + e);
			}finally {
				try {
					ConnProperty.conClose(conn, pstmt, rsRs);				
				}catch(Exception e2) {}
			}
					
			return aList;

		}

		// ����ϱ�
		@Override
		public int bookInsert(BookVO bvo) {
			// TODO Auto-generated method stub
			System.out.println("BookDAOImpl bookInsert() �Լ� ���� >>> : ");
			
			
			// ����� ��ü�� ���������� �����ϰ� �ʱ�ȭ �ϱ� 
			Connection conn = null;
			PreparedStatement pstmt = null;
			int nCnt = 0;
			
			try {			

				conn = ConnProperty.getConnection();
				System.out.println("conn.getAutoCommit() >>> : " + conn.getAutoCommit());
				
				pstmt = conn.prepareStatement(BookSqlMap.getBookInsertQuery());
				System.out.println("�Է��ϱ� >>> : \n"+ BookSqlMap.getBookInsertQuery());
	  			
				pstmt.clearParameters();
				pstmt.setString(1, bvo.getKnum());
				pstmt.setString(2, bvo.getKtitle());
				pstmt.setString(3, bvo.getKauth());
				pstmt.setString(4, bvo.getIsbn());
				pstmt.setString(5, bvo.getKcomp());
				pstmt.setString(6, bvo.getKprice());
				pstmt.setString(7, bvo.getKqty());
				pstmt.setString(8, bvo.getKcover());
				/*
				sb.append("      			 KNUM 				\n");// COLUMN 1
				sb.append("					,KTITLE 			\n");// COLUMN 2
				sb.append("					,KAUTH 				\n");// COLUMN 3
			    sb.append("					,ISBN   			\n");// COLUMN 4	    
			    sb.append("					,KCOMP 				\n");// COLUMN 5	    
			    sb.append("					,KPRICE				\n");// COLUMN 6    
			    sb.append("					,KQTY 				\n");// COLUMN 7
			    sb.append("					,KCOVER   			\n");// COLUMN 8	    
			    sb.append("					,DELETEYN			\n");// COLUMN 9
			    sb.append("					,INSERTDATE			\n");// COLUMN 10
			    sb.append("					,UPDATEDATE			\n");// COLUMN 11
				sb.append("			      )						\n");
				sb.append("	       VALUES (  					\n");		
				sb.append("     				 ? 				\n"); // placeholder 1
				sb.append("						,? 				\n"); // placeholder 2
			    sb.append("						,?   			\n"); // placeholder 3
			    sb.append("						,?   			\n"); // placeholder 4
			    sb.append("						,? 				\n"); // placeholder 5
			    sb.append("						,? 				\n"); // placeholder 6
			    sb.append("						,?				\n"); // placeholder 7
			    sb.append("						,?				\n"); // placeholder 8
			    sb.append("						,'Y'			\n"); // placeholder 9
			    sb.append("						,SYSDATE 		\n"); // placeholder 10
			    sb.append("						,SYSDATE 		\n"); // placeholder 11	
				*/
				nCnt = pstmt.executeUpdate();
				if (!conn.getAutoCommit()) conn.commit();			
				System.out.println("nCnt >>> : " + nCnt + " �� ��� �Ǿ��� ");
				
				ConnProperty.conClose(conn, pstmt);
			}catch(Exception e) {
				System.out.println("�Է� ��񿬵��� ������ ������ϴ�. >>> : " + e);
			}finally {
				try {
					ConnProperty.conClose(conn, pstmt);				
				}catch(Exception e2) {}
			}
			
			return nCnt;
		}

		// �����ϱ� 
		@Override
		public int bookUpdate(BookVO bvo) {
			// TODO Auto-generated method stub
			System.out.println("BookDAOImpl bookUpdate() �Լ� ���� >>> : ");
			
			// ����� ��ü�� ���������� �����ϰ� �ʱ�ȭ �ϱ� 
			Connection conn = null;
			PreparedStatement pstmt = null;
			int nCnt = 0;
			
			try {			

				conn = ConnProperty.getConnection();
				System.out.println("conn.getAutoCommit() >>> : " + conn.getAutoCommit());
				
				pstmt = conn.prepareStatement(BookSqlMap.getBookUpdateQuery());
				System.out.println("�����ϱ� >>> : \n"+ BookSqlMap.getBookUpdateQuery());
	  			
				pstmt.clearParameters();
				pstmt.setString(1, bvo.getKprice());
				pstmt.setString(2, bvo.getKqty());
				pstmt.setString(3, bvo.getKnum());			
				
				nCnt = pstmt.executeUpdate();			
				if (!conn.getAutoCommit()) conn.commit();			
				System.out.println("nCnt >>> : " + nCnt + " �� ���� �Ǿ��� ");
				
				ConnProperty.conClose(conn, pstmt);
			}catch(Exception e) {
				System.out.println("�Է� ��񿬵��� ������ ������ϴ�. >>> : " + e);
			}finally {
				try {
					ConnProperty.conClose(conn, pstmt);				
				}catch(Exception e2) {}
			}
			
			return nCnt;
		}

		// �����ϱ� 
		@Override
		public int bookDelete(BookVO bvo) {
			// TODO Auto-generated method stub
			System.out.println("BookDAOImpl bookDelete() �Լ� ���� >>> : ");
			
			// ����� ��ü�� ���������� �����ϰ� �ʱ�ȭ �ϱ� 
			Connection conn = null;
			PreparedStatement pstmt = null;
			int nCnt = 0;
			
			try {			

				conn = ConnProperty.getConnection();
				System.out.println("conn.getAutoCommit() >>> : " + conn.getAutoCommit());
				
				pstmt = conn.prepareStatement(BookSqlMap.getBookDeleteQuery());
				System.out.println("�����ϱ� >>> : \n"+ BookSqlMap.getBookDeleteQuery());
	  			
				pstmt.clearParameters();		
				pstmt.setString(1, bvo.getKnum());			
				
				nCnt = pstmt.executeUpdate();			
				if (!conn.getAutoCommit()) conn.commit();			
				System.out.println("nCnt >>> : " + nCnt + " �� ���� �Ǿ��� ");
				
				ConnProperty.conClose(conn, pstmt);
			}catch(Exception e) {
				System.out.println("�Է� ��񿬵��� ������ ������ϴ�. >>> : " + e);
			}finally {
				try {
					ConnProperty.conClose(conn, pstmt);				
				}catch(Exception e2) {}
			}
			
			return nCnt;
		}
	}
