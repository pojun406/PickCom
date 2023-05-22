package member.join;

import common.JDBConnection;
import member.MemberDTO;
import java.sql.*;

public class JoinServiceImp extends JDBConnection implements JoinService {

    public void memberInsert(MemberDTO m){
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DriverManager.getConnection(url + database, user, pwd);
            String sql = "INSERT INTO member VALUES (?,?,?,?,?,sysdate,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, "honggile");
            ps.setString(2, "홍길동");
            ps.setString(3, "abcd1234");
            ps.setString(4, "abcd1234@naver.com");
            ps.setString(5, "일반");
            ps.setInt(6, 1);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(con, ps);
        }
    };
    public boolean idCheck(String id){
        boolean result=true;
        Connection con=null;
        ResultSet rs=null;
        PreparedStatement ps=null;
        try {
            con=DriverManager.getConnection(url + database,user,pwd);
            String sql="SELECT * FROM member WHERE id =?";
            ps=con.prepareStatement(sql);
            ps.setString(1, id.trim());
            rs=ps.executeQuery();
            if(rs.next()) {
                result=false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(con, ps, rs);
        }
        return result;
    };
    public boolean mailCheck (String email){
        boolean result = false;
        return result;
    };
}
