package servlet.member.join;

import servlet.member.MemberDAO;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/join/idCheck.do")
public class IdCheckServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("userId");

        // MemberDAO의 idCheck() 메서드를 호출하여 아이디 중복 여부 확인
        MemberDAO dao = new MemberDAO();
        boolean isIdAvailable = dao.idCheck(id.trim());
        System.out.println(isIdAvailable);
        if (isIdAvailable) {
        	// 중복된 아이디인 경우
            response.getWriter().write("{\"isDuplicate\": true}");
        } else {
            // 사용 가능한 아이디인 경우
            response.getWriter().write("{\"isDuplicate\": false}");
        }
    }
}
