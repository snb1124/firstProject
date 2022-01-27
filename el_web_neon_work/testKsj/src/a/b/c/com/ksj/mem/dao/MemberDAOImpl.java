package a.b.c.com.ksj.mem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import a.b.c.com.common.ConnProperty;
import a.b.c.com.ksj.mem.sql.MemberSqlMap;
import a.b.c.com.ksj.mem.vo.MemberVO;

public class MemberDAOImpl implements MemberDAO {
//��ü��ȸ 
	@Override
	public ArrayList<MemberVO> memberSelectAll() {
	
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList aList = null;
		
		try{
		
			conn=ConnProperty.getConnection();
			pstmt = conn.prepareStatement(MemberSqlMap.getMemberSelectAllQuery());
			System.out.println(MemberSqlMap.getMemberSelectAllQuery());
			rsRs= pstmt.executeQuery();
			if(rsRs!=null){
				aList = new ArrayList<MemberVO>();
				while(rsRs.next()){
					MemberVO mvo = new MemberVO();
					mvo.setKnum(rsRs.getString(1));
					mvo.setKname(rsRs.getString(2)); 
					mvo.setKid(rsRs.getString(3));
					mvo.setKpw(rsRs.getString(4));
					mvo.setKgender(rsRs.getString(5));
					mvo.setKbirth(rsRs.getString(6));
					mvo.setKhp(rsRs.getString(7));					
					mvo.setKtel(rsRs.getString(8));
					mvo.setKemail(rsRs.getString(9));					
					mvo.setKzonecode(rsRs.getString(10));
					mvo.setKroadaddress(rsRs.getString(11));
					mvo.setKgibunaddress(rsRs.getString(12));					
					mvo.setKhobby(rsRs.getString(13));
					mvo.setKinfo(rsRs.getString(14));
					mvo.setKphoto(rsRs.getString(15));					
					mvo.setKadmin(rsRs.getString(16));
					mvo.setDeleteyn(rsRs.getString(17));
					mvo.setInsertdate(rsRs.getString(18));
					mvo.setUpdatedate(rsRs.getString(19));
					
					aList.add(mvo);
					MemberVO.printlnMemberVO(mvo);
				}//if
			}// while
	
			ConnProperty.conClose(conn, pstmt, rsRs);
		}catch(Exception e){
			System.out.println("����Ʈ�� ��񿬵� ���� �߻� "+e.getMessage());
		}finally{
			ConnProperty.conClose(conn, pstmt, rsRs);
		}
		

		
		return aList;
	}// �� ��

	@Override
	public ArrayList<MemberVO> memberSelect(MemberVO mvo) {
			
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList aList = null;
		try{
	
			conn= ConnProperty.getConnection();
			pstmt = conn.prepareStatement(MemberSqlMap.getMemberSelectQuery());
			System.out.println(MemberSqlMap.getMemberSelectQuery());
			pstmt.clearParameters();
			pstmt.setString(1, mvo.getKnum());
			rsRs= pstmt.executeQuery();
			if(rsRs!=null){
			aList = new ArrayList<MemberVO>();
			
			while(rsRs.next()){
		    mvo = new MemberVO();
			mvo.setKnum(rsRs.getString(1));
			mvo.setKname(rsRs.getString(2)); 
			mvo.setKid(rsRs.getString(3));
			mvo.setKpw(rsRs.getString(4));
			mvo.setKgender(rsRs.getString(5));
			mvo.setKbirth(rsRs.getString(6));
			mvo.setKhp(rsRs.getString(7));					
			mvo.setKtel(rsRs.getString(8));
			mvo.setKemail(rsRs.getString(9));					
			mvo.setKzonecode(rsRs.getString(10));
			mvo.setKroadaddress(rsRs.getString(11));
			mvo.setKgibunaddress(rsRs.getString(12));					
			mvo.setKhobby(rsRs.getString(13));
			mvo.setKinfo(rsRs.getString(14));
			mvo.setKphoto(rsRs.getString(15));					
			mvo.setKadmin(rsRs.getString(16));
			mvo.setDeleteyn(rsRs.getString(17));
			mvo.setInsertdate(rsRs.getString(18));
			mvo.setUpdatedate(rsRs.getString(19));
			aList.add(mvo);
		}
			
		}
			ConnProperty.conClose(conn, pstmt, rsRs);
		
		}catch(Exception e){
			System.out.println("������ȸ ������ ���� ���� �߻�  "+e.getMessage());
		
		}finally{
			ConnProperty.conClose(conn, pstmt, rsRs);
		}
		
	
		return aList;
	}// ����Ʈ �� 

