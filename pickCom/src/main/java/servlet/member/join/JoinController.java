package servlet.member.join;

import servlet.member.MemberDAO;
import servlet.member.MemberDTO;
import servlet.utils.JSFunction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/join/join.do")
public class JoinController extends HttpServlet {
	@Override
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		// 로그인 폼으로부터 받은 아이디와 패스워드
		String userId = req.getParameter("MEMBER_ID");
		String userName = req.getParameter("MEMBER_NAME");
		String userPwd = req.getParameter("MEMBER_PASSWD");
		String userEmail = req.getParameter("MEMBER_EMAIL");
		String nickName = req.getParameter("MEMBER_NICKNAME");

		// 회원 테이블 DAO를 통해 회원 정보 DTO 획득
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = new MemberDTO();
		dto.setMember_id(userId);
		dto.setMember_name(userName);
		dto.setMember_passwd(userPwd);
		dto.setMember_email(userEmail);
		dto.setMember_nickName(nickName);
		dao.memberJoin(dto);
		
		JSFunction.alertLocation(resp, "회원가입 완료", "/views/login/loginForm.jsp");
	 }
}
