package servlet.member.login;

import servlet.member.MemberDAO;
import servlet.member.MemberDTO;
import servlet.utils.JSFunction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login/login.do")
public class LoginController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		// 로그인 폼으로부터 받은 아이디와 패스워드
		String userId = req.getParameter("MEMBER_ID");
		String userPwd = req.getParameter("MEMBER_PASSWD");

		// 회원 테이블 DAO를 통해 회원 정보 DTO 획득
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.memberLogin(userId, userPwd);

		// 로그인 성공 여부에 따른 처리
		if (dto != null) {
			boolean rank = false;
			if (dto.getMember_rank().trim().equals("관리자")) {
				rank = true;
			}
			session.setAttribute("num", dto.getMember_num());
			session.setAttribute("name", dto.getMember_name());
			session.setAttribute("rank", rank);
			resp.sendRedirect("/shop/productList.do");
		} else {
			JSFunction.alertLocation(resp, "로그인 정보를 확인하세요", "/main.do");
		}
	}
}
