package a.b.c.com.ksj.login.Sql;

public abstract class LoginSqlMap {

	public static String getLoginCheckCntQuery(){
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT 								\n");
		sb.append("       COUNT(A.KNUM)  NCNT 			\n");		
	    sb.append("	FROM 								\n");	    
	    sb.append("		  MVC_MEMBER 	A 				\n");
	    sb.append("	WHERE A.DELETEYN 	= 'Y'			\n");	    
	    sb.append("	AND   A.KID 	  	= ?				\n");
	    sb.append("	AND   A.KPW  		= ?   			\n");
		
		
		
		/*내가 생각한 쿼리문 
		 * sb.append("SELECT A.KID, A.KPW \n");
		sb.append("FROM MVC_MEMBER A \n");
		sb.append("WHERE KID = ? \n");
		sb.append("AND   KPW = ? \n");
		sb.append("AND   DELETEYN = 'Y' \n");
		 sb.append("	ORDER BY 1 DESC ");
		 */
		return sb.toString();
	}
}
