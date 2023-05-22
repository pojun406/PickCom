package member.join;

import member.MemberDTO;

public interface JoinService {
    public void memberInsert(MemberDTO m); // 회원가입
    public boolean idCheck(String id); // 아이디 중복 확인
    public boolean mailCheck (String email); // 이메일 확인


}
