package a.b.c.com.ksj.book.sql;

public abstract class BookSqlMap {
	
	// MaxChabun 쿼리 
	public static String getMaxChabunQuery() {
		
		StringBuffer sb = new StringBuffer();			
		sb.append(" SELECT  /*+ INDEX_DESC(SYS_C0011177) */ 			\n");
		sb.append("         NVL(MAX(SUBSTR(A.KNUM, -4)), 0) + 1 MAXNUM	\n");
		sb.append(" FROM    TEST_BOOK A 								\n");	  

		return sb.toString();
	}

	public static String getBookSelectAllQuery(){ 
		
		/*StringBuffer sb = new StringBuffer();			
		sb.append( "SELECT * FROM TEST_BOOK");
		sb.append(" WHERE DELETEYN='Y' ORDER BY 1 DESC");*/
		
		StringBuffer sb = new StringBuffer();	
		sb.append(" SELECT 								\n");
		sb.append("      A.KNUM 		KNUM			\n");
		sb.append("		,A.KTITLE 		KTITLE			\n");
		sb.append("		,A.KAUTH 		KAUTH			\n");
	    sb.append("		,A.ISBN   		KISBN			\n");	    
	    sb.append("		,A.KCOMP 		KCOMP			\n");	    
	    sb.append("		,A.KPRICE		KPRICE			\n");	    
	    sb.append("		,A.KQTY 		KQTY			\n");
	    sb.append("		,A.KCOVER   	KCOVER			\n");	    
	    sb.append("		,A.DELETEYN		DELETEYN		\n");
	    sb.append("		,TO_CHAR(A.INSERTDATE, 'YYYY-MM-DD')  INSERTDATE	\n");
	    sb.append("		,TO_CHAR(A.UPDATEDATE, 'YYYY-MM-DD')  UPDATEDATE	\n");
	    sb.append("	FROM 								\n");
	    sb.append("		 TEST_BOOK A 					\n");
	    sb.append("	WHERE A.DELETEYN = 'Y'				\n");
	    sb.append("	ORDER BY 1 DESC  					\n");
	
	    return sb.toString();	  
	}
	
	public static String getBookSelectQuery(){ 
		
		StringBuffer sb = new StringBuffer();			
		sb.append(" SELECT 								\n");
		sb.append("      A.KNUM 		KNUM			\n");
		sb.append("		,A.KTITLE 		KTITLE			\n");
		sb.append("		,A.KAUTH 		KAUTH			\n");
	    sb.append("		,A.ISBN   		ISBN			\n");	    
	    sb.append("		,A.KCOMP 		KCOMP			\n");	    
	    sb.append("		,A.KPRICE		KPRICE			\n");	    
	    sb.append("		,A.KQTY 		KQTY			\n");
	    sb.append("		,A.KCOVER   	KCOVER			\n");	    
	    sb.append("		,A.DELETEYN		DELETEYN		\n");
	    sb.append("		,TO_CHAR(A.INSERTDATE, 'YYYY-MM-DD')  INSERTDATE	\n");
	    sb.append("		,TO_CHAR(A.UPDATEDATE, 'YYYY-MM-DD')  UPDATEDATE	\n");
	    sb.append("	FROM 								\n");
	    sb.append("		 TEST_BOOK A 					\n");
	    sb.append("	WHERE A.DELETEYN = 'Y'				\n");
	    sb.append("	AND   A.KNUM     = ? 				\n");

	    return sb.toString();	  

	}
	
	// 도서 정보 등록
	public static String getBookInsertQuery(){ 
	
		StringBuffer sb = new StringBuffer();			
		sb.append("	INSERT INTO 						\n");	
		sb.append("		TEST_BOOK 				    	\n");
		sb.append("		          (			    		\n");
		sb.append("      			 KNUM 				\n");
		sb.append("					,KTITLE 			\n");
		sb.append("					,KAUTH 				\n");
	    sb.append("					,ISBN   			\n");	    
	    sb.append("					,KCOMP 				\n");	    
	    sb.append("					,KPRICE				\n");	    
	    sb.append("					,KQTY 				\n");
	    sb.append("					,KCOVER   			\n");	    
	    sb.append("					,DELETEYN			\n");
	    sb.append("					,INSERTDATE			\n");
	    sb.append("					,UPDATEDATE			\n");
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
		sb.append("	              )						\n");		
		
		return sb.toString();
	}
	
	public static String getBookUpdateQuery(){ 
	
		StringBuffer sb = new StringBuffer();	
		sb.append("	UPDATE  							\n");	
		sb.append("		   	 TEST_BOOK 			    	\n");	
		sb.append("	SET  								\n");		
		sb.append("			 KPRICE 		= ?			\n");	    	    
		sb.append("			,KQTY			= ?			\n");	    
	    sb.append("		  	,UPDATEDATE 	= SYSDATE	\n");
		sb.append("	WHERE  	 KNUM 			= ?			\n");	    
		sb.append("	AND    	 DELETEYN 		= 'Y'  		\n");	
		
		return sb.toString();
		
	}
	
	
	public static String getBookDeleteQuery(){ 
	
		StringBuffer sb = new StringBuffer();			
		sb.append("	UPDATE  							\n");	
		sb.append("		   TEST_BOOK 			    	\n");	
		sb.append("	SET  								\n");
	    sb.append("		   DELETEYN 	= 'N'			\n");	    	   
	    sb.append("		  ,UPDATEDATE 	= SYSDATE		\n");
		sb.append("	WHERE  KNUM 		= ?				\n");	    
		sb.append("	AND    DELETEYN 	= 'Y'  			\n");	
		
		return sb.toString();
	}
}
