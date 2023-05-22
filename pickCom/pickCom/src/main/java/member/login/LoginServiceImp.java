package member.login;

import common.JDBConnection;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.Map;

@Service("loginService")
public class LoginServiceImp extends JDBConnection implements LoginService {
    @Resource(name="loginDAO")
    private LoginDAO loginDAO;

    // 로그인
    @Override
    public Map<String, Object> memberLogin(Map<String, Object> map) throws Exception{
        return loginDAO.memberLogin(map);
    }

    // 로그아웃
    @Override
    public Map<String, Object> memberLogout(Map<String, Object> map) throws Exception{
        return loginDAO.memberLogout(map);
    }

    // 아이디 찾기
    @Override
    public Map<String, Object> findId(Map<String, Object> map) throws Exception{
        return (Map<String, Object>) loginDAO.findId(map);
    }

    // 비밀번호 찾기
    @Override
    public Map<String, Object> findPw(Map<String, Object> map) throws Exception{
        return (Map<String, Object>) loginDAO.findPw(map);
    }

}
