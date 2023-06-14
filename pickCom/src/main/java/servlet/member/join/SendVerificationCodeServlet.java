package servlet.member.join;

import java.io.IOException;
import java.util.Random;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/join/sendVerificationCode.do")
public class SendVerificationCodeServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 클라이언트로부터 이메일 주소를 받아옴
		String email = request.getParameter("email");
		System.out.println(email);

		// 여기서는 간단히 무작위의 6자리 숫자를 인증번호로 생성합니다
		Random random = new Random();
		int verificationCode = 100000 + random.nextInt(900000);

		// 인증번호를 세션에 저장하거나 데이터베이스에 저장하는 등의 처리를 수행할 수 있습니다.
		// 여기서는 세션에 저장하는 예시를 보여줍니다.
		HttpSession session = request.getSession();
		session.setAttribute("verificationCode", verificationCode);

		// 이메일 전송 로직을 구현하고, 생성된 인증번호를 이메일로 전송합니다.
		// 이 부분은 별도의 이메일 전송 라이브러리를 사용하거나 JavaMail을 활용하여 구현해야 합니다.
		EmailSender sender = new EmailSender();
		boolean result = false;
		try {
			sender.sendEmail(email, verificationCode);
			result = true;
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		System.out.println(result);

		if (result) {
        	// 중복된 아이디인 경우
            response.getWriter().write("{\"isDuplicate\": true}");
        } else {
            // 사용 가능한 아이디인 경우
            response.getWriter().write("{\"isDuplicate\": false}");
        }
	}
}
