package member;

public interface MemberDAO {
    public void memberInsert(MemberDTO m);

    public boolean idCheck(String id);

    public int loginCheck(String id, String pw);

//    public ArrayList<Member> mArr=new ArrayList<Member>();
//
//    public void memberUpdate(Member m);
//
//    public ArrayList<Member> memberSearch(String key, String word);
//
//    public void memberDelete(int num);
}
