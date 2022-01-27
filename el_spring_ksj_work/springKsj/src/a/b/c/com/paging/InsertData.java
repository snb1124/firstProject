package a.b.c.com.paging;

import java.sql.Connection;
import java.sql.Statement;

public class InsertData {

   
   public void insertData() throws Exception{
      
      Connection con = ConnProperty.getConnection();
      Statement stmt = con.createStatement();
      String sqls = null;
      
      // for문 이용해서 200 건 데이터 넣기
      for(long i=0; i<200; i++) {
         sqls = "INSERT INTO SE_BOARD VALUES("
               + "B_SEQ.NEXTVAL, " 
               + "'" + i + "', " 
               + "'" + i + "', " 
               + "'" + i + "', " 
               + "'" + i + "', " 
               + "'" + i + "', " 
               + " 1, 1, 1, DEFAULT, 1)";
         
         int nCount = stmt.executeUpdate(sqls);
         if(nCount % 100 == 0) con.commit();
               
      }
      
      con.commit();
      stmt.close();stmt = null;
      con.close(); con= null;
      
   }
   public static void main(String[] args) throws Exception {
      // TODO Auto-generated method stub
      new InsertData().insertData();
   }

}