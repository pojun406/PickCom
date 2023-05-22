package member.login;

import common.JDBConnection;
import java.sql.*;

public class LoginImp extends JDBConnection implements LoginDAO {
    public int loginCheck(String id, String pw) { // 로그인
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        int result=0;
        try {
            con= DriverManager.getConnection(url + database, user, pwd);
            String sql="select * from member where id=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()==false || (id.isEmpty())==true) { // 아이디가 비어있거나 값이 없을 때
                result=1;
            } else {
                sql="select * from (select * from member where id=?)";
                ps.setString(1, id);
                rs=ps.executeQuery(sql);
                while (rs.next()==true) {
                    if (rs.getString(3).equals(pw)) { // 입력한 비밀번호와 데이터베이스의 비밀번호가 일치하는지 검사
                        result=0; // 로그인 성공
                    }else {
                        result=1;
                    }
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(con, ps, rs);
        }
        return result;
    }
}
