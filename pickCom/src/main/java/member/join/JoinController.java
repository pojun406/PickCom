package member.join;

import common.CommandMap;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class JoinController {
    @Resource(name="joinService")
    private JoinService joinService;

    // 회원가입 폼
    @RequestMapping(value="/joinForm.do")
    public ModelAndView joinForm(CommandMap commandMap) throws Exception {
        ModelAndView mv = new ModelAndView("login/joinForm");


        return mv;
    }

    // 회원가입 처리
    @RequestMapping(value="/joinAction.do", method= RequestMethod.POST)
    public ModelAndView insertMember(CommandMap commandMap, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("login/joinAction");
        // 이메일, SMS 수신 여부
        String email_agree = (String)commandMap.get("EMAIL_AGREE");
        String sms_agree = (String)commandMap.get("SMS_AGREE");
        // 체크를 하지 않으면 '0' 으로 set 후 넘김
        if(email_agree == null) {
            email_agree = "0";
            commandMap.put("EMAIL_AGREE", email_agree);
        }
        if(sms_agree == null) {
            sms_agree = "0";
            commandMap.put("SMS_AGREE", sms_agree);
        }
        // 이메일
        String email = request.getParameter("MEMBER_EMAIL") + "@" + request.getParameter("MEMBER_EMAIL2");
        System.out.println("이메일 : "+email);
        // 직접입력일 경우
        if(request.getParameter("MEMBER_EMAIL2") == "") {
            email = request.getParameter("MEMBER_EMAIL");
        }
        commandMap.remove("MEMBER_EMAIL");
        commandMap.put("MEMBER_EMAIL", email);

        String birth = request.getParameter("MEMBER_BIRTH")
                + request.getParameter("MEMBER_BIRTH2")
                + request.getParameter("MEMBER_BIRTH3");
        commandMap.remove("MEMBER_BIRTH");
        commandMap.put("MEMBER_BIRTH", birth);

        joinService.memberInsert(commandMap.getMap());

        mv.addObject("MEMBER_NAME", commandMap.get("MEMBER_NAME"));

        return mv;
    }

    //아이디 중복 체크
    @RequestMapping(value="/selectIdCheck.do", method=RequestMethod.GET)
    @ResponseBody
    public int selectIdCheck(@RequestParam("mem_userid") String mem_userid) throws Exception{

        int cnt = joinService.idCheck(mem_userid);

        return cnt;
    }

}
