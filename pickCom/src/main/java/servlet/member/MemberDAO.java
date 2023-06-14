package servlet.member;

import pcom.board.BoardDTO;
import servlet.common.DBConnPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class MemberDAO {
	private DBConnPool db;

	// 사용자 로그인
	public MemberDTO memberLogin(String uid, String upass) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDTO dto = null;

		String query = "select * from member where member_id=? and member_passwd=?";
		try {
			db = new DBConnPool();
			con = db.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, uid);
			pstmt.setString(2, upass);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new MemberDTO();
				dto.setMember_num(rs.getInt("member_num"));
				dto.setMember_name(rs.getString("member_name"));
				dto.setMember_nickName(rs.getString("member_nickName"));
				dto.setMember_rank(rs.getString("member_rank"));
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		} finally {
			db.close();
		}
		return dto;
	}

	// 사용자 아이디 중복 확인
	public boolean idCheck(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean result = false;

		String query = "SELECT * FROM member WHERE member_id =?";
		try {
			db = new DBConnPool();
			con = db.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = true;
			}
		} catch (Exception e) {
			System.out.println("Exception[idCheck]: " + e.getMessage());
		} finally {
			db.close();
		}
		return result;
	}

	// 사용자 회원가입
	public int memberJoin(MemberDTO m) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;

		// String query = "SELECT COUNT(*) FROM member WHERE member_email = ?";
		String query = "INSERT INTO member(member_id, member_passwd,"
				+ "member_name,member_nickName, member_email, member_rank) " + "VALUES (?, ?, ?, ?, ?, ?)";

		try {
			db = new DBConnPool();
			con = db.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, m.getMember_id());
			pstmt.setString(2, m.getMember_passwd());
			pstmt.setString(3, m.getMember_name());
			pstmt.setString(4, m.getMember_nickName());
			pstmt.setString(5, m.getMember_email());
			pstmt.setString(6, "일반");
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Exception[memberJoin]: " + e.getMessage());
		} finally {
			db.close();
		}
		return result;
	}

	// 사용자 정보 조회
	public MemberDTO memberSelect(int idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDTO dto = null;

		String query = "SELECT * FROM member WHERE member_num =?";
		try {
			db = new DBConnPool();
			con = db.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new MemberDTO();
				Timestamp regDate = rs.getTimestamp("member_regDate");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String regDateString = sdf.format(regDate);

				dto.setMember_num(rs.getInt("member_num"));
				dto.setMember_id(rs.getString("member_id"));
				dto.setMember_name(rs.getString("member_name"));
				dto.setMember_nickName(rs.getString("member_nickName"));
				dto.setMember_passwd(rs.getString("member_passwd"));
				dto.setMember_email(rs.getString("member_email"));
				dto.setMember_rank(rs.getString("member_rank"));
				dto.setMember_regDate(regDateString);
			}
		} catch (Exception e) {
			System.out.println("Exception[memberSelect]: " + e.getMessage());
		} finally {
			db.close();
		}
		return dto;
	}

	// 사용자 아이디 조회
	public int idFind(String email) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;

		String query = "SELECT * FROM member WHERE member_email=?";
		try {
			db = new DBConnPool();
			con = db.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = 1;
			}
		} catch (Exception e) {
			System.out.println("Exception[idFind]: " + e.getMessage());
		} finally {
			db.close();
		}
		return result;
	}

	// 사용자 비밀번호 변경
	public int pwUpdate(int num, String pw) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;

		String query = "UPDATE member SET member_passwd=? WHERE member_num=?";
		try {
			db = new DBConnPool();
			con = db.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, pw);
			pstmt.setInt(2, num);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Exception[pwUpdate] : " + e.getMessage());
		} finally {
			db.close();
		}
		return result;
	}

	// 사용자 정보 삭제
	public void memberDelete(int idx) {
		Connection con = null;
		PreparedStatement pstmt = null;

		String query = "DELETE member WHERE member_num=?";
		try {
			db = new DBConnPool();
			con = db.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Exception[memberDelete] : " + e.getMessage());
		} finally {
			db.close();
		}
	}

	// 사용자 정보 수정
	public void nameUpdate(int num, String name) {
		Connection con = null;
		PreparedStatement pstmt = null;

		String query = "UPDATE member SET member_name=? " + "WHERE member_num=?";
		try {
			db = new DBConnPool();
			con = db.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setInt(2, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Exception[nameUpdate] : " + e.getMessage());
		} finally {
			db.close();
		}
	}

	// 검색 조건에 맞는 게시물의 개수를 반환합니다.
	public int selectCount(int num, String cate) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int totalCount = 0;

		String query = "SELECT COUNT(*) FROM ? WHERE member_num=?";
		try {
			db = new DBConnPool();
			con = db.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, cate);
			pstmt.setInt(2, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				totalCount = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("게시물 카운트 중 예외 발생");
			e.printStackTrace();
		} finally {
			db.close();
		}

		return totalCount;
	}


}