	@Override
	public boolean memberInsert(MemberVO mvo) {
			
	Connection conn= null;
	PreparedStatement pstmt = null;
	int nCnt = 0;
	boolean bool = false;
	try{
		conn = ConnProperty.getConnection();
		System.out.println("conn.getAutoCommit="+conn.getAutoCommit());
		pstmt=conn.prepareStatement(MemberSqlMap.getMemberInsertQuery());
		System.out.println("MemberSqlMap.getMemberInsertQuery()="+MemberSqlMap.getMemberInsertQuery());

		pstmt.clearParameters();
		pstmt.setString(1, mvo.getKnum());
		pstmt.setString(2, mvo.getKname());
		pstmt.setString(3, mvo.getKid());
		pstmt.setString(4, mvo.getKpw());
		pstmt.setString(5, mvo.getKgender());
		pstmt.setString(6, mvo.getKbirth());
		pstmt.setString(7, mvo.getKhp());
		pstmt.setString(8, mvo.getKtel());
		pstmt.setString(9, mvo.getKemail());
		pstmt.setString(10, mvo.getKzonecode());
		pstmt.setString(11, mvo.getKroadaddress());
		pstmt.setString(12, mvo.getKgibunaddress());
		pstmt.setString(13, mvo.getKhobby());
		pstmt.setString(14, mvo.getKinfo());
		pstmt.setString(15, mvo.getKphoto());
		pstmt.setString(16, mvo.getKadmin());
		//System.out.println("�ٿ��α�3");
		nCnt = pstmt.executeUpdate();
		if(!conn.getAutoCommit()) conn.commit();
	//	System.out.println("�ٿ��α�4");
		System.out.println("ncnt="+nCnt+"�� ��ϵ�");
	//	System.out.println("�ٿ��α�5");
		if(nCnt > 0){bool = true;}
		System.out.println("��� �ٿ� �μ�Ʈ �α� 2 ");
		ConnProperty.conClose(conn, pstmt);
		
		
	}catch(Exception e){
		System.out.println("insert ��� ���� ���� �߻� "+e.getMessage());
	}finally{
		ConnProperty.conClose(conn, pstmt);
	}System.out.println("��� �ٿ� �μ�Ʈ �α� 3 ");

		return bool;
	}// �μ�Ʈ ��

	@Override
	public boolean memberUpdate(MemberVO mvo) {
	 System.out.println("�ٿ� ������Ʈ ���� ");
	 Connection conn = null;
	 PreparedStatement pstmt = null;
	 int nCnt = 0;
	 boolean bool = false;
	 
	 try{
		 conn = ConnProperty.getConnection();
		 System.out.println("conn.getAutoCommit"+conn.getAutoCommit());
		 pstmt = conn.prepareStatement(MemberSqlMap.getMemberUpdateQuery());
		 System.out.println("������Ʈ "+MemberSqlMap.getMemberUpdateQuery());
			
		 
		 
		 	pstmt.clearParameters();			
			pstmt.setString(1, mvo.getKemail());
			pstmt.setString(2, mvo.getKzonecode());
			pstmt.setString(3, mvo.getKroadaddress());
			pstmt.setString(4, mvo.getKgibunaddress());
			pstmt.setString(5, mvo.getKhobby());			
			pstmt.setString(6, mvo.getKnum());
			
			nCnt = pstmt.executeUpdate();						
			if (!conn.getAutoCommit()) conn.commit();
			System.out.println("nCnt >>> : " + nCnt + " �� ���� �Ǿ��� ");
			if (nCnt > 0) { bool = true;}
			ConnProperty.conClose(conn, pstmt);
	 }catch(Exception e){
		 System.out.println("��� ���� ���� �߻� "+e.getMessage()); 
	 }finally{
		 ConnProperty.conClose(conn, pstmt);
	 }
	 
	 
		return bool;
	}

	@Override
	public boolean memberDelete(MemberVO mvo) {
		System.out.println("�ٿ� ����Ʈ ����");
		 Connection conn = null;
		 PreparedStatement pstmt = null;
		 int nCnt = 0;
		 boolean bool = false;
		 
		 try{
			 conn = ConnProperty.getConnection();
			 System.out.println("conn.getAutoCommit"+conn.getAutoCommit());
			 pstmt = conn.prepareStatement(MemberSqlMap.getMemberDeleteQuery());
			 System.out.println("����Ʈ "+MemberSqlMap.getMemberDeleteQuery());
			 pstmt.clearParameters();
			 pstmt.setString(1, mvo.getKnum());
			 nCnt = pstmt.executeUpdate();
			 if (!conn.getAutoCommit()) conn.commit();
				System.out.println("nCnt >>> : " + nCnt + " �� ���� �Ǿ��� ");
				if (nCnt > 0) { bool = true;}
				ConnProperty.conClose(conn, pstmt);
		 }catch(Exception e){
			 System.out.println("��� ���� ���� �߻� "+e.getMessage()); 
		 }finally{
			 ConnProperty.conClose(conn, pstmt);
		 }
		 
		return bool;
	}

}
