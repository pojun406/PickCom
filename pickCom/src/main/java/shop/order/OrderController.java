package shop.order;

import common.CommandMap;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import shop.cart.CartService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class OrderController {
    @Resource(name="cartService")
    private CartService cartService;

    @Resource(name="orderService")
    private OrderService orderService;

    //장바구니 모두구매
    @RequestMapping(value="/order/cartAllOrderWrite.do")
    public ModelAndView cartAllOrderSelect(CommandMap commandMap, HttpServletRequest request) throws Exception {

        ModelAndView mv = new ModelAndView("order/orderWrite");
        Object MEMBER_NUM = ""; //세션값 가져오기
        HttpSession session = request.getSession();
        MEMBER_NUM = (Object)session.getAttribute("SESSION_NO");
        commandMap.remove("MEMBER_NUM"); // 기존 회원번호 데이터 삭제
        commandMap.put("MEMBER_NUM", MEMBER_NUM); // 세션 값으로 적용
        List<Map<String,Object>> list = cartService.cartList(commandMap);
        Map<String,Object> map = orderService.orderMemberInfo(commandMap, request);
        mv.addObject("list", list);
        mv.addObject("map", map);
        System.out.println(list);
        System.out.println(map);
        return mv;
    }

    //장바구니 선택상품 구매
    @RequestMapping(value="/order/cartSelectOrder.do")
    public ModelAndView cartSelect(CommandMap commandMap, HttpServletRequest request) throws Exception {

        ModelAndView mv = new ModelAndView("order/orderWrite");
        Object MEMBER_NUM = ""; //세션값 가져오기
        HttpSession session = request.getSession();
        MEMBER_NUM = (Object)session.getAttribute("SESSION_NO");
        commandMap.remove("MEMBER_NUM"); // 기존 회원번호 데이터 삭제
        commandMap.put("MEMBER_NUM", MEMBER_NUM); // 세션 값으로 적용
        List<Map<String,Object>> list = cartService.cartSelectList(commandMap, request); //선택한 장바구니번호의 상품
        Map<String,Object> map = orderService.orderMemberInfo(commandMap, request); //주문자정보
        mv.addObject("list", list);
        mv.addObject("map", map);
        System.out.println(list);
        System.out.println(map);
        return mv;
    }

    //상품 주문완료(결제)
    @RequestMapping(value="/order/orderPay.do")
    public ModelAndView orderPay(CommandMap commandMap, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("order/orderFinish");

        Object MEMBER_NUM = ""; //세션값 가져오기
        HttpSession session = request.getSession();
        MEMBER_NUM = (Object)session.getAttribute("SESSION_NO");
        commandMap.remove("MEMBER_NUM"); // 기존 회원번호 데이터 삭제
        commandMap.put("MEMBER_NUM", MEMBER_NUM); // 세션 값으로 적용
        orderService.insertOrder(commandMap, request);
        orderService.updateMember(commandMap, request);
        Map<String,Object> map = orderService.selectOrder(commandMap, request);
        mv.addObject("map", map);
        return mv;
    }

    //주문자 정보변경
    /*@RequestMapping(value="/order/orderModify.do")
    public ModelAndView orderModify(CommandMap commandMap, HttpServletRequest request) throws Exception {
        System.out.println(commandMap.get("ORDER_NUM"));

        ModelAndView mv = new ModelAndView("redirect:/my_detail.do");
        mv.addObject("order_NUM", commandMap.get("ORDER_NUM"));
        //수량수정
        orderService.orderModify(commandMap, request);
        return mv;
    }*/
}
