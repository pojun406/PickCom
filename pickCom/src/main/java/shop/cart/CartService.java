package shop.cart;

import common.CommandMap;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface CartService {
    // 장바구니 리스트 출력
    public List<Map<String, Object>> cartList(CommandMap commandMap) throws Exception;

    // 장바구니 수량 변경
    public void cartModify(CommandMap commandMap, HttpServletRequest request) throws Exception;

    // 장바구니 상품 삭제
    public void cartDelete(CommandMap commandMap, HttpServletRequest request) throws Exception;

    // 장바구니 초기화
    public void cartClear(CommandMap commandMap, HttpServletRequest request) throws Exception;

    // 장바구니에서 선택상품 주문시
    List<Map<String, Object>> cartSelectList(CommandMap commandMap, HttpServletRequest request) throws Exception;
}
