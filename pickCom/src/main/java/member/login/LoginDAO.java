package member.login;

import common.AbstractDAO;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository("loginDAO")
public class LoginDAO extends AbstractDAO {
    // 로그인
    public Map<String, Object> memberLogin(Map<String, Object> map) throws Exception{
        return (Map<String, Object>)selectOne("login.loginAction", map);
    }

    // 로그아웃
    public Map<String, Object> memberLogout(Map<String, Object> map) throws Exception{
        return (Map<String, Object>)selectOne("login.logout", map);
    }

    // 아이디 찾기
    public Map<String, Object> findId(Map<String, Object> map) throws Exception{
        return (Map<String, Object>)selectOne("login.selectFindId2", map);
    }

    // 비밀번호 찾기
    public Map<String, Object> findPw(Map<String, Object> map) throws Exception{
        return (Map<String, Object>)selectOne("login.selectFindPw2", map);
    }


}
