package servlet.member.join;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {
    private final String host = "smtp.gmail.com"; // SMTP 서버 호스트
    private final int port = 587; // SMTP 서버 포트
    private final String username = "roozi8855@gmail.com"; // 보내는 이메일 계정
    private final String password = "pxxunybnxntczulg"; // 보내는 이메일 계정 비밀번호

    public void sendEmail(String recipient, int code) throws MessagingException {
        // SMTP 서버 설정
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);

        // 인증 정보
        Authenticator authenticator = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        };

        // 세션 생성
        Session session = Session.getInstance(properties, authenticator);

        try {
            // 메시지 생성
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username)); // 보내는 사람 이메일 설정
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient)); // 수신자 이메일 설정
            message.setSubject("PickCom 회원가입 인증번호"); // 이메일 제목 설정
            message.setText("인증번호는 " + code + "입니다."); // 이메일 내용 설정

            // 이메일 전송
            Transport.send(message);

            System.out.println("이메일 전송 완료");

        } catch (AddressException e) {
            e.printStackTrace();
            throw new RuntimeException("유효하지 않은 이메일 주소입니다.");
        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RuntimeException("이메일 전송 중 오류가 발생했습니다.");
        }
    }
}
