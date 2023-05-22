package member;

public class MemberDTO {
    private String member_id;
    private String member_name;
    private String nickName;
    private String passwd;
    private String email;
    private String rank;
    private String member_regDate;
    private boolean member_stat;

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getMember_regDate() {
        return member_regDate;
    }

    public void setMember_regDate(String member_regDate) {
        this.member_regDate = member_regDate;
    }

    public boolean isMember_stat() {
        return member_stat;
    }

    public void setMember_stat(boolean member_stat) {
        this.member_stat = member_stat;
    }
}
