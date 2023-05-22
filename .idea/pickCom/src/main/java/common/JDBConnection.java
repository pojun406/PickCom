package common;

import java.sql.*;

public class JDBConnection {
    Connection con = null;
    public String url, database, user, pwd;
    public JDBConnection(){
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            url = "jdbc:mariadb://localhost:3306/";
            database = "pcom";
            user = "root";
            pwd = "1234";
        } catch (ClassNotFoundException e) {
            System.err.println(" 드라이버 로딩 오류 : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void closeConnection(Connection con, PreparedStatement ps, ResultSet rs) {
        try {
            if(con!=null) con.close();
            if(ps!=null) ps.close();
            if(rs!=null) rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection(Connection con, PreparedStatement ps) {
        try {
            if(con!=null) con.close();
            if(ps!=null) ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
