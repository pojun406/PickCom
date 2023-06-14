package servlet.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnPool {
	private String url = "jdbc:mariadb://localhost:3306/pcom";
	private String user = "root";
	private String pwd = "eodnjs5060!";
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public DBConnPool() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("접속");
		} catch (Exception e) {
			System.out.println("Exception[DBConnPool]: " + e.getMessage());
		}
	}

	public void close() {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
			if (rs != null) {
				rs.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			System.out.println("Exception[close]: " + e.getMessage());
		}
	}
	
	public Connection getConnection() {
		return con;
	}
}
