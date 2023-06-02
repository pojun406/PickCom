package shop.cart;

import common.CommandMap;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class CartController {
    @Resource(name="cartService")
    private CartService cartService;

    //세션값으로 장바구니 전체리스트
    @RequestMapping(value="/cart/cartList.do")
    public ModelAndView cartList(CommandMap commandMap, HttpServletRequest request) throws Exception {

        ModelAndView mv = new ModelAndView("cart/cartList");

        Object MEMBER_NO = "";
        //세션값 가져오기
        HttpSession session = request.getSession();
        MEMBER_NO = (Object)session.getAttribute("SESSION_NO");
        commandMap.remove("MEMBER_NUM");
        // 기존 회원번호 데이터 삭제
        commandMap.put("MEMBER_NUM", MEMBER_NO);
        // 세션 값으로 적용

        List<Map<String,Object>> list = cartService.cartList(commandMap);
        //GOODS_NO, cart_NO, MEMBER_NO, cart_GOODS_AMOUNT, GOODS_ATT_NO, GOODS_ATT_SIZE,
        //GOODS_ATT_COLOR, GOODS_NAME, GOODS_SELL_PRICE, GOODS_SALE_PRICE, UPLOAD_SAVE_NAME, MEMBER_GRADE

        mv.addObject("list", list);
        System.out.println(list);
        return mv;

    }

    //장바구니 수량 수정
    @RequestMapping(value="/cart/cartModify.do")
    public ModelAndView cartModify(CommandMap commandMap, HttpServletRequest request) throws Exception {

        ModelAndView mv = new ModelAndView("redirect:/cart/cartList.do");

        //수량수정
        cartService.cartModify(commandMap, request);
        return mv;
    }

    //장바구니 선택삭제(1개)
    @RequestMapping(value="/cart/cartDelete.do")
    public ModelAndView cartDelete(CommandMap commandMap, HttpServletRequest request) throws Exception {

        ModelAndView mv = new ModelAndView("redirect:/cart/cartList.do");
        System.out.println(commandMap.get("cart_NUM"));
        cartService.cartDelete(commandMap, request);
        return mv;
    }

    //정바구니 전체삭제
    @RequestMapping(value="/cart/cartAllDelete.do")
    public ModelAndView cartAllDelete(CommandMap commandMap, HttpServletRequest request) throws Exception {

        Object MEMBER_NO = "";
        //세션값 가져오기
        HttpSession session = request.getSession();
        MEMBER_NO = (Object)session.getAttribute("SESSION_NO");
        // 기존 회원번호 데이터 삭제
        commandMap.remove("MEMBER_NUM");
        // 세션 값으로 적용
        commandMap.put("MEMBER_NUM", MEMBER_NO);

        ModelAndView mv = new ModelAndView("redirect:/cart/cartList.do");
        System.out.println(commandMap.get("MEMBER_NUM"));
        cartService.cartClear(commandMap, request);
        return mv;
    }

    /*//장바구니에서 제품 찜하기
    @RequestMapping(value="/cart/like.do")
    public ModelAndView goodsLike(CommandMap commandMap, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("redirect:/cart/cartList.do");

        Object MEMBER_NO = "";
        //세션값 가져오기
        HttpSession session = request.getSession();
        MEMBER_NO = (Object)session.getAttribute("SESSION_NO");
        // 기존 회원번호 데이터 삭제
        commandMap.remove("MEMBER_NO");
        // 세션 값으로 적용
        commandMap.put("MEMBER_NO", MEMBER_NO);

        //해당제품 찜하기 여부 확인
        Map<String,Object> map = cartService.selectProductLike(commandMap, request);
        //이미 있으면'1', 없으면'0'
        String like_cnt = String.valueOf(map.get("LIKE_CNT"));

        //없을때 찜하기 추가
        if(like_cnt.equals("0")) {
            cartService.insertProductLike(commandMap, request);
        }
        return mv;
    }*/
}
