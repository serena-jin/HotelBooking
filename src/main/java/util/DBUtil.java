package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	
//	private static DataSource ds; 
//	
//	static {
//		try {
//			Context initContext = new InitialContext();
//			Context envContext  = (Context)initContext.lookup("java:/comp/env");
//			ds = (DataSource)envContext.lookup("jdbc/myoracle"); //lookup("jdbc/myoracle"): java 환경 내부에 재사용 가능한 요소들
//		}catch(NamingException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	
//	public static Connection getConnection() throws SQLException {
//		return ds.getConnection();
//	}
	
	
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("--------DB connected--------");
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
			System.out.println("--------DB failed--------");
		}
	}

	
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "SCOTT", "TIGER");
	}



	// DML용
	public static void close(Connection con, Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	
	
	// SELECT용
	public static void close(Connection con, Statement stmt, ResultSet rset) {
		try {
			if (rset != null) {
				rset.close();
				rset = null;
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}
}
