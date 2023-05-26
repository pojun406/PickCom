package member.my;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {
    @Resource(name = "myService")
    private MyService myService;

    // 마이페이지 메인

    // 수정 전 비밀번호 확인

    //회원 정보 수정 폼 이동

    // 회원 정보 수정 처리

    // 회원 탈퇴 폼

    // 회원 탈퇴 처리

    //좋아요 리스트 출력

    //좋아요 삭제

    // 마이페이지 사이드바

    //상품QNA리스트 페이지 열기

    //나의 상품QNA 출력

    //나의 상품후기 리스트 페이지 열기

    //나의 상품후기 출력
}
