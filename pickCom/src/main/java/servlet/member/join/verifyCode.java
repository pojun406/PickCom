package servlet.member.join;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/join/verifyCode.do")
public class verifyCode extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 클라이언트로부터 입력받은 인증번호를 가져옴
        String enteredCode = request.getParameter("code");

        // 세션에서 저장된 인증번호를 가져옴
        HttpSession session = request.getSession();
        Integer storedCode = (Integer) session.getAttribute("verificationCode");
        System.out.println(enteredCode + "  " + storedCode);
        if (storedCode != null && enteredCode != null && storedCode.toString().equals(enteredCode)) {
            // 인증 성공 메시지를 클라이언트에 응답합니다.
        	response.getWriter().write("{\"isDuplicate\": false}");
        } else {
            // 인증번호 불일치
            // 인증 실패 메시지를 클라이언트에 응답합니다.
        	response.getWriter().write("{\"isDuplicate\": true}");
        }
    }
}