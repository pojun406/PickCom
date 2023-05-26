package member.join;

import common.JDBConnection;
import jakarta.annotation.Resource;
import member.MemberDTO;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.Map;

@Service("joinService")
public class JoinServiceImp extends JDBConnection implements JoinService {
    @Resource(name="joinDAO")
    private JoinDAO joinDAO;

    // 회원가입
    @Override
    public void memberInsert(Map<String, Object> map) throws Exception{
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

        joinDAO.memberInsert(map);
    };

    // 아이디 중복체크
    @Override
    public int idCheck(String id) throws Exception{
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
        return joinDAO.idCheck(id);
    };

    // 이메일 중복 체크
    @Override
    public int selectEmailCheck(String email) throws Exception{
        return joinDAO.selectEmailCheck(email);
    }
}
