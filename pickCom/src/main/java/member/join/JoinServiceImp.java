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
        joinDAO.memberInsert(map);
    };

    // 아이디 중복체크
    @Override
    public int idCheck(String id) throws Exception{
        return joinDAO.idCheck(id);
    };

    // 이메일 중복 체크
    @Override
    public int selectEmailCheck(String email) throws Exception{
        return joinDAO.selectEmailCheck(email);
    }
}
