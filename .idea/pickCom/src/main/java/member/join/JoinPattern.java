package member.join;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JoinPattern {
    private static final String ID_PATTERN = "^[a-zA-Z0-9]{6,14}$";
    private static final String NICKNAME_PATTERN = "^[��-�Ra-zA-Z]{2,8}$";
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&+=]?)(?=\\S+$).{8,16}$";

    public boolean idChk(String id) {
        Pattern pattern = Pattern.compile(ID_PATTERN);
        Matcher matcher = pattern.matcher(id);
        return matcher.matches();
    }

    public boolean nameChk(String name) {
        Pattern pattern = Pattern.compile(NICKNAME_PATTERN);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public boolean pwdChk(String pwd) {
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(pwd);
        return matcher.matches();
    }
}
