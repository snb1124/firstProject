package a.b.c.com.ksj.mem.sql;

public abstract class MemberSqlMap {
	//채번 
	public static String getMaxChabunQuery() {
		
		StringBuffer sb = new StringBuffer();			
		sb.append(" SELECT  /*+ INDEX_DESC(A SYS_C0011199) */ 			\n");
		sb.append("         NVL(MAX(SUBSTR(A.KNUM, -4)), 0) + 1 MAXNUM	\n");
		sb.append(" FROM    MVC_MEMBER A 								\n");	  

		return sb.toString();
	}
	//셀렉트올
	public static String getMemberSelectAllQuery(){ 
		
		StringBuffer sb = new StringBuffer();			
		sb.append(" SELECT 									\n");
		sb.append("      A.KNUM 			KNUM 			\n");
		sb.append("		,A.KNAME  			KNAME 			\n");
		sb.append("		,A.KID  			KID 			\n");
	    sb.append("		,A.KPW  			KPW   			\n");
	    sb.append("		,A.KGENDER  		KGENDER 		\n");
	    sb.append("		,A.KBIRTH  			KBIRTH 			\n");
	    sb.append("		,A.KHP  			KHP 			\n");
	    sb.append("		,A.KTEL  			KTEL   			\n");	   
		sb.append("		,A.KEMAIL  			KEMAIL 			\n");		
	    sb.append("		,A.KZONECODE  		KZONECODE   	\n");
	    sb.append("		,A.KROADADDRESS  	KROADADDRESS 	\n");
	    sb.append("		,A.KGIBUNADDRESS  	KGIBUNADDRESS 	\n");
		sb.append("		,A.KHOBBY  			KHOBBY 			\n");
	    sb.append("		,A.KINFO  			KINFO   		\n");
		sb.append("		,A.KPHOTO  			KPHOTO 			\n");
	    sb.append("		,A.KADMIN  			KADMIN   		\n");
	    sb.append("		,A.DELETEYN 		DELETEYN		\n");
	    sb.append("		,TO_CHAR(A.INSERTDATE, 'YYYY-MM-DD')  INSERTDATE	\n");
	    sb.append("		,TO_CHAR(A.UPDATEDATE, 'YYYY-MM-DD')  UPDATEDATE	\n");	    
	    sb.append("	FROM 								\n");
	    sb.append("		 MVC_MEMBER A 					\n");
	    sb.append("	WHERE DELETEYN = 'Y'				\n");
	    sb.append("	ORDER BY 1 DESC						\n");

	    return sb.toString();
	}
	
