package com.catchdog.common;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class ConnProperty {

	private static final String ORCL_JDBC_DIRVER = "oracle.jdbc.driver.OracleDriver";
	private static final String ORCL_URL = "jdbc:oracle:thin:@49.247.38.128:1521:XE";
	private static final String ORCL_USER = "ds2d";
	private static final String ORCL_PASS = "1111";
	
	public static Connection getConnection() {
		
		Connection conn = null;
		
		try {
			Class.forName(ConnProperty.ORCL_JDBC_DIRVER);	
			conn = DriverManager.getConnection( ConnProperty.ORCL_URL
					                           ,ConnProperty.ORCL_USER
					                           ,ConnProperty.ORCL_PASS);
			
		}catch (Exception e) {
			System.out.println(   "ConnProperty :: 데이터베이스를 연결하는데 \n"
					            + "드라이버 또는 연결 과정에서 문제가 생김 >>> : \n" 
								+ e.getMessage() + "\n");
		}
		System.out.println("완료");
		return conn;
	}
	
	public static void main(String[]args) {
		ConnProperty.getConnection();
		
	}

}
