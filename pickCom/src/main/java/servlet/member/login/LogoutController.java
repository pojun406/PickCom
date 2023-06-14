package servlet.member.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login/logout.do")
public class LogoutController extends HttpServlet {
	@Override
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.removeAttribute("num");
		session.removeAttribute("name");
		session.removeAttribute("rank");
		
		resp.sendRedirect("/productList.do");
	 }
}