	//셀렉트
	public static String getMemberSelectQuery(){ 
		
		StringBuffer sb = new StringBuffer();			
		sb.append(" SELECT 									\n");
		sb.append("      A.KNUM 			KNUM 			\n");
		sb.append("		,A.KNAME  			KNAME 			\n");
		sb.append("		,A.KID  			KID 			\n");
	    sb.append("		,A.KPW  			KPW   			\n");
	    sb.append("		,A.KGENDER  		KGENDER 		\n");
	    sb.append("		,A.KBIRTH  			KBIRTH 			\n");
	    sb.append("		,A.KHP  			KHP 			\n");
	    sb.append("		,A.KTEL  			KTEL   			\n");	   
		sb.append("		,A.KEMAIL  			KEMAIL 			\n");		
	    sb.append("		,A.KZONECODE  		KZONECODE   	\n");
	    sb.append("		,A.KROADADDRESS  	KROADADDRESS 	\n");
	    sb.append("		,A.KGIBUNADDRESS  	KGIBUNADDRESS 	\n");
		sb.append("		,A.KHOBBY  			KHOBBY 			\n");
	    sb.append("		,A.KINFO  			KINFO   		\n");
		sb.append("		,A.KPHOTO  			KPHOTO 			\n");
	    sb.append("		,A.KADMIN  			KADMIN   		\n");
	    sb.append("		,A.DELETEYN 		DELETEYN		\n");
	    sb.append("		,TO_CHAR(A.INSERTDATE, 'YYYY-MM-DD')  INSERTDATE	\n");
	    sb.append("		,TO_CHAR(A.UPDATEDATE, 'YYYY-MM-DD')  UPDATEDATE	\n");	    
	    sb.append("	FROM 								\n");
	    sb.append("		 MVC_MEMBER A 					\n");
	    sb.append("	WHERE DELETEYN = 'Y'				\n");
	    sb.append("	AND   A.KNUM   = ?					\n");// placeholder 1

	    return sb.toString();
	}
	// 회원 등록
	public static String getMemberInsertQuery(){ 
		
		StringBuffer sb = new StringBuffer();			
		sb.append("	INSERT INTO 						\n");	
		sb.append("		MVC_MEMBER 				    	\n");
		sb.append("		          (			    		\n");
		sb.append("      			 KNUM 				\n"); // COLUMN 1
		sb.append("					,KNAME 				\n"); // COLUMN 2
		sb.append("					,KID 				\n"); // COLUMN 3
	    sb.append("					,KPW   				\n"); // COLUMN 4
	    sb.append("					,KGENDER 			\n"); // COLUMN 5
	    sb.append("					,KBIRTH 			\n"); // COLUMN 6
	    sb.append("					,KHP 				\n"); // COLUMN 7
	    sb.append("					,KTEL   			\n"); // COLUMN 8	   
		sb.append("					,KEMAIL 			\n"); // COLUMN 9		
	    sb.append("					,KZONECODE   		\n"); // COLUMN 10
	    sb.append("					,KROADADDRESS 		\n"); // COLUMN 11
	    sb.append("					,KGIBUNADDRESS 		\n"); // COLUMN 12
		sb.append("					,KHOBBY 			\n"); // COLUMN 13
	    sb.append("					,KINFO   			\n"); // COLUMN 14
		sb.append("					,KPHOTO 			\n"); // COLUMN 15
	    sb.append("					,KADMIN   			\n"); // COLUMN 16
	    sb.append("					,DELETEYN			\n"); // COLUMN 17
	    sb.append("					,INSERTDATE			\n"); // COLUMN 18
	    sb.append("					,UPDATEDATE			\n"); // COLUMN 19	 	  
		sb.append("			      )						\n");
		sb.append("	       VALUES   					\n");
		sb.append("	       		 (  					\n");
		sb.append("     				 ? 				\n"); // placeholder 1
		sb.append("						,? 				\n"); // placeholder 2
	    sb.append("						,?   			\n"); // placeholder 3
	    sb.append("						,?   			\n"); // placeholder 4
	    sb.append("						,? 				\n"); // placeholder 5
	    sb.append("						,? 				\n"); // placeholder 6
	    sb.append("						,?				\n"); // placeholder 7
	    sb.append("						,?				\n"); // placeholder 8
	    sb.append("						,?				\n"); // placeholder 9
	    sb.append("						,?   			\n"); // placeholder 10
	    sb.append("						,? 				\n"); // placeholder 11
	    sb.append("						,? 				\n"); // placeholder 12
	    sb.append("						,?				\n"); // placeholder 13
	    sb.append("						,?				\n"); // placeholder 14
	    sb.append("						,?				\n"); // placeholder 15
	    sb.append("						,?				\n"); // placeholder 16
	    sb.append("						,'Y'			\n"); // placeholder 17
	    sb.append("						,SYSDATE 		\n"); // placeholder 18
	    sb.append("						,SYSDATE 		\n"); // placeholder 19	
		sb.append("	              )						\n");		
		
		return sb.toString();
	}
	//업데이트
	public static String getMemberUpdateQuery(){ 
		
		StringBuffer sb = new StringBuffer();			
		sb.append("	UPDATE  							\n");	
		sb.append("		   	 MVC_MEMBER 			    \n");	
		sb.append("	SET  								\n");		
		sb.append("			 KEMAIL 		= ?			\n"); // placeholder 1	  
		sb.append("			,KZONECODE   	= ?			\n"); // placeholder 2	
		sb.append("			,KROADADDRESS 	= ?			\n"); // placeholder 3	
		sb.append("			,KGIBUNADDRESS 	= ?			\n"); // placeholder 4			   
		sb.append("			,KHOBBY 		= ? 		\n"); // placeholder 5	        	
	    sb.append("		  	,UPDATEDATE 	= SYSDATE	\n");
		sb.append("	WHERE  	 KNUM 			= ?			\n"); // placeholder 6	    
		sb.append("	AND    	 DELETEYN 		= 'Y'  		\n");		
					
		return sb.toString();
	}
	//딜리트
	public static String getMemberDeleteQuery(){ 
		
		StringBuffer sb = new StringBuffer();			
		sb.append("	UPDATE  							\n");	
		sb.append("		   MVC_MEMBER 			    	\n");	
		sb.append("	SET  								\n");
	    sb.append("		   DELETEYN 	= 'N'			\n");	    	   
	    sb.append("		  ,UPDATEDATE 	= SYSDATE		\n");
		sb.append("	WHERE  KNUM 		= ?				\n"); // placeholder 1    
		sb.append("	AND    DELETEYN 	= 'Y'  			\n");		
					
		return sb.toString();
	}	
}
