package a.b.c.com.common;
import java.sql.Connection;
import java.sql.DriverManager;

public abstract class CommonXML {

	
	public static final String XML_FILE_PATH= "C:\\00.KOSMO93\\30.WEB\\el_web_neon_work\\testCss\\WebContent\\cssTest\\xmlTest";
	public static final String KOS_URL = "jdbc:oracle:thin:@localhost:1521:orclKOSMO00";
	public static final String KOS_USER="scott";
	public static final String KOS_PASS="1234";
	public static final String KOS_DRIVER="oracle.jdbc.driver.OracleDriver";
	
	public static Connection getConnection(){
		Connection conn = null;
		
		try{
			Class.forName(CommonXML.KOS_DRIVER);
			conn= DriverManager.getConnection(CommonXML.KOS_URL, CommonXML.KOS_USER, CommonXML.KOS_PASS);
			
		}catch(Exception e){
			System.out.println("드라이버 찾기 문제 발생  "+ e.getMessage());
		}
		
		return conn;
	}
	
	
}
