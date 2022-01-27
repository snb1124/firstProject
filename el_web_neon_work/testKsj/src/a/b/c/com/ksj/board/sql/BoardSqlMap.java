package a.b.c.com.ksj.board.sql;

public abstract class BoardSqlMap {
	
	public static String getMaxChabunQuery(){
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT /*+ INDEX_DESC(A SYS_C0011181)*/");
		sb.append("NVL(MAX(SUBSTR(A.KNUM, -4)),0)+1 MAXNUM");
		sb.append(" FROM    MVC_BOARD A 								\n");

		return sb.toString();
	}
	
	public static String getBoardSelectAllQuery(){ 
		StringBuffer sb = new StringBuffer();			
		sb.append(" SELECT 								\n");
		sb.append("      A.KNUM 		KNUM 			\n");
		sb.append("		,A.KSUBJECT  	KSUBJECT 		\n");
		sb.append("		,A.KWRITER  	BWRITER 		\n");
	    sb.append("		,A.KPW  		KPW   			\n");	    	    	    
	    sb.append("		,A.KMEMO  		KMEMO			\n");
	    sb.append("		,A.KPHOTO  		KPHOTO			\n");	 
	    sb.append("		,A.DELETEYN  	DELETEYN		\n");	
	    sb.append("		,TO_CHAR(A.INSERTDATE, 'YYYY-MM-DD')  INSERTDATE	\n");
	    sb.append("		,TO_CHAR(A.UPDATEDATE, 'YYYY-MM-DD')  UPDATEDATE	\n");	   
	    sb.append("	FROM 								\n");
	    sb.append("		 MVC_BOARD A 					\n");
	    sb.append("	WHERE A.DELETEYN = 'Y'				\n");
	    sb.append("	ORDER BY 1 DESC  					\n");
	    
	/*	sb.append("SELECT * FROM  			MVC_BOARD	\n");
		sb.append("WHERE DELETEYN='Y'                     ");
		sb.append("ORDER BY 1 DESC                       ");*/
		
		return sb.toString();
	}
	
	public static String getBoardSelectQuery(){ 
		StringBuffer sb = new StringBuffer();			
		sb.append(" SELECT 								\n");
		sb.append("      A.KNUM 		KNUM 			\n");
		sb.append("		,A.KSUBJECT  	KSUBJECT 		\n");
		sb.append("		,A.KWRITER  	KWRITER 		\n");
	    sb.append("		,A.KPW  		KPW   			\n");	    	    	    
	    sb.append("		,A.KMEMO  		KMEMO			\n");
	    sb.append("		,A.KPHOTO  		KPHOTO			\n");	 
	    sb.append("		,A.DELETEYN  	DELETEYN		\n");	
	    sb.append("		,TO_CHAR(A.INSERTDATE, 'YYYY-MM-DD')  INSERTDATE	\n");
	    sb.append("		,TO_CHAR(A.UPDATEDATE, 'YYYY-MM-DD')  UPDATEDATE	\n");	   
	    sb.append("	FROM 								\n");
	    sb.append("		 MVC_BOARD A 					\n");
	    sb.append("	WHERE A.DELETEYN = 'Y'				\n");
	    sb.append("	AND   A.KNUM 	 =  ?  				\n");

	    return sb.toString();	
	}
	
	public static String getBoardInsertQuery(){ 
		
		StringBuffer sb = new StringBuffer();			
		sb.append("	INSERT INTO 						\n");	
		sb.append("		MVC_BOARD 				    	\n");
		sb.append("		          (			    		\n");
		sb.append("     			 KNUM 				\n"); // COLUMN 1
		sb.append("				  	,KSUBJECT 			\n"); // COLUMN 2
		sb.append("					,KWRITER 			\n"); // COLUMN 3
	    sb.append("					,KPW   				\n"); // COLUMN 4	
		sb.append("					,KMEMO				\n"); // COLUMN 5
		sb.append("					,KPHOTO				\n"); // COLUMN 6
	    sb.append("					,DELETEYN			\n"); // COLUMN 7
	    sb.append("					,INSERTDATE			\n"); // COLUMN 8
	    sb.append("					,UPDATEDATE			\n"); // COLUMN 9
		sb.append("			      )						\n");
		sb.append("	       VALUES (  					\n");			
		sb.append("						 ? 				\n");// placeholder 1
	    sb.append("						,?   			\n");// placeholder 2
	    sb.append("						,?   			\n");// placeholder 3
	    sb.append("						,?   			\n");// placeholder 4
	    sb.append("						,? 				\n");// placeholder 5
	    sb.append("						,? 				\n");// placeholder 6
	    sb.append("						,'Y'			\n");// placeholder 7
	    sb.append("						,SYSDATE 		\n");// placeholder 8
	    sb.append("						,SYSDATE 		\n");// placeholder 9	
		sb.append("	              )						\n");		
		
		return sb.toString();
	}
	
	public static String getBoardUpdateQuery(){ 
		StringBuffer sb = new StringBuffer();			
		sb.append("	UPDATE  							\n");	
		sb.append("		   MVC_BOARD 			    	\n");	
		sb.append("	SET  								\n");
	    sb.append("		   KSUBJECT	  		= ?			\n");	    
	    sb.append("		  ,KMEMO 			= ?			\n");	    	    
	    sb.append("		  ,UPDATEDATE 		= SYSDATE	\n");
		sb.append("	WHERE  KNUM 			= ?			\n");	    
		sb.append("	AND    DELETEYN 		= 'Y'  		\n");		
					
		return sb.toString();
	}
	
	public static String getBoardDeleteQuery(){ 
		StringBuffer sb = new StringBuffer();			
		sb.append("	UPDATE  							\n");	
		sb.append("		   MVC_BOARD 			    	\n");	
		sb.append("	SET  								\n");
	    sb.append("		   DELETEYN 	= 'N'			\n");	    	   
	    sb.append("		  ,UPDATEDATE 	= SYSDATE		\n");
		sb.append("	WHERE  KNUM	 		= ?				\n");	    
		sb.append("	AND    DELETEYN 	= 'Y'  			\n");		
					
		return sb.toString();
	}

}
