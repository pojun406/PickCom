package member.my;

import java.util.List;
import java.util.Map;

public interface MyDAO {
    // 구매 목록
    public List<Map<String,Object>> orderList(Map<String,Object> map);

    // 닉네임 변경
    public String nickNameChange(String nickName);

    // 비밀번호 변경
    public String passwdChange(String passwd);

    // 회원 탈퇴
    public void memberDelete();

    // 게시글 목록
    public List<Map<String,Object>> boardList(List<Map<String,Object>> map);

    // 게시글 삭제

    // 댓글 목록
    public List<Map<String,Object>> replyList(List<Map<String,Object>> map);

    // 리뷰 목록
    public List<Map<String,Object>> reviewList(List<Map<String,Object>> map);
}
