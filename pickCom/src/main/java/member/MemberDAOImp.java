package member;

import java.sql.*;
import java.time.LocalDate;

public class MemberDAOImp implements MemberDAO {
    Connection con = null;
    String url, database, user, pwd;
    public MemberDAOImp() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            url = "jdbc:mariadb://localhost:3306/";
            database = "pcom";
            user = "root";
            pwd = "1234";
        } catch (ClassNotFoundException e) {
            System.err.println(" 드라이버 로딩 오류 : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void memberInsert(MemberDTO m) { // 회원가입
        Connection con = null;
        PreparedStatement ps = null;
        LocalDate now = LocalDate.now();
        try {
            con = DriverManager.getConnection(url + database, user, pwd);
            String sql = "INSERT INTO member VALUES (?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, "honggile");
            ps.setString(2, "홍길동");
            ps.setString(3, "abcd1234");
            ps.setString(4, "abcd1234@naver.com");
            ps.setString(5, "일반");
            ps.setString(6, now.toString());
            ps.setInt(7, 1);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(con, ps);
        }
    }

    public boolean idCheck(String id) { // 아이디 확인
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
    }

    public int loginCheck(String id, String pw) { // 로그인
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        int result=0;
        try {
            con=DriverManager.getConnection(url + database, user, pwd);
            st=con.createStatement();
            String sql="select * from member where id='" + id + "'";
            rs = st.executeQuery(sql);
            if (rs.next()==false || (id.isEmpty())==true) { // 아이디가 비어있거나 값이 없을 때
                result=1;
            } else {
                sql="select * from (select * from member where id='" + id + "')";
                rs=st.executeQuery(sql);
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
            closeConnection(con, st, rs);
        }
        return result;
    }

    public boolean mailCheck (String email) { // 이메일 확인

        boolean result = false;

        return result;
    }

    /*public ArrayList<Member> memberView() { // 유저 리스트 출력
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        ArrayList<Member> mArr=new ArrayList<Member>();
        try {
            con=DriverManager.getConnection(url + database, user, pwd);
            String sql="SELECT * FROM java.member";
            st=con.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()) {
                Member m=new Member();
                m.setNum(rs.getInt("num"));
                m.setName(rs.getString("name"));
                m.setId(rs.getString("id"));
                m.setPw(rs.getString("pw"));
                m.setEmail(rs.getString("email"));
                mArr.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mArr;
    }

    //ȸ�� ����
    public void memberUpdate(Member m) { // 유저 정보 업데이트
        Connection con=null;
        PreparedStatement ps=null;
        try {
            String sql="UPDATE java.member SET name=?, id=?,"
                    + "pw=?,score=? WHERE num=?";
            con=DriverManager.getConnection(url + database,user,pwd);
            ps=con.prepareStatement(sql);
            ps.setString(1, m.getId());
            ps.setString(2, m.getName());
            ps.setString(3, m.getPw());
            ps.setInt(5, m.getNum());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(con, ps);
        }
    }

    //ȸ�� �˻�
    public ArrayList<Member> memberSearch(String key, String word){ // 유저 검색
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        ArrayList<Member>mArr=new ArrayList<Member>();
        try {
            con=DriverManager.getConnection(url+database,user,pwd);
            st=con.createStatement();
            String sql="SELECT * FROM java.member WHERE "+key+" LIKE '%"+word+"%'";
            rs=st.executeQuery(sql);
            while(rs.next()) {
                Member m=new Member();
                m.setNum(rs.getInt("num"));
                m.setName(rs.getString("name"));
                m.setId(rs.getString("id"));
                m.setPw(rs.getString("pw"));
                m.setScore(rs.getInt("score"));
                mArr.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(con, st, rs);
        }
        return mArr;
    }

    public void memberDelete(int num) { // 유저 삭제
        Connection con=null;
        Statement st=null;
        try {
            con=DriverManager.getConnection(url + database, user, pwd);
            String sql="DELETE FROM java.member WHERE num="+num;
            st=con.createStatement();
            st.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(con, st, null);
        }
    }*/

    public void closeConnection(Connection con, Statement st, ResultSet rs) {
        try {
            if(con!=null) con.close();
            if(st!=null) st.close();
            if(rs!=null) rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection(Connection con, PreparedStatement ps) {
        try {
            if(con!=null) con.close();
            if(ps!=null) ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
